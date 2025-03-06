package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import nextstep.shoppingcart.data.model.Cart
import nextstep.shoppingcart.data.model.Product

@Composable
fun CartLazyColumn(
    carts: List<Cart>,
    onClickRemoveButton: (Cart) -> Unit,
    onClickMinusButton: (Cart) -> Unit,
    onClickPlusButton: (Cart) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(
            horizontal = 18.dp,
            vertical = 16.dp
        ),
        verticalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        items(carts.size) { index ->
            CartItem(
                cart = carts[index],
                onClickRemoveButton = onClickRemoveButton,
                onClickMinusButton = onClickMinusButton,
                onClickPlusButton = onClickPlusButton,
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartLazyColumnPreview() {
    val carts: List<Cart> = List(3) { _ ->
        Cart(
            product = Product(
                imageUrl = "",
                name = "Android",
                price = 10000
            ),
            count = 2,
        )
    }

    CartLazyColumn(
        carts = carts,
        onClickRemoveButton = { /* NO-OP */ },
        onClickMinusButton = { /* NO-OP */ },
        onClickPlusButton = { /* NO-OP */ },
    )
}
