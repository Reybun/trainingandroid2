package com.example.controle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.controle.databinding.FragmentUserlistAddBinding

class UserListAddFragment : Fragment () {

    private lateinit var viewModel : UserListAddViewModel
    private lateinit var adapter: UserAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentUserlistAddBinding>(
            inflater,
            R.layout.fragment_userlist_add,
            container,
            false
        )

        context?.let {
            val db: ControleDatabase = ControleDatabase.getInstance(it)
            val vmFactory = UserListAddViewModelFactory(userDao = db.userDao)
            viewModel = ViewModelProvider(this, vmFactory).get(UserListAddViewModel::class.java)
            binding.lifecycleOwner = this

        }
        binding.vm = viewModel
        adapter = UserAdapter(viewModel) // viewModel is a IUserAdapterCallBack
        binding.rvUserlistadd.adapter = adapter
        binding.rvUserlistadd.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        //OBSERVE LA LISTE
        viewModel.usersObs.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.userIdSelectedObs.observe(viewLifecycleOwner, {
            context?.let {
                val toast = Toast.makeText(it,viewModel.userIdSelectedObs.value!!, Toast.LENGTH_LONG)
                toast.show()
            }
           //QUAND JE CLIQUE SUR UN BOUTON FAIT TOAST
        })


        return binding.root
    }





}