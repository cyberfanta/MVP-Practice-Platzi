package com.cyberfanta.mvppracticeplatzi.presenters

import com.cyberfanta.mvppracticeplatzi.models.Coupon
import com.cyberfanta.mvppracticeplatzi.models.CouponInteractor
import com.cyberfanta.mvppracticeplatzi.models.CouponInteractorImpl
import com.cyberfanta.mvppracticeplatzi.views.CouponView

class CouponPresenterImpl(var couponView: CouponView): CouponPresenter {
    private var couponInteractor: CouponInteractor = CouponInteractorImpl(this)

    //View
    override fun showCoupons(coupons: ArrayList<Coupon>) {
        couponView.showCoupons(coupons)
    }

    //Interactor
    override fun getCoupons() {
        couponInteractor.getCouponsAPI()
    }
}