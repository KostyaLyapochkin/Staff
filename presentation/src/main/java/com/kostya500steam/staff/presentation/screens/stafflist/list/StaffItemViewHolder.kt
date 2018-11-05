package com.kostya500steam.staff.presentation.screens.stafflist.list

import android.view.LayoutInflater
import android.view.ViewGroup
import com.kostya500steam.domain.entity.Staff
import com.kostya500steam.staff.databinding.ItemStaffBinding
import com.kostya500steam.staff.presentation.base.recyclerview.BaseItemViewHolder

class StaffItemViewHolder(viewModel: StaffItemViewModel,
                          binding: ItemStaffBinding) : BaseItemViewHolder<Staff,
        StaffItemViewModel, ItemStaffBinding>(viewModel, binding) {

    companion object {

        fun create(parent: ViewGroup, viewModel: StaffItemViewModel) : StaffItemViewHolder {
            return StaffItemViewHolder(viewModel, ItemStaffBinding.inflate(LayoutInflater.from(parent.context),
                    parent, false))
        }
    }

}