package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.Task

class TasksAdapter (private val list: List<Task>, private val onItemClicked: (position: Int) -> Unit) :
    RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {


    class TasksViewHolder(view: View, private val onItemClicked: (position: Int) -> Unit): RecyclerView.ViewHolder(view), View.OnClickListener {
        val name: TextView = view.findViewById(R.id.rowTaskName)
        val desc: TextView = view.findViewById(R.id.rowTaskDesc)
        val prio: TextView = view.findViewById(R.id.rowTaskPri)
        val time: TextView = view.findViewById(R.id.rowTaskTim)
        fun bind(task: Task) {
            this.name.text = "Name: ${task.name}"
            this.desc.text = "Description: ${task.description}"
            this.prio.text = "Priority: ${task.priority.toString()}"
            this.time.text = "Time: ${task.timestamp}"
        }

        init {
            view.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val position = bindingAdapterPosition
            onItemClicked(position)
        }
    }

    // Builds but doesnt give data to grafic elements.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return TasksViewHolder(view, onItemClicked)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val task = list[position]
        holder.bind(task)
    }

    override fun getItemCount() = list.size
}
