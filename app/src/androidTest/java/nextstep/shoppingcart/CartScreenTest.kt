package nextstep.shoppingcart

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import nextstep.shoppingcart.data.model.Product
import nextstep.shoppingcart.data.repository.CartRepository
import nextstep.shoppingcart.ui.screen.CartScreen
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class CartScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    private val products = listOf(
        Product(imageUrl = "", name = "상품+", price = 0),
        Product(imageUrl = "", name = "상품1", price = 10000),
        Product(imageUrl = "", name = "상품2", price = 10000)
    )

    @Before
    fun setup() {
        CartRepository.addAll(products)
        composeTestRule.setContent {
            CartScreen(onClickBackButton = {})
        }
    }

    @After
    fun tearDown() {
        CartRepository.clear()
    }

    @Test
    fun 담긴_상품_가격의_총합이_노출된다() {
        // Then
        composeTestRule.onNodeWithText("주문하기(20,000원)").assertExists()
    }

    @Test
    fun 담긴_상품을_제거할_수_있다() {
        // When
        composeTestRule.onAllNodesWithContentDescription("장바구니 상품 삭제")[1].performClick()

        // Then
        composeTestRule.onNodeWithText("상품1").assertDoesNotExist()
    }

    @Test
    fun 담긴_상품의_수량을_증가시키면_상품_가격에_반영된다() {
        // When
        composeTestRule.onAllNodesWithContentDescription("+")[1].performClick()

        // Then
        composeTestRule.onNodeWithText("주문하기(30,000원)").assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_감소시키면_상품_가격에_반영된다() {
        // When
        composeTestRule.onAllNodesWithContentDescription("-")[1].performClick()

        // Then
        composeTestRule.onNodeWithText("주문하기(10,000원)").assertExists()
    }

    @Test
    fun 담긴_상품의_수량을_1보다_적게_하면_상품이_삭제된다() {
        // When
        composeTestRule.onAllNodesWithContentDescription("-")[1].performClick()

        // Then
        composeTestRule.onNodeWithText("상품1").assertDoesNotExist()
    }
}
