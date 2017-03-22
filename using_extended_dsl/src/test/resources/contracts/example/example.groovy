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
            myArray:[
                            [
                                notABugGeneratedHere: execute('optionalNotNullOrEmptyString($it)'),
                                anotherArrayNeededForBug:[
                                                            [
                                                                optionalNotEmpty: execute('optionalNotNullOrEmptyString($it)') //This generates a bad JSONPath because of the get
                                                            ]
                                                         ]
                            ]
                         ]
        ])
        headers {
            contentType(applicationJson())
        }
    }
}