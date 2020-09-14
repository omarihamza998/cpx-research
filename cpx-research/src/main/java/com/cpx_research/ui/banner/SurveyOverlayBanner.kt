package com.cpx_research.ui.banner

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.PopupMenu
import androidx.core.text.HtmlCompat
import com.cpx_research.CPXResearch
import com.cpx_research.R
import com.cpx_research.interfaces.OnCPXResponseListener
import com.cpx_research.models.CPXResponse
import com.cpx_research.models.CPXSettings
import com.cpx_research.models.CPXTextInformation
import com.cpx_research.ui.webview.CPXWebViewActivity


interface ISurveyOverlayBanner {

    fun enableBanner()

    fun disableBanner()

    fun inflateView(cpxTextInformation: CPXTextInformation)

    fun showView()

    fun createTimer()

    fun stopTimer()

}

interface ISurveyOverlayClickListeners {

    fun onOpenWebViewClickListener()

    fun onCloseBannerClickListener(cpxTextInformation: CPXTextInformation)

}

class SurveyOverlayBanner(
    private val activity: Activity,
    private val cpxResearch: CPXResearch,
    private val cpxSettings: CPXSettings,
    private val checkInterval: Long
) : ISurveyOverlayBanner, ISurveyOverlayClickListeners {

    private var banner: View? = null
    var isBannerVisible = false

    override fun enableBanner() {
        // Get Available Surveys Count
        cpxResearch.getCPXResponse(object : OnCPXResponseListener<CPXResponse> {
            override fun onSuccess(data: CPXResponse?) {
                // Available Surveys > 0 ? -> Show the Surveys
                if (!data?.CPXSurveys.isNullOrEmpty()) {
                    data?.textInformation?.let {
                        inflateView(it)
                    }
                    showView()
                    createTimer()
                }
                // Available Surveys == 0 ? -> do nothing
            }

            override fun onError(message: String) {
                // Error -> do nothing
            }

        })
    }

    override fun disableBanner() {
        isBannerVisible = false
        stopTimer()
        val rootView = activity.findViewById<ViewGroup>(android.R.id.content)
        rootView.removeView(banner)
    }

    override fun inflateView(cpxTextInformation: CPXTextInformation) {
        if (banner == null) {
            //Inflate the View
            banner = activity.layoutInflater.inflate(R.layout.survey_overlay_banner, null)

            //Get Reference of the title TextView
            val textView = banner?.findViewById<TextView>(R.id.bannerTitleTextView)
            textView?.text = HtmlCompat.fromHtml(
                cpxTextInformation.headlineGeneral,
                HtmlCompat.FROM_HTML_MODE_LEGACY
            )
            textView?.setBackgroundColor(Color.parseColor(cpxSettings.overlayBannerBackgroundColor))
            textView?.setTextColor(Color.parseColor(cpxSettings.overlayBannerTextColor))
            textView?.setOnClickListener {
                onOpenWebViewClickListener()
            }

            //Close Button ClickListener
            banner?.findViewById<ImageButton>(R.id.closeBannerButton)?.setOnClickListener {
                onCloseBannerClickListener(cpxTextInformation)
            }
        }
    }

    override fun showView() {
        val rootView = activity.findViewById<ViewGroup>(android.R.id.content)
        val params = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.WRAP_CONTENT,
            FrameLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.BOTTOM or Gravity.CENTER
        rootView.addView(banner, params)
        isBannerVisible = true
    }

    override fun createTimer() {

    }

    override fun stopTimer() {

    }

    override fun onOpenWebViewClickListener() {
        val intent = Intent(activity, CPXWebViewActivity::class.java)
        intent.putExtra("settings", cpxSettings)
        activity.startActivity(intent)
    }

    override fun onCloseBannerClickListener(cpxTextInformation: CPXTextInformation) {
        val popup = PopupMenu(activity, banner!!.findViewById(R.id.closeBannerButton)!!)


        popup.setOnMenuItemClickListener {
            Toast.makeText(
                activity,
                "You Clicked : " + it.title,
                Toast.LENGTH_SHORT
            ).show()
            return@setOnMenuItemClickListener true
        }

        popup.show() //showing popup menu

    }

}