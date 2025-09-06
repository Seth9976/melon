package com.google.android.gms.measurement.internal;

import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.ActivityManager;
import android.os.Bundle;
import android.text.TextUtils;
import java.util.Objects;
import k8.Y;

final class zzoa {
    final zzob zza;

    public zzoa(zzob zzob0) {
        Objects.requireNonNull(zzob0);
        this.zza = zzob0;
        super();
    }

    public final void zza() {
        this.zza.zzg();
        zzib zzib0 = this.zza.zzu;
        if(zzib0.zzd().zzp(zzib0.zzaZ().currentTimeMillis())) {
            zzib0.zzd().zzg.zzb(true);
            ActivityManager.RunningAppProcessInfo activityManager$RunningAppProcessInfo0 = new ActivityManager.RunningAppProcessInfo();
            ActivityManager.getMyMemoryState(activityManager$RunningAppProcessInfo0);
            if(activityManager$RunningAppProcessInfo0.importance == 100) {
                zzib0.zzaV().zzk().zza("Detected application was in foreground");
                this.zzc(zzib0.zzaZ().currentTimeMillis(), false);
            }
        }
    }

    public final void zzb(long v, boolean z) {
        zzob zzob0 = this.zza;
        zzob0.zzg();
        zzob0.zzj();
        zzib zzib0 = zzob0.zzu;
        if(zzib0.zzd().zzp(v)) {
            zzib0.zzd().zzg.zzb(true);
            zzob0.zzu.zzv().zzi();
        }
        zzib0.zzd().zzk.zzb(v);
        if(zzib0.zzd().zzg.zza()) {
            this.zzc(v, z);
        }
    }

    public final void zzc(long v, boolean z) {
        zzob zzob0 = this.zza;
        zzob0.zzg();
        if(zzob0.zzu.zzB()) {
            zzob0.zzu.zzd().zzk.zzb(v);
            long v1 = zzob0.zzu.zzaZ().elapsedRealtime();
            zzob0.zzu.zzaV().zzk().zzb("Session started, time", v1);
            zzib zzib0 = zzob0.zzu;
            zzib0.zzj().zzN("auto", "_sid", ((long)(v / 1000L)), v);
            zzob0.zzu.zzd().zzl.zzb(v / 1000L);
            zzob0.zzu.zzd().zzg.zzb(false);
            Bundle bundle0 = new Bundle();
            bundle0.putLong("_sid", v / 1000L);
            zzib0.zzj().zzG("auto", "_s", v, bundle0);
            String s = zzob0.zzu.zzd().zzq.zza();
            if(!TextUtils.isEmpty(s)) {
                Bundle bundle1 = Y.b("_ffr", s);
                zzib0.zzj().zzG("auto", "_ssr", v, bundle1);
            }
        }
    }
}

