package com.sightic.irisintegratequickstart.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.sightic.irisintegratequickstart.ui.theme.Gray
import com.sightic.irisintegratequickstart.ui.theme.IRISIntegrateQuickstartTheme

@Composable
fun Header(title: String, subtitle: String, backgroundColor: Color = Gray) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(backgroundColor)
            .safeContentPadding()
    ) {
        CompositionLocalProvider(LocalContentColor provides Color.White) {
            Text(
                text = title,
                style = MaterialTheme.typography.headlineMedium
            )
            Text(
                text = subtitle,
                style = MaterialTheme.typography.titleMedium
            )
        }

    }
}

@Preview
@Composable
private fun HeaderPreview() {
    IRISIntegrateQuickstartTheme {
        Header("IRIS integrate Quickstart", "IRIS integrate version: 1.0.0")
    }
}