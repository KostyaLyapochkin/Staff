package com.kostya500steam.staff.presentation.base

import com.kostya500steam.staff.presentation.base.fragment.BaseFragment

abstract class BaseRouter<A : BaseActivity> (protected open val activity: A) {

    fun showFragment(f : BaseFragment, id : Int, addToBackStack : Boolean) {
        val fragmentManager = activity.supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(id, f)
        if (addToBackStack) {
            transaction.addToBackStack(null)
        }
        transaction.commit()
    }

    open fun showError(t: Throwable) {

    }
}