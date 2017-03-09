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
        body (['things':[['id':anyNumber()]]])
        headers {
            contentType(applicationJson())
        }
    }
}

/*
{
  "things":[
    {
      "id":"notNull"
    }
  ],
  "someOtherThing":{
    "things":[]
  }
}
 */