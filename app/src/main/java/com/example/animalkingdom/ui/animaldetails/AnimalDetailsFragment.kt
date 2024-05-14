package com.example.animalkingdom.ui.animaldetails


import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.animalkingdom.R
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.example.animalkingdom.data.database.AppDatabase
import com.example.animalkingdom.data.model.Animal
import com.example.animalkingdom.ui.BaseFragment.BaseFragment
import com.example.animalkingdom.ui.Helper.toast
import com.example.animalkingdom.ui.animalsdetails.AnimalsDetailsViewModel
import com.miu.mdp.animalkingdomexplorer.ui.animalsdetails.AnimalListAdapter
import kotlinx.coroutines.launch


class AnimalDetailsFragment() : BaseFragment() {

    private lateinit var viewModel: AnimalsDetailsViewModel
    private lateinit var recyclerView: RecyclerView
    private lateinit var animalViewModel: AnimalsDetailsViewModel
    //private lateinit var animalRepository: AnimalRepository
    override fun <T> addItem(item: T) {
        launch {
            /* NoteDatabase needs an context argument, if it is not null
            let perform add or update query
            */
            context?.let {
                  animalViewModel.insert(item as Animal)
                it.toast("Animal Added")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_animal_details2, container, false)
       
        recyclerView = view.findViewById(R.id.animal_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = AnimalListAdapter()
        recyclerView.adapter = adapter
        animalViewModel = ViewModelProvider(this).get(AnimalsDetailsViewModel::class.java)
        animalViewModel.allAnimals.observe(viewLifecycleOwner, Observer { animals ->
            animals?.let { adapter.submitList(it) }
        })


        val btnFab = view.findViewById<FloatingActionButton>(R.id.flbAnimal)
        btnFab.setOnClickListener{
            val dialog = AnimalDialogFragment()
            dialog.fatherFragment = this
            dialog.show(parentFragmentManager,"Add Animal")
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(AnimalsDetailsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}