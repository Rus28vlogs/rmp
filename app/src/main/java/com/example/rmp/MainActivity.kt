package com.example.rmp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val userlogin: EditText = findViewById(R.id.user_login)
        val maillogin: EditText = findViewById(R.id.user_mail)
        val userPass: EditText = findViewById(R.id.user_pass)
        val buttonreg: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.linktoauth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

            buttonreg.setOnClickListener {
            val login = userlogin.text.toString().trim()
            val email = maillogin.text.toString().trim()
            val pass = userPass.text.toString().trim()


            if (login == ""||email == ""||pass == "")
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            else {
                val user = User(login, email, pass)

                val db = DBHelper(this,null)
                db.addUser(user)
                Toast.makeText(this, "Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                userlogin.text.clear()
                maillogin.text.clear()
                userPass.text.clear()



            }
        }
        }
}