package com.mewz.themoviebooking.mvp.presenters.impls

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.mewz.themoviebooking.mvp.presenters.AbstractBasePresenter
import com.mewz.themoviebooking.mvp.presenters.LogoPresenter
import com.mewz.themoviebooking.mvp.views.LogoView

class LogoPresenterImpl: AbstractBasePresenter<LogoView>(), LogoPresenter {

    override fun onUiReady(context: Context, owner: LifecycleOwner) {}

}