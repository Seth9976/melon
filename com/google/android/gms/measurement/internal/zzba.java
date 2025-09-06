package com.google.android.gms.measurement.internal;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k8.Y;

public final class zzba extends zzje {
    private long zza;
    private String zzb;

    public zzba(zzib zzib0) {
        super(zzib0);
    }

    @Override  // com.google.android.gms.measurement.internal.zzje
    public final boolean zza() {
        Calendar calendar0 = Calendar.getInstance();
        TimeUnit timeUnit0 = TimeUnit.MINUTES;
        int v = calendar0.get(15);
        this.zza = timeUnit0.convert(((long)(calendar0.get(16) + v)), TimeUnit.MILLISECONDS);
        Locale locale0 = Locale.getDefault();
        String s = locale0.getLanguage();
        Locale locale1 = Locale.ENGLISH;
        String s1 = s.toLowerCase(locale1);
        String s2 = locale0.getCountry().toLowerCase(locale1);
        this.zzb = Y.l(new StringBuilder(String.valueOf(s1).length() + 1 + String.valueOf(s2).length()), s1, "-", s2);
        return false;
    }

    public final long zzb() {
        this.zzw();
        return this.zza;
    }

    public final String zzc() {
        this.zzw();
        return this.zzb;
    }
}

