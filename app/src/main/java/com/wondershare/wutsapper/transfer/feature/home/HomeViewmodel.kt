package com.wondershare.wutsapper.transfer.feature.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewmodel : ViewModel() {

    var dropOrDown = MutableLiveData<Boolean>()
    var menuId = MutableLiveData<Int>()

    init {
        dropOrDown.postValue(false)
        menuId.postValue(1)
    }
}