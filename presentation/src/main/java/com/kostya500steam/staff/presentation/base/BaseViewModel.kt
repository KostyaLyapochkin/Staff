package com.kostya500steam.staff.presentation.base

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel<R : BaseRouter<BaseActivity>> : ViewModel() {
    protected open var router: R? = null
    protected open val compositeDisposable by lazy {
        CompositeDisposable()
    }

    fun addRouter(router : R) : Unit {
        this.router = router
    }

    fun removeRouter() {
        this.router = null
    }

    open fun onCreate() {

    }

    open fun onResume() {

    }

    open fun onPause() {

    }

    open fun onDestroy() {

    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}