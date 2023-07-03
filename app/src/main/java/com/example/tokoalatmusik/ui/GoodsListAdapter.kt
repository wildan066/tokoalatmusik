package com.example.tokoalatmusik.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.tokoalatmusik.R
import com.example.tokoalatmusik.model.Goods

class GoodsListAdapter(
    private val onItemClickListener: (Goods) -> Unit
): ListAdapter<Goods, GoodsListAdapter.goodsViewHolder>(WORD_COMPARATION) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): goodsViewHolder {
        return goodsViewHolder.create(parent)
    }
    override fun onBindViewHolder(holder: goodsViewHolder, position: Int) {
        val goods = getItem(position)
        holder.bind(goods)
        holder.itemView.setOnClickListener {
            onItemClickListener(goods)
        }
    }

    class goodsViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val nameTextView: TextView = itemView.findViewById(R.id.nameTextView)
        private val addressTextView: TextView = itemView.findViewById(R.id.addressTextView)
        private val jenisTextView: TextView = itemView.findViewById(R.id.jenisTextView)

        fun bind(goods: Goods) {
            nameTextView.text = goods?.name
            addressTextView.text = goods?.address
            jenisTextView.text = goods?.jenis
        }

        companion object {
            fun create(parent: ViewGroup): goodsViewHolder {
                val view: View = LayoutInflater.from(parent.context)
                    .inflate(R. layout.item_goods, parent, false)
                return goodsViewHolder(view)

            }
        }

    }
    companion object{
        private val WORD_COMPARATION = object : DiffUtil.ItemCallback<Goods>() {
            override fun areItemsTheSame(oldItem: Goods, newItem: Goods): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Goods, newItem: Goods): Boolean {
                return oldItem.id == newItem.id
            }
        }
    }
}

private fun GoodsListAdapter.goodsViewHolder.bind(goods: Goods){}