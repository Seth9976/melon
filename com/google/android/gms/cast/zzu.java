package com.google.android.gms.cast;

import com.google.android.gms.cast.internal.CastUtils;
import java.util.Collection;
import java.util.Locale;

final class zzu {
    private final String zza;
    private final String zzb;
    private final Collection zzc;

    public zzu(String s, String s1, Collection collection0, boolean z, boolean z1, zzv zzv0) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = collection0;
    }

    public static String zza(zzu zzu0) {
        StringBuilder stringBuilder0 = new StringBuilder(zzu0.zza);
        String s = zzu0.zzb;
        if(s != null) {
            String s1 = s.toUpperCase(Locale.ROOT);
            if(!s1.matches("[A-F0-9]+")) {
                throw new IllegalArgumentException("Invalid application ID: " + s);
            }
            stringBuilder0.append("/");
            stringBuilder0.append(s1);
        }
        Collection collection0 = zzu0.zzc;
        int v = 0;
        if(collection0 != null) {
            if(collection0.isEmpty()) {
                throw new IllegalArgumentException("Must specify at least one namespace");
            }
            if(s == null) {
                stringBuilder0.append("/");
            }
            stringBuilder0.append("/");
            boolean z = true;
            for(Object object0: collection0) {
                CastUtils.throwIfInvalidNamespace(((String)object0));
                if(!z) {
                    stringBuilder0.append(",");
                }
                stringBuilder0.append(CastUtils.zzc(((String)object0)));
                z = false;
            }
            v = s == null ? 0 : 1;
        }
        else if(s != null) {
            v = 1;
        }
        if(1 != v && collection0 == null) {
            stringBuilder0.append("/");
        }
        if(collection0 == null) {
            stringBuilder0.append("/");
        }
        stringBuilder0.append("//ALLOW_IPV6");
        return stringBuilder0.toString();
    }
}

