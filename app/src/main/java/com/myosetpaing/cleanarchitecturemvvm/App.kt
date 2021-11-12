package com.myosetpaing.cleanarchitecturemvvm

import android.app.Application
import com.myosetpaing.cleanarchitecturemvvm.framework.di.presentationModule
import com.myosetpaing.cleanarchitecturemvvm.framework.di.repositoryModule
import com.myosetpaing.cleanarchitecturemvvm.network.networkModule
import com.myosetpaing.cleanarchitecturemvvm.utils.ReleaseTree
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

/**
 * Created by mspai on 10/11/2021.
 **/

open class App : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin ()
        plantTimber()
    }


    protected open fun startKoin() {
        startKoin {
            if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
            androidContext(this@App)
            modules(listOf(presentationModule, repositoryModule,networkModule))
        }
    }
    protected open fun plantTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun createStackElementTag(element: StackTraceElement): String {
                    return String.format(
                        "Class:%s: Line: %s, Method: %s",
                        super.createStackElementTag(element),
                        element.lineNumber,
                        element.methodName
                    )
                }
            })
        } else {
            Timber.plant(ReleaseTree())
        }
    }
}