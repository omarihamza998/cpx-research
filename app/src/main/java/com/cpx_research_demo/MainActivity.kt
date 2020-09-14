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

        val cpxSettings = CPXSettingsBuilder("1", "15879600")
            .build()

        val cpxResearch = CPXResearch.init(this, cpxSettings)

        cpxResearch.enableBanner()
    }
}
