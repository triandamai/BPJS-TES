/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.splash

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.base.BaseFragment
import com.bluehabit.bpjs.android.databinding.FragmentSplashBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashFragment : BaseFragment<FragmentSplashBinding>() {


    private val viewModel by viewModels<SplashViewModel>()
    override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): FragmentSplashBinding =
        FragmentSplashBinding.inflate(inflater, container, false)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBinding(binding(inflater, container, savedInstanceState))
        requireActivity().actionBar?.hide()
        findNavController().navigate(R.id.navigation_signin)
        return binding.root
    }


}