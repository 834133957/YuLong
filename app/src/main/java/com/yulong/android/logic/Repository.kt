package com.yulong.android.logic

import androidx.lifecycle.liveData
import com.yulong.android.logic.model.Place
import com.yulong.android.logic.network.YuLongWeatherNetwork
import kotlinx.coroutines.Dispatchers

object Repository {

    fun searchPlace(query: String) = liveData(Dispatchers.IO) {
        val result = try {
            val placeResponse = YuLongWeatherNetwork.searchPlaces(query)
            if (placeResponse.status == "ok") {
                Result.success(placeResponse.places)
            } else {
                Result.failure(RuntimeException("response status is ${placeResponse.status}"))
            }
        } catch (e: Exception) {
            Result.failure<List<Place>>(e)
        }
        emit(result as Result<List<Place>>)
    }
}