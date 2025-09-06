package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import k8.Y;

public final class zzgm {
    protected static final AtomicReference zza;
    protected static final AtomicReference zzb;
    protected static final AtomicReference zzc;
    private final zzgl zzd;

    static {
        zzgm.zza = new AtomicReference();
        zzgm.zzb = new AtomicReference();
        zzgm.zzc = new AtomicReference();
    }

    public zzgm(zzgl zzgl0) {
        this.zzd = zzgl0;
    }

    public final String zza(String s) {
        if(s == null) {
            return null;
        }
        return this.zzd.zza() ? zzgm.zzg(s, zzjl.zzc, zzjl.zza, zzgm.zza) : s;
    }

    public final String zzb(String s) {
        if(s == null) {
            return null;
        }
        return this.zzd.zza() ? zzgm.zzg(s, zzjm.zzb, zzjm.zza, zzgm.zzb) : s;
    }

    public final String zzc(String s) {
        if(s == null) {
            return null;
        }
        if(!this.zzd.zza()) {
            return s;
        }
        return s.startsWith("_exp_") ? "experiment_id(" + s + ")" : zzgm.zzg(s, zzjn.zzb, zzjn.zza, zzgm.zzc);
    }

    public final String zzd(zzbg zzbg0) {
        String s;
        zzgl zzgl0 = this.zzd;
        if(!zzgl0.zza()) {
            return zzbg0.toString();
        }
        StringBuilder stringBuilder0 = new StringBuilder("origin=");
        stringBuilder0.append(zzbg0.zzc);
        stringBuilder0.append(",name=");
        stringBuilder0.append(this.zza(zzbg0.zza));
        stringBuilder0.append(",params=");
        zzbe zzbe0 = zzbg0.zzb;
        if(zzbe0 == null) {
            s = null;
        }
        else {
            s = zzgl0.zza() ? this.zze(zzbe0.zzf()) : zzbe0.toString();
        }
        stringBuilder0.append(s);
        return stringBuilder0.toString();
    }

    public final String zze(Bundle bundle0) {
        String s;
        if(bundle0 == null) {
            return null;
        }
        if(!this.zzd.zza()) {
            return bundle0.toString();
        }
        StringBuilder stringBuilder0 = Y.p("Bundle[{");
        for(Object object0: bundle0.keySet()) {
            if(stringBuilder0.length() != 8) {
                stringBuilder0.append(", ");
            }
            stringBuilder0.append(this.zzb(((String)object0)));
            stringBuilder0.append("=");
            Object object1 = bundle0.get(((String)object0));
            if(object1 instanceof Bundle) {
                s = this.zzf(new Object[]{object1});
            }
            else if(object1 instanceof Object[]) {
                s = this.zzf(((Object[])object1));
            }
            else {
                s = object1 instanceof ArrayList ? this.zzf(((ArrayList)object1).toArray()) : String.valueOf(object1);
            }
            stringBuilder0.append(s);
        }
        stringBuilder0.append("}]");
        return stringBuilder0.toString();
    }

    public final String zzf(Object[] arr_object) {
        if(arr_object == null) {
            return "[]";
        }
        StringBuilder stringBuilder0 = Y.p("[");
        for(int v = 0; v < arr_object.length; ++v) {
            Object object0 = arr_object[v];
            String s = object0 instanceof Bundle ? this.zze(((Bundle)object0)) : String.valueOf(object0);
            if(s != null) {
                if(stringBuilder0.length() != 1) {
                    stringBuilder0.append(", ");
                }
                stringBuilder0.append(s);
            }
        }
        stringBuilder0.append("]");
        return stringBuilder0.toString();
    }

    private static final String zzg(String s, String[] arr_s, String[] arr_s1, AtomicReference atomicReference0) {
        Preconditions.checkNotNull(arr_s);
        Preconditions.checkNotNull(arr_s1);
        Preconditions.checkNotNull(atomicReference0);
        Preconditions.checkArgument(arr_s.length == arr_s1.length);
        for(int v = 0; v < arr_s.length; ++v) {
            if(Objects.equals(s, arr_s[v])) {
                synchronized(atomicReference0) {
                    String[] arr_s2 = (String[])atomicReference0.get();
                    if(arr_s2 == null) {
                        arr_s2 = new String[arr_s1.length];
                        atomicReference0.set(arr_s2);
                    }
                    String s1 = arr_s2[v];
                    if(s1 == null) {
                        s1 = arr_s1[v] + "(" + arr_s[v] + ")";
                        arr_s2[v] = s1;
                    }
                    return s1;
                }
            }
        }
        return s;
    }
}

