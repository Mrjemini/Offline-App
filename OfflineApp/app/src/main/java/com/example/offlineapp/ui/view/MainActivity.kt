package com.example.offlineapp.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.offlineapp.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, UserListFragment())
            .commit()


    }

}