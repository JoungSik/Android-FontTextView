package com.joung.fonttextview.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

import com.joung.fonttextview.exception.NotSupportFontFileException;
import com.joung.fonttextview.model.FontType;
import com.joung.fonttextview.model.Language;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FontUtil {
    private static final String TAG = FontUtil.class.getSimpleName();

    private static final String PATH_FONT = "fonts/";
    private static final String SLASH = "/";

    public static FontUtil mInstance = null;

    public FontUtil() {
        Log.v(TAG, "new Instance");
    }

    public static FontUtil getInstance() {
        if (mInstance == null) {
            mInstance = new FontUtil();
        }
        return mInstance;
    }

    public void getFontExtension(Context context) {
        try {
            String[] koreaAssetList = context.getAssets().list(PATH_FONT + Language.korea);
            String[] englishAssetList = context.getAssets().list(PATH_FONT + Language.english);

            ArrayList<String> mAssetList = new ArrayList<>();
            mAssetList.addAll(Arrays.asList(koreaAssetList));
            mAssetList.addAll(Arrays.asList(englishAssetList));

            Pattern pattern = Pattern.compile("\\.(ttf)$", Pattern.CASE_INSENSITIVE);
            for (String asset : mAssetList) {
                Matcher m = pattern.matcher(asset);
                if (!m.find()) {
                    throw new NotSupportFontFileException(asset);
                }
            }
        } catch (IOException | NotSupportFontFileException e) {
            e.printStackTrace();
        }
    }

    public static void setFont(TextView textView, int fontType) {
        String fontPath = FontUtil.getFontType(fontType);
        try {
            textView.setTypeface(Typeface.createFromAsset(textView.getContext().getAssets(), fontPath));
        } catch (Exception e) {
            Log.e(TAG, "error message - " + e.toString());
            Log.e(TAG, "font type - " + fontType);
            Log.e(TAG, "font path - " + fontPath);

            e.printStackTrace();
        }
    }

    public static String getFontType(int fontType) {

        // Todo: Checking Support Locale.
        String locale = Locale.getDefault().getLanguage();
        if (!locale.equals(Language.english) && !locale.equals(Language.korea)) {
            Log.e(TAG, "Error - Not Support Device Locale.");
            Log.e(TAG, "Error - then Default Local English");

            locale = Language.english;
        }

        String path = PATH_FONT + locale + SLASH;
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
        return path + FontType.FONT_TYPE_TTF;
    }
}
