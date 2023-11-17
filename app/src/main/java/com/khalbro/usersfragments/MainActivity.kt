package com.khalbro.usersfragments

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.khalbro.usersfragments.FragmentA.Companion.FRAGMENT_A_TAG

class MainActivity : AppCompatActivity(), FragmentA.NextButtonClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (supportFragmentManager.findFragmentByTag(FRAGMENT_A_TAG) == null) {
            with(supportFragmentManager.beginTransaction()) {
                replace(
                    com.google.android.material.R.id.container,
                    FragmentA.newInstance(),
                    FragmentA.FRAGMENT_A_TAG
                )
                commit()
            }
        }
    }


    override fun onNextButtonClicked() {
        with(supportFragmentManager.beginTransaction()) {
            replace(
                com.google.android.material.R.id.container,
                FragmentB.newInstance(),
                FragmentB.FRAGMENT_B_TAG
            )
            addToBackStack(FragmentB.FRAGMENT_B_TAG)
            commit()
        }
    }

    companion object {
        fun newIntent(context: Context) = Intent(context, MainActivity::class.java)
    }
}