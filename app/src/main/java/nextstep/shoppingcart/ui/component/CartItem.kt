package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import nextstep.shoppingcart.R
import nextstep.shoppingcart.data.model.Cart
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.ui.theme.Black
import nextstep.shoppingcart.ui.theme.Gray
import nextstep.shoppingcart.ui.theme.Gray10
import nextstep.shoppingcart.ui.theme.White

@Composable
fun CartItem(
    cart: Cart,
    onClickRemoveButton: (Cart) -> Unit,
    onClickMinusButton: (Cart) -> Unit,
    onClickPlusButton: (Cart) -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .background(color = White, shape = RoundedCornerShape(4.dp))
            .border(width = 1.dp, color = Gray10, shape = RoundedCornerShape(4.dp))
            .padding(18.dp)
    ) {
        ProductNameWithRemoveButtonRow(
            productName = cart.product.name,
            onClickButton = { onClickRemoveButton(cart) },
        )
        ProductWithQuantitySelectorRow(
            imageUrl = cart.product.imageUrl,
            formattedPrice = cart.product.formattedPrice,
            quantity = cart.count,
            onClickMinusButton = { onClickMinusButton(cart) },
            onClickPlusButton = { onClickPlusButton(cart) },
            modifier = modifier
        )
    }
}

@Composable
private fun ProductNameWithRemoveButtonRow(
    productName: String,
    onClickButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val closeIcon = ImageVector.vectorResource(R.drawable.close_24px)
    val descriptionCartRemove = stringResource(R.string.description_shopping_cart_remove)

    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = productName,
            modifier = modifier.weight(1f),
            color = Black,
            fontSize = 20.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 0.5.sp,
            lineHeight = 24.sp,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
        )

        IconButton(onClick = onClickButton) {
            Icon(
                imageVector = closeIcon,
                contentDescription = descriptionCartRemove
            )
        }
    }
}

@Composable
private fun ProductWithQuantitySelectorRow(
    imageUrl: String,
    formattedPrice: String,
    quantity: Int,
    onClickMinusButton: () -> Unit,
    onClickPlusButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        AsyncImage(
            model = imageUrl,
            contentDescription = null,
            modifier = modifier.size(width = 136.dp, height = 84.dp),
            placeholder = ColorPainter(Gray),
            contentScale = ContentScale.Fit
        )

        Column(
            modifier = modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.End
        ) {
            Text(
                text = formattedPrice,
                color = Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.W400,
                fontFamily = FontFamily.SansSerif,
                letterSpacing = 0.5.sp,
            )

            QuantitySelector(
                quantity = quantity,
                onClickMinusButton = onClickMinusButton,
                onClickPlusButton = onClickPlusButton,
                modifier = modifier.wrapContentWidth()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun CartItemPreview() {
    CartItem(
        cart = Cart(
            product = Product(
                imageUrl = "",
                name = "AndroidAndroidAndroidAndroidAndroidAndroid",
                price = 10000
            ),
            count = 1123
        ),
        onClickRemoveButton = { /* NO-OP */ },
        onClickMinusButton = { /* NO-OP */ },
        onClickPlusButton = { /* NO-OP */ },
    )
}
