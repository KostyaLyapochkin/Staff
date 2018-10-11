package com.kostya500steam.staff.presentation.screens

import android.app.DatePickerDialog
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import com.kostya500steam.staff.R
import com.kostya500steam.staff.databinding.ActivityStaffListBinding
import com.kostya500steam.staff.presentation.base.BaseMVVMActivity
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
    }

    private val beforeDate = DatePickerDialog.OnDateSetListener { _, year, month, day ->
        viewModel.before.set("$year-$month-$day")
    }

    private val afterDate = DatePickerDialog.OnDateSetListener { _, year, month, day ->
        viewModel.after.set("$year-$month-$day")
    }

}
