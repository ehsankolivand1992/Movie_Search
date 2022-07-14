package com.sprout.movieslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sprout.baseui.BaseFragment
import com.sprout.movieslist.databinding.FragmentMovieListBinding


class MovieListFragment : BaseFragment<FragmentMovieListBinding>() {


    override fun setBinding() = FragmentMovieListBinding.inflate(layoutInflater)


}