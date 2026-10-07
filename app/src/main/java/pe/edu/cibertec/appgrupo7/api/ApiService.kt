package pe.edu.cibertec.appgrupo7.api

import pe.edu.cibertec.appgrupo7.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("user")
    fun getUsers(): Call<UserResponse>
}