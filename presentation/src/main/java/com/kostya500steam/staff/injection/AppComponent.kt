package com.kostya500steam.staff.injection

import android.content.Context
import com.kostya500steam.staff.presentation.screens.stafflist.StaffListViewModel
import dagger.Component
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

    fun inject(staffList: StaffListViewModel)

    fun getContext(): Context

}