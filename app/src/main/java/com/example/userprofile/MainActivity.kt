package com.example.userprofile

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserProfile(var name: String, var email: String, var password: Int, var age: Int) {

    fun displayProfile(): String
    {
        return "User Profile:\nName: $name\nEmail: $email\nPassword: $password\nAge: $age"
    }

    fun updateProfile(newName: String, newEmail: String, newPassword: Int, newAge: Int) {
        name = newName
        email = newEmail
        password = newPassword
        age = newAge
    }
}

class MainActivity : AppCompatActivity()
{

    private lateinit var nameEditText: EditText
    private lateinit var emailEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var ageEditText: EditText
    private lateinit var displayButton: Button
    private lateinit var updateButton: Button
    private lateinit var profileTextView: TextView

    private lateinit var userProfile: UserProfile

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        nameEditText = findViewById(R.id.nameEditText)
        emailEditText = findViewById(R.id.emailEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        ageEditText = findViewById(R.id.ageEditText)
        displayButton = findViewById(R.id.displayButton)
        updateButton = findViewById(R.id.updateButton)
        profileTextView = findViewById(R.id.profileTextView)


        userProfile = UserProfile("Malathi", "malathisankar@gmail.com", 12345, 34)

        displayButton.setOnClickListener()
        {
            profileTextView.text = userProfile.displayProfile()
        }

        updateButton.setOnClickListener {

            val newName = nameEditText.text.toString()
            val newEmail = emailEditText.text.toString()
            val newPassword = passwordEditText.text.toString().toInt()
            val newAge = ageEditText.text.toString().toInt()

            userProfile.updateProfile(newName, newEmail, newPassword, newAge)

            profileTextView.text = userProfile.displayProfile()
        }
    }
}