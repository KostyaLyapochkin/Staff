package com.kostya500steam.staff.presentation.base.fragment

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kostya500steam.staff.BR
import com.kostya500steam.staff.presentation.base.BaseActivity
import com.kostya500steam.staff.presentation.base.BaseRouter
import com.kostya500steam.staff.presentation.base.BaseViewModel

abstract class BaseMVVMFragment<VM : BaseViewModel<BaseRouter<BaseActivity>>,
        B : ViewDataBinding, R> : BaseFragment() {

    protected open lateinit var viewModel: VM
    protected open lateinit var binding: B
    protected open var router: R? = null

    protected abstract fun initViewModel(): VM
    protected abstract fun initLayout(): Int
    protected abstract fun initRouter(): R

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        viewModel = initViewModel()
        binding = DataBindingUtil.inflate(inflater, initLayout(), container, false)
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        router = initRouter()
        viewModel.addRouter(router as BaseRouter<BaseActivity>)
    }

    override fun onStop() {
        super.onStop()
        viewModel.removeRouter()
    }

}