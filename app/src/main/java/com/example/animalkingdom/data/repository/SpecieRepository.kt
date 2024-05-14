package com.example.animalkingdom.data.repository

import androidx.lifecycle.LiveData
import com.example.animalkingdom.data.dao.SpecieDao
import com.example.animalkingdom.data.model.Specie

class SpecieRepository(private val specieDao: SpecieDao) {
    val allSpecies: LiveData<List<Specie>> = specieDao.getAllSpecies()

    suspend fun insert(specie: Specie) {
        specieDao.addSpecie(specie)
    }
}
