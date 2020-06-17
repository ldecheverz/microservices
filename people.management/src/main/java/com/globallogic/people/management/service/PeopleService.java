package com.globallogic.people.management.service;

import com.globallogic.people.management.clients.CountryClients;
import com.globallogic.people.management.entity.Person;
import com.globallogic.people.management.exception.PersonNotFoundException;
import com.globallogic.people.management.model.Country;
import com.globallogic.people.management.repository.PersonRepository;
import javassist.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {

    @Autowired
    private CountryClients countryClients;

    @Value("${management.version}")
    private String version;

    private Logger logger = LoggerFactory.getLogger(PeopleService.class);

    @Autowired
    private PersonRepository personRepository;

    /**
     * Return an specific persons.
     * @param id
     * @return
     */
    public Person getPerson(Long id){
        Optional<Person> person = personRepository.findById(id);
        if(!person.isPresent()){
            throw new PersonNotFoundException("id-" + id);
        }
        return person.get();
    }

    /**
     * Store a new person in the database.
     * @param person
     * @return
     */
    public Person addPerson(Person person){
        logger.info(String.format("Service Version: %s", version));
        Optional<List<Country>> countries = Optional.ofNullable(countryClients.getCountries());
        if(countries.isPresent()) {
            countries.get().stream().forEach(System.out::println);
            return personRepository.save(person);
        } else {
            throw new PersonNotFoundException("No se pudo obtener los países.");
        }
    }
}
