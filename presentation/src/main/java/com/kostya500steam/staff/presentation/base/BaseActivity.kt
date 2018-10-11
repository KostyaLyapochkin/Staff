package com.kostya500steam.staff.presentation.base

import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import io.reactivex.disposables.CompositeDisposable

abstract class BaseActivity : AppCompatActivity() {
    protected open val compositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear()
    }

}