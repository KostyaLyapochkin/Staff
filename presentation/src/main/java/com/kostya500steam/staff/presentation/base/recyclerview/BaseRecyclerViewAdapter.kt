package com.kostya500steam.staff.presentation.base.recyclerview

import android.support.v7.widget.RecyclerView
import com.kostya500steam.domain.entity.DomainModule
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject

abstract class BaseRecyclerViewAdapter<Entity : DomainModule,
        VM : BaseItemViewModel<Entity>> : RecyclerView.Adapter<BaseItemViewHolder<Entity, VM, *>>() {

    private val itemClickSubject = PublishSubject.create<ClickedItemModel<Entity>>()
    private val itemLongClickSubject = PublishSubject.create<ClickedItemModel<Entity>>()
    private val currencies: MutableList<Entity> = mutableListOf()
    private var isState : Boolean = true

    override fun onBindViewHolder(holder: BaseItemViewHolder<Entity, VM, *>, position: Int) {
        holder.bindTo(currencies[position], position)
    }

    override fun getItemCount(): Int = currencies.size

    fun updateData(currencies: MutableList<Entity>) {
        this.currencies.clear()
        this.currencies.addAll(currencies)
        notifyDataSetChanged()
    }

    override fun onViewAttachedToWindow(holder: BaseItemViewHolder<Entity, VM, *>) {
        super.onViewAttachedToWindow(holder)
        if (isState) {
            // для перехода в новую активити
            holder.itemView.setOnClickListener {
                val pos = holder.adapterPosition
                itemClickSubject.onNext(ClickedItemModel(currencies[pos], pos))
                holder.viewModel.onItemClick()
            }
            // для удаления - сделать long click
            holder.itemView.setOnLongClickListener {
                val pos = holder.adapterPosition
                itemLongClickSubject.onNext(ClickedItemModel(currencies[pos], pos))
                holder.viewModel.onItemClick()
                true
            }
        }
    }

    override fun onViewDetachedFromWindow(holder: BaseItemViewHolder<Entity, VM, *>) {
        super.onViewDetachedFromWindow(holder)
        if (isState) holder.itemView.setOnClickListener { holder.itemView.setOnClickListener(null) }
    }

    fun observeItemClick(): Observable<ClickedItemModel<Entity>> = itemClickSubject

    fun observeItemLongClick() : Observable<ClickedItemModel<Entity>> = itemLongClickSubject

    fun turnOnState(): Unit {
        this.isState = true
    }


}