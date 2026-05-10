package com.project.urlshortener.service;

import com.project.urlshortener.entity.UrlMapping;
import com.project.urlshortener.repository.UrlRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {

    private final UrlRepository repository;

    public UrlService(UrlRepository repository) {
        this.repository = repository;
    }

    public String shortenUrl(String originalUrl) {
        String code = generateCode();

        UrlMapping url = new UrlMapping();
        url.setOriginalUrl(originalUrl);
        url.setShortCode(code);

        repository.save(url);

        return "http://localhost:8080/" + code;
    }

    public String getOriginalUrl(String code) {
        UrlMapping url = repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("URL not found"));

        url.setClicks(url.getClicks() + 1);
        repository.save(url);

        return url.getOriginalUrl();
    }

    public Long getClicks(String code) {
        UrlMapping url = repository.findByShortCode(code)
                .orElseThrow(() -> new RuntimeException("Not found"));

        return url.getClicks();
    }

    private String generateCode() {
        String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(int i=0;i<6;i++) {
            sb.append(chars.charAt(random.nextInt(chars.length())));
        }

        return sb.toString();
    }
}
