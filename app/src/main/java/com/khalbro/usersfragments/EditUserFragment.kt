package com.khalbro.usersfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.khalbro.usersfragments.databinding.FragmentEditUserBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"
private const val ARG_PARAM3 = "param3"
private const val ARG_PARAM4 = "param4"
private const val ARG_PARAM5 = "param5"

class EditUserFragment : Fragment() {

    private var paramNameUser: String? = null
    private var paramSurnameUser: String? = null
    private var paramPhoneNumber: String? = null
    private var paramId: Int? = null
    private var paramIconUser: Int? = null
    private var _binding: FragmentEditUserBinding? = null
    private var user: User = User(
        id = 0, nameUser = "", surname = "", iconUser = 1, phoneNumberUser = ""
    )
    private val binding get() = _binding!!
    private val userStorage = UserStorage

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            paramNameUser = it.getString(ARG_PARAM1)
            paramSurnameUser = it.getString(ARG_PARAM2)
            paramPhoneNumber = it.getString(ARG_PARAM3)
            paramId = it.getInt(ARG_PARAM4)
            paramIconUser = it.getInt(ARG_PARAM5)
        }
        user = User(
            nameUser = paramNameUser!!,
            surname = paramSurnameUser!!,
            phoneNumberUser = paramPhoneNumber!!,
            id = paramId!!,
            iconUser = paramIconUser!!
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentEditUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvNameEdit.setText(paramNameUser)
        binding.etSurnameEdit.setText(paramSurnameUser)
        binding.etPhoneNumberEdit.setText(paramPhoneNumber)
        binding.btnSave.setOnClickListener {
            userStorage.updateContact(
                user.copy(
                    nameUser = binding.tvNameEdit.text.toString(),
                    surname = binding.etSurnameEdit.text.toString(),
                    phoneNumberUser = binding.etPhoneNumberEdit.text.toString()
                )
            )
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    FragmentD.newInstance(),
                )
                .addToBackStack(null)
                .commit()
        }
    }

    companion object {
        const val FRAGMENT_EditUser_TAG = "FRAGMENT_EditUser_TAG"

        @JvmStatic
        fun newInstance(
            paramNameUser: String,
            paramSurnameUser: String,
            paramPhoneNumber: String,
            paramId: Int,
            paramIconUser: Int
        ) =
            EditUserFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, paramNameUser)
                    putString(ARG_PARAM2, paramSurnameUser)
                    putString(ARG_PARAM3, paramPhoneNumber)
                    putInt(ARG_PARAM4, paramId)
                    putInt(ARG_PARAM5, paramIconUser)
                }
            }
    }
}