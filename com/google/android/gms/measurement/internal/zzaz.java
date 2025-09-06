package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import java.util.EnumMap;
import java.util.Map.Entry;
import java.util.Objects;

public final class zzaz {
    public static final zzaz zza;
    private final int zzb;
    private final String zzc;
    private final Boolean zzd;
    private final String zze;
    private final EnumMap zzf;

    static {
        zzaz.zza = new zzaz(null, 100, null, null);
    }

    public zzaz(Boolean boolean0, int v, Boolean boolean1, String s) {
        EnumMap enumMap0 = new EnumMap(zzjj.class);
        this.zzf = enumMap0;
        zzjh zzjh0 = zzjk.zzh(boolean0);
        enumMap0.put(zzjj.zzc, zzjh0);
        this.zzb = v;
        this.zzc = this.zzl();
        this.zzd = boolean1;
        this.zze = s;
    }

    private zzaz(EnumMap enumMap0, int v, Boolean boolean0, String s) {
        EnumMap enumMap1 = new EnumMap(zzjj.class);
        this.zzf = enumMap1;
        enumMap1.putAll(enumMap0);
        this.zzb = v;
        this.zzc = this.zzl();
        this.zzd = boolean0;
        this.zze = s;
    }

    // 去混淆评级： 低(30)
    @Override
    public final boolean equals(Object object0) {
        return !(object0 instanceof zzaz) || !this.zzc.equalsIgnoreCase(((zzaz)object0).zzc) || !Objects.equals(this.zzd, ((zzaz)object0).zzd) ? false : Objects.equals(this.zze, ((zzaz)object0).zze);
    }

    @Override
    public final int hashCode() {
        Boolean boolean0 = this.zzd;
        if(boolean0 == null) {
            return this.zze == null ? this.zzc.hashCode() + 0x970 : this.zze.hashCode() * 0x89 + (this.zzc.hashCode() + 87);
        }
        int v = boolean0.booleanValue() ? 7 : 13;
        return this.zze == null ? 0x919 + (this.zzc.hashCode() + v * 29) : this.zze.hashCode() * 0x89 + (this.zzc.hashCode() + v * 29);
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("source=");
        stringBuilder0.append(zzjk.zzd(this.zzb));
        zzjj[] arr_zzjj = zzji.zzb.zza();
        for(int v = 0; v < arr_zzjj.length; ++v) {
            zzjj zzjj0 = arr_zzjj[v];
            stringBuilder0.append(",");
            stringBuilder0.append(zzjj0.zze);
            stringBuilder0.append("=");
            zzjh zzjh0 = (zzjh)this.zzf.get(zzjj0);
            if(zzjh0 == null) {
                stringBuilder0.append("uninitialized");
            }
            else {
                switch(zzjh0.ordinal()) {
                    case 0: {
                        stringBuilder0.append("uninitialized");
                        break;
                    }
                    case 1: {
                        stringBuilder0.append("eu_consent_policy");
                        break;
                    }
                    case 2: {
                        stringBuilder0.append("denied");
                        break;
                    }
                    case 3: {
                        stringBuilder0.append("granted");
                    }
                }
            }
        }
        Boolean boolean0 = this.zzd;
        if(boolean0 != null) {
            stringBuilder0.append(",isDmaRegion=");
            stringBuilder0.append(boolean0);
        }
        String s = this.zze;
        if(s != null) {
            stringBuilder0.append(",cpsDisplayStr=");
            stringBuilder0.append(s);
        }
        return stringBuilder0.toString();
    }

    public static zzaz zza(zzjh zzjh0, int v) {
        EnumMap enumMap0 = new EnumMap(zzjj.class);
        enumMap0.put(zzjj.zzc, zzjh0);
        return new zzaz(enumMap0, -10, null, null);
    }

    public final int zzb() {
        return this.zzb;
    }

    public final zzjh zzc() {
        zzjh zzjh0 = (zzjh)this.zzf.get(zzjj.zzc);
        return zzjh0 == null ? zzjh.zza : zzjh0;
    }

    public final boolean zzd() {
        for(Object object0: this.zzf.values()) {
            if(((zzjh)object0) != zzjh.zza) {
                return true;
            }
            if(false) {
                break;
            }
        }
        return false;
    }

    public final String zze() {
        return this.zzc;
    }

    public final Bundle zzf() {
        Bundle bundle0 = new Bundle();
        for(Object object0: this.zzf.entrySet()) {
            Map.Entry map$Entry0 = (Map.Entry)object0;
            String s = zzjk.zzi(((zzjh)map$Entry0.getValue()));
            if(s != null) {
                bundle0.putString(((zzjj)map$Entry0.getKey()).zze, s);
            }
        }
        Boolean boolean0 = this.zzd;
        if(boolean0 != null) {
            bundle0.putString("is_dma_region", boolean0.toString());
        }
        String s1 = this.zze;
        if(s1 != null) {
            bundle0.putString("cps_display_str", s1);
        }
        return bundle0;
    }

    public static zzaz zzg(String s) {
        if(s != null && s.length() > 0) {
            String[] arr_s = s.split(":");
            int v = Integer.parseInt(arr_s[0]);
            EnumMap enumMap0 = new EnumMap(zzjj.class);
            zzjj[] arr_zzjj = zzji.zzb.zza();
            int v2 = 0;
            for(int v1 = 1; v2 < arr_zzjj.length; ++v1) {
                enumMap0.put(arr_zzjj[v2], zzjk.zzj(arr_s[v1].charAt(0)));
                ++v2;
            }
            return new zzaz(enumMap0, v, null, null);
        }
        return zzaz.zza;
    }

    public static zzaz zzh(Bundle bundle0, int v) {
        Boolean boolean0 = null;
        if(bundle0 == null) {
            return new zzaz(null, v, null, null);
        }
        EnumMap enumMap0 = new EnumMap(zzjj.class);
        zzjj[] arr_zzjj = zzji.zzb.zza();
        for(int v1 = 0; v1 < arr_zzjj.length; ++v1) {
            zzjj zzjj0 = arr_zzjj[v1];
            enumMap0.put(zzjj0, zzjk.zzg(bundle0.getString(zzjj0.zze)));
        }
        if(bundle0.containsKey("is_dma_region")) {
            boolean0 = Boolean.valueOf(bundle0.getString("is_dma_region"));
        }
        return new zzaz(enumMap0, v, boolean0, bundle0.getString("cps_display_str"));
    }

    public static Boolean zzi(Bundle bundle0) {
        if(bundle0 != null) {
            zzjh zzjh0 = zzjk.zzg(bundle0.getString("ad_personalization"));
            if(zzjh0 != null) {
                switch(zzjh0.ordinal()) {
                    case 2: {
                        return false;
                    }
                    case 3: {
                        return true;
                    }
                    default: {
                        return null;
                    }
                }
            }
        }
        return null;
    }

    public final Boolean zzj() {
        return this.zzd;
    }

    public final String zzk() {
        return this.zze;
    }

    private final String zzl() {
        StringBuilder stringBuilder0 = new StringBuilder();
        stringBuilder0.append(this.zzb);
        zzjj[] arr_zzjj = zzji.zzb.zza();
        for(int v = 0; v < arr_zzjj.length; ++v) {
            zzjj zzjj0 = arr_zzjj[v];
            stringBuilder0.append(":");
            stringBuilder0.append(zzjk.zzm(((zzjh)this.zzf.get(zzjj0))));
        }
        return stringBuilder0.toString();
    }
}

