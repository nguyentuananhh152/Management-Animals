package com.example.managementanimals.service;

import com.example.managementanimals.entity.Animal;
import com.example.managementanimals.exception.NotFoundException;
import com.example.managementanimals.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalServiceImplement implements AnimalService{
    @Autowired
    private AnimalRepo animalRepo;

    public AnimalServiceImplement() {}
    public void print(String string) {
        System.out.print(string);
    }
    @Override
    public void save(Animal animal) {
        try {
            animalRepo.save(animal);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    @Override
    public void saveAll(List<Animal> animalList) {
        try {
            animalRepo.saveAll(animalList);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    @Override
    public void updateById(int id) {        //-------------------

    }

    @Override
    public void deleteById(int id) {
        try {
            animalRepo.deleteById(id);
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    @Override
    public void deleteAll() {
        try {
            animalRepo.deleteAll();
        } catch (Exception e) {
            print(e.getMessage());
        }
    }

    @Override
    public long count() {
        return animalRepo.count();
    }

    @Override
    public boolean exist(int id) {
        return animalRepo.existsById(id);
    }

    @Override
    public Animal findById(int id) {
        if (exist(id)) {
            return animalRepo.findById(id).get();
        }
        throw new NotFoundException("Animal Not Found!!");
    }

    @Override
    public Animal findByKey(String key) {
        try {
            return new Animal();
//            return animalRepo.findBy();
        } catch (Exception e) {
            print(e.getMessage());
        }
        return new Animal();
    }

    @Override
    public List<Animal> findAll() {
        return null;
    }

    @Override
    public Animal findByNumber(int number) {
        return null;
    }

    @Override
    public List<Animal> findTheFirstNumber(int number) {
        return null;
    }
}
