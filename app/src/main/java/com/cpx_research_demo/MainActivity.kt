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
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var cpxResearch: CPXResearch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cpxSettings = CPXSettingsBuilder("1", "15879600")
            .build()

        cpxResearch = CPXResearch.init(this, cpxSettings)

    }

    override fun onResume() {
        super.onResume()
        cpxResearch.enableBanner(TimeUnit.SECONDS.toMillis(20))
    }

    override fun onPause() {
        super.onPause()
        cpxResearch.disableBanner()
    }
}
