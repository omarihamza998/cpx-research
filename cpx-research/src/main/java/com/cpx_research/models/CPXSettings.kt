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
    var webViewStarsFilledColor: String?,
    var overlayBannerBackgroundColor: String?,
    var overlayBannerTextColor: String?
) {

    constructor(builder: CPXSettingsBuilder) : this(
        builder.appId,
        builder.extUserId,
        builder.email,
        builder.username,
        builder.secureHash,
        builder.subId1,
        builder.subId2,
        builder.extraInfo1,
        builder.extraInfo2,
        builder.extraInfo3,
        builder.extraInfo4,
        builder.extraInfo5,
        builder.extraInfo6,
        builder.extraInfo7,
        builder.extraInfo8,
        builder.extraInfo9,
        builder.extraInfo10,
        builder.webViewTextColor,
        builder.webViewTopBarBackgroundColor,
        builder.webViewBoxBackgroundColor,
        builder.webViewStarsFilledColor,
        builder.overlayBannerBackgroundColor,
        builder.overlayBannerTextColor
    )

}

class CPXSettingsBuilder(val appId: String, val extUserId: String) {

    var email: String? = null
    var username: String? = null
    var secureHash: String? = null
    var subId1: String? = null
    var subId2: String? = null
    var extraInfo1: String? = null
    var extraInfo2: String? = null
    var extraInfo3: String? = null
    var extraInfo4: String? = null
    var extraInfo5: String? = null
    var extraInfo6: String? = null
    var extraInfo7: String? = null
    var extraInfo8: String? = null
    var extraInfo9: String? = null
    var extraInfo10: String? = null
    var webViewTextColor: String? = null
    var webViewTopBarBackgroundColor: String? = null
    var webViewBoxBackgroundColor: String? = null
    var webViewStarsFilledColor: String? = null
    var overlayBannerBackgroundColor: String? = null
    var overlayBannerTextColor: String? = null

    fun setEmail(email: String) = apply { this.email = email }

    fun setUsername(username: String) = apply { this.username = username }

    fun setSecureHash(secureHash: String) = apply { this.secureHash = secureHash }

    fun setSubId1(subId1: String) = apply { this.subId1 = subId1 }

    fun setSubId2(subId2: String) = apply { this.subId2 = subId2 }

    fun setExtraInfo1(extraInfo1: String) = apply { this.extraInfo1 = extraInfo1 }

    fun setExtraInfo2(extraInfo2: String) = apply { this.extraInfo2 = extraInfo2 }

    fun setExtraInfo3(extraInfo3: String) = apply { this.extraInfo3 = extraInfo3 }

    fun setExtraInfo4(extraInfo4: String) = apply { this.extraInfo4 = extraInfo4 }

    fun setExtraInfo5(extraInfo5: String) = apply { this.extraInfo5 = extraInfo5 }

    fun setExtraInfo6(extraInfo6: String) = apply { this.extraInfo6 = extraInfo6 }

    fun setExtraInfo7(extraInfo7: String) = apply { this.extraInfo7 = extraInfo7 }

    fun setExtraInfo8(extraInfo8: String) = apply { this.extraInfo8 = extraInfo8 }

    fun setExtraInfo9(extraInfo9: String) = apply { this.extraInfo9 = extraInfo9 }

    fun setExtraInfo10(extraInfo10: String) = apply { this.extraInfo10 = extraInfo10 }

    fun setWebViewTextColor(textColor: String) = apply { this.webViewTextColor = textColor }

    fun setWebViewTopBarBackgroundColor(backgroundColor: String) =
        apply { this.webViewTopBarBackgroundColor = backgroundColor }

    fun setWebViewBoxBackgroundColor(backgroundColor: String) =
        apply { this.webViewBoxBackgroundColor = backgroundColor }

    fun setWebViewStarsFilledColor(starsFilledColor: String) =
        apply { this.webViewStarsFilledColor = starsFilledColor }

    fun setOverlayBannerBackgroundColor(backgroundColor: String) =
        apply { this.overlayBannerBackgroundColor = backgroundColor }

    fun setOverlayBannerTextColor(textColor: String) =
        apply { this.overlayBannerTextColor = textColor }


    fun build() = CPXSettings(this)

}

