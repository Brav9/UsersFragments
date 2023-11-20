package com.khalbro.usersfragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResult
import com.khalbro.usersfragments.databinding.BFragmentBinding


class FragmentB : Fragment(), NextButtonClickListener {

    private var _binding: BFragmentBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = BFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val text = "Hello Fragment C"
        setFragmentResult(
            FragmentC.REQUEST_KEY,
            bundleOf(FragmentC.BUNDLE_KAY to text)
        )

        binding.btnMoveFromFragmentBToFragmentC.setOnClickListener {

            onNextButtonClicked()
        }
        binding.btnBackFromFragmentBToFragmentA.setOnClickListener {
            parentFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    FragmentA.newInstance(),
                    FragmentA.FRAGMENT_A_TAG
                )
                .addToBackStack(null)
                .commit()
        }
    }

    override fun onNextButtonClicked() {
        with(parentFragmentManager.beginTransaction()) {
            replace(
                R.id.container,
                FragmentC.newInstance(),
                FragmentC.FRAGMENT_C_TAG
            )
            addToBackStack(FragmentC.FRAGMENT_C_TAG)
            commit()
        }
    }

    companion object {
        const val FRAGMENT_B_TAG = "FRAGMENT_B_TAG"
        fun newInstance() = FragmentB()
    }
}