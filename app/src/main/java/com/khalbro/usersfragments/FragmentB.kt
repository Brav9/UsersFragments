package com.khalbro.usersfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentB : Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    companion object {
        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"

        private const val STRING_EXTRA = "STRING_EXTRA"

        fun newInstance() = FragmentB()
//            .apply {
//            arguments = Bundle().apply {
//                putString(STRING_EXTRA, s)
//            }
//        }
    }
}