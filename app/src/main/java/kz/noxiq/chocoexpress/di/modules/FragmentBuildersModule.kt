package kz.noxiq.chocoexpress.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.noxiq.chocoexpress.ui.home.HomeFragment
import kz.noxiq.chocoexpress.ui.orders.OrdersFragment

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeOrdersFragment(): OrdersFragment

}