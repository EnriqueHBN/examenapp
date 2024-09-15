package com.example.examen.Models

import android.media.Image

data class Publisher(val id : Int, val name : String, val image : String){
    companion object{
        val publisherList = listOf(
            Publisher(1,"Marvel", ""),
            Publisher(2,"DC", "")
        )
    }
}
