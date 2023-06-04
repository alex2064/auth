package com.example.auth.common.dto

import com.example.auth.common.status.ResultCode

data class BaseResponse<T>(
    val resultCode: String = ResultCode.SUCCESS.name,
    val data: T? = null,
    val messase: String = ResultCode.SUCCESS.msg,
)