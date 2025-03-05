package nextstep.shoppingcart.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import nextstep.shoppingcart.ui.theme.Blue50
import nextstep.shoppingcart.ui.theme.White

@Composable
fun BottomButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Button(
        onClick = onClick,
        modifier = modifier.fillMaxWidth(),
        shape = RectangleShape,
        colors = ButtonDefaults.buttonColors(
            containerColor = Blue50,
            contentColor = White
        ),
        contentPadding = PaddingValues(
            horizontal = 16.dp,
            vertical = 15.dp
        )
    ) {
        Text(
            text = text,
            modifier = modifier,
            color = White,
            fontSize = 20.sp,
            fontWeight = FontWeight.W700,
            fontFamily = FontFamily.SansSerif,
            lineHeight = 23.sp,
        )
    }
}

@Preview
@Composable
private fun BottomButtonPreview() {
    BottomButton(
        text = "장바구니 담기",
        onClick = {
            // NO-OP
        }
    )
}
