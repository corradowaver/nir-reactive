package com.corradowaver.reactive.controller

import com.corradowaver.reactive.service.UserService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.config.EnableWebFlux

@RestController
@EnableWebFlux
class UserController(
  val userService: UserService
) {

  @GetMapping(
    value = ["/user/username/{username}"],
    produces = [MediaType.TEXT_EVENT_STREAM_VALUE]
  )
  fun getUserByUsername(@PathVariable username: String, @RequestParam delay: Long) =
    userService.getUserByUsername(username, delay)

  @GetMapping(
    value = ["/user/password/{password}"],
    produces = [MediaType.TEXT_EVENT_STREAM_VALUE]
  )
  fun getUserByPassword(@PathVariable password: String, @RequestParam delay: Long) =
    userService.getUserByPassword(password, delay)

  @GetMapping(
    value = ["/user/all"],
    produces = [MediaType.TEXT_EVENT_STREAM_VALUE]
  )
  fun getAllUsers() =
    userService.getAllUsers()


}
