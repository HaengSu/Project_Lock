package com.example.project_lock

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.project_lock.databinding.ActivitySubBinding

//t
class ActivitySub : AppCompatActivity(){
    private val TAG = "로그"
    private lateinit var binding : ActivitySubBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        setContentView(binding.root)
        packageManager.clearPackagePreferredActivities(packageName)

        val intent = Intent()
        intent.action = Intent.ACTION_MAIN
        intent.addCategory(Intent.CATEGORY_HOME)
        startActivity(intent)
    }

    override fun onPause() {
        super.onPause()
        packageManager.clearPackagePreferredActivities(packageName)
    }
}