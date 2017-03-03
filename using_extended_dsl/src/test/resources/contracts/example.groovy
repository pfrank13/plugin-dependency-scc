package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    request {
        method 'GET'
        urlPath '/foo'
        headers {
            accept(applicationJson())
            contentType(applicationJson())
        }
    }
    response {
        status 200
        body (["type":"foo"])
        headers {
            contentType(applicationJson())
        }
    }
}