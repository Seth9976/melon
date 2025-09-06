package com.samsung.android.sdk.look.cocktailbar;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.samsung.android.sdk.look.Slook;

@Deprecated
public final class SlookCocktailSubWindow {
    private static Slook mSlook;

    static {
        SlookCocktailSubWindow.mSlook = new Slook();
    }

    public static Window getSubWindow(Activity activity0) {
        if(SlookCocktailSubWindow.mSlook.isFeatureEnabled(6)) {
            if(activity0 == null) {
                throw new IllegalArgumentException("activity is null.");
            }
            Window window0 = RefActivity.get().getSubWindow(activity0);
            if(window0 == null) {
                throw new IllegalArgumentException("activity is invalid.");
            }
            return window0;
        }
        return null;
    }

    public static void setSubContentView(Activity activity0, int v) {
        if(SlookCocktailSubWindow.mSlook.isFeatureEnabled(6)) {
            if(activity0 == null) {
                throw new IllegalArgumentException("activity is null.");
            }
            if(RefActivity.get().getSubWindow(activity0) == null) {
                throw new IllegalArgumentException("activity is invalid.");
            }
            RefActivity.get().setSubContentView(activity0, v);
        }
    }

    public static void setSubContentView(Activity activity0, View view0) {
        if(SlookCocktailSubWindow.mSlook.isFeatureEnabled(6)) {
            if(activity0 == null) {
                throw new IllegalArgumentException("activity is null.");
            }
            if(RefActivity.get().getSubWindow(activity0) == null) {
                throw new IllegalArgumentException("activity is invalid.");
            }
            RefActivity.get().setSubContentView(activity0, view0);
        }
    }
}

