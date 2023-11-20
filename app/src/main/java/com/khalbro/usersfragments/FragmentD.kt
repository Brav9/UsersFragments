package com.khalbro.usersfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khalbro.usersfragments.databinding.DFragmentBinding

class FragmentD : Fragment() {

    private var _binding: DFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnBackFromFragmentDToFragmentB.setOnClickListener {
//          parentFragmentManager.popBackStack(FragmentB.FRAGMENT_B_TAG, FragmentManager.POP_BACK_STACK_INCLUSIVE)
            parentFragmentManager.beginTransaction()
              .replace( R.id.container,
                  FragmentA.newInstance(),
                  FragmentA.FRAGMENT_A_TAG)
                .addToBackStack(null)
              .commit()
        }
    }

    companion object {
        const val FRAGMENT_D_TAG = "FRAGMENT_D_TAG"
        fun newInstance() = FragmentD()
    }
}