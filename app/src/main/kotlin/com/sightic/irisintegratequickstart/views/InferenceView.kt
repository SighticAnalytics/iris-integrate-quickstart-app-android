package com.sightic.irisintegratequickstart.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sightic.irisintegratequickstart.R
import com.sightic.irisintegratequickstart.components.Header
import com.sightic.irisintegratequickstart.ui.theme.Gray
import com.sightic.irisintegratequickstart.ui.theme.IRISIntegrateQuickstartTheme

@Composable
fun InferenceView() {
    Box(Modifier.fillMaxSize()) {
        Header(
            stringResource(R.string.hold_on),
            stringResource(R.string.waiting_for_inference_result)
        )
        CircularProgressIndicator(
            modifier = Modifier
                .align(Alignment.Center)
                .size(80.dp),
            color = Gray,
            trackColor = Gray.copy(alpha = 0.1f),
            strokeCap = StrokeCap.Round,
            strokeWidth = 7.dp,
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun StartViewPreview() {
    IRISIntegrateQuickstartTheme {
        InferenceView()
    }
}