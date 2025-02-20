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
import com.sightic.irisintegratequickstart.ui.theme.Amber
import com.sightic.irisintegratequickstart.ui.theme.Green
import com.sightic.irisintegratequickstart.ui.theme.IRISIntegrateQuickstartTheme
import com.sightic.irisintegratequickstart.viewmodel.Action

@Composable
fun ResultView(hasImpairment: Boolean, onAction: (Action) -> Unit) {
    Box(Modifier.fillMaxSize()) {
        Header(
            title = stringResource(R.string.result),
            subtitle = when {
                hasImpairment -> stringResource(R.string.scan_result_is_positive)
                else -> stringResource(R.string.scan_result_is_negative)
            },
            backgroundColor = when {
                hasImpairment -> Amber
                else -> Green
            }
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
private fun StartViewPositivePreview() {
    IRISIntegrateQuickstartTheme {
        ResultView(true) {}
    }
}

@Preview(showBackground = true)
@Composable
private fun StartViewNegativePreview() {
    IRISIntegrateQuickstartTheme {
        ResultView(false) {}
    }
}