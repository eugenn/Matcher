package org.match.controller;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.match.MatchConfiguration;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static io.restassured.RestAssured.given;
/**
 * Created by eugennekhai on 07/07/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MatchConfiguration.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class MatchControllerIT {
    @Value("${local.server.port}")   //
    int port;
    String input = "I have a sore throat and headache.";
    String output = "[\"sore throat\",\"headache\"]";

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void shouldFindMatchedPhrases() {
        given().
                param("q", input).
        when().
                get("/match").
        then().
                contentType(ContentType.JSON).
                statusCode(HttpStatus.OK.value()).
        assertThat().
                body(CoreMatchers.is(output));
    }

    @Test
    public void shouldFindPhrasesUsingTriesMatch() {
        given().
                param("q", input).
        when().
                get("/fastMatch").
        then().
                contentType(ContentType.JSON).
                statusCode(HttpStatus.OK.value()).
        assertThat().
                body(CoreMatchers.is(output));
    }

    @Test
    public void shouldNotFindPhrases() {
        String input = "nothing";
        String output = "[]";

        given().
                param("q", input).
        when().
                get("/match").
        then().
                contentType(ContentType.JSON).
                statusCode(HttpStatus.OK.value()).
        assertThat().
                body(CoreMatchers.is(output));
    }

    @Test
    public void shouldThrowError() {
        String input = "nothing";
        String output = "Error! Please check input params";

        given().
                param("q1", input).
        when().
                get("/match").
        then().
                contentType(ContentType.TEXT).
                statusCode(HttpStatus.BAD_REQUEST.value()).
        assertThat().
                body(CoreMatchers.is(output));
    }

}