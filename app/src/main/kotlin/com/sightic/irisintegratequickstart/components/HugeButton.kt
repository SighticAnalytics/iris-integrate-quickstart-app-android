package com.sightic.irisintegratequickstart.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.sightic.irisintegratequickstart.ui.theme.Blue

@Composable
fun HugeButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors().copy(containerColor = Blue)
    ) {
        Text(
            text,
            Modifier.padding(10.dp),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center,
            color = Color.White,
        )
    }
}