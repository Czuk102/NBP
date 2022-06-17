package com.example.nbp.controllers;


import com.example.nbp.models.Root;
import com.example.nbp.services.NbpService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class NbpController {

    private final NbpService nbpService;

    public NbpController(NbpService nbpService) {
        this.nbpService = nbpService;
    }

    @GetMapping("/currency/{code}")
    public ResponseEntity<Root> getCurrency(@PathVariable("code") String code,
                                            @RequestParam(required=false,defaultValue="1") Integer topCount){
        return ResponseEntity.ok(nbpService.getCurrency(code,topCount ));
    }
}
