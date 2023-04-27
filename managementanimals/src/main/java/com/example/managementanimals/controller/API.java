package com.example.managementanimals.controller;


import com.example.managementanimals.entity.Animal;
import com.example.managementanimals.exception.NotFoundException;
import com.example.managementanimals.service.AnimalServiceImplement;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

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
        try {
            model.addAttribute("animal", animalServiceImplement.findById(id));
            return "profile.html";
        } catch (NotFoundException e) {
            model.addAttribute("notification", e.getMessage());
            return "notification.html";
        } catch (Exception e) {
            model.addAttribute("notification", e.getMessage());
            return "notification.html";
        }
    }

    @GetMapping("get-all-list")
    @ResponseBody
    public String getAllListAnimal(Model model) {
        try {
            model.addAttribute("listanimal", animalServiceImplement.findAll());
            return "list.html";
        } catch (Exception e) {
            model.addAttribute("notification", e.getMessage());
            return "notification.html";
        }
    }

    @PostMapping("save")
    public String saveAnimal(Model model, Animal animal) {
        try {
            animalServiceImplement.save(animal);
            model.addAttribute("notification", "Save Success!");
            return "notification.html";
        } catch (Exception e) {
            model.addAttribute("notification", e.getMessage());
            return "notification.html";
        }
    }

    @PutMapping("update")
    public String updateAnimal(Model model, int id, Animal animal) {
        try {
            animalServiceImplement.updateById(id, animal);
            model.addAttribute("notification", "Update Success!");
            return "notification.html";
        } catch (Exception e) {
            model.addAttribute("notification", e.getMessage());
            return "notification.html";
        }
    }

}
