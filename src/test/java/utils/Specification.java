package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class Specification {
    private static final String BASE_URL = "https://api.dropboxapi.com";
    private static String token = "UpMP4Un1mYEAAAAAAAAAAS5Z-C7nNpQ7T4Yu58AaY_G0yteV79OQqDq9aDV4ZBqj";

    public static RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setConfig(RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                    .setBaseUri(BASE_URL)
                    .setBasePath("/2/files")
                    .setAuth(RestAssured.oauth2(token))
                    .build();
}
