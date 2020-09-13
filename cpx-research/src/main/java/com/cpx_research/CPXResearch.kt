package com.cpx_research

import android.content.Context
import com.androidnetworking.AndroidNetworking
import com.cpx_research.interfaces.CPXNetworking
import com.cpx_research.interfaces.ICPXResearch
import com.cpx_research.interfaces.OnCPXResponseListener
import com.cpx_research.models.CPXSettings
import com.cpx_research.models.CPXSurvey
import com.cpx_research.models.CPXTextInformation
import com.cpx_research.networking.CPXNetworkingImpl


class CPXResearch private constructor(
    val context: Context,
    private val cpxSettings: CPXSettings
) : ICPXResearch {

    var cpxNetworking: CPXNetworking = CPXNetworkingImpl(cpxSettings)

    companion object {
        fun init(context: Context, cpxSettings: CPXSettings): CPXResearch {
            AndroidNetworking.initialize(context)
            return CPXResearch(context, cpxSettings)
        }
    }


    override fun enableBanner(surveysCheckInterval: Long) {
    }

    override fun disableBanner() {
    }

    override fun fetchAvailableSurveys(onCPXResponseListener: OnCPXResponseListener<List<CPXSurvey>>) {
        cpxNetworking.fetchAllSurveys(onCPXResponseListener)
    }

    override fun getCPXTextInformation(onCPXResponseListener: OnCPXResponseListener<CPXTextInformation>) {
        cpxNetworking.getCPXTextInformation(onCPXResponseListener)
    }


    override fun isBannerVisible(): Boolean {
        return false;
    }

    override fun checkForNewSurveys() {
    }

    override fun openSurveyWall() {
    }

    override fun openSurvey(surveyId: String) {
    }


}