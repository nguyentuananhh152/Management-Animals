package com.example.managementanimals.service;


import com.example.managementanimals.entity.Animal;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface AnimalService {
//    ---------------------- add, update, delete ----------
    public void save(Animal animal);
    public void saveAll(List<Animal> animalList);
    public void updateById(int id, Animal animal);
    public void deleteById(int id);
    public void deleteAll();
//    ---------------------------- count, check exist -------------
    public long count();
    public boolean exist(int id);
//    ---------------------------- find ---------------
    public Animal findById(int id);
    public ArrayList<Animal> findByKey(String key);
    public ArrayList<Animal> findAll();
    public ArrayList<Animal> findListByNumber(int numberStart, int numberEnd);
    public ArrayList<Animal> findTheFirstNumber (int number);


}
