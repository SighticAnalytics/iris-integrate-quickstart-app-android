package com.sightic.irisintegratequickstart.extensions

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.sightic.irisintegrate.SighticSupportedDevice
import com.sightic.irisintegratequickstart.R

@Composable
fun SighticSupportedDevice.Status.asReadableStatus() = when (this) {
    SighticSupportedDevice.Status.SUPPORTED -> stringResource(R.string.device_supported)
    SighticSupportedDevice.Status.HARDWARE_UNSUPPORTED -> stringResource(R.string.device_unsupported_hardware)
    SighticSupportedDevice.Status.LIBRARY_UNSUPPORTED -> stringResource(R.string.device_unsupported_library_version)
    SighticSupportedDevice.Status.GOOGLE_PLAY_SERVICES_MISSING -> stringResource(R.string.device_unsupported_google_play_missing)
    SighticSupportedDevice.Status.GOOGLE_PLAY_SERVICES_TENSORFLOW_MISSING -> stringResource(R.string.device_unsupported_tensorflow_is_not_supported)
}