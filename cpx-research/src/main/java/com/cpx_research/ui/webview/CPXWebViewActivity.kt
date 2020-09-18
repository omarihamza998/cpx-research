package com.cpx_research.ui.webview

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import com.cpx_research.R
import com.cpx_research.models.CPXSettings
import kotlinx.android.synthetic.main.activity_c_p_x_web_view.*

class CPXWebViewActivity : Activity() {

    lateinit var cpxSettings: CPXSettings
    lateinit var webViewUrl: String

    companion object {

        fun launchActivity(activity: Activity, cpxSettings: CPXSettings) {
            val intent = Intent(activity, CPXWebViewActivity::class.java)
            intent.putExtra("settings", cpxSettings)
            if (cpxSettings.webViewActivityRequestCode != null) {
                activity.startActivityForResult(intent, cpxSettings.webViewActivityRequestCode!!)
            } else {
                activity.startActivity(intent)
            }
        }

        fun launchActivity(activity: Activity, cpxSettings: CPXSettings, surveyId: String) {
            val intent = Intent(activity, CPXWebViewActivity::class.java)
            intent.putExtra("survey_id", surveyId)
            intent.putExtra("settings", cpxSettings)
            if (cpxSettings.webViewActivityRequestCode != null) {
                activity.startActivityForResult(intent, cpxSettings.webViewActivityRequestCode!!)
            } else {
                activity.startActivity(intent)
            }
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_c_p_x_web_view)

        readIntent()
        generateWebViewUrl()
        setupWebView()
    }

    private fun readIntent() {
        cpxSettings = intent.getSerializableExtra("settings") as CPXSettings
    }

    private fun generateWebViewUrl() {

        webViewUrl = "https://offers.cpx-research.com/index.php"

        val builder = Uri.parse(webViewUrl)
            .buildUpon()

        cpxSettings.convertToRequestParameters(true).forEach {
            builder.appendQueryParameter(it.key, it.value)
        }

        intent.getStringExtra("survey_id")?.let {
            builder.appendQueryParameter("survey_id", it)
        }

        webViewUrl = builder.build().toString()

    }


    private fun setupWebView() {
        webView.settings.javaScriptEnabled = true
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.settings.domStorageEnabled = true
        webView.loadUrl(webViewUrl)
    }

}
