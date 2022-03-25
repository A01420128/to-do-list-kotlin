package com.example.todolist.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.todolist.R
import com.example.todolist.data.Task

class TasksAdapter (private val list: List<Task>) :
    RecyclerView.Adapter<TasksAdapter.TasksViewHolder>() {

    private var clickListener: ClickListener? = null

    fun setOnItemClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    interface ClickListener {
        fun onItemClick(view: View, position: Int)
    }


    inner class TasksViewHolder(view: View): RecyclerView.ViewHolder(view), View.OnClickListener {
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

        override fun onClick(view: View?) {
            if (view != null) {
                clickListener?.onItemClick(view, bindingAdapterPosition)
            }
        }
    }

    // Builds but doesnt give data to grafic elements.
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TasksViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: TasksViewHolder, position: Int) {
        val task = list[position]
        holder.bind(task)
    }

    override fun getItemCount() = list.size

    fun getData(position: Int): Task {
        return list[position]
    }
}
