package com.corradowaver.reactive.dto

import org.springframework.data.annotation.Id

data class Users(
  @Id
  val username: String = "",
  val password: String = ""
)
