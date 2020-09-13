package ru.alena.testtask2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import ru.alena.testtask2.databinding.FragmentUserPageBinding

class UserPageFragment: Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentUserPageBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_user_page,
            container, false)
        return binding.root
    }
}