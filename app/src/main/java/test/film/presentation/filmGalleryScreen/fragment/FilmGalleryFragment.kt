package test.film.presentation.filmGalleryScreen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import test.film.R
import test.film.domain.model.FilmData
import test.film.presentation.detailsFilmScreen.fragment.DetailsFilmFragment
import test.film.presentation.filmGalleryScreen.compose.FilmGalleryScreen
import test.film.presentation.filmGalleryScreen.viewmodel.FilmGalleryVM

class FilmGalleryFragment : Fragment() {

    private val filmGalleryVM: FilmGalleryVM by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                FilmGalleryScreen(
                    filmGalleryVM.uiState,
                    ::openDetailsFilm,
                    filmGalleryVM::clickToGenre,
                    filmGalleryVM.activeGenre.value,
                    filmGalleryVM::reload
                )
            }
        }
    }

    private fun openDetailsFilm(film: FilmData) {
        if (activity == null) return
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.container, DetailsFilmFragment.newInstance(film))
            .addToBackStack(null)
            .commit()
    }

    companion object {
        @JvmStatic
        fun newInstance() = FilmGalleryFragment()
    }
}