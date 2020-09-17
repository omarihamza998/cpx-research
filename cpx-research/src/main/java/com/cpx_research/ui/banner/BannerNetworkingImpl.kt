package com.cpx_research.ui.banner

import android.util.Log
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.ParsedRequestListener
import com.cpx_research.interfaces.CPXNetworking
import com.cpx_research.interfaces.OnCPXResponseListener
import com.cpx_research.models.CPXResponse
import com.cpx_research.models.CPXSettings
import com.cpx_research.models.CPXSurvey
import com.cpx_research.models.CPXTextInformation

class BannerNetworkingImpl(private val cpxSettings: CPXSettings) : CPXNetworking {

    companion object {
        private const val GET_SURVEYS_URL = "https://live-api.cpx-research.com/api/get-surveys.php"
    }

    private val isExpert = false

    override fun getCPXResponse(onCPXResponseListener: OnCPXResponseListener<CPXResponse>) {
        AndroidNetworking.get(GET_SURVEYS_URL)
            .addQueryParameter(cpxSettings.convertToRequestParameters(isExpert))
            .build()
            .getAsObject(CPXResponse::class.java, object : ParsedRequestListener<CPXResponse> {
                override fun onResponse(response: CPXResponse?) {
                    if (response != null) {
                        if (response.errorMessage != null) {
                            onCPXResponseListener.onError(response.errorMessage ?: "unknown error")
                        } else {
                            onCPXResponseListener.onSuccess(response)
                        }
                    } else {
                        onCPXResponseListener.onSuccess(null)
                    }
                }

                override fun onError(anError: ANError?) {
                    onCPXResponseListener.onError(anError?.message ?: "unknown error")
                }

            })
    }


    override fun fetchAllSurveys(
        onCPXResponseListener: OnCPXResponseListener<List<CPXSurvey>>
    ) {
        AndroidNetworking.get(GET_SURVEYS_URL)
            .addQueryParameter(cpxSettings.convertToRequestParameters(isExpert))
            .build()
            .getAsObject(CPXResponse::class.java, object : ParsedRequestListener<CPXResponse> {
                override fun onResponse(response: CPXResponse?) {
                    if (response != null) {
                        Log.e("RESPONSE", response.toString())
                        if (response.errorMessage != null) {
                            onCPXResponseListener.onError(response.errorMessage ?: "unknown error")
                        } else {
                            onCPXResponseListener.onSuccess(response.CPXSurveys)
                        }
                    } else {
                        onCPXResponseListener.onSuccess(null)
                    }
                }

                override fun onError(anError: ANError?) {
                    onCPXResponseListener.onError(anError?.message ?: "unknown error")
                }

            })
    }

    override fun hideBannerRequest(
        duration: Long,
        onCPXResponseListener: OnCPXResponseListener<Any>
    ) {
        val params = HashMap<String, String>(cpxSettings.convertToRequestParameters(isExpert))
        params["reload_time"] = duration.toString()
        AndroidNetworking.get(GET_SURVEYS_URL)
            .addQueryParameter(params)
            .build()
            .getAsObject(Any::class.java, object : ParsedRequestListener<Any> {
                override fun onResponse(response: Any?) {
                    onCPXResponseListener.onSuccess(response)
                }

                override fun onError(anError: ANError?) {
                    onCPXResponseListener.onError(anError?.message ?: "unknown error")
                }

            })
    }


    override fun getCPXTextInformation(onCPXResponseListener: OnCPXResponseListener<CPXTextInformation>) {
        AndroidNetworking.get(GET_SURVEYS_URL)
            .addQueryParameter(cpxSettings.convertToRequestParameters(isExpert))
            .build()
            .getAsObject(CPXResponse::class.java, object : ParsedRequestListener<CPXResponse> {
                override fun onResponse(response: CPXResponse?) {
                    if (response != null) {
                        if (response.errorMessage != null) {
                            onCPXResponseListener.onError(response.errorMessage ?: "unknown error")
                        } else {
                            onCPXResponseListener.onSuccess(response.textInformation)
                        }
                    } else {
                        onCPXResponseListener.onSuccess(null)
                    }
                }

                override fun onError(anError: ANError?) {
                    onCPXResponseListener.onError(anError?.message ?: "unknown error")
                }

            })
    }
}