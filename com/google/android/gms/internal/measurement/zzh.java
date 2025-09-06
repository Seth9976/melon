package com.google.android.gms.internal.measurement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class zzh {
    public static void zza(String s, int v, List list0) {
        if(list0.size() != v) {
            throw new IllegalArgumentException(s + " operation requires " + v + " parameters found " + list0.size());
        }
    }

    public static void zzb(String s, int v, List list0) {
        if(list0.size() < v) {
            throw new IllegalArgumentException(s + " operation requires at least " + v + " parameters found " + list0.size());
        }
    }

    public static void zzc(String s, int v, List list0) {
        if(list0.size() > v) {
            throw new IllegalArgumentException(s + " operation requires at most " + v + " parameters found " + list0.size());
        }
    }

    public static boolean zzd(zzao zzao0) {
        if(zzao0 == null) {
            return false;
        }
        Double double0 = zzao0.zzd();
        return !double0.isNaN() && ((double)double0) >= 0.0 && double0.equals(Math.floor(((double)double0)));
    }

    public static zzbk zze(String s) {
        zzbk zzbk0 = s == null || s.isEmpty() ? null : zzbk.zza(Integer.parseInt(s));
        if(zzbk0 == null) {
            throw new IllegalArgumentException("Unsupported commandId " + s);
        }
        return zzbk0;
    }

    public static boolean zzf(zzao zzao0, zzao zzao1) {
        if(!zzao0.getClass().equals(zzao1.getClass())) {
            return false;
        }
        if(!(zzao0 instanceof zzat) && !(zzao0 instanceof zzam)) {
            if(zzao0 instanceof zzah) {
                return Double.isNaN(((double)zzao0.zzd())) || Double.isNaN(((double)zzao1.zzd())) ? false : zzao0.zzd().equals(zzao1.zzd());
            }
            if(zzao0 instanceof zzas) {
                return zzao0.zzc().equals(zzao1.zzc());
            }
            return zzao0 instanceof zzaf ? zzao0.zze().equals(zzao1.zze()) : zzao0 == zzao1;
        }
        return true;
    }

    public static int zzg(double f) {
        if(!Double.isNaN(f) && !Double.isInfinite(f)) {
            int v = Double.compare(f, 0.0);
            if(v != 0) {
                return v <= 0 ? ((int)(((long)(-1.0 * Math.floor(Math.abs(f)) % 4294967296.0)))) : ((int)(((long)(1.0 * Math.floor(Math.abs(f)) % 4294967296.0))));
            }
        }
        return 0;
    }

    public static long zzh(double f) {
        return ((long)zzh.zzg(f)) & 0xFFFFFFFFL;
    }

    public static double zzi(double f) {
        if(Double.isNaN(f)) {
            return 0.0;
        }
        if(!Double.isInfinite(f)) {
            int v = Double.compare(f, 0.0);
            if(v != 0) {
                return v <= 0 ? -1.0 * Math.floor(Math.abs(f)) : 1.0 * Math.floor(Math.abs(f));
            }
        }
        return f;
    }

    public static Object zzj(zzao zzao0) {
        if(zzao.zzg.equals(zzao0)) {
            return null;
        }
        if(zzao.zzf.equals(zzao0)) {
            return "";
        }
        if(zzao0 instanceof zzal) {
            return zzh.zzk(((zzal)zzao0));
        }
        if(zzao0 instanceof zzae) {
            ArrayList arrayList0 = new ArrayList();
            for(Object object0: ((zzae)zzao0)) {
                Object object1 = zzh.zzj(((zzao)object0));
                if(object1 != null) {
                    arrayList0.add(object1);
                }
            }
            return arrayList0;
        }
        return !zzao0.zzd().isNaN() ? zzao0.zzd() : zzao0.zzc();
    }

    public static Map zzk(zzal zzal0) {
        Map map0 = new HashMap();
        for(Object object0: zzal0.zzb()) {
            String s = (String)object0;
            Object object1 = zzh.zzj(zzal0.zzk(s));
            if(object1 != null) {
                ((HashMap)map0).put(s, object1);
            }
        }
        return map0;
    }

    public static int zzl(zzg zzg0) {
        int v = zzh.zzg(((double)zzg0.zzh("runtime.counter").zzd()) + 1.0);
        if(v > 1000000) {
            throw new IllegalStateException("Instructions allowed exceeded");
        }
        zzg0.zze("runtime.counter", new zzah(((double)v)));
        return v;
    }
}

