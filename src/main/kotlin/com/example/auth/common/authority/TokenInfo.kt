package com.example.auth.common.authority

data class TokenInfo(
    val grantType: String,
    val accessToken: String,
)