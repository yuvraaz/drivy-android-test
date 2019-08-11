package fr.youbaraj.drivy_android.feature.list

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.makeramen.roundedimageview.RoundedImageView
import fr.youbaraj.drivy_android.R
import fr.youbaraj.drivy_android.feature.detail.CarDetailActivity
import fr.youbaraj.drivy_android.feature.list.model.CarsDAO

class CarsListAdapter(private val carsDataSet: List<CarsDAO>) :
    RecyclerView.Adapter<CarsListAdapter.CarsViewHolder>() {
    lateinit var context: Context
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarsViewHolder {
        val v = LayoutInflater.from(parent.context).inflate( R.layout.item_cars,parent, false)
        context=parent.context
        return CarsViewHolder(v)
    }


    override fun getItemCount(): Int {
        return carsDataSet.size
    }


    override fun onBindViewHolder(holder: CarsViewHolder, position: Int) {
        /*Update item view that displays on rcyclerview*/
        Glide.with(context)
            .load(carsDataSet[position].pictureurl)
            .into(holder.photo)
        holder.title.text = carsDataSet[position].brand
        holder.model.text= carsDataSet[position].model
        holder.count.text = carsDataSet[position].rating.count.toString()
        holder.price.text = "€"+carsDataSet[position].price.toString() + "/d"
        holder.ratingBar.rating = carsDataSet[position].rating.average.toFloat()


        holder.photo.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, CarDetailActivity::class.java).apply {
                putExtra("car", carsDataSet[position])
            }
            context.startActivity(intent)
        })


    }


    class CarsViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
       /*View initialization for adapter*/
        var photo: RoundedImageView = itemView.findViewById(R.id.iv_picture)
        var title: TextView = itemView.findViewById(R.id.tv_title)
        var model: TextView = itemView.findViewById(R.id.tv_model)
        var count: TextView = itemView.findViewById(R.id.tv_count)
        var price: TextView = itemView.findViewById(R.id.tv_price)
        var ratingBar : RatingBar = itemView.findViewById(R.id.rb_rating)


    }

}