package com.example.foodrecipe

class Recipe(val id : String? , val name: String, val ingredients : String, val direction : String) {

    constructor() : this ("","","","")
}