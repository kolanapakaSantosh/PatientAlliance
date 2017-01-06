package com.scottline.patientalliance.customviews;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by ramesh on 1/3/17.
 */

public class EditText_RobotoRegular extends EditText {

    public EditText_RobotoRegular(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public EditText_RobotoRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public EditText_RobotoRegular(Context context) {
        super(context);
        init();
    }

    /**
     * Font is set based on the activity the user is in
     * so using try catch block to verify the view and setting the font
     * by this way font can be easily changed
     */
    private void init() {
        if (isInEditMode()) {
            Typeface myFonts = Typeface.createFromAsset(getContext().getAssets(),
                    "fonts/roboto_regular.ttf");
            setTypeface(myFonts);
        }

    }
}
