package com.ciandt.hello.endpoint.rest

import com.ciandt.hello.core.usecase.SayHelloUseCase
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("hello")
class HelloController() {

    @Autowired
    val sayHelloUC: SayHelloUseCase? = null

    @GetMapping
    @ApiOperation(value = "sayHello", nickname = "hello")
    @ApiResponses(ApiResponse(code = 200, message = "Success", response = HelloDto::class))
    fun sayHello(@RequestParam(value = "name", defaultValue = "World") name: String): HelloDto {
        val msg = sayHelloUC!!.sayHello(name)
        return HelloDto(message = msg.message)
    }
}
