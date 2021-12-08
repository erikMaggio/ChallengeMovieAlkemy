package com.example.challengemovie.Ui.Fragment
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.challengemovie.ViewModel.DetailsViewModel
import com.example.challengemovie.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment : Fragment() {

    private val detailsViewModel by activityViewModels<DetailsViewModel>()
    private lateinit var binding: FragmentDetailsBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        detailsViewModel.getDetails(getBundle()!!)

        detailsViewModel.liveData.observe(viewLifecycleOwner, {
            binding.tvTitle.text =it.title
            binding.tvPopularity.text =it.popularity.toString()
            binding.tvGenres.text = it.genres[1].name
            binding.tvOriginalLenguage.text =it.originalLanguage
            binding.tvReleaseDate.text =it.releaseDate

        })

        return binding.root
    }
    private fun getBundle(): Int? {
        val data = arguments?.getInt("id")
        return data
    }
}