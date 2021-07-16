package com.vladbudan.app.service;

import com.vladbudan.app.model.Pet;

import java.util.List;

public interface PetService {

    void addPet(Pet pet);
    void updatePet(Pet pet);
    Pet getPetById(Integer id);
    void deletePet(Integer id);
    List<Pet> getAllPets();
}
