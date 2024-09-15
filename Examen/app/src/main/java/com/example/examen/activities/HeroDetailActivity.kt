package com.example.examen.activities;

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.example.examen.R

class HeroDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hero_detail)

        // Obtener los datos del héroe desde el Intent
        val heroName = intent.getStringExtra("heroName")
        val heroImageUrl = intent.getStringExtra("heroImageUrl")
        val heroPublisherId = intent.getIntExtra("heroPublisherId", -1)
        val heroType = intent.getStringExtra("heroType")

        // Mostrar los datos en la vista
        val heroNameTextView = findViewById<TextView>(R.id.heroDetailName)
        val heroTypeTextView = findViewById<TextView>(R.id.heroDetailType)
        val heroPublisherTextView = findViewById<TextView>(R.id.heroDetailPublisher)
        val heroImageView = findViewById<ImageView>(R.id.heroDetailImage)

        heroNameTextView.text = heroName
        heroTypeTextView.text = "Type: $heroType"
        heroPublisherTextView.text = "Publisher ID: $heroPublisherId"

        // Cargar la imagen usando Picasso
        Picasso.get().load(heroImageUrl).into(heroImageView)

        // Configurar el botón de "Volver"
        val backButton = findViewById<Button>(R.id.backButton)
        backButton.setOnClickListener {
            finish()  // Cierra esta actividad y vuelve a la anterior
        }
    }
}