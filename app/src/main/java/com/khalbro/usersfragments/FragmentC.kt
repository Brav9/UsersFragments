package com.khalbro.usersfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.setFragmentResultListener
import com.khalbro.usersfragments.databinding.CFragmenBinding


private const val ARG_PARAM1 = "param1"

class FragmentC : Fragment(), NextButtonClickListener {

    private var param1: String? = null
    private var _binding: CFragmenBinding? = null
    private var result = ""
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
        setFragmentListener()

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

    private fun setFragmentListener() {
        setFragmentResultListener(FragmentC.REQUEST_KEY) { requestKey, bundle ->
            result = bundle.getString(FragmentC.BUNDLE_KAY).toString()
            binding.tvMassage.text = result
        }
    }

    companion object {
        const val REQUEST_KEY = "REQUEST_KEY"
        const val BUNDLE_KAY = "BUNDLE_KAY"
        const val FRAGMENT_C_TAG = "FRAGMENT_C_TAG"

        @JvmStatic
        fun newInstance() = FragmentC()
    }
}