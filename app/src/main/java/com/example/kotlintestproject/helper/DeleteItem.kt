package com.example.kotlintestproject.helper

import com.example.kotlintestproject.model.ListItemModel

interface OnDeleteClickListener {
    fun onDeleteClick(item: ListItemModel)
}