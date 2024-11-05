package com.example.recycleview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.recycleview.databinding.ItemDisasterBinding

typealias OnClickDisaster = (Disaster) -> Unit
class DisasterAdapter(private val listDisaster : List<Disaster>, private val onClickDisaster : OnClickDisaster)
    : RecyclerView.Adapter<DisasterAdapter.ItemDisasterViewHolder>() {

    inner class ItemDisasterViewHolder(private val binding: ItemDisasterBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(data: Disaster){
                with(binding){
                    txtDisasterName.text = data.nameDisaster
                    imgDisaster.setImageResource(data.getDisasterDrawable())
                    itemView.setOnClickListener{
                        onClickDisaster(data)
                    }
                }
            }
        // You can add methods here to bind data to the views
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemDisasterViewHolder {
        val binding = ItemDisasterBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ItemDisasterViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listDisaster.size
    }

    override fun onBindViewHolder(holder: ItemDisasterViewHolder, position: Int) {
        holder.bind(listDisaster[position])
    }

}
