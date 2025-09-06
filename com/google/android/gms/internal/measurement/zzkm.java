package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;

final class zzkm implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzkn zza;

    public zzkm(zzkn zzkn0) {
        this.zza = zzkn0;
    }

    @Override  // android.content.SharedPreferences$OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences0, String s) {
        this.zza.zzc(sharedPreferences0, s);
    }
}

