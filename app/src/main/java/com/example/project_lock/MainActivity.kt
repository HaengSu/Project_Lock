package com.example.project_lock

import android.app.ActivityManager
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.project_lock.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private val TAG: String = "로그"
    private lateinit var binding: ActivityMainBinding
    private lateinit var decorView: View
    private var uiOption: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        decorView = window.decorView
        uiOption = window.decorView.systemUiVisibility
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) uiOption =
            uiOption or View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) uiOption =
            uiOption or View.SYSTEM_UI_FLAG_FULLSCREEN
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) uiOption =
            uiOption or View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY

        decorView.setSystemUiVisibility(uiOption)

        binding.imLocker.setOnClickListener { v ->

            if (binding.imLocker.isSelected) {
                binding.imLocker.isSelected = !binding.imLocker.isSelected
            } else {
                binding.imLocker.isSelected = !binding.imLocker.isSelected
                packageManager.clearPackagePreferredActivities(packageName)
            }
        }
    }

        override fun onPause() {
        super.onPause()
        val activity : ActivityManager = applicationContext.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        activity.moveTaskToFront(taskId,0)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        Log.i(TAG, "onKeyDown: keyCode = ${keyCode}")
        when (keyCode) {
            KeyEvent.KEYCODE_BACK -> {
                Log.i(TAG, "onKeyDown: 취소키 눌림")
                return false
            }
        }
        return super.onKeyDown(keyCode, event)
    }

}



















