package pe.edu.upeu.asistenciaupeujcn.data.remote

import pe.edu.upeu.asistenciaupeujcn.modelo.Asistenciax
import pe.edu.upeu.asistenciaupeujcn.modelo.AsistenciaxResp
import pe.edu.upeu.asistenciaupeujcn.modelo.MsgGeneric
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path
import retrofit2.http.Query

interface RestAsistenciax {
    @GET("/asis/asistenciax/list")
    suspend fun reportarAsistenciax(@Header("Authorization")
                                    token:String): Response<List<Asistenciax>>
    @GET("/asis/asistenciax/buscar/{id}")
    suspend fun getAsistenciaxId(@Header("Authorization") token:String,
                                 @Query("id") id:Long): Response<Asistenciax>
    @DELETE("/asis/asistenciax/eliminar/{id}")
    suspend fun deleteAsistenciax(@Header("Authorization") token:String,
                                  @Path("id") id:Long): Response<MsgGeneric>
    @PUT("/asis/asistenciax/editar/{id}")
    suspend fun actualizarAsistenciax(@Header("Authorization")
                                      token:String, @Path("id") id:Long, @Body asistenciax: Asistenciax
    ): Response<Asistenciax>
    @POST("/asis/asistenciax/crear")
    suspend fun insertarAsistenciax(@Header("Authorization")
                                    token:String,@Body asistenciax: Asistenciax
    ): Response<AsistenciaxResp>
}
