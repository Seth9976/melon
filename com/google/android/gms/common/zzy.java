package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.internal.ShowFirstParty;
import javax.annotation.Nullable;

@ShowFirstParty
public class zzy {
    final boolean zza;
    @Nullable
    final String zzb;
    @Nullable
    final Throwable zzc;
    final int zzd;
    private static final zzy zze;

    static {
        zzy.zze = new zzy(true, 3, 1, null, null, -1L);
    }

    private zzy(boolean z, int v, int v1, @Nullable String s, @Nullable Throwable throwable0, long v2) {
        this.zza = z;
        this.zzd = v;
        this.zzb = s;
        this.zzc = throwable0;
    }

    public zzy(boolean z, int v, int v1, String s, Throwable throwable0, long v2, byte[] arr_b) {
        this(false, 1, 5, null, null, -1L);
    }

    @Nullable
    public String zza() {
        return this.zzb;
    }

    @Deprecated
    public static zzy zzb() {
        return zzy.zze;
    }

    public static zzy zzc(String s) {
        return new zzy(false, 1, 5, s, null, -1L);
    }

    public static zzy zzd(String s, Throwable throwable0) {
        return new zzy(false, 1, 5, s, throwable0, -1L);
    }

    public final void zze() {
        if(!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            Throwable throwable0 = this.zzc;
            if(throwable0 != null) {
                Log.d("GoogleCertificatesRslt", this.zza(), throwable0);
                return;
            }
            Log.d("GoogleCertificatesRslt", this.zza());
        }
    }

    public static zzy zzf(int v, long v1) {
        return new zzy(true, v, 1, null, null, v1);
    }

    public static zzy zzg(int v, int v1, String s, @Nullable Throwable throwable0) {
        return new zzy(false, v, v1, s, throwable0, -1L);
    }
}

