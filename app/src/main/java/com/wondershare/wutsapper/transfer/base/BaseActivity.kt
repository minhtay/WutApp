package com.wondershare.wutsapper.transfer.base

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.os.PersistableBundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.google.android.material.snackbar.Snackbar
import dagger.android.support.DaggerAppCompatActivity

abstract class BaseActivity<V : ViewDataBinding, VM : BaseViewmodel<*>> : DaggerAppCompatActivity(),
    BaseFragment.Callback, BaseNavigator, DialogInterface {

    var viewDataBinding: V? = null
    private var mViewmodel: VM? = null
    var snackbar: Snackbar? = null

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
    abstract val viewmodel: VM

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        performDataBinding()
    }

    private fun performDataBinding() {
        viewDataBinding = DataBindingUtil.setContentView(this, layoutId)
        this.mViewmodel = if (mViewmodel == null) viewmodel else mViewmodel
        viewDataBinding!!.setVariable(bindingVariable, mViewmodel)
        viewDataBinding!!.executePendingBindings()
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        if (view != null) {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    override fun hideSnackbar() {
        snackbar.let {
            if(it!!.isShown){
                it.dismiss()
            }
        }
    }

    override fun showToast(msg: String) {
        Toast.makeText(this,msg,Toast.LENGTH_LONG).show()
    }

    override fun showSnackbar() {
        /**/
    }

    override fun showSnackbarWithAction() {
        /**/
    }
}