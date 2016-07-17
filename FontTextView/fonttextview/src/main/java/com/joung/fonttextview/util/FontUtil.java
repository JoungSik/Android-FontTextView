package com.joung.fonttextview.util;

import android.util.Log;

import com.joung.fonttextview.model.FontType;

import java.util.Locale;

public class FontUtil {
    public static String getFontType(int fontType) {
        String path = "fonts/" + Locale.getDefault().getLanguage() + "/";
        switch (fontType) {
            case FontType.REGULAR:
                path += FontType.STRING_REGULAR;
                break;
            case FontType.BOLD:
                path += FontType.STRING_BOLD;
                break;
            case FontType.THIN:
                path += FontType.STRING_THIN;
                break;
            case FontType.MEDIUM:
                path += FontType.STRING_MEDIUM;
                break;
            case FontType.LIGHT:
                path += FontType.STRING_LIGHT;
                break;
            case FontType.BLACK:
                path += FontType.STRING_BLACK;
                break;
            case FontType.ITALIC:
                path += FontType.STRING_ITALIC;
                break;
        }

        Log.v("TAG", "path - " + path);
        return path + ".ttf";
    }
}
