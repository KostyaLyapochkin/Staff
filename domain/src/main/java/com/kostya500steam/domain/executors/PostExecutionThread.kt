package com.kostya500steam.domain.executors

import io.reactivex.Scheduler

interface PostExecutionThread {
    fun getScheduler() : Scheduler
}