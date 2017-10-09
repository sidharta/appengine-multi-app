package com.ciandt.hello.endpoint.rest

import com.ciandt.hello.core.entity.HelloMessage
import com.ciandt.hello.core.usecase.SayHelloUseCase
import org.springframework.web.bind.annotation.*
import io.swagger.annotations.*
import org.springframework.beans.factory.annotation.Autowired

@RestController
@RequestMapping("hello")
class HelloController() {

    @Autowired
    val sayHelloUC : SayHelloUseCase? = null

    @GetMapping
    @ApiOperation(value = "sayHello", nickname = "hello")
	@ApiResponses(ApiResponse(code = 200, message = "Success", response =  HelloMessage::class ))
    fun sayHello( @RequestParam(value="name", defaultValue="World") name: String ): HelloMessage {
        val msg = sayHelloUC!!.sayHello(name)
        return msg
    }
}
