package fr.youbaraj.drivy_android.feature.list

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class CarActivityModule {
    @ContributesAndroidInjector(modules = [CarsViewModelModule::class,CarsNetworkModule::class])
    abstract fun bindCarsListActivity():CarListActivity
}