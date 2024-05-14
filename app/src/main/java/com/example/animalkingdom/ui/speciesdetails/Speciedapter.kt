package com.miu.mdp.speciekingdomexplorer.ui.speciesdetails

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.animalkingdom.R
import com.example.animalkingdom.data.model.Specie
class SpecieListAdapter : ListAdapter<Specie, SpecieListAdapter.SpecieViewHolder>(SpecieDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpecieViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_specie_layout, parent, false)
        return SpecieViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: SpecieViewHolder, position: Int) {
        val current = getItem(position)
        holder.bind(current)
    }

    class SpecieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val specieNameTextView: TextView = itemView.findViewById(R.id.text_specie_name)
        private val specieDescriptionTextView: TextView = itemView.findViewById(R.id.text_specie_description)

        fun bind(specie: Specie
        ) {
            specieNameTextView.text = specie.name
            specieDescriptionTextView.text =  specie.description
        }
    }

    class SpecieDiffCallback : DiffUtil.ItemCallback<Specie>() {
        override fun areItemsTheSame(oldItem: Specie, newItem: Specie): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Specie, newItem: Specie): Boolean {
            return oldItem == newItem
        }
    }
}