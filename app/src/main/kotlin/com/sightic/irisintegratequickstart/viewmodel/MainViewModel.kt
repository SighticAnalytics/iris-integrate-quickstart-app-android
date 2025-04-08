package com.sightic.irisintegratequickstart.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sightic.irisintegrate.SighticRecording
import com.sightic.irisintegrate.SighticResult
import com.sightic.irisintegrate.SighticSupportedDevice
import com.sightic.irisintegrate.error.SighticError
import com.sightic.irisintegratequickstart.BuildConfig
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

sealed class Screen {
    data object Loading : Screen()
    data object Start : Screen()
    data object Scan : Screen()
    data object Inference : Screen()
    data class Result(val hasImpairment: Boolean) : Screen()
    data class Error(val error: SighticError) : Screen()
    data class DeviceUnsupported(val status: SighticSupportedDevice.Status) : Screen()
}

sealed interface Action {
    data class OnDeviceSupportedStatusReceived(val status: SighticSupportedDevice.Status) : Action
    data object OnStartScanClicked : Action
    data class OnResultReceived(val result: SighticResult<SighticRecording>) : Action
    data object OnDoneClicked : Action
}

class MainViewModel : ViewModel() {

    private val _screen = MutableStateFlow<Screen>(Screen.Loading)
    val screen = _screen

    fun onAction(action: Action) {
        when (action) {
            is Action.OnDeviceSupportedStatusReceived -> checkDeviceSupportedStatus(action.status)
            is Action.OnResultReceived -> inferResult(action.result)
            is Action.OnStartScanClicked -> _screen.update { Screen.Scan }
            is Action.OnDoneClicked -> _screen.update { Screen.Start }
        }
    }

    private fun checkDeviceSupportedStatus(status: SighticSupportedDevice.Status) {
        when (status) {
            SighticSupportedDevice.Status.SUPPORTED -> _screen.update { Screen.Start }
            else -> {
                _screen.update { Screen.DeviceUnsupported(status) }
            }
        }
    }

    private fun inferResult(result: SighticResult<SighticRecording>) {
        _screen.update { Screen.Inference }
        when (result) {
            is SighticResult.Failure -> _screen.update {
                Screen.Error(result.error)
            }

            is SighticResult.Success -> {
                viewModelScope.launch {
                    val inferenceResult = result.value.performInference(
                        BuildConfig.API_KEY
                    )

                    when (inferenceResult) {
                        is SighticResult.Failure ->
                            _screen.update { Screen.Error(inferenceResult.error) }

                        is SighticResult.Success -> {
                            _screen.update { Screen.Result(inferenceResult.value.hasImpairment) }
                        }
                    }
                }
            }
        }
    }
}