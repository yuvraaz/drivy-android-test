package fr.youbaraj.drivy_android.feature.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import fr.youbaraj.drivy_android.feature.list.viewmodel.CarsViewModel


@Module
abstract class CarsViewModelModule {

    @Binds
    abstract  fun bindDaggerViewModelFactory(daggerViewModelFactory: CarsViewModelFactory):ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(CarsViewModel::class)
    abstract fun bindCarsViewModel(carsViewModel: CarsViewModel):ViewModel

}