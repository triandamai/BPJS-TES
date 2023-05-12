/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.dashboard.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.bluehabit.bpjs.android.databinding.ItemProgramBinding
import com.bluehabit.bpjs.data.model.Program


class HomeProgramViewHolder(val view: ItemProgramBinding) : RecyclerView.ViewHolder(view.root) {

    fun bind(data: Program) = with(view) {
        lyParent.setOnClickListener { }
        ivAvailable.isVisible = data.available
        tvName.text = data.title
        ivIcon.setImageResource(data.icon)
        tvSubtitle.text = if (data.available) "Anda Sudah terdaftar di layanan ini" else
            "Anda belum terdaftra di layanan ini"
    }
}

class HomeProgramAdapter() : RecyclerView.Adapter<HomeProgramViewHolder>() {
    private var items: List<Program> = listOf()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeProgramViewHolder =
        HomeProgramViewHolder(
            ItemProgramBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HomeProgramViewHolder, position: Int) {
        val data = items[position]

        holder.bind(data)

    }

    fun updateDate(data: List<Program>) {
        items = data
        notifyDataSetChanged()
    }
}