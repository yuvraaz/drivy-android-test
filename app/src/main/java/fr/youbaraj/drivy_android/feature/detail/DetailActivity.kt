package fr.youbaraj.drivy_android.feature.detail

import android.os.Bundle
 import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import fr.youbaraj.drivy_android.R
 import fr.youbaraj.drivy_android.databinding.ActivityDetailBinding
import fr.youbaraj.drivy_android.feature.list.model.CarsDAO
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_detail)
        var car = intent.extras?.get("car") as CarsDAO?
        binding.cardetail = car
        setSupportActionBar(toolbar)
        configAndUpdateActionBar()
    }

    fun configAndUpdateActionBar(){
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
     }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}
