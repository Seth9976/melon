package com.google.android.gms.internal.auth;

import android.content.Context;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;
import androidx.collection.f;
import java.util.Iterator;
import java.util.Map;

public final class zzdd implements zzcl {
    private static final Map zza;
    private final SharedPreferences zzb;
    private final SharedPreferences.OnSharedPreferenceChangeListener zzc;

    static {
        zzdd.zza = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    public static zzdd zza(Context context0, String s, Runnable runnable0) {
        throw null;
    }

    @Override  // com.google.android.gms.internal.auth.zzcl
    public final Object zzb(String s) {
        throw null;
    }

    public static void zzc() {
        synchronized(zzdd.class) {
            Map map0 = zzdd.zza;
            Iterator iterator0 = map0.values().iterator();
            if(!iterator0.hasNext()) {
                map0.clear();
                return;
            }
            Object object0 = iterator0.next();
            zzdd zzdd0 = (zzdd)object0;
        }
        throw null;
    }
}

