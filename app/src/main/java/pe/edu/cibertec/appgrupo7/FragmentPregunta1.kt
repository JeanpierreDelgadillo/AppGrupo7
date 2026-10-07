package pe.edu.cibertec.appgrupo7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import pe.edu.cibertec.appgrupo7.databinding.FragmentPregunta1Binding

class FragmentPregunta1 : Fragment(), View.OnClickListener {
    private lateinit var binding: FragmentPregunta1Binding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPregunta1Binding.inflate(inflater, container, false)
        binding.btnCalcular.setOnClickListener(this)
        return binding.root
    }
    override fun onClick(view: View?) {

        if (view?.id == R.id.btnCalcular) {
            calcularConsumo()
        }
    }
    private fun calcularConsumo() {
        val texto = binding.etConsumo.text.toString().trim()
        if (texto.isBlank()) {
            Toast.makeText(
                requireContext(),
                "Ingrese el consumo",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        val consumo = texto.toDoubleOrNull()
        if (consumo == null) {
            Toast.makeText(
                requireContext(),
                "Ingrese un número válido",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        if (consumo < 0) {
            Toast.makeText(
                requireContext(),
                "El consumo no puede ser negativo",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        if (consumo <= 20) {
            binding.tvResultado.text =
                "Consumo dentro de la asignación regular."

        } else {
            val exceso = consumo - 20
            val recargo = 45.0 + exceso * 8.50
            binding.tvResultado.text =
                "Volumen consumido: %.2f m³\n".format(consumo) +
                        "Exceso: %.2f m³\n".format(exceso) +
                        "Monto total del recargo: S/ %.2f".format(recargo)
        }
    }
}