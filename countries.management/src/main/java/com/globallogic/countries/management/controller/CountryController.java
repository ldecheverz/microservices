package com.globallogic.countries.management.controller;

import com.globallogic.countries.management.entity.Country;
import com.globallogic.countries.management.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping(value = "/countries")
    public List<Country> retrieveAllCountries(){
        return countryService.getCountries();
    }
}
