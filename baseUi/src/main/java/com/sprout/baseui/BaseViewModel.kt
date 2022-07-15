package com.sprout.baseui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    val loading: MutableLiveData<Boolean> = MutableLiveData()
}