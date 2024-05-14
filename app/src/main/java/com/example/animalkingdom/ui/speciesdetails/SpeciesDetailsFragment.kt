package com.example.animalkingdom.ui.speciesdetails;

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.animalkingdom.R
import com.example.animalkingdom.data.database.AppDatabase
import com.example.animalkingdom.data.model.Specie
import com.example.animalkingdom.ui.BaseFragment.BaseFragment
import com.example.animalkingdom.ui.Helper.toast

import com.miu.mdp.speciekingdomexplorer.ui.speciesdetails.SpecieListAdapter
import kotlinx.coroutines.launch

class SpeciesDetailsFragment : BaseFragment() {

    companion object {
        fun newInstance() = SpeciesDetailsFragment()
    }

    private lateinit var viewModel: SpeciesDetailsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var specieViewModel: SpeciesDetailsViewModel

    override fun <T> addItem(item: T) {
        launch {
            /* NoteDatabase needs an context argument, if it is not null
            let perform add or update query
            */
            context?.let {
                // Create a new Note object
                specieViewModel.insert(item as Specie)
                it.toast("Specie Added")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_species_details2, container, false)
        recyclerView = view.findViewById(R.id.specie_recycler_view)
         recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = SpecieListAdapter()
        recyclerView.adapter = adapter
        specieViewModel = ViewModelProvider(this).get(SpeciesDetailsViewModel::class.java)
        specieViewModel.allSpecies.observe(viewLifecycleOwner, Observer { species ->
            species?.let { adapter.submitList(it) }
        })


        val btnFab = view.findViewById<FloatingActionButton>(R.id.flbSpecie)
        btnFab.setOnClickListener{
            val dialog = SpecieDialogFragment()
            dialog.fatherFragment = this
            dialog.show(parentFragmentManager,"Add Specie")
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SpeciesDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}