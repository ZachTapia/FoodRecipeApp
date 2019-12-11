package com.example.foodrecipe


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.databinding.DataBindingUtil
import com.example.foodrecipe.databinding.FragmentFindRecipeBinding
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_find_recipe.view.*

/**
 * A simple [Fragment] subclass.
 */
class FindRecipeFragment : Fragment() {

    private lateinit var  ref : DatabaseReference
    private lateinit var  recipeList : MutableList<Recipe>
    private lateinit var binding : FragmentFindRecipeBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_find_recipe, container, false)

        ref = FirebaseDatabase.getInstance().getReference("recipes")

        recipeList = mutableListOf()





        ref.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    recipeList.clear()
                    for (i in p0.children){
                        val recipe = i.getValue(Recipe :: class.java)
                        recipeList.add(recipe!!)
                    }
                    val adapter = RecipeAdapter(recipeList)

                    binding.listView.adapter = adapter

                }
            }

        })



        return binding.root
    }

    fun displayComment(){

    }


}
