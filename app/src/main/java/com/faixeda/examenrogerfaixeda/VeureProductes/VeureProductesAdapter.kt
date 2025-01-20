package com.faixeda.examenrogerfaixeda.VeureProductes


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.faixeda.examenrogerfaixeda.R
import com.faixeda.examenrogerfaixeda.data.Producte

class VeureProductesAdapter(private val mList : List<Producte>)  : RecyclerView.Adapter<VeureProductesAdapter.ViewHolder>(){
    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_producte, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val producte = mList[position]

        holder.textViewNom.text = producte.nom
        holder.textViewPreu.text = producte.preu.toString() + "€"


        holder.itemView.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_fragmentVeureProductes_to_fragmentModificarProductes)
        }

        //Aixo serveix per si volem fer-lo responsive amb una accio que seleccioni els
        // items i els faci canviar de color per veure quins estan seleccionats

//        holder.itemView.setOnClickListener {
//            if (selectedItems.contains(alumne)) {
//                selectedItems.remove(alumne) // Si ya está seleccionado, lo eliminamos
//                holder.itemView.setBackgroundColor(Color.WHITE) // Restaurar el color de fondo original
//            } else {
//                selectedItems.add(alumne) // Si no está seleccionado, lo añadimos
//                holder.itemView.setBackgroundColor(Color.LTGRAY) // Cambiar el fondo para indicar selección
//            }
//        }

    }
    // Holds the views for adding it to image and text
    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val textViewNom: TextView = itemView.findViewById(R.id.textViewNom)
        val textViewPreu: TextView = itemView.findViewById(R.id.textViewPreu)
    }
}
