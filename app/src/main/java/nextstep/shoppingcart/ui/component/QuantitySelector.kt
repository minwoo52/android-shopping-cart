package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.Black
import nextstep.shoppingcart.ui.theme.White
import java.text.NumberFormat
import java.util.Locale

@Composable
fun QuantitySelector(
    quantity: Int,
    onClickMinusButton: () -> Unit,
    onClickPlusButton: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.background(White),
        verticalAlignment = Alignment.CenterVertically
    ) {
        QuantityButton(
            symbol = stringResource(R.string.minus),
            onClick = onClickMinusButton,
            modifier = modifier.size(42.dp)
        )

        FormatQuantity(
            quantity = quantity,
            modifier = Modifier.wrapContentWidth()

        )

        QuantityButton(
            symbol = stringResource(R.string.plus),
            onClick = onClickPlusButton,
            modifier = modifier.size(42.dp)
        )
    }
}

@Composable
private fun QuantityButton(
    symbol: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = White,
            contentColor = Black
        ),
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            text = symbol,
            fontSize = 22.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily.SansSerif,
            letterSpacing = 0.5.sp,
            textAlign = TextAlign.Center,
        )
    }
}

@Composable
private fun FormatQuantity(
    quantity: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = NumberFormat.getNumberInstance(Locale.getDefault()).format(quantity),
        modifier = modifier,
        color = Black,
        fontSize = 22.sp,
        fontWeight = FontWeight.W400,
        fontFamily = FontFamily.SansSerif,
        letterSpacing = 0.5.sp,
        textAlign = TextAlign.Center
    )
}

@Preview
@Composable
private fun QuantitySelectorPreview() {
    QuantitySelector(
        quantity = 1234,
        onClickMinusButton = {},
        onClickPlusButton = {}
    )
}
