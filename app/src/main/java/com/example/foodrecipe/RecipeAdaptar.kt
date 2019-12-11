package com.example.foodrecipe

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(val recipeList: List<Recipe>) : RecyclerView.Adapter<ViewHolder>() {
    var data = listOf<Recipe>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount() = recipeList.size
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = recipeList[position]
        holder.textView.text = item.name

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater =LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.text_item_view, parent, false) as TextView
        return ViewHolder(view)
    }
}