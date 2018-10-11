package com.kostya500steam.staff.presentation.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import com.kostya500steam.staff.BR

abstract class BaseMVVMActivity<VM : BaseViewModel<BaseRouter<BaseActivity>>,
        B : ViewDataBinding,
        R : BaseRouter<BaseActivity>> : BaseActivity() {

    protected open lateinit var viewModel: VM
    protected open lateinit var binding : B
    protected open lateinit var router : R

    protected abstract fun initViewModule() : VM
    protected abstract fun initLayout() : Int
    protected abstract fun initRouter() : R

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = initViewModule()
        binding = DataBindingUtil.setContentView(this, initLayout())
        binding.setVariable(BR.viewModel, viewModel)
    }

    override fun onResume() {
        super.onResume()
        router = initRouter()
        viewModel.addRouter(router)
    }

    override fun onPause() {
        super.onPause()
        viewModel.removeRouter()
    }

    fun getCurrentRouter() : R = router

}