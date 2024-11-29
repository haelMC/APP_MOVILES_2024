package pe.edu.upeu.navegacionjpc.api

import pe.edu.upeu.navegacionjpc.model.User
import retrofit2.Call
import retrofit2.http.GET


interface ApiService {
    @GET("users")
    fun getUsers(): Call<List<User>>

}