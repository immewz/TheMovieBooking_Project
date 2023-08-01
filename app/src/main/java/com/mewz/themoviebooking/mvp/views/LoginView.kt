package com.mewz.themoviebooking.mvp.views

interface LoginView: BaseView {
    fun navigateToOTPScreen(phone: String, message: String)
}