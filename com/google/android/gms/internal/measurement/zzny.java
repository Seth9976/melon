package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.List;

final class zzny {
    public static final int zza;
    private static final zzoh zzb;

    static {
        zzny.zzb = new zzoj();
    }

    public static zzoh zzA() {
        return zzny.zzb;
    }

    // 去混淆评级： 低(20)
    public static boolean zzB(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    public static void zzC(zzlr zzlr0, Object object0, Object object1) {
        if(((zzmb)object1).zzb.zza.isEmpty()) {
            return;
        }
        zzmb zzmb0 = (zzmb)object0;
        throw null;
    }

    public static void zzD(zzoh zzoh0, Object object0, Object object1) {
        zzoi zzoi0 = ((zzme)object0).zzc;
        zzoi zzoi1 = ((zzme)object1).zzc;
        if(!zzoi.zza().equals(zzoi1)) {
            if(zzoi.zza().equals(zzoi0)) {
                zzoi0 = zzoi.zzc(zzoi0, zzoi1);
            }
            else {
                zzoi0.zzl(zzoi1);
            }
        }
        ((zzme)object0).zzc = zzoi0;
    }

    public static Object zzE(Object object0, int v, int v1, Object object1, zzoh zzoh0) {
        if(object1 == null) {
            object1 = zzoh0.zza(object0);
        }
        ((zzoi)object1).zzk(v << 3, ((long)v1));
        return object1;
    }

    public static void zza(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzC(v, list0, z);
        }
    }

    public static void zzb(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzB(v, list0, z);
        }
    }

    public static void zzc(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzy(v, list0, z);
        }
    }

    public static void zzd(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzz(v, list0, z);
        }
    }

    public static void zze(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzL(v, list0, z);
        }
    }

    public static void zzf(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzA(v, list0, z);
        }
    }

    public static void zzg(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzJ(v, list0, z);
        }
    }

    public static void zzh(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzw(v, list0, z);
        }
    }

    public static void zzi(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzH(v, list0, z);
        }
    }

    public static void zzj(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzK(v, list0, z);
        }
    }

    public static void zzk(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzx(v, list0, z);
        }
    }

    public static void zzl(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzI(v, list0, z);
        }
    }

    public static void zzm(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzD(v, list0, z);
        }
    }

    public static void zzn(int v, List list0, zzou zzou0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzou0.zzE(v, list0, z);
        }
    }

    public static int zzo(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzmz) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzll.zzA(((zzmz)list0).zzc(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzll.zzA(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzp(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzmz) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzll.zzA(((zzmz)list0).zzc(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzll.zzA(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzq(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzmz) {
            int v2 = 0;
            while(v1 < v) {
                long v3 = ((zzmz)list0).zzc(v1);
                v2 += zzll.zzA(v3 >> 0x3F ^ v3 + v3);
                ++v1;
            }
            return v2;
        }
        int v4 = 0;
        while(v1 < v) {
            long v5 = (long)(((Long)list0.get(v1)));
            v4 += zzll.zzA(v5 >> 0x3F ^ v5 + v5);
            ++v1;
        }
        return v4;
    }

    public static int zzr(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzmf) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzll.zzA(((zzmf)list0).zzf(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzll.zzA(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzs(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzmf) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzll.zzA(((zzmf)list0).zzf(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzll.zzA(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzt(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzmf) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzll.zzz(((zzmf)list0).zzf(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzll.zzz(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzu(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzmf) {
            int v2 = 0;
            while(v1 < v) {
                int v3 = ((zzmf)list0).zzf(v1);
                v2 += zzll.zzz(v3 >> 0x1F ^ v3 + v3);
                ++v1;
            }
            return v2;
        }
        int v4 = 0;
        while(v1 < v) {
            int v5 = (int)(((Integer)list0.get(v1)));
            v4 += zzll.zzz(v5 >> 0x1F ^ v5 + v5);
            ++v1;
        }
        return v4;
    }

    public static int zzv(List list0) {
        return list0.size() * 4;
    }

    public static int zzw(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : (zzll.zzz(v << 3) + 4) * v1;
    }

    public static int zzx(List list0) {
        return list0.size() * 8;
    }

    public static int zzy(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : (zzll.zzz(v << 3) + 8) * v1;
    }

    public static int zzz(int v, Object object0, zznw zznw0) {
        if(object0 instanceof zzmv) {
            int v1 = ((zzmv)object0).zzb();
            return Z.B(v1, v1, zzll.zzz(v << 3));
        }
        return zzll.zzD(((zznl)object0), zznw0) + zzll.zzz(v << 3);
    }
}

