package demo.mindvalleytest

import android.app.Application
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import demo.mindvalleytest.dependencyInjection.components.DaggerAppComponent
import javax.inject.Inject

class MindValleyTestApplication : Application(), HasAndroidInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun androidInjector(): DispatchingAndroidInjector<Any> = dispatchingAndroidInjector
}