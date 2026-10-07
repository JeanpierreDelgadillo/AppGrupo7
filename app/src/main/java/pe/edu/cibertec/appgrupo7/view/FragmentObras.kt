package pe.edu.cibertec.appgrupo7.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import pe.edu.cibertec.appgrupo7.adapter.ObraAdapter
import pe.edu.cibertec.appgrupo7.databinding.FragmentObrasBinding
import pe.edu.cibertec.appgrupo7.model.Obras

class FragmentObras : Fragment() {

    private var _binding: FragmentObrasBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentObrasBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.rvobra.layoutManager = LinearLayoutManager(requireContext())
        binding.rvobra.adapter = ObraAdapter(getObras())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun getObras(): List<Obras> {
        return listOf(
            // pega aquí las 20 líneas Obras(...) del archivo getObras.kt
        )
    }
}