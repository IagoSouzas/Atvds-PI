package com.example.apiStarWars.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/hp")
@CrossOrigin("*")
public class HarryPotter {

    @GetMapping("/magias")
    public ResponseEntity<String> magiasHarryPotter() {
        RestTemplate template = new RestTemplate();
        String url = "https://hp-api.onrender.com/api/spells";
        String resposta = template.getForObject(url, String.class);
        return ResponseEntity.ok(resposta);
    }

}
