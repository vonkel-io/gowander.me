package io.vonkel.gowonderapp.infrastructure.web

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.serde.annotation.Serdeable
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.UUID

@Controller("/api/users")
class UserController(
    // Injeção do caso de uso (UserService)
) {

    @Post
    fun createUser(@Body userRequest: UserRequest): Mono<HttpResponse<UserResponse>> {
        val user = UserResponse(
            id=UUID.randomUUID().toString(),
            name=userRequest.name,
            email=userRequest.email
        )
        return Mono.just(HttpResponse.created(user))
    }

    @Get
    fun getAllUsers(): Flux<UserResponse> {
        val users = listOf(
            UserResponse(
                id = UUID.randomUUID().toString(),
                name = "João Silva",
                email = "joao.silva@email.com"
            ),
            UserResponse(
                id = UUID.randomUUID().toString(),
                name = "Maria Santos",
                email = "maria.santos@email.com"
            ),
            UserResponse(
                id = UUID.randomUUID().toString(),
                name = "Carlos Oliveira",
                email = "carlos.oliveira@email.com"
            )
        )
        return Flux.fromIterable(users)
    }

    @Get("/{id}")
    fun getUserById(@PathVariable id: String): Mono<UserResponse> {
        return Mono.empty()
    }
}

// DTOs
@Serdeable
data class UserRequest(
    val name: String,
    val email: String
)

@Serdeable
data class UserResponse(
    val id: String,
    val name: String,
    val email: String
)