package com.kostya500steam.staff.presentation.base.basedialog

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import com.kostya500steam.staff.BR
import com.kostya500steam.staff.presentation.base.BaseActivity
import com.kostya500steam.staff.presentation.base.BaseRouter
import com.kostya500steam.staff.presentation.base.BaseViewModel

abstract class BaseMVVMDialogFragment<VM : BaseViewModel<BaseRouter<BaseActivity>>,
        B : ViewDataBinding,
        R : BaseRouter<BaseActivity>> : BaseDialogFragment() {

    protected lateinit var viewModel : VM
    protected lateinit var binding : B
    protected lateinit var router: R

    protected abstract fun provideViewModel() : VM
    protected abstract fun provideLayout() : Int
    protected abstract fun provideRouter() : R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = provideViewModel()
        router = provideRouter()
        binding = DataBindingUtil.inflate(LayoutInflater.from(activity),
                provideLayout(), null, false)

        binding.setVariable(BR.viewModel, viewModel)
        viewModel.addRouter(router)
    }

}