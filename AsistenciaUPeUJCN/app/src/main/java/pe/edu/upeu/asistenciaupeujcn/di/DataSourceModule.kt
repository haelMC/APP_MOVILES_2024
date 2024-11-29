package pe.edu.upeu.asistenciaupeujcn.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import pe.edu.upeu.asistenciaupeujcn.data.local.DbDataSource
import pe.edu.upeu.asistenciaupeujcn.data.local.dao.ActividadDao
import pe.edu.upeu.asistenciaupeujcn.data.remote.RestActividad
import pe.edu.upeu.asistenciaupeujcn.data.remote.RestAsistenciax
import pe.edu.upeu.asistenciaupeujcn.data.remote.RestUsuario
import pe.edu.upeu.asistenciaupeujcn.utils.TokenUtils
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DataSourceModule {
    var retrofit: Retrofit?=null
    @Singleton
    @Provides
    @Named("BaseUrl")
    fun provideBaseUrl()=TokenUtils.API_URL
    @Singleton
    @Provides
    fun provideRetrofit(@Named("BaseUrl") baseUrl:String):
            Retrofit {
        val okHttpClient= OkHttpClient.Builder()
            .connectTimeout(1, TimeUnit.MINUTES)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()
        if (retrofit==null){
            retrofit= Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .baseUrl(baseUrl).build()
        }
        return retrofit!!
    }

    @Singleton
    @Provides
    fun restUsuario(retrofit: Retrofit):RestUsuario{
        return retrofit.create(RestUsuario::class.java)
    }
    @Singleton
    @Provides
    fun restActividad(retrofit: Retrofit):RestActividad{
        return retrofit.create(RestActividad::class.java)
    }




    @Singleton
    @Provides
    fun dbDataSource(@ApplicationContext context:Context):DbDataSource{
        return Room.databaseBuilder(context,
            DbDataSource::class.java,
            "eventoasistencia_db")
            .fallbackToDestructiveMigration().build()}


    @Singleton
    @Provides
    fun actividadDao(db:DbDataSource):ActividadDao{
        return db.actividadDao()
    }
    @Singleton
    @Provides
    fun restAsistenciax(retrofit: Retrofit): RestAsistenciax {
        return retrofit.create(RestAsistenciax::class.java)
    }


}