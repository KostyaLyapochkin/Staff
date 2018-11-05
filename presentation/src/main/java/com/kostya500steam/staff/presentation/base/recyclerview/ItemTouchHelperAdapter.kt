package com.kostya500steam.staff.presentation.base.recyclerview

interface ItemTouchHelperAdapter {

    fun onItemMove(fromPosition: Int, toPosition: Int) : Boolean

    fun onItemDismiss(position: Int)
}