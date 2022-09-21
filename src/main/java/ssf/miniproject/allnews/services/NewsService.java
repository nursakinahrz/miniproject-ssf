package ssf.miniproject.allnews.services;

import java.io.Reader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import jakarta.json.JsonValue;

import ssf.miniproject.allnews.models.News;


@Service
public class NewsService {

    private final String NEWS_URL = "https://newsapi.org/v2/everything";

    @Value("${API_KEY}")
    private String apiKey;

    public List<News> getNewsList(String q) { 
        //removed String query
        //String apiKey = System.getenv("API_KEY");

        String url = UriComponentsBuilder.fromUriString(NEWS_URL)
        .queryParam("q", q)
        .toUriString();

        RestTemplate template = new RestTemplate();
        ResponseEntity<String> resp = null;
        List<News> list = new LinkedList<>();

       
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("x-api-key", apiKey);
            //headers.set("X-RapidAPI-Host", "tasty.p.rapidapi.com");
            HttpEntity request = new HttpEntity<>(headers);

            resp = template.exchange(url, HttpMethod.GET, request, String.class,1);


            // RequestEntity<Void> req = RequestEntity
            //     .get(url)
            //     .header("x-api-key", "apiKey %s".formatted(apiKey))
            //     .build();

            // ResponseEntity<String> resp = template.exchange(url, HttpMethod.GET, req, String.class);

            String payload = resp.getBody();
            // System.out.println(payload);

            Reader strReader = new StringReader(payload);
            // Create a JsonReader from Reader
            JsonReader jsonReader = Json.createReader(strReader);
            // Read the payload as Json object
            JsonObject jsonobject = jsonReader.readObject();
            JsonArray articles = jsonobject.getJsonArray("articles");

            for (int i = 0; i < articles.size(); i++) {
                
                JsonObject jo =  articles.getJsonObject(i);
                // name, id, thumbnail_url, video_url, yields
                // JsonArray resultsJo = recipes.getJsonArray("results");
                //JsonObject user_ratings = recipes.getJsonObject("user_ratings");
                // count_positive, score, count_negative
                list.add(News.create(jo));

                // for (int k = 0; k < resultsJo.size(); k++) {
                //     JsonObject jo = resultsJo.getJsonObject(k);
                // }
            }
            System.out.println(">>>>>> list from svc: " + list);
            return list;

        } catch (Exception ex) {
            System.err.printf("Error: %s\n", ex.getMessage());
            ex.printStackTrace();

            // final List <Recipes> recipeList = new LinkedList<>();
            // try (StringReader strReader = new StringReader(resp.getBody())) {
            //     JsonReader r = Json.createReader(strReader);
            //             JsonObject j = r.readObject();
            // 			for (JsonValue v: j.getJsonArray("results"))
            // 				recipeList.add(Recipes.create((JsonObject)v));
            // 	}

            return list;
        }
    }


}

    