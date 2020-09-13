package com.cpx_research_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.cpx_research.CPXResearch
import com.cpx_research.interfaces.OnCPXResponseListener
import com.cpx_research.models.CPXSettingsBuilder
import com.cpx_research.models.CPXSurvey
import com.cpx_research.models.CPXTextInformation

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cpxSettings = CPXSettingsBuilder("5878", "123")
            .setEmail("123")
            .setUsername("email")
            .setExtraInfo1("123")
            .setOverlayBannerTextColor("#00000")
            .setOverlayBannerBackgroundColor("#ffffff")
            .build()

        val cpxResearch = CPXResearch.init(this, cpxSettings)

        cpxResearch.getCPXTextInformation(object : OnCPXResponseListener<CPXTextInformation>{
            override fun onSuccess(data: CPXTextInformation?) {
                Toast.makeText(
                    applicationContext,
                    "Success",
                    Toast.LENGTH_LONG
                ).show()
                Log.e("TEXT INFORMATION", data?.toString() ?: "ss")
            }

            override fun onError(message: String) {
                Toast.makeText(applicationContext, message, Toast.LENGTH_LONG).show()
            }

        })
    }
}
