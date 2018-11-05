package com.kostya500steam.staff.presentation.screens.stafflist

import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Color
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import com.kostya500steam.staff.R
import com.kostya500steam.staff.databinding.ActivityStaffListBinding
import com.kostya500steam.staff.presentation.base.BaseMVVMActivity
import com.kostya500steam.staff.presentation.screens.stafflist.list.SwipeHelper
import java.util.*

class StaffListActivity : BaseMVVMActivity<StaffListViewModel,
        ActivityStaffListBinding,
        StaffListRouter>() {

    override fun initViewModule(): StaffListViewModel = ViewModelProviders.of(this)
            .get(StaffListViewModel::class.java)

    override fun initLayout(): Int = R.layout.activity_staff_list
    override fun initRouter(): StaffListRouter = StaffListRouter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val calendar = Calendar.getInstance()
        binding.before.setOnClickListener {
            val d = DatePickerDialog(this, beforeDate,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
            d.show()
        }
        binding.after.setOnClickListener {
            val d = DatePickerDialog(this, afterDate,
                    calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH))
            d.show()
        }
        binding.recyclerView.setHasFixedSize(true)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
//        рабочая версия, просто перетягивание и удаление
//        val callback = SimpleItemTouchHelperCallback(viewModel.adapter.get()!!)
//        val touchHelper = ItemTouchHelper(callback)
//        touchHelper.attachToRecyclerView(binding.recyclerView)


//        val callback = SwipeController({
//            Log.e("AAA", "Edit = $it")
//        }, {
//            Log.e("AAA", "Remove = $it")
//            viewModel.adapter.get()!!.onItemDismiss(it)
//        })
//        val touchHelper = ItemTouchHelper(callback)
//        touchHelper.attachToRecyclerView(binding.recyclerView)

        val swipeHelper = object : SwipeHelper(this, binding.recyclerView) {

            override fun instantiateUnderlayButton(viewHolder: RecyclerView.ViewHolder?, underlayButtons: MutableList<UnderlayButton>?) {
                underlayButtons!!.add(SwipeHelper.UnderlayButton("Delete",
                        0,
                        Color.parseColor("#FF3C30"),
                        SwipeHelper.UnderlayButtonClickListener {
                            Log.e("AAA", "DELETE = $it")
                        }))
            }
        }
    }

    private val beforeDate = DatePickerDialog.OnDateSetListener { _, year, month, day ->
        viewModel.before.set("$year-$month-$day")
    }

    private val afterDate = DatePickerDialog.OnDateSetListener { _, year, month, day ->
        viewModel.after.set("$year-$month-$day")
    }

}
