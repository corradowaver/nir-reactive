package com.corradowaver.reactive.service

import com.corradowaver.reactive.dto.Users
import com.corradowaver.reactive.dto.UsersResponse
import com.corradowaver.reactive.repository.UserRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.Duration.ofMillis

@Service
class UserService(
  val userRepository: UserRepository
) {

  fun getUserByUsername(username: String, delay: Long): Mono<UsersResponse> =
    userByUsernameFromRepo(username, delay).map {
      UsersResponse(it.username, generatePassword())
    }


  fun getUserByPassword(password: String, delay: Long): Mono<UsersResponse> =
    userByPasswordFromRepo(password, delay).map {
      UsersResponse(it.username, generatePassword())
    }


  fun getAllUsers(): Flux<UsersResponse> =
    userRepository.findAll()
      .map { UsersResponse(it.username, generatePassword()) }

  private fun userByUsernameFromRepo(username: String, delay: Long): Mono<Users> =
    userRepository.findByUsername(username).delayElement(ofMillis(delay))

  // Not indexed by password
  private fun userByPasswordFromRepo(username: String, delay: Long): Mono<Users> =
    userRepository.findByPassword(username).delayElement(ofMillis(delay))

  private fun generatePassword(): String = "fake"

}
