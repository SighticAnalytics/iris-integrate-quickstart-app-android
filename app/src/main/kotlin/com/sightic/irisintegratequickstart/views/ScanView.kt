package com.sightic.irisintegratequickstart.views

import androidx.compose.runtime.Composable
import com.sightic.irisintegrate.SighticView
import com.sightic.irisintegratequickstart.viewmodel.Action

@Composable
fun ScanView(onAction: (Action) -> Unit) {
    SighticView {
        onAction.invoke(Action.OnResultReceived(it))
    }
}