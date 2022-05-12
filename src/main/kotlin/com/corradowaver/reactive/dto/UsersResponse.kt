package com.corradowaver.reactive.dto

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class UsersResponse(
  val username: String = "",
  val password: String = ""
)
