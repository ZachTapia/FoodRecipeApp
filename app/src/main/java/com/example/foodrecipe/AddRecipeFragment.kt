package com.example.foodrecipe


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.foodrecipe.databinding.FragmentAddRecipeBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_find_recipe.view.*

/**
 * A simple [Fragment] subclass.
 */
class AddRecipeFragment : Fragment() {

    private lateinit var binding: FragmentAddRecipeBinding
    private lateinit var  ref : DatabaseReference


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        ref = FirebaseDatabase.getInstance().getReference("recipes")


        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_add_recipe, container, false)


        binding.submitButton.setOnClickListener {
            inputRecipe()
        }



        return binding.root
    }

    private fun inputRecipe (){
        val name = binding.recipeName.text.toString()
        val ingredients = binding.ingredientsList.text.toString()
        val directions = binding.directions.text.toString()
        if (name.isEmpty()){
            binding.recipeName.error = "Please Enter a Recipe Name"
            return
        }


        //val ref = FirebaseDatabase.getInstance().getReference("recipes")

        val recipeId = ref.push().key

        val recipe = Recipe(recipeId, name, ingredients, directions)

        ref.child(recipeId.toString()).setValue(recipe).addOnCompleteListener {
            Toast.makeText(activity , "Recipe has been submitted", Toast.LENGTH_LONG).show()
            binding.recipeName.text.clear()
            binding.ingredientsList.text.clear()
            binding.directions.text.clear()
        }

    }
}