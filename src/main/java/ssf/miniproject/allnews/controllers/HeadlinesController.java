package ssf.miniproject.allnews.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ssf.miniproject.allnews.models.TopNews;
import ssf.miniproject.allnews.services.TopNewsService;

@Controller
public class HeadlinesController {

    @Autowired
    private TopNewsService topnewsSvc;
    
    ///Get All News
    @GetMapping(path = "/index")
    public String getNews (HttpSession session, Model model, @RequestParam String country) {

        List<TopNews> topNews = topnewsSvc.getNewsList(country);

        // if(opt.isEmpty()) {
        session.setAttribute("country", country);
        
        
        System.out.println(">>>>>>" + topNews.toString());

        String name = (String) session.getAttribute("name");
        session.setAttribute("name", name);
        model.addAttribute("country", country);
        model.addAttribute("name", name);
        model.addAttribute("topNews", topNews);

        return "index";  
    }
}