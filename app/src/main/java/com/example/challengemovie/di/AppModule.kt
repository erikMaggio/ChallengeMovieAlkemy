package com.example.challengemovie.di

import com.example.challengemovie.model.ApiRest.ApiServiceDetails
import com.example.challengemovie.model.ApiRest.ApiServicePopular
import com.example.challengemovie.model.repository.DetailsRepository
import com.example.challengemovie.model.repository.PopularRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideApiServicePopular(retrofit: Retrofit): ApiServicePopular {
        return retrofit.create(ApiServicePopular::class.java)
    }

    @Singleton
    @Provides
    fun provideRepositoryPopular(api: ApiServicePopular): PopularRepository {
        return PopularRepository(api)
    }

    @Singleton
    @Provides
    fun provideApiServiceDetails(retrofit: Retrofit): ApiServiceDetails {
        return retrofit.create(ApiServiceDetails::class.java)
    }

    @Singleton
    @Provides
    fun provideRepositoryDetails(app: ApiServiceDetails): DetailsRepository {
        return DetailsRepository(app)
    }
}