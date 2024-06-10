// ShopActivity.kt

package com.example.rmp

import android.content.ContentValues
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class ShopActivity : AppCompatActivity() {

    private lateinit var dbHelper: DatabaseHelper
    private lateinit var productList: MutableList<Product>
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop)

        dbHelper = DatabaseHelper(this)

        val etProductName: EditText = findViewById(R.id.etProductName)
        val etProductPrice: EditText = findViewById(R.id.etProductPrice)
        val btnAddProduct: Button = findViewById(R.id.btnAddProduct)
        val productListView: ListView = findViewById(R.id.productListView)

        productList = mutableListOf()
        productAdapter = ProductAdapter(this, productList)
        productListView.adapter = productAdapter

        btnAddProduct.setOnClickListener {
            val name = etProductName.text.toString()
            val price = etProductPrice.text.toString().toDoubleOrNull()

            if (name.isNotEmpty() && price != null) {
                addProductToDatabase(name, price)
                etProductName.text.clear()
                etProductPrice.text.clear()
                updateProductList()
            } else {
                Toast.makeText(this, "Пожалуйста, введите корректные данные о товаре", Toast.LENGTH_SHORT).show()
            }
        }

        updateProductList()
    }

    private fun addProductToDatabase(name: String, price: Double) {
        val db = dbHelper.writableDatabase
        val values = ContentValues().apply {
            put(DatabaseHelper.COLUMN_NAME, name)
            put(DatabaseHelper.COLUMN_PRICE, price)
        }

        val newRowId = db?.insert(DatabaseHelper.TABLE_PRODUCTS, null, values)
        if (newRowId == -1L) {
            Toast.makeText(this, "Ошибка при добавлении товара", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, "Товар успешно добавлен в БД с ID: $newRowId", Toast.LENGTH_SHORT).show()
        }
    }

    private fun updateProductList() {
        productList.clear()
        productList.addAll(dbHelper.getAllProducts())
        productAdapter.notifyDataSetChanged()
    }
}
