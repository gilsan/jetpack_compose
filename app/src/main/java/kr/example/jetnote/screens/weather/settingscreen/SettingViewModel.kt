package kr.example.jetnote.screens.weather.settingscreen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kr.example.jetnote.model.weathermodel.TemperatureUnit
import kr.example.jetnote.repository.WeatherRepositoryDao


import javax.inject.Inject


@HiltViewModel
class SettingViewModel @Inject constructor( private val repositoryDao: WeatherRepositoryDao): ViewModel() {

    private val _unitLists = MutableStateFlow<List<TemperatureUnit>>(emptyList())
    val unitLists = _unitLists

    init {
        getSettings()
    }

    private fun getSettings() {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryDao.getSetting().distinctUntilChanged().collect { listOfUnit ->
                if (listOfUnit.isNullOrEmpty()) {

                } else {
                    _unitLists.value = listOfUnit
                }
            }
        }
    }
    fun insertUnit(temperatureUnit: TemperatureUnit) {
        viewModelScope.launch {
            repositoryDao.insertUnit(temperatureUnit)
        }
    }

    fun updateUnit(temperatureUnit: TemperatureUnit) {
        viewModelScope.launch {
            repositoryDao.updateUnit(temperatureUnit)
        }
    }

    fun deleteUnit(temperatureUnit: TemperatureUnit) {
        viewModelScope.launch {
            repositoryDao.deleteUnit(temperatureUnit)
        }
    }

    fun deleteAllUnit() {
        viewModelScope.launch {
            repositoryDao.deleteAllUnit()
        }
    }








}