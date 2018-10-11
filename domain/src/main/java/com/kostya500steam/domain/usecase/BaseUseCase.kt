package com.kostya500steam.domain.usecase

import com.kostya500steam.domain.executors.ExecutionThread
import com.kostya500steam.domain.executors.PostExecutionThread
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase {
    protected open val executionThread : Scheduler
    protected open val postExecutionThread : Scheduler

    constructor(executionThread: Scheduler, postExecutionThread: Scheduler) {
        this.executionThread = executionThread
        this.postExecutionThread = postExecutionThread
    }

    constructor(executionThread: ExecutionThread, postExecutionThread: PostExecutionThread) {
        this.executionThread = Schedulers.from(executionThread)
        this.postExecutionThread = postExecutionThread.getScheduler()
    }

    constructor(postExecutionThread: PostExecutionThread) {
        this.executionThread = Schedulers.io()
        this.postExecutionThread = postExecutionThread.getScheduler()
    }

    constructor(executionThread: PostExecutionThread, postExecutionThread: PostExecutionThread) {
        this.executionThread = executionThread.getScheduler()
        this.postExecutionThread = postExecutionThread.getScheduler()
    }

}