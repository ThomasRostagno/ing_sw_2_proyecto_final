package com.ingsof2.exceptions;

import com.ingsof2.utils.ErrorCode;

import javax.swing.*;

public class ApiException extends Exception {

    private String code;
    private String description;

    public ApiException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.description = errorCode.getDescription();
    }

    public ApiException(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public static void showException(ApiException e) {
        JOptionPane.showMessageDialog(new JFrame(), e.getDescription(), "Error",
                JOptionPane.ERROR_MESSAGE);

    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
