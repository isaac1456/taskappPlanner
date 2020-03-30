package com.example.taskappplaner.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.taskappplaner.R
import com.example.taskappplaner.model.modelTask
import kotlinx.android.synthetic.main.fragment_first.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class TaskListFragment : Fragment() {
    private val viewModel: taskViewModel by sharedViewModel()
    private val TaskAdapter = taskAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        taskRecyclerView()
    }

    private fun taskRecyclerView() {
        taskRecycleer.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = TaskAdapter
        }
        updateListAdapterTask()
    }

    private fun updateListAdapterTask() {
        val observer = Observer<List<modelTask>> {
            TaskAdapter.updateTasks(it)
        }
        viewModel.taskRepo.taskD.getAllTask().observe(activity!!, observer)
    }
}