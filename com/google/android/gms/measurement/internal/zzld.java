package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;

final class zzld implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final zzli zza;

    public zzld(zzli zzli0) {
        this.zza = zzli0;
    }

    @Override  // android.content.SharedPreferences$OnSharedPreferenceChangeListener
    public final void onSharedPreferenceChanged(SharedPreferences sharedPreferences0, String s) {
        this.zza.zzaf(sharedPreferences0, s);
    }
}

