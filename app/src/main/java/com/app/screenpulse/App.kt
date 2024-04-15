package com.app.screenpulse

import android.app.Activity
import android.app.Application
import android.os.Bundle

class App: Application() {

    override fun onCreate() {
        super.onCreate()
        application = this

        registerActivityLifecycleCallbacks(AppLifecycleTracker())
    }

    companion object {
        lateinit var application: Application
    }

    class AppLifecycleTracker : ActivityLifecycleCallbacks  {

        private var numStarted = 0

        override fun onActivityCreated(p0: Activity, p1: Bundle?) {}

        override fun onActivityStarted(activity: Activity) {
            if (numStarted == 0) {
                appIsForeground = true
            }
            numStarted++
        }

        override fun onActivityResumed(p0: Activity) {
            currentActivityClassName = p0::class.java.canonicalName
        }

        override fun onActivityPaused(p0: Activity) {}

        override fun onActivityStopped(activity: Activity) {
            numStarted--
            if (numStarted == 0) {
                appIsForeground = false
            }
        }

        override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {}

        override fun onActivityDestroyed(p0: Activity) {}

        companion object {
            var appIsForeground = false
            var currentActivityClassName: String? = null
        }

    }
}