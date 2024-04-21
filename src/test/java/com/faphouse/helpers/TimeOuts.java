package com.faphouse.helpers;

public enum TimeOuts {
    ELEMENT_LOAD_TIMEOUT_S(300),
    ELEMENT_LOAD_TIMEOUT_MS(20000),
    ELEMENT_LOAD_VALUE_TIMEOUT_MS(30000),
    PAGE_LOAD_TIMEOUT_S(15),
    PAGE_LOAD_TIMEOUT_MS(15000),
    ELEMENT_INVISIBILITY_TIMEOUT_MS(20000),
    LIST_LOAD_TIMEOUT_S(40),
    FILE_LOAD_TIMEOUT_MS(20000),
    WAIT_API_MS(120000),
    WAIT_NEW_MESSAGE_S(120),
    WAIT_NEW_MESSAGE_MS(120000),
    AJAX_LOADER_MS(30000),
    SVG_LOADING_MS(3000),
    VIDEO_LOADING_MS(60000);

    private final Integer value;

    TimeOuts(Integer value){
        this.value = value;
    }

    public Integer getValue(){
        return value;
    }
}
