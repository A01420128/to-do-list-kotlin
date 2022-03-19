package com.example.todolist.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.todolist.R
import com.example.todolist.data.Task
import com.example.todolist.databinding.FragmentCapturaBinding
import java.text.SimpleDateFormat
import java.util.*

/**
 * A simple [Fragment] subclass.
 * Use the [CapturaFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CapturaFragment : Fragment() {

    private lateinit var binding: FragmentCapturaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCapturaBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val nameUser = arguments?.getString("name")
        binding.textView3.text = "${nameUser}'s To Do List"

        binding.btnCapture.setOnClickListener {
            val name = binding.inputTaskName.text.toString()
            val desc = binding.inputTaskDescription.text.toString()
            val priority = binding.inputTaskPriority.text.toString().toInt()
            val timeStamp: String = SimpleDateFormat("yyyyMMdd_HHmmss").format(Date())
            val task = Task(name, desc, priority, timeStamp)
            val action = CapturaFragmentDirections.actionCapturaFragmentToListaFragment(task)
            findNavController().navigate(action)
        }
    }

}