package com.example.animalkingdom.data.repository

import androidx.lifecycle.LiveData
import com.example.animalkingdom.data.dao.AnimalDao
import com.example.animalkingdom.data.model.Animal

class AnimalRepository(private val animalDao: AnimalDao) {
    val allAnimals: LiveData<List<Animal>> = animalDao.getAllAnimals()

    suspend fun insert(animal: Animal) {
        animalDao.addAnimal(animal)
    }
}
