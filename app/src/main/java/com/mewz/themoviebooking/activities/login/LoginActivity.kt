package com.mewz.themoviebooking.activities.login

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.AppCompatEditText
import com.hbb20.CCPCountry
import com.hbb20.CountryCodePicker
import com.mewz.themoviebooking.R
import com.mewz.themoviebooking.activities.BaseActivity
import com.mewz.themoviebooking.data.models.TheMovieBookingModel
import com.mewz.themoviebooking.data.models.TheMovieBookingModelImpl
import com.mewz.themoviebooking.databinding.ActivityLoginBinding
import com.mewz.themoviebooking.fragments.ProfileFragment
import com.mewz.themoviebooking.mvp.presenters.LoginPresenter
import com.mewz.themoviebooking.mvp.presenters.impls.LoginPresenterImpl
import com.mewz.themoviebooking.mvp.views.LoginView

class LoginActivity : BaseActivity(), LoginView {

    private lateinit var binding: ActivityLoginBinding

    private lateinit var mPresenter: LoginPresenter

    private val mTheMovieBookingModel: TheMovieBookingModel = TheMovieBookingModelImpl

    companion object{
        fun newIntent(context: Context): Intent{
            return Intent(context, LoginActivity::class.java)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            setContentView(binding.root)
        }else{
            setContentView(binding.root)
        }


        setUpPresenter()
        setUpListeners()

    }

    private fun setUpPresenter() {
        mPresenter = getPresenter<LoginPresenterImpl, LoginView>()
    }

    private fun setUpListeners() {

        binding.btnVerifyPhone.setOnClickListener {

            val ccp = findViewById<CountryCodePicker>(R.id.countryCodePicker)
            val phone = findViewById<AppCompatEditText>(R.id.edtPhoneNumber)
            ccp.registerCarrierNumberEditText(phone)
            val fullNumber = ccp.fullNumber

            mTheMovieBookingModel.getOtp(
                phone = fullNumber,
                onSuccess = {mPresenter.onTapVerifyPhoneNumber(fullNumber, it.message.toString())},
                onFailure = {
                    Toast.makeText(this, it, Toast.LENGTH_LONG).show()
                }
            )

        }

    }

    override fun navigateToOTPScreen(phone: String, message: String) {
        startActivity(OtpActivity.newIntent(this, phone, message))
    }


}