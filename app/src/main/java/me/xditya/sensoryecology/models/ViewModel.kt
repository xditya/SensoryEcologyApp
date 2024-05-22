package me.xditya.sensoryecology.models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import me.xditya.sensoryecology.helpers.RetrofitInstance

class SensorViewModel : ViewModel() {

    private val _sensorData = MutableLiveData<SensorData>()
    val sensorData: LiveData<SensorData> get() = _sensorData

    init {
        startFetchingSensorData()
    }

    private fun startFetchingSensorData() {
        viewModelScope.launch {
            while (true) {
                try {
                    val response = RetrofitInstance.api.getSensorData()
                    _sensorData.postValue(response)
                } catch (e: Exception) {
                    // Handle exceptions
                }
                delay(5000) // Wait for 5 seconds
            }
        }
    }
}