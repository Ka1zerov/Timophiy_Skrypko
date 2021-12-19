package utils;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

import static io.restassured.config.EncoderConfig.encoderConfig;

public class Specification {
    private static final String BASE_URL = "https://api.dropboxapi.com";
    private static String token = "sl.A-fTDI1SFvUdY1tkVnBzJ6t8x7P0ap6WpmK0Zmz9QOjHhAH0ep2SlBj4-kS0I6YI3vKL8z5PqfsNW6PFBBg3ZiKcRrJYwEsolL-FyYTR-tgSGF-ef8hN8D-GlYLyq5YonXBwPbC8Lor6";

    public static RequestSpecification REQ_SPEC =
            new RequestSpecBuilder()
                    .setConfig(RestAssured.config().encoderConfig(encoderConfig().appendDefaultContentCharsetToContentTypeIfUndefined(false)))
                    .setBaseUri(BASE_URL)
                    .setBasePath("/2/files")
                    .setAuth(RestAssured.oauth2(token))
                    .build();
}
