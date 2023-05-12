/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.dashboard.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.databinding.ItemProgramBinding
import com.bluehabit.bpjs.android.databinding.ItemServicesBinding
import com.bluehabit.bpjs.data.model.HomeModel
import com.bluehabit.bpjs.data.model.RV_ITEM_TYPE
import com.bluehabit.bpjs.data.model.Service


class HomeServicesViewHolder(val view: ItemServicesBinding) : ViewHolder(view.root) {
    fun bind(data: Service) = with(view) {
        lyParent.setOnClickListener {
            it.findNavController().navigate(R.id.navigation_information)
        }
        tvTitle.text = data.serviceName
        ivIcon.setImageResource(data.serviceIcon)
    }
}

class HomeServicesAdapter() : RecyclerView.Adapter<HomeServicesViewHolder>() {
    var items: List<Service> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeServicesViewHolder =
        HomeServicesViewHolder(
            ItemServicesBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )


    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: HomeServicesViewHolder, position: Int) {
        val data = items[position]
        holder.bind(data)
    }

    fun updateDate(data: List<Service>) {
        items = data
        notifyDataSetChanged()
    }
}