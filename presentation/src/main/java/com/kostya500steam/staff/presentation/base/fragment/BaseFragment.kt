package com.kostya500steam.staff.presentation.base.fragment

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable

abstract class BaseFragment : Fragment() {
    protected open val compositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }
}