package com.kostya500steam.staff.injection

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class AppModule(private val context : Context) {

    @Provides
    @Singleton
    fun provideContext() = context

}