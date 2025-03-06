package nextstep.shoppingcart

import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.screen.ProductDetailScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {

    private val product: Product? by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getParcelableExtra(ARG_PRODUCT, Product::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(ARG_PRODUCT) as? Product ?: error("Product is required.")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = product!!,
                    onClickBackButton = { finish() },
                    onClickBottomButton = { moveToCartPage() }
                )
            }
        }
    }

    private fun moveToCartPage() {
        CartActivity.start(this)
    }

    companion object {

        private const val ARG_PRODUCT = "ARG_PRODUCT"

        fun newIntent(
            context: Context,
            product: Product
        ): Intent {
            return Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(ARG_PRODUCT, product)
            }
        }
    }
}
