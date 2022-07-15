package com.sprout.moviesearch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import androidx.lifecycle.lifecycleScope
import com.sprout.baseui.BaseActivity
import com.sprout.baseui.customlistinner.LoadingDialog
import com.sprout.moviesearch.databinding.ActivityMainBinding


@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(),LoadingDialog {
    private val viewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun setBinding() = ActivityMainBinding.inflate(layoutInflater)

    override fun showDialog(progress: Boolean) {

        if (progress)
        {
            binding.loadingDialog.visibility = View.VISIBLE
        }else {
            binding.loadingDialog.visibility = View.GONE

        }

    }
}