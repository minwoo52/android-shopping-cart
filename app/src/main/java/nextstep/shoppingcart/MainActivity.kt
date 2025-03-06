package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.screen.ProductListScreen
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ShoppingCartTheme {
                ProductListScreen(
                    onClickActionButton = {
                        moveToCartPage()
                    },
                    onClickProductItem = {
                        moveToProductDetailPage(product = it)
                    }
                )
            }
        }
    }

    private fun moveToProductDetailPage(product: Product) {
        val intent = ProductDetailActivity.newIntent(
            context = this,
            product = product
        )
        startActivity(intent)
    }

    private fun moveToCartPage() {
        CartActivity.start(this)
    }
}
