package com.corradowaver.reactive.repository

import com.corradowaver.reactive.dto.Users
import org.springframework.data.domain.Pageable
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Repository
interface UserRepository : ReactiveCrudRepository<Users, Long> {
  fun findByUsername(username: String): Mono<Users>
  fun findByPassword(password: String): Mono<Users>
}
