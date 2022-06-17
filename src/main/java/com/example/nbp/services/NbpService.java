package com.example.nbp.services;


import com.example.nbp.models.Root;
import io.swagger.models.auth.In;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Slf4j
@Service
public class NbpService {
    private final RestTemplate restTemplate;

    private static final String NPB_URL = "http://api.nbp.pl/api/exchangerates/rates/";
    private static final String table = "a";

    public NbpService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;

    }

//    public Root getCurrency(double topCount,String code ){
//        Root response = restTemplate.getForObject(NPB_URL+table+"/{code}/last/{topCount}/",Root.class,code, topCount);
//        return response;
//    }
    public Root getCurrency(String code, Integer topCount){
        Root response = restTemplate.getForObject(NPB_URL+table+"/{code}/last/{topCount}/",Root.class,code,topCount);
        return response;
    }
}
