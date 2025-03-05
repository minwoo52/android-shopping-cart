package nextstep.shoppingcart.ui.component

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import nextstep.shoppingcart.R
import nextstep.shoppingcart.ui.theme.BlackDark
import nextstep.shoppingcart.ui.theme.White

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BackButtonAppBar(
    title: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    val backArrowIcon = ImageVector.vectorResource(R.drawable.arrow_back_24px)
    val descriptionNavigate = stringResource(R.string.description_back_navigate)

    TopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        modifier = modifier,
        navigationIcon = {
            IconButton(onClick = onClick) {
                Icon(
                    imageVector = backArrowIcon,
                    contentDescription = descriptionNavigate
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
private fun BackButtonAppBarPreview() {
    BackButtonAppBar(
        title = "앱바 제목",
        onClick = {
            // No-op
        },
    )
}
