package com.example.animalkingdom.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.example.animalkingdom.R
import androidx.navigation.fragment.findNavController


/**
 * A simple [Fragment] subclass.
 * Use the [DashboardFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class DashboardFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_dashboard, container, false)

        val animalBtn:Button = view.findViewById(R.id.animalBtn)
        val speciesBtn:Button = view.findViewById(R.id.speciesBtn)
         animalBtn.setOnClickListener{
           findNavController().navigate(R.id.action_dashboardFragment_to_animalDetailsFragment2)
        }
        speciesBtn.setOnClickListener{
            findNavController().navigate(R.id.action_dashboardFragment_to_speciesDetailsFragment2)
        }

        return  view
    }



}