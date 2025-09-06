package com.google.android.gms.internal.measurement;

import I6.b0;
import java.util.HashMap;
import java.util.Map;
import va.e;

public final class zzaa {
    private static final b0 zza;
    private String zzb;
    private final long zzc;
    private final Map zzd;

    static {
        zzaa.zza = b0.o(3, new Object[]{"_syn", "_err", "_el"});
    }

    public zzaa(String s, long v, Map map0) {
        this.zzb = s;
        this.zzc = v;
        HashMap hashMap0 = new HashMap();
        this.zzd = hashMap0;
        if(map0 != null) {
            hashMap0.putAll(map0);
        }
    }

    @Override
    public final Object clone() {
        return this.zzg();
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzaa)) {
            return false;
        }
        if(this.zzc != ((zzaa)object0).zzc) {
            return false;
        }
        return this.zzb.equals(((zzaa)object0).zzb) ? this.zzd.equals(((zzaa)object0).zzd) : false;
    }

    @Override
    public final int hashCode() {
        return this.zzd.hashCode() + (this.zzb.hashCode() * 0x1F + ((int)(this.zzc ^ this.zzc >>> 0x20))) * 0x1F;
    }

    @Override
    public final String toString() {
        String s = this.zzb;
        String s1 = this.zzd.toString();
        StringBuilder stringBuilder0 = new StringBuilder(String.valueOf(s).length() + 25 + String.valueOf(this.zzc).length() + 9 + s1.length() + 1);
        e.g(stringBuilder0, "Event{name=\'", s, "\', timestamp=");
        stringBuilder0.append(this.zzc);
        stringBuilder0.append(", params=");
        stringBuilder0.append(s1);
        stringBuilder0.append("}");
        return stringBuilder0.toString();
    }

    public final long zza() {
        return this.zzc;
    }

    public final String zzb() {
        return this.zzb;
    }

    public final void zzc(String s) {
        this.zzb = s;
    }

    public final void zzd(String s, Object object0) {
        if(object0 == null) {
            this.zzd.remove(s);
            return;
        }
        Object object1 = zzaa.zzh(s, this.zzd.get(s), object0);
        this.zzd.put(s, object1);
    }

    // 去混淆评级： 低(20)
    public final Object zze(String s) {
        return this.zzd.containsKey(s) ? this.zzd.get(s) : null;
    }

    public final Map zzf() {
        return this.zzd;
    }

    public final zzaa zzg() {
        String s = this.zzb;
        HashMap hashMap0 = new HashMap(this.zzd);
        return new zzaa(s, this.zzc, hashMap0);
    }

    public static Object zzh(String s, Object object0, Object object1) {
        if(zzaa.zza.contains(s) && object1 instanceof Double) {
            return Math.round(((double)(((Double)object1))));
        }
        if(s.startsWith("_")) {
            if(object0 instanceof String) {
                return object1;
            }
            return object0 == null ? object1 : object0;
        }
        if(!(object0 instanceof Double)) {
            if(object0 instanceof Long) {
                return Math.round(((double)(((Double)object1))));
            }
            if(object0 instanceof String) {
                return object1.toString();
            }
        }
        return object1;
    }
}

