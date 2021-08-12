package com.cyberfanta.mvppracticeplatzi.presenters

import com.cyberfanta.mvppracticeplatzi.models.Coupon

interface CouponPresenter {
    //View
    fun showCoupons(coupons: ArrayList<Coupon>)

    //Interactor
    fun getCoupons()
}