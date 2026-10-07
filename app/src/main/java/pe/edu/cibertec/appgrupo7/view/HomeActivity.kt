package pe.edu.cibertec.appgrupo7.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import pe.edu.cibertec.appgrupo7.FragmentPregunta1
import pe.edu.cibertec.appgrupo7.FragmentPregunta2
import pe.edu.cibertec.appgrupo7.FragmentPregunta3
import pe.edu.cibertec.appgrupo7.FragmentPregunta4
import pe.edu.cibertec.appgrupo7.R
import pe.edu.cibertec.appgrupo7.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigation =
            findViewById<BottomNavigationView>(R.id.bottomNavigation)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, FragmentPregunta1())
            .commit()

        bottomNavigation.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_p1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, FragmentPregunta1())
                        .commit()
                    true
                }
                R.id.nav_p2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, FragmentPregunta2())
                        .commit()
                    true
                }
                R.id.nav_p3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, FragmentPregunta3())
                        .commit()
                    true
                }
                R.id.nav_p4 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragmentContainer, FragmentPregunta4())
                        .commit()
                    true
                }
                else -> false
            }
        }
    }
}