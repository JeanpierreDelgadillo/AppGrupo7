package pe.edu.cibertec.appgrupo7

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import pe.edu.cibertec.appgrupo7.adapter.UserAdapter
import pe.edu.cibertec.appgrupo7.response.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FragmentPregunta4 : Fragment() {

    private lateinit var rvUsers: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view = inflater.inflate(R.layout.fragment_pregunta4, container, false)

        rvUsers = view.findViewById(R.id.rvUsers)
        rvUsers.layoutManager = LinearLayoutManager(requireContext())

        getUsersData()

        return view
    }

    private fun getUsersData() {
        RetrofitClient.apiService.getUsers().enqueue(object : Callback<UserResponse> {
            override fun onResponse(call: Call<UserResponse>, response: Response<UserResponse>) {
                if (response.isSuccessful) {
                    val userList = response.body()?.users ?: emptyList()
                    rvUsers.adapter = UserAdapter(userList)
                } else {
                    Toast.makeText(context, "Error al obtener datos", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                Log.e("FragmentPregunta4", "Error: ${t.message}")
                Toast.makeText(context, "Error de conexión", Toast.LENGTH_SHORT).show()
            }
        })
    }
}