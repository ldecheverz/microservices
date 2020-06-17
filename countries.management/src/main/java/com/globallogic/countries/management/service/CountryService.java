package com.globallogic.countries.management.service;

import com.globallogic.countries.management.entity.Country;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class CountryService {

    public List<Country> getCountries(){
        return Arrays.asList(Country.builder().name("Argentina").continent("America").build(), Country.builder().name("United States").continent("America").build(),
                Country.builder().name("Spain").continent("Europe").build());
    }
}
