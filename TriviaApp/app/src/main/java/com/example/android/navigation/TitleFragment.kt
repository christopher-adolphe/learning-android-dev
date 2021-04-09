package com.example.android.navigation

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.android.navigation.databinding.FragmentTitleBinding

/**
 * A simple [Fragment] subclass.
 * Use the [TitleFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class TitleFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)

        // Opt. 1: Getting an instance of the navigation controller to create the navigation
         binding.playButton.setOnClickListener { view: View ->
             view.findNavController().navigate(TitleFragmentDirections.actionTitleFragmentToGameFragment())
         }

        // Opt. 2: Using Navigation to create the navigation
        // binding.playButton.setOnClickListener(
                // Navigation.createNavigateOnClickListener(R.id.action_titleFragment_to_gameFragment)
        // )

        // Setting setHasOptionsMenu to true to indicate Android that the fragment has an overflow menu
        setHasOptionsMenu(true)

        return binding.root
    }

    // Overriding the onCreateOptionsMenu method to indicate Android the menu we want to inflate
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)

        inflater.inflate(R.menu.overflow_menu, menu)
    }

    // Overriding the onOptionsItemSelected method to navigate to the specified fragment when an item is selected from the menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item, view!!.findNavController()) ||
                super.onOptionsItemSelected(item)
    }
}