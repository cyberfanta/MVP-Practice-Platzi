package com.cyberfanta.mvppracticeplatzi.views

import com.cyberfanta.mvppracticeplatzi.models.Coupon

interface CouponView {
    //View
    fun showCoupons (coupons: ArrayList<Coupon>)

    //Presenter
    fun getCoupons ()
}