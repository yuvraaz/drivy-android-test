package fr.youbaraj.drivy_android.feature.list.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.youbaraj.drivy_android.feature.list.model.CarsDAO
import fr.youbaraj.drivy_android.feature.list.service.CarService
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject
import javax.security.auth.callback.Callback

class CarsViewModel @Inject constructor(private val carService: CarService) : ViewModel() {
    private val carsData: MutableLiveData<List<CarsDAO>> = MutableLiveData()
    private val loadingState: MutableLiveData<LoadingState> = MutableLiveData()

    fun carsData(): LiveData<List<CarsDAO>> = carsData
    fun state() : LiveData<LoadingState> = loadingState


    fun fetchCars() {
        loadingState.postValue(LoadingState.IN_PROGRESS)
        carService.getCars().enqueue(object : Callback, retrofit2.Callback<List<CarsDAO>> {
            override fun onResponse(call: Call<List<CarsDAO>>?, response: Response<List<CarsDAO>>?) {
                carsData.postValue(response?.body())
                loadingState.postValue(LoadingState.LOADED)
            }

            override fun onFailure(call: Call<List<CarsDAO>>?, t: Throwable?) {
                carsData.postValue(null)
                loadingState.postValue(LoadingState.FAILED)
            }

        }


        )
    }

    enum class LoadingState{
        IN_PROGRESS, LOADED, FAILED
    }


}