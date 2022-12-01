package com.wondershare.wutsapper.transfer.base

interface BaseNavigator {
    fun showToast(msg: String)

    fun showSnackbar()

    fun showSnackbarWithAction()

    fun hideSnackbar()

    fun hideKeyboard()

}