package io.vonkel.gowonderapp.infrastructure.web

import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.HttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import jakarta.inject.Inject
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import reactor.test.StepVerifier
import java.util.*

@MicronautTest
class UserControllerTest {

    @Inject
    @field:Client("/")
    lateinit var client: HttpClient

    @Test
    fun `should return all users with status OK`() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/users")

        val response = client.toBlocking().exchange(request, Array<UserResponse>::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertNotNull(response.body())

        val users = response.body()!!
        assertTrue(users.isNotEmpty())
        assertEquals(3, users.size)

        // Verifica se os dados estão corretos
        val firstUser = users[0]
        assertNotNull(firstUser.id)
        assertEquals("João Silva", firstUser.name)
        assertEquals("joao.silva@email.com", firstUser.email)
    }

    @Test
    fun `should create user with status CREATED`() {
        val userRequest = UserRequest(
            name = "Novo Usuário",
            email = "novo@email.com"
        )

        val request: HttpRequest<UserRequest> = HttpRequest.POST("/api/users", userRequest)

        val response = client.toBlocking().exchange(request, UserResponse::class.java)

        assertEquals(HttpStatus.CREATED, response.status)
        assertNotNull(response.body())

        val createdUser = response.body()!!
        assertNotNull(createdUser.id)
        assertEquals(userRequest.name, createdUser.name)
        assertEquals(userRequest.email, createdUser.email)

    }

    @Test
    fun `should return 404 when user not found by id`() {
        val nonExistentId = UUID.randomUUID().toString()
        val request: HttpRequest<Any> = HttpRequest.GET("/api/users/$nonExistentId")

        val exception = assertThrows(HttpClientResponseException::class.java) {
            client.toBlocking().exchange(request, UserResponse::class.java)
        }

        assertEquals(HttpStatus.NOT_FOUND, exception.status)
    }

    @Test
    fun `should return bad request when creating user with invalid data`() {
        // Teste com email inválido
        val invalidUserRequest = UserRequest(
            name = "",
            email = "email-invalido"
        )

        val request: HttpRequest<UserRequest> = HttpRequest.POST("/api/users", invalidUserRequest)

        val exception = assertThrows(HttpClientResponseException::class.java) {
            client.toBlocking().exchange(request, Any::class.java)
        }

        // Pode ser BAD_REQUEST se tiver validação
        assertEquals(HttpStatus.BAD_REQUEST, exception.status)
    }

    @Test
    fun `should return correct content type`() {
        val request: HttpRequest<Any> = HttpRequest.GET<Any>("/api/users")
            .header("Accept", "application/json")

        val response = client.toBlocking().exchange(request, Array<UserResponse>::class.java)

        assertEquals(HttpStatus.OK, response.status)
        assertEquals("application/json", response.contentType.get().toString())
    }

    @Nested
    inner class ReactiveTests {

        @Test
        fun `should return flux of users`() {
            val request: HttpRequest<Any> = HttpRequest.GET("/api/users")

            val response = client.toBlocking().exchange(request, Array<UserResponse>::class.java)

            val users = response.body()!!

            // Testando como Flux
            val userFlux = Flux.fromIterable(users.toList())

            StepVerifier.create(userFlux)
                .expectNextCount(3)
                .verifyComplete()

            StepVerifier.create(userFlux)
                .assertNext { user ->
                    assertNotNull(user.id)
                    assertTrue(user.name.isNotEmpty())
                    assertTrue(user.email.contains("@"))
                }
                .assertNext { user ->
                    assertNotNull(user.id)
                }
                .assertNext { user ->
                    assertNotNull(user.id)
                }
                .verifyComplete()
        }

        @Test
        fun `should create user with mono response`() {
            val userRequest = UserRequest(
                name = "Usuário Reactivo",
                email = "reactive@email.com"
            )

            val request: HttpRequest<UserRequest> = HttpRequest.POST("/api/users", userRequest)

            val response = client.toBlocking().exchange(request, UserResponse::class.java)
            val createdUser = response.body()!!

            val userMono = Mono.just(createdUser)

            StepVerifier.create(userMono)
                .assertNext { user ->
                    assertEquals(userRequest.name, user.name)
                    assertEquals(userRequest.email, user.email)
                    assertNotNull(user.id)
                }
                .verifyComplete()
        }
    }
}