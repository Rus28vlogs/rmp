package com.example.rmp

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.stripe.android.PaymentConfiguration
import com.stripe.android.paymentsheet.PaymentSheet
import com.stripe.android.paymentsheet.PaymentSheetResult

class itemActivity : AppCompatActivity() {
    private lateinit var paymentSheet: PaymentSheet
    private lateinit var paymentIntentClientSecret: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item)

        // Инициализация PaymentConfiguration
        PaymentConfiguration.init(applicationContext, "pk_test_51PPAqZBGs9PiDDTVeuZQq55RqC4U9Ax4VRC1ny0EcuAyDkIoXEDxZV4VQTRDhX2cxR5qVJO4fyZaFXX2UPQOoyws00s2Nq9Pgs")

        val title: TextView = findViewById(R.id.item_list_title_one)
        title.text = intent.getStringExtra("itemTitle")

        val description: TextView = findViewById(R.id.item_list_text)
        description.text = intent.getStringExtra("itemText")

        // Получение clientSecret из intent
        paymentIntentClientSecret = intent.getStringExtra("paymentIntentClientSecret") ?: ""


        val payButton: Button = findViewById(R.id.button_auth)
        payButton.setOnClickListener {
            presentPaymentSheet()
        }
    }

    private fun presentPaymentSheet() {
        paymentSheet.presentWithPaymentIntent(
            paymentIntentClientSecret,
            PaymentSheet.Configuration("Example, Inc.")
        )
    }


}
