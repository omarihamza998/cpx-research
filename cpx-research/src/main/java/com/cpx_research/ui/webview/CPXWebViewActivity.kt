package com.cpx_research.ui.webview

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cpx_research.R
import com.cpx_research.models.CPXSettings
import kotlinx.android.synthetic.main.activity_c_p_x_web_view.*

class CPXWebViewActivity : AppCompatActivity() {

    lateinit var cpxSettings: CPXSettings
    lateinit var webViewUrl: String

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

        cpxSettings.convertToRequestParameters().forEach {
            builder.appendQueryParameter(it.key, it.value)
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
