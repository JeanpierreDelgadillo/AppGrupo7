package pe.edu.cibertec.appgrupo7

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import pe.edu.cibertec.appgrupo7.databinding.ActivityPregunta4Binding

class Pregunta4Activity : AppCompatActivity(), View.OnClickListener  {

    private lateinit var binding: ActivityPregunta4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityPregunta4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.btnCalculo.setOnClickListener(this)
    }
    override fun onClick(v: View?) {
        when (v?.id) {
            binding.btnCalculo.id -> calcularRecargo()
        }
    }
    private fun calcularRecargo() {

        val textoConsumo =
            binding.etconsumo.text.toString().trim()

        if (textoConsumo.isEmpty()) {
            binding.etconsumo.error = "Ingrese el consumo en kWh"
            return
        }

        val consumo = textoConsumo.toDoubleOrNull()

        if (consumo == null || consumo < 0) {
            binding.etconsumo.error = "Ingrese un consumo válido"
            return
        }

        binding.etconsumo.error = null

        val limite = 150.00

        if (consumo <= limite) {

            binding.textView3.text =
                "Consumo eficiente sin sobrecosto."

        } else {

            val exceso = consumo - limite

            val recargo = 60.00 + (exceso * 1.80)

            binding.textView3.text = """
            Consumo ingresado: ${String.format("%.2f", consumo)} kWh
            Exceso del límite: ${String.format("%.2f", exceso)} kWh
            Monto total a pagar por recargo: S/ ${String.format("%.2f", recargo)}
        """.trimIndent()
        }
    }



}
