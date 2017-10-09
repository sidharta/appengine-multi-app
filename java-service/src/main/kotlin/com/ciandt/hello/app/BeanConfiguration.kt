package com.ciandt.hello.app

import com.ciandt.hello.core.usecase.GetRealNameToHello
import com.ciandt.hello.core.usecase.SayHelloUseCase
import com.ciandt.hello.gateway.inmemory.RealNameInMemoryGateway
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

/**
 * Created by sidharta on 10/6/17.
 */
@Configuration
class BeanConfiguration {

    @Bean
    fun getRealNameGateway() : GetRealNameToHello {
        return RealNameInMemoryGateway()
    }

    @Bean
    fun getSayHelloUseCase() : SayHelloUseCase {
        return SayHelloUseCase()
    }
}