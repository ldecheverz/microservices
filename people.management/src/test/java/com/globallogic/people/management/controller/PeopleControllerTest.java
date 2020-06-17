package com.globallogic.people.management.controller;

import com.globallogic.people.management.entity.Person;
import com.globallogic.people.management.service.PeopleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class PeopleControllerTest {

    private static final Long ID_PERSON = 1L;
    public static final Person PERSON =Person.builder().name("lucas").lastname("Echeverz").build();

    @Mock
    private PeopleService peopleService;

    @InjectMocks
    private PeopleController peopleController;

    @Test
    public void getPersonShouldRunOk() {
        //before
        when(peopleService.getPerson(ID_PERSON)).thenReturn(PERSON);

        //method call
        Person foundPerson = peopleController.getPerson(ID_PERSON);

        //after
        assertEquals(PERSON.getName(),foundPerson.getName());
        assertEquals(PERSON.getLastname(),foundPerson.getLastname());
        verify(peopleService).getPerson(ID_PERSON);
    }

    @Test
    public void addPersonShouldRunOk() {
        //before
        when(peopleService.addPerson(PERSON)).thenReturn(PERSON);

        //method call
        Person foundPerson = peopleController.addPerson(PERSON);

        //after
        assertEquals(PERSON.getName(),foundPerson.getName());
        assertEquals(PERSON.getLastname(),foundPerson.getLastname());
        verify(peopleService).addPerson(PERSON);
    }
}