package com.example.oembed.handler;

import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.UrlValidator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UrlHandler {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    private final UrlValidator urlValidator;

    public boolean isValidUrl(String url) {
        if(!urlValidator.isValid(url)) {
            log.error("유효하지 않은 URL : {}" , url);
            return false;
        } else{
            log.info("유효한 URL {}", url);
            return true;
        }
    }
}
