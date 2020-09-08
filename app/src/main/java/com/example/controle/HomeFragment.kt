package com.example.controle

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.controle.databinding.FragmentHomeBinding

class HomeFragment : Fragment () {

    private var listener: IHome? = null
    private lateinit var binding : FragmentHomeBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is IHome) {
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
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        binding.btListdetail.setOnClickListener{listener?.OnClickListWithDetail()}
        binding.btListtoast.setOnClickListener{listener?.OnClickListWithToast()}

    }




}