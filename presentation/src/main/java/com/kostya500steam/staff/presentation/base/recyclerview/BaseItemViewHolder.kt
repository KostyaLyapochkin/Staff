package com.kostya500steam.staff.presentation.base.recyclerview

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.kostya500steam.domain.entity.DomainModule
import com.kostya500steam.staff.BR

open class BaseItemViewHolder<Entity : DomainModule,
        VM : BaseItemViewModel<Entity>,
        B : ViewDataBinding>(val viewModel: VM, private val binding: B) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.setVariable(BR.viewModel, viewModel)
    }

    fun bindTo(entity: Entity, position: Int) {
        viewModel.setItem(entity, position)
        binding.executePendingBindings()
    }

}