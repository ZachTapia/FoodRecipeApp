package com.example.foodrecipe

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.foodrecipe.models.RecipePost

import kotlinx.android.synthetic.main.layout_recipe_list_item.view.*

class RecipeRecyclerAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private var items: List<RecipePost> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return RecipeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_recipe_list_item, parent, false))
    }



    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder) {
            is RecipeViewHolder -> { holder.bind(items.get(position)) }
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun submitList(recipeList: List<RecipePost>) {
        items = recipeList
    }

    class RecipeViewHolder constructor(itemView: View): RecyclerView.ViewHolder(itemView) {

        val recipeTitle = itemView.recipe_title
        val recipeImage = itemView.recipe_image
        val recipeAuthor = itemView.recipe_author
        val recipeRating = itemView.recipe_rating

        fun bind(recipePost: RecipePost) {
            //Bind Strings
            recipeTitle.setText(recipePost.title)
            recipeAuthor.setText(recipePost.authorName)
            recipeRating.setText(recipePost.recipeRating)

            //Bind images using glide
            val requestOptions = RequestOptions()
                .placeholder(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)

            Glide.with(itemView.context)
                .applyDefaultRequestOptions(requestOptions)
                .load(recipePost.imageURL)
                .into(recipeImage)
        }
    }

}