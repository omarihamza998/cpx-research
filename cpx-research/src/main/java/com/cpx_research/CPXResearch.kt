package com.cpx_research

import android.app.Activity
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.cpx_research.ui.banner.SurveyOverlayBanner
import com.cpx_research.interfaces.CPXNetworking
import com.cpx_research.interfaces.ICPXResearch
import com.cpx_research.interfaces.OnCPXResponseListener
import com.cpx_research.models.CPXResponse
import com.cpx_research.models.CPXSettings
import com.cpx_research.models.CPXSurvey
import com.cpx_research.models.CPXTextInformation
import com.cpx_research.networking.CPXNetworkingImpl


class CPXResearch private constructor(
    private val activity: Activity,
    private val cpxSettings: CPXSettings
) : ICPXResearch {

    private var surveyOverlayBanner: SurveyOverlayBanner? = null

    private var cpxNetworking: CPXNetworking = CPXNetworkingImpl(cpxSettings)

    companion object {
        fun init(activity: Activity, cpxSettings: CPXSettings): CPXResearch {
            AndroidNetworking.initialize(activity)
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY);
            return CPXResearch(activity, cpxSettings)
        }
    }


    override fun enableBanner(surveysCheckInterval: Long) {
        if (surveyOverlayBanner == null) {
            surveyOverlayBanner =
                SurveyOverlayBanner(activity, this, cpxSettings, surveysCheckInterval)
        }
        surveyOverlayBanner?.enableBanner()
    }

    override fun disableBanner() {
        surveyOverlayBanner?.disableBanner(true)
    }

    override fun fetchAvailableSurveys(onCPXResponseListener: OnCPXResponseListener<List<CPXSurvey>>) {
        cpxNetworking.fetchAllSurveys(onCPXResponseListener)
    }

    override fun getCPXTextInformation(onCPXResponseListener: OnCPXResponseListener<CPXTextInformation>) {
        cpxNetworking.getCPXTextInformation(onCPXResponseListener)
    }

    override fun getCPXResponse(onCPXResponseListener: OnCPXResponseListener<CPXResponse>) {
        cpxNetworking.getCPXResponse(onCPXResponseListener)
    }


    override fun isBannerVisible() = surveyOverlayBanner?.isBannerVisible == true


    override fun checkForNewSurveys() {
    }

    override fun openSurveyWall() {
    }

    override fun openSurvey(surveyId: String) {
    }


}