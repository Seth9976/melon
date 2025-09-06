package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Map.Entry;

public final class zzjk {
    public static final zzjk zza;
    private final EnumMap zzb;
    private final int zzc;

    static {
        zzjk.zza = new zzjk(null, null, 100);
    }

    public zzjk(Boolean boolean0, Boolean boolean1, int v) {
        EnumMap enumMap0 = new EnumMap(zzjj.class);
        this.zzb = enumMap0;
        zzjh zzjh0 = zzjk.zzh(null);
        enumMap0.put(zzjj.zza, zzjh0);
        zzjh zzjh1 = zzjk.zzh(null);
        enumMap0.put(zzjj.zzb, zzjh1);
        this.zzc = v;
    }

    private zzjk(EnumMap enumMap0, int v) {
        EnumMap enumMap1 = new EnumMap(zzjj.class);
        this.zzb = enumMap1;
        enumMap1.putAll(enumMap0);
        this.zzc = v;
    }

    @Override
    public final boolean equals(Object object0) {
        if(!(object0 instanceof zzjk)) {
            return false;
        }
        zzjj[] arr_zzjj = zzji.zza.zzb();
        for(int v = 0; v < arr_zzjj.length; ++v) {
            zzjj zzjj0 = arr_zzjj[v];
            if(this.zzb.get(zzjj0) != ((zzjk)object0).zzb.get(zzjj0)) {
                return false;
            }
        }
        return this.zzc == ((zzjk)object0).zzc;
    }

    @Override
    public final int hashCode() {
        int v = this.zzc * 17;
        for(Object object0: this.zzb.values()) {
            v = v * 0x1F + ((zzjh)object0).hashCode();
        }
        return v;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("source=");
        stringBuilder0.append(zzjk.zzd(this.zzc));
        zzjj[] arr_zzjj = zzji.zza.zzb();
        for(int v = 0; v < arr_zzjj.length; ++v) {
            zzjj zzjj0 = arr_zzjj[v];
            stringBuilder0.append(",");
            stringBuilder0.append(zzjj0.zze);
            stringBuilder0.append("=");
            zzjh zzjh0 = (zzjh)this.zzb.get(zzjj0);
            if(zzjh0 == null) {
                zzjh0 = zzjh.zza;
            }
            stringBuilder0.append(zzjh0);
        }
        return stringBuilder0.toString();
    }

    public static zzjk zza(zzjh zzjh0, zzjh zzjh1, int v) {
        EnumMap enumMap0 = new EnumMap(zzjj.class);
        enumMap0.put(zzjj.zza, zzjh0);
        enumMap0.put(zzjj.zzb, zzjh1);
        return new zzjk(enumMap0, -10);
    }

    public final int zzb() {
        return this.zzc;
    }

    public final boolean zzc() {
        for(Object object0: this.zzb.values()) {
            if(((zzjh)object0) != zzjh.zza) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public static String zzd(int v) {
        switch(v) {
            case -30: {
                return "TCF";
            }
            case -20: {
                return "API";
            }
            case -10: {
                return "MANIFEST";
            }
            case 0: {
                return "1P_API";
            }
            case 30: {
                return "1P_INIT";
            }
            case 90: {
                return "REMOTE_CONFIG";
            }
            case 100: {
                return "UNKNOWN";
            }
            default: {
                return "OTHER";
            }
        }
    }

    public static zzjk zze(Bundle bundle0, int v) {
        if(bundle0 == null) {
            return new zzjk(null, null, v);
        }
        EnumMap enumMap0 = new EnumMap(zzjj.class);
        zzjj[] arr_zzjj = zzji.zza.zzb();
        for(int v1 = 0; v1 < arr_zzjj.length; ++v1) {
            zzjj zzjj0 = arr_zzjj[v1];
            enumMap0.put(zzjj0, zzjk.zzg(bundle0.getString(zzjj0.zze)));
        }
        return new zzjk(enumMap0, v);
    }

    public static zzjk zzf(String s, int v) {
        EnumMap enumMap0 = new EnumMap(zzjj.class);
        zzjj[] arr_zzjj = zzji.zza.zza();
        for(int v1 = 0; v1 < arr_zzjj.length; ++v1) {
            String s1 = s == null ? "" : s;
            zzjj zzjj0 = arr_zzjj[v1];
            if(v1 + 2 < s1.length()) {
                enumMap0.put(zzjj0, zzjk.zzj(s1.charAt(v1 + 2)));
            }
            else {
                enumMap0.put(zzjj0, zzjh.zza);
            }
        }
        return new zzjk(enumMap0, v);
    }

    public static zzjh zzg(String s) {
        if(s == null) {
            return zzjh.zza;
        }
        if(s.equals("granted")) {
            return zzjh.zzd;
        }
        return s.equals("denied") ? zzjh.zzc : zzjh.zza;
    }

    public static zzjh zzh(Boolean boolean0) {
        if(boolean0 == null) {
            return zzjh.zza;
        }
        return boolean0.booleanValue() ? zzjh.zzd : zzjh.zzc;
    }

    public static String zzi(zzjh zzjh0) {
        switch(zzjh0.ordinal()) {
            case 2: {
                return "denied";
            }
            case 3: {
                return "granted";
            }
            default: {
                return null;
            }
        }
    }

    public static zzjh zzj(char c) {
        switch(c) {
            case 43: {
                return zzjh.zzb;
            }
            case 0x30: {
                return zzjh.zzc;
            }
            case 49: {
                return zzjh.zzd;
            }
            default: {
                return zzjh.zza;
            }
        }
    }

    public final String zzk() {
        StringBuilder stringBuilder0 = new StringBuilder("G1");
        zzjj[] arr_zzjj = zzji.zza.zza();
        for(int v = 0; v < arr_zzjj.length; ++v) {
            zzjh zzjh0 = (zzjh)this.zzb.get(arr_zzjj[v]);
            int v1 = 45;
            if(zzjh0 != null) {
                switch(zzjh0.ordinal()) {
                    case 2: {
                        v1 = 0x30;
                        break;
                    }
                    case 1: 
                    case 3: {
                        v1 = 49;
                    }
                }
            }
            stringBuilder0.append(((char)v1));
        }
        return stringBuilder0.toString();
    }

    public final String zzl() {
        StringBuilder stringBuilder0 = new StringBuilder("G1");
        zzjj[] arr_zzjj = zzji.zza.zza();
        for(int v = 0; v < arr_zzjj.length; ++v) {
            stringBuilder0.append(zzjk.zzm(((zzjh)this.zzb.get(arr_zzjj[v]))));
        }
        return stringBuilder0.toString();
    }

    public static char zzm(zzjh zzjh0) {
        if(zzjh0 != null) {
            switch(zzjh0.ordinal()) {
                case 1: {
                    return '+';
                }
                case 2: {
                    return '0';
                }
                case 3: {
                    return '1';
                }
                default: {
                    return '-';
                }
            }
        }
        return '-';
    }

    public final Bundle zzn() {
        Bundle bundle0 = new Bundle();
        for(Object object0: this.zzb.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            String s = zzjk.zzi(((zzjh)map$Entry0.getValue()));
            if(s != null) {
                bundle0.putString(((zzjj)map$Entry0.getKey()).zze, s);
            }
        }
        return bundle0;
    }

    public final boolean zzo(zzjj zzjj0) {
        return ((zzjh)this.zzb.get(zzjj0)) != zzjh.zzc;
    }

    public final zzjh zzp() {
        zzjh zzjh0 = (zzjh)this.zzb.get(zzjj.zza);
        return zzjh0 == null ? zzjh.zza : zzjh0;
    }

    public final zzjh zzq() {
        zzjh zzjh0 = (zzjh)this.zzb.get(zzjj.zzb);
        return zzjh0 == null ? zzjh.zza : zzjh0;
    }

    public final boolean zzr(zzjk zzjk0) {
        EnumMap enumMap0 = this.zzb;
        zzjj[] arr_zzjj = (zzjj[])enumMap0.keySet().toArray(new zzjj[0]);
        for(int v = 0; v < arr_zzjj.length; ++v) {
            zzjj zzjj0 = arr_zzjj[v];
            zzjh zzjh0 = (zzjh)enumMap0.get(zzjj0);
            zzjh zzjh1 = (zzjh)zzjk0.zzb.get(zzjj0);
            if(zzjh0 == zzjh.zzc && zzjh1 != zzjh.zzc) {
                return true;
            }
        }
        return false;
    }

    public final zzjk zzs(zzjk zzjk0) {
        EnumMap enumMap0 = new EnumMap(zzjj.class);
        zzjj[] arr_zzjj = zzji.zza.zzb();
        for(int v = 0; v < arr_zzjj.length; ++v) {
            zzjj zzjj0 = arr_zzjj[v];
            zzjh zzjh0 = (zzjh)this.zzb.get(zzjj0);
            zzjh zzjh1 = (zzjh)zzjk0.zzb.get(zzjj0);
            if(zzjh0 == null) {
                zzjh0 = zzjh1;
            }
            else if(zzjh1 != null) {
                zzjh zzjh2 = zzjh.zza;
                if(zzjh0 == zzjh2) {
                    zzjh0 = zzjh1;
                }
                else if(zzjh1 != zzjh2) {
                    zzjh zzjh3 = zzjh.zzb;
                    if(zzjh0 == zzjh3) {
                        zzjh0 = zzjh1;
                    }
                    else if(zzjh1 != zzjh3) {
                        zzjh0 = zzjh0 == zzjh.zzc || zzjh1 == zzjh.zzc ? zzjh.zzc : zzjh.zzd;
                    }
                }
            }
            if(zzjh0 != null) {
                enumMap0.put(zzjj0, zzjh0);
            }
        }
        return new zzjk(enumMap0, 100);
    }

    public final zzjk zzt(zzjk zzjk0) {
        EnumMap enumMap0 = new EnumMap(zzjj.class);
        zzjj[] arr_zzjj = zzji.zza.zzb();
        for(int v = 0; v < arr_zzjj.length; ++v) {
            zzjj zzjj0 = arr_zzjj[v];
            zzjh zzjh0 = (zzjh)this.zzb.get(zzjj0);
            if(zzjh0 == zzjh.zza) {
                zzjh0 = (zzjh)zzjk0.zzb.get(zzjj0);
            }
            if(zzjh0 != null) {
                enumMap0.put(zzjj0, zzjh0);
            }
        }
        return new zzjk(enumMap0, this.zzc);
    }

    public static boolean zzu(int v, int v1) {
        if(v == -20) {
            if(v1 != -30) {
                v = -20;
                goto label_5;
            }
            return true;
        }
    label_5:
        if(v == -30) {
            return v1 == -20 ? true : -30 == v1 || -30 < v1;
        }
        return v == v1 || v < v1;
    }
}

