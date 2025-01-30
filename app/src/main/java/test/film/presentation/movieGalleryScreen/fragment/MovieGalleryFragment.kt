package test.film.presentation.movieGalleryScreen.fragment

import android.content.res.Configuration
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.koin.androidx.viewmodel.ext.android.viewModel
import test.film.R
import test.film.presentation.detailsFilmScreen.fragment.DetailsFilmFragment
import test.film.presentation.movieGalleryScreen.viewmodel.MovieGalleryVM

class MovieGalleryFragment : Fragment() {

    private val movieGalleryVM:MovieGalleryVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       val view = inflater.inflate(R.layout.movie_gallery, container, false)
        return view
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
    }

    private fun openDetailsFilm(movieId:String){
        if (activity == null) return
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container, DetailsFilmFragment.newInstance(movieId))
            .setCustomAnimations(R.anim.slide_in, R.anim.slide_out)
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = MovieGalleryFragment()
    }
}