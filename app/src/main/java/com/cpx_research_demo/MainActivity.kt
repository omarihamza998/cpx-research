package com.cpx_research_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.cpx_research.CPXResearch
import com.cpx_research.models.CPXSettingsBuilder
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    lateinit var cpxResearch: CPXResearch


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cpxSettings = CPXSettingsBuilder("1", "15879602")
            .setWebViewActivityRequestCode(100)
            .build()

        cpxResearch = CPXResearch.init(this, cpxSettings)

        launchSurveyButton.setOnClickListener {
            cpxResearch.openSurvey(surveyIdEditText.text.toString())
        }

        openSurveysWallButton.setOnClickListener {
            cpxResearch.openSurveyWall()
        }

        startTimerButton.setOnClickListener {
            cpxResearch.enableBanner(TimeUnit.SECONDS.toMillis(20))
        }

        stopTimerButton.setOnClickListener {
            cpxResearch.disableBanner()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 100){
            Toast.makeText(this, "WebViewClosed", Toast.LENGTH_LONG).show()
        }
    }
}
