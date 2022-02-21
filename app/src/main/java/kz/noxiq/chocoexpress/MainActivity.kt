package kz.noxiq.chocoexpress

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.android.support.DaggerAppCompatActivity
import kz.noxiq.chocoexpress.databinding.ActivityMainBinding
import kz.noxiq.chocoexpress.ui.home.HomeFragment
import kz.noxiq.chocoexpress.ui.orders.OrdersFragment
import kz.noxiq.chocoexpress.ui.rahmet.RahmetFragment

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.navigation_bar)

        val homeFragment = HomeFragment()
        val ordersFragment = OrdersFragment()
        val rahmetFragment = RahmetFragment()

        /*
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, firstFragment)
            commit()
        }
         */

        bottomNavigationView.setOnNavigationItemSelectedListener{
            when(it.itemId){
                R.id.home_tab -> changeFragment(homeFragment)
                R.id.orders_tab -> changeFragment(ordersFragment)
                R.id.raqmet_tab -> changeFragment(rahmetFragment)
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    private fun changeFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.nav_host_fragment, fragment)
            commit()
        }
    }


}