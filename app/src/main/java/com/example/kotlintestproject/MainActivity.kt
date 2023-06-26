package com.example.kotlintestproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.kotlintestproject.adapter.ListItemAdapter
import com.example.kotlintestproject.databinding.ActivityMainBinding
import com.example.kotlintestproject.helper.OnDeleteClickListener
import com.example.kotlintestproject.model.ListItemModel

class MainActivity : AppCompatActivity(), OnDeleteClickListener {
    private lateinit var binding: ActivityMainBinding
    private val adapter by lazy {
        ListItemAdapter()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
    }

    private  fun setupRecyclerView() {
        binding.recyclerView.adapter = adapter
        val items = listOf(
            ListItemModel(
                "1",
                "Bifacial Module",
                "Kes 790000",
                R.drawable.ic_launcher_background,
                1
            ),
            ListItemModel(
                "2",
                "Bifacial Module 2",
                "Kes 890000",
                R.drawable.ic_launcher_foreground,
                1
            ),
            ListItemModel(
                "3",
                "Bifacial Module 3",
                "Kes 590000",
                R.drawable.ic_launcher_background,
                1
            ),
            ListItemModel(
                "4",
                "Bifacial Module 3",
                "Kes 690000",
                R.drawable.ic_launcher_foreground,
                1
            ),
            ListItemModel(
                "5",
                "Bifacial Module 4",
                "Kes 690000",
                R.drawable.ic_launcher_background,
                1
            ),
        )
        adapter.submitList(items)
    }

    override fun onDeleteClick(item: ListItemModel) {
        val position = adapter.currentList.indexOf(item)
        if (position != -1) {
            val list = adapter.currentList.toMutableList()
            list.removeAt(position)
            adapter.submitList(list)
        }
    }


}