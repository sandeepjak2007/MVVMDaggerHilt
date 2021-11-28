package com.vrajatcreations.tvshows.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.vrajatcreations.tvshows.databinding.TvShowLayoutAdapterBinding
import com.vrajatcreations.tvshows.models.TVShowItem

class TVShowAdapter : RecyclerView.Adapter<TVShowAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: TvShowLayoutAdapterBinding) :
        RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<TVShowItem>() {
        override fun areItemsTheSame(
            oldItem: TVShowItem,
            newItem: TVShowItem
        ): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(
            oldItem: TVShowItem,
            newItem: TVShowItem
        ): Boolean {
            return newItem == oldItem
        }

    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    var tvShows: List<TVShowItem>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(
            TvShowLayoutAdapterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentTVShow = tvShows[position]
        holder.binding.apply {
            textView.text = currentTVShow.name
            imageView.load(currentTVShow.image.original){
                crossfade(true)
                crossfade(1000)
            }
        }
    }

    override fun getItemCount() = tvShows.size

}