package com.kinzlstanislav.questlog.view.fragments

import com.kinzlstanislav.questlog.R
import com.kinzlstanislav.questlog.base.BaseFragment
import com.kinzlstanislav.questlog.base.view.viewBinding
import com.kinzlstanislav.questlog.databinding.FragmentQuestsBinding
import com.kinzlstanislav.questlog.view.viewmodel.QuestsViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class QuestsFragment : BaseFragment(layoutId = R.layout.fragment_quests) {

    private val binding by viewBinding(FragmentQuestsBinding::bind)
    private val viewModel by viewModel<QuestsViewModel>()

    override fun onFragmentViewCreated() {
    }
}