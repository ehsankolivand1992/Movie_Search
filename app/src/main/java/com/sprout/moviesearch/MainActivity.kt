package com.sprout.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.lifecycleScope
import com.sprout.baseui.BaseActivity
import com.sprout.moviesearch.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setBinding() = ActivityMainBinding.inflate(layoutInflater)
}