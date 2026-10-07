package pe.edu.cibertec.appgrupo7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import pe.edu.cibertec.appgrupo7.databinding.ItemObrasBinding
import pe.edu.cibertec.appgrupo7.model.Obras

class ObraAdapter(private var listaObras: List<Obras>)
    :RecyclerView.Adapter<ObraAdapter.ViewHolder>() {

    inner class ViewHolder(val binding : ItemObrasBinding)
        : RecyclerView.ViewHolder(binding.root)


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ObraAdapter.ViewHolder {
        val binding = ItemObrasBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ObraAdapter.ViewHolder, position: Int) {
        with(holder){
            with(listaObras[position]){
                binding.tvtittle.text = title
                binding.tvauthor.text = author
                binding.tvgender.text = gender
                Glide.with(itemView.context)
                    .load(image)
                    .into(binding.ivimage)
            }
        }
    }

    override fun getItemCount() = listaObras.size

}