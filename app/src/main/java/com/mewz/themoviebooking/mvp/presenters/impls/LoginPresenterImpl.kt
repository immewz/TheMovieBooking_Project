package com.mewz.themoviebooking.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.mewz.themoviebooking.mvp.presenters.AbstractBasePresenter
import com.mewz.themoviebooking.mvp.presenters.LoginPresenter
import com.mewz.themoviebooking.mvp.views.LoginView

class LoginPresenterImpl: AbstractBasePresenter<LoginView>(), LoginPresenter {

    override fun onUiReady(context: Context, owner: LifecycleOwner) {}

    override fun onTapVerifyPhoneNumber(phone: String, message: String) {
        mView.navigateToOTPScreen(phone, message)
    }
}