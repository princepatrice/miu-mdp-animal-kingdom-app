package com.example.animalkingdom.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.animalkingdom.data.model.Animal

// Create DAO for each entity, we have one entity. create one AnimalDao
// Provide the functionality expects from the DB
// suspend keyword is used in all the functions to run DB queries under Kotlin Coroutine scope
@Dao
interface AnimalDao {
    @Insert
    suspend fun addAnimal(animal: Animal)
    @Query("SELECT * FROM animals ORDER BY id DESC")
    fun getAllAnimals():LiveData<List<Animal>>
    @Insert
    suspend fun addMultipleAnimals(vararg animal: Animal)
    @Update
    suspend fun updateAnimal(eanimal:Animal)
    @Delete
    suspend fun deleteAnimal(animal: Animal)
}