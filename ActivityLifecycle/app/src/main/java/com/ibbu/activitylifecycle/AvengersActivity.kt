package com.ibbu.activitylifecycle

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class AvengersActivity : AppCompatActivity() {
    var titleName: String? = "The Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.scrollview_example)

//        if (intent != null) {
//            titleName = intent.getStringExtra("Name")
//        }

        sharedPreferences =
            getSharedPreferences(
                getString(R.string.preference_file_name),
                Context.MODE_PRIVATE
            )

        titleName = sharedPreferences.getString(
            "Title",
            "The Avengers"
        )

        title = titleName
    }
}