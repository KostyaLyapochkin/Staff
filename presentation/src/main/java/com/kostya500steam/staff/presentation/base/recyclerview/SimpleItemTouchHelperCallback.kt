package com.kostya500steam.staff.presentation.base.recyclerview

import android.support.v7.widget.RecyclerView
import android.support.v7.widget.helper.ItemTouchHelper

class SimpleItemTouchHelperCallback(private val itemTouchHelperAdapter : ItemTouchHelperAdapter)
    : ItemTouchHelper.Callback() {

    override fun getMovementFlags(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?): Int {
        val dragFlags = ItemTouchHelper.UP or ItemTouchHelper.DOWN
        val swipeFlags = ItemTouchHelper.START or ItemTouchHelper.END
        return ItemTouchHelper.Callback.makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(recyclerView: RecyclerView?, viewHolder: RecyclerView.ViewHolder?,
                        target: RecyclerView.ViewHolder?): Boolean {
        itemTouchHelperAdapter.onItemMove(viewHolder!!.adapterPosition, target!!.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder?, direction: Int) {
        itemTouchHelperAdapter.onItemDismiss(viewHolder!!.adapterPosition)
    }

    override fun isItemViewSwipeEnabled(): Boolean = true

    override fun isLongPressDragEnabled(): Boolean = true

}