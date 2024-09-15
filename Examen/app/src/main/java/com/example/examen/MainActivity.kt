package com.example.examen


import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.examen.Models.User
import com.example.examen.R
import com.example.examen.activities.HeroesActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Referenciar los elementos de la interfaz
        val usernameEditText = findViewById<EditText>(R.id.username)
        val passwordEditText = findViewById<EditText>(R.id.password)
        val loginButton = findViewById<Button>(R.id.login_button)

        // Establecer listener para el botón de login
        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            val isValidUser = User.users.any { user ->
                user.email == username && user.password == password
            }
//            var isValid = false
//
//            for (user in User.users){
//                if (user.email == username && user.password == password){
//                    //usuario loguiado
//                    isValid = true
//                }
//            }

// Verificar las credenciales
            if (isValidUser) {
                Toast.makeText(this, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()

                // Redirigir a la actividad HeroesActivity
                val intent = Intent(this, HeroesActivity::class.java)
                startActivity(intent)

                // Opcionalmente puedes finalizar la actividad actual si ya no quieres que esté en la pila
                finish()
            } else {
                Toast.makeText(this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
