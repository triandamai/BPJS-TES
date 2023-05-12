/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.programInformation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.base.BaseFragment
import com.bluehabit.bpjs.android.databinding.FragmentInformationBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProgramInformationFragment : BaseFragment<FragmentInformationBinding>() {
    private val viewModel by viewModels<ProgramInformationViewModel>()
    private val informationAdapter = InformationAdapter()

    override fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): FragmentInformationBinding = FragmentInformationBinding
        .inflate(inflater, container, false)


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        setBinding(
            binding(
                inflater,
                container,
                savedInstanceState
            )
        )
        binding.toolbar.setNavigationIcon(R.drawable.arrow_long_left)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        setupProgram()
        return binding.root
    }

    private fun setupProgram() = with(binding) {
        rvInformation.adapter = informationAdapter
        rvInformation.layoutManager = LinearLayoutManager(
            requireContext(),
            RecyclerView.VERTICAL,
            false
        )
        lifecycleScope.launch {
            viewModel.program.collect {
                informationAdapter.updateData(it)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        clearBinding()
    }
}