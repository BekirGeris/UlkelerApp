package com.begers.ulkeler.model

import com.google.gson.annotations.SerializedName

data class Country(
        @SerializedName("name")
        val countryName: String?,
        @SerializedName("capital")
        val countryRegion: String,
        @SerializedName("region")
        val countryCağpital: String,
        @SerializedName("currency")
        val countryCurrency: String,
        @SerializedName("language")
        val countryLanguage: String,
        @SerializedName("flag")
        val imagerl: String)