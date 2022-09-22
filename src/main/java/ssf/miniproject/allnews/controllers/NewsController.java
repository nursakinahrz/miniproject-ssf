package ssf.miniproject.allnews.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.miniproject.allnews.models.News;
import ssf.miniproject.allnews.services.NewsService;

@RequestMapping
@Controller
public class NewsController {
    
    @Autowired
    private NewsService newsSvc;

    // @Autowired
    // private UserService userSvc;


    // //User registration
    // @PostMapping(path = "/registration")
    // public String postUser(@RequestBody MultiValueMap<String, String> form, HttpSession session, Model model) {

    //     String name = form.getFirst("name");
    //     String email = form.getFirst("email");
    //     String password = form.getFirst("password");

    //     User newUser = User.create(name, email, password);

    //     userSvc.save(newUser);
    //     System.out.println("user saved");

    //     session.setAttribute("name", name);
    //     model.addAttribute("name", name);

    //     return "search";
        
    // }


    //Get All News
    @GetMapping(path = "/newslist")
    //removed httpsession for a while
    public String getNews (HttpSession session, Model model, @RequestParam String q) {

        List<News> allNews = newsSvc.getNewsList(q);

        // if(opt.isEmpty()) {
        session.setAttribute("articles", q);
        //     model.addAttribute("query", query.toUpperCase());
        //     //model.addAttribute("recipe", recipe);
        
        //     return "recipes";
        // }
        System.out.println(">>>>>>" + allNews.toString());

        //kiv below
        String name = (String) session.getAttribute("name");
       // session.setAttribute("name", name);
        //model.addAttribute("articles", q);
        //model.addAttribute("name", name);
        // model.addAttribute("size", size);
        model.addAttribute("allNews", allNews);

        return "newslist";  
    }
    

}




