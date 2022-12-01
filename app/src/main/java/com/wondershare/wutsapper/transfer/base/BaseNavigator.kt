package com.wondershare.wutsapper.transfer.base

interface BaseNavigator {
    fun showToast(msg: String)

    fun showSnackbar(title: String, msg: String, action: String? = null)

    fun showSnackbarWithAction()

    fun hideSnackbar()

    fun hideKeyboard()

}