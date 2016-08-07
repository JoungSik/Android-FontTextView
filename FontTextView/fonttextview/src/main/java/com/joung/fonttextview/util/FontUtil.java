package com.joung.fonttextview.util;

import android.content.Context;
import android.graphics.Typeface;
import android.util.Log;
import android.widget.TextView;

import com.joung.fonttextview.model.FontType;

import java.io.IOException;
import java.util.Locale;
import java.util.regex.Pattern;

public class FontUtil {
    private static final String TAG = FontUtil.class.getSimpleName();

    private static final String PATH_FONT = "fonts/";
    private static final String SLASH = "/";

    private static String[] koreaFontAssetList = new String[FontType.SUPPORT_FONT_TYPE_COUNT];
    private static String[] englishFontAssetList = new String[FontType.SUPPORT_FONT_TYPE_COUNT];

    public static FontUtil mInstance = null;

    public FontUtil() {}

    public static FontUtil getInstance() {
        if (mInstance == null) {
            mInstance = new FontUtil();
        }
        return mInstance;
    }

    public void getFontExtension(Context context) {
        try {
            String[] koreaAssetList = context.getAssets().list(PATH_FONT + FontType.KOREA);
            String[] englishAssetList = context.getAssets().list(PATH_FONT + FontType.ENGLISH);

            for (String koreaAsset : koreaAssetList) {
                Pattern pattern = Pattern.compile(FontType.STRING_MATCH_REGULAR, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(koreaAsset).find()) {
                    koreaFontAssetList[FontType.REGULAR] = koreaAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_BOLD, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(koreaAsset).find()) {
                    koreaFontAssetList[FontType.BOLD] = koreaAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_THIN, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(koreaAsset).find()) {
                    koreaFontAssetList[FontType.THIN] = koreaAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_MEDIUM, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(koreaAsset).find()) {
                    koreaFontAssetList[FontType.MEDIUM] = koreaAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_LIGHT, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(koreaAsset).find()) {
                    koreaFontAssetList[FontType.LIGHT] = koreaAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_BLACK, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(koreaAsset).find()) {
                    koreaFontAssetList[FontType.BLACK] = koreaAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_ITALIC, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(koreaAsset).find()) {
                    koreaFontAssetList[FontType.ITALIC] = koreaAsset;
                }
            }

            for (String englishAsset : englishAssetList) {
                Pattern pattern = Pattern.compile(FontType.STRING_MATCH_REGULAR, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(englishAsset).find()) {
                    englishFontAssetList[FontType.REGULAR] = englishAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_BOLD, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(englishAsset).find()) {
                    englishFontAssetList[FontType.BOLD] = englishAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_THIN, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(englishAsset).find()) {
                    englishFontAssetList[FontType.THIN] = englishAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_MEDIUM, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(englishAsset).find()) {
                    englishFontAssetList[FontType.MEDIUM] = englishAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_LIGHT, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(englishAsset).find()) {
                    englishFontAssetList[FontType.LIGHT] = englishAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_BLACK, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(englishAsset).find()) {
                    englishFontAssetList[FontType.BLACK] = englishAsset;
                }

                pattern = Pattern.compile(FontType.STRING_MATCH_ITALIC, Pattern.CASE_INSENSITIVE);
                if (pattern.matcher(englishAsset).find()) {
                    englishFontAssetList[FontType.ITALIC] = englishAsset;
                }
            }
        } catch (IOException e) {
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
        if (!locale.equals(FontType.ENGLISH) && !locale.equals(FontType.KOREA)) {
            Log.e(TAG, "Error - Not Support Device Locale. then Default Local English");

            locale = FontType.ENGLISH;
        }

        String path = PATH_FONT + locale + SLASH;
        if (locale.equals(FontType.KOREA)) {
            path += koreaFontAssetList[fontType];
        } else {
            path += englishFontAssetList[fontType];
        }
        return path;
    }
}
