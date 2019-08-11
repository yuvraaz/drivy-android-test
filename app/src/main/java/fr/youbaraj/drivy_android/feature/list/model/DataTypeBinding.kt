package fr.youbaraj.drivy_android.feature.list.model

 import android.widget.ImageView
 import android.widget.RatingBar
 import android.widget.TextView
 import androidx.databinding.BindingAdapter
 import com.bumptech.glide.Glide
 import com.bumptech.glide.request.RequestOptions

@BindingAdapter("imageUrl")
fun setImageUrl(view: ImageView, url: String?) {
    Glide.with(view).load(url).into(view)
}

@BindingAdapter("circ_imageUrl")
fun setCircularImageUrl(view: ImageView, url: String?) {
    Glide.with(view).load(url).apply(RequestOptions.circleCropTransform())
        .into(view)
}






@BindingAdapter("rate_value")
fun setRate(view: RatingBar, rate: Double) {
    view.rating=  Math.round(rate.toFloat() * 10.0) / 10.0.toFloat()

}

@BindingAdapter("rate_count")
fun setRateCount(textView: TextView, rate: Double) {
    textView.text=(Math.round(rate.toFloat() * 10.0) / 10.0).toFloat().toString()
}


@BindingAdapter("review_value")
fun setOwnerReview(textView: TextView, review: Int) {
    textView.text="("+review.toString()+" reviews)"
}


@BindingAdapter("review_count")
fun setCarReview(textView: TextView, count: Int) {
    textView.text=count.toString()+" reviews"
}

@BindingAdapter("price_value")
fun setPrice(textView: TextView, price: Int) {
    textView.text="€"+price.toString()+"/d"
}




