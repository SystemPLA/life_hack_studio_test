package ru.systempla.life_hack_studio_test.main_activity

import android.os.Bundle
import moxy.MvpAppCompatActivity
import ru.systempla.life_hack_studio_test.R

class MainActivity : MvpAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
