package com.faixeda.examenrogerfaixeda.AfegirProductes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.faixeda.examenrogerfaixeda.R
import com.faixeda.examenrogerfaixeda.databinding.FragmentAfegirProductesBinding


class AfegirProductesFragment : Fragment() {
    private lateinit var binding: FragmentAfegirProductesBinding
    private lateinit var afegirProducteViewModel: AfegirProductesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_afegir_productes, container, false)

        afegirProducteViewModel = ViewModelProvider(this).get(AfegirProductesViewModel::class.java)

        binding.buttonAfegir.setOnClickListener{
            var nom : String = binding.editTextNom.text.toString()
            var preu : Int? = binding.editTextPreu.text.toString().toIntOrNull()

            if (nom != "" && preu != null){
                afegirProducteViewModel.nouProducte(requireContext(), nom, preu)
                findNavController().navigate(R.id.action_afegirProductesFragment_to_fragmentVeureProductes)
            } else {
                Toast.makeText(context, "No pot haver-hi camps buits", Toast.LENGTH_SHORT).show()
            }
        }
        return binding.root
    }

}