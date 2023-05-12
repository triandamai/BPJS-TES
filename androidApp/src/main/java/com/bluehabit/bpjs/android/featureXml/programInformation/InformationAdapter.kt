/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.programInformation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.databinding.ItemProgramInformationBinding
import com.bluehabit.bpjs.data.model.Program

class InformationViewHolder(val view: ItemProgramInformationBinding) : RecyclerView.ViewHolder(view.root) {
    fun bind(data: Program) = with(view) {
        lyParent.setOnClickListener {
            it.findNavController().navigate(
                R.id.navigation_detail_program,
                bundleOf(
                    "ID" to data.id
                )
            )
        }
        tvName.text = data.title
    }

}

class InformationAdapter() : RecyclerView.Adapter<InformationViewHolder>() {
    private var items: List<Program> = listOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): InformationViewHolder =
        InformationViewHolder(
            ItemProgramInformationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: InformationViewHolder, position: Int) {
        val data = items[position]

        holder.bind(data)
    }

    fun updateData(data: List<Program>) {
        items = data
    }
}