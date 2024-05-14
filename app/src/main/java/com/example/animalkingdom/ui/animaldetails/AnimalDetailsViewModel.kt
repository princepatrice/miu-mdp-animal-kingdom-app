package com.example.animalkingdom.ui.animalsdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalkingdom.data.database.AppDatabase
import com.example.animalkingdom.data.model.Animal
import com.example.animalkingdom.data.repository.AnimalRepository
import kotlinx.coroutines.launch

class AnimalsDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: AnimalRepository
    val allAnimals: LiveData<List<Animal>>

    init {
        val animalDao = AppDatabase(application.applicationContext).getAnimalDao()
        repository = AnimalRepository(animalDao)
        allAnimals = repository.allAnimals
    }

    fun insert(animal: Animal) = viewModelScope.launch {
        repository.insert(animal)
    }
}
