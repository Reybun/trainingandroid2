package com.example.controle

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.controle.databinding.FragmentUserlistDetailBinding

class UserListDetailFragment : Fragment () {

    private var listener: IUserSelected? = null
    private lateinit var viewModel : UserListDetailViewModel
    private lateinit var adapter: UserAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is IUserSelected) {
            listener = context
        } else {
            NotImplementedError("ATTACHED NOT TO INTERFACE")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentUserlistDetailBinding>(
            inflater,
            R.layout.fragment_userlist_detail,
            container,
            false
        )

        context?.let {
            val db: ControleDatabase = ControleDatabase.getInstance(it)
            val vmFactory = UserListDetailViewModelFactory(userDao = db.userDao)
            viewModel = ViewModelProvider(this, vmFactory).get(UserListDetailViewModel::class.java)
            binding.lifecycleOwner = this

        }

        adapter = UserAdapter(viewModel) // viewModel is a IUserAdapterCallBack
        binding.rvUserlistdetail.adapter = adapter
        binding.rvUserlistdetail.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        //OBSERVE LA LISTE
        viewModel.usersObs.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        viewModel.userIdSelectedObs.observe(viewLifecycleOwner, {
            listener?.userSelected(viewModel.userIdSelectedObs.value!!) //QUAND JE CLIQUE SUR UN BOUTON PASSE LID A LACTIVITY
        })

        return binding.root
    }





}