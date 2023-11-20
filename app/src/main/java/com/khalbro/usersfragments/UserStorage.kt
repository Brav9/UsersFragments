package com.khalbro.usersfragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

object UserStorage {

    private val _currentUserLiveData = MutableLiveData<List<User>>()
    val currentUserLiveData: LiveData<List<User>> = _currentUserLiveData

    private val userList = listOf(
        User(1, "Skull", "Skuller", "+6666666666", R.drawable.skull),
        User(2, "Ghost", "Ghostovich", "+0000000000", R.drawable.ghost),
        User(3, "Ball", "Bulldogovich", "+09090909090", R.drawable.bulldog),
        User(4, "Raks", "Big", "+11010010100001", R.drawable.pitbull),
        User(5, "Vaska", "Gerry", "+35770009971", R.drawable.cat),
        User(6, "Jerry", "Mouse", "+485447885005", R.drawable.jerry),
        User(7, "Tom", "Cat", "+006060606060", R.drawable.tom),
    )

    init {
        loadUsers()
    }

    private fun loadUsers() {
        _currentUserLiveData.value = userList
    }

    fun changeSelectState(user: User) {
        val current = currentUserLiveData.value ?: emptyList()
        _currentUserLiveData.postValue(
            current.map { currentContact ->
                currentContact
            })
    }

    fun updateContact(user: User) {
        val current = currentUserLiveData.value ?: emptyList()
        _currentUserLiveData.postValue(
            current.map { currentUser ->
                if (currentUser.id == user.id) {
                    user
                } else {
                    currentUser
                }
            })
    }
}
