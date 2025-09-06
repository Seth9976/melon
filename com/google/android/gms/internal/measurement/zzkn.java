package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.content.SharedPreferences;
import android.os.StrictMode.ThreadPolicy;
import android.os.StrictMode;
import androidx.collection.f;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzkn implements zzju {
    private static final Map zza;
    private final SharedPreferences zzb;
    private SharedPreferences.OnSharedPreferenceChangeListener zzc;
    private final Object zzd;
    private volatile Map zze;
    private final List zzf;

    static {
        zzkn.zza = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
    }

    private zzkn(SharedPreferences sharedPreferences0, Runnable runnable0) {
        this.zzd = new Object();
        this.zzf = new ArrayList();
        this.zzb = sharedPreferences0;
    }

    public static zzkn zza(Context context0, String s, Runnable runnable0) {
        SharedPreferences sharedPreferences0;
        if(!s.startsWith("direct_boot:") && !zzjm.zzc(context0)) {
            return null;
        }
        synchronized(zzkn.class) {
            Map map0 = zzkn.zza;
            zzkn zzkn0 = (zzkn)map0.get(s);
            if(zzkn0 == null) {
                StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskReads();
                try {
                    sharedPreferences0 = s.startsWith("direct_boot:") ? zzcf.zza(context0.createDeviceProtectedStorageContext(), s.substring(12), 0, zzcb.zza) : zzcf.zza(context0, s, 0, zzcb.zza);
                }
                finally {
                    StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
                }
                zzkn0 = new zzkn(sharedPreferences0, runnable0);
                zzkm zzkm0 = (SharedPreferences sharedPreferences0, String s) -> {
                    synchronized(zzkn0.zzd) {
                        zzkn0.zze = null;
                        zzkl.zzc();
                    }
                    synchronized(zzkn0) {
                        for(Object object0: zzkn0.zzf) {
                            ((zzjr)object0).zza();
                        }
                    }
                };
                zzkn0.zzc = zzkm0;
                zzkn0.zzb.registerOnSharedPreferenceChangeListener(zzkm0);
                map0.put(s, zzkn0);
            }
            return zzkn0;
        }
    }

    public static void zzb() {
        synchronized(zzkn.class) {
            Map map0 = zzkn.zza;
            for(Object object0: map0.values()) {
                SharedPreferences.OnSharedPreferenceChangeListener sharedPreferences$OnSharedPreferenceChangeListener0 = ((zzkn)object0).zzc;
                sharedPreferences$OnSharedPreferenceChangeListener0.getClass();
                ((zzkn)object0).zzb.unregisterOnSharedPreferenceChangeListener(sharedPreferences$OnSharedPreferenceChangeListener0);
            }
            map0.clear();
        }
    }

    // 检测为 Lambda 实现
    public final void zzc(SharedPreferences sharedPreferences0, String s) [...]

    @Override  // com.google.android.gms.internal.measurement.zzju
    public final Object zze(String s) {
        Map map1;
        Map map0 = this.zze;
        if(map0 == null) {
            synchronized(this.zzd) {
                map0 = this.zze;
                if(map0 == null) {
                    StrictMode.ThreadPolicy strictMode$ThreadPolicy0 = StrictMode.allowThreadDiskReads();
                    try {
                        map1 = this.zzb.getAll();
                        this.zze = map1;
                    }
                    catch(Throwable throwable0) {
                        StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
                        throw throwable0;
                    }
                    StrictMode.setThreadPolicy(strictMode$ThreadPolicy0);
                    map0 = map1;
                }
            }
        }
        return map0 == null ? null : map0.get(s);
    }
}

