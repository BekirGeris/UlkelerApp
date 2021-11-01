package com.begers.ulkeler.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.begers.ulkeler.model.Country

class FeedViewModel : ViewModel() {
    val countries = MutableLiveData<List<Country>>()
    val countryError = MutableLiveData<Boolean>()
    val countryLoading = MutableLiveData<Boolean>()

    fun refreshData() {
        val county = Country("Turkey", "Asia", "Ankara", "TRY", "Türkçe", "imageUrl")
        val county2 = Country("Fransa", "Avrupa", "Paris", "Euro", "Fransızça", "imageUrl2")
        val county3 = Country("Almanya", "Avrupa", "Berlin", "Euro", "Almanca", "imageUrl3")

        val countryList = arrayListOf<Country>(county, county2, county3)

        countries.value = countryList
        countryError.value = false
        countryLoading.value = false
    }

}