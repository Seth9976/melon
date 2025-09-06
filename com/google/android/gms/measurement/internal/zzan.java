package com.google.android.gms.measurement.internal;

import java.util.EnumMap;

final class zzan {
    private final EnumMap zza;

    public zzan() {
        this.zza = new EnumMap(zzjj.class);
    }

    private zzan(EnumMap enumMap0) {
        EnumMap enumMap1 = new EnumMap(zzjj.class);
        this.zza = enumMap1;
        enumMap1.putAll(enumMap0);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("1");
        zzjj[] arr_zzjj = zzjj.values();
        for(int v = 0; v < arr_zzjj.length; ++v) {
            zzam zzam0 = (zzam)this.zza.get(arr_zzjj[v]);
            if(zzam0 == null) {
                zzam0 = zzam.zza;
            }
            stringBuilder0.append(zzam0.zzb());
        }
        return stringBuilder0.toString();
    }

    public final zzam zza(zzjj zzjj0) {
        zzam zzam0 = (zzam)this.zza.get(zzjj0);
        return zzam0 == null ? zzam.zza : zzam0;
    }

    public final void zzb(zzjj zzjj0, int v) {
        zzam zzam0 = zzam.zza;
        switch(v) {
            case -30: {
                zzam0 = zzam.zzh;
                break;
            }
            case -10: {
                zzam0 = zzam.zzd;
                break;
            }
            case -20: 
            case 0: {
                zzam0 = zzam.zzf;
                break;
            }
            default: {
                if(v == 30) {
                    zzam0 = zzam.zze;
                }
            }
        }
        this.zza.put(zzjj0, zzam0);
    }

    public final void zzc(zzjj zzjj0, zzam zzam0) {
        this.zza.put(zzjj0, zzam0);
    }

    public static zzan zzd(String s) {
        int v = 0;
        EnumMap enumMap0 = new EnumMap(zzjj.class);
        if(s.length() >= zzjj.values().length && s.charAt(0) == 49) {
            zzjj[] arr_zzjj = zzjj.values();
            for(int v1 = 1; v < arr_zzjj.length; ++v1) {
                enumMap0.put(arr_zzjj[v], zzam.zza(s.charAt(v1)));
                ++v;
            }
            return new zzan(enumMap0);
        }
        return new zzan();
    }
}

