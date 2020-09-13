package com.cpx_research_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cpx_research.CPXResearch
import com.cpx_research.models.CPXSettingsBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cpxSettings = CPXSettingsBuilder("app_id", "ext_user_id")
            .setEmail("123")
            .setUsername("email")
            .setExtraInfo1("123")
            .setOverlayBannerTextColor("#00000")
            .setOverlayBannerBackgroundColor("#ffffff")
            .build()

        val cpxResearch = CPXResearch.init(this, cpxSettings)



    }
}
