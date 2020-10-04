package com.kinzlstanislav.questlog

import com.kinzlstanislav.questlog.view.viewmodel.AbilitiesViewModel
import com.kinzlstanislav.questlog.view.viewmodel.MainViewModel
import com.kinzlstanislav.questlog.view.viewmodel.ProfileViewModel
import com.kinzlstanislav.questlog.view.viewmodel.QuestsViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object KoinModules {
    val VIEW_MODEL_MODULE = module {
        viewModel {
            AbilitiesViewModel()
        }
        viewModel {
            ProfileViewModel()
        }
        viewModel {
            QuestsViewModel()
        }
        viewModel {
            MainViewModel()
        }
    }
    val APP_MODULE = module {

    }
}