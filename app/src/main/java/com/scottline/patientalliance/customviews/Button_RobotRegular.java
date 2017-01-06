package com.scottline.patientalliance.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by ramesh on 1/4/17.
 */

public class Button_RobotRegular extends EditText {

    public Button_RobotRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public Button_RobotRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public Button_RobotRegular(Context context) {
        super(context);
        init();
    }


    private void init() {
        if (isInEditMode()) {
            Typeface myFonts = Typeface.createFromAsset(getContext().getAssets(),
                    "fonts/roboto_regular.ttf");
            setTypeface(myFonts);
        }

    }
}