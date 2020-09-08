package com.example.controle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.controle.databinding.FragmentUserDetailBinding

class UserDetailFragment : Fragment () {

    private lateinit var binding: FragmentUserDetailBinding
    private lateinit var viewModel: UserDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate<FragmentUserDetailBinding>(
            inflater,
            R.layout.fragment_user_detail,
            null,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        if(context != null && arguments != null) {
            val userId = UserDetailFragmentArgs.fromBundle(requireArguments()).userId

            val vmFactory = UserDetailViewModelFactory(ControleDatabase.getInstance(requireContext()).userDao, userId)
            viewModel = ViewModelProviders.of(this, vmFactory).get(UserDetailViewModel::class.java)
            binding.vm = viewModel
        }

        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }





}