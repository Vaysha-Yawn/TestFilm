package test.film.domain.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable


data class FilmData (
    val id: Long,
    @SerializedName("localized_name")
    val localizedName: String?,
    val name: String?,
    val year: Long?,
    val rating: Double?,
    @SerializedName("image_url")
    val imageUrl: String?,
    val description: String?,
    val genres: List<String?>,
):Serializable{
    companion object{
        val exampleData  = FilmData(0L, "localizedName", "Название", 2017, 6.7, "", "description", listOf("Драма"))
    }
}