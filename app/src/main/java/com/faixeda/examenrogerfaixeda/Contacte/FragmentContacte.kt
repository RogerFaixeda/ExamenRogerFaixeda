package com.faixeda.examenrogerfaixeda.Contacte

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.faixeda.examenrogerfaixeda.R
import com.faixeda.examenrogerfaixeda.databinding.FragmentContacteBinding


class FragmentContacte : Fragment() {
    private lateinit var binding: FragmentContacteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_contacte, container, false)

        binding.buttonTornar.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentContacte_to_fragmentVeureProductes)
        }

        return binding.root
    }

}