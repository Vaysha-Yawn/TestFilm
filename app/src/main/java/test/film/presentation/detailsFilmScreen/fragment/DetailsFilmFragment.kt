package test.film.presentation.detailsFilmScreen.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import test.film.domain.model.FilmData
import test.film.presentation.detailsFilmScreen.compose.DetailsFilmScreen
import test.film.presentation.detailsFilmScreen.viewmodel.DetailsFilmVM

private const val MOVIE_ARG_NAME = "MOVIE"

class DetailsFilmFragment : Fragment() {

    private val detailsFilmVM: DetailsFilmVM by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            val film = it.getSerializable(MOVIE_ARG_NAME)
            detailsFilmVM.setData(film as FilmData)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireContext()).apply {
            setContent {
                DetailsFilmScreen(::close, detailsFilmVM.filmData.value)
            }
        }
    }

    private fun close() {
        if (activity == null) return
        requireActivity().supportFragmentManager.popBackStack()
    }

    companion object {
        @JvmStatic
        fun newInstance(film: FilmData) =
            DetailsFilmFragment().apply {
                arguments = Bundle().apply {
                    putSerializable(MOVIE_ARG_NAME, film)
                }
            }
    }
}