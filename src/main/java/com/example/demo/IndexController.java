package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
public class IndexController{

    private final UserRepository visitRepository;

    public IndexController(UserRepository visitRepository){
        this.visitRepository = visitRepository;
    }

    @GetMapping("/")
    public ModelAndView index(){
        Map<String, String> model = new HashMap<>();
        model.put("name", "Dev");

        User visit = new User();
        visit.description = String.format("Visited at %s", LocalDateTime.now());
        visitRepository.save(visit);

        return new ModelAndView("index", model);
    }
}
