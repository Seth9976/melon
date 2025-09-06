package com.samsung.android.sdk.look;

import android.graphics.drawable.Drawable;

class RefPointerIcon extends AbstractBaseReflection {
    private static RefPointerIcon sInstance;

    public static RefPointerIcon get() {
        if(RefPointerIcon.sInstance == null) {
            RefPointerIcon.sInstance = new RefPointerIcon();
        }
        return RefPointerIcon.sInstance;
    }

    @Override  // com.samsung.android.sdk.look.AbstractBaseReflection
    public String getBaseClassName() {
        return "android.view.PointerIcon";
    }

    public int setHoveringSpenIcon(int v, Drawable drawable0) {
        Object object0 = this.invokeStaticMethod("setHoveringSpenIcon", new Class[]{Integer.TYPE, Drawable.class}, new Object[]{v, drawable0});
        return object0 == null ? -1 : ((int)(((Integer)object0)));
    }

    public void setHoveringSpenIcon(int v, int v1) {
        this.invokeStaticMethod("setHoveringSpenIcon", new Class[]{Integer.TYPE, Integer.TYPE}, new Object[]{v, v1});
    }
}

