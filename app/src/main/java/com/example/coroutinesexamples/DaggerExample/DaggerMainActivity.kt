package com.example.coroutinesexamples.DaggerExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.coroutinesexamples.R

class DaggerMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dagger_main)


        val userRepository = UserRepository()
        val emailService = EmailService()
        /*val userRegistrationService = DaggerUserRegistrationComponent.builder().build()
        userRegistrationService.registerUser("ritesh.sonar111@gmail.com","12345")*/
    }
}