package kz.noxiq.chocoexpress.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.noxiq.chocoexpress.ui.home.HomeFragment

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeOrdersFragment(): HomeFragment


}