package com.kakao.emoticon.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import com.kakao.emoticon.KakaoEmoticon;

public enum ScreenUtils {
    INSTANCE;

    private float mDensity;
    private int mDensityDPI;

    private ScreenUtils() {
        DisplayMetrics displayMetrics0 = KakaoEmoticon.getApplication().getApplicationContext().getResources().getDisplayMetrics();
        this.mDensity = displayMetrics0.density;
        this.mDensityDPI = displayMetrics0.densityDpi;
    }

    public int dp2px(float f) {
        int v = (int)(this.mDensity * f);
        return 0.0f >= f || v != 0 ? v : 1;
    }

    public int getDensityDPI() {
        return this.mDensityDPI;
    }

    public int getHeight() {
        return KakaoEmoticon.getApplication().getApplicationContext().getResources().getDisplayMetrics().heightPixels;
    }

    public int getHeight(Context context0) {
        return context0.getResources().getDisplayMetrics().heightPixels;
    }

    public int getOrientation() {
        return KakaoEmoticon.getApplication().getApplicationContext().getResources().getConfiguration().orientation;
    }

    public int getStatusBarHeight(Resources resources0) {
        int v = resources0.getIdentifier("status_bar_height", "dimen", "android");
        return v <= 0 ? 0 : resources0.getDimensionPixelSize(v);
    }

    public int getWidth() {
        return KakaoEmoticon.getApplication().getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    public int getWidth(Context context0) {
        return context0.getResources().getDisplayMetrics().widthPixels;
    }

    public boolean isLandscape() {
        return KakaoEmoticon.getApplication().getApplicationContext().getResources().getConfiguration().orientation == 2;
    }

    public boolean isPortrait() {
        return KakaoEmoticon.getApplication().getApplicationContext().getResources().getConfiguration().orientation == 1 ? true : KakaoEmoticon.getApplication().getApplicationContext().getResources().getConfiguration().orientation == 1;
    }
}

