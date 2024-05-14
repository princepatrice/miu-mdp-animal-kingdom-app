package com.example.animalkingdom.ui.speciesdetails

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.animalkingdom.data.database.AppDatabase
import com.example.animalkingdom.data.model.Specie
import com.example.animalkingdom.data.repository.SpecieRepository
import kotlinx.coroutines.launch

class SpeciesDetailsViewModel(application: Application) : AndroidViewModel(application) {
    private val repository: SpecieRepository
    val allSpecies: LiveData<List<Specie>>

    init {
        val specieDao = AppDatabase(application.applicationContext).getSpecieDao()
        repository = SpecieRepository(specieDao)
        allSpecies = repository.allSpecies
    }

    fun insert(specie: Specie) = viewModelScope.launch {
        repository.insert(specie)
    }
}
