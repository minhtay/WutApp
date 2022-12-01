package com.wondershare.wutsapper.transfer.feature.main


import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.ViewModelProvider
import com.wondershare.wutsapper.transfer.BR
import com.wondershare.wutsapper.transfer.R
import com.wondershare.wutsapper.transfer.base.BaseActivity
import com.wondershare.wutsapper.transfer.databinding.ActivityHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity() : BaseActivity<ActivityHomeBinding, HomeViewmodel>() {

        @Inject lateinit var mViewModelFactory: ViewModelProvider.Factory
    private lateinit var binding: ActivityHomeBinding

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.activity_home

    override val viewmodel: HomeViewmodel
        get() = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(HomeViewmodel::class.java)

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = viewDataBinding!!
        binding.btnChooseApp.setOnClickListener { clickChooseApp() }

    }

    private fun initview() {
        if()
    }

    private fun clickChooseApp() {
        TODO("Not yet implemented")
    }

    override fun onFragmentAttached() {
    }

    override fun onFragmentDetached(tag: String) {
    }

    override fun cancel() {
    }

    override fun dismiss() {
    }

}