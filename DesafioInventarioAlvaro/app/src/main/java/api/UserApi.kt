package api

import modelo.Rol
import modelo.Usuario
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface UserApi {
    @GET("listado")
    fun getUsuarios(): Call<MutableList<Usuario>>

    @GET("listado/{id}")
    fun getUnUsuario(@Path("id") id:String): Call<Usuario>

    @Headers("Content-Type:application/json")
    @POST("registrar")
    fun addUsuario(@Body info: Usuario) : Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @POST("login")
    fun loginUsuario(@Body info: Usuario) : Call<MutableList<Rol>>

    @DELETE("borrar/{dni}")
    fun borrarUsuario(@Path("dni") id:String) : Call<ResponseBody>

    @Headers("Content-Type:application/json")
    @PUT("modificar")
    fun modUsuario(@Body info: Usuario) : Call<ResponseBody>
}
