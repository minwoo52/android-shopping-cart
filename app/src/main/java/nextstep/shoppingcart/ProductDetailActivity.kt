package nextstep.shoppingcart

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.ProductDetailScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class ProductDetailActivity : ComponentActivity() {

    private val productId: String by lazy {
        intent.getStringExtra(ARG_PRODUCT_ID)
            ?: throw IllegalArgumentException("productId is required")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductDetailScreen(
                    product = getDummyProduct(),
                    onClickBackButton = { finish() },
                    onClickBottomButton = { moveToCartPage() }
                )
            }
        }
    }

    private fun getDummyProduct(): Product {
        return Product(
            imageUrl = "https://picsum.photos/600/600?random=$productId",
            name = "PET보틀-원형(500ml)",
            price = 42200
        )
    }

    private fun moveToCartPage() {
        CartActivity.start(this)
    }

    companion object {

        const val ARG_PRODUCT_ID = "productId"

        fun newIntent(
            context: Context,
            productId: String
        ): Intent {
            return Intent(context, ProductDetailActivity::class.java).apply {
                putExtra(ARG_PRODUCT_ID, productId)
            }
        }
    }
}
