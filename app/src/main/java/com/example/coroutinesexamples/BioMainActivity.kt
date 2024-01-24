package com.example.coroutinesexamples

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.biometric.BiometricManager
import androidx.biometric.BiometricPrompt
import androidx.biometric.BiometricPrompt.PromptInfo
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import com.example.coroutinesexamples.databinding.ActivityBioMainBinding


class BioMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBioMainBinding

    // creating a variable for our Executor
    var executor = ContextCompat.getMainExecutor(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_bio_main)
        val biometricManager: BiometricManager = BiometricManager.from(this)

        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS -> {
                 "You can use the fingerprint sensor to login".also { binding.msgtext.text = it }
                binding.msgtext.setTextColor(Color.parseColor("#fafafa"))
            }

            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE -> {
                 "This device does not have a fingerprint sensor".also { binding.msgtext.text = it }
                binding.login.visibility = View.GONE
            }

            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE -> {
                "The biometric sensor is currently unavailable".also { binding.msgtext.text = it }
                binding.login.visibility = View.GONE
            }

            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED -> {
                "Your device doesn't have fingerprint saved,please check your security settings".also { binding.msgtext.text = it }
                binding.login.visibility = View.GONE
            }

            BiometricManager.BIOMETRIC_ERROR_SECURITY_UPDATE_REQUIRED -> {
                TODO()
            }

            BiometricManager.BIOMETRIC_ERROR_UNSUPPORTED -> {
                TODO()
            }

            BiometricManager.BIOMETRIC_STATUS_UNKNOWN -> {
                TODO()
            }
        }

        // this will give us result of AUTHENTICATION
        // this will give us result of AUTHENTICATION
        val biometricPrompt = BiometricPrompt(this@BioMainActivity,executor,object :BiometricPrompt.AuthenticationCallback(){
            override fun onAuthenticationError(errorCode: Int, errString: CharSequence) {
                super.onAuthenticationError(errorCode, errString)
            }

            override fun onAuthenticationFailed() {
                super.onAuthenticationFailed()
            }

            override fun onAuthenticationSucceeded(result: BiometricPrompt.AuthenticationResult) {
                super.onAuthenticationSucceeded(result)
                Toast.makeText(applicationContext, "Login Success", Toast.LENGTH_SHORT).show()
                 "Login Successful".also { binding.login.text }
            }
        })
        // creating a variable for our promptInfo
        // BIOMETRIC DIALOG
        // creating a variable for our promptInfo
        // BIOMETRIC DIALOG
        val promptInfo = PromptInfo.Builder().setTitle("GFG")
            .setDescription("Use your fingerprint to login ").setNegativeButtonText("Cancel")
            .build()
        binding.login.setOnClickListener {
            biometricPrompt.authenticate(
                promptInfo
            )
        }


    }
}