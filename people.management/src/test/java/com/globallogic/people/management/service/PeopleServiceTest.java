package com.globallogic.people.management.service;

import com.globallogic.people.management.clients.CountryClients;
import com.globallogic.people.management.entity.Person;
import com.globallogic.people.management.model.Country;
import com.globallogic.people.management.repository.PersonRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PeopleServiceTest {

    private static final Long ID_PERSON = 1L;
    public static final Person PERSON = Person.builder().name("lucas").lastname("Echeverz").build();
    public static final List<Country> COUNTRIES = Arrays.asList(Country.builder().name("Argentina").continent("America").build(), Country.builder().name("United States").continent("America").build(),
            Country.builder().name("Spain").continent("Europe").build());

    @Mock
    private PersonRepository personRepository;

    @Mock
    private CountryClients countryClients;

    @InjectMocks
    private PeopleService peopleService;

    @Test
    public void getPersonShouldRunOk() {
        //given
        when(personRepository.findById(ID_PERSON)).thenReturn(Optional.of(PERSON));

        //method call
        Person foundPerson = peopleService.getPerson(ID_PERSON);

        //then
        assertEquals(PERSON.getName(),foundPerson.getName());
        assertEquals(PERSON.getLastname(),foundPerson.getLastname());
        verify(personRepository).findById(ID_PERSON);
    }

    @Test
    public void addPersonShouldRunOk() {
        //given
        when(personRepository.save(PERSON)).thenReturn(PERSON);
        when(countryClients.getCountries()).thenReturn(COUNTRIES);
        ArgumentCaptor<Long> captor = ArgumentCaptor.forClass(Long.class);
        //method call
        Person foundPerson = peopleService.addPerson(PERSON);

        //then
        assertEquals(PERSON.getName(),foundPerson.getName());
        assertEquals(PERSON.getLastname(),foundPerson.getLastname());
        verify(personRepository).save(PERSON);
//        verify(personRepository,times(1)).findById(captor.capture());
//        assertThat(captor.getValue()).matches(id -> id == 5L);
        verify(countryClients).getCountries();
    }
}