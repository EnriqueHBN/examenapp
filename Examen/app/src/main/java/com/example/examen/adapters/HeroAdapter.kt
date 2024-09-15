package com.example.loginapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.Models.Hero
import com.example.examen.R
import com.squareup.picasso.Picasso

class HeroAdapter(
    private val heroList: List<Hero>,
    private val onItemClick: (Hero) -> Unit  // Función lambda para manejar clics
) : RecyclerView.Adapter<HeroAdapter.HeroViewHolder>() {

    class HeroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val heroImage: ImageView = view.findViewById(R.id.hero_image)
        val heroName: TextView = view.findViewById(R.id.hero_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeroViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.hero_item, parent, false)
        return HeroViewHolder(view)
    }

    override fun onBindViewHolder(holder: HeroViewHolder, position: Int) {
        val hero = heroList[position]
        holder.heroName.text = hero.name
        Picasso.get().load(hero.imageUrl).into(holder.heroImage)

        // Configura el clic en cada héroe
        holder.itemView.setOnClickListener {
            onItemClick(hero)  // Llama al callback con el héroe seleccionado
        }
    }

    override fun getItemCount(): Int = heroList.size
}

