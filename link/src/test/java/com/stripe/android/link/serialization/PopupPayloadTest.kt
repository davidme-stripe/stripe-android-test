package com.stripe.android.link.serialization

import com.google.common.truth.Truth.assertThat
import kotlinx.serialization.json.Json
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner

@RunWith(RobolectricTestRunner::class)
@Suppress("MaxLineLength")
internal class PopupPayloadTest {
    @Test
    fun testJsonSerialization() {
        val json = Json.encodeToString(PopupPayload.serializer(), createPayload())
        assertThat(json).isEqualTo("""{"publishableKey":"pk_test_abc","stripeAccount":"123","merchantInfo":{"businessName":"Jay's Taco Stand","country":"US"},"customerInfo":{"email":"jaystacostandfake@gmail.com","country":"US"},"paymentInfo":{"currency":"USD","amount":5555},"returnUrl":"stripesdk://link_return_url","locale":"US"}""")
    }

    @Test
    fun testToUrl() {
        assertThat(createPayload().toUrl()).isEqualTo("https://checkout.link.com/link-popup.html#eyJwdWJsaXNoYWJsZUtleSI6InBrX3Rlc3RfYWJjIiwic3RyaXBlQWNjb3VudCI6IjEyMyIsIm1lcmNoYW50SW5mbyI6eyJidXNpbmVzc05hbWUiOiJKYXkncyBUYWNvIFN0YW5kIiwiY291bnRyeSI6IlVTIn0sImN1c3RvbWVySW5mbyI6eyJlbWFpbCI6ImpheXN0YWNvc3RhbmRmYWtlQGdtYWlsLmNvbSIsImNvdW50cnkiOiJVUyJ9LCJwYXltZW50SW5mbyI6eyJjdXJyZW5jeSI6IlVTRCIsImFtb3VudCI6NTU1NX0sInJldHVyblVybCI6InN0cmlwZXNkazovL2xpbmtfcmV0dXJuX3VybCIsImxvY2FsZSI6IlVTIn0=")
    }

    private fun createPayload(): PopupPayload = PopupPayload(
        publishableKey = "pk_test_abc",
        stripeAccount = "123",
        merchantInfo = PopupPayload.MerchantInfo(
            businessName = "Jay's Taco Stand",
            country = "US",
        ),
        customerInfo = PopupPayload.CustomerInfo(
            email = "jaystacostandfake@gmail.com",
            country = "US",
        ),
        paymentInfo = PopupPayload.PaymentInfo(
            currency = "USD",
            amount = 5555,
        ),
        returnUrl = "stripesdk://link_return_url",
        locale = "US",
    )
}
