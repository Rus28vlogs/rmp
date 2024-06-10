package com.example.rmp

import android.app.Application
import com.stripe.android.PaymentConfiguration

class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        PaymentConfiguration.init(
            applicationContext,
            "pk_test_51PPAqZBGs9PiDDTVeuZQq55RqC4U9Ax4VRC1ny0EcuAyDkIoXEDxZV4VQTRDhX2cxR5qVJO4fyZaFXX2UPQOoyws00s2Nq9Pgs"
        )
    }
}
