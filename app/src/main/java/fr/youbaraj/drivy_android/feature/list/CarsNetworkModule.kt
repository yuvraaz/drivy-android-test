package fr.youbaraj.drivy_android.feature.list

import dagger.Module
import dagger.Provides
import fr.youbaraj.drivy_android.feature.list.service.CarService
import retrofit2.Retrofit


@Module
 class CarsNetworkModule {
    @Provides
    fun providesCarSerivce(retrofit : Retrofit) : CarService{
        return retrofit.create(CarService::class.java)
    }

}