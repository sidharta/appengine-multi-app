package com.ciandt.hello.core.usecase.sayhello

import com.ciandt.hello.core.usecase.GetRealNameToHello
import com.ciandt.hello.core.usecase.SayHelloUseCase
import spock.lang.Specification

class SayHelloUseCaseTest extends Specification {

    SayHelloUseCase sayHelloUseCase

    GetRealNameToHello getRealNameToHello

    def setup() {
        getRealNameToHello = Mock(GetRealNameToHello)
        sayHelloUseCase = new SayHelloUseCase(getRealNameToHello)
    }

    def "SayHelloToJohn"() {
        given: "a Jon' name"
        String name = "John"

        when: "say hello to Mr. John"
        String helloMessage = sayHelloUseCase.sayHello(name)

        then: "a hello message is said to John"
        helloMessage.contains("Hello John!")
        1 * getRealNameToHello.getRealNameToHello(name) >> name
    }

}
