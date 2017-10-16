package com.ciandt.hello.core.usecase

import com.ciandt.hello.core.entity.HelloMessage
import org.springframework.beans.factory.annotation.Autowired

class SayHelloUseCase {

    var gw: GetRealNameToHello

    @Autowired
    constructor(gw: GetRealNameToHello) {
        this.gw = gw
    }

    fun sayHello(name: String): HelloMessage {
        val realName = gw.getRealNameToHello(name = name)
        return HelloMessage(message = "Hello $realName!")
    }
}