package com.google.android.gms.cast.framework;

import android.content.Context;
import android.preference.PreferenceManager;

public final class zzbf {
    public static void zza(Context context0) {
        PreferenceManager.getDefaultSharedPreferences(context0).edit().putBoolean("googlecast-introOverlayShown", true).apply();
    }
}

