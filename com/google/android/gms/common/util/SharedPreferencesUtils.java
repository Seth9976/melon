package com.google.android.gms.common.util;

import android.content.Context;
import android.content.SharedPreferences.Editor;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public class SharedPreferencesUtils {
    @KeepForSdk
    @Deprecated
    public static void publishWorldReadableSharedPreferences(Context context0, SharedPreferences.Editor sharedPreferences$Editor0, String s) {
        throw new IllegalStateException("world-readable shared preferences should only be used by apk");
    }
}

