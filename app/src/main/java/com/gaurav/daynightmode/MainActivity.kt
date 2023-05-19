package com.gaurav.daynightmode

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import com.gaurav.daynightmode.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private var editor : SharedPreferences.Editor?=null
    private var sharedPreferences: SharedPreferences?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        sharedPreferences = getSharedPreferences("MODE", Context.MODE_PRIVATE)
        var nigthMode = sharedPreferences?.getBoolean("nigth", false)!!
        if (nigthMode)
        {
            binding.sthDarkmodeandLightmodeButton.isChecked=true
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }
        binding.sthDarkmodeandLightmodeButton.setOnCheckedChangeListener { compoundButton, state ->
            if (nigthMode) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                editor = sharedPreferences?.edit()
                editor?.putBoolean("nigth", false)
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                editor = sharedPreferences?.edit()
                editor?.putBoolean("nigth", true)
            }
            editor?.apply()

        }
    }

}