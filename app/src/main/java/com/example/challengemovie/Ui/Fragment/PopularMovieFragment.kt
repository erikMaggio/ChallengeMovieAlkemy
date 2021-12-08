package com.example.challengemovie.Ui.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challengemovie.R
import com.example.challengemovie.Ui.Fragment.DetailsFragment
import com.example.challengemovie.Ui.Fragment.adapter.MovieAdapter
import com.example.challengemovie.ViewModel.PopularViewModel
import com.example.challengemovie.databinding.FragmentPopularMovieBinding
import com.example.challengemovie.model.Response.Movie
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PopularMovieFragment : Fragment() {

    private val popularViewModel by activityViewModels<PopularViewModel>()
    private lateinit var binding: FragmentPopularMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPopularMovieBinding.inflate(inflater, container, false)

        popularViewModel.getPopular(1)

        popularViewModel.listLiveData.observe(viewLifecycleOwner, {
            initRecyclerView(it.result)
        })

        binding.bt1.setOnClickListener {
            popularViewModel.getPopular(1)
        }
        binding.bt2.setOnClickListener {
            popularViewModel.getPopular(2)
        }
        binding.bt3.setOnClickListener {
            popularViewModel.getPopular(3)
        }
        binding.bt4.setOnClickListener {
            popularViewModel.getPopular(4)
        }
        binding.bt5.setOnClickListener {
            popularViewModel.getPopular(5)
        }

        return binding.root
    }

    private fun initRecyclerView(list: Array<Movie>) {
        val adapter = MovieAdapter(list)

        adapter.setOnClickListener(object : MovieAdapter.OnClickListener {
            override fun onItemClick(position: Int) {

                val bundle = Bundle()
                bundle.putInt("id", list[position].id)
                val fragment = DetailsFragment()
                fragment.arguments = bundle
                findNavController().navigate(R.id.detailsFragment, bundle)
            }
        })
        binding.rvList.layoutManager =
            LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        binding.rvList.adapter = adapter
    }


}