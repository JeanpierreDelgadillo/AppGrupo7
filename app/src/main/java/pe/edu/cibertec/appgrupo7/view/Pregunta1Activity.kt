package pe.edu.cibertec.appgrupo7.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo7.R
import pe.edu.cibertec.appgrupo7.databinding.ActivityPregunta1Binding
import pe.edu.cibertec.appgrupo7.model.Usuario

class Pregunta1Activity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityPregunta1Binding

    // Fuente de datos simulada: código de alumno = usuario, DNI = contraseña
    private val listaUsuarios = listOf(
        Usuario("I202224196", "46342586"),
        Usuario("I202412622", "75679412"),
        Usuario("I202510240", "76466314"),
        Usuario("I202501629", "46473454"),
        Usuario("I202210176", "75265282"),
        Usuario("I202511882", "47849813"),
        Usuario("I202505493", "61143063")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta1Binding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnlogin.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        login(
            binding.etusuario.text.toString(),
            binding.etpassword.text.toString()
        )
    }

    private fun login(usuario: String, password: String) {
        if (usuario.isBlank() || password.isBlank()) {
            Toast.makeText(
                applicationContext,
                "Ingrese usuario y contraseña",
                Toast.LENGTH_LONG
            ).show()
            return
        }
        if (validarCredenciales(usuario, password)) {
            val intent = Intent(this, HomeActivity::class.java)
            Toast.makeText(applicationContext, "Login exitoso", Toast.LENGTH_LONG).show()
            startActivity(intent)
            finish()
        } else {
            Toast.makeText(
                applicationContext,
                "Usuario o contraseña incorrectos",
                Toast.LENGTH_LONG
            ).show()
        }
    }

    private fun validarCredenciales(usuario: String, password: String): Boolean {
        return listaUsuarios.any { it.usuario == usuario && it.password == password }
    }
}