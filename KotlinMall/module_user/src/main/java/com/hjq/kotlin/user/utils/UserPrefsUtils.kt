package com.hjq.kotlin.user.utils

import com.hjq.kotlin.base.common.BaseConstant
import com.hjq.kotlin.base.utils.AppPrefsUtils


/**
 * 本地存储用户信息
 */
object UserPrefsUtils {
    /*
        退出登录时，传入null,清空存储
     */
    /*
    fun putUserInfo(userInfo: UserInfo?) {
        AppPrefsUtils.putString(BaseConstant.KEY_SP_TOKEN, userInfo?.id ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_ICON, userInfo?.userIcon ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_NAME, userInfo?.userName ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_MOBILE, userInfo?.userMobile ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_GENDER, userInfo?.userGender ?: "")
        AppPrefsUtils.putString(ProviderConstant.KEY_SP_USER_SIGN, userInfo?.userSign ?: "")
    }
    */
}