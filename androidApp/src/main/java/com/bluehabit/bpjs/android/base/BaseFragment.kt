/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment

abstract class BaseFragment< Binding> : Fragment() {
    private var _binding: Binding? = null


    // This property is only valid between onCreateView and
    // onDestroyView.
    val binding get() = _binding!!

    abstract fun binding(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): Binding

    fun clearBinding() {
        _binding = null
    }

    fun setBinding(binding: Binding) {
        _binding = binding
    }
}