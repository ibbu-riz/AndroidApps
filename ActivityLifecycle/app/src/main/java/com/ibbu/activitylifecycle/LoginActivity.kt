package com.ibbu.activitylifecycle

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ibbu.activitylifecycle.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    lateinit var binding: ActivityLoginBinding
    val validMobileNumber = "1234"
    val validPassword = arrayOf("ibbu", "tony", "steve", "bruce", "thanos")

    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = "Login"

        binding.btnLogin.setOnClickListener {
            val mobileNumber = binding.etMobileNumber.text.toString()
            val password = binding.etPassword.text.toString()

            val intent = Intent(
                this,
                AvengersActivity::class.java
            )

            lateinit var nameOfAvengers: String

            if (mobileNumber == validMobileNumber) {
                when (password) {
                    validPassword[0] -> {
                        nameOfAvengers = "Ibbu"
                        savePreferences(nameOfAvengers)
//                        intent.putExtra("Name", nameOfAvengers)
                        startActivity(intent)
                    }
                    validPassword[1] -> {
                        nameOfAvengers = "Iron Man"
                        savePreferences(nameOfAvengers)
//                        intent.putExtra("Name", nameOfAvengers)
                        startActivity(intent)
                    }
                    validPassword[2] -> {
                        nameOfAvengers = "Captain America"
                        savePreferences(nameOfAvengers)
//                        intent.putExtra("Name", nameOfAvengers)
                        startActivity(intent)
                    }
                    validPassword[3] -> {
                        nameOfAvengers = "The Hulk"
                        savePreferences(nameOfAvengers)
//                        intent.putExtra("Name", nameOfAvengers)
                        startActivity(intent)
                    }
                    validPassword[4] -> {
                        nameOfAvengers = "The Avengers1234"
                        savePreferences(nameOfAvengers)
//                        intent.putExtra("Name", nameOfAvengers)
                        startActivity(intent)
                    }
                }
            } else {
                Toast.makeText(
                    this,
                    "Incorrect credentials",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        sharedPreferences =
            getSharedPreferences(
                getString(R.string.preference_file_name),
                Context.MODE_PRIVATE
            )

        val isLoggedIn = sharedPreferences.getBoolean(
            "isLoggedIn",
            false
        )

        if (isLoggedIn) {
            startActivity(
                Intent(
                    this,
                    AvengersActivity::class.java
                )
            )
            finish()
        }
    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean(
            "isLoggedIn",
            true
        ).apply()
        sharedPreferences.edit().putString(
            "Title",
            title
        ).apply()
    }

}