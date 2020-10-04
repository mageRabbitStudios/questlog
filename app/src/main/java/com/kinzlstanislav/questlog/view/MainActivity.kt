package com.kinzlstanislav.questlog.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.kinzlstanislav.questlog.R
import com.kinzlstanislav.questlog.base.ktx.bindView
import com.kinzlstanislav.questlog.base.ktx.emit
import com.kinzlstanislav.questlog.base.ktx.observe
import com.kinzlstanislav.questlog.base.ktx.removeTooltips
import com.kinzlstanislav.questlog.base.view.BottomNavigationViewWithIndicator
import com.kinzlstanislav.questlog.view.viewmodel.MainViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()
    private val mainActivityMotionLayout by bindView<MotionLayout>(R.id.mainActivityMotionLayout)
    private val bottomNavigationView by bindView<BottomNavigationViewWithIndicator>(R.id.bottomNavigation)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView.apply {
            itemIconTintList = null
            removeTooltips()
            val navController = findNavController(R.id.nav_host_fragment)
            setupWithNavController(navController)

            navController.addOnDestinationChangedListener { _, destination, _ ->
                when (destination.id) {
                    R.id.questsFragment -> moveIndicator(toPosition = 0)
                    R.id.abilitiesFragment -> moveIndicator(toPosition = 1)
                    R.id.profileFragment -> moveIndicator(toPosition = 2)
                }
            }
        }

        observe(viewModel.showBottomNavbarState) { showBottomNavigationBar ->
            if (showBottomNavigationBar) {
                mainActivityMotionLayout.transitionToEnd()
            } else {
                mainActivityMotionLayout.transitionToStart()
            }
        }

        viewModel.showBottomNavbarState.emit(true)
    }
}