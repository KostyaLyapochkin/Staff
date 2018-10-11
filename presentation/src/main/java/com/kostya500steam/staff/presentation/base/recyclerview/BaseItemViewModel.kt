package com.kostya500steam.staff.presentation.base.recyclerview

import com.kostya500steam.domain.entity.DomainModule

abstract class BaseItemViewModel<Entity : DomainModule> {

    abstract fun setItem(entity: Entity, position : Int)

    open fun onItemClick() {

    }
}