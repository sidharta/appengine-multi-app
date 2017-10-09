package com.ciandt.hello.gateway.inmemory

import com.ciandt.hello.core.usecase.GetRealNameToHello

/**
 * Created by sidharta on 10/6/17.
 */
class RealNameInMemoryGateway : GetRealNameToHello {

    override fun getRealNameToHello(name: String): String = "Mr. $name"

}