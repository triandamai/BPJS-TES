/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.dashboard.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bluehabit.bpjs.android.databinding.ItemProgramBinding
import com.bluehabit.bpjs.android.databinding.ItemServicesBinding
import com.bluehabit.bpjs.data.model.HomeModel
import com.bluehabit.bpjs.data.model.RV_ITEM_TYPE


class HomeServicesViewHolder(val view: ItemServicesBinding) : RecyclerView.ViewHolder(view.root) {}
class HomeProgramViewHolder(val view: ItemProgramBinding) : RecyclerView.ViewHolder(view.root) {}
class HomeAdapter() : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    var items: List<HomeModel> = listOf()

    override fun getItemViewType(position: Int): Int {
        return when (items[position].type) {
            RV_ITEM_TYPE.PROGRAM -> 1
            RV_ITEM_TYPE.OTHER_SERVICES -> 2
            RV_ITEM_TYPE.OTHER -> 3
            else -> super.getItemViewType(position)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            1 -> HomeProgramViewHolder(
                ItemProgramBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            2 -> HomeServicesViewHolder(
                ItemServicesBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )

            else -> HomeProgramViewHolder(
                ItemProgramBinding.inflate(
                    LayoutInflater.from(parent.context),
                    parent,
                    false
                )
            )
        }
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = items[position]

        when (data.type) {
            RV_ITEM_TYPE.PROGRAM -> {

            }

            RV_ITEM_TYPE.OTHER_SERVICES -> {

            }

            RV_ITEM_TYPE.OTHER -> {

            }
        }
    }
}