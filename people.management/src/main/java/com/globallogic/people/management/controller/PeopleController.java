package com.globallogic.people.management.controller;

import com.globallogic.people.management.entity.Person;
import com.globallogic.people.management.service.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/people")
public class PeopleController {

    @Autowired
    private PeopleService peopleService;

    @GetMapping(value = "/getPerson/{id}")
    public Person getPerson(@PathVariable Long id){
        return peopleService.getPerson(id);
    }

    @PostMapping(value = "/addPerson")
    public Person addPerson(@RequestBody Person person){
        return peopleService.addPerson(person);
    }
}
