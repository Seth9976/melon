package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.framework.CastContext;
import com.google.android.gms.cast.framework.CastSession;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzaa;
import com.google.android.gms.common.internal.Preconditions;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.Pure;

public final class zzl {
    private static final Logger zza;
    private final zzh zzb;
    private final zzaf zzc;
    private final zzn zzd;
    private final Runnable zze;
    private final Handler zzf;
    private final SharedPreferences zzg;
    private zzm zzh;
    private CastSession zzi;
    private boolean zzj;

    static {
        zzl.zza = new Logger("ApplicationAnalytics");
    }

    public zzl(SharedPreferences sharedPreferences0, zzh zzh0, zzaf zzaf0, Bundle bundle0, String s) {
        this.zzg = sharedPreferences0;
        this.zzb = zzh0;
        this.zzc = zzaf0;
        this.zzd = new zzn(bundle0, s);
        this.zzf = new zzet(Looper.getMainLooper());
        this.zze = () -> {
            zzm zzm0 = this.zzh;
            if(zzm0 != null) {
                zzqe zzqe0 = this.zzd.zza(zzm0);
                this.zzb.zzf(zzqe0, 0xDF);
            }
            this.zzu();
        };
    }

    public static SharedPreferences zza(zzl zzl0) {
        return zzl0.zzg;
    }

    public static zzh zzb(zzl zzl0) {
        return zzl0.zzb;
    }

    public static zzm zzc(zzl zzl0) {
        return zzl0.zzh;
    }

    public static zzn zzd(zzl zzl0) {
        return zzl0.zzd;
    }

    public static Logger zze() {
        return zzl.zza;
    }

    // 检测为 Lambda 实现
    public static void zzf(zzl zzl0) [...]

    public static void zzg(zzl zzl0, zzm zzm0) {
        zzl0.zzh = null;
    }

    public static void zzh(zzl zzl0, CastSession castSession0) {
        zzl0.zzi = castSession0;
    }

    public static void zzi(zzl zzl0, boolean z) {
        zzl0.zzj = z;
    }

    public static void zzj(zzl zzl0) {
        zzl0.zzr();
    }

    public static void zzk(zzl zzl0) {
        zzl0.zzs();
    }

    public static void zzl(zzl zzl0) {
        zzl0.zzt();
    }

    public static void zzm(zzl zzl0, int v) {
        zzl.zza.d("log session ended with error = %d", new Object[]{v});
        zzl0.zzs();
        zzqe zzqe0 = zzl0.zzd.zze(zzl0.zzh, v);
        zzl0.zzb.zzf(zzqe0, 0xE4);
        zzl0.zzr();
        if(!zzl0.zzj) {
            zzl0.zzh = null;
        }
    }

    public static void zzn(zzl zzl0, SharedPreferences sharedPreferences0, String s) {
        boolean z = false;
        if(zzl0.zzx(s)) {
            zzl.zza.d("Use the existing ApplicationAnalyticsSession if it is available and valid.", new Object[0]);
            Preconditions.checkNotNull(zzl0.zzh);
            return;
        }
        zzaf zzaf0 = zzl0.zzc;
        zzl0.zzh = zzm.zzb(sharedPreferences0, zzaf0);
        if(zzl0.zzx(s)) {
            zzl.zza.d("Use the restored ApplicationAnalyticsSession if it is valid.", new Object[0]);
            Preconditions.checkNotNull(zzl0.zzh);
            zzm.zza = zzl0.zzh.zzd + 1L;
            return;
        }
        zzl.zza.d("The restored ApplicationAnalyticsSession is not valid, create a new one.", new Object[0]);
        zzm zzm0 = zzm.zza(zzaf0);
        zzl0.zzh = zzm0;
        zzm zzm1 = (zzm)Preconditions.checkNotNull(zzm0);
        if(zzl0.zzi != null && zzl0.zzi.zzl()) {
            z = true;
        }
        zzm1.zzo = z;
        zzm zzm2 = (zzm)Preconditions.checkNotNull(zzl0.zzh);
        zzm2.zzb = zzl.zzq();
        ((zzm)Preconditions.checkNotNull(zzl0.zzh)).zzf = s;
    }

    public static void zzo(zzl zzl0) {
        zzl0.zzh.zzc(zzl0.zzg);
    }

    public static void zzp(zzl zzl0) {
        zzl0.zzu();
    }

    @Pure
    private static String zzq() {
        return ((CastContext)Preconditions.checkNotNull(CastContext.getSharedInstance())).getCastOptions().getReceiverApplicationId();
    }

    private final void zzr() {
        this.zzf.removeCallbacks(this.zze);
    }

    @EnsuresNonNull({"analyticsSession"})
    private final void zzs() {
        if(this.zzw()) {
            CastDevice castDevice0 = this.zzi == null ? null : this.zzi.getCastDevice();
            if(castDevice0 != null && !TextUtils.equals(this.zzh.zzc, castDevice0.zzd())) {
                this.zzv(castDevice0);
            }
            Preconditions.checkNotNull(this.zzh);
            return;
        }
        zzl.zza.w("The analyticsSession should not be null for logging. Create a dummy one.", new Object[0]);
        this.zzt();
    }

    @EnsuresNonNull({"analyticsSession"})
    private final void zzt() {
        int v = 0;
        zzl.zza.d("Create a new ApplicationAnalyticsSession based on CastSession", new Object[0]);
        zzm zzm0 = zzm.zza(this.zzc);
        this.zzh = zzm0;
        zzm zzm1 = (zzm)Preconditions.checkNotNull(zzm0);
        zzm1.zzo = this.zzi != null && this.zzi.zzl();
        zzm zzm2 = (zzm)Preconditions.checkNotNull(this.zzh);
        zzm2.zzb = zzl.zzq();
        CastDevice castDevice0 = this.zzi == null ? null : this.zzi.getCastDevice();
        if(castDevice0 != null) {
            this.zzv(castDevice0);
        }
        zzm zzm3 = (zzm)Preconditions.checkNotNull(this.zzh);
        CastSession castSession0 = this.zzi;
        if(castSession0 != null) {
            v = castSession0.zzm();
        }
        zzm3.zzp = v;
        Preconditions.checkNotNull(this.zzh);
    }

    private final void zzu() {
        ((Handler)Preconditions.checkNotNull(this.zzf)).postDelayed(((Runnable)Preconditions.checkNotNull(this.zze)), 300000L);
    }

    private final void zzv(CastDevice castDevice0) {
        zzm zzm0 = this.zzh;
        if(zzm0 != null) {
            zzm0.zzc = castDevice0.zzd();
            zzm0.zzg = castDevice0.zza();
            zzm0.zzh = castDevice0.getModelName();
            zzm0.zzn = castDevice0.zzb();
            zzaa zzaa0 = castDevice0.zzc();
            if(zzaa0 != null) {
                String s = zzaa0.zzc();
                if(s != null) {
                    zzm0.zzi = s;
                }
                String s1 = zzaa0.zzd();
                if(s1 != null) {
                    zzm0.zzj = s1;
                }
                String s2 = zzaa0.zza();
                if(s2 != null) {
                    zzm0.zzk = s2;
                }
                String s3 = zzaa0.zzb();
                if(s3 != null) {
                    zzm0.zzl = s3;
                }
                String s4 = zzaa0.zze();
                if(s4 != null) {
                    zzm0.zzm = s4;
                }
            }
        }
    }

    @EnsuresNonNullIf(expression = {"analyticsSession"}, result = true)
    private final boolean zzw() {
        if(this.zzh == null) {
            zzl.zza.d("The analytics session is null when matching with application ID.", new Object[0]);
            return false;
        }
        String s = zzl.zzq();
        if(s != null) {
            String s1 = this.zzh.zzb;
            if(s1 != null && TextUtils.equals(s1, s)) {
                Preconditions.checkNotNull(this.zzh);
                return true;
            }
        }
        zzl.zza.d("The analytics session doesn\'t match the application ID %s", new Object[]{s});
        return false;
    }

    private final boolean zzx(String s) {
        if(!this.zzw()) {
            return false;
        }
        Preconditions.checkNotNull(this.zzh);
        if(s != null) {
            String s1 = this.zzh.zzf;
            if(s1 != null && TextUtils.equals(s1, s)) {
                return true;
            }
        }
        zzl.zza.d("The analytics session doesn\'t match the receiver session ID %s.", new Object[]{s});
        return false;
    }
}

