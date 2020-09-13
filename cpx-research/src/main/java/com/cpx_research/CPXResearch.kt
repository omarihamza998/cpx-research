package com.cpx_research

import android.content.Context
import com.cpx_research.interfaces.ICPXResearch
import com.cpx_research.interfaces.OnCPXResponseListener
import com.cpx_research.models.CPXSettings

class CPXResearch private constructor(
    val context: Context,
    val cpxSettings: CPXSettings
) : ICPXResearch {

    companion object {
        fun init(context: Context, cpxSettings: CPXSettings) = CPXResearch(context, cpxSettings)
    }


    override fun enableBanner(surveysCheckInterval: Long) {
    }

    override fun disableBanner() {
    }

    override fun fetchAvailableSurveys(onCPXResponseListener: OnCPXResponseListener) {
    }

    override fun isBannerVisible(): Boolean {
    }

    override fun checkForNewSurveys() {
    }

    override fun openSurveyWall() {
    }

    override fun openSurvey(surveyId: String) {
    }

    override fun getCPXTextInformation(onCPXResponseListener: OnCPXResponseListener) {
    }

}