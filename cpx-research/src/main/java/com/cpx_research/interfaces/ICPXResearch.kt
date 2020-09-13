package com.cpx_research.interfaces

import android.content.Context
import com.cpx_research.models.CPXSettings
import java.util.concurrent.TimeUnit

interface ICPXResearch {

    fun enableBanner(surveysCheckInterval: Long = TimeUnit.MINUTES.toMillis(2))

    fun disableBanner()

    fun fetchAvailableSurveys(onCPXResponseListener: OnCPXResponseListener)

    fun isBannerVisible(): Boolean

    fun checkForNewSurveys()

    fun openSurveyWall()

    fun openSurvey(surveyId: String)

    fun getCPXTextInformation(onCPXResponseListener: OnCPXResponseListener)

}