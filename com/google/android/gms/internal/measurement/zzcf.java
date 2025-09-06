package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.content.SharedPreferences;

public final class zzcf {
    private static final ThreadLocal zza;

    static {
        zzcf.zza = new zzce();
    }

    public static SharedPreferences zza(Context context0, String s, int v, zzca zzca0) {
        SharedPreferences sharedPreferences1;
        SharedPreferences sharedPreferences0 = s.equals("") ? new zzcd() : null;
        if(sharedPreferences0 != null) {
            return sharedPreferences0;
        }
        ThreadLocal threadLocal0 = zzcf.zza;
        if(!((Boolean)threadLocal0.get()).booleanValue()) {
            throw new IllegalArgumentException();
        }
        threadLocal0.set(Boolean.FALSE);
        try {
            sharedPreferences1 = context0.getSharedPreferences(s, 0);
        }
        catch(Throwable throwable0) {
            zzcf.zza.set(Boolean.TRUE);
            throw throwable0;
        }
        threadLocal0.set(Boolean.TRUE);
        return sharedPreferences1;
    }
}

