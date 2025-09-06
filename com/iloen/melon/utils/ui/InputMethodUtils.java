package com.iloen.melon.utils.ui;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.iloen.melon.utils.log.LogU;

public class InputMethodUtils {
    public static void hideInputMethod(Context context0, View view0) {
        if(context0 == null) {
            LogU.w("InputMethodUtils", "hideInputMethod() invalid context");
            return;
        }
        if(view0 == null) {
            LogU.w("InputMethodUtils", "hideInputMethod() invalid targetView");
            return;
        }
        InputMethodManager inputMethodManager0 = (InputMethodManager)context0.getSystemService("input_method");
        if(inputMethodManager0 != null) {
            inputMethodManager0.hideSoftInputFromWindow(view0.getWindowToken(), 0);
        }
        view0.clearFocus();
    }

    public static void showInputMethod(Context context0, EditText editText0) {
        if(context0 == null) {
            LogU.w("InputMethodUtils", "showInputMethod() invalid context");
            return;
        }
        if(editText0 != null && editText0.requestFocus()) {
            ((InputMethodManager)context0.getSystemService("input_method")).showSoftInput(editText0, 0);
        }
    }
}

