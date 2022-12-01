package com.wondershare.wutsapper.transfer.base

import android.app.Dialog
import android.content.Context
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.ViewGroup
import android.view.Window
import android.widget.RelativeLayout
import androidx.fragment.app.DialogFragment

@Suppress("UNREACHABLE_CODE")
abstract class BaseDialog : DialogFragment(), BaseNavigator {
    var baseActivity: BaseActivity<*, *>? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is BaseActivity<*,*>){
            val activity = context as BaseActivity<*,*>
            this.baseActivity = activity
            activity.onFragmentAttached()
        }
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return super.onCreateDialog(savedInstanceState)
        // content
        val root = RelativeLayout(activity)
        root.layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

        // fullscreen dialog
        val diaolog = Dialog(requireContext())
        diaolog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        diaolog.setContentView(root)
        if (dialog?.window != null) {
            dialog?.window?.setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))
            dialog?.window?.setLayout(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT)
        }
        dialog!!.setCanceledOnTouchOutside(false)

        return dialog!!
    }

    override fun onDetach() {
        baseActivity = null
        super.onDetach()
    }

    override fun show(fragmentManager: androidx.fragment.app.FragmentManager, tag: String?) {
        val transaction = fragmentManager.beginTransaction()
        val prevFragment = fragmentManager.findFragmentByTag(tag)
        if (prevFragment != null) {
            transaction.remove(prevFragment)
        }
        transaction.addToBackStack(null)
        show(transaction, tag)
    }

    fun dismissDialog(tag: String) {
        dismiss()
        baseActivity!!.onFragmentDetached(tag)
    }

    override fun showToast(msg: String) {
        baseActivity?.showToast(msg)
    }

    override fun showSnackbar() {
        baseActivity?.showSnackbar()
    }

}