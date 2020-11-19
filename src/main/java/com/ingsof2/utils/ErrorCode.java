package com.ingsof2.utils;

public enum ErrorCode {
    FAIL_GETTING_IMAGE(1, "Fail getting image."),
    FAIL_CONNECTING_TO_DB(2, "Fail connecting to the database."),
    FAIL_DISCONNECTING_TO_DB(3, "Fail disconnecting to the database."),
    FAIL_EXECUTING_QUERY(4, "Fail executing query.");

    private String code;
    private String description;

    ErrorCode(int code, String description) {
        this.code = String.format("%s", code);
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
