package kz.noxiq.chocoexpress

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import kz.noxiq.chocoexpress.di.DaggerAppComponent

class App : DaggerApplication() {
    private val applicationInjector = DaggerAppComponent.builder().application(this).build()
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = applicationInjector
}