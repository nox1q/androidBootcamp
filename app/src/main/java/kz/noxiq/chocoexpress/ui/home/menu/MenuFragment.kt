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
import kz.noxiq.chocoexpress.domain.menu.model.OrderCreate
import kz.noxiq.chocoexpress.domain.menu.model.ProductCountUpdate
import kz.noxiq.chocoexpress.ui.home.menu.adapter.SliderViewPageAdapter
import kz.noxiq.chocoexpress.ui.home.menu.category.ProductCategoryAdapter
import kz.noxiq.chocoexpress.ui.home.menu.category_name.CategoryNameAdapter
import kz.noxiq.chocoexpress.ui.utils.formatPrice
import kz.noxiq.chocoexpress.ui.utils.observe
import kz.noxiq.chocoexpress.ui.utils.setVisibility
import javax.inject.Inject

class MenuFragment : DaggerFragment(R.layout.fragment_menu) {

    private lateinit var binding: FragmentMenuBinding
    private val args: MenuFragmentArgs by navArgs()

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory
    private val viewModel by navGraphViewModels<MenuViewModel>(R.id.menu) { viewModelFactory }

    private val productCategoryAdapter: ProductCategoryAdapter by lazy {
        ProductCategoryAdapter(viewModel::onProductCountChangeClicked)
    }
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
        navigation()
    }

    private fun navigation() {
        navigateToMenuCategoryNames()
        navigateToStash()
    }

    private fun navigateToMenuCategoryNames() {
        binding.ivMenuList.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToMenuCategoryNamesFragment()
            )
        }
    }

    private fun navigateToStash() {
        binding.btnPay.setOnClickListener {
            findNavController().navigate(
                MenuFragmentDirections.actionMenuFragmentToStashFragment()
            )
        }
    }

    private fun observeViewModel() {

        viewModel.getIsLoadingMenu().observe(viewLifecycleOwner,binding.pbLoading::setVisibility)

        viewModel.getMenuLiveData().observe(
            viewLifecycleOwner, ::handleMenu
        )
        viewModel.getProductCountUpdateLiveData()
            .observe(viewLifecycleOwner, ::handleProductCountUpdateLiveData)
        viewModel.getOrderCreateLiveData().observe(viewLifecycleOwner, ::handleOrderCreate)
        viewModel.getPositionSizePairLiveData().observe(viewLifecycleOwner,::handlePositionSizePair)
    }

    private fun setupViewPager() {
        binding.sliderImageView.registerOnPageChangeCallback(getPageChangeCallback())
        binding.sliderImageView.currentItem = 3
    }

    private fun handleMenu(menu: Menu) {
        toolbar.title = menu.restaurantName
        binding.sliderImageView.adapter = SliderViewPageAdapter(menu.restaurantImageUrls)
        binding.tvRestaurantAddress.text = menu.restaurantLocation
        binding.tvSliderPosition.text = "1/${menu.restaurantImageUrls.size}"
        binding.rvProducts.adapter = productCategoryAdapter
        productCategoryAdapter.submitList(menu.productCategories)
        binding.rvCategoryNames.adapter = categoryNameAdapter
        categoryNameAdapter.submitList(menu.productCategoryNames)
    }

    private fun handlePositionSizePair(positionSizePair: Pair<Int,Int>){
        binding.tvSliderPosition.text = "${positionSizePair.first}/${positionSizePair.second}"
    }

    private fun handleProductCountUpdateLiveData(productCountUpdate: ProductCountUpdate) {
        productCategoryAdapter.notifyItemChanged(
            productCountUpdate.productCategoryPosition,
            productCountUpdate
        )
    }

    private fun handleOrderCreate(orderCreate: OrderCreate) {
        val isPriceHigherThanZero: Boolean = orderCreate.totalPrice > 0

        with(binding) {
            btnPay.setVisibility(isPriceHigherThanZero)
            tvTotalPrice.text = formatPrice(orderCreate.totalPrice)
        }
    }

    private fun setupToolbar() {
        toolbar.setNavigationOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun getPageChangeCallback() = object : ViewPager2.OnPageChangeCallback() {
        override fun onPageSelected(position: Int) {
            viewModel.onPageSelected(position)
            binding.sliderImageView.currentItem
        }
    }
}