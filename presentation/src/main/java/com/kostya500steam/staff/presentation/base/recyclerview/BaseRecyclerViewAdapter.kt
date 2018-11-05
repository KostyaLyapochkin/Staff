package com.kostya500steam.staff.presentation.base.recyclerview

import android.support.v7.widget.RecyclerView
import com.kostya500steam.domain.entity.DomainModule
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import java.util.*

abstract class BaseRecyclerViewAdapter<Entity : DomainModule,
        VM : BaseItemViewModel<Entity>> : RecyclerView.Adapter<BaseItemViewHolder<Entity, VM, *>>(), ItemTouchHelperAdapter {

    private val itemClickSubject = PublishSubject.create<ClickedItemModel<Entity>>()
    private val itemLongClickSubject = PublishSubject.create<ClickedItemModel<Entity>>()
    private val entityList: MutableList<Entity> = mutableListOf()
    protected open var isState: Boolean = true

    override fun onBindViewHolder(holder: BaseItemViewHolder<Entity, VM, *>, position: Int) {
        holder.bindTo(entityList[position], position)
    }

    override fun getItemCount(): Int = entityList.size

    fun updateData(entities: MutableList<Entity>) {
        this.entityList.clear()
        this.entityList.addAll(entities)
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: BaseItemViewHolder<Entity, VM, *>) {
        super.onViewAttachedToWindow(holder)
        if (isState) {
            // click
            holder.itemView.setOnClickListener {
                val pos = holder.adapterPosition
                itemClickSubject.onNext(ClickedItemModel(entityList[pos], pos))
                holder.viewModel.onItemClick()
            }
            // long click
            holder.itemView.setOnLongClickListener {
                val pos = holder.adapterPosition
                itemLongClickSubject.onNext(ClickedItemModel(entityList[pos], pos))
                holder.viewModel.onItemClick()
                true
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseItemViewHolder<Entity, VM, *>) {
        super.onViewDetachedFromWindow(holder)
        if (isState) holder.itemView.setOnClickListener { holder.itemView.setOnClickListener(null) }
    }

    //Удаление
    override fun onItemDismiss(position: Int) {
        entityList.removeAt(position)
        notifyItemRemoved(position)
    }

    // Перемещение
    override fun onItemMove(fromPosition: Int, toPosition: Int): Boolean {
        if (fromPosition < toPosition) {
            for (i in fromPosition until toPosition) {
                Collections.swap(entityList, i, i + 1)
            }
        } else {
            for (i in fromPosition downTo toPosition + 1) {
                Collections.swap(entityList, i, i - 1)
            }
        }
        notifyItemMoved(fromPosition, toPosition)
        return true
    }

    fun observeItemClick(): Observable<ClickedItemModel<Entity>> = itemClickSubject

    fun observeItemLongClick(): Observable<ClickedItemModel<Entity>> = itemLongClickSubject

}