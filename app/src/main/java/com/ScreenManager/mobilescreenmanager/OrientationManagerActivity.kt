package com.ScreenManager.mobilescreenmanager

import android.content.Intent
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.provider.Settings
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.ScreenManager.mobilescreenmanager.adapter.CardPagerAdapter
import com.ScreenManager.mobilescreenmanager.databinding.ActivityOrientationManagerBinding
import com.ScreenManager.mobilescreenmanager.service.ScreenManagerService
import com.google.android.material.tabs.TabLayoutMediator

class OrientationManagerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOrientationManagerBinding
    private lateinit var pagerAdapter: CardPagerAdapter
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOrientationManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        
        setupToolbar()
        setupViewPager()
        setupTabLayout()
        startScreenManagerService()
    }
    
    private fun setupToolbar() {
        setSupportActionBar(binding.topAppBar)
        binding.topAppBar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.settings -> {
                    // Implementar navegação para configurações
                    true
                }
                else -> false
            }
        }
    }
    
    private fun setupViewPager() {
        pagerAdapter = CardPagerAdapter(
            onNextClick = {
                binding.viewPager.currentItem = 1
            },
            onOrientationChange = { isAutoRotate, radioButtonId ->
                handleOrientationChange(isAutoRotate, radioButtonId)
            }
        )
        
        binding.viewPager.apply {
            adapter = pagerAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            isUserInputEnabled = true
        }
    }
    
    private fun setupTabLayout() {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            // Configuração dos indicadores de página
        }.attach()
    }
    
    private fun handleOrientationChange(isAutoRotate: Boolean, radioButtonId: Int) {
        val intent = Intent(this, ScreenManagerService::class.java).apply {
            action = ScreenManagerService.ACTION_CHANGE_ORIENTATION
            putExtra(ScreenManagerService.EXTRA_AUTO_ROTATE, isAutoRotate)
            if (!isAutoRotate) {
                val orientation = when (radioButtonId) {
                    R.id.portraitRadio -> ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                    R.id.landscapeRadio -> ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                    else -> ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
                }
                putExtra(ScreenManagerService.EXTRA_ORIENTATION, orientation)
            }
        }
        startService(intent)
        
        // Atualiza a interface
        if (isAutoRotate) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_SENSOR
            Toast.makeText(this, "Rotação automática ativada", Toast.LENGTH_SHORT).show()
        } else {
            val newOrientation = when (radioButtonId) {
                R.id.portraitRadio -> ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
                R.id.landscapeRadio -> ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
                else -> ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED
            }
            requestedOrientation = newOrientation
            Toast.makeText(this, "Orientação alterada", Toast.LENGTH_SHORT).show()
        }
    }
    
    private fun startScreenManagerService() {
        val intent = Intent(this, ScreenManagerService::class.java)
        startService(intent)
    }
    
    override fun onDestroy() {
        super.onDestroy()
        // O serviço continuará rodando em background
    }
} 