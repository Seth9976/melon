package com.samsung.android.sdk.look.cocktailbar;

import android.app.Activity;
import android.view.View;
import android.view.Window;

class RefActivity extends AbstractBaseReflection {
    private static RefActivity mInstance;

    public static RefActivity get() {
        if(RefActivity.mInstance == null) {
            RefActivity.mInstance = new RefActivity();
        }
        return RefActivity.mInstance;
    }

    @Override  // com.samsung.android.sdk.look.cocktailbar.AbstractBaseReflection
    public String getBaseClassName() {
        return "android.app.Activity";
    }

    public Window getSubWindow(Activity activity0) {
        Object object0 = this.invokeNormalMethod(activity0, "getSubWindow");
        return object0 instanceof Window ? ((Window)object0) : null;
    }

    public void setSubContentView(Activity activity0, int v) {
        this.invokeNormalMethod(activity0, "setSubContentView", new Class[]{Integer.TYPE}, new Object[]{v});
    }

    public void setSubContentView(Activity activity0, View view0) {
        this.invokeNormalMethod(activity0, "setSubContentView", new Class[]{View.class}, new Object[]{view0});
    }
}

