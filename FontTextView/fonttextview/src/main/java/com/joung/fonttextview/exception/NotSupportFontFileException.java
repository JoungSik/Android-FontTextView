package com.joung.fonttextview.exception;

public class NotSupportFontFileException extends Exception {

    private String fileName = null;

    public NotSupportFontFileException() {
        super("Not Support Font file type");
    }

    public NotSupportFontFileException(String fileName) {
        this.fileName = fileName;
    }

    public String toString() {
        if (fileName != null) {
            return fileName + " - this Font file is not support file.";
        } else {
            return "this Font file is not support file.";
        }
    }
}
