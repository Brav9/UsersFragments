package com.khalbro.usersfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.khalbro.usersfragments.databinding.DFragmentBinding

class FragmentD : Fragment() {

    private var _binding: DFragmentBinding? = null
    private val binding get() = _binding!!
    private val userStorage = UserStorage
    private val userAdapter: UsersAdapter by lazy {
        UsersAdapter(
            listener = { user ->
                    userStorage.changeSelectState(user)
                    with(parentFragmentManager.beginTransaction()) {
                        replace(
                            R.id.container,
                            EditUserFragment.newInstance(
                                user.nameUser,
                                user.surname,
                                user.phoneNumberUser,
                                user.id,
                                user.iconUser
                            ),
                            EditUserFragment.FRAGMENT_EditUser_TAG
                        )
                        addToBackStack(EditUserFragment.FRAGMENT_EditUser_TAG)
                        commit()

                }
            })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recyclerView: RecyclerView = binding.rvUsersFragmentD
        recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        recyclerView.adapter = userAdapter

        binding.btnBackFromFragmentDToFragmentB.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(
                    R.id.container,
                    FragmentA.newInstance(),
                )
                .addToBackStack(null)
                .commit()
        }

        userStorage.currentUserLiveData.observe(viewLifecycleOwner) { userList ->
            userAdapter.submitList(userList)
        }
    }

    companion object {
        const val FRAGMENT_D_TAG = "FRAGMENT_D_TAG"
        fun newInstance() = FragmentD()
    }
}