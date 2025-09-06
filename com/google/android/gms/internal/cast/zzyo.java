package com.google.android.gms.internal.cast;

import A7.d;
import H0.b;
import b3.Z;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class zzyo implements zzyv {
    private static final int[] zza;
    private static final Unsafe zzb;
    private final int[] zzc;
    private final Object[] zzd;
    private final zzyl zze;
    private final boolean zzf;
    private final int[] zzg;
    private final int zzh;
    private final zzzh zzi;
    private final zzwx zzj;

    static {
        zzyo.zza = new int[0];
        zzyo.zzb = zzzo.zzg();
    }

    private zzyo(int[] arr_v, Object[] arr_object, int v, int v1, zzyl zzyl0, boolean z, int[] arr_v1, int v2, int v3, zzyq zzyq0, zzxy zzxy0, zzzh zzzh0, zzwx zzwx0, zzyg zzyg0) {
        this.zzc = arr_v;
        this.zzd = arr_object;
        this.zzf = zzwx0 != null && zzyl0 instanceof zzxg;
        this.zzg = arr_v1;
        this.zzh = v2;
        this.zzi = zzzh0;
        this.zzj = zzwx0;
        this.zze = zzyl0;
    }

    private static boolean zzA(Object object0, int v, zzyv zzyv0) {
        return zzyv0.zzh(zzzo.zzf(object0, ((long)(v & 0xFFFFF))));
    }

    private static boolean zzB(Object object0) {
        if(object0 == null) {
            return false;
        }
        return object0 instanceof zzxi ? ((zzxi)object0).zzM() : true;
    }

    private final boolean zzC(Object object0, int v, int v1) {
        return zzzo.zzc(object0, ((long)(this.zzm(v1) & 0xFFFFF))) == v;
    }

    private static boolean zzD(Object object0, long v) {
        return ((Boolean)zzzo.zzf(object0, v)).booleanValue();
    }

    private static final void zzE(int v, Object object0, zzzt zzzt0) {
        if(object0 instanceof String) {
            zzzt0.zzE(v, ((String)object0));
            return;
        }
        zzzt0.zzd(v, ((zzwn)object0));
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final int zza(Object object0) {
        int v42;
        int v41;
        int v39;
        int v37;
        int v36;
        int v35;
        int v29;
        int v23;
        int v20;
        int v19;
        int v18;
        int v17;
        int v14;
        int v13;
        int v12;
        int v10;
        Unsafe unsafe0 = zzyo.zzb;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0xFFFFF;
        while(true) {
            int[] arr_v = this.zzc;
            if(v1 >= arr_v.length) {
                break;
            }
            int v5 = this.zzo(v1);
            int v6 = v5 >>> 20 & 0xFF;
            int v7 = arr_v[v1];
            int v8 = arr_v[v1 + 2];
            int v9 = v8 & 0xFFFFF;
            if(v6 <= 17) {
                if(v9 != v4) {
                    v2 = v9 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v9));
                    v4 = v9;
                }
                v10 = 1 << (v8 >>> 20);
            }
            else {
                v10 = 0;
            }
            boolean z = v6 < zzxc.zzJ.zza();
            long v11 = (long)(v5 & 0xFFFFF);
            switch(v6) {
                case 0: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 = Z.z(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 1: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 = Z.z(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 2: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v12 = zzwu.zzz(v7 << 3);
                        v13 = zzwu.zzA(unsafe0.getLong(object0, v11));
                        v3 += v13 + v12;
                    }
                    v1 += 3;
                    continue;
                }
                case 3: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v12 = zzwu.zzz(v7 << 3);
                        v13 = zzwu.zzA(unsafe0.getLong(object0, v11));
                        v3 += v13 + v12;
                    }
                    v1 += 3;
                    continue;
                }
                case 4: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v12 = zzwu.zzz(v7 << 3);
                        v13 = zzwu.zzA(unsafe0.getInt(object0, v11));
                        v3 += v13 + v12;
                    }
                    v1 += 3;
                    continue;
                }
                case 5: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 = Z.z(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 6: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 = Z.z(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 7: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 = Z.z(v7 << 3, 1, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 8: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        Object object1 = unsafe0.getObject(object0, v11);
                        if(object1 instanceof zzwn) {
                            v14 = ((zzwn)object1).zzd();
                            v3 += zzwu.zzz(v14) + v14 + zzwu.zzz(v7 << 3);
                            v1 += 3;
                            continue;
                        }
                        else {
                            v12 = zzwu.zzz(v7 << 3);
                            v13 = zzwu.zzy(((String)object1));
                        }
                    }
                    else {
                        v1 += 3;
                        continue;
                    }
                    v3 += v13 + v12;
                    v1 += 3;
                    continue;
                }
                case 9: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 += zzyx.zzh(v7, unsafe0.getObject(object0, v11), this.zzq(v1));
                    }
                    v1 += 3;
                    continue;
                }
                case 10: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v14 = ((zzwn)unsafe0.getObject(object0, v11)).zzd();
                        v3 += zzwu.zzz(v14) + v14 + zzwu.zzz(v7 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 11: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 = Z.z(unsafe0.getInt(object0, v11), zzwu.zzz(v7 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 12: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 += zzwu.zzA(unsafe0.getInt(object0, v11)) + zzwu.zzz(v7 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 13: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 = Z.z(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 14: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 = Z.z(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 15: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        int v15 = unsafe0.getInt(object0, v11);
                        v3 = Z.z(v15 >> 0x1F ^ v15 + v15, zzwu.zzz(v7 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 16: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        long v16 = unsafe0.getLong(object0, v11);
                        v3 += zzwu.zzA(v16 >> 0x3F ^ v16 + v16) + zzwu.zzz(v7 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 17: {
                    if(this.zzz(object0, v1, v4, v2, v10)) {
                        v3 += zzwu.zzw(v7, ((zzyl)unsafe0.getObject(object0, v11)), this.zzq(v1));
                        break;
                    }
                    else {
                        v1 += 3;
                        continue;
                    }
                    v17 = zzyx.zzd(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 18: {
                    v17 = zzyx.zzd(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 19: {
                    v17 = zzyx.zzb(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 20: {
                    List list0 = (List)unsafe0.getObject(object0, v11);
                    if(list0.size() != 0) {
                        v3 += zzwu.zzz(v7 << 3) * list0.size() + zzyx.zzg(list0);
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 21: {
                    List list1 = (List)unsafe0.getObject(object0, v11);
                    v18 = list1.size();
                    if(v18 != 0) {
                        v19 = zzyx.zzl(list1);
                        v20 = zzwu.zzz(v7 << 3);
                        v23 = v20 * v18 + v19;
                        v3 += v23;
                        v1 += 3;
                        continue;
                    }
                    v23 = 0;
                    v3 += v23;
                    v1 += 3;
                    continue;
                }
                case 22: {
                    List list2 = (List)unsafe0.getObject(object0, v11);
                    v18 = list2.size();
                    if(v18 != 0) {
                        v19 = zzyx.zzf(list2);
                        v20 = zzwu.zzz(v7 << 3);
                        v23 = v20 * v18 + v19;
                        v3 += v23;
                        v1 += 3;
                        continue;
                    }
                    v23 = 0;
                    v3 += v23;
                    v1 += 3;
                    continue;
                }
                case 23: {
                    v17 = zzyx.zzd(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 24: {
                    v17 = zzyx.zzb(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 25: {
                    int v21 = ((List)unsafe0.getObject(object0, v11)).size();
                    v3 += (v21 == 0 ? 0 : (zzwu.zzz(v7 << 3) + 1) * v21);
                    v1 += 3;
                    continue;
                }
                case 26: {
                    List list3 = (List)unsafe0.getObject(object0, v11);
                    int v22 = list3.size();
                    if(v22 != 0) {
                        v23 = zzwu.zzz(v7 << 3) * v22;
                        if(list3 instanceof zzxx) {
                            zzxx zzxx0 = (zzxx)list3;
                            for(int v24 = 0; v24 < v22; ++v24) {
                                Object object2 = zzxx0.zza();
                                if(object2 instanceof zzwn) {
                                    int v25 = ((zzwn)object2).zzd();
                                    v23 = Z.z(v25, v25, v23);
                                }
                                else {
                                    v23 = zzwu.zzy(((String)object2)) + v23;
                                }
                            }
                        }
                        else {
                            for(int v26 = 0; v26 < v22; ++v26) {
                                Object object3 = list3.get(v26);
                                if(object3 instanceof zzwn) {
                                    int v27 = ((zzwn)object3).zzd();
                                    v23 = Z.z(v27, v27, v23);
                                }
                                else {
                                    v23 = zzwu.zzy(((String)object3)) + v23;
                                }
                            }
                        }
                        v3 += v23;
                        v1 += 3;
                        continue;
                    }
                    v23 = 0;
                    v3 += v23;
                    v1 += 3;
                    continue;
                }
                case 27: {
                    List list4 = (List)unsafe0.getObject(object0, v11);
                    zzyv zzyv0 = this.zzq(v1);
                    int v28 = list4.size();
                    if(v28 == 0) {
                        v29 = 0;
                    }
                    else {
                        v29 = zzwu.zzz(v7 << 3) * v28;
                        for(int v30 = 0; v30 < v28; ++v30) {
                            Object object4 = list4.get(v30);
                            if(object4 instanceof zzxw) {
                                int v31 = ((zzxw)object4).zza();
                                v29 = Z.z(v31, v31, v29);
                            }
                            else {
                                v29 = zzwu.zzx(((zzyl)object4), zzyv0) + v29;
                            }
                        }
                    }
                    v3 += v29;
                    v1 += 3;
                    continue;
                }
                case 28: {
                    List list5 = (List)unsafe0.getObject(object0, v11);
                    int v32 = list5.size();
                    if(v32 != 0) {
                        v23 = zzwu.zzz(v7 << 3) * v32;
                        for(int v33 = 0; v33 < list5.size(); ++v33) {
                            int v34 = ((zzwn)list5.get(v33)).zzd();
                            v23 = Z.z(v34, v34, v23);
                        }
                        v3 += v23;
                        v1 += 3;
                        continue;
                    }
                    v23 = 0;
                    v3 += v23;
                    v1 += 3;
                    continue;
                }
                case 29: {
                    List list6 = (List)unsafe0.getObject(object0, v11);
                    v18 = list6.size();
                    if(v18 != 0) {
                        v19 = zzyx.zzk(list6);
                        v20 = zzwu.zzz(v7 << 3);
                        v23 = v20 * v18 + v19;
                        v3 += v23;
                        v1 += 3;
                        continue;
                    }
                    v23 = 0;
                    v3 += v23;
                    v1 += 3;
                    continue;
                }
                case 30: {
                    List list7 = (List)unsafe0.getObject(object0, v11);
                    v18 = list7.size();
                    if(v18 != 0) {
                        v19 = zzyx.zza(list7);
                        v20 = zzwu.zzz(v7 << 3);
                        v23 = v20 * v18 + v19;
                        v3 += v23;
                        v1 += 3;
                        continue;
                    }
                    v23 = 0;
                    v3 += v23;
                    v1 += 3;
                    continue;
                }
                case 0x1F: {
                    v17 = zzyx.zzb(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    break;
                }
                case 0x20: {
                    v17 = zzyx.zzd(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    break;
                }
                case 33: {
                    List list8 = (List)unsafe0.getObject(object0, v11);
                    v18 = list8.size();
                    if(v18 != 0) {
                        v3 += zzwu.zzz(v7 << 3) * v18 + zzyx.zzi(list8);
                        v1 += 3;
                        continue;
                    }
                    v23 = 0;
                    v3 += v23;
                    v1 += 3;
                    continue;
                }
                case 34: {
                    List list9 = (List)unsafe0.getObject(object0, v11);
                    v18 = list9.size();
                    v3 += (v18 == 0 ? 0 : zzwu.zzz(v7 << 3) * v18 + zzyx.zzj(list9));
                    v1 += 3;
                    continue;
                }
                case 35: {
                    v35 = zzyx.zze(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 36: {
                    v35 = zzyx.zzc(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 37: {
                    v35 = zzyx.zzg(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 38: {
                    v35 = zzyx.zzl(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 39: {
                    v35 = zzyx.zzf(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 40: {
                    v35 = zzyx.zze(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 41: {
                    v35 = zzyx.zzc(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 42: {
                    v35 = ((List)unsafe0.getObject(object0, v11)).size();
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 43: {
                    v35 = zzyx.zzk(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 44: {
                    v35 = zzyx.zza(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 45: {
                    v35 = zzyx.zzc(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 46: {
                    v35 = zzyx.zze(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x2F: {
                    v35 = zzyx.zzi(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x30: {
                    v35 = zzyx.zzj(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzwu.zzz(v7 << 3);
                        v37 = zzwu.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 49: {
                    List list10 = (List)unsafe0.getObject(object0, v11);
                    zzyv zzyv1 = this.zzq(v1);
                    int v38 = list10.size();
                    if(v38 == 0) {
                        v39 = 0;
                    }
                    else {
                        v39 = 0;
                        for(int v40 = 0; v40 < v38; ++v40) {
                            v39 += zzwu.zzw(v7, ((zzyl)list10.get(v40)), zzyv1);
                        }
                    }
                    v3 += v39;
                    v1 += 3;
                    continue;
                }
                case 50: {
                    Object object5 = unsafe0.getObject(object0, v11);
                    Object object6 = this.zzr(v1);
                    zzyf zzyf0 = (zzyf)object5;
                    zzye zzye0 = (zzye)object6;
                    if(!zzyf0.isEmpty()) {
                        Iterator iterator0 = zzyf0.entrySet().iterator();
                        if(iterator0.hasNext()) {
                            Object object7 = iterator0.next();
                            ((Map.Entry)object7).getKey();
                            ((Map.Entry)object7).getValue();
                            throw null;
                        }
                    }
                    v1 += 3;
                    continue;
                }
                case 51: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 = Z.z(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 52: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 = Z.z(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 53: {
                    if(this.zzC(object0, v7, v1)) {
                        v41 = zzwu.zzz(v7 << 3);
                        v42 = zzwu.zzA(zzyo.zzp(object0, v11));
                        v3 += v42 + v41;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 54: {
                    if(this.zzC(object0, v7, v1)) {
                        v41 = zzwu.zzz(v7 << 3);
                        v42 = zzwu.zzA(zzyo.zzp(object0, v11));
                        v3 += v42 + v41;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 55: {
                    if(this.zzC(object0, v7, v1)) {
                        v41 = zzwu.zzz(v7 << 3);
                        v42 = zzwu.zzA(zzyo.zzl(object0, v11));
                        v3 += v42 + v41;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 56: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 = Z.z(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 57: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 = Z.z(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 58: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 = Z.z(v7 << 3, 1, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 59: {
                    if(this.zzC(object0, v7, v1)) {
                        Object object8 = unsafe0.getObject(object0, v11);
                        if(object8 instanceof zzwn) {
                            v36 = ((zzwn)object8).zzd();
                            v3 += zzwu.zzz(v36) + v36 + zzwu.zzz(v7 << 3);
                            break;
                        }
                        else {
                            v41 = zzwu.zzz(v7 << 3);
                            v42 = zzwu.zzy(((String)object8));
                        }
                        v3 += v42 + v41;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 60: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 += zzyx.zzh(v7, unsafe0.getObject(object0, v11), this.zzq(v1));
                    }
                    v1 += 3;
                    continue;
                }
                case 61: {
                    if(this.zzC(object0, v7, v1)) {
                        v36 = ((zzwn)unsafe0.getObject(object0, v11)).zzd();
                        v3 += zzwu.zzz(v36) + v36 + zzwu.zzz(v7 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 62: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 = Z.z(zzyo.zzl(object0, v11), zzwu.zzz(v7 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 0x3F: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 += zzwu.zzA(zzyo.zzl(object0, v11)) + zzwu.zzz(v7 << 3);
                        break;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x40: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 = Z.z(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 65: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 = Z.z(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 66: {
                    if(this.zzC(object0, v7, v1)) {
                        int v43 = zzyo.zzl(object0, v11);
                        v3 = Z.z(v43 >> 0x1F ^ v43 + v43, zzwu.zzz(v7 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 67: {
                    if(this.zzC(object0, v7, v1)) {
                        long v44 = zzyo.zzp(object0, v11);
                        v3 += zzwu.zzA(v44 >> 0x3F ^ v44 + v44) + zzwu.zzz(v7 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 68: {
                    if(this.zzC(object0, v7, v1)) {
                        v3 += zzwu.zzw(v7, ((zzyl)unsafe0.getObject(object0, v11)), this.zzq(v1));
                    }
                    break;
                }
                default: {
                    v1 += 3;
                    continue;
                }
            }
            v1 += 3;
        }
        int v45 = ((zzxi)object0).zzc.zza() + v3;
        if(this.zzf) {
            zzzd zzzd0 = ((zzxg)object0).zzb.zza;
            int v46 = zzzd0.zzc();
            int v47 = 0;
            for(int v = 0; v < v46; ++v) {
                Map.Entry map$Entry0 = zzzd0.zzg(v);
                v47 += zzxb.zzb(((zzxa)((zzyz)map$Entry0).zza()), map$Entry0.getValue());
            }
            for(Object object9: zzzd0.zzd()) {
                v47 += zzxb.zzb(((zzxa)((Map.Entry)object9).getKey()), ((Map.Entry)object9).getValue());
            }
            return v45 + v47;
        }
        return v45;
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final int zzb(Object object0) {
        int v10;
        int v9;
        int v8;
        long v7;
        int v6;
        int v1 = 0;
        for(int v = 0; true; v += 3) {
            int[] arr_v = this.zzc;
            if(v >= arr_v.length) {
                break;
            }
            int v2 = this.zzo(v);
            int v3 = arr_v[v];
            long v4 = (long)(0xFFFFF & v2);
            int v5 = 37;
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    v6 = v1 * 53;
                    v7 = Double.doubleToLongBits(zzzo.zza(object0, v4));
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 1: {
                    v9 = v1 * 53;
                    v10 = Float.floatToIntBits(zzzo.zzb(object0, v4));
                    v1 = v10 + v9;
                    break;
                }
                case 2: {
                    v6 = v1 * 53;
                    v7 = zzzo.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 3: {
                    v6 = v1 * 53;
                    v7 = zzzo.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 4: {
                    v6 = v1 * 53;
                    v8 = zzzo.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 5: {
                    v6 = v1 * 53;
                    v7 = zzzo.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 6: {
                    v6 = v1 * 53;
                    v8 = zzzo.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 7: {
                    v9 = v1 * 53;
                    v10 = zzxo.zza(zzzo.zzw(object0, v4));
                    v1 = v10 + v9;
                    break;
                }
                case 8: {
                    v9 = v1 * 53;
                    v10 = ((String)zzzo.zzf(object0, v4)).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 9: {
                    Object object1 = zzzo.zzf(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 10: {
                    v9 = v1 * 53;
                    v10 = zzzo.zzf(object0, v4).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 11: {
                    v6 = v1 * 53;
                    v8 = zzzo.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 12: {
                    v6 = v1 * 53;
                    v8 = zzzo.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 13: {
                    v1 = v1 * 53 + zzzo.zzc(object0, v4);
                    break;
                }
                case 14: {
                    v7 = zzzo.zzd(object0, v4);
                    v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    break;
                }
                case 15: {
                    v1 = v1 * 53 + zzzo.zzc(object0, v4);
                    break;
                }
                case 16: {
                    v7 = zzzo.zzd(object0, v4);
                    v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    break;
                }
                case 17: {
                    Object object2 = zzzo.zzf(object0, v4);
                    if(object2 != null) {
                        v5 = object2.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    v9 = v1 * 53;
                    v10 = zzzo.zzf(object0, v4).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 50: {
                    v1 = zzzo.zzf(object0, v4).hashCode() + v1 * 53;
                    break;
                }
                case 51: {
                    if(this.zzC(object0, v3, v)) {
                        v7 = Double.doubleToLongBits(zzyo.zzj(object0, v4));
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 52: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = Float.floatToIntBits(zzyo.zzk(object0, v4)) + v1 * 53;
                    }
                    break;
                }
                case 53: {
                    if(this.zzC(object0, v3, v)) {
                        v7 = zzyo.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 54: {
                    if(this.zzC(object0, v3, v)) {
                        v7 = zzyo.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 55: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = v1 * 53 + zzyo.zzl(object0, v4);
                    }
                    break;
                }
                case 56: {
                    if(this.zzC(object0, v3, v)) {
                        v7 = zzyo.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 57: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = v1 * 53 + zzyo.zzl(object0, v4);
                    }
                    break;
                }
                case 58: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = zzxo.zza(zzyo.zzD(object0, v4)) + v1 * 53;
                    }
                    break;
                }
                case 59: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = ((String)zzzo.zzf(object0, v4)).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 60: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = zzzo.zzf(object0, v4).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 61: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = zzzo.zzf(object0, v4).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 62: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = v1 * 53 + zzyo.zzl(object0, v4);
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = v1 * 53 + zzyo.zzl(object0, v4);
                    }
                    break;
                }
                case 0x40: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = v1 * 53 + zzyo.zzl(object0, v4);
                    }
                    break;
                }
                case 65: {
                    if(this.zzC(object0, v3, v)) {
                        v7 = zzyo.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 66: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = v1 * 53 + zzyo.zzl(object0, v4);
                    }
                    break;
                }
                case 67: {
                    if(this.zzC(object0, v3, v)) {
                        v7 = zzyo.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 68: {
                    if(this.zzC(object0, v3, v)) {
                        v1 = zzzo.zzf(object0, v4).hashCode() + v1 * 53;
                    }
                }
            }
        }
        int v11 = 0x7BC6F + v1 * 53;
        return this.zzf ? v11 * 53 + ((zzxg)object0).zzb.zza.hashCode() : v11;
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final Object zzc() {
        return ((zzxi)this.zze).zzA();
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final void zzd(Object object0) {
        if(zzyo.zzB(object0)) {
            if(object0 instanceof zzxi) {
                ((zzxi)object0).zzK(0x7FFFFFFF);
                ((zzxi)object0).zza = 0;
                ((zzxi)object0).zzI();
            }
            int[] arr_v = this.zzc;
            for(int v = 0; v < arr_v.length; v += 3) {
                int v1 = this.zzo(v);
                long v2 = (long)(0xFFFFF & v1);
                switch(v1 >>> 20 & 0xFF) {
                    case 9: 
                    case 17: {
                        if(this.zzy(object0, v)) {
                            this.zzq(v).zzd(zzyo.zzb.getObject(object0, v2));
                        }
                        break;
                    }
                    case 18: 
                    case 19: 
                    case 20: 
                    case 21: 
                    case 22: 
                    case 23: 
                    case 24: 
                    case 25: 
                    case 26: 
                    case 27: 
                    case 28: 
                    case 29: 
                    case 30: 
                    case 0x1F: 
                    case 0x20: 
                    case 33: 
                    case 34: 
                    case 35: 
                    case 36: 
                    case 37: 
                    case 38: 
                    case 39: 
                    case 40: 
                    case 41: 
                    case 42: 
                    case 43: 
                    case 44: 
                    case 45: 
                    case 46: 
                    case 0x2F: 
                    case 0x30: 
                    case 49: {
                        ((zzxn)zzzo.zzf(object0, v2)).zzb();
                        break;
                    }
                    case 50: {
                        Unsafe unsafe0 = zzyo.zzb;
                        Object object1 = unsafe0.getObject(object0, v2);
                        if(object1 != null) {
                            ((zzyf)object1).zzb();
                            unsafe0.putObject(object0, v2, object1);
                        }
                        break;
                    }
                    case 60: 
                    case 68: {
                        if(this.zzC(object0, arr_v[v], v)) {
                            this.zzq(v).zzd(zzyo.zzb.getObject(object0, v2));
                        }
                    }
                }
            }
            this.zzi.zza(object0);
            if(this.zzf) {
                this.zzj.zza(object0);
            }
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final void zze(Object object0, Object object1) {
        if(!zzyo.zzB(object0)) {
            throw new IllegalArgumentException("Mutating immutable message: " + object0);
        }
        object1.getClass();
        for(int v = 0; true; v += 3) {
            int[] arr_v = this.zzc;
            if(v >= arr_v.length) {
                break;
            }
            int v1 = this.zzo(v);
            int v2 = arr_v[v];
            long v3 = (long)(0xFFFFF & v1);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzo(object0, v3, zzzo.zza(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 1: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzp(object0, v3, zzzo.zzb(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 2: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzr(object0, v3, zzzo.zzd(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 3: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzr(object0, v3, zzzo.zzd(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 4: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzq(object0, v3, zzzo.zzc(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 5: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzr(object0, v3, zzzo.zzd(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 6: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzq(object0, v3, zzzo.zzc(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 7: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzm(object0, v3, zzzo.zzw(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 8: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzs(object0, v3, zzzo.zzf(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 9: {
                    this.zzt(object0, object1, v);
                    break;
                }
                case 10: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzs(object0, v3, zzzo.zzf(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 11: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzq(object0, v3, zzzo.zzc(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 12: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzq(object0, v3, zzzo.zzc(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 13: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzq(object0, v3, zzzo.zzc(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 14: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzr(object0, v3, zzzo.zzd(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 15: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzq(object0, v3, zzzo.zzc(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 16: {
                    if(this.zzy(object1, v)) {
                        zzzo.zzr(object0, v3, zzzo.zzd(object1, v3));
                        this.zzv(object0, v);
                    }
                    break;
                }
                case 17: {
                    this.zzt(object0, object1, v);
                    break;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    zzxn zzxn0 = (zzxn)zzzo.zzf(object0, v3);
                    zzxn zzxn1 = (zzxn)zzzo.zzf(object1, v3);
                    int v4 = zzxn0.size();
                    int v5 = zzxn1.size();
                    if(v4 > 0 && v5 > 0) {
                        if(!zzxn0.zzc()) {
                            zzxn0 = zzxn0.zzd(v5 + v4);
                        }
                        zzxn0.addAll(zzxn1);
                    }
                    if(v4 > 0) {
                        zzxn1 = zzxn0;
                    }
                    zzzo.zzs(object0, v3, zzxn1);
                    break;
                }
                case 50: {
                    Object object2 = zzzo.zzf(object0, v3);
                    Object object3 = zzzo.zzf(object1, v3);
                    zzyf zzyf0 = (zzyf)object2;
                    zzyf zzyf1 = (zzyf)object3;
                    if(!zzyf1.isEmpty()) {
                        if(!zzyf0.zzd()) {
                            zzyf0 = zzyf0.zza();
                        }
                        zzyf0.zzc(zzyf1);
                    }
                    zzzo.zzs(object0, v3, zzyf0);
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: {
                    if(this.zzC(object1, v2, v)) {
                        zzzo.zzs(object0, v3, zzzo.zzf(object1, v3));
                        this.zzw(object0, v2, v);
                    }
                    break;
                }
                case 60: {
                    this.zzu(object0, object1, v);
                    break;
                }
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: {
                    if(this.zzC(object1, v2, v)) {
                        zzzo.zzs(object0, v3, zzzo.zzf(object1, v3));
                        this.zzw(object0, v2, v);
                    }
                    break;
                }
                case 68: {
                    this.zzu(object0, object1, v);
                }
            }
        }
        zzyx.zzo(this.zzi, object0, object1);
        if(this.zzf) {
            zzyx.zzn(this.zzj, object0, object1);
        }
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final void zzf(Object object0, zzzt zzzt0) {
        int v9;
        int v8;
        Map.Entry map$Entry0;
        if(this.zzf) {
            zzxb zzxb0 = ((zzxg)object0).zzb;
            if(zzxb0.zza.isEmpty()) {
                map$Entry0 = null;
            }
            else {
                Object object1 = zzxb0.zze().next();
                map$Entry0 = (Map.Entry)object1;
            }
        }
        else {
            map$Entry0 = null;
        }
        int[] arr_v = this.zzc;
        Unsafe unsafe0 = zzyo.zzb;
        int v = 0xFFFFF;
        int v1 = 0;
        int v2 = 0;
        while(v1 < arr_v.length) {
            int v3 = this.zzo(v1);
            int v4 = v3 >>> 20 & 0xFF;
            int v5 = arr_v[v1];
            if(v4 <= 17) {
                int v6 = arr_v[v1 + 2];
                int v7 = v6 & 0xFFFFF;
                if(v7 != v) {
                    v2 = v7 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v7));
                    v = v7;
                }
                v8 = v3;
                v9 = 1 << (v6 >>> 20);
            }
            else {
                v8 = v3;
                v9 = 0;
            }
            if(map$Entry0 == null) {
                long v10 = (long)(v8 & 0xFFFFF);
                switch(v4) {
                    case 0: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzf(v5, zzzo.zza(object0, v10));
                        }
                        break;
                    }
                    case 1: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzn(v5, zzzo.zzb(object0, v10));
                        }
                        break;
                    }
                    case 2: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzs(v5, unsafe0.getLong(object0, v10));
                        }
                        break;
                    }
                    case 3: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzI(v5, unsafe0.getLong(object0, v10));
                        }
                        break;
                    }
                    case 4: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzq(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 5: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzl(v5, unsafe0.getLong(object0, v10));
                        }
                        break;
                    }
                    case 6: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzj(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 7: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzb(v5, zzzo.zzw(object0, v10));
                        }
                        break;
                    }
                    case 8: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzyo.zzE(v5, unsafe0.getObject(object0, v10), zzzt0);
                        }
                        break;
                    }
                    case 9: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzu(v5, unsafe0.getObject(object0, v10), this.zzq(v1));
                        }
                        break;
                    }
                    case 10: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzd(v5, ((zzwn)unsafe0.getObject(object0, v10)));
                        }
                        break;
                    }
                    case 11: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzG(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 12: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzh(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 13: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzw(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 14: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzy(v5, unsafe0.getLong(object0, v10));
                        }
                        break;
                    }
                    case 15: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzA(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 16: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzC(v5, unsafe0.getLong(object0, v10));
                        }
                        break;
                    }
                    case 17: {
                        if(this.zzz(object0, v1, v, v2, v9)) {
                            zzzt0.zzp(v5, unsafe0.getObject(object0, v10), this.zzq(v1));
                        }
                        break;
                    }
                    case 18: {
                        zzyx.zzq(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 19: {
                        zzyx.zzu(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 20: {
                        zzyx.zzw(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 21: {
                        zzyx.zzC(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 22: {
                        zzyx.zzv(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 23: {
                        zzyx.zzt(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 24: {
                        zzyx.zzs(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 25: {
                        zzyx.zzp(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 26: {
                        int v11 = arr_v[v1];
                        List list0 = (List)unsafe0.getObject(object0, v10);
                        if(list0 != null && !list0.isEmpty()) {
                            zzzt0.zzF(v11, list0);
                        }
                        break;
                    }
                    case 27: {
                        int v12 = arr_v[v1];
                        List list1 = (List)unsafe0.getObject(object0, v10);
                        zzyv zzyv0 = this.zzq(v1);
                        if(list1 != null && !list1.isEmpty()) {
                            for(int v13 = 0; v13 < list1.size(); ++v13) {
                                ((zzwv)zzzt0).zzu(v12, list1.get(v13), zzyv0);
                            }
                        }
                        break;
                    }
                    case 28: {
                        int v14 = arr_v[v1];
                        List list2 = (List)unsafe0.getObject(object0, v10);
                        if(list2 != null && !list2.isEmpty()) {
                            zzzt0.zze(v14, list2);
                        }
                        break;
                    }
                    case 29: {
                        zzyx.zzB(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 30: {
                        zzyx.zzr(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 0x1F: {
                        zzyx.zzx(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 0x20: {
                        zzyx.zzy(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 33: {
                        zzyx.zzz(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 34: {
                        zzyx.zzA(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, false);
                        break;
                    }
                    case 35: {
                        zzyx.zzq(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 36: {
                        zzyx.zzu(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 37: {
                        zzyx.zzw(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 38: {
                        zzyx.zzC(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 39: {
                        zzyx.zzv(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 40: {
                        zzyx.zzt(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 41: {
                        zzyx.zzs(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 42: {
                        zzyx.zzp(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 43: {
                        zzyx.zzB(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 44: {
                        zzyx.zzr(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 45: {
                        zzyx.zzx(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 46: {
                        zzyx.zzy(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 0x2F: {
                        zzyx.zzz(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 0x30: {
                        zzyx.zzA(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzzt0, true);
                        break;
                    }
                    case 49: {
                        int v15 = arr_v[v1];
                        List list3 = (List)unsafe0.getObject(object0, v10);
                        zzyv zzyv1 = this.zzq(v1);
                        if(list3 != null && !list3.isEmpty()) {
                            for(int v16 = 0; v16 < list3.size(); ++v16) {
                                ((zzwv)zzzt0).zzp(v15, list3.get(v16), zzyv1);
                            }
                        }
                        break;
                    }
                    case 50: {
                        if(unsafe0.getObject(object0, v10) != null) {
                            zzye zzye0 = (zzye)this.zzr(v1);
                            throw null;
                        }
                        break;
                    }
                    case 51: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzf(v5, zzyo.zzj(object0, v10));
                        }
                        break;
                    }
                    case 52: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzn(v5, zzyo.zzk(object0, v10));
                        }
                        break;
                    }
                    case 53: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzs(v5, zzyo.zzp(object0, v10));
                        }
                        break;
                    }
                    case 54: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzI(v5, zzyo.zzp(object0, v10));
                        }
                        break;
                    }
                    case 55: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzq(v5, zzyo.zzl(object0, v10));
                        }
                        break;
                    }
                    case 56: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzl(v5, zzyo.zzp(object0, v10));
                        }
                        break;
                    }
                    case 57: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzj(v5, zzyo.zzl(object0, v10));
                        }
                        break;
                    }
                    case 58: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzb(v5, zzyo.zzD(object0, v10));
                        }
                        break;
                    }
                    case 59: {
                        if(this.zzC(object0, v5, v1)) {
                            zzyo.zzE(v5, unsafe0.getObject(object0, v10), zzzt0);
                        }
                        break;
                    }
                    case 60: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzu(v5, unsafe0.getObject(object0, v10), this.zzq(v1));
                        }
                        break;
                    }
                    case 61: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzd(v5, ((zzwn)unsafe0.getObject(object0, v10)));
                        }
                        break;
                    }
                    case 62: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzG(v5, zzyo.zzl(object0, v10));
                        }
                        break;
                    }
                    case 0x3F: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzh(v5, zzyo.zzl(object0, v10));
                        }
                        break;
                    }
                    case 0x40: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzw(v5, zzyo.zzl(object0, v10));
                        }
                        break;
                    }
                    case 65: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzy(v5, zzyo.zzp(object0, v10));
                        }
                        break;
                    }
                    case 66: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzA(v5, zzyo.zzl(object0, v10));
                        }
                        break;
                    }
                    case 67: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzC(v5, zzyo.zzp(object0, v10));
                        }
                        break;
                    }
                    case 68: {
                        if(this.zzC(object0, v5, v1)) {
                            zzzt0.zzp(v5, unsafe0.getObject(object0, v10), this.zzq(v1));
                        }
                    }
                }
                v1 += 3;
                continue;
            }
            zzxh zzxh0 = (zzxh)map$Entry0.getKey();
            throw null;
        }
        if(map$Entry0 == null) {
            zzxi zzxi0 = (zzxi)object0;
            return;
        }
        zzxh zzxh1 = (zzxh)map$Entry0.getKey();
        throw null;
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final boolean zzg(Object object0, Object object1) {
        boolean z;
        int v = 0;
        while(v < this.zzc.length) {
            int v1 = this.zzo(v);
            long v2 = (long)(v1 & 0xFFFFF);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.zzx(object0, object1, v) && Double.doubleToLongBits(zzzo.zza(object0, v2)) == Double.doubleToLongBits(zzzo.zza(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 1: {
                    if(this.zzx(object0, object1, v) && Float.floatToIntBits(zzzo.zzb(object0, v2)) == Float.floatToIntBits(zzzo.zzb(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 2: {
                    if(this.zzx(object0, object1, v) && zzzo.zzd(object0, v2) == zzzo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 3: {
                    if(this.zzx(object0, object1, v) && zzzo.zzd(object0, v2) == zzzo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 4: {
                    if(this.zzx(object0, object1, v) && zzzo.zzc(object0, v2) == zzzo.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 5: {
                    if(this.zzx(object0, object1, v) && zzzo.zzd(object0, v2) == zzzo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 6: {
                    if(this.zzx(object0, object1, v) && zzzo.zzc(object0, v2) == zzzo.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 7: {
                    if(this.zzx(object0, object1, v) && zzzo.zzw(object0, v2) == zzzo.zzw(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 8: {
                    if(this.zzx(object0, object1, v) && zzyx.zzD(zzzo.zzf(object0, v2), zzzo.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 9: {
                    if(this.zzx(object0, object1, v) && zzyx.zzD(zzzo.zzf(object0, v2), zzzo.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 10: {
                    if(this.zzx(object0, object1, v) && zzyx.zzD(zzzo.zzf(object0, v2), zzzo.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 11: {
                    if(this.zzx(object0, object1, v) && zzzo.zzc(object0, v2) == zzzo.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 12: {
                    if(this.zzx(object0, object1, v) && zzzo.zzc(object0, v2) == zzzo.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 13: {
                    if(this.zzx(object0, object1, v) && zzzo.zzc(object0, v2) == zzzo.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 14: {
                    if(this.zzx(object0, object1, v) && zzzo.zzd(object0, v2) == zzzo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 15: {
                    if(this.zzx(object0, object1, v) && zzzo.zzc(object0, v2) == zzzo.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 16: {
                    if(this.zzx(object0, object1, v) && zzzo.zzd(object0, v2) == zzzo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 17: {
                    if(this.zzx(object0, object1, v) && zzyx.zzD(zzzo.zzf(object0, v2), zzzo.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 18: 
                case 19: 
                case 20: 
                case 21: 
                case 22: 
                case 23: 
                case 24: 
                case 25: 
                case 26: 
                case 27: 
                case 28: 
                case 29: 
                case 30: 
                case 0x1F: 
                case 0x20: 
                case 33: 
                case 34: 
                case 35: 
                case 36: 
                case 37: 
                case 38: 
                case 39: 
                case 40: 
                case 41: 
                case 42: 
                case 43: 
                case 44: 
                case 45: 
                case 46: 
                case 0x2F: 
                case 0x30: 
                case 49: {
                    z = zzyx.zzD(zzzo.zzf(object0, v2), zzzo.zzf(object1, v2));
                    goto label_45;
                }
                case 50: {
                    z = zzyx.zzD(zzzo.zzf(object0, v2), zzzo.zzf(object1, v2));
                label_45:
                    if(!z) {
                        return false;
                    }
                    break;
                }
                case 51: 
                case 52: 
                case 53: 
                case 54: 
                case 55: 
                case 56: 
                case 57: 
                case 58: 
                case 59: 
                case 60: 
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: 
                case 68: {
                    int v3 = this.zzm(v);
                    if(zzzo.zzc(object0, ((long)(v3 & 0xFFFFF))) != zzzo.zzc(object1, ((long)(v3 & 0xFFFFF))) || !zzyx.zzD(zzzo.zzf(object0, v2), zzzo.zzf(object1, v2))) {
                        return false;
                    }
                }
            }
            v += 3;
        }
        if(!((zzxi)object0).zzc.equals(((zzxi)object1).zzc)) {
            return false;
        }
        return this.zzf ? ((zzxg)object0).zzb.equals(((zzxg)object1).zzb) : true;
    }

    @Override  // com.google.android.gms.internal.cast.zzyv
    public final boolean zzh(Object object0) {
        int v11;
        int v10;
        int v9;
        int v1 = 0;
        int v2 = 0xFFFFF;
        for(int v = 0; v1 < this.zzh; v = v10) {
            int v3 = this.zzg[v1];
            int v4 = this.zzc[v3];
            int v5 = this.zzo(v3);
            int v6 = this.zzc[v3 + 2];
            int v7 = v6 & 0xFFFFF;
            int v8 = 1 << (v6 >>> 20);
            if(v7 == v2) {
                v11 = v2;
                v9 = v3;
                v10 = v;
            }
            else {
                if(v7 != 0xFFFFF) {
                    v = zzyo.zzb.getInt(object0, ((long)v7));
                }
                v9 = v3;
                v10 = v;
                v11 = v7;
            }
            if((0x10000000 & v5) != 0 && !this.zzz(object0, v9, v11, v10, v8)) {
                return false;
            }
            switch(v5 >>> 20 & 0xFF) {
                case 9: 
                case 17: {
                    if(this.zzz(object0, v9, v11, v10, v8) && !zzyo.zzA(object0, v5, this.zzq(v9))) {
                        return false;
                    }
                    break;
                }
                case 27: 
                case 49: {
                    List list0 = (List)zzzo.zzf(object0, ((long)(v5 & 0xFFFFF)));
                    if(!list0.isEmpty()) {
                        zzyv zzyv0 = this.zzq(v9);
                        for(int v12 = 0; v12 < list0.size(); ++v12) {
                            if(!zzyv0.zzh(list0.get(v12))) {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 50: {
                    if(!((zzyf)zzzo.zzf(object0, ((long)(v5 & 0xFFFFF)))).isEmpty()) {
                        zzye zzye0 = (zzye)this.zzr(v9);
                        throw null;
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.zzC(object0, v4, v9) && !zzyo.zzA(object0, v5, this.zzq(v9))) {
                        return false;
                    }
                }
            }
            ++v1;
            v2 = v11;
        }
        return !this.zzf || ((zzxg)object0).zzb.zzh();
    }

    public static zzyo zzi(Class class0, zzyi zzyi0, zzyq zzyq0, zzxy zzxy0, zzzh zzzh0, zzwx zzwx0, zzyg zzyg0) {
        int v102;
        int v101;
        int v100;
        Field field3;
        int v98;
        int v97;
        int v90;
        int v88;
        Object[] arr_object2;
        int v87;
        int v86;
        int v85;
        int v84;
        int v83;
        int v82;
        Field field1;
        Field field0;
        int v79;
        int v77;
        int v70;
        zzyu zzyu1;
        int v69;
        int v64;
        int v14;
        int[] arr_v;
        int v13;
        int v12;
        int v11;
        int v10;
        int v9;
        int v8;
        int v2;
        if(zzyi0 instanceof zzyu) {
            zzyu zzyu0 = (zzyu)zzyi0;
            String s = zzyu0.zzd();
            int v = s.length();
            if(s.charAt(0) >= 0xD800) {
                for(int v1 = 1; true; v1 = v2) {
                    v2 = v1 + 1;
                    if(s.charAt(v1) < 0xD800) {
                        break;
                    }
                }
            }
            else {
                v2 = 1;
            }
            int v3 = v2 + 1;
            int v4 = s.charAt(v2);
            if(v4 >= 0xD800) {
                int v5 = v4 & 0x1FFF;
                int v6 = 13;
                int v7;
                while((v7 = s.charAt(v3)) >= 0xD800) {
                    v5 |= (v7 & 0x1FFF) << v6;
                    v6 += 13;
                    ++v3;
                }
                v4 = v5 | v7 << v6;
                ++v3;
            }
            if(v4 == 0) {
                v8 = 0;
                v9 = 0;
                v10 = 0;
                v11 = 0;
                v12 = 0;
                v13 = 0;
                arr_v = zzyo.zza;
                v14 = 0;
            }
            else {
                int v15 = v3 + 1;
                int v16 = s.charAt(v3);
                if(v16 >= 0xD800) {
                    int v17 = v16 & 0x1FFF;
                    int v18 = 13;
                    int v19;
                    while((v19 = s.charAt(v15)) >= 0xD800) {
                        v17 |= (v19 & 0x1FFF) << v18;
                        v18 += 13;
                        ++v15;
                    }
                    v16 = v17 | v19 << v18;
                    ++v15;
                }
                int v20 = v15 + 1;
                int v21 = s.charAt(v15);
                if(v21 >= 0xD800) {
                    int v22 = v21 & 0x1FFF;
                    int v23 = 13;
                    int v24;
                    while((v24 = s.charAt(v20)) >= 0xD800) {
                        v22 |= (v24 & 0x1FFF) << v23;
                        v23 += 13;
                        ++v20;
                    }
                    v21 = v22 | v24 << v23;
                    ++v20;
                }
                int v25 = v20 + 1;
                int v26 = s.charAt(v20);
                if(v26 >= 0xD800) {
                    int v27 = v26 & 0x1FFF;
                    int v28 = 13;
                    int v29;
                    while((v29 = s.charAt(v25)) >= 0xD800) {
                        v27 |= (v29 & 0x1FFF) << v28;
                        v28 += 13;
                        ++v25;
                    }
                    v26 = v27 | v29 << v28;
                    ++v25;
                }
                int v30 = v25 + 1;
                int v31 = s.charAt(v25);
                if(v31 >= 0xD800) {
                    int v32 = v31 & 0x1FFF;
                    int v33 = 13;
                    int v34;
                    while((v34 = s.charAt(v30)) >= 0xD800) {
                        v32 |= (v34 & 0x1FFF) << v33;
                        v33 += 13;
                        ++v30;
                    }
                    v31 = v32 | v34 << v33;
                    ++v30;
                }
                int v35 = v30 + 1;
                v10 = s.charAt(v30);
                if(v10 >= 0xD800) {
                    int v36 = v10 & 0x1FFF;
                    int v37 = 13;
                    int v38;
                    while((v38 = s.charAt(v35)) >= 0xD800) {
                        v36 |= (v38 & 0x1FFF) << v37;
                        v37 += 13;
                        ++v35;
                    }
                    v10 = v36 | v38 << v37;
                    ++v35;
                }
                int v39 = v35 + 1;
                int v40 = s.charAt(v35);
                if(v40 >= 0xD800) {
                    int v41 = v40 & 0x1FFF;
                    int v42 = 13;
                    int v43;
                    while((v43 = s.charAt(v39)) >= 0xD800) {
                        v41 |= (v43 & 0x1FFF) << v42;
                        v42 += 13;
                        ++v39;
                    }
                    v40 = v41 | v43 << v42;
                    ++v39;
                }
                int v44 = v39 + 1;
                int v45 = s.charAt(v39);
                if(v45 >= 0xD800) {
                    int v46 = v45 & 0x1FFF;
                    int v47 = 13;
                    int v48;
                    while((v48 = s.charAt(v44)) >= 0xD800) {
                        v46 |= (v48 & 0x1FFF) << v47;
                        v47 += 13;
                        ++v44;
                    }
                    v45 = v46 | v48 << v47;
                    ++v44;
                }
                int v49 = v44 + 1;
                int v50 = s.charAt(v44);
                if(v50 >= 0xD800) {
                    int v51 = v50 & 0x1FFF;
                    int v52 = 13;
                    int v53;
                    while((v53 = s.charAt(v49)) >= 0xD800) {
                        v51 |= (v53 & 0x1FFF) << v52;
                        v52 += 13;
                        ++v49;
                    }
                    v50 = v51 | v53 << v52;
                    ++v49;
                }
                v11 = v26;
                v8 = v40;
                v12 = v31;
                v13 = v50;
                v9 = v16 * 2 + v21;
                arr_v = new int[v50 + v40 + v45];
                v14 = v16;
                v3 = v49;
            }
            Unsafe unsafe0 = zzyo.zzb;
            Object[] arr_object = zzyu0.zze();
            Class class1 = zzyu0.zza().getClass();
            int v54 = v13 + v8;
            int[] arr_v1 = new int[v10 * 3];
            Object[] arr_object1 = new Object[v10 + v10];
            int v55 = v13;
            int v56 = v54;
            int v57 = 0;
            int v58 = 0;
            while(v3 < v) {
                int v59 = s.charAt(v3);
                if(v59 >= 0xD800) {
                    int v60 = v59 & 0x1FFF;
                    int v61 = v3 + 1;
                    int v62 = 13;
                    int v63;
                    while((v63 = s.charAt(v61)) >= 0xD800) {
                        v60 |= (v63 & 0x1FFF) << v62;
                        v62 += 13;
                        ++v61;
                    }
                    v59 = v60 | v63 << v62;
                    v64 = v61 + 1;
                }
                else {
                    v64 = v3 + 1;
                }
                int v65 = s.charAt(v64);
                if(v65 >= 0xD800) {
                    int v66 = v65 & 0x1FFF;
                    int v67 = v64 + 1;
                    int v68 = 13;
                    while(true) {
                        v69 = s.charAt(v67);
                        zzyu1 = zzyu0;
                        if(v69 < 0xD800) {
                            break;
                        }
                        v66 |= (v69 & 0x1FFF) << v68;
                        v68 += 13;
                        ++v67;
                        zzyu0 = zzyu1;
                    }
                    v65 = v66 | v69 << v68;
                    v70 = v67 + 1;
                }
                else {
                    zzyu1 = zzyu0;
                    v70 = v64 + 1;
                }
                if((v65 & 0x400) != 0) {
                    arr_v[v58] = v57;
                    ++v58;
                }
                int v71 = v65 & 0x800;
                if((v65 & 0xFF) >= 51) {
                    int v72 = s.charAt(v70);
                    if(v72 >= 0xD800) {
                        int v73 = v72 & 0x1FFF;
                        int v74 = v70 + 1;
                        int v75 = 13;
                        int v76;
                        while((v76 = s.charAt(v74)) >= 0xD800) {
                            v73 |= (v76 & 0x1FFF) << v75;
                            v75 += 13;
                            ++v74;
                        }
                        v72 = v73 | v76 << v75;
                        v77 = v74 + 1;
                    }
                    else {
                        v77 = v70 + 1;
                    }
                    int v78 = (v65 & 0xFF) - 51;
                    if(v78 == 9 || v78 == 17) {
                        arr_object1[v57 / 3 * 2 + 1] = arr_object[v9];
                        v79 = v71;
                        ++v9;
                    }
                    else {
                        if(v78 == 12) {
                            if(zzyu1.zzc() == 1 || v71 != 0) {
                                arr_object1[v57 / 3 * 2 + 1] = arr_object[v9];
                                ++v9;
                            }
                            else {
                                v79 = 0;
                                goto label_223;
                            }
                        }
                        v79 = v71;
                    }
                label_223:
                    int v80 = v72 + v72;
                    Object object0 = arr_object[v80];
                    if(object0 instanceof Field) {
                        field0 = (Field)object0;
                    }
                    else {
                        field0 = zzyo.zzs(class1, ((String)object0));
                        arr_object[v80] = field0;
                    }
                    int v81 = (int)unsafe0.objectFieldOffset(field0);
                    Object object1 = arr_object[v80 + 1];
                    if(object1 instanceof Field) {
                        field1 = (Field)object1;
                    }
                    else {
                        field1 = zzyo.zzs(class1, ((String)object1));
                        arr_object[v80 + 1] = field1;
                    }
                    v82 = v14;
                    v83 = v9;
                    v84 = v57;
                    v85 = (int)unsafe0.objectFieldOffset(field1);
                    v86 = v81;
                    v71 = v79;
                    v87 = v59;
                    v3 = v77;
                    arr_object2 = arr_object1;
                    v88 = 0;
                }
                else {
                    int v89 = v9 + 1;
                    arr_object2 = arr_object1;
                    Field field2 = zzyo.zzs(class1, ((String)arr_object[v9]));
                    v87 = v59;
                    switch(v65 & 0xFF) {
                        case 9: 
                        case 17: {
                            v82 = v14;
                            arr_object2[v57 / 3 * 2 + 1] = field2.getType();
                            v84 = v57;
                            break;
                        }
                        case 27: {
                            v82 = v14;
                            v90 = v9 + 2;
                            arr_object2[v57 / 3 * 2 + 1] = arr_object[v89];
                            v89 = v90;
                            v84 = v57;
                            break;
                        }
                        case 12: 
                        case 30: 
                        case 44: {
                            v82 = v14;
                            if(zzyu1.zzc() == 1 || v71 != 0) {
                                v90 = v9 + 2;
                                arr_object2[v57 / 3 * 2 + 1] = arr_object[v89];
                                v89 = v90;
                                v84 = v57;
                            }
                            else {
                                v84 = v57;
                                v71 = 0;
                            }
                            break;
                        }
                        case 49: {
                            v82 = v14;
                            arr_object2[v57 / 3 * 2 + 1] = arr_object[v89];
                            v89 = v9 + 2;
                            v84 = v57;
                            break;
                        }
                        case 50: {
                            arr_v[v55] = v57;
                            int v91 = v57 / 3 + v57 / 3;
                            arr_object2[v91] = arr_object[v89];
                            if(v71 == 0) {
                                v89 = v9 + 2;
                                v84 = v57;
                                ++v55;
                                v71 = 0;
                            }
                            else {
                                v89 = v9 + 3;
                                arr_object2[v91 + 1] = arr_object[v9 + 2];
                                v84 = v57;
                                ++v55;
                            }
                            v82 = v14;
                            break;
                        }
                        default: {
                            v82 = v14;
                            v84 = v57;
                            break;
                        }
                    }
                    int v92 = (int)unsafe0.objectFieldOffset(field2);
                    v85 = 0xFFFFF;
                    if((v65 & 0x1000) == 0 || (v65 & 0xFF) > 17) {
                        v100 = v89;
                        v102 = v70;
                        v101 = 0;
                    }
                    else {
                        int v93 = v70 + 1;
                        int v94 = s.charAt(v70);
                        if(v94 >= 0xD800) {
                            int v95 = v94 & 0x1FFF;
                            int v96 = 13;
                            while(true) {
                                v97 = v93 + 1;
                                v98 = s.charAt(v93);
                                if(v98 < 0xD800) {
                                    break;
                                }
                                v95 |= (v98 & 0x1FFF) << v96;
                                v96 += 13;
                                v93 = v97;
                            }
                            v94 = v95 | v98 << v96;
                        }
                        else {
                            v97 = v93;
                        }
                        int v99 = v94 / 0x20 + v82 * 2;
                        Object object2 = arr_object[v99];
                        if(object2 instanceof Field) {
                            field3 = (Field)object2;
                        }
                        else {
                            field3 = zzyo.zzs(class1, ((String)object2));
                            arr_object[v99] = field3;
                        }
                        v100 = v89;
                        v101 = v94 % 0x20;
                        v85 = (int)unsafe0.objectFieldOffset(field3);
                        v102 = v97;
                    }
                    if((v65 & 0xFF) < 18 || (v65 & 0xFF) > 49) {
                        v88 = v101;
                        v86 = v92;
                        v83 = v100;
                        v3 = v102;
                    }
                    else {
                        arr_v[v56] = v92;
                        v88 = v101;
                        v86 = v92;
                        v83 = v100;
                        v3 = v102;
                        ++v56;
                    }
                }
                arr_v1[v84] = v87;
                arr_v1[v84 + 1] = ((v65 & 0x200) == 0 ? 0 : 0x20000000) | ((v65 & 0x100) == 0 ? 0 : 0x10000000) | (v71 == 0 ? 0 : 0x80000000) | (v65 & 0xFF) << 20 | v86;
                arr_v1[v84 + 2] = v88 << 20 | v85;
                v57 = v84 + 3;
                v9 = v83;
                zzyu0 = zzyu1;
                v14 = v82;
                arr_object1 = arr_object2;
            }
            return new zzyo(arr_v1, arr_object1, v11, v12, zzyu0.zza(), false, arr_v, v13, v54, zzyq0, zzxy0, zzzh0, zzwx0, zzyg0);
        }
        zzze zzze0 = (zzze)zzyi0;
        throw null;
    }

    private static double zzj(Object object0, long v) {
        return (double)(((Double)zzzo.zzf(object0, v)));
    }

    private static float zzk(Object object0, long v) {
        return (float)(((Float)zzzo.zzf(object0, v)));
    }

    private static int zzl(Object object0, long v) {
        return (int)(((Integer)zzzo.zzf(object0, v)));
    }

    private final int zzm(int v) {
        return this.zzc[v + 2];
    }

    private static int zzn(int v) [...] // Inlined contents

    private final int zzo(int v) {
        return this.zzc[v + 1];
    }

    private static long zzp(Object object0, long v) {
        return (long)(((Long)zzzo.zzf(object0, v)));
    }

    private final zzyv zzq(int v) {
        Object[] arr_object = this.zzd;
        int v1 = v / 3 + v / 3;
        zzyv zzyv0 = (zzyv)arr_object[v1];
        if(zzyv0 != null) {
            return zzyv0;
        }
        zzyv zzyv1 = zzys.zza().zzb(((Class)arr_object[v1 + 1]));
        arr_object[v1] = zzyv1;
        return zzyv1;
    }

    private final Object zzr(int v) {
        return this.zzd[v / 3 + v / 3];
    }

    private static Field zzs(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(NoSuchFieldException noSuchFieldException0) {
            Field[] arr_field = class0.getDeclaredFields();
            for(int v = 0; v < arr_field.length; ++v) {
                Field field0 = arr_field[v];
                if(s.equals(field0.getName())) {
                    return field0;
                }
            }
            String s1 = Arrays.toString(arr_field);
            StringBuilder stringBuilder0 = d.o("Field ", s, " for ", class0.getName(), " not found. Known fields are ");
            stringBuilder0.append(s1);
            throw new RuntimeException(stringBuilder0.toString(), noSuchFieldException0);
        }
    }

    private final void zzt(Object object0, Object object1, int v) {
        if(!this.zzy(object1, v)) {
            return;
        }
        int v1 = this.zzo(v);
        Unsafe unsafe0 = zzyo.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException(b.f(this.zzc[v], "Source subfield ", " is present but null: ", object1.toString()));
        }
        zzyv zzyv0 = this.zzq(v);
        if(!this.zzy(object0, v)) {
            if(zzyo.zzB(object2)) {
                Object object3 = zzyv0.zzc();
                zzyv0.zze(object3, object2);
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object2);
            }
            this.zzv(object0, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(!zzyo.zzB(object4)) {
            Object object5 = zzyv0.zzc();
            zzyv0.zze(object5, object4);
            unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zzyv0.zze(object4, object2);
    }

    private final void zzu(Object object0, Object object1, int v) {
        int[] arr_v = this.zzc;
        int v1 = arr_v[v];
        if(!this.zzC(object1, v1, v)) {
            return;
        }
        int v2 = this.zzo(v);
        Unsafe unsafe0 = zzyo.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v2 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException(b.f(arr_v[v], "Source subfield ", " is present but null: ", object1.toString()));
        }
        zzyv zzyv0 = this.zzq(v);
        if(!this.zzC(object0, v1, v)) {
            if(zzyo.zzB(object2)) {
                Object object3 = zzyv0.zzc();
                zzyv0.zze(object3, object2);
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object2);
            }
            this.zzw(object0, v1, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(!zzyo.zzB(object4)) {
            Object object5 = zzyv0.zzc();
            zzyv0.zze(object5, object4);
            unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zzyv0.zze(object4, object2);
    }

    private final void zzv(Object object0, int v) {
        int v1 = this.zzm(v);
        if(((long)(0xFFFFF & v1)) == 0xFFFFFL) {
            return;
        }
        zzzo.zzq(object0, ((long)(0xFFFFF & v1)), 1 << (v1 >>> 20) | zzzo.zzc(object0, ((long)(0xFFFFF & v1))));
    }

    private final void zzw(Object object0, int v, int v1) {
        zzzo.zzq(object0, ((long)(this.zzm(v1) & 0xFFFFF)), v);
    }

    private final boolean zzx(Object object0, Object object1, int v) {
        return this.zzy(object0, v) == this.zzy(object1, v);
    }

    private final boolean zzy(Object object0, int v) {
        int v1 = this.zzm(v);
        if(Long.compare(v1 & 0xFFFFF, 0xFFFFFL) == 0) {
            int v2 = this.zzo(v);
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    return Double.doubleToRawLongBits(zzzo.zza(object0, ((long)(v2 & 0xFFFFF)))) != 0L;
                }
                case 1: {
                    return Float.floatToRawIntBits(zzzo.zzb(object0, ((long)(v2 & 0xFFFFF)))) != 0;
                }
                case 2: {
                    return zzzo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 3: {
                    return zzzo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 4: {
                    return zzzo.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 5: {
                    return zzzo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 6: {
                    return zzzo.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 7: {
                    return zzzo.zzw(object0, ((long)(v2 & 0xFFFFF)));
                }
                case 8: {
                    Object object1 = zzzo.zzf(object0, ((long)(v2 & 0xFFFFF)));
                    if(object1 instanceof String) {
                        return !((String)object1).isEmpty();
                    }
                    if(!(object1 instanceof zzwn)) {
                        throw new IllegalArgumentException();
                    }
                    return !zzwn.zzb.equals(object1);
                }
                case 9: {
                    return zzzo.zzf(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                case 10: {
                    Object object2 = zzzo.zzf(object0, ((long)(v2 & 0xFFFFF)));
                    return !zzwn.zzb.equals(object2);
                }
                case 11: {
                    return zzzo.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 12: {
                    return zzzo.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 13: {
                    return zzzo.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 14: {
                    return zzzo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 15: {
                    return zzzo.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 16: {
                    return zzzo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 17: {
                    return zzzo.zzf(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        return (zzzo.zzc(object0, ((long)(v1 & 0xFFFFF))) & 1 << (v1 >>> 20)) != 0;
    }

    private final boolean zzz(Object object0, int v, int v1, int v2, int v3) {
        return v1 == 0xFFFFF ? this.zzy(object0, v) : (v2 & v3) != 0;
    }
}

