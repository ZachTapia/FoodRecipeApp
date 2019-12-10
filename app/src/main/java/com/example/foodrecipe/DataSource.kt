package com.example.foodrecipe

import com.example.foodrecipe.models.RecipePost

class DataSource{

    companion object{

        fun createDataSet(): ArrayList<RecipePost>{
            val list = ArrayList<RecipePost>()
            list.add(
                RecipePost(
                    "World's Best Lasagna!",
                    "It takes a little work, but it is worth it.",
                    "https://images.unsplash.com/photo-1574894709920-11b28e7367e3?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80",
                    "John Chandler",
                    "4.9 / 5"
                )
            )
            list.add(
                RecipePost(
                    "Apple Pie by Grandma Ople",
                    "This was my grandmother's apple pie recipe. I have never seen another one quite like it. It will always be my favorite and has won me several first place prizes in local competitions. I hope it becomes one of your favorites as well!",
                    "https://images.unsplash.com/photo-1541016798630-d0563e0c6017?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1950&q=80",
                    "Moe Ople",
                    "4.2 / 5"
                )
            )

            list.add(
                RecipePost(
                    "Yummy Sweet Potato Casserole",
                    "My family begs me to make this creamy baked dish every Thanksgiving and Christmas. What makes it so good is the pecan topping! Try it and I'm sure it will become your new tradition!",
                    "https://images.unsplash.com/photo-1522784081430-8ac6a122cbc8?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1350&q=80",
                    "Tina B.",
                    "3.9 / 5"
                )
            )
            list.add(
                RecipePost(
                    "Slow Cooker Mashed Potatoes",
                    "These are melt in your mouth mashed potatoes, and what could be better than potatoes in the slow cooker?",
                    "https://images.unsplash.com/photo-1573810655264-8d1e50f1592d?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1490&q=80",
                    "Steven O.",
                    "5 / 5"
                )
            )
            return list
        }
    }
}