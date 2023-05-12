/*
 * Copyright © 2023 Blue Habit.
 *
 * Unauthorized copying, publishing of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 */

package com.bluehabit.bpjs.android

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bluehabit.bpjs.android.databinding.ActivityXmlBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class XmlActivity : AppCompatActivity() {

    private lateinit var binding: ActivityXmlBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityXmlBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_xml)
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { nav, des, arg ->
            navView.isVisible = des.id in setOf(
                R.id.navigation_home,
                R.id.navigation_news,
                R.id.navigation_digital_card,
                R.id.navigation_profile
            )
        }
    }
}