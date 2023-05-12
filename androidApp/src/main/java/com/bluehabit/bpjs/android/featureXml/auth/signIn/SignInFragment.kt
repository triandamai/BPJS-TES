/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.featureXml.auth.signIn

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.bluehabit.bpjs.android.R
import com.bluehabit.bpjs.android.base.BaseFragment
import com.bluehabit.bpjs.android.databinding.FragmentSigninBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class SignInFragment : BaseFragment<FragmentSigninBinding>() {
    private val viewModel by viewModels<SignInViewModel>()
    override fun binding(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?)
            : FragmentSigninBinding = FragmentSigninBinding.inflate(
        inflater,
        container,
        false
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setBinding(
            binding(
                inflater, container, savedInstanceState
            )
        )

        binding.btnSignIn.setOnClickListener {

            viewModel.signIn(
                binding.etEmail.text.toString(),
                binding.etPassword.text.toString()
            ) { success, message ->
                if (success) {
                    findNavController().navigate(R.id.navigation_home)
                }
            }
        }
        return binding.root
    }


}