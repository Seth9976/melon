package com.google.android.gms.cast.internal;

import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Locale;

@KeepForSdk
public class Logger {
    protected final String zza;
    private final boolean zzb;
    private final String zzc;
    private boolean zzd;

    @KeepForSdk
    public Logger(String s) {
        this(s, null);
    }

    public Logger(String s, String s1) {
        Preconditions.checkNotEmpty(s, "The log tag cannot be null or empty.");
        this.zza = s;
        this.zzc = s1;
        this.zzb = s.length() <= 23;
        this.zzd = false;
    }

    @KeepForSdk
    public void d(String s, Object[] arr_object) {
        if(!this.zzc()) {
            return;
        }
        String s1 = this.zza(s, arr_object);
        Log.d(this.zza, s1);
    }

    @KeepForSdk
    public void d(Throwable throwable0, String s, Object[] arr_object) {
        if(!this.zzc()) {
            return;
        }
        String s1 = this.zza(s, arr_object);
        Log.d(this.zza, s1, throwable0);
    }

    @KeepForSdk
    public void e(String s, Object[] arr_object) {
        String s1 = this.zza(s, arr_object);
        Log.e(this.zza, s1);
    }

    @KeepForSdk
    public void e(Throwable throwable0, String s, Object[] arr_object) {
        String s1 = this.zza(s, arr_object);
        Log.e(this.zza, s1, throwable0);
    }

    @KeepForSdk
    public void i(String s, Object[] arr_object) {
        String s1 = this.zza(s, arr_object);
        Log.i(this.zza, s1);
    }

    @KeepForSdk
    public void i(Throwable throwable0, String s, Object[] arr_object) {
        String s1 = this.zza(s, arr_object);
        Log.i(this.zza, s1, throwable0);
    }

    @KeepForSdk
    public void v(String s, Object[] arr_object) {
        if(Logger.zzd() && this.zzb) {
            String s1 = this.zza;
            if(Log.isLoggable(s1, 2)) {
                Log.v(s1, this.zza(s, arr_object));
            }
        }
    }

    @KeepForSdk
    public void w(String s, Object[] arr_object) {
        String s1 = this.zza(s, arr_object);
        Log.w(this.zza, s1);
    }

    @KeepForSdk
    public void w(Throwable throwable0, String s, Object[] arr_object) {
        String s1 = this.zza(s, arr_object);
        Log.w(this.zza, s1, throwable0);
    }

    public final String zza(String s, Object[] arr_object) {
        if(arr_object.length != 0) {
            s = String.format(Locale.ROOT, s, arr_object);
        }
        String s1 = TextUtils.isEmpty(this.zzc) ? "" : "[" + this.zzc + "] ";
        return TextUtils.isEmpty(s1) ? s : s1 + s;
    }

    public final void zzb(boolean z) {
        this.zzd = true;
    }

    // 去混淆评级： 低(40)
    public final boolean zzc() {
        return Logger.zzd() && (this.zzd || this.zzb && Log.isLoggable(this.zza, 3));
    }

    private static final boolean zzd() {
        return !Build.TYPE.equals("user");
    }
}

