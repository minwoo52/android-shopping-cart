package nextstep.shoppingcart

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
                        moveToProductDetailPage(productId = it.randomId)
                    }
                )
            }
        }
    }

    private fun moveToProductDetailPage(productId: String) {
        val intent = ProductDetailActivity.newIntent(
            context = this,
            productId = productId
        )
        startActivity(intent)
    }

    private fun moveToCartPage() {
        CartActivity.start(this)
    }
}
