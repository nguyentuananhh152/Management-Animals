package com.example.managementanimals.controller;


import com.example.managementanimals.exception.NotFoundException;
import com.example.managementanimals.service.AnimalServiceImplement;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class API {
    @Autowired
    private AnimalServiceImplement animalServiceImplement;

    public API() {}

    @GetMapping("/")
    public String test(Model model) {

        return "home.html";
    }

    @GetMapping("/get/{id}")
    public String getAnimalById(Model model, @PathVariable("id") int id) {
//        model.addAttribute("animal", animalServiceImplement.findById(10));
//        return "profile.html";
        try {
            model.addAttribute("animal", animalServiceImplement.findById(id));
            return "profile.html";
        } catch (NotFoundException e) {
            model.addAttribute("notification", e.getMessage());
            return "notification.html";
        }
    }

}
