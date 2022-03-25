package com.example.todolist.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.MainActivity
import com.example.todolist.R
import com.example.todolist.adapter.TasksAdapter
import com.example.todolist.data.Task
import com.example.todolist.data.TasksDataProvider
import com.example.todolist.databinding.FragmentListaBinding


/**
 * A simple [Fragment] subclass.
 * Use the [ListaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaFragment : Fragment() {

    private lateinit var binding: FragmentListaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val task = arguments?.getParcelable<Task>("task")
        Log.v("time", task!!.timestamp)
        val message = "Task created: name: ${task!!.name}, description: ${task.description}, priority: ${task.priority}, timestamp: ${task.timestamp}"
        Toast.makeText(view.context, message,Toast.LENGTH_LONG).show()

        val recyclerView: RecyclerView = binding.recyclerView

        val tasksAdapter = TasksAdapter(TasksDataProvider.getData())

        tasksAdapter.setOnItemClickListener(object: TasksAdapter.ClickListener {
            override fun onItemClick(view: View, position: Int) {
                Toast.makeText(context, tasksAdapter.getData(position).toString(), Toast.LENGTH_LONG).show()
            }
        })

        recyclerView.adapter = tasksAdapter

    }

}