package pe.edu.cibertec.appgrupo7

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo7.adapter.ObraAdapter
import pe.edu.cibertec.appgrupo7.databinding.FragmentObrasBinding
import pe.edu.cibertec.appgrupo7.model.Obras

class FragmentPregunta3 : Fragment() {

    private var _binding: FragmentObrasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentObrasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvobra.layoutManager = LinearLayoutManager(requireContext())
        binding.rvobra.adapter = ObraAdapter(getObras())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getObras(): List<Obras> {
        return listOf(
            Obras(1, "Los ríos profundos",
                "José María Arguedas", "Novela",
                "https://picsum.photos/seed/peru1/400/300"),
            Obras(2, "Todas las sangres",
                "José María Arguedas", "Novela",
                "https://picsum.photos/seed/peru2/400/300"),
            Obras(3, "Yawar fiesta",
                "José María Arguedas", "Novela",
                "https://picsum.photos/seed/peru3/400/300"),
            Obras(4, "La ciudad y los perros",
                "Mario Vargas Llosa", "Novela",
                "https://picsum.photos/seed/peru4/400/300"),
            Obras(5, "La casa verde",
                "Mario Vargas Llosa", "Novela",
                "https://picsum.photos/seed/peru5/400/300"),
            Obras(6, "Conversación en La Catedral",
                "Mario Vargas Llosa", "Novela",
                "https://picsum.photos/seed/peru6/400/300"),
            Obras(7, "Pantaleón y las visitadoras",
                "Mario Vargas Llosa", "Novela",
                "https://picsum.photos/seed/peru7/400/300"),
            Obras(8, "La tía Julia y el escribidor",
                "Mario Vargas Llosa", "Novela",
                "https://picsum.photos/seed/peru8/400/300"),
            Obras(9, "Un mundo para Julius",
                "Alfredo Bryce Echenique", "Novela",
                "https://picsum.photos/seed/peru9/400/300"),
            Obras(10, "Los heraldos negros",
                "César Vallejo", "Poesía",
                "https://picsum.photos/seed/peru10/400/300"),
            Obras(11, "Trilce",
                "César Vallejo", "Poesía",
                "https://picsum.photos/seed/peru11/400/300"),
            Obras(12, "El tungsteno",
                "César Vallejo", "Novela",
                "https://picsum.photos/seed/peru12/400/300"),
            Obras(13, "Poemas humanos",
                "César Vallejo", "Poesía",
                "https://picsum.photos/seed/peru13/400/300"),
            Obras(14, "Siete ensayos de interpretación de la realidad peruana",
                "José Carlos Mariátegui", "Ensayo",
                "https://picsum.photos/seed/peru14/400/300"),
            Obras(15, "El mundo es ancho y ajeno",
                "Ciro Alegría", "Novela",
                "https://picsum.photos/seed/peru15/400/300"),
            Obras(16, "La serpiente de oro",
                "Ciro Alegría", "Novela",
                "https://picsum.photos/seed/peru16/400/300"),
            Obras(17, "Los perros hambrientos",
                "Ciro Alegría", "Novela",
                "https://picsum.photos/seed/peru17/400/300"),
            Obras(18, "Redoble por Rancas",
                "Manuel Scorza", "Novela",
                "https://picsum.photos/seed/peru18/400/300"),
            Obras(19, "Cuentos andinos",
                "Enrique López Albújar", "Cuentos",
                "https://picsum.photos/seed/peru19/400/300"),
            Obras(20, "Los inocentes",
                "Oswaldo Reynoso", "Cuentos",
                "https://picsum.photos/seed/peru20/400/300")
        )
    }
}