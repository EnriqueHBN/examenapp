package com.example.examen.activities
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.examen.Models.Hero
import com.example.examen.R
import com.example.loginapp.HeroAdapter

class HeroesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_heroes)

        val allHeroesAndVillains = listOf(
            // Héroes de DC
            Hero("https://media.revistagq.com/photos/65b259b97894af5e6b420593/16:9/w_1920,c_limit/supergirl-james-gunn.jpeg", "Supergirl", 2, "Hero"),
            Hero("https://static.wikia.nocookie.net/dcmovies/images/5/59/Zatanna_%28DCAMU%29_profile.jpg/revision/latest?cb=20240123003126", "Zatanna", 2, "Hero"),
            Hero("https://static.wikia.nocookie.net/dcanimated/images/f/f2/Hawkgirl.png/revision/latest?cb=20180707194732", "HawkGirl", 2, "Hero"),
            Hero("https://static.wikia.nocookie.net/mujer-maravilla/images/3/38/Wonder_Woman_2009.jpg/revision/latest?cb=20150202152955&path-prefix=es", "Wonder woman", 2, "Hero"),
            Hero("https://static.wikia.nocookie.net/characterprofile/images/b/b7/Bumblebee_%28DC_Comics%29_render.jpg/revision/latest?cb=20240103093806", "Bumblebee", 2, "Hero"),

            // Villanos de DC
            Hero("https://static.wikia.nocookie.net/harleyquinntv/images/6/64/Posion_Ivy.jpg/revision/latest?cb=20191230181034", "Poison Ivy", 2, "Villain"),
            Hero("https://www.elcalce.com/resizer/v2/3S3RUY2EURDP7GLEQZHUJNHISU.jpg?auth=8d0936666cf790d739f2a6d79a924f32c0281a1595474c244d23993bf3176b2b&width=1200&height=900&smart=truev", "Harley Quinn", 2, "Villain"),
            Hero("http://oyster.ignimgs.com/wordpress/stg.ign.com/2018/03/5359391-cheetahjusticeleaguedoom-720x405.png", "Cheetah", 2, "Villain"),
            Hero("hhttps://static.wikia.nocookie.net/harleyquinntv/images/c/c6/Killer_Frost.png/revision/latest?cb=20200724114932", "Killer Frost", 2, "Villain"),
            Hero("https://static.dc.com/dc/files/default_images/Char_Profile_Katana_5c4a5fe3bf45e1.63501303.jpg", "Katana", 2, "Villain"),

            // Héroes de Marvel
            Hero("https://i.pinimg.com/564x/68/de/67/68de67d0e7e29749470a3e66d9e20248.jpg", "Doctor Strange", 1, "Hero"),
            Hero("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSK6ABCceifEhQewrt7AxOD7Bn-PoLjRepxKQ&s", "Ant-Man", 1, "Hero"),
            Hero("https://upload.wikimedia.org/wikipedia/en/2/2e/TheFalcon.jpg", "Falcon", 1, "Hero"),
            Hero("https://i.pinimg.com/originals/df/f1/dd/dff1ddc600819e5f1aa8e95a788d5584.jpg", "Thor", 1, "Hero"),
            Hero("https://i.ytimg.com/vi/VdN0TWU9q2Y/hq720.jpg?sqp=-oaymwEhCK4FEIIDSFryq4qpAxMIARUAAAAAGAElAADIQj0AgKJD&rs=AOn4CLBsTYayIYkxuE9XyaqXCdkPY72Q5A", "Spider-Man", 1, "Hero"),



            // Villanos de Marvel
            Hero("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT5vX8oIyzEsuFa83nOn2vIpZXg_ZRf03IpcA&s", "DR Doom", 1, "Villain"),
            Hero("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRRtTtDIhPSwGJTm1mZo_zpeMT5YD3dpvdYdw&s", "Magneto", 1, "Villain"),
            Hero("https://static.wikia.nocookie.net/comicadventures/images/b/bd/Kingpin.jpg/revision/latest?cb=20111016024629l", "King Pin", 1, "Villain"),
            Hero("https://i.pinimg.com/originals/56/de/f4/56def43093b5a2febc0e88bb12e3ea3d.jpg", "Venom", 1, "Villain"),
            Hero("https://static.tvtropes.org/pmwiki/pub/images/red_skull_cover_9486.jpg", "RedSkull", 1, "Villain"),
        )

        // Configurar las listas
        setupRecyclerView(findViewById(R.id.dc_heroes_list), allHeroesAndVillains.filter { hero ->
            hero.PublisherId == 2 && hero.type == "Hero"
        })
        setupRecyclerView(findViewById(R.id.dc_villains_list), allHeroesAndVillains.filter { villain ->
            villain.PublisherId == 2 && villain.type == "Villain"
        })
        setupRecyclerView(findViewById(R.id.marvel_heroes_list), allHeroesAndVillains.filter { hero ->
            hero.PublisherId == 1 && hero.type == "Hero"
        })
        setupRecyclerView(findViewById(R.id.marvel_villains_list), allHeroesAndVillains.filter { villain ->
            villain.PublisherId == 1 && villain.type == "Villain"
        })
    }

    private fun setupRecyclerView(recyclerView: RecyclerView, data: List<Hero>) {
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)

        recyclerView.adapter = HeroAdapter(data) { hero ->
            // Navegar a HeroDetailActivity con los datos del héroe
            val intent = Intent(this, HeroDetailActivity::class.java).apply {
                putExtra("heroName", hero.name)
                putExtra("heroImageUrl", hero.imageUrl)
                putExtra("heroPublisherId", hero.PublisherId)
                putExtra("heroType", hero.type)
            }
            startActivity(intent)
        }
    }
}
