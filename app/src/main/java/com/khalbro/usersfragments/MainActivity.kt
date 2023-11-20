package com.khalbro.usersfragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khalbro.usersfragments.FragmentA.Companion.FRAGMENT_A_TAG

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentByTag(FRAGMENT_A_TAG) == null) {
            with(supportFragmentManager.beginTransaction()) {
                replace(
                    R.id.container,
                    FragmentA.newInstance(),
                    FragmentA.FRAGMENT_A_TAG
                )
                commit()
            }
        }
    }
}