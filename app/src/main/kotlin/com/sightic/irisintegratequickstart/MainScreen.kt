package com.sightic.irisintegratequickstart


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sightic.irisintegratequickstart.viewmodel.MainViewModel
import com.sightic.irisintegratequickstart.views.ContentView


@Composable
fun MainScreen() {

    val viewModel = viewModel<MainViewModel>()
    val screen by viewModel.screen.collectAsStateWithLifecycle()

    ContentView(
        screen = screen,
        onAction = viewModel::onAction
    )

}