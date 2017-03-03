package com.example;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.jayway.restassured.RestAssured;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import static com.github.tomakehurst.wiremock.client.WireMock.*;

/**
 * @author pfrank
 */
public class ExampleBase {
  private static WireMockServer wireMockServer;

  @BeforeClass
  public static void setUpClass(){
    wireMockServer = new WireMockServer(0);
    wireMockServer.start();
    RestAssured.port = wireMockServer.port();

    WireMock.get(urlPathEqualTo("foo")).willReturn(aResponse().withStatus(200).withBody("{\"type\":\"foo\"}").withHeader("Content-Type", "application/json"));
  }


  @AfterClass
  public static void cleanUpClass(){
    wireMockServer.stop();
  }

}
