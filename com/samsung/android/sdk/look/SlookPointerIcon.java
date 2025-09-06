package com.samsung.android.sdk.look;

import A7.d;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View.OnHoverListener;
import android.view.View;
import va.e;

@Deprecated
public class SlookPointerIcon {
    private int HOVERING_SPENICON_CUSTOM;
    private int HOVERING_SPENICON_DEFAULT;
    private static final String TAG = "SlookPointerIcon";
    private boolean bLoggingFlag;
    private Context mContext;
    private Drawable mDrawable;
    private Slook mSlook;

    public SlookPointerIcon() {
        this.mSlook = new Slook();
        this.bLoggingFlag = false;
        this.HOVERING_SPENICON_CUSTOM = 0;
        this.HOVERING_SPENICON_DEFAULT = 1;
    }

    private void insertLogForAPI(String s) {
        int v;
        if(this.mContext == null) {
            return;
        }
        String s1 = Slook.class.getPackage().getName();
        try {
            v = this.mContext.getPackageManager().getPackageInfo("com.samsung.android.providers.context", 0x80).versionCode;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            Log.d("SM_SDK", "Could not find ContextProvider");
            v = -1;
        }
        e.f(v, "context framework\'s  versionCode: ", "SM_SDK");
        if(v > 1) {
            if(this.mContext.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
                throw new SecurityException();
            }
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("app_id", s1);
            contentValues0.put("feature", "com.iloen.melon#6");
            contentValues0.put("extra", s);
            Log.d("SlookPointerIcon", d.n(new StringBuilder(String.valueOf(s1)), ", ", "com.iloen.melon#6", ", ", s));
            Intent intent0 = new Intent();
            intent0.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
            intent0.putExtra("data", contentValues0);
            intent0.setPackage("com.samsung.android.providers.context");
            this.mContext.sendBroadcast(intent0);
            return;
        }
        Log.d("SM_SDK", "Add com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission");
    }

    private boolean isSupport(int v) {
        return this.mSlook.isFeatureEnabled(4);
    }

    public void setHoverIcon(View view0, Drawable drawable0) {
        if(!this.isSupport(1)) {
            Log.d("SlookPointerIcon", "setHoverIcon does not support from Android N OS");
            return;
        }
        if(view0 != null) {
            this.mContext = view0.getContext();
            if(drawable0 == null) {
                view0.setOnHoverListener(null);
                RefPointerIcon.get().setHoveringSpenIcon(this.HOVERING_SPENICON_DEFAULT, -1);
                return;
            }
            this.mDrawable = drawable0;
            view0.setOnHoverListener(new View.OnHoverListener() {
                @Override  // android.view.View$OnHoverListener
                public boolean onHover(View view0, MotionEvent motionEvent0) {
                    switch(motionEvent0.getAction()) {
                        case 9: {
                            RefPointerIcon.get().setHoveringSpenIcon(SlookPointerIcon.this.HOVERING_SPENICON_CUSTOM, SlookPointerIcon.this.mDrawable);
                            return false;
                        }
                        case 10: {
                            RefPointerIcon.get().setHoveringSpenIcon(SlookPointerIcon.this.HOVERING_SPENICON_DEFAULT, -1);
                            return false;
                        }
                        default: {
                            return false;
                        }
                    }
                }
            });
            try {
                if(!this.bLoggingFlag) {
                    this.insertLogForAPI("setHoverIcon");
                    this.bLoggingFlag = true;
                }
                return;
            }
            catch(SecurityException unused_ex) {
                throw new SecurityException("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission is required.");
            }
        }
        throw new IllegalArgumentException("view is null.");
    }
}

