/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.dashboard.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluehabit.bpjs.android.base.BaseFragment
import com.bluehabit.bpjs.android.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    private val viewModel by viewModels<HomeViewModel>()
    private val programAdapter = HomeProgramAdapter()
    private val servicesAdapter = HomeServicesAdapter()
    override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentHomeBinding =
        FragmentHomeBinding.inflate(
            inflater,
            container,
            false
        )


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBinding(binding(inflater, container, savedInstanceState))
        val root: View = binding.root


        setupProgram()
        setupServices()
        return root
    }

    private fun setupProgram() = with(binding) {
        rvProgram.adapter = programAdapter
        rvProgram.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL,
            false
        )
        lifecycleScope.launch {
            viewModel.program.collect {
                programAdapter.updateDate(it)
            }
        }
    }

    fun setupServices() = with(binding) {
        rvServices.adapter = servicesAdapter
        rvServices.layoutManager = GridLayoutManager(
            requireContext(),
            4,
            RecyclerView.VERTICAL,
            false
        )

        lifecycleScope.launch {
            viewModel.services.collect {
                servicesAdapter.updateDate(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }
}