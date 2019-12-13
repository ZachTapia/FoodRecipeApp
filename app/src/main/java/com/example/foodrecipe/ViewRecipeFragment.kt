package com.example.foodrecipe


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.foodrecipe.databinding.FragmentViewRecipeBinding
import com.firebase.ui.auth.AuthUI
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.fragment_find_recipe.*
import com.google.android.youtube.player.YouTubeStandalonePlayer

/**
 * A simple [Fragment] subclass.
 */
class ViewRecipeFragment : Fragment() {

    private lateinit var binding: FragmentViewRecipeBinding
    private lateinit var  ref : DatabaseReference
    private lateinit var  recipeList : MutableList<Recipe>
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_view_recipe, container, false)

        ref = FirebaseDatabase.getInstance().getReference("recipes")


        ref.addValueEventListener(object: ValueEventListener {
            override fun onCancelled(p0: DatabaseError) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onDataChange(p0: DataSnapshot) {
                if(p0.exists()){
                    var data = p0.child("-LvvRsN1rp8rdyWHMrZj").getValue(Recipe :: class.java)
                    binding.recipeName.text = data!!.name
                    binding.Directions.text = "Directions:\n" +data!!.direction
                    binding.ingredientsList.text = "Ingredients:\n" + data!!.ingredients
                    binding.authorName.text = "By: "+data!!.author
                    binding.button.setOnClickListener {
                        val intent = YouTubeStandalonePlayer.createVideoIntent(activity, "XXXX", "YxVZuuxxXxk", 0, true, true);
                        startActivity(intent);
                    }

                }
            }

        })

        return binding.root
    }
}
