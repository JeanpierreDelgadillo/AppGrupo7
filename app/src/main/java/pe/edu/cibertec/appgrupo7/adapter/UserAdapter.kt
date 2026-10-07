package pe.edu.cibertec.appgrupo7.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pe.edu.cibertec.appgrupo7.databinding.ItemUserBinding
import pe.edu.cibertec.appgrupo7.response.User

class UserAdapter(private val users: List<User>) :
    RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    class UserViewHolder(val binding: ItemUserBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val binding = ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(binding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val u = users[position]
        holder.binding.tvId.text = "ID: ${u.id}"
        holder.binding.tvName.text = "${u.firstName} ${u.lastName}"
        holder.binding.tvEmail.text = "Email: ${u.email}"
        holder.binding.tvPhone.text = "Tel: ${u.phone}"
    }

    override fun getItemCount(): Int = users.size
}