package com.kostya500steam.staff.presentation.screens

import android.databinding.ObservableField
import com.kostya500steam.staff.presentation.base.BaseActivity
import com.kostya500steam.staff.presentation.base.BaseRouter
import com.kostya500steam.staff.presentation.base.BaseViewModel

class StaffListViewModel : BaseViewModel<BaseRouter<BaseActivity>>() {

    @JvmField
    val before = ObservableField<String>("YYYY-MM-DD")
    @JvmField
    val after = ObservableField<String>("YYYY-MM-DD")

}