/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.detailProgram.tabContentFragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bluehabit.bpjs.android.databinding.ItemDetailsBinding

class DetailViewHolder(val view: ItemDetailsBinding) : RecyclerView.ViewHolder(view.root) {
    fun bind(data: String) = with(view) {
        tvName.text = data
    }

}

class DetailAdapter() : RecyclerView.Adapter<DetailViewHolder>() {
    private var items: List<String> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DetailViewHolder =
        DetailViewHolder(
            ItemDetailsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DetailViewHolder, position: Int) {
        val data = items[position]
        holder.bind(data)
    }

    fun updateData(data: List<String>) {
        items = data
        notifyDataSetChanged()
    }

}