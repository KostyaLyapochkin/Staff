package com.kostya500steam.staff.app

import android.app.Application
import com.kostya500steam.staff.injection.AppComponent
import com.kostya500steam.staff.injection.AppModule
import com.kostya500steam.staff.injection.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
                .builder()
                .appModule(AppModule(this))
                .build()
    }

    companion object {

        @JvmStatic
        private lateinit var appComponent: AppComponent

        @JvmStatic
        internal fun getInstance() = appComponent

    }

}
