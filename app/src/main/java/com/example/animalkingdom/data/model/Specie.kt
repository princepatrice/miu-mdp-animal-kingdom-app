package com.example.animalkingdom.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "species")
data class Specie(
    var name:String,
    var description:String
): Serializable // need to pass Note entity through Fragments. So that entity should be Serializable
{
    @PrimaryKey(autoGenerate = true)
    var id:Int = 0
}
