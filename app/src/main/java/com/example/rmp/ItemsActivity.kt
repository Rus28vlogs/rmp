package com.example.rmp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_items)
        val itemsList: RecyclerView = findViewById(R.id.itemList)
        val items = arrayListOf<Item>()

        items.add(Item(1,"cat","Чеширский кот","Ручной Чеширский кот","Кот выполнен из гипгипоаллергенных материалов", 2500))
        items.add(Item(2,"owls","Керамические совы","Ручные керамические совы"," Совы выполнены из фарфора", 1700))
        items.add(Item(3,"sleep","Ловец снов","Якутский ловец снов","Поймает даже самый страшный кошмар", 800))

        itemsList.layoutManager = LinearLayoutManager(this)
        itemsList.adapter = ItemsAdapter(items,this)
    }
}
data class Itemm(
    val id: Int,
    val name: String,
    val description: String,
    val details: String,
    val price: Double
)