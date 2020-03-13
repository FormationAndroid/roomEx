package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.database.User
import com.example.myapplication.database.UserDao
import com.example.myapplication.database.getDatabase
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thread {

            val john = User(name = "john", age = 42)
            val maria = User(name = "maria", age = 67)
            getDatabase(applicationContext)?.userDao()?.apply {
                insertUsers(john, maria)
                getAll().forEach { Log.d("MyApp", "user $it") }

                runOnUiThread {
                    // TODO : set my textview
                }

            }

        }

    }
}
