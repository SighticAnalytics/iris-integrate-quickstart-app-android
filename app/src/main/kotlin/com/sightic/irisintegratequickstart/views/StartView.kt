package com.sightic.irisintegratequickstart.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sightic.irisintegrate.LibraryVersion
import com.sightic.irisintegratequickstart.R
import com.sightic.irisintegratequickstart.components.Header
import com.sightic.irisintegratequickstart.components.HugeButton
import com.sightic.irisintegratequickstart.ui.theme.IRISIntegrateQuickstartTheme
import com.sightic.irisintegratequickstart.viewmodel.Action

@Composable
fun StartView(onAction: (Action) -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Header(
            stringResource(R.string.app_name),
            stringResource(R.string.iris_integrate_version, LibraryVersion.description)
        )
        HugeButton(
            text = stringResource(R.string.start_scan),
            modifier = Modifier.align(Alignment.Center),
            onClick = {
                onAction.invoke(Action.OnStartScanClicked)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StartViewPreview() {
    IRISIntegrateQuickstartTheme {
        StartView {}
    }
}