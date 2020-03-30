package com.example.taskappplaner.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.taskappplaner.R
import com.example.taskappplaner.model.modelTask

class taskAdapter : RecyclerView.Adapter<taskAdapter.taskViewHolder>() {
    private var tasksList: List<modelTask> = ArrayList()

    class taskViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var name: TextView? = null
        var description: TextView? = null

        init {
            name = view.findViewById(R.id.name)
            description = view.findViewById(R.id.description)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): taskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.task_row,
            parent,
            false
        )
        return taskViewHolder(view)
    }

    override fun getItemCount(): Int {
        return tasksList.size
    }

    override fun onBindViewHolder(holdertask: taskViewHolder, position: Int) {
        val task = tasksList[position]
        holdertask.name!!.text = task.name
        holdertask.description!!.text = task.Description
    }

    fun updateTasks(tasksList: List<modelTask>) {
        this.tasksList = tasksList
        notifyDataSetChanged()
    }
}
