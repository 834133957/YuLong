package com.yulong.android.logic.dao

import android.content.Context
import androidx.core.content.edit
import com.google.gson.Gson
import com.yulong.android.YuLongWeatherApplication
import com.yulong.android.logic.model.Place

object PlaceDao {

    fun savePlace(place: Place) {
        sharePreferences().edit {
            putString("place", Gson().toJson(place))
        }
    }

    fun getPlace() : Place {
        val placeGson = sharePreferences().getString("place","")
        return Gson().fromJson(placeGson, Place::class.java)
    }

    fun isPlaceSaved() = sharePreferences().contains("place")

    private fun sharePreferences() = YuLongWeatherApplication.context.getSharedPreferences("yulong_weather",Context.MODE_PRIVATE)
}