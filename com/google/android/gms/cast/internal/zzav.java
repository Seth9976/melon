package com.google.android.gms.cast.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.DefaultClock;
import com.google.android.gms.internal.cast.zzet;

public final class zzav {
    public static final Object zza;
    protected final Logger zzb;
    long zzc;
    long zzd;
    zzat zze;
    Runnable zzf;
    private final long zzg;
    private final String zzh;
    private final Handler zzi;
    private final Clock zzj;

    static {
        zzav.zza = new Object();
    }

    public zzav(long v, String s) {
        this.zzg = v;
        this.zzh = s;
        this.zzj = DefaultClock.getInstance();
        this.zzc = -1L;
        this.zzd = 0L;
        this.zzi = new zzet(Looper.getMainLooper());
        this.zzb = new Logger("RequestTracker", s);
    }

    // 检测为 Lambda 实现
    public static void zza(zzav zzav0) [...]

    public final void zzb(long v, zzat zzat0) {
        long v1 = this.zzj.currentTimeMillis();
        Object object0 = zzav.zza;
        synchronized(object0) {
            zzat zzat1 = this.zze;
            long v2 = this.zzc;
            long v3 = this.zzd;
            this.zzc = v;
            this.zze = zzat0;
            this.zzd = v1;
            if(zzat1 != null) {
                zzat1.zzb(this.zzh, v2, v3, v1);
            }
            synchronized(object0) {
                Runnable runnable0 = this.zzf;
                if(runnable0 != null) {
                    this.zzi.removeCallbacks(runnable0);
                }
                zzau zzau0 = () -> synchronized(zzav.zza) {
                    if(!this.zzf()) {
                        return;
                    }
                    this.zzh(15, null);
                };
                this.zzf = zzau0;
                this.zzi.postDelayed(zzau0, this.zzg);
            }
        }
    }

    public final boolean zzc(int v) {
        return this.zzh(2002, null);
    }

    public final boolean zzd(long v, int v1, Object object0) {
        synchronized(zzav.zza) {
            if(this.zze(v)) {
                this.zzg(v1, object0, "request " + v + " completed");
                return true;
            }
            return false;
        }
    }

    public final boolean zze(long v) {
        synchronized(zzav.zza) {
        }
        return Long.compare(this.zzc, -1L) != 0 && this.zzc == v;
    }

    public final boolean zzf() {
        synchronized(zzav.zza) {
        }
        return this.zzc != -1L;
    }

    private final void zzg(int v, Object object0, String s) {
        this.zzb.d(s, new Object[0]);
        Object object1 = zzav.zza;
        synchronized(object1) {
            if(this.zze != null) {
                long v1 = this.zzj.currentTimeMillis();
                ((zzat)Preconditions.checkNotNull(this.zze)).zza(this.zzh, this.zzc, v, object0, this.zzd, v1);
            }
            this.zzc = -1L;
            this.zze = null;
            synchronized(object1) {
                Runnable runnable0 = this.zzf;
                if(runnable0 != null) {
                    this.zzi.removeCallbacks(runnable0);
                    this.zzf = null;
                }
            }
        }
    }

    private final boolean zzh(int v, Object object0) {
        synchronized(zzav.zza) {
            if(this.zzf()) {
                this.zzg(v, null, "clearing request " + this.zzc);
                return true;
            }
            return false;
        }
    }
}

