package com.khalbro.usersfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.khalbro.usersfragments.databinding.CFragmenBinding

private const val ARG_PARAM1 = "param1"

class FragmentC : Fragment(), NextButtonClickListener {

    private var param1: String? = null
    private var _binding: CFragmenBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = CFragmenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.tvMassage.text = param1
        binding.btnMoveFromFragmentCToFragmentD.setOnClickListener {
            onNextButtonClicked()
        }
        binding.btnBackFromFragmentCToFragmentA.setOnClickListener {
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
                FragmentD.newInstance(),
                FragmentD.FRAGMENT_D_TAG
            )
            addToBackStack(FragmentD.FRAGMENT_D_TAG)
            commit()
        }
    }

    companion object {
        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"
        @JvmStatic
        fun newInstance(param1 : String) = FragmentC().apply {
            arguments = Bundle().apply {
                putString(ARG_PARAM1, param1)
            }
        }
    }
}