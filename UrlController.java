package com.project.urlshortener.controller;

import com.project.urlshortener.dto.UrlRequest;
import com.project.urlshortener.service.UrlService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class UrlController {

    private final UrlService service;

    public UrlController(UrlService service) {
        this.service = service;
    }

    @PostMapping("/shorten")
    public String shorten(@RequestBody UrlRequest request) {
        return service.shortenUrl(request.getOriginalUrl());
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> redirect(@PathVariable String code) {
        String original = service.getOriginalUrl(code);

        return ResponseEntity.status(302)
                .header(HttpHeaders.LOCATION, original)
                .build();
    }

    @GetMapping("/analytics/{code}")
    public String analytics(@PathVariable String code) {
        return "Clicks: " + service.getClicks(code);
    }
}
