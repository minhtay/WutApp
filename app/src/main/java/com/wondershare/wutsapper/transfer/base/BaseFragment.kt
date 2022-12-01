package com.wondershare.wutsapper.transfer.base

import android.view.View
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment

abstract class BaseFragment<V : ViewDataBinding, VM : BaseViewmodel<*>> : Fragment(),
    BaseNavigator {

    var baseActivity: BaseActivity<*, *>? = null
    val rootView: View? = null
    var viewDataBinding: V? = null
    var mViewmodel: VM? = null

    /**
     * Override for set binding variable
     *
     * @return variable id
     */
    abstract val bindingVariable: Int

    /**
     * @return layout resource id
     */
    @get:LayoutRes
    abstract val layoutId: Int

    /**
     * Override for set view model
     *
     * @return view model instance
     */
    abstract val viewModel: VM

    interface Callback {
        fun onFragmentAttached()

        fun onFragmentDetached(tag: String)
    }
}