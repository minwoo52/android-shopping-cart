package nextstep.shoppingcart.ui.component

import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun Snackbar(
    hostState: SnackbarHostState,
    modifier: Modifier = Modifier
) {
    SnackbarHost(
        hostState = hostState,
        modifier = modifier
    ) { snackbar ->
        Snackbar(
            snackbarData = snackbar,
            modifier = modifier,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun SnackbarPreview() {
    val hostState = SnackbarHostState()

    Snackbar(
        hostState = hostState
    )

    LaunchedEffect(Unit) {
        hostState.showSnackbar(
            message = "Message",
            actionLabel = "Button",
        )
    }
}
