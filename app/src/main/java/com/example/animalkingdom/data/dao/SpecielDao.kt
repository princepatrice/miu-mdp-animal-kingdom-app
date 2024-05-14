package com.example.animalkingdom.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.animalkingdom.data.model.Specie

// Create DAO for each entity, we have one entity. create one SpecieDao
// Provide the functionality expects from the DB
// suspend keyword is used in all the functions to run DB queries under Kotlin Coroutine scope
@Dao
interface SpecieDao {
    @Insert
    suspend fun addSpecie(specie: Specie)
    @Query("SELECT * FROM species ORDER BY id DESC")
    fun getAllSpecies(): LiveData<List<Specie>>
    @Insert
    suspend fun addMultipleSpecies(vararg specie: Specie)
    @Update
    suspend fun updateSpecie(especie:Specie)
    @Delete
    suspend fun deleteSpecie(specie: Specie)
}