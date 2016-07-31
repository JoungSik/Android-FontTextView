package com.joung.fonttextview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.joung.fonttextview.R;
import com.joung.fonttextview.util.FontUtil;

public class FontTextView extends TextView {
    public int type;
    public Context context;

    public FontTextView(Context context) {
        super(context);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        getAttrs(attrs);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        getAttrs(attrs, defStyleAttr);
    }

    private void getAttrs(AttributeSet attrs) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.FontTextView);
        setFont(typedArray);
    }


    private void getAttrs(AttributeSet attrs, int defStyle) {
        TypedArray typedArray = getContext().obtainStyledAttributes(attrs, R.styleable.FontTextView, defStyle, 0);
        setFont(typedArray);
    }

    private void setFont(TypedArray typedArray) {
        int fontType = typedArray.getInt(R.styleable.FontTextView_type, -1);
        FontUtil.setFont(this, fontType);
    }
}
