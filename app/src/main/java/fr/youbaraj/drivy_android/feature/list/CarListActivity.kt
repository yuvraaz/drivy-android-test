package fr.youbaraj.drivy_android.feature.list

 import android.os.Bundle
 import android.view.View
 import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.android.support.DaggerAppCompatActivity
import fr.youbaraj.drivy_android.R
import fr.youbaraj.drivy_android.feature.list.viewmodel.CarsViewModel
import kotlinx.android.synthetic.main.activity_car_list.*
import javax.inject.Inject

class CarListActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var factory: CarsViewModelFactory
    lateinit var carsViewModel: CarsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_list)

        carsViewModel = ViewModelProviders.of(this,factory).get(CarsViewModel::class.java)
        carsViewModel.fetchCars()

        initView()
    }

    private fun initView(){
        rv_cars.layoutManager = LinearLayoutManager(this)
        carsViewModel.carsData().observe(this, Observer {
            rv_cars.adapter = CarsListAdapter(it)
        })

        carsViewModel.state().observe(this, Observer {
            if(it.equals(CarsViewModel.LoadingState.IN_PROGRESS))
            pb_loadlist.visibility =  View.VISIBLE
            else pb_loadlist.visibility = View.INVISIBLE
        })
    }
}
