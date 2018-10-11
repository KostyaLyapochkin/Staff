package com.kostya500steam.staff.presentation.base.recyclerview

import com.kostya500steam.domain.entity.DomainModule


data class ClickedItemModel<Entity : DomainModule>(val entity: Entity?, val position: Int)
