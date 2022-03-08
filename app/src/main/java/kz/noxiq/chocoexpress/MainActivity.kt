package kz.noxiq.chocoexpress

import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import dagger.android.support.DaggerAppCompatActivity
import kz.noxiq.chocoexpress.databinding.ActivityMainBinding
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController

class MainActivity : DaggerAppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initView()
    }

    private fun initView(){
        navController = findNavController(R.id.nav_host_fragment)

        initBottomNavigation()
        initOnDestinationChangedListener()
    }

    private fun initBottomNavigation() {
        navController = findNavController(R.id.nav_host_fragment)
        binding.bottomNav.setupWithNavController(navController)
    }

    private fun initOnDestinationChangedListener() {
        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.homeFragment,
                R.id.ordersFragment
                -> {
                    binding.bottomNav.visibility = View.VISIBLE
                }
                else -> {
                    binding.bottomNav.visibility = View.GONE
                }
            }
        }
    }

}