package com.sightic.irisintegratequickstart


import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.sightic.irisintegrate.SighticSupportedDevice
import com.sightic.irisintegratequickstart.viewmodel.Action
import com.sightic.irisintegratequickstart.viewmodel.MainViewModel
import com.sightic.irisintegratequickstart.views.ContentView
import kotlinx.coroutines.launch


@Composable
fun MainScreen() {

    val context = LocalContext.current
    val scope = rememberCoroutineScope()

    val viewModel = viewModel<MainViewModel>()
    val screen by viewModel.screen.collectAsStateWithLifecycle()

    LaunchedEffect(scope) {
        scope.launch {
            val status = SighticSupportedDevice.status(context)
            viewModel.onAction(Action.OnDeviceSupportedStatusReceived(status))
        }
    }

    ContentView(
        screen = screen,
        onAction = viewModel::onAction
    )
}

