package test.film.presentation.detailsFilmScreen.fragment

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import test.film.R
import test.film.presentation.detailsFilmScreen.viewmodel.DetailsFilmVM

private const val MOVIE_ID_ARG_NAME = "MOVIE_ID"

class DetailsFilmFragment : Fragment() {

    private var movieId: String? = null
    private val detailsFilmVM:DetailsFilmVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            movieId = it.getString(MOVIE_ID_ARG_NAME)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.details_film, container, false)
        return view
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    private fun close(){
        if (activity == null) return
        requireActivity().supportFragmentManager.popBackStack()
    }

    companion object {
        @JvmStatic
        fun newInstance(movieId: String) =
            DetailsFilmFragment().apply {
                arguments = Bundle().apply {
                    putString(MOVIE_ID_ARG_NAME, movieId)
                }
            }
    }
}