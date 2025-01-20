package com.faixeda.examenrogerfaixeda.VeureProductes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.faixeda.examenrogerfaixeda.R
import com.faixeda.examenrogerfaixeda.databinding.FragmentVeureProductesBinding


class FragmentVeureProductes : Fragment() {
    private lateinit var binding: FragmentVeureProductesBinding

    private lateinit var veureProductesViewModel: VeureProductesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_veure_productes, container, false)

        veureProductesViewModel = ViewModelProvider(this).get(VeureProductesViewModel::class.java)
        veureProductesViewModel.llistar_alumnes(requireContext())
        binding.recyclerViewAlumnes.layoutManager = LinearLayoutManager(requireContext())

        veureProductesViewModel.llistat_productes?.observe(viewLifecycleOwner, Observer { productesLlistar ->
            binding.recyclerViewAlumnes.adapter = VeureProductesAdapter(productesLlistar)
        })

        binding.buttonAfegirProducte.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentVeureProductes_to_afegirProductesFragment)
        }
        binding.buttonContacte.setOnClickListener{
            findNavController().navigate(R.id.action_fragmentVeureProductes_to_fragmentContacte)
        }



        return binding.root
    }

}