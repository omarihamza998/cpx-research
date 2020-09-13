package com.cpx_research.models

import com.google.gson.annotations.SerializedName

data class CPXResponse(
    @SerializedName("count_available_surveys")
    var availableSurveysCount: Int = 0,
    @SerializedName("surveys")
    var CPXSurveys: List<CPXSurvey>?,
    @SerializedName("text")
    var textInformation: CPXTextInformation?,
    @SerializedName("error_message")
    var errorMessage: String? = null
)