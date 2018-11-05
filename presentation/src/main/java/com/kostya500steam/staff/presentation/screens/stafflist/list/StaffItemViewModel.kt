package com.kostya500steam.staff.presentation.screens.stafflist.list

import android.databinding.ObservableField
import com.kostya500steam.domain.entity.Staff
import com.kostya500steam.staff.presentation.base.recyclerview.BaseItemViewModel

class StaffItemViewModel : BaseItemViewModel<Staff>() {

    @JvmField
    val name = ObservableField<String>(" ")
    private lateinit var staff: Staff

    override fun setItem(entity: Staff, position: Int) {
        this.staff = entity
        name.set(staff.name)
    }
}