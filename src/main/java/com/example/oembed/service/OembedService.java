package com.example.oembed.service;

import com.example.oembed.handler.JsonHandler;
import com.example.oembed.handler.UrlHandler;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


@Service
@RequiredArgsConstructor
public class OembedService {
    Logger log = LoggerFactory.getLogger(OembedService.class);

    private final JsonHandler jsonHandler;
    private final UrlHandler urlHandler;

    public Mono<String> call(String url) {
        final String youtube = "youtube.com";
//        final String instagram = "instagram.com";
        final String twitter = "twitter.com";
        final String vimeo = "vimeo.com";

        try{
            if(urlHandler.isValidUrl(url)){
                if(url.contains(youtube)){
                    return jsonHandler.youtubeHandler(url);
                }
                else if(url.contains(twitter)){
                    return jsonHandler.twitterHandler(url);
                }
//            else if(url.contains(instagram)){
//                return jsonHandler.instagramHandler(url);
//            }
                else if(url.contains(vimeo)){
                    return jsonHandler.vimeoHandler(url);
                } else{
                    log.info("지원하지 않는 서비스");
                    return null;
                }
            } else{
                return null;
            }
        } catch(NullPointerException e){
            log.info(String.valueOf(e));
        }

        return null;
    }
}
