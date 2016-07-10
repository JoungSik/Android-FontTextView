package com.joung.fonttextview.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import com.joung.fonttextview.R;

public class FontTextView extends TextView {

    private static final int NORMAL = -1;
    private static final int REGULAR = 0;
    private static final int BOLD = 1;

    public Context context;
    public int type;

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
        switch (fontType) {
            case NORMAL:
                break;
            case REGULAR:
                this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/en/regular.ttf"));
                break;
            case BOLD:
                this.setTypeface(Typeface.createFromAsset(context.getAssets(), "fonts/en/bold.ttf"));
                break;
        }
    }
}
