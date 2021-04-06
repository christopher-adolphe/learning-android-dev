package com.example.android.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.android.todoapp.databinding.FragmentToDoDetailBinding

class ToDoDetail : Fragment() {
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentToDoDetailBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do_detail, container, false)

        viewModel.selectedItem.observe(viewLifecycleOwner, Observer { toDo ->
            // Perform an action with the latest item data
            binding.toDoTitleText.text = toDo.title
            binding.toDoDescText.text = toDo.description
        })

        // Inflate the layout for this fragment
        return binding.root
    }
}