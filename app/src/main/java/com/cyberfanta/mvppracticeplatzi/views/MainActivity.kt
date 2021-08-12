package com.cyberfanta.mvppracticeplatzi.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.cyberfanta.mvppracticeplatzi.R
import com.cyberfanta.mvppracticeplatzi.models.Coupon
import com.cyberfanta.mvppracticeplatzi.presenters.CouponPresenter
import com.cyberfanta.mvppracticeplatzi.presenters.CouponPresenterImpl

class MainActivity : AppCompatActivity(), CouponView {
    private var couponPresenter: CouponPresenter? = null
    private var rvCoupons: RecyclerView? = null

    //Entry point for this app
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()

        couponPresenter = CouponPresenterImpl(this)

        rvCoupons = findViewById(R.id.rvCoupons) //UI
        rvCoupons?.layoutManager = LinearLayoutManager(this)

        getCoupons()
    }

    //View
    override fun showCoupons(coupons: ArrayList<Coupon>) {
        try{
            rvCoupons!!.adapter = RecyclerCouponsAdapter(coupons, R.layout.card_coupon)
        }catch (e: Exception){
            e.printStackTrace()
        }
    }

    //Presenter
    override fun getCoupons() {
        couponPresenter?.getCoupons()
    }
}