package modelo

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class Usuario(
    @SerializedName("login")
    val Login: String? = null,

    @SerializedName("nombre")
    val Nombre: String? = null,

    @SerializedName("pwd")
    val Pwd: String? = null
)