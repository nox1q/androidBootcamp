package kz.noxiq.chocoexpress.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import kz.noxiq.chocoexpress.ui.home.HomeFragment
import kz.noxiq.chocoexpress.ui.home.cart.CartFragment
import kz.noxiq.chocoexpress.ui.home.menu.MenuFragment
import kz.noxiq.chocoexpress.ui.home.menu_category_name.MenuCategoryNamesFragment
import kz.noxiq.chocoexpress.ui.orders.OrdersFragment
import kz.noxiq.chocoexpress.ui.orders.order_details.OrderDetailsFragment
import kz.noxiq.chocoexpress.ui.rahmet.LoginFragment
import kz.noxiq.chocoexpress.ui.rahmet.RahmetFragment
import kz.noxiq.chocoexpress.ui.registration.EmailFragment
import kz.noxiq.chocoexpress.ui.registration.PasswordFragment

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {

    @ContributesAndroidInjector
    abstract fun contributeHomeFragment(): HomeFragment

    @ContributesAndroidInjector
    abstract fun contributeMenuFragment(): MenuFragment

    @ContributesAndroidInjector
    abstract fun contributesOrdersFragment(): OrdersFragment

    @ContributesAndroidInjector
    abstract fun contributesOrderDetailsFragment(): OrderDetailsFragment

    @ContributesAndroidInjector
    abstract fun contributesRahmetFragment(): RahmetFragment

    @ContributesAndroidInjector
    abstract fun contributesMenuCategoryNameFragment(): MenuCategoryNamesFragment

    @ContributesAndroidInjector
    abstract fun contributesCartFragment(): CartFragment

    @ContributesAndroidInjector
    abstract fun contributesEmailFragment(): EmailFragment

    @ContributesAndroidInjector
    abstract fun contributesPasswordFragment(): PasswordFragment

    @ContributesAndroidInjector
    abstract fun contributesLoginFragment(): LoginFragment

}