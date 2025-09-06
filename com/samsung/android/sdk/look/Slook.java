package com.samsung.android.sdk.look;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.samsung.android.feature.SemFloatingFeature;
import com.samsung.android.sdk.SsdkInterface;
import com.samsung.android.sdk.SsdkUnsupportedException;
import va.e;

public final class Slook implements SsdkInterface {
    public static class VERSION_CODES {
        public static final int L1 = 1;
        public static final int L2 = 2;

    }

    public static final int AIRBUTTON = 1;
    public static final int COCKTAIL_BAR = 6;
    public static final int COCKTAIL_PANEL = 7;
    public static final int SMARTCLIP = 2;
    public static final int SPEN_BEZEL_INTERACTION = 5;
    public static final int SPEN_HOVER_ICON = 4;
    private static final String TAG = "Slook";
    private static final int VERSION_CODE = 6;
    private static final String VERSION_NAME = "1.3.0";
    public static final int WRITINGBUDDY = 3;

    @Override  // com.samsung.android.sdk.SsdkInterface
    public int getVersionCode() [...] // Inlined contents

    @Override  // com.samsung.android.sdk.SsdkInterface
    public String getVersionName() {
        return "1.3.0";
    }

    // 去混淆评级： 低(40)
    @Override  // com.samsung.android.sdk.SsdkInterface
    public void initialize(Context context0) {
        throw new SsdkUnsupportedException("This device is not samsung product.", 0);
    }

    private void insertLog(Context context0) {
        int v;
        try {
            if(!SemFloatingFeature.getInstance().getBoolean("SEC_FLOATING_FEATURE_CONTEXTSERVICE_ENABLE_SURVEY_MODE")) {
                Log.d("SM_SDK", "CONTEXTSERVICE_ENABLE_SURVEY_MODE is disable");
                return;
            }
        }
        catch(NoClassDefFoundError noClassDefFoundError0) {
            Log.e("SM_SDK", "NoClassDefFoundError : " + noClassDefFoundError0);
            return;
        }
        catch(NoSuchMethodError noSuchMethodError0) {
            Log.e("SM_SDK", "NoSuchMethodError : " + noSuchMethodError0);
            return;
        }
        try {
            v = context0.getPackageManager().getPackageInfo("com.samsung.android.providers.context", 0x80).versionCode;
        }
        catch(PackageManager.NameNotFoundException unused_ex) {
            Log.d("SM_SDK", "Could not find ContextProvider");
            v = -1;
        }
        e.f(v, "versionCode: ", "SM_SDK");
        if(v > 1) {
            if(context0.checkCallingOrSelfPermission("com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY") != 0) {
                throw new SecurityException();
            }
            ContentValues contentValues0 = new ContentValues();
            contentValues0.put("app_id", Slook.class.getPackage().getName());
            contentValues0.put("feature", "com.iloen.melon#" + 6);
            Intent intent0 = new Intent();
            intent0.setAction("com.samsung.android.providers.context.log.action.USE_APP_FEATURE_SURVEY");
            intent0.putExtra("data", contentValues0);
            intent0.setPackage("com.samsung.android.providers.context");
            context0.sendBroadcast(intent0);
            return;
        }
        Log.d("SM_SDK", "Add com.samsung.android.providers.context.permission.WRITE_USE_APP_FEATURE_SURVEY permission");
    }

    @Override  // com.samsung.android.sdk.SsdkInterface
    public boolean isFeatureEnabled(int v) {
        switch(v) {
            case 1: 
            case 2: 
            case 3: 
            case 4: 
            case 5: {
                return RefSlookImpl.get().isFeatureEnabled(v);
            }
            case 6: {
                return RefSlookImpl.get().isFeatureEnabled(6);
            }
            case 7: {
                return RefSlookImpl.get().isFeatureEnabled(7);
            }
            default: {
                throw new IllegalArgumentException("The type(" + v + ") is not supported.");
            }
        }
    }

    private boolean isSupportedDevice() {
        for(int v = 1; true; ++v) {
            if(v > 7) {
                return false;
            }
            switch(v) {
                case 1: 
                case 2: 
                case 3: 
                case 4: 
                case 5: {
                    if(RefSlookImpl.get().isFeatureEnabled(v)) {
                        return true;
                    }
                    break;
                }
                case 6: {
                    if(RefSlookImpl.get().isFeatureEnabled(6)) {
                        return true;
                    }
                    break;
                }
                case 7: {
                    if(RefSlookImpl.get().isFeatureEnabled(7)) {
                        return true;
                    }
                }
            }
        }
    }
}

