package com.faphouse.helpers;

import org.apache.commons.lang3.RandomStringUtils;

public interface TestUtils {

    static String getRandomStringWithNumbers(int count) {
        int div = count / 2;
        return RandomStringUtils.randomAlphabetic(div) + RandomStringUtils.randomNumeric(count - div);
    }

    static String getRandomString(int length) {
        return RandomStringUtils.randomAlphabetic(length).toLowerCase();
    }
}
