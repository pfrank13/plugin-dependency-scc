package com.example

import org.springframework.cloud.contract.spec.internal.ServerDslProperty

import java.util.regex.Pattern

/**
 * @author pfrank
 */
class ExtendedDsl {
    static ServerDslProperty enumOf(String... values){
        createAndValidateProperty(Pattern.compile(values.collect({"(.*$it.*)"}).join("|")), values[0])
    }
}
