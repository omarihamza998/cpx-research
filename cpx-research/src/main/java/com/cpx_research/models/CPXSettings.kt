package com.cpx_research.models

data class CPXSettings(
    val appId: String,
    val extUserId: String,
    var email: String?,
    var username: String?,
    var secureHash: String?,
    var subId1: String?,
    var subId2: String?,
    var extraInfo1: String?,
    var extraInfo2: String?,
    var extraInfo3: String?,
    var extraInfo4: String?,
    var extraInfo5: String?,
    var extraInfo6: String?,
    var extraInfo7: String?,
    var extraInfo8: String?,
    var extraInfo9: String?,
    var extraInfo10: String?,
    var webViewTextColor: String?,
    var webViewTopBarBackgroundColor: String?,
    var webViewBoxBackgroundColor: String?,
    var webViewsStarsFilledColor: String?,
    var overlayBannerBackgroundColor: String?,
    var overlayBannerTextColor: String?
)