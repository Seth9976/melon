package com.google.android.gms.common.internal;

import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public final class GmsLogger {
    private final String zza;
    private final String zzb;

    @KeepForSdk
    public GmsLogger(String s) {
        this(s, null);
    }

    @KeepForSdk
    public GmsLogger(String s, String s1) {
        Preconditions.checkNotNull(s, "log tag cannot be null");
        Preconditions.checkArgument(s.length() <= 23, "tag \"%s\" is longer than the %d character maximum", new Object[]{s, 23});
        this.zza = s;
        if(s1 == null || s1.length() <= 0) {
            s1 = null;
        }
        this.zzb = s1;
    }

    @KeepForSdk
    public boolean canLog(int v) {
        return Log.isLoggable(this.zza, v);
    }

    @KeepForSdk
    public boolean canLogPii() {
        return false;
    }

    @KeepForSdk
    public void d(String s, String s1) {
        if(this.canLog(3)) {
            Log.d(s, this.zza(s1));
        }
    }

    @KeepForSdk
    public void d(String s, String s1, Throwable throwable0) {
        if(this.canLog(3)) {
            Log.d(s, this.zza(s1), throwable0);
        }
    }

    @KeepForSdk
    public void e(String s, String s1) {
        if(this.canLog(6)) {
            Log.e(s, this.zza(s1));
        }
    }

    @KeepForSdk
    public void e(String s, String s1, Throwable throwable0) {
        if(this.canLog(6)) {
            Log.e(s, this.zza(s1), throwable0);
        }
    }

    @KeepForSdk
    public void efmt(String s, String s1, Object[] arr_object) {
        if(this.canLog(6)) {
            Log.e(s, this.zzb(s1, arr_object));
        }
    }

    @KeepForSdk
    public void i(String s, String s1) {
        if(this.canLog(4)) {
            Log.i(s, this.zza(s1));
        }
    }

    @KeepForSdk
    public void i(String s, String s1, Throwable throwable0) {
        if(this.canLog(4)) {
            Log.i(s, this.zza(s1), throwable0);
        }
    }

    @KeepForSdk
    public void pii(String s, String s1) {
    }

    @KeepForSdk
    public void pii(String s, String s1, Throwable throwable0) {
    }

    @KeepForSdk
    public void v(String s, String s1) {
        if(this.canLog(2)) {
            Log.v(s, this.zza(s1));
        }
    }

    @KeepForSdk
    public void v(String s, String s1, Throwable throwable0) {
        if(this.canLog(2)) {
            Log.v(s, this.zza(s1), throwable0);
        }
    }

    @KeepForSdk
    public void w(String s, String s1) {
        if(this.canLog(5)) {
            Log.w(s, this.zza(s1));
        }
    }

    @KeepForSdk
    public void w(String s, String s1, Throwable throwable0) {
        if(this.canLog(5)) {
            Log.w(s, this.zza(s1), throwable0);
        }
    }

    @KeepForSdk
    public void wfmt(String s, String s1, Object[] arr_object) {
        if(this.canLog(5)) {
            String s2 = this.zzb(s1, arr_object);
            Log.w(this.zza, s2);
        }
    }

    @KeepForSdk
    public void wtf(String s, String s1, Throwable throwable0) {
        if(this.canLog(7)) {
            Log.e(s, this.zza(s1), throwable0);
            Log.wtf(s, this.zza(s1), throwable0);
        }
    }

    private final String zza(String s) {
        return this.zzb == null ? s : this.zzb + s;
    }

    private final String zzb(String s, Object[] arr_object) {
        String s1 = String.format(s, arr_object);
        return this.zzb == null ? s1 : this.zzb + s1;
    }
}

