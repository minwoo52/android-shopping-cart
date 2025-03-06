package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.repository.CartRepository
import nextstep.shoppingcart.ui.component.BackButtonAppBar
import nextstep.shoppingcart.ui.component.CartLazyColumn
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.White

@Composable
fun CartScreen(
    onClickBackButton: () -> Unit,
) {
    val appBarTitle = stringResource(R.string.title_cart)
    var carts by remember { mutableStateOf(CartRepository.items) }

    Scaffold(
        topBar = {
            BackButtonAppBar(
                title = appBarTitle,
                onClick = onClickBackButton,
            )
        },
    ) { innerPadding ->
        CartLazyColumn(
            carts = carts,
            onClickRemoveButton = {
                carts = CartRepository.removeAll(it.product)
            },
            onClickMinusButton = {
                carts = CartRepository.removeOne(it.product)
            },
            onClickPlusButton = {
                carts = CartRepository.addOne(it.product)
            },
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(innerPadding),
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun CartScreenPreview() {
    ShoppingCartTheme {
        CartScreen(
            onClickBackButton = { /* NO-OP */ },
        )
    }
}
