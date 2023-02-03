package com.example.oembed.handler;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class JsonHandler {
    private final WebClient webClient;
    private final String youtubeApi = "https://www.youtube.com/oembed?url=";
    private final String vimeoApi = "https://vimeo.com/api/oembed.json?url=";
    private final String twitterApi = "https://publish.twitter.com/oembed?url=";
//    private final String instagramApi = "https://api.instagram.com/oembed?url=";


    public Mono<String> youtubeHandler(String url) {
        Mono<String> result = webClient.get()
                .uri(youtubeApi + url)
                .retrieve()
                .bodyToMono(String.class);

        return result;
    }

    public Mono<String> twitterHandler(String url) {
        Mono<String> result = webClient.get()
                .uri(twitterApi + url)
                .retrieve()
                .bodyToMono(String.class);

        return result;
    }

    public Mono<String> vimeoHandler(String url) {
        Mono<String> result = webClient.get()
                .uri(vimeoApi + url)
                .retrieve()
                .bodyToMono(String.class);

        return result;
    }

    /**
     * instagram은 엑세스 토큰이 필요해서 구현 불가능
     */
//    public Mono<String> instagramHandler(String url) {
//        Mono<String> result = webClient.get()
//                .uri(instagramApi + url)
//                .retrieve()
//                .bodyToMono(String.class);
//
//        return result;
//    }
}
