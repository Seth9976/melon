package com.google.android.gms.internal.measurement;

import I6.y0;
import I6.z0;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map.Entry;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import y5.a;

final class zzcc implements SharedPreferences.Editor {
    boolean zza;
    final Set zzb;
    final Map zzc;
    final zzcd zzd;

    public zzcc(zzcd zzcd0, byte[] arr_b) {
        Objects.requireNonNull(zzcd0);
        this.zzd = zzcd0;
        super();
        this.zza = false;
        this.zzb = new HashSet();
        this.zzc = new HashMap();
    }

    @Override  // android.content.SharedPreferences$Editor
    public final void apply() {
        this.commit();
    }

    @Override  // android.content.SharedPreferences$Editor
    public final SharedPreferences.Editor clear() {
        this.zza = true;
        return this;
    }

    @Override  // android.content.SharedPreferences$Editor
    public final boolean commit() {
        if(this.zza) {
            this.zzd.zza().clear();
        }
        zzcd zzcd0 = this.zzd;
        Set set0 = this.zzb;
        zzcd0.zza().keySet().removeAll(set0);
        Map map0 = this.zzc;
        for(Object object0: map0.entrySet()) {
            zzcd0.zza().put(((String)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
        }
        for(Object object1: zzcd0.zzb()) {
            SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener0 = (SharedPreferences.OnSharedPreferenceChangeListener)object1;
            Set set1 = map0.keySet();
            a.o(set0, "set1");
            a.o(set1, "set2");
            new z0(set0, set1, 0);
            y0 y00 = new y0(set0, set1);
            while(y00.hasNext()) {
                sharedPreferences$OnSharedPreferenceChangeListener0.onSharedPreferenceChanged(zzcd0, ((String)y00.next()));
            }
        }
        return this.zza || !set0.isEmpty() || !map0.isEmpty();
    }

    @Override  // android.content.SharedPreferences$Editor
    public final SharedPreferences.Editor putBoolean(String s, boolean z) {
        this.zza(s, Boolean.valueOf(z));
        return this;
    }

    @Override  // android.content.SharedPreferences$Editor
    public final SharedPreferences.Editor putFloat(String s, float f) {
        this.zza(s, f);
        return this;
    }

    @Override  // android.content.SharedPreferences$Editor
    public final SharedPreferences.Editor putInt(String s, int v) {
        this.zza(s, v);
        return this;
    }

    @Override  // android.content.SharedPreferences$Editor
    public final SharedPreferences.Editor putLong(String s, long v) {
        this.zza(s, v);
        return this;
    }

    @Override  // android.content.SharedPreferences$Editor
    public final SharedPreferences.Editor putString(String s, String s1) {
        this.zza(s, s1);
        return this;
    }

    @Override  // android.content.SharedPreferences$Editor
    public final SharedPreferences.Editor putStringSet(String s, Set set0) {
        this.zza(s, set0);
        return this;
    }

    @Override  // android.content.SharedPreferences$Editor
    public final SharedPreferences.Editor remove(String s) {
        this.zzb.add(s);
        return this;
    }

    private final void zza(String s, Object object0) {
        if(object0 != null) {
            this.zzc.put(s, object0);
            return;
        }
        this.remove(s);
    }
}

