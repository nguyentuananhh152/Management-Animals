package com.example.managementanimals.service;

import com.example.managementanimals.entity.Animal;
import com.example.managementanimals.exception.NotFoundException;
import com.example.managementanimals.repository.AnimalRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
            if (exist(animal.getId())) {
                updateById(animal.getId(), animal);
            } else {
                animalRepo.save(animal);
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void saveAll(List<Animal> animalList) {
        try {
            animalRepo.saveAll(animalList);
        } catch (Exception e) {
        }
    }

    @Override
    public void updateById(int id, Animal animal) {        //-------------------
        try {
            Animal animalUpdate = animalRepo.findById(id).get();
            animalUpdate.setName(animal.getName());
            animalUpdate.setImage(animal.getImage());
            animalUpdate.setDescription(animal.getDescription());
            animalUpdate.setSpecie(animal.getSpecie());
            animalRepo.save(animalUpdate);
        } catch (Exception e) {

        }
    }

    public Animal update(Animal animalOld, Animal animalNew) {
        animalOld = animalNew;
        return animalOld;
    }
    @Override
    public void deleteById(int id) {
        try {
            if (exist(id)) {
                animalRepo.deleteById(id);
            } else {
                throw new NotFoundException("Animal not found");
            }
        } catch (Exception e) {
        }
    }

    @Override
    public void deleteAll() {
        try {
            animalRepo.deleteAll();
        } catch (Exception e) {
        }
    }

    @Override
    public long count() {
        try {
            return animalRepo.count();
        } catch (Exception e) {
            return 0;
        }
    }

    @Override
    public boolean exist(int id) {
        try {
            return animalRepo.existsById(id);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Animal findById(int id) {
        if (exist(id)) {
            return animalRepo.findById(id).get();
        }
        throw new NotFoundException("Animal Not Found!!");
    }

    @Override
    public ArrayList<Animal> findByKey(String key) {
        ArrayList<Animal> listAnimal = new ArrayList<>();
        try {
            for (int i = 1; i <= animalRepo.count(); i++) {
                if (containKey(key, animalRepo.findById(i).get())) {
                    listAnimal.add(animalRepo.findById(i).get());
                }
            }
        } catch (Exception e) {
        } finally {
            return listAnimal;
        }

    }

    public boolean containKey(String string, Animal animal) {
        if (animal.getName().contains(string)) return true;
        if (animal.getDescription().contains(string)) return true;
        if (animal.getSpecie().contains(string)) return true;
        return false;
    }

    @Override
    public ArrayList<Animal> findAll() {
        ArrayList<Animal> arraylistAnimal = new ArrayList<>();
        try {
            for (int i = 1; i <= animalRepo.count(); i++) {
                arraylistAnimal.add(animalRepo.findById(i).get());
            }
        } catch (Exception e) {
        } finally {
            return arraylistAnimal;
        }
    }

    @Override
    public ArrayList<Animal> findListByNumber(int numberStart, int numberEnd) {
        ArrayList<Animal> listAnimal = new ArrayList<>();
        try {
            if (numberEnd > numberStart && numberStart > 0) {
                for (int i = numberStart; i <= numberEnd; i++) {
                    listAnimal.add(animalRepo.findById(i).get());
                }
            }
        } catch (Exception e) {
        } finally {
            return listAnimal;
        }
    }

    @Override
    public ArrayList<Animal> findTheFirstNumber(int number) {
        ArrayList<Animal> listAnimal = new ArrayList<>();
        try {
            if (number > 0) {
                for (int i = 1; i <= number; i++) {
                    listAnimal.add(animalRepo.findById(i).get());
                }
            }
        } catch (Exception e) {
        } finally {
            return listAnimal;
        }
    }
}
