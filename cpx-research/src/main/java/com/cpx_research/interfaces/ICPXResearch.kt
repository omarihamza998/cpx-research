package com.cpx_research.interfaces

import com.cpx_research.models.CPXResponse
import com.cpx_research.models.CPXTextInformation
import com.cpx_research.models.CPXSurvey
import java.util.concurrent.TimeUnit

interface ICPXResearch {

    fun enableBanner(surveysCheckInterval: Long = TimeUnit.MINUTES.toMillis(2))

    fun disableBanner()

    fun fetchAvailableSurveys(onCPXResponseListener: OnCPXResponseListener<List<CPXSurvey>>)

    fun isBannerVisible(): Boolean

    fun checkForNewSurveys()

    fun openSurveyWall()

    fun openSurvey(surveyId: String)

    fun getCPXTextInformation(onCPXResponseListener: OnCPXResponseListener<CPXTextInformation>)

    fun getCPXResponse(onCPXResponseListener: OnCPXResponseListener<CPXResponse>)

    fun hideBannerForDuration(duration: Long, onCPXResponseListener: OnCPXResponseListener<Any>)

}