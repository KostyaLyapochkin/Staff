package com.kostya500steam.staff.presentation.screens.stafflist

import android.databinding.ObservableField
import com.kostya500steam.domain.entity.Staff
import com.kostya500steam.staff.app.App
import com.kostya500steam.staff.presentation.base.BaseActivity
import com.kostya500steam.staff.presentation.base.BaseRouter
import com.kostya500steam.staff.presentation.base.BaseViewModel
import com.kostya500steam.staff.presentation.screens.stafflist.list.StaffAdapter

class StaffListViewModel : BaseViewModel<BaseRouter<BaseActivity>>() {

    val before = ObservableField<String>("YYYY-MM-DD")
    val after = ObservableField<String>("YYYY-MM-DD")
    val adapter = ObservableField<StaffAdapter>(StaffAdapter())

    init {
        App.getInstance().inject(this)
        val l = mutableListOf(
                Staff("Kostya-1"),
                Staff("Kostya-2"),
                Staff("Kostya-3"),
                Staff("Kostya-3"),
                Staff("Kostya-4"),
                Staff("Kostya-5"),
                Staff("Kostya-6"),
                Staff("Kostya-7"),
                Staff("Kostya-8"),
                Staff("Kostya-9"),
                Staff("Kostya-10"),
                Staff("Kostya-11"),
                Staff("Kostya-12"))
        adapter.get()!!.updateData(l)
    }

}