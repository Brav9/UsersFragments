package com.khalbro.usersfragments

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        view.findViewById<Button>(R.id.btnTransitionFragmentB).setOnClickListener {
//            (requireActivity() as NextButtonClickListener).onNextButtonClicked()
//        }
    }
    interface NextButtonClickListener{
        fun onNextButtonClicked()
    }

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"
        fun newInstance() = FragmentA()
    }

//    override fun onBackPressed() = !viewModel.isLoading
}