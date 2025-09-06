package com.kakao.emoticon.util;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import b.l;

public class SoftInputHelper {
    public static void a(Context context0, View view0) {
        SoftInputHelper.lambda$showSoftInputDelayed$0(context0, view0);
    }

    public static void hideSoftInput(Activity activity0) {
        activity0.getWindow().setSoftInputMode(3);
    }

    public static void hideSoftInput(Context context0, View view0) {
        if(view0 == null) {
            return;
        }
        ((InputMethodManager)context0.getSystemService("input_method")).hideSoftInputFromWindow(view0.getApplicationWindowToken(), 0);
    }

    private static void lambda$showSoftInputDelayed$0(Context context0, View view0) {
        ((InputMethodManager)context0.getSystemService("input_method")).showSoftInput(view0, 1);
    }

    public static void showSoftInput(Context context0, View view0, int v) {
        if(view0 == null) {
            return;
        }
        ((InputMethodManager)context0.getSystemService("input_method")).showSoftInput(view0, v);
    }

    public static void showSoftInputDelayed(Context context0, View view0) {
        if(view0 == null) {
            return;
        }
        view0.postDelayed(new l(23, context0, view0), 200L);
    }
}

