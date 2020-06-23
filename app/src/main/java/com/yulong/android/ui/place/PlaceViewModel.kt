package com.yulong.android.ui.place

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.yulong.android.logic.Repository
import com.yulong.android.logic.model.Place

class PlaceViewModel: ViewModel() {

    private val searchLiveData = MutableLiveData<String>()

    val placeLists = ArrayList<Place>()

    val placeLiveData = Transformations.switchMap(searchLiveData) {query -> Repository.searchPlace(query)}

    fun searchPlaces(query: String) {
        searchLiveData.value = query
    }

    fun savePlace(place: Place) = Repository.savePlace(place)

    fun getSavedPlace() = Repository.getPlace()

    fun isPlaceSaved() = Repository.isPlaceSaved()
}