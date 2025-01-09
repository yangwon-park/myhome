package com.myhome.dto

import com.fasterxml.jackson.annotation.JsonInclude
import jakarta.servlet.http.HttpServletResponse
import jakarta.servlet.http.HttpServletResponse.SC_OK

data class CommonResponse<T>(
	@JsonInclude(JsonInclude.Include.NON_NULL)
	val response: T?,
	val status: Int,
) {
	companion object {
		fun <T> ok(): CommonResponse<T> {
			return CommonResponse(null, SC_OK)
		}

		fun <T> ok(status: HttpServletResponse): CommonResponse<T> {
			return CommonResponse(null, status.status)
		}

		fun <T> ok(response: T): CommonResponse<T> {
			return CommonResponse(response, SC_OK)
		}
	}
}