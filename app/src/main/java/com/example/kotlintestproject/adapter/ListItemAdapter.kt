package com.example.kotlintestproject.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintestproject.databinding.CardItemBinding
import com.example.kotlintestproject.helper.OnDeleteClickListener
import com.example.kotlintestproject.model.ListItemModel

class ListItemAdapter : ListAdapter<ListItemModel, ListItemAdapter.ListViewHolder>(COMPARATOR), OnDeleteClickListener {



    object COMPARATOR : DiffUtil.ItemCallback<ListItemModel>() {
        override fun areItemsTheSame(oldItem: ListItemModel, newItem: ListItemModel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: ListItemModel, newItem: ListItemModel): Boolean {
            return oldItem.id == newItem.id
        }

    }
    class ListViewHolder(private val binding: CardItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListItemModel, onDeleteClickListener: OnDeleteClickListener) {
            binding.apply {
                itemNameTv.text = item.name
                itemPriceTv.text = item.price
                itemAmount.text = item.quantity.toString()

                add.setOnClickListener {
                    val amount: Int = item.quantity.plus(1)
                    itemAmount.text = amount.toString()
                    item.quantity = amount
                }

                minus.setOnClickListener {
                    if (item.quantity > 0) {
                        val amount: Int = item.quantity.minus(1)
                        itemAmount.text = amount.toString()
                        item.quantity = amount
                    }
                }

                deleteItemIv.setOnClickListener {
                    onDeleteClickListener.onDeleteClick(item)
                }
            }
        }
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        return ListViewHolder(CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false ))
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val item = getItem(position)

        holder.itemView.setOnClickListener {
           // getItem(position)
        }
        holder.bind(item, this)

    }

    override fun onDeleteClick(item: ListItemModel) {
        val position = currentList.indexOf(item)
        if (position != RecyclerView.NO_POSITION) {
            notifyItemRemoved(position)
        }
    }

}