package com.begers.ulkeler.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.begers.ulkeler.model.Country

class CountryViewModel : ViewModel() {

    val countryLiveData = MutableLiveData<Country>()

    fun getDataFromRoom() {
        val country = Country("Tukey", "Asya", "Ankara", "TRY", "Türkçe", "imageUrl")
        countryLiveData.value = country
    }
}