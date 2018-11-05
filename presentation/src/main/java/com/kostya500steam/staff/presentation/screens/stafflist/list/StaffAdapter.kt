package com.kostya500steam.staff.presentation.screens.stafflist.list

import android.view.ViewGroup
import com.kostya500steam.domain.entity.Staff
import com.kostya500steam.staff.presentation.base.recyclerview.BaseItemViewHolder
import com.kostya500steam.staff.presentation.base.recyclerview.BaseRecyclerViewAdapter

class StaffAdapter : BaseRecyclerViewAdapter<Staff, StaffItemViewModel>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseItemViewHolder<Staff, StaffItemViewModel, *> {
         return StaffItemViewHolder.create(parent, StaffItemViewModel())
    }
}