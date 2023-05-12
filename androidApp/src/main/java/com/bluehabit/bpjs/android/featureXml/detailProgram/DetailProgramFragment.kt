/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.detailProgram

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.base.BaseFragment
import com.bluehabit.bpjs.android.databinding.FragmentDetailProgramBinding
import com.google.android.material.tabs.TabItem
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DetailProgramFragment : BaseFragment<FragmentDetailProgramBinding>() {

    private val viewModel by viewModels<DetailProgramViewModel>()
    private var adapter = DetailAdapter()

    override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentDetailProgramBinding =
        FragmentDetailProgramBinding.inflate(inflater, container, false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBinding(
            binding(
                inflater,
                container,
                savedInstanceState
            )
        )
        observeProgram()

        binding.toolbar.setNavigationIcon(R.drawable.arrow_long_left)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        val tab1 = binding.tabLayout.newTab()
        val tab2 = binding.tabLayout.newTab()
        tab1.text = "Manfaat"
        tab2.text = "Besar Iuran"

        binding.tabLayout.addTab(tab1)
        binding.tabLayout.addTab(tab2)
        binding.tabLayout.addOnTabSelectedListener(
            object : OnTabSelectedListener {
                override fun onTabSelected(tab: TabLayout.Tab?) {
                    viewModel.update(tab?.id == tab1.id)
                }

                override fun onTabUnselected(tab: TabLayout.Tab?) {

                }

                override fun onTabReselected(tab: TabLayout.Tab?) {

                }

            }
        )
        return binding.root
    }

    private fun observeProgram() = with(binding) {
        rvDetail.adapter = adapter

        lifecycleScope.launch {
            viewModel.program.collect {
                it?.let {
                    toolbar.title = it.title
                    tvNameHeader.text = it.title
                    tvSubtitleHeader.text = if (it.available) "Anda sudah terdaftar di layanan ini"
                    else "Anda belum terdaftar di layanan ini"
                    ivAvailableHeader.isVisible = it.available
                    ivIconHeader.setImageResource(it.icon)
                    adapter.updateData(if (viewModel.isBenefit) it.benefit else it.contribution)

                }
            }
        }
        lifecycleScope.launch {
            viewModel.list.collect {
                adapter.updateData(it)
            }
        }
    }


}