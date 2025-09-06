package com.google.android.gms.internal.measurement;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class zzcd implements SharedPreferences {
    private final Map zza;
    private final Set zzb;

    public zzcd() {
        this.zza = new HashMap();
        this.zzb = new HashSet();
    }

    @Override  // android.content.SharedPreferences
    public final boolean contains(String s) {
        return this.zza.containsKey(s);
    }

    @Override  // android.content.SharedPreferences
    public final SharedPreferences.Editor edit() {
        return new zzcc(this, null);
    }

    @Override  // android.content.SharedPreferences
    public final Map getAll() {
        return this.zza;
    }

    @Override  // android.content.SharedPreferences
    public final boolean getBoolean(String s, boolean z) {
        return ((Boolean)this.zzc(s, Boolean.valueOf(z))).booleanValue();
    }

    @Override  // android.content.SharedPreferences
    public final float getFloat(String s, float f) {
        return (float)(((Float)this.zzc(s, f)));
    }

    @Override  // android.content.SharedPreferences
    public final int getInt(String s, int v) {
        return (int)(((Integer)this.zzc(s, v)));
    }

    @Override  // android.content.SharedPreferences
    public final long getLong(String s, long v) {
        return (long)(((Long)this.zzc(s, v)));
    }

    @Override  // android.content.SharedPreferences
    public final String getString(String s, String s1) {
        return (String)this.zzc(s, s1);
    }

    @Override  // android.content.SharedPreferences
    public final Set getStringSet(String s, Set set0) {
        return (Set)this.zzc(s, set0);
    }

    @Override  // android.content.SharedPreferences
    public final void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener0) {
        this.zzb.add(sharedPreferences$OnSharedPreferenceChangeListener0);
    }

    @Override  // android.content.SharedPreferences
    public final void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener0) {
        this.zzb.remove(sharedPreferences$OnSharedPreferenceChangeListener0);
    }

    public final Map zza() {
        return this.zza;
    }

    public final Set zzb() {
        return this.zzb;
    }

    private final Object zzc(String s, Object object0) {
        Object object1 = this.zza.get(s);
        return object1 == null ? object0 : object1;
    }
}

