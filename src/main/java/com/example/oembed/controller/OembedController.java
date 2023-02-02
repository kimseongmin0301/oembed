package com.example.oembed.controller;


import com.example.oembed.service.OembedService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
public class OembedController {

    private final OembedService oembedService;

    @GetMapping(value="/search", produces = "application/json")
    public ResponseEntity<String> search(@RequestParam String url) throws IOException{

        return ResponseEntity.ok(oembedService.urlConnector(url));
    }
}
