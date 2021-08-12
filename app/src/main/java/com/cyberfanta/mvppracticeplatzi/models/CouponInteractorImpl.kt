package com.cyberfanta.mvppracticeplatzi.models

import com.cyberfanta.mvppracticeplatzi.presenters.CouponPresenter

class CouponInteractorImpl(var couponPresenter: CouponPresenter): CouponInteractor {
    private var couponRepository: CouponRepository = CouponRepositoryImpl(couponPresenter)

    //Presenter
    override fun getCouponsAPI() {
        couponRepository.getCouponsAPI()
    }
}