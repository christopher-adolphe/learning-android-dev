package com.example.android.todoapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.fragment.app.activityViewModels
import androidx.navigation.findNavController
import com.example.android.todoapp.databinding.FragmentToDoListBinding

class ToDoList : Fragment() {
    private val toDos: List<ToDo> = listOf(
        ToDo("To Do 1", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Nulla facilisi nullam vehicula ipsum. Mattis molestie a iaculis at erat pellentesque. Elit eget gravida cum sociis natoque penatibus et. Tellus orci ac auctor augue mauris augue neque gravida in."),
        ToDo("To Do 2", "Nisi quis eleifend quam adipiscing vitae. Molestie ac feugiat sed lectus. Dignissim convallis aenean et tortor at risus. Volutpat est velit egestas dui id ornare arcu odio. Donec enim diam vulputate ut. Amet tellus cras adipiscing enim eu turpis egestas pretium. "),
        ToDo("To Do 3", "Suspendisse potenti nullam ac tortor. Habitasse platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper. Facilisi cras fermentum odio eu feugiat pretium nibh ipsum. Quam id leo in vitae turpis massa sed. Etiam non quam lacus suspendisse faucibus interdum posuere lorem ipsum."),
        ToDo("To Do 4", "Mauris in aliquam sem fringilla ut morbi. Sit amet nulla facilisi morbi tempus iaculis urna id volutpat. Nunc eget lorem dolor sed viverra ipsum nunc aliquet bibendum. Aliquet bibendum enim facilisis gravida neque. Donec et odio pellentesque diam."),
        ToDo("To Do 5", "Posuere lorem ipsum dolor sit amet consectetur adipiscing elit duis. Felis bibendum ut tristique et. Ipsum faucibus vitae aliquet nec ullamcorper sit amet risus. Sed vulputate mi sit amet mauris commodo."),
        ToDo("To Do 6", "Tempor nec feugiat nisl pretium. Sit amet consectetur adipiscing elit duis. Amet venenatis urna cursus eget. Dignissim convallis aenean et tortor at risus viverra adipiscing at. Placerat in egestas erat imperdiet. Facilisi cras fermentum odio eu feugiat pretium."),
        ToDo("To Do 7", "Id aliquet lectus proin nibh nisl condimentum id. In ornare quam viverra orci sagittis eu volutpat. Mauris vitae ultricies leo integer. Ac placerat vestibulum lectus mauris. Diam in arcu cursus euismod quis viverra nibh. Sit amet justo donec enim diam vulputate."),
        ToDo("To Do 8", "Leo duis ut diam quam nulla. Lectus urna duis convallis convallis tellus id interdum velit. Eget magna fermentum iaculis eu non diam phasellus. Sodales ut etiam sit amet nisl purus in mollis nunc. At risus viverra adipiscing at in. Morbi blandit cursus risus at. Commodo odio aenean sed adipiscing diam."),
        ToDo("To Do 9", "Fames ac turpis egestas maecenas pharetra convallis posuere. Elit ut aliquam purus sit amet. Sodales ut eu sem integer. Vestibulum rhoncus est pellentesque elit. In massa tempor nec feugiat nisl. Morbi tincidunt ornare massa eget. Purus sit amet volutpat consequat mauris nunc congue nisi."),
        ToDo("To Do 10", "Consectetur adipiscing elit ut aliquam. Sit amet justo donec enim diam vulputate ut pharetra. Orci eu lobortis elementum nibh tellus molestie nunc. Vulputate ut pharetra sit amet aliquam id diam maecenas. Quam pellentesque nec nam aliquam."),
        ToDo("To Do 11", "Tortor at auctor urna nunc. Odio pellentesque diam volutpat commodo sed. Sit amet est placerat in egestas. Quis ipsum suspendisse ultrices gravida dictum fusce. Ut sem viverra aliquet eget sit amet. Nec feugiat in fermentum posuere."),
        ToDo("To Do 12", "Urna condimentum mattis pellentesque id nibh tortor. Ipsum consequat nisl vel pretium lectus quam id leo. Varius morbi enim nunc faucibus a. Laoreet non curabitur gravida arcu. Arcu dui vivamus arcu felis. Consequat ac felis donec et odio pellentesque."),
        ToDo("To Do 13", "Tempor nec feugiat nisl pretium fusce id velit. Dignissim enim sit amet venenatis. Pharetra convallis posuere morbi leo urna molestie at. Ipsum dolor sit amet consectetur. "),
        ToDo("To Do 14", "Molestie ac feugiat sed lectus vestibulum mattis. Sed libero enim sed faucibus turpis in eu. Proin gravida hendrerit lectus a. Sed vulputate mi sit amet mauris commodo quis imperdiet massa. Tincidunt nunc pulvinar sapien et."),
        ToDo("To Do 15", "Morbi leo urna molestie at elementum eu facilisis sed odio. Eget nullam non nisi est sit amet facilisis magna. Eget magna fermentum iaculis eu non diam phasellus vestibulum. Leo duis ut diam quam nulla porttitor massa.")
    )
    private val viewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentToDoListBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_to_do_list, container, false)

        val toDoListview: ListView = binding.todoListView

        val toDoTitles: List<String> = toDos.map { it.title }

        val arrayAdapter = ArrayAdapter<String>(container!!.context, android.R.layout.simple_list_item_1, toDoTitles)

        toDoListview.adapter = arrayAdapter

        toDoListview.setOnItemClickListener { _, view, position, _ ->
            viewModel.selectItem(toDos[position])
            view.findNavController().navigate(R.id.action_toDoList_to_toDoDetail)
        }

        // Inflate the layout for this fragment
        return binding.root
    }
}