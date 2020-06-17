package com.globallogic.people.management.proxy;


import com.globallogic.people.management.model.Country;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name="countries-management",url="${countries.url}",decode404 = true)
public interface CountryClientProxy {

    @GetMapping(value = "/countries")
    List<Country> retrieveAllCountries();

}