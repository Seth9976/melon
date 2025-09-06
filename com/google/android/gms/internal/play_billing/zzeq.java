package com.google.android.gms.internal.play_billing;

import b3.Z;
import java.util.List;

final class zzeq {
    public static final int zza;
    private static final Class zzb;
    private static final zzff zzc;
    private static final zzff zzd;

    static {
        Class class1;
        Class class0;
        zzff zzff0 = null;
        try {
            class0 = null;
            class0 = Class.forName("com.google.protobuf.GeneratedMessage");
        }
        catch(Throwable unused_ex) {
        }
        try {
            zzeq.zzb = class0;
            class1 = null;
            class1 = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        }
        catch(Throwable unused_ex) {
        }
        if(class1 != null) {
            try {
                zzff0 = (zzff)class1.getConstructor(null).newInstance(null);
            }
            catch(Throwable unused_ex) {
            }
        }
        zzeq.zzc = zzff0;
        zzeq.zzd = new zzfh();
    }

    public static void zzA(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzy(v, list0, z);
        }
    }

    public static void zzB(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzA(v, list0, z);
        }
    }

    public static void zzC(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzC(v, list0, z);
        }
    }

    public static void zzD(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzE(v, list0, z);
        }
    }

    public static void zzE(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzJ(v, list0, z);
        }
    }

    public static void zzF(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzL(v, list0, z);
        }
    }

    // 去混淆评级： 低(20)
    public static boolean zzG(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    public static int zza(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzct) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzby.zzx(((zzct)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzby.zzx(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzb(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : (zzby.zzw(v << 3) + 4) * v1;
    }

    public static int zzc(List list0) {
        return list0.size() * 4;
    }

    public static int zzd(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : (zzby.zzw(v << 3) + 8) * v1;
    }

    public static int zze(List list0) {
        return list0.size() * 8;
    }

    public static int zzf(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzct) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzby.zzx(((zzct)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzby.zzx(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzg(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzdr) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzby.zzx(((zzdr)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzby.zzx(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzh(int v, Object object0, zzeo zzeo0) {
        if(object0 instanceof zzdi) {
            int v1 = ((zzdi)object0).zza();
            return Z.C(v1, v1, zzby.zzw(v << 3));
        }
        return zzby.zzu(((zzec)object0), zzeo0) + zzby.zzw(v << 3);
    }

    public static int zzi(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzct) {
            int v2 = 0;
            while(v1 < v) {
                int v3 = ((zzct)list0).zze(v1);
                v2 += zzby.zzw(v3 >> 0x1F ^ v3 + v3);
                ++v1;
            }
            return v2;
        }
        int v4 = 0;
        while(v1 < v) {
            int v5 = (int)(((Integer)list0.get(v1)));
            v4 += zzby.zzw(v5 >> 0x1F ^ v5 + v5);
            ++v1;
        }
        return v4;
    }

    public static int zzj(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzdr) {
            int v2 = 0;
            while(v1 < v) {
                long v3 = ((zzdr)list0).zze(v1);
                v2 += zzby.zzx(v3 >> 0x3F ^ v3 + v3);
                ++v1;
            }
            return v2;
        }
        int v4 = 0;
        while(v1 < v) {
            long v5 = (long)(((Long)list0.get(v1)));
            v4 += zzby.zzx(v5 >> 0x3F ^ v5 + v5);
            ++v1;
        }
        return v4;
    }

    public static int zzk(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzct) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzby.zzw(((zzct)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzby.zzw(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzl(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzdr) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzby.zzx(((zzdr)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzby.zzx(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static zzff zzm() {
        return zzeq.zzc;
    }

    public static zzff zzn() {
        return zzeq.zzd;
    }

    public static Object zzo(Object object0, int v, int v1, Object object1, zzff zzff0) {
        if(object1 == null) {
            object1 = zzff0.zzc(object0);
        }
        zzff0.zzf(object1, v, ((long)v1));
        return object1;
    }

    public static void zzp(zzce zzce0, Object object0, Object object1) {
        zzci zzci0 = zzce0.zzb(object1);
        if(!zzci0.zza.isEmpty()) {
            zzce0.zzc(object0).zzh(zzci0);
        }
    }

    public static void zzq(zzff zzff0, Object object0, Object object1) {
        zzff0.zzh(object0, zzff0.zze(zzff0.zzd(object0), zzff0.zzd(object1)));
    }

    public static void zzr(Class class0) {
        if(!zzcs.class.isAssignableFrom(class0) && (zzeq.zzb != null && !zzeq.zzb.isAssignableFrom(class0))) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void zzs(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzc(v, list0, z);
        }
    }

    public static void zzt(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzg(v, list0, z);
        }
    }

    public static void zzu(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzj(v, list0, z);
        }
    }

    public static void zzv(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzl(v, list0, z);
        }
    }

    public static void zzw(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzn(v, list0, z);
        }
    }

    public static void zzx(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzp(v, list0, z);
        }
    }

    public static void zzy(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzs(v, list0, z);
        }
    }

    public static void zzz(int v, List list0, zzfx zzfx0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzfx0.zzu(v, list0, z);
        }
    }
}

