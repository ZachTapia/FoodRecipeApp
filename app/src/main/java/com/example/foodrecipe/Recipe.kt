package com.example.foodrecipe

class Recipe(val id : String? , val name: String, val author: String, val ingredients : String, val direction : String, val recipeRating : String,
             val imageURL : String) {

    constructor() : this("", "", "", "", "", "", "")
}