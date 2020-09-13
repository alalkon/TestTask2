package ru.alena.testtask2

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import ru.alena.testtask2.databinding.FragmentStarterBinding


class StarterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentStarterBinding>(inflater,
            R.layout.fragment_starter, container, false)

        binding.loginButton.setOnClickListener{view: View ->
            view.findNavController()
                .navigate(R.id.action_starterFragment_to_loginFragment) }
        binding.signUpButton.setOnClickListener{view: View ->
            view.findNavController()
                .navigate(R.id.action_starterFragment_to_signFragment) }

        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.option_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
            onNavDestinationSelected(item, requireView().findNavController())
                ||super.onOptionsItemSelected(item)

    }
}