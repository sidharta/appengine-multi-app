package com.ciandt.hello.core.usecase

import com.ciandt.hello.core.entity.HelloMessage
import org.springframework.beans.factory.annotation.Autowired

class SayHelloUseCase {

    @Autowired
    val gw : GetRealNameToHello? = null

    fun sayHello(name: String): HelloMessage {
        val realName = gw!!.getRealNameToHello(name = name)
        return HelloMessage(message = "Hello $realName!")
    }
}