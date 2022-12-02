package com.wondershare.wutsapper.transfer.feature.home


import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupWindow
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.wondershare.wutsapper.transfer.R
import com.wondershare.wutsapper.transfer.databinding.ActivityHomeBinding


class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewmodel: HomeViewmodel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        viewmodel = ViewModelProvider(this)[HomeViewmodel::class.java]
        binding.lifecycleOwner = this
        initView()
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private fun initView() {
        viewmodel.dropOrDown.observe(this) {
            if (it) {
                binding.imgDropOrDown.setImageDrawable(getDrawable(R.drawable.ic_up_menu))
            } else {
                binding.imgDropOrDown.setImageDrawable(getDrawable(R.drawable.ic_down_menu))
            }
        }

        binding.btnChooseApp.setOnClickListener {
            popupMenu()
            viewmodel.dropOrDown.postValue(true)
        }
    }

    private fun popupMenu() {
        val layoutInflater = baseContext
            .getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater

        val popupView: View = layoutInflater.inflate(R.layout.menupopup_home, null)

        val popupWindow = PopupWindow(
            popupView,
            binding.btnChooseApp.width, ViewGroup.LayoutParams.MATCH_PARENT,
            true
        )

        popupWindow.isTouchable = true
        popupWindow.isFocusable = true

        popupWindow.showAtLocation(popupView, Gravity.CENTER, 0, 0)


        }

}