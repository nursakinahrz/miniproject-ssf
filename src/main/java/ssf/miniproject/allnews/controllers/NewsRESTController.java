package ssf.miniproject.allnews.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import ssf.miniproject.allnews.models.News;
import ssf.miniproject.allnews.services.UserService;


@RestController
@RequestMapping(path = "/newslist", produces = MediaType.APPLICATION_JSON_VALUE)
public class NewsRESTController {

    // @Autowired
	// private UserService articleSvc;

    // @GetMapping(value ="{author}")
	// public ResponseEntity<String> getArticle(@PathVariable String author) {
	// 	Optional<News> opt = articleSvc.get(author);
	// 	if (opt.isEmpty()) {

	// 		JsonObject payload = Json.createObjectBuilder()
	// 			.add("error", "Cannot find author %s".formatted(author))
	// 			.build();

	// 		return ResponseEntity.status(HttpStatus.NOT_FOUND)
	// 			.body(payload.toString());
	// 	}
	// 	News article = opt.get();
	// 	return ResponseEntity.ok(article.toJson().toString());
	// }

    
}




	

	
