package kr.example.jetnote.screens.weather.favoritescreen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch
import kr.example.jetnote.model.weathermodel.Favorite
import kr.example.jetnote.repository.WeatherRepositoryDao

import javax.inject.Inject


@HiltViewModel
class FavoriteViewModel @Inject constructor( private val repositoryDao: WeatherRepositoryDao): ViewModel() {
    private val _favLists = MutableStateFlow<List<Favorite>>(emptyList())
    val favLists = _favLists

    init {
        getFavorite()
    }

    fun getFavorite()  {
        viewModelScope.launch(Dispatchers.IO) {
            repositoryDao.getFavorite().distinctUntilChanged().collect {
                listOffavs ->
                if (listOffavs.isNullOrEmpty()) {

                } else {
                    _favLists.value = listOffavs
                   // Log.d("TAG", "[FavoriteViewModel][29] ===> ${_favLists.value}")
                }
            }

        }
    }


    fun insertFavorite(favorite: Favorite) {
        viewModelScope.launch {
        repositoryDao.insertFavorite(favorite)
        }
    }

    fun updateFavorite(favorite: Favorite) {
        viewModelScope.launch {
        repositoryDao.updateFavorite(favorite)
        }
    }

    fun deleteFavorite(favorite: Favorite) {
        viewModelScope.launch {
        repositoryDao.deleteFavor(favorite)
        }
    }
}