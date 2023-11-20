package com.khalbro.usersfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.khalbro.usersfragments.databinding.AFragmentBinding

class FragmentA : Fragment(), NextButtonClickListener {

    private var _binding: AFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = AFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnMoveFromFragmentAToFragmentB.setOnClickListener {
            onNextButtonClicked()
        }
    }

    override fun onNextButtonClicked() {
        with(parentFragmentManager.beginTransaction()) {
            replace(
                R.id.container,
                FragmentB.newInstance(),
                FragmentB.FRAGMENT_B_TAG
            )
            addToBackStack(null)
            commit()
        }
    }

    companion object {
        const val FRAGMENT_A_TAG = "FRAGMENT_A_TAG"
        fun newInstance() = FragmentA()
    }
}