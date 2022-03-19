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


/**
 * A simple [Fragment] subclass.
 * Use the [ListaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val task = arguments?.getParcelable<Task>("task")
        Log.v("time", task!!.timestamp)
        val message = "Task created: name: ${task!!.name}, description: ${task.description}, priority: ${task.priority}, timestamp: ${task.timestamp}"
        Toast.makeText(view.context, message,Toast.LENGTH_LONG).show()

        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)

        val tasksAdapter = TasksAdapter(TasksDataProvider.getData()) {
            // TODO: Do something when item clicked
        }
        recyclerView.adapter = tasksAdapter

    }

}