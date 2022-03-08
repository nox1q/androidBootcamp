package kz.noxiq.chocoexpress.ui.home.menu_category_name

import android.os.Bundle
import android.view.View
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentCategoryNamesBinding
import kz.noxiq.chocoexpress.databinding.FragmentMenuBinding
import kz.noxiq.chocoexpress.domain.menu.model.Menu
import kz.noxiq.chocoexpress.ui.home.menu.MenuFragmentArgs
import kz.noxiq.chocoexpress.ui.home.menu.MenuViewModel
import kz.noxiq.chocoexpress.ui.home.menu.category.ProductCategoryAdapter
import kz.noxiq.chocoexpress.ui.home.menu.category_name.CategoryNameAdapter
import javax.inject.Inject

class MenuCategoryNamesFragment : DaggerFragment(R.layout.fragment_category_names) {

    private lateinit var binding: FragmentCategoryNamesBinding
    private val adapter: MenuCategoryNameAdapter = MenuCategoryNameAdapter()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by navGraphViewModels<MenuViewModel>(R.id.menu) { viewModelFactory }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentCategoryNamesBinding.bind(view)
        binding.rvCategoryNames.adapter = adapter
        observeViewModel()
        setupToolbar()
    }

    private fun observeViewModel() {
        viewModel.getMenuLiveData().observe(viewLifecycleOwner, ::handleMenu)
    }


    private fun handleMenu(menu: Menu) {
        adapter.submitList(menu.productCategories)
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }
}