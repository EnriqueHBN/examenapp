package com.example.examen.Models

data class User(val name:String,val email:String,val password: String){
    val computedName :String get() = "Hola, $name"
    companion object{
        val users = listOf(
            User("Renata","renata12@hotmail.com","12345"),
            User("Enrique","enrique34@hotmail.com","12345"),
            User("Andrea","cristian56@hotmail.com","12345")
        )
    }
}