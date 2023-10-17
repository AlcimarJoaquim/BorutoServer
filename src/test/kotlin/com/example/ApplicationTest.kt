package com.example

import com.example.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.testing.*
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testRoot() {
        withTestApplication(moduleFunction = Application::module){
            handleRequest(HttpMethod.Get, "/").apply {
                assertEquals(expected = HttpStatusCode.OK, actual = response.status())
                assertEquals("Welcome to Boruto API!", response.content)
            }
        }
    }
}
