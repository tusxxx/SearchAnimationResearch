package com.pi.searchanimationresearch

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.compose.ui.platform.ComposeView
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.transition.TransitionInflater

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(requireActivity()).apply {
            setContent {
                HomeScreen { openSearchFragment() }
            }
        }
    }

    private fun openSearchFragment() {
        val inflater = TransitionInflater.from(requireContext()) // create inflater
        val editText =
            requireActivity().findViewById<EditText>(R.id.etFakeSearch)  // наша вьюшка в компоузе
        val searchFragment = SearchFragment().apply {  // создаем фрагмент
            sharedElementEnterTransition =
                inflater.inflateTransition(R.transition.transform) // устанавливаем для него анимку для шаред вьюшек
            enterTransition =
                inflater.inflateTransition(R.transition.fade) // опцианально - анимация перехода между фрагментами
        }

        requireActivity().supportFragmentManager.commit {
            replace(R.id.fcv, searchFragment)
            addSharedElement(
                editText,
                editText.transitionName
            ) // сюда пихаем вьюшку из первого фрагмента и transitionName который прописали у них
            addToBackStack(null)
        }
    }
}