package nextstep.shoppingcart.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.component.BackButtonAppBar
import nextstep.shoppingcart.ui.component.BottomButton
import nextstep.shoppingcart.ui.theme.Black
import nextstep.shoppingcart.ui.theme.Gray
import nextstep.shoppingcart.ui.theme.GrayLight
import nextstep.shoppingcart.ui.theme.ShoppingCartTheme
import nextstep.shoppingcart.ui.theme.White

@Composable
fun ProductDetailScreen(
    product: Product,
    onClickBackButton: () -> Unit,
    onClickBottomButton: () -> Unit,
) {
    val appBarTitle = stringResource(R.string.title_product_detail)
    val addToCartButtonText = stringResource(R.string.button_add_to_cart)

    Scaffold(
        topBar = {
            BackButtonAppBar(
                title = appBarTitle,
                onClick = onClickBackButton,
            )
        },
        bottomBar = {
            BottomButton(
                text = addToCartButtonText,
                onClick = onClickBottomButton,
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(White)
                .padding(innerPadding)
        ) {
            ProductImage(imageUrl = product.imageUrl)

            ProductName(name = product.name)

            HorizontalDivider(color = GrayLight)

            ProductPriceRow(price = product.price.toString())
        }
    }
}

@Composable
private fun ProductImage(
    imageUrl: String,
    modifier: Modifier = Modifier,
) {
    AsyncImage(
        model = imageUrl,
        contentDescription = null,
        modifier = modifier
            .fillMaxWidth()
            .aspectRatio(1f),
        placeholder = ColorPainter(Gray),
    )
}

@Composable
private fun ProductName(
    name: String,
    modifier: Modifier = Modifier,
) {
    Text(
        text = name,
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp),
        color = Black,
        fontSize = 24.sp,
        fontWeight = FontWeight.W700,
        fontFamily = FontFamily.SansSerif,
        textAlign = TextAlign.Start,
        lineHeight = 28.sp,
        letterSpacing = 0.5.sp,
    )
}

@Composable
private fun ProductPriceRow(
    price: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(18.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = stringResource(R.string.label_price),
            color = Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 0.5.sp,
        )

        Text(
            text = price,
            modifier = modifier.weight(1f),
            fontSize = 20.sp,
            fontWeight = FontWeight.W400,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.End
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ProductScreenPreview() {
    val product = Product(
        imageUrl = "",
        name = "PET보틀-원형(500ml)",
        price = 10000
    )
    ShoppingCartTheme {
        ProductDetailScreen(
            product = product,
            onClickBackButton = {
                // NO-OP
            },
            onClickBottomButton = {
                // NO-OP
            }
        )
    }
}
