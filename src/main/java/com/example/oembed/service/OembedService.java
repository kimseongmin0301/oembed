package com.example.oembed.service;

import com.example.oembed.handler.JsonHandler;
import lombok.RequiredArgsConstructor;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.IOException;

@RequiredArgsConstructor
@Service
public class OembedService {

    Logger log = LoggerFactory.getLogger(OembedService.class);

    private final JsonHandler jsonHandler;

    /**
     * urlConnector
     * instagram은 엑세스 토큰이 필요하므로 구현 불가능
     * @param url
     * @return
     * @throws IOException
     */
    public String urlConnector(String url) throws IOException {
        final String youtube = "www.youtube.com";
//        final String instagram = "www.instagram.com";
        final String twitter = "twitter.com";
        final String vimeo = "vimeo.com";

        try{
            if(url.contains(youtube)) return youtubeHandler(url);
            else if(url.contains(twitter)) return twitterHandler(url);
//            else if(url.contains(instagram)) return instagramHandler(url);
            else if(url.contains(vimeo)) return vimeoHandler(url);
        } catch(NullPointerException | JSONException e){
            log.info(String.valueOf(e));
        }

        return null;
    }

    /**
     * youtube handler
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public String youtubeHandler(String url) throws IOException, JSONException {

        String top = "https://www.youtube.com/oembed?url=https%3A//youtube.com/watch%3Fv%3D";
        String mid = url.split("watch\\?v=")[1];
        String bottom = "&format=json";

        String data = getJsonObject(top + mid + bottom);

        return data;
    }

    /**
     * 구현 불가
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
//    public JSONObject instagramHandler(String url) throws IOException, JSONException {
//
//        return null;
//    }

    /**
     * twitterHandler
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public String twitterHandler(String url) throws IOException, JSONException {

        String top = "https://publish.twitter.com/oembed?url=https%3A//twitter.com/";
        String mid = url.split("twitter.com/")[1];
        String bottom = "&format=json";
        String data = getJsonObject(top + mid + bottom);

        return data;
    }

    /**
     * vimeoHandler
     * @param url
     * @return
     * @throws IOException
     * @throws JSONException
     */
    public String vimeoHandler(String url) throws IOException, JSONException {

        String top = "https://vimeo.com/api/oembed.json?url=";
        String mid = url;
        String data = getJsonObject(top + mid);

        return data;
    }

    private String getJsonObject(String data) throws IOException {
        String result = jsonHandler.getData(data);

        return result;
    }
}
