package com.globallogic.people.management.clients;

import com.globallogic.people.management.model.Country;
import com.globallogic.people.management.proxy.CountryClientProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class CountryClients {

    @Value("${countries.url}")
    private String countriesUrl;

    private RestTemplate restTemplate;

    @Autowired
    private CountryClientProxy countryClientProxy;

    @Autowired
    public CountryClients(RestTemplateBuilder builder) {
        this.restTemplate = builder.build();
    }

    public List<Country>  getCountries(){
        List<Country> countries = countryClientProxy.retrieveAllCountries();
        return countries;
    }


    /**
     * Method deprecated after feign beign incorporated.
     * @return
     */
    private List<Country> getCountriesNoFeign(){
        ResponseEntity<List<Country>> response = restTemplate.exchange(countriesUrl, HttpMethod.GET, null, new ParameterizedTypeReference<List<Country>>() {
        });
        List<Country> countries = response.getBody();
        return countries;
    }
}
