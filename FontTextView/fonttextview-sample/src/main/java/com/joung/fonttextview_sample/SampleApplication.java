package com.joung.fonttextview_sample;

import android.app.Application;

import com.joung.fonttextview.util.FontUtil;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        FontUtil.getInstance().getFontExtension(this);
    }
}
