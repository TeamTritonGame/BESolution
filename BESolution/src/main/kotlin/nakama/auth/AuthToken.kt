package org.david.nakama.auth

object AuthToken {
    lateinit var authToken: String

    fun setAuthToken(token: String) {
        authToken = token
    }

    fun getAuthToken(): String {
        return authToken
    }
}