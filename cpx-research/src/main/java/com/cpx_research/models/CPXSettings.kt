package com.cpx_research.models

import java.io.Serializable

class CPXSettings(
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
    var overlayBannerBackgroundColor: String= "#1565c0",
    var overlayBannerTextColor: String = "#ffffff"
) : Serializable {

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
        builder.overlayBannerBackgroundColor ?: "#1565c0",
        builder.overlayBannerTextColor ?: "#ffffff"
    )

    fun convertToRequestParameters(): Map<String, String> {
        val params = HashMap<String, String>()

        params["app_id"] = appId
        params["ext_user_id"] = extUserId
        email?.let { params["email"] = it }
        username?.let { params["username"] = it }
        secureHash?.let { params["secure_hash"] = it }
        subId1?.let { params["subid_1"] = it }
        subId2?.let { params["subid_2"] = it }
        extraInfo1?.let { params["extra_info_1"] = it }
        extraInfo2?.let { params["extra_info_2"] = it }
        extraInfo3?.let { params["extra_info_3"] = it }
        extraInfo4?.let { params["extra_info_4"] = it }
        extraInfo5?.let { params["extra_info_5"] = it }
        extraInfo6?.let { params["extra_info_6"] = it }
        extraInfo7?.let { params["extra_info_7"] = it }
        extraInfo8?.let { params["extra_info_8"] = it }
        extraInfo9?.let { params["extra_info_9"] = it }
        extraInfo10?.let { params["extra_info_10"] = it }
        webViewTextColor?.let { params["text_color"] = it }
        webViewTopBarBackgroundColor?.let { params["topbar_background_color"] = it }
        webViewBoxBackgroundColor?.let { params["box_background_color"] = it }
        webViewStarsFilledColor?.let { params["stars_filled"] = it }
        params["output_method"] = "jsscriptv1"

        return params
    }

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

