package com.example.coroutinesexamples.DaggerExample

class UserRegistrationService(private val userRepository: UserRepository ,
                              private val emailService: EmailService
) {

    fun registerUser(email: String,password:String){
        userRepository.saveUser(email,password)
        emailService.send(email,"no-reply@cheezcode.com","User Register")
    }
}