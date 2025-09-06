package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class zzi {
    public static zzao zza(Object object0) {
        if(object0 == null) {
            return zzao.zzg;
        }
        if(object0 instanceof String) {
            return new zzas(((String)object0));
        }
        if(object0 instanceof Double) {
            return new zzah(((Double)object0));
        }
        if(object0 instanceof Long) {
            return new zzah(((Long)object0).doubleValue());
        }
        if(object0 instanceof Integer) {
            return new zzah(((Integer)object0).doubleValue());
        }
        if(object0 instanceof Boolean) {
            return new zzaf(((Boolean)object0));
        }
        if(object0 instanceof Map) {
            zzao zzao0 = new zzal();
            for(String s: ((Map)object0).keySet()) {
                zzao zzao1 = zzi.zza(((Map)object0).get(s));
                if(s != null) {
                    if(!(s instanceof String)) {
                        s = s.toString();
                    }
                    ((zzal)zzao0).zzm(s, zzao1);
                }
            }
            return zzao0;
        }
        if(!(object0 instanceof List)) {
            throw new IllegalArgumentException("Invalid value type");
        }
        zzao zzao2 = new zzae();
        for(Object object1: ((List)object0)) {
            zzao zzao3 = zzi.zza(object1);
            ((zzae)zzao2).zzn(((zzae)zzao2).zzh(), zzao3);
        }
        return zzao2;
    }

    public static zzao zzb(zzje zzje0) {
        if(zzje0 == null) {
            return zzao.zzf;
        }
        switch(zzje0.zzj() - 1) {
            case 1: {
                return zzje0.zzc() ? new zzas("") : zzao.zzm;
            }
            case 2: {
                return zzje0.zzg() ? new zzah(zzje0.zzh()) : new zzah(null);
            }
            case 3: {
                return zzje0.zze() ? new zzaf(Boolean.valueOf(zzje0.zzf())) : new zzaf(null);
            }
            case 4: {
                ArrayList arrayList0 = new ArrayList();
                for(Object object0: zzje0.zza()) {
                    arrayList0.add(zzi.zzb(((zzje)object0)));
                }
                return new zzap("", arrayList0);
            }
            default: {
                throw new IllegalArgumentException("Unknown type found. Cannot convert entity");
            }
        }
    }
}

