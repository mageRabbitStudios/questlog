package com.kinzlstanislav.questlog.view.fragments

import com.kinzlstanislav.questlog.R
import com.kinzlstanislav.questlog.base.BaseFragment
import com.kinzlstanislav.questlog.base.view.viewBinding
import com.kinzlstanislav.questlog.databinding.FragmentAbilitiesBinding
import com.kinzlstanislav.questlog.view.viewmodel.AbilitiesViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class AbilitiesFragment : BaseFragment(layoutId = R.layout.fragment_abilities) {

    private val binding by viewBinding(FragmentAbilitiesBinding::bind)
    private val viewModel by viewModel<AbilitiesViewModel>()

    override fun onFragmentViewCreated() {
    }
}