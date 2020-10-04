package com.kinzlstanislav.questlog.view.fragments

import com.kinzlstanislav.questlog.R
import com.kinzlstanislav.questlog.databinding.FragmentProfileBinding
import com.kinzlstanislav.questlog.base.BaseFragment
import com.kinzlstanislav.questlog.base.view.viewBinding
import com.kinzlstanislav.questlog.view.viewmodel.ProfileViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class ProfileFragment : BaseFragment(layoutId = R.layout.fragment_profile) {

    private val binding by viewBinding(FragmentProfileBinding::bind)
    private val viewModel by viewModel<ProfileViewModel>()

    override fun onFragmentViewCreated() {

    }
}