package com.faixeda.examenrogerfaixeda.ModificarProductes

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.faixeda.examenrogerfaixeda.R
import com.faixeda.examenrogerfaixeda.VeureProductes.VeureProductesViewModel
import com.faixeda.examenrogerfaixeda.databinding.FragmentModificarProductesBinding
import com.faixeda.examenrogerfaixeda.databinding.FragmentVeureProductesBinding


class FragmentModificarProductes : Fragment() {
    private lateinit var binding: FragmentModificarProductesBinding

    private lateinit var modificarProductesViewModel: ModificarProductesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_modificar_productes, container, false)

        modificarProductesViewModel = ViewModelProvider(this).get(ModificarProductesViewModel::class.java)

        binding.buttonModificar.setOnClickListener{
            var nom : String = binding.editTextNom.text.toString()
            var preu : Int? = binding.editTextPreu.text.toString().toIntOrNull()

            if (nom != "" && preu != null){
                modificarProductesViewModel.modificaProducte(requireContext(), nom, preu)
                findNavController().navigate(R.id.action_fragmentModificarProductes_to_fragmentVeureProductes)
            } else {
                Toast.makeText(context, "No pot haver-hi camps buits", Toast.LENGTH_SHORT).show()
            }
        }

        binding.buttonEliminar.setOnClickListener{
            var nom : String = binding.editTextNom.text.toString()
            var preu : Int? = binding.editTextPreu.text.toString().toIntOrNull()

            if (nom != "" && preu != null){
                modificarProductesViewModel.eliminarProducte(requireContext(), nom, preu)
                findNavController().navigate(R.id.action_fragmentModificarProductes_to_fragmentVeureProductes)
            } else {
                Toast.makeText(context, "No pot haver-hi camps buits", Toast.LENGTH_SHORT).show()
            }
        }




        return binding.root
    }

}