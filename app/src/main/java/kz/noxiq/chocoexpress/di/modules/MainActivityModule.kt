package kz.noxiq.chocoexpress.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.noxiq.chocoexpress.MainActivity

@Suppress("unused")
@Module
abstract class MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            FragmentBuildersModule::class
        ]
    )
    abstract fun contributeMainActivity(): MainActivity
}