package nextstep.shoppingcart.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.util.Locale

@Parcelize
data class Product(
    val imageUrl: String,
    val name: String,
    val price: Int,
) : Parcelable {
    val formattedPrice: String
        get() = String.format(Locale.KOREA, "%,d원", price)
}
