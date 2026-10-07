package pe.edu.cibertec.appgrupo7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo7.databinding.FragmentPregunta2Binding

class FragmentPregunta2 : Fragment(), View.OnClickListener  {

    private lateinit var binding: FragmentPregunta2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPregunta2Binding.inflate(inflater, container, false)
        binding.btnCalculo.setOnClickListener(this)
        return binding.root
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
