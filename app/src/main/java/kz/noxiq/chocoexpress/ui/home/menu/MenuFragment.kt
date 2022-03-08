package kz.noxiq.chocoexpress.ui.home.menu

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.navGraphViewModels
import androidx.viewpager2.widget.ViewPager2
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_menu.*
import kz.noxiq.chocoexpress.R
import kz.noxiq.chocoexpress.databinding.FragmentMenuBinding
import kz.noxiq.chocoexpress.domain.menu.model.Menu
import kz.noxiq.chocoexpress.ui.home.menu.adapter.SliderViewPageAdapter
import kz.noxiq.chocoexpress.ui.home.menu.category.ProductCategoryAdapter
import kz.noxiq.chocoexpress.ui.home.menu.category_name.CategoryNameAdapter
import javax.inject.Inject

class MenuFragment : DaggerFragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding
    private val args: MenuFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by navGraphViewModels<MenuViewModel>(R.id.menu) { viewModelFactory }

    private val productCategoryAdapter: ProductCategoryAdapter = ProductCategoryAdapter()
    private val categoryNameAdapter: CategoryNameAdapter by lazy {
        CategoryNameAdapter(viewModel::onCategoryClicked)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentMenuBinding.bind(view)
        viewModel.onStart(args.restaurantId)

        observeViewModel()
        setupToolbar()
        setupViewPager()
        navigateToMenuCategoryNames()
    }


    private fun navigateToMenuCategoryNames() {
        binding.ivMenuList.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToMenuCategoryNamesFragment()
            )
        }
    }

    private fun observeViewModel() {
        viewModel.getMenuLiveData().observe(
            viewLifecycleOwner, ::handleMenu
        )
    }


    private fun setupViewPager() {
        binding.sliderImageView.registerOnPageChangeCallback(getPageChangeCallback())
    }

    private fun handleMenu(menu: Menu) {
        toolbar.title = menu.restaurantName
        binding.sliderImageView.adapter = SliderViewPageAdapter(menu.restaurantImageUrls)
        binding.tvRestaurantAddress.text = menu.restaurantLocation
//        binding.tvImageList.text = menu.restaurantImageUrls.size.toString()
        binding.rvProducts.adapter = productCategoryAdapter
        productCategoryAdapter.submitList(menu.productCategories)
        binding.rvCategoryNames.adapter = categoryNameAdapter
        categoryNameAdapter.submitList(menu.productCategoryNames)
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getPageChangeCallback() = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            viewModel.onPageSelected(position)
        }
    }
}