package com.google.android.gms.internal.measurement;

import V4.u;
import android.content.Context;
import android.database.ContentObserver;
import android.util.Log;

final class zzjx implements zzju {
    private static zzjx zza;
    private final Context zzb;
    private final ContentObserver zzc;
    private boolean zzd;

    private zzjx() {
        this.zzd = false;
        this.zzb = null;
        this.zzc = null;
    }

    private zzjx(Context context0) {
        this.zzd = false;
        this.zzb = context0;
        this.zzc = new zzjv(this, null);
    }

    public static zzjx zza(Context context0) {
        synchronized(zzjx.class) {
            if(zzjx.zza == null) {
                zzjx.zza = u.l(context0, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzjx(context0) : new zzjx();
            }
            if(zzjx.zza != null && zzjx.zza.zzc != null && !zzjx.zza.zzd) {
                try {
                    context0.getContentResolver().registerContentObserver(zzjg.zza, true, zzjx.zza.zzc);
                    zzjx zzjx0 = zzjx.zza;
                    zzjx0.getClass();
                    zzjx0.zzd = true;
                }
                catch(SecurityException securityException0) {
                    Log.e("GservicesLoader", "Unable to register Gservices content observer", securityException0);
                }
            }
            zzjx zzjx1 = zzjx.zza;
            zzjx1.getClass();
            return zzjx1;
        }
    }

    public final String zzb(String s) {
        if(this.zzb != null && !zzjm.zzb(this.zzb)) {
            try {
                return (String)zzju.zzg(() -> {
                    this.zzb.getClass();
                    return zzjf.zza(this.zzb.getContentResolver(), s, null);
                });
            }
            catch(IllegalStateException | SecurityException | NullPointerException illegalStateException0) {
                Log.e("GservicesLoader", "Unable to read GServices for: " + s, illegalStateException0);
            }
        }
        return null;
    }

    public static void zzc() {
        synchronized(zzjx.class) {
            zzjx zzjx0 = zzjx.zza;
            if(zzjx0 != null) {
                Context context0 = zzjx0.zzb;
                if(context0 != null && zzjx0.zzc != null && zzjx0.zzd) {
                    context0.getContentResolver().unregisterContentObserver(zzjx.zza.zzc);
                }
            }
            zzjx.zza = null;
        }
    }

    // 检测为 Lambda 实现
    public final String zzd(String s) [...]

    @Override  // com.google.android.gms.internal.measurement.zzju
    public final Object zze(String s) {
        return this.zzb(s);
    }
}

