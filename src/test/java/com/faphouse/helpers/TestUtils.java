package com.faphouse.helpers;

import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public interface TestUtils {
    static Response verifyCode(Response response, Integer statusCode) {
        return response.then().statusCode(statusCode).extract().response();
    }

    static String getRandomStringWithNumbers(int upperRange) {
        return RandomStringUtils.randomAlphanumeric(upperRange);
    }

    static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }

    static String formatDate(DateTime date, String pattern) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern(pattern);
        return dateTimeFormatter.print(date);
    }

    static String generateStringFromResource(String path) throws IOException {
        return new String(Files.readAllBytes(Paths.get(path)));
    }
}
