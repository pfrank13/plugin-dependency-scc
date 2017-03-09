package com.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.jayway.restassured.RestAssured;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.util.StreamUtils;

import java.io.IOException;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @author pfrank
 */
public class ExampleBase {
  private static WireMockServer wireMockServer;

  @BeforeClass
  public static void setUpClass() throws IOException{
    wireMockServer = new WireMockServer(0);
    wireMockServer.start();

    RestAssured.baseURI = "http://localhost";
    RestAssured.port = wireMockServer.port();

    final Resource exampleResponseJson = new ClassPathResource("/json/example_response.json");
    wireMockServer.stubFor(WireMock.get(urlEqualTo("/foo")).willReturn(aResponse().withStatus(200).withBody(StreamUtils.copyToByteArray(exampleResponseJson.getInputStream())).withHeader("Content-Type", "application/json")));
  }


  @AfterClass
  public static void cleanUpClass(){
    wireMockServer.stop();
  }

}
