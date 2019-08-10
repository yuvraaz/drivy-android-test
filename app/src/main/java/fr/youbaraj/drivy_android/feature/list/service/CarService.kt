package fr.youbaraj.drivy_android.feature.list.service

import fr.youbaraj.drivy_android.feature.list.model.CarsDAO
import retrofit2.Call
import retrofit2.http.GET

 interface CarService {
    @GET(Constants.CARS)
    fun getCars() : Call<List<CarsDAO>>
}