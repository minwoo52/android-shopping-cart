package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.Product
import nextstep.shoppingcart.ui.component.ProductLazyGrid
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme

@Composable
fun ProductListScreen(
    onClickActionButton: () -> Unit,
    onClickProductItem: (Product) -> Unit,
) {
    val appBarTitle = stringResource(R.string.title_product_list)
    val products: List<Product> = List(20) { index ->
        Product(
            imageUrl = "https://picsum.photos/id/${getRandomId()}/600/600",
            name = "상품명 $index",
            price = 10000
        )
    }

    Scaffold(
        topBar = {
            ProductListAppBar(
                title = appBarTitle,
                onClickActionButton = onClickActionButton,
            )
        },
    ) { innerPadding ->
        ProductLazyGrid(
            products = products,
            onClick = onClickProductItem,
            modifier = Modifier.padding(innerPadding)
        )
    }
}

private fun getRandomId(): Int = (100..200).random()

@Preview(showBackground = true)
@Composable
private fun ProductScreenPreview() {
    ShoppingCartTheme {
        ProductListScreen(
            onClickActionButton = {
                // NO-OP
            },
            onClickProductItem = {
                // NO-OP
            }
        )
    }
}
