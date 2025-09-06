package com.google.android.gms.internal.cast;

import b3.Z;
import java.util.List;

final class zzyx {
    public static final int zza;
    private static final zzzh zzb;

    static {
        zzyx.zzb = new zzzj();
    }

    public static void zzA(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzD(v, list0, z);
        }
    }

    public static void zzB(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzH(v, list0, z);
        }
    }

    public static void zzC(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzJ(v, list0, z);
        }
    }

    // 去混淆评级： 低(20)
    public static boolean zzD(Object object0, Object object1) {
        return object0 == object1 || object0 != null && object0.equals(object1);
    }

    public static int zza(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzxj) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzwu.zzA(((zzxj)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzwu.zzA(((int)(((Integer)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzb(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : (zzwu.zzz(v << 3) + 4) * v1;
    }

    public static int zzc(List list0) {
        return list0.size() * 4;
    }

    public static int zzd(int v, List list0, boolean z) {
        int v1 = list0.size();
        return v1 == 0 ? 0 : (zzwu.zzz(v << 3) + 8) * v1;
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
        if(list0 instanceof zzxj) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzwu.zzA(((zzxj)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzwu.zzA(((int)(((Integer)list0.get(v1)))));
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
        if(list0 instanceof zzya) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzwu.zzA(((zzya)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzwu.zzA(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static int zzh(int v, Object object0, zzyv zzyv0) {
        if(object0 instanceof zzxw) {
            int v1 = ((zzxw)object0).zza();
            return Z.z(v1, v1, zzwu.zzz(v << 3));
        }
        return zzwu.zzx(((zzyl)object0), zzyv0) + zzwu.zzz(v << 3);
    }

    public static int zzi(List list0) {
        int v = list0.size();
        int v1 = 0;
        if(v == 0) {
            return 0;
        }
        if(list0 instanceof zzxj) {
            int v2 = 0;
            while(v1 < v) {
                int v3 = ((zzxj)list0).zze(v1);
                v2 += zzwu.zzz(v3 >> 0x1F ^ v3 + v3);
                ++v1;
            }
            return v2;
        }
        int v4 = 0;
        while(v1 < v) {
            int v5 = (int)(((Integer)list0.get(v1)));
            v4 += zzwu.zzz(v5 >> 0x1F ^ v5 + v5);
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
        if(list0 instanceof zzya) {
            int v2 = 0;
            while(v1 < v) {
                long v3 = ((zzya)list0).zze(v1);
                v2 += zzwu.zzA(v3 >> 0x3F ^ v3 + v3);
                ++v1;
            }
            return v2;
        }
        int v4 = 0;
        while(v1 < v) {
            long v5 = (long)(((Long)list0.get(v1)));
            v4 += zzwu.zzA(v5 >> 0x3F ^ v5 + v5);
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
        if(list0 instanceof zzxj) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzwu.zzz(((zzxj)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzwu.zzz(((int)(((Integer)list0.get(v1)))));
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
        if(list0 instanceof zzya) {
            int v2 = 0;
            while(v1 < v) {
                v2 += zzwu.zzA(((zzya)list0).zze(v1));
                ++v1;
            }
            return v2;
        }
        int v3 = 0;
        while(v1 < v) {
            v3 += zzwu.zzA(((long)(((Long)list0.get(v1)))));
            ++v1;
        }
        return v3;
    }

    public static zzzh zzm() {
        return zzyx.zzb;
    }

    public static void zzn(zzwx zzwx0, Object object0, Object object1) {
        if(((zzxg)object1).zzb.zza.isEmpty()) {
            return;
        }
        zzxg zzxg0 = (zzxg)object0;
        throw null;
    }

    public static void zzo(zzzh zzzh0, Object object0, Object object1) {
        zzzi zzzi0 = ((zzxi)object0).zzc;
        zzzi zzzi1 = ((zzxi)object1).zzc;
        if(!zzzi.zzc().equals(zzzi1)) {
            if(zzzi.zzc().equals(zzzi0)) {
                zzzi0 = zzzi.zze(zzzi0, zzzi1);
            }
            else {
                zzzi0.zzd(zzzi1);
            }
        }
        ((zzxi)object0).zzc = zzzi0;
    }

    public static void zzp(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzc(v, list0, z);
        }
    }

    public static void zzq(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzg(v, list0, z);
        }
    }

    public static void zzr(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzi(v, list0, z);
        }
    }

    public static void zzs(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzk(v, list0, z);
        }
    }

    public static void zzt(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzm(v, list0, z);
        }
    }

    public static void zzu(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzo(v, list0, z);
        }
    }

    public static void zzv(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzr(v, list0, z);
        }
    }

    public static void zzw(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzt(v, list0, z);
        }
    }

    public static void zzx(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzx(v, list0, z);
        }
    }

    public static void zzy(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzz(v, list0, z);
        }
    }

    public static void zzz(int v, List list0, zzzt zzzt0, boolean z) {
        if(list0 != null && !list0.isEmpty()) {
            zzzt0.zzB(v, list0, z);
        }
    }
}

