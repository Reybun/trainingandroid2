package com.example.controle

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation

class MainActivity :
    AppCompatActivity(),
    IHome,
    IUserSelected
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun OnClickListWithDetail() {
        Navigation.findNavController(this, R.id.home_fragment)
            .navigate(R.id.action_homeFragment_to_userListDetailFragment)
    }

    override fun OnClickListWithToast() {
        Navigation.findNavController(this, R.id.home_fragment)
            .navigate(HomeFragmentDirections.actionHomeFragmentToUserListAddFragment())
    }


    override fun userSelected(id: String) {
        val action = UserListDetailFragmentDirections.actionUserListDetailFragmentToUserDetailFragment(id)
        Navigation.findNavController(this, R.id.home_fragment).navigate(action)
    }
}