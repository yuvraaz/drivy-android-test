package fr.youbaraj.drivy_android.feature.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import fr.youbaraj.drivy_android.R
import fr.youbaraj.drivy_android.databinding.ActivityCarDetailBinding
import fr.youbaraj.drivy_android.feature.list.model.CarsDAO

class CarDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityCarDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_car_detail)
        var car = intent.extras?.get("car") as CarsDAO?
        binding.cardetail = car
        configAndUpdateActionBar(car)
   }

    fun configAndUpdateActionBar(car : CarsDAO?){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.title=car?.brand +" "+ car?.model
    }
}
