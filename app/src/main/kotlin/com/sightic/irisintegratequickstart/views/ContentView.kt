package com.sightic.irisintegratequickstart.views

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.sightic.irisintegrate.error.AlignmentError
import com.sightic.irisintegratequickstart.extensions.asReadableError
import com.sightic.irisintegratequickstart.ui.theme.IRISIntegrateQuickstartTheme
import com.sightic.irisintegratequickstart.viewmodel.Action
import com.sightic.irisintegratequickstart.viewmodel.Screen

@Composable
fun ContentView(
    screen: Screen,
    onAction: (Action) -> Unit
) {
    when (screen) {
        is Screen.Start -> StartView(onAction)
        is Screen.Scan -> ScanView(onAction)
        is Screen.Inference -> InferenceView()
        is Screen.Result -> ResultView(screen.hasImpairment, onAction)
        is Screen.Error -> ErrorView(screen.error.asReadableError(), onAction)
    }

}

@Preview(showBackground = true)
@Composable
private fun ContentViewPreview() {
    IRISIntegrateQuickstartTheme {
        ContentView(
            screen = Screen.Start,
            onAction = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentViewInferencePreview() {
    IRISIntegrateQuickstartTheme {
        ContentView(
            screen = Screen.Inference,
            onAction = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentViewResultPositivePreview() {
    IRISIntegrateQuickstartTheme {
        ContentView(
            screen = Screen.Result(true),
            onAction = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentViewResultNegativePreview() {
    IRISIntegrateQuickstartTheme {
        ContentView(
            screen = Screen.Result(false),
            onAction = {}
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun ContentViewErrorPreview() {
    IRISIntegrateQuickstartTheme {
        ContentView(
            screen = Screen.Error(AlignmentError.AltitudeTooLow),
            onAction = {}
        )
    }
}