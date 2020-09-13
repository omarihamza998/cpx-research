package com.cpx_research.models

import com.google.gson.annotations.SerializedName

data class CPXTextInformation(
    @SerializedName("currency_name_singular")
    var currencyNameSingular: String,
    @SerializedName("currency_name_plural")
    var currencyNamePlural: String,
    @SerializedName("shortcurt_min")
    var shortcutMin: String,
    @SerializedName("headline_general")
    var headlineGeneral: String,
    @SerializedName("headline_1_element_1")
    var headline1Element1: String,
    @SerializedName("headline_1_element_2")
    var headline1Element2: String,
    @SerializedName("headline_2_element_1")
    var headline2Element1: String
)