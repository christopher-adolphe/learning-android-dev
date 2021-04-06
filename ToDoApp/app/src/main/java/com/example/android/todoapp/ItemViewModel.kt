package com.example.android.todoapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ItemViewModel : ViewModel() {
    private val mutableSelectedItem = MutableLiveData<ToDo>()
    val selectedItem: LiveData<ToDo> get() = mutableSelectedItem

    fun selectItem(item: ToDo) {
        mutableSelectedItem.value = item
    }
}