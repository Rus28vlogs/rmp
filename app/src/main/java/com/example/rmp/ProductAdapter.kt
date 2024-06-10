package com.example.rmp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class ProductAdapter(private val context: Context, private val productList: List<Product>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.item_product, parent, false)

        val productNameTextView: TextView = view.findViewById(R.id.productNameTextView)
        val productPriceTextView: TextView = view.findViewById(R.id.productPriceTextView)

        val product = productList[position]

        productNameTextView.text = product.name
        productPriceTextView.text = product.price.toString()

        return view
    }

    override fun getItem(position: Int): Any {
        return productList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return productList.size
    }
}