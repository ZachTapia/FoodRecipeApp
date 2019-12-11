package com.example.foodrecipe



import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodrecipe.databinding.FragmentFindRecipeBinding
import kotlinx.android.synthetic.main.fragment_find_recipe.*

/**
 * A simple [Fragment] subclass.
 */
class FindRecipeFragment : Fragment() {

    private lateinit var recipeAdapter: RecipeRecyclerAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val binding = DataBindingUtil.inflate<FragmentFindRecipeBinding>(inflater, R.layout.fragment_find_recipe, container, false)

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        recycler_view.apply {
            layoutManager = LinearLayoutManager(activity)
            val topSpacingItemDecoration = TopSpacingItemDecoration(30)
            addItemDecoration(topSpacingItemDecoration)
            recipeAdapter = RecipeRecyclerAdapter()
            adapter = recipeAdapter
        }


        val data = DataSource.createDataSet()
        recipeAdapter.submitList(data)

    }


}

