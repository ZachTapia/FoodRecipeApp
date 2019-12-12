package com.example.foodrecipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


import kotlinx.android.synthetic.main.text_item_view.view.*

class RecipeAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<Recipe> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.text_item_view, parent, false))
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is RecipeViewHolder -> { holder.bind(items.get(position)) }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(recipeList: List<Recipe>) {
        items = recipeList
    }

    class RecipeViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

        val recipeTitle = itemView.recipe_title
        //val recipeImage = itemView.recipe_image
        val recipeAuthor = itemView.recipe_author
        val recipeRating = itemView.recipe_rating

        fun bind(recipePost: Recipe) {
            //Bind Strings
            recipeTitle.setText(recipePost.name)
            recipeAuthor.setText(recipePost.author)
            recipeRating.setText(recipePost.recipeRating)


            //Bind images using glide
            /*val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(recipePost.imageURL)
                .into(recipeImage)*/
        }
    }


}