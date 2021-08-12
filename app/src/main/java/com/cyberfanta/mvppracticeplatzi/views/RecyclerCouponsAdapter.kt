package com.cyberfanta.mvppracticeplatzi.views

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.mvppracticeplatzi.R
import com.cyberfanta.mvppracticeplatzi.models.Coupon
import com.squareup.picasso.Picasso

class RecyclerCouponsAdapter(private var coupons : ArrayList<Coupon>, private var resource: Int) : RecyclerView.Adapter<RecyclerCouponsAdapter.CardCouponHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CardCouponHolder {
        val view: View = LayoutInflater.from(p0.context).inflate(resource, p0, false)
        return CardCouponHolder(view)
    }

    override fun getItemCount(): Int {
        return coupons.size
    }

    override fun onBindViewHolder(p0: CardCouponHolder, p1: Int) {
        val coupon = coupons[p1]
        p0.setDataCard(coupon)
    }

    class CardCouponHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {
        private var coupon: Coupon? = null
        private var imgCoupon: ImageView = view.findViewById(R.id.imgCoupon)
        private var tvTitle: TextView = view.findViewById(R.id.tvTitle)
        private var tvDescriptionShort: TextView = view.findViewById(R.id.tvDescriptionShort)
        private var tvCategory: TextView = view.findViewById(R.id.tvCategory)
        private var tvDate: TextView = view.findViewById(R.id.tvDate)

        init {
            view.setOnClickListener(this)
        }

        fun setDataCard(coupon: Coupon){
            this.coupon = coupon
            if (coupon.imageUrl.isNotEmpty())
                Picasso.get().load(coupon.imageUrl).resize(520, 520).centerCrop().into(imgCoupon)
            tvTitle.text = coupon.title
            tvDescriptionShort.text = coupon.descriptionShort
            tvCategory.text = coupon.category
            tvDate.text = coupon.endDate
        }

        override fun onClick(view: View) {
            coupon?.let {
                Log.i("CLICK Coupon: ", it.title)
            }
            val context = view.context
            val showPhotoIntent = Intent(context, CouponDetailActivity::class.java)
            showPhotoIntent.putExtra("COUPON", coupon)
            context.startActivity(showPhotoIntent)
        }
    }
}
