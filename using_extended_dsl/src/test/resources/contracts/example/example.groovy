package contracts.example

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
        body ([
            iso8601WithOffset: anyIso8601WithOffset(),
            url: anyUrl()
        ])
        headers {
            contentType(applicationJson())
        }
    }
}