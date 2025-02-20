package com.sightic.irisintegratequickstart.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.sightic.irisintegratequickstart.R
import com.sightic.irisintegratequickstart.components.Header
import com.sightic.irisintegratequickstart.components.HugeButton
import com.sightic.irisintegratequickstart.ui.theme.IRISIntegrateQuickstartTheme
import com.sightic.irisintegratequickstart.ui.theme.Red
import com.sightic.irisintegratequickstart.viewmodel.Action

@Composable
fun ErrorView(errorMessage: String, onAction: (Action) -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Header(
            title = stringResource(R.string.error),
            subtitle = errorMessage,
            backgroundColor = Red
        )
        HugeButton(
            text = stringResource(R.string.done),
            modifier = Modifier
                .align(Alignment.Center),
            onClick = {
                onAction.invoke(Action.OnDoneClicked)
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StartViewPreview() {
    IRISIntegrateQuickstartTheme {
        ErrorView("Something went wrong...") { }
    }
}