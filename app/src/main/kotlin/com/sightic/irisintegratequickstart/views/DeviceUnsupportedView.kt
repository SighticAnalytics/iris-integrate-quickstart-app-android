package com.sightic.irisintegratequickstart.views

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sightic.irisintegratequickstart.R
import com.sightic.irisintegratequickstart.ui.theme.IRISIntegrateQuickstartTheme

@Composable
fun DeviceUnsupportedView(statusMessage: String) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .align(BiasAlignment(horizontalBias = 0f, verticalBias = -0.5f)),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.device_unsupported_title),
                style = MaterialTheme.typography.displaySmall,
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp),
            )
            Text(
                text = stringResource(R.string.device_unsupported_body),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(vertical = 8.dp),
            )
            Text(text = statusMessage, textAlign = TextAlign.Center)
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun DeviceUnsupportedViewPreview() {
    IRISIntegrateQuickstartTheme {
        DeviceUnsupportedView(stringResource(R.string.device_unsupported_hardware))
    }
}