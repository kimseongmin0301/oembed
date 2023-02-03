package com.example.oembed.controller;

import com.example.oembed.service.OembedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
public class OembedController {

    private final OembedService oembedService;

    @GetMapping(value="/search", produces = "application/json")
    public ResponseEntity<Mono<String>> search(@RequestParam String url) {

        return ResponseEntity.ok(oembedService.call(url));
    }
}
