package com.hjq.kotlin.provider.router

object RouterPath {
    //用户模块
    class ModuleUser {
        companion object {
            const val PATH_LOGIN = "/moduleUser/login"
        }
    }

    //消息模块
    class ModuleMessage {
        companion object {
            const val PATH_MESSAGE_PUSH = "/moduleMessage/push"
            const val PATH_MESSAGE_ORDER = "/moduleMessage/order"
        }
    }
}