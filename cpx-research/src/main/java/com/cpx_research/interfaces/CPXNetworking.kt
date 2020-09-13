package com.cpx_research.interfaces

import com.cpx_research.models.CPXResponse
import com.cpx_research.models.CPXSurvey
import com.cpx_research.models.CPXTextInformation

interface CPXNetworking {

    fun getCPXResponse(onCPXResponseListener: OnCPXResponseListener<CPXResponse>)

    fun fetchAllSurveys(onCPXResponseListener: OnCPXResponseListener<List<CPXSurvey>>)

    fun hideBannerRequest()

    fun getCPXTextInformation(onCPXResponseListener: OnCPXResponseListener<CPXTextInformation>)

}