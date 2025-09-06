package com.bumptech.glide.signature;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.bumptech.glide.load.Key;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class ApplicationVersionSignature {
    private static final ConcurrentMap PACKAGE_NAME_TO_KEY = null;
    private static final String TAG = "AppVersionSignature";

    static {
        ApplicationVersionSignature.PACKAGE_NAME_TO_KEY = new ConcurrentHashMap();
    }

    private static PackageInfo getPackageInfo(Context context0) {
        try {
            return context0.getPackageManager().getPackageInfo("com.iloen.melon", 0);
        }
        catch(PackageManager.NameNotFoundException packageManager$NameNotFoundException0) {
            Log.e("AppVersionSignature", "Cannot resolve info forcom.iloen.melon", packageManager$NameNotFoundException0);
            return null;
        }
    }

    // 去混淆评级： 低(20)
    private static String getVersionCode(PackageInfo packageInfo0) {
        return packageInfo0 == null ? "f9339b67-4e0d-4511-aa49-67968b27a012" : String.valueOf(packageInfo0.versionCode);
    }

    public static Key obtain(Context context0) {
        ConcurrentMap concurrentMap0 = ApplicationVersionSignature.PACKAGE_NAME_TO_KEY;
        Key key0 = (Key)concurrentMap0.get("com.iloen.melon");
        if(key0 == null) {
            Key key1 = ApplicationVersionSignature.obtainVersionSignature(context0);
            Key key2 = (Key)concurrentMap0.putIfAbsent("com.iloen.melon", key1);
            return key2 == null ? key1 : key2;
        }
        return key0;
    }

    private static Key obtainVersionSignature(Context context0) {
        return new ObjectKey(ApplicationVersionSignature.getVersionCode(ApplicationVersionSignature.getPackageInfo(context0)));
    }

    public static void reset() {
        ApplicationVersionSignature.PACKAGE_NAME_TO_KEY.clear();
    }
}

