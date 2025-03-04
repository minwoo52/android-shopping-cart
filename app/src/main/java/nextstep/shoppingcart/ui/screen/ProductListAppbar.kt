package nextstep.shoppingcart.ui.screen

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.BlackDark
import nextstep.shoppingcart.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListAppBar(
    title: String,
    onClickActionButton: () -> Unit,
    modifier: Modifier = Modifier
) {
    val descriptionNavigate = stringResource(R.string.description_shopping_cart_navigate)

    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        modifier = modifier,
        actions = {
            IconButton(
                onClick = onClickActionButton
            ) {
                Icon(
                    imageVector = Icons.Filled.ShoppingCart,
                    contentDescription = descriptionNavigate,
                    modifier = modifier
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = White,
            titleContentColor = BlackDark,
        ),
    )
}

@Preview
@Composable
private fun ProductListAppBarPreview() {
    ProductListAppBar(
        title = "앱바 제목",
        onClickActionButton = {
            // No-op
        },
    )
}
