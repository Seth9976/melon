package com.google.android.gms.internal.auth;

import A7.d;
import H0.b;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import sun.misc.Unsafe;

final class zzga implements zzgi {
    private static final int[] zza;
    private static final Unsafe zzb;
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzfx zzg;
    private final int[] zzh;
    private final int zzi;
    private final int zzj;
    private final zzfl zzk;
    private final zzgz zzl;
    private final zzem zzm;
    private final zzgc zzn;
    private final zzfs zzo;

    static {
        zzga.zza = new int[0];
        zzga.zzb = zzhj.zzg();
    }

    private zzga(int[] arr_v, Object[] arr_object, int v, int v1, zzfx zzfx0, int v2, boolean z, int[] arr_v1, int v3, int v4, zzgc zzgc0, zzfl zzfl0, zzgz zzgz0, zzem zzem0, zzfs zzfs0) {
        this.zzc = arr_v;
        this.zzd = arr_object;
        this.zze = v;
        this.zzf = v1;
        this.zzh = arr_v1;
        this.zzi = v3;
        this.zzj = v4;
        this.zzn = zzgc0;
        this.zzk = zzfl0;
        this.zzl = zzgz0;
        this.zzm = zzem0;
        this.zzg = zzfx0;
        this.zzo = zzfs0;
    }

    private final void zzA(Object object0, int v, int v1) {
        zzhj.zzn(object0, ((long)(this.zzl(v1) & 0xFFFFF)), v);
    }

    private final void zzB(Object object0, int v, Object object1) {
        int v1 = this.zzo(v);
        zzga.zzb.putObject(object0, ((long)(v1 & 0xFFFFF)), object1);
        this.zzz(object0, v);
    }

    private final void zzC(Object object0, int v, int v1, Object object1) {
        int v2 = this.zzo(v1);
        zzga.zzb.putObject(object0, ((long)(v2 & 0xFFFFF)), object1);
        this.zzA(object0, v, v1);
    }

    private final boolean zzD(Object object0, Object object1, int v) {
        return this.zzE(object0, v) == this.zzE(object1, v);
    }

    private final boolean zzE(Object object0, int v) {
        int v1 = this.zzl(v);
        if(Long.compare(v1 & 0xFFFFF, 0xFFFFFL) == 0) {
            int v2 = this.zzo(v);
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    return Double.doubleToRawLongBits(zzhj.zza(object0, ((long)(v2 & 0xFFFFF)))) != 0L;
                }
                case 1: {
                    return Float.floatToRawIntBits(zzhj.zzb(object0, ((long)(v2 & 0xFFFFF)))) != 0;
                }
                case 2: {
                    return zzhj.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 3: {
                    return zzhj.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 4: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 5: {
                    return zzhj.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 6: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 7: {
                    return zzhj.zzt(object0, ((long)(v2 & 0xFFFFF)));
                }
                case 8: {
                    Object object1 = zzhj.zzf(object0, ((long)(v2 & 0xFFFFF)));
                    if(object1 instanceof String) {
                        return !((String)object1).isEmpty();
                    }
                    if(!(object1 instanceof zzef)) {
                        throw new IllegalArgumentException();
                    }
                    return !zzef.zzb.equals(object1);
                }
                case 9: {
                    return zzhj.zzf(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                case 10: {
                    Object object2 = zzhj.zzf(object0, ((long)(v2 & 0xFFFFF)));
                    return !zzef.zzb.equals(object2);
                }
                case 11: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 12: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 13: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 14: {
                    return zzhj.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 15: {
                    return zzhj.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 16: {
                    return zzhj.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 17: {
                    return zzhj.zzf(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        return (zzhj.zzc(object0, ((long)(v1 & 0xFFFFF))) & 1 << (v1 >>> 20)) != 0;
    }

    private final boolean zzF(Object object0, int v, int v1, int v2, int v3) {
        return v1 == 0xFFFFF ? this.zzE(object0, v) : (v2 & v3) != 0;
    }

    private static boolean zzG(Object object0, int v, zzgi zzgi0) {
        return zzgi0.zzi(zzhj.zzf(object0, ((long)(v & 0xFFFFF))));
    }

    private static boolean zzH(Object object0) {
        if(object0 == null) {
            return false;
        }
        return object0 instanceof zzev ? ((zzev)object0).zzm() : true;
    }

    private final boolean zzI(Object object0, int v, int v1) {
        return zzhj.zzc(object0, ((long)(this.zzl(v1) & 0xFFFFF))) == v;
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final int zza(Object object0) {
        int v10;
        int v9;
        int v8;
        long v7;
        int v6;
        int v1 = 0;
        for(int v = 0; v < this.zzc.length; v += 3) {
            int v2 = this.zzo(v);
            int v3 = this.zzc[v];
            long v4 = (long)(0xFFFFF & v2);
            int v5 = 37;
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    v6 = v1 * 53;
                    v7 = Double.doubleToLongBits(zzhj.zza(object0, v4));
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 1: {
                    v9 = v1 * 53;
                    v10 = Float.floatToIntBits(zzhj.zzb(object0, v4));
                    v1 = v10 + v9;
                    break;
                }
                case 2: {
                    v6 = v1 * 53;
                    v7 = zzhj.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 3: {
                    v6 = v1 * 53;
                    v7 = zzhj.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 4: {
                    v6 = v1 * 53;
                    v8 = zzhj.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 5: {
                    v6 = v1 * 53;
                    v7 = zzhj.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 6: {
                    v6 = v1 * 53;
                    v8 = zzhj.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 7: {
                    v9 = v1 * 53;
                    v10 = zzfa.zza(zzhj.zzt(object0, v4));
                    v1 = v10 + v9;
                    break;
                }
                case 8: {
                    v9 = v1 * 53;
                    v10 = ((String)zzhj.zzf(object0, v4)).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 9: {
                    Object object1 = zzhj.zzf(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 10: {
                    v9 = v1 * 53;
                    v10 = zzhj.zzf(object0, v4).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 11: {
                    v6 = v1 * 53;
                    v8 = zzhj.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 12: {
                    v6 = v1 * 53;
                    v8 = zzhj.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 13: {
                    v1 = v1 * 53 + zzhj.zzc(object0, v4);
                    break;
                }
                case 14: {
                    v7 = zzhj.zzd(object0, v4);
                    v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    break;
                }
                case 15: {
                    v1 = v1 * 53 + zzhj.zzc(object0, v4);
                    break;
                }
                case 16: {
                    v7 = zzhj.zzd(object0, v4);
                    v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    break;
                }
                case 17: {
                    Object object2 = zzhj.zzf(object0, v4);
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
                    v10 = zzhj.zzf(object0, v4).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 50: {
                    v1 = zzhj.zzf(object0, v4).hashCode() + v1 * 53;
                    break;
                }
                case 51: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = Double.doubleToLongBits(((double)(((Double)zzhj.zzf(object0, v4)))));
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 52: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = Float.floatToIntBits(((float)(((Float)zzhj.zzf(object0, v4))))) + v1 * 53;
                    }
                    break;
                }
                case 53: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = zzga.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 54: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = zzga.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 55: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 56: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = zzga.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 57: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 58: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = zzfa.zza(((Boolean)zzhj.zzf(object0, v4)).booleanValue()) + v1 * 53;
                    }
                    break;
                }
                case 59: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = ((String)zzhj.zzf(object0, v4)).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 60: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = zzhj.zzf(object0, v4).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 61: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = zzhj.zzf(object0, v4).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 62: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 0x40: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 65: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = zzga.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 66: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = v1 * 53 + zzga.zzk(object0, v4);
                    }
                    break;
                }
                case 67: {
                    if(this.zzI(object0, v3, v)) {
                        v7 = zzga.zzp(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 68: {
                    if(this.zzI(object0, v3, v)) {
                        v1 = zzhj.zzf(object0, v4).hashCode() + v1 * 53;
                    }
                }
            }
        }
        return this.zzl.zzb(object0).hashCode() + v1 * 53;
    }

    public final int zzb(Object object0, byte[] arr_b, int v, int v1, int v2, zzdt zzdt0) {
        int v106;
        int v105;
        int v112;
        int v108;
        int v107;
        int v62;
        int v61;
        int v60;
        int v99;
        int v98;
        int v97;
        int v96;
        int v92;
        int v90;
        zzez zzez5;
        int v89;
        int v72;
        int v71;
        int v63;
        int v85;
        int v54;
        int v53;
        int v52;
        int v31;
        int v30;
        Object object4;
        Unsafe unsafe2;
        int v29;
        int v34;
        Object object5;
        Unsafe unsafe3;
        int v48;
        int v46;
        int v45;
        int v36;
        int v35;
        int v32;
        int v27;
        int v26;
        int v25;
        Object object2;
        Unsafe unsafe1;
        int v16;
        int v15;
        int v14;
        int v13;
        byte[] arr_b2;
        int v12;
        Object object1 = object0;
        byte[] arr_b1 = arr_b;
        zzga.zzw(object1);
        Unsafe unsafe0 = zzga.zzb;
        int v3 = v;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v7 = -1;
        int v8 = 0xFFFFF;
        while(true) {
            if(v3 >= v1) {
                v15 = v5;
                unsafe1 = unsafe0;
                break;
            }
            int v9 = v3 + 1;
            int v10 = arr_b1[v3];
            if(v10 < 0) {
                v9 = zzdu.zzi(v10, arr_b1, v9, zzdt0);
                v10 = zzdt0.zza;
            }
            v6 = v10;
            int v11 = v6 >>> 3;
            if(v11 <= v7) {
                if(v11 >= this.zze && v11 <= this.zzf) {
                    v12 = this.zzm(v11, 0);
                }
            }
            else if(v11 >= this.zze && v11 <= this.zzf) {
                v12 = this.zzm(v11, v4 / 3);
            }
            else {
                v12 = -1;
            }
            if(v12 == -1) {
                arr_b2 = arr_b1;
                v13 = v11;
                v14 = v9;
                v4 = 0;
                v15 = v5;
                v16 = v6;
                unsafe1 = unsafe0;
                object2 = object1;
            }
            else {
                int v17 = 10;
                int v18 = v6 & 7;
                int[] arr_v = this.zzc;
                int v19 = arr_v[v12 + 1];
                int v20 = v19 >>> 20 & 0xFF;
                long v21 = (long)(v19 & 0xFFFFF);
                if(v20 <= 17) {
                    int v22 = arr_v[v12 + 2];
                    int v23 = 1 << (v22 >>> 20);
                    int v24 = v22 & 0xFFFFF;
                    if(v24 == v8) {
                        v25 = v9;
                        v27 = v5;
                        v26 = v8;
                    }
                    else {
                        v25 = v9;
                        if(v8 != 0xFFFFF) {
                            unsafe0.putInt(object1, ((long)v8), v5);
                        }
                        v26 = v24;
                        v27 = v24 == 0xFFFFF ? 0 : unsafe0.getInt(object1, ((long)v24));
                    }
                    switch(v20) {
                        case 0: {
                        label_73:
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v32 = v23;
                            v31 = v25;
                            v30 = v12;
                            arr_b2 = arr_b;
                            if(v18 == 1) {
                                zzhj.zzl(object4, v21, Double.longBitsToDouble(zzdu.zzn(arr_b2, v31)));
                                v3 = v31 + 8;
                                v29 = v27 | v32;
                                object1 = object4;
                                unsafe0 = unsafe2;
                                v8 = v26;
                                v4 = v30;
                                v5 = v29;
                                arr_b1 = arr_b2;
                                v7 = v11;
                                continue;
                            }
                            break;
                        }
                        case 1: {
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v32 = v23;
                            v31 = v25;
                            v30 = v12;
                            arr_b2 = arr_b;
                            if(v18 == 5) {
                                zzhj.zzm(object4, v21, Float.intBitsToFloat(zzdu.zzb(arr_b2, v31)));
                                v3 = v31 + 4;
                                v29 = v27 | v32;
                                object1 = object4;
                                unsafe0 = unsafe2;
                                v8 = v26;
                                v4 = v30;
                                v5 = v29;
                                arr_b1 = arr_b2;
                                v7 = v11;
                                continue;
                            }
                            break;
                        }
                        case 2: 
                        case 3: {
                            v31 = v25;
                            v30 = v12;
                            arr_b2 = arr_b;
                            if(v18 == 0) {
                                int v33 = zzdu.zzk(arr_b2, v31, zzdt0);
                                unsafe0.putLong(object1, v21, zzdt0.zzb);
                                v29 = v27 | v23;
                                v3 = v33;
                                v8 = v26;
                                v4 = v30;
                                v5 = v29;
                                arr_b1 = arr_b2;
                                v7 = v11;
                                continue;
                            }
                            else {
                                unsafe2 = unsafe0;
                                object4 = object1;
                                break;
                            }
                            goto label_108;
                        }
                        case 7: {
                            unsafe3 = unsafe0;
                            v35 = v23;
                            v30 = v12;
                            object5 = object1;
                            v34 = v25;
                            if(v18 == 0) {
                                v36 = zzdu.zzk(arr_b, v34, zzdt0);
                                zzhj.zzk(object5, v21, zzdt0.zzb != 0L);
                                goto label_235;
                            }
                            goto label_246;
                        }
                        case 8: {
                            unsafe3 = unsafe0;
                            v35 = v23;
                            object5 = object1;
                            v34 = v25;
                            if(v18 == 2) {
                                if((v19 & 0x20000000) == 0) {
                                    v30 = v12;
                                    v36 = zzdu.zzh(arr_b, v34, zzdt0);
                                    int v44 = zzdt0.zza;
                                    if(v44 >= 0) {
                                        if(v44 == 0) {
                                            zzdt0.zzc = "";
                                        }
                                        else {
                                            zzdt0.zzc = new String(arr_b, v36, v44, zzfa.zzb);
                                            v36 += v44;
                                        }
                                    label_234:
                                        unsafe3.putObject(object5, v21, zzdt0.zzc);
                                    label_235:
                                        arr_b1 = arr_b;
                                        unsafe0 = unsafe3;
                                        v8 = v26;
                                        v5 = v27 | v35;
                                        v3 = v36;
                                        object1 = object5;
                                        v4 = v30;
                                        v7 = v11;
                                        continue;
                                    }
                                }
                                else {
                                    v36 = zzdu.zzh(arr_b, v34, zzdt0);
                                    int v37 = zzdt0.zza;
                                    if(v37 >= 0) {
                                        if(v37 == 0) {
                                            zzdt0.zzc = "";
                                            v30 = v12;
                                        }
                                        else {
                                            if((arr_b.length - v36 - v37 | (v36 | v37)) < 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", ((int)arr_b.length), v36, v37));
                                            }
                                            int v38 = v36 + v37;
                                            char[] arr_c = new char[v37];
                                            int v39;
                                            for(v39 = 0; v36 < v38; ++v39) {
                                                int v40 = arr_b[v36];
                                                if(!zzhk.zzd(((byte)v40))) {
                                                    break;
                                                }
                                                ++v36;
                                                arr_c[v39] = (char)v40;
                                            }
                                        label_185:
                                            while(v36 < v38) {
                                                int v41 = arr_b[v36];
                                                if(zzhk.zzd(((byte)v41))) {
                                                    int v42 = v39 + 1;
                                                    arr_c[v39] = (char)v41;
                                                    ++v36;
                                                    while(true) {
                                                        v39 = v42;
                                                        if(v36 >= v38) {
                                                            continue label_185;
                                                        }
                                                        int v43 = arr_b[v36];
                                                        if(!zzhk.zzd(((byte)v43))) {
                                                            continue label_185;
                                                        }
                                                        ++v36;
                                                        v42 = v39 + 1;
                                                        arr_c[v39] = (char)v43;
                                                    }
                                                }
                                                if(v41 < 0xFFFFFFE0) {
                                                    if(v36 + 1 < v38) {
                                                        zzhk.zzc(((byte)v41), arr_b[v36 + 1], arr_c, v39);
                                                        v36 += 2;
                                                        ++v39;
                                                        continue;
                                                    }
                                                }
                                                else if(v41 >= -16) {
                                                    if(v36 + 1 < v38 - 2) {
                                                        zzhk.zza(((byte)v41), arr_b[v36 + 1], arr_b[v36 + 2], arr_b[v36 + 3], arr_c, v39);
                                                        v39 += 2;
                                                        v36 += 4;
                                                        continue;
                                                    }
                                                }
                                                else if(v36 + 1 < v38 - 1) {
                                                    zzhk.zzb(((byte)v41), arr_b[v36 + 1], arr_b[v36 + 2], arr_c, v39);
                                                    v36 += 3;
                                                    ++v39;
                                                    continue;
                                                }
                                                throw zzfb.zzb();
                                            }
                                            v30 = v12;
                                            zzdt0.zzc = new String(arr_c, 0, v39);
                                            v36 = v38;
                                        }
                                        goto label_234;
                                    }
                                }
                                throw zzfb.zzc();
                            }
                            else {
                                v30 = v12;
                            }
                        label_246:
                            arr_b2 = arr_b;
                            object4 = object5;
                            v31 = v34;
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 9: {
                            v45 = v12;
                            v46 = v25;
                            if(v18 == 2) {
                                Object object6 = this.zzt(object1, v45);
                                int v47 = zzdu.zzm(object6, this.zzr(v45), arr_b, v46, v1, zzdt0);
                                this.zzB(object1, v45, object6);
                                arr_b1 = arr_b;
                                v8 = v26;
                                v5 = v27 | v23;
                                v3 = v47;
                                v4 = v45;
                                v7 = v11;
                                continue;
                            }
                            else {
                                arr_b2 = arr_b;
                                object4 = object1;
                                unsafe2 = unsafe0;
                                v30 = v45;
                                v31 = v46;
                                break;
                            }
                            goto label_268;
                        }
                        case 10: {
                        label_268:
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v45 = v12;
                            v46 = v25;
                            arr_b2 = arr_b;
                            if(v18 == 2) {
                                v48 = zzdu.zza(arr_b2, v46, zzdt0);
                                unsafe2.putObject(object4, v21, zzdt0.zzc);
                                goto label_307;
                            }
                            v30 = v45;
                            v31 = v46;
                            break;
                        }
                        case 4: 
                        case 11: {
                        label_108:
                            v31 = v25;
                            v30 = v12;
                            arr_b2 = arr_b;
                            if(v18 == 0) {
                                v3 = zzdu.zzh(arr_b2, v31, zzdt0);
                                unsafe0.putInt(object1, v21, zzdt0.zza);
                                v29 = v27 | v23;
                                v8 = v26;
                                v4 = v30;
                                v5 = v29;
                                arr_b1 = arr_b2;
                                v7 = v11;
                                continue;
                            }
                            else {
                                unsafe2 = unsafe0;
                                object4 = object1;
                                break;
                            }
                            goto label_121;
                        }
                        case 12: {
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v45 = v12;
                            v46 = v25;
                            arr_b2 = arr_b;
                            if(v18 == 0) {
                                v48 = zzdu.zzh(arr_b2, v46, zzdt0);
                                int v49 = zzdt0.zza;
                                zzey zzey0 = this.zzq(v45);
                                if((v19 & 0x80000000) == 0 || zzey0 == null || zzey0.zza()) {
                                    unsafe2.putInt(object4, v21, v49);
                                    goto label_307;
                                }
                                else {
                                    zzga.zzc(object4).zzh(v6, ((long)v49));
                                    object1 = object4;
                                    unsafe0 = unsafe2;
                                    v3 = v48;
                                    arr_b1 = arr_b2;
                                    v4 = v45;
                                    v8 = v26;
                                    v7 = v11;
                                    v5 = v27;
                                    continue;
                                }
                                goto label_299;
                            }
                            v30 = v45;
                            v31 = v46;
                            break;
                        }
                        case 6: 
                        case 13: {
                        label_137:
                            unsafe3 = unsafe0;
                            v30 = v12;
                            object5 = object1;
                            v34 = v25;
                            if(v18 == 5) {
                                unsafe3.putInt(object5, v21, zzdu.zzb(arr_b, v34));
                                v3 = v34 + 4;
                                arr_b1 = arr_b;
                                unsafe0 = unsafe3;
                                v8 = v26;
                                v4 = v30;
                                v5 = v27 | v23;
                                object1 = object5;
                                v7 = v11;
                                continue;
                            }
                            goto label_246;
                        }
                        case 5: 
                        case 14: {
                        label_121:
                            v30 = v12;
                            if(v18 == 1) {
                                arr_b2 = arr_b;
                                unsafe0.putLong(object1, v21, zzdu.zzn(arr_b, v25));
                                v3 = v25 + 8;
                                v29 = v27 | v23;
                                v8 = v26;
                                v4 = v30;
                                v5 = v29;
                                arr_b1 = arr_b2;
                                v7 = v11;
                                continue;
                            }
                            else {
                                arr_b2 = arr_b;
                                v31 = v25;
                                unsafe2 = unsafe0;
                                object4 = object1;
                                break;
                            }
                            goto label_137;
                        }
                        case 15: {
                        label_299:
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v45 = v12;
                            v46 = v25;
                            arr_b2 = arr_b;
                            if(v18 == 0) {
                                v48 = zzdu.zzh(arr_b2, v46, zzdt0);
                                unsafe2.putInt(object4, v21, zzdt0.zza >>> 1 ^ -(zzdt0.zza & 1));
                            label_307:
                                object1 = object4;
                                unsafe0 = unsafe2;
                                v3 = v48;
                                arr_b1 = arr_b2;
                                v4 = v45;
                                v8 = v26;
                                v7 = v11;
                                v5 = v27 | v23;
                                continue;
                            }
                            v30 = v45;
                            v31 = v46;
                            break;
                        }
                        case 16: {
                            arr_b2 = arr_b;
                            if(v18 == 0) {
                                int v50 = zzdu.zzk(arr_b2, v25, zzdt0);
                                unsafe0.putLong(object1, v21, zzdt0.zzb >>> 1 ^ -(1L & zzdt0.zzb));
                                v3 = v50;
                                v4 = v12;
                                v8 = v26;
                                v5 = v27 | v23;
                                arr_b1 = arr_b2;
                                v7 = v11;
                                continue;
                            }
                            else {
                                unsafe2 = unsafe0;
                                object4 = object1;
                                v30 = v12;
                                v31 = v25;
                            }
                            break;
                        }
                        default: {
                            if(v18 == 3) {
                                Object object3 = this.zzt(object1, v12);
                                int v28 = zzdu.zzl(object3, this.zzr(v12), arr_b, v25, v1, v11 << 3 | 4, zzdt0);
                                arr_b2 = arr_b;
                                this.zzB(object1, v12, object3);
                                v29 = v27 | v23;
                                v3 = v28;
                                v4 = v12;
                                v8 = v26;
                                v5 = v29;
                                arr_b1 = arr_b2;
                                v7 = v11;
                                continue;
                            }
                            else {
                                unsafe2 = unsafe0;
                                object4 = object1;
                                v30 = v12;
                                v31 = v25;
                                arr_b2 = arr_b;
                                break;
                            }
                            goto label_73;
                        }
                    }
                    v14 = v31;
                    v8 = v26;
                    v16 = v6;
                    v4 = v30;
                    v13 = v11;
                    v15 = v27;
                    object2 = object4;
                    unsafe1 = unsafe2;
                }
                else if(v20 == 27) {
                    if(v18 == 2) {
                        zzez zzez0 = (zzez)unsafe0.getObject(object1, v21);
                        if(!zzez0.zzc()) {
                            int v51 = zzez0.size();
                            if(v51 != 0) {
                                v17 = v51 + v51;
                            }
                            zzez0 = zzez0.zzd(v17);
                            unsafe0.putObject(object1, v21, zzez0);
                        }
                        arr_b1 = arr_b;
                        v3 = zzdu.zze(this.zzr(v12), v6, arr_b, v9, v1, zzez0, zzdt0);
                        v4 = v12;
                        object1 = object0;
                        v7 = v11;
                        continue;
                    }
                    else {
                        object2 = object1;
                        v52 = v11;
                        v15 = v5;
                        v53 = v9;
                        unsafe1 = unsafe0;
                        v54 = v6;
                        goto label_827;
                    }
                    goto label_365;
                }
                else {
                label_365:
                    int v55 = v6;
                    object2 = object1;
                    if(v20 <= 49) {
                        Unsafe unsafe4 = zzga.zzb;
                        zzez zzez1 = (zzez)unsafe4.getObject(object2, v21);
                        if(!zzez1.zzc()) {
                            int v56 = zzez1.size();
                            if(v56 != 0) {
                                v17 = v56 + v56;
                            }
                            zzez1 = zzez1.zzd(v17);
                            unsafe4.putObject(object2, v21, zzez1);
                        }
                        zzez zzez2 = zzez1;
                        switch(v20) {
                            case 26: {
                                zzez zzez3 = zzez2;
                                v15 = v5;
                                arr_b1 = arr_b;
                                if(v18 == 2) {
                                    if((((long)v19) & 0x20000000L) == 0L) {
                                        v63 = zzdu.zzh(arr_b1, v9, zzdt0);
                                        int v79 = zzdt0.zza;
                                        if(v79 >= 0) {
                                            if(v79 == 0) {
                                                zzez3.add("");
                                                goto label_597;
                                            }
                                            else {
                                                zzez3.add(new String(arr_b1, v63, v79, zzfa.zzb));
                                            }
                                        alab1:
                                            while(true) {
                                                v63 += v79;
                                                while(true) {
                                                label_597:
                                                    if(v63 >= v1) {
                                                        goto label_635;
                                                    }
                                                    int v80 = zzdu.zzh(arr_b1, v63, zzdt0);
                                                    if(v55 != zzdt0.zza) {
                                                        goto label_635;
                                                    }
                                                    v63 = zzdu.zzh(arr_b1, v80, zzdt0);
                                                    v79 = zzdt0.zza;
                                                    if(v79 < 0) {
                                                        break alab1;
                                                    }
                                                    if(v79 != 0) {
                                                        zzez3.add(new String(arr_b1, v63, v79, zzfa.zzb));
                                                        break;
                                                    }
                                                    zzez3.add("");
                                                }
                                            }
                                            throw zzfb.zzc();
                                        }
                                    }
                                    else {
                                        v63 = zzdu.zzh(arr_b1, v9, zzdt0);
                                        int v81 = zzdt0.zza;
                                        if(v81 >= 0) {
                                            if(v81 == 0) {
                                                zzez3.add("");
                                                goto label_620;
                                            }
                                            else {
                                                int v82 = v63 + v81;
                                                if(!zzhn.zzc(arr_b1, v63, v82)) {
                                                    throw zzfb.zzb();
                                                }
                                                zzez3.add(new String(arr_b1, v63, v81, zzfa.zzb));
                                            alab2:
                                                while(true) {
                                                    v63 = v82;
                                                    while(true) {
                                                    label_620:
                                                        if(v63 >= v1) {
                                                            goto label_635;
                                                        }
                                                        int v83 = zzdu.zzh(arr_b1, v63, zzdt0);
                                                        if(v55 != zzdt0.zza) {
                                                            goto label_635;
                                                        }
                                                        v63 = zzdu.zzh(arr_b1, v83, zzdt0);
                                                        int v84 = zzdt0.zza;
                                                        if(v84 < 0) {
                                                            throw zzfb.zzc();
                                                        }
                                                        if(v84 != 0) {
                                                            v82 = v63 + v84;
                                                            if(!zzhn.zzc(arr_b1, v63, v82)) {
                                                                break alab2;
                                                            }
                                                            zzez3.add(new String(arr_b1, v63, v84, zzfa.zzb));
                                                            break;
                                                        }
                                                        zzez3.add("");
                                                    }
                                                }
                                                throw zzfb.zzb();
                                            label_635:
                                                v61 = v9;
                                                v60 = v11;
                                                v62 = v55;
                                                v3 = v63;
                                                break;
                                            }
                                        }
                                    }
                                    throw zzfb.zzc();
                                }
                                else {
                                    v61 = v9;
                                    v60 = v11;
                                    v62 = v55;
                                    v3 = v61;
                                    break;
                                }
                                goto label_646;
                            }
                            case 28: {
                            label_646:
                                v85 = v55;
                                zzez zzez4 = zzez2;
                                v15 = v5;
                                arr_b1 = arr_b;
                                if(v18 == 2) {
                                    int v86 = zzdu.zzh(arr_b1, v9, zzdt0);
                                    int v87 = zzdt0.zza;
                                    if(v87 < 0) {
                                        throw zzfb.zzc();
                                    }
                                    if(v87 > arr_b1.length - v86) {
                                        throw zzfb.zzf();
                                    }
                                    if(v87 == 0) {
                                        zzez4.add(zzef.zzb);
                                        goto label_660;
                                    }
                                    else {
                                        zzez4.add(zzef.zzk(arr_b1, v86, v87));
                                    }
                                alab3:
                                    while(true) {
                                        v86 += v87;
                                        while(true) {
                                        label_660:
                                            if(v86 >= v1) {
                                                goto label_674;
                                            }
                                            int v88 = zzdu.zzh(arr_b1, v86, zzdt0);
                                            if(v85 != zzdt0.zza) {
                                                goto label_674;
                                            }
                                            v86 = zzdu.zzh(arr_b1, v88, zzdt0);
                                            v87 = zzdt0.zza;
                                            if(v87 < 0) {
                                                throw zzfb.zzc();
                                            }
                                            if(v87 > arr_b1.length - v86) {
                                                break alab3;
                                            }
                                            if(v87 != 0) {
                                                zzez4.add(zzef.zzk(arr_b1, v86, v87));
                                                break;
                                            }
                                            zzez4.add(zzef.zzb);
                                        }
                                    }
                                    throw zzfb.zzf();
                                label_674:
                                    v3 = v86;
                                    v61 = v9;
                                    v60 = v11;
                                    v62 = v85;
                                }
                                else {
                                    v61 = v9;
                                    v60 = v11;
                                    v62 = v85;
                                    v3 = v61;
                                }
                                break;
                            }
                            case 18: 
                            case 35: {
                                v61 = v9;
                                v60 = v11;
                                v15 = v5;
                                arr_b1 = arr_b;
                                v62 = v55;
                                if(v18 == 2) {
                                    zzek zzek0 = (zzek)zzez2;
                                    v63 = zzdu.zzh(arr_b1, v61, zzdt0);
                                    int v64 = zzdt0.zza + v63;
                                    while(v63 < v64) {
                                        zzek0.zze(Double.longBitsToDouble(zzdu.zzn(arr_b1, v63)));
                                        v63 += 8;
                                    }
                                    if(v63 != v64) {
                                        throw zzfb.zzf();
                                    }
                                    v3 = v63;
                                    break;
                                }
                                else if(v18 == 1) {
                                    zzek zzek1 = (zzek)zzez2;
                                    zzek1.zze(Double.longBitsToDouble(zzdu.zzn(arr_b1, v61)));
                                    int v65;
                                    for(v65 = v61 + 8; v65 < v1; v65 = v66 + 8) {
                                        int v66 = zzdu.zzh(arr_b1, v65, zzdt0);
                                        if(v62 != zzdt0.zza) {
                                            break;
                                        }
                                        zzek1.zze(Double.longBitsToDouble(zzdu.zzn(arr_b1, v66)));
                                    }
                                    v3 = v65;
                                    break;
                                }
                                v3 = v61;
                                break;
                            }
                            case 19: 
                            case 36: {
                                v61 = v9;
                                v60 = v11;
                                v15 = v5;
                                arr_b1 = arr_b;
                                v62 = v55;
                                if(v18 == 2) {
                                    zzer zzer0 = (zzer)zzez2;
                                    v63 = zzdu.zzh(arr_b1, v61, zzdt0);
                                    int v67 = zzdt0.zza + v63;
                                    while(v63 < v67) {
                                        zzer0.zze(Float.intBitsToFloat(zzdu.zzb(arr_b1, v63)));
                                        v63 += 4;
                                    }
                                    if(v63 != v67) {
                                        throw zzfb.zzf();
                                    }
                                    v3 = v63;
                                    break;
                                }
                                else if(v18 == 5) {
                                    zzer zzer1 = (zzer)zzez2;
                                    zzer1.zze(Float.intBitsToFloat(zzdu.zzb(arr_b1, v61)));
                                    for(v65 = v61 + 4; v65 < v1; v65 = v68 + 4) {
                                        int v68 = zzdu.zzh(arr_b1, v65, zzdt0);
                                        if(v62 != zzdt0.zza) {
                                            break;
                                        }
                                        zzer1.zze(Float.intBitsToFloat(zzdu.zzb(arr_b1, v68)));
                                    }
                                    v3 = v65;
                                    break;
                                }
                                v3 = v61;
                                break;
                            }
                            case 20: 
                            case 21: 
                            case 37: 
                            case 38: {
                                v61 = v9;
                                v60 = v11;
                                v15 = v5;
                                arr_b1 = arr_b;
                                v62 = v55;
                                if(v18 == 2) {
                                    zzfm zzfm0 = (zzfm)zzez2;
                                    v63 = zzdu.zzh(arr_b1, v61, zzdt0);
                                    int v69 = zzdt0.zza + v63;
                                    while(v63 < v69) {
                                        v63 = zzdu.zzk(arr_b1, v63, zzdt0);
                                        zzfm0.zze(zzdt0.zzb);
                                    }
                                    if(v63 != v69) {
                                        throw zzfb.zzf();
                                    }
                                    v3 = v63;
                                    break;
                                }
                                else if(v18 == 0) {
                                    zzfm zzfm1 = (zzfm)zzez2;
                                    v63 = zzdu.zzk(arr_b1, v61, zzdt0);
                                    zzfm1.zze(zzdt0.zzb);
                                    while(v63 < v1) {
                                        int v70 = zzdu.zzh(arr_b1, v63, zzdt0);
                                        if(v62 != zzdt0.zza) {
                                            break;
                                        }
                                        v63 = zzdu.zzk(arr_b1, v70, zzdt0);
                                        zzfm1.zze(zzdt0.zzb);
                                    }
                                    v3 = v63;
                                    break;
                                }
                                v3 = v61;
                                break;
                            }
                            case 25: 
                            case 42: {
                                v15 = v5;
                                v71 = v9;
                                arr_b1 = arr_b;
                                if(v18 == 2) {
                                    zzdv zzdv0 = (zzdv)zzez2;
                                    v72 = zzdu.zzh(arr_b1, v71, zzdt0);
                                    int v77 = zzdt0.zza + v72;
                                    while(v72 < v77) {
                                        v72 = zzdu.zzk(arr_b1, v72, zzdt0);
                                        zzdv0.zze(zzdt0.zzb != 0L);
                                    }
                                    v60 = v11;
                                    if(v72 != v77) {
                                        throw zzfb.zzf();
                                    }
                                    goto label_576;
                                }
                                else {
                                    v60 = v11;
                                    if(v18 == 0) {
                                        zzdv zzdv1 = (zzdv)zzez2;
                                        v72 = zzdu.zzk(arr_b1, v71, zzdt0);
                                        zzdv1.zze(zzdt0.zzb != 0L);
                                        while(v72 < v1) {
                                            int v78 = zzdu.zzh(arr_b1, v72, zzdt0);
                                            if(v55 != zzdt0.zza) {
                                                break;
                                            }
                                            v72 = zzdu.zzk(arr_b1, v78, zzdt0);
                                            zzdv1.zze(zzdt0.zzb != 0L);
                                        }
                                    label_576:
                                        v61 = v71;
                                        v62 = v55;
                                        v3 = v72;
                                        break;
                                    }
                                }
                                v61 = v71;
                                v62 = v55;
                                v3 = v61;
                                break;
                            }
                            case 22: 
                            case 29: 
                            case 39: 
                            case 43: {
                                v60 = v11;
                                v15 = v5;
                                v71 = v9;
                                arr_b1 = arr_b;
                                if(v18 == 2) {
                                    v72 = zzdu.zzf(arr_b1, v71, zzez2, zzdt0);
                                    goto label_576;
                                }
                                else if(v18 == 0) {
                                    v3 = zzdu.zzj(v55, arr_b1, v71, v1, zzez2, zzdt0);
                                    v62 = v55;
                                    v61 = v71;
                                    break;
                                }
                                v61 = v71;
                                v62 = v55;
                                v3 = v61;
                                break;
                            }
                            case 30: 
                            case 44: {
                                v60 = v11;
                                arr_b1 = arr_b;
                                if(v18 == 2) {
                                    v89 = zzdu.zzf(arr_b1, v9, zzez2, zzdt0);
                                    v85 = v55;
                                    zzez5 = zzez2;
                                    v90 = v9;
                                    goto label_698;
                                }
                                else if(v18 == 0) {
                                    v85 = v55;
                                    zzez5 = zzez2;
                                    v89 = zzdu.zzj(v85, arr_b1, v9, v1, zzez5, zzdt0);
                                    v90 = v9;
                                label_698:
                                    zzey zzey1 = this.zzq(v12);
                                    zzgz zzgz0 = this.zzl;
                                    if(zzey1 == null) {
                                        v92 = v89;
                                        v15 = v5;
                                        v97 = v60;
                                    }
                                    else {
                                        if(zzez5 == null) {
                                            throw new NullPointerException();
                                        }
                                        int v91 = zzez5.size();
                                        zzey zzey2 = zzey1;
                                        v92 = v89;
                                        Object object7 = null;
                                        int v93 = 0;
                                        int v94 = 0;
                                        while(v94 < v91) {
                                            Integer integer0 = (Integer)zzez5.get(v94);
                                            int v95 = (int)integer0;
                                            if(zzey2.zza()) {
                                                if(v94 != v93) {
                                                    zzez5.set(v93, integer0);
                                                }
                                                ++v93;
                                                v96 = v60;
                                            }
                                            else {
                                                v96 = v60;
                                                object7 = zzgk.zzc(object2, v96, v95, object7, zzgz0);
                                            }
                                            ++v94;
                                            v60 = v96;
                                        }
                                        v15 = v5;
                                        v97 = v60;
                                        if(v93 != v91) {
                                            zzez5.subList(v93, v91).clear();
                                        }
                                    }
                                    v61 = v90;
                                    v60 = v97;
                                    v3 = v92;
                                    v62 = v85;
                                    break;
                                }
                                else {
                                    v15 = v5;
                                    v62 = v55;
                                    v61 = v9;
                                    v3 = v61;
                                    break;
                                }
                                goto label_740;
                            }
                            case 24: 
                            case 0x1F: 
                            case 41: 
                            case 45: {
                                v60 = v11;
                                v15 = v5;
                                v71 = v9;
                                arr_b1 = arr_b;
                                if(v18 == 2) {
                                    zzew zzew0 = (zzew)zzez2;
                                    v72 = zzdu.zzh(arr_b1, v71, zzdt0);
                                    int v75 = zzdt0.zza + v72;
                                    while(v72 < v75) {
                                        zzew0.zze(zzdu.zzb(arr_b1, v72));
                                        v72 += 4;
                                    }
                                    if(v72 != v75) {
                                        throw zzfb.zzf();
                                    }
                                    goto label_576;
                                }
                                else if(v18 == 5) {
                                    zzew zzew1 = (zzew)zzez2;
                                    zzew1.zze(zzdu.zzb(arr_b1, v71));
                                    for(v72 = v71 + 4; v72 < v1; v72 = v76 + 4) {
                                        int v76 = zzdu.zzh(arr_b1, v72, zzdt0);
                                        if(v55 != zzdt0.zza) {
                                            break;
                                        }
                                        zzew1.zze(zzdu.zzb(arr_b1, v76));
                                    }
                                    goto label_576;
                                }
                                v61 = v71;
                                v62 = v55;
                                v3 = v61;
                                break;
                            }
                            case 23: 
                            case 0x20: 
                            case 40: 
                            case 46: {
                                v60 = v11;
                                v15 = v5;
                                v71 = v9;
                                arr_b1 = arr_b;
                                if(v18 == 2) {
                                    zzfm zzfm2 = (zzfm)zzez2;
                                    v72 = zzdu.zzh(arr_b1, v71, zzdt0);
                                    int v73 = zzdt0.zza + v72;
                                    while(v72 < v73) {
                                        zzfm2.zze(zzdu.zzn(arr_b1, v72));
                                        v72 += 8;
                                    }
                                    if(v72 != v73) {
                                        throw zzfb.zzf();
                                    }
                                    goto label_576;
                                }
                                else if(v18 == 1) {
                                    zzfm zzfm3 = (zzfm)zzez2;
                                    zzfm3.zze(zzdu.zzn(arr_b1, v71));
                                    for(v72 = v71 + 8; v72 < v1; v72 = v74 + 8) {
                                        int v74 = zzdu.zzh(arr_b1, v72, zzdt0);
                                        if(v55 != zzdt0.zza) {
                                            break;
                                        }
                                        zzfm3.zze(zzdu.zzn(arr_b1, v74));
                                    }
                                    goto label_576;
                                }
                                v61 = v71;
                                v62 = v55;
                                v3 = v61;
                                break;
                            }
                            case 33: 
                            case 0x2F: {
                            label_740:
                                v98 = v9;
                                v60 = v11;
                                arr_b1 = arr_b;
                                if(v18 == 2) {
                                    zzew zzew2 = (zzew)zzez2;
                                    v99 = zzdu.zzh(arr_b1, v98, zzdt0);
                                    int v100 = zzdt0.zza + v99;
                                    while(v99 < v100) {
                                        v99 = zzdu.zzh(arr_b1, v99, zzdt0);
                                        zzew2.zze(zzdt0.zza >>> 1 ^ -(zzdt0.zza & 1));
                                    }
                                    if(v99 != v100) {
                                        throw zzfb.zzf();
                                    }
                                    goto label_788;
                                }
                                else if(v18 == 0) {
                                    zzew zzew3 = (zzew)zzez2;
                                    v99 = zzdu.zzh(arr_b1, v98, zzdt0);
                                    zzew3.zze(zzdt0.zza >>> 1 ^ -(zzdt0.zza & 1));
                                    while(v99 < v1) {
                                        int v101 = zzdu.zzh(arr_b1, v99, zzdt0);
                                        if(v55 != zzdt0.zza) {
                                            break;
                                        }
                                        v99 = zzdu.zzh(arr_b1, v101, zzdt0);
                                        zzew3.zze(zzdt0.zza >>> 1 ^ -(zzdt0.zza & 1));
                                    }
                                    goto label_788;
                                }
                                goto label_793;
                            }
                            case 34: 
                            case 0x30: {
                                v98 = v9;
                                arr_b1 = arr_b;
                                if(v18 == 2) {
                                    zzfm zzfm4 = (zzfm)zzez2;
                                    v99 = zzdu.zzh(arr_b1, v98, zzdt0);
                                    int v102 = zzdt0.zza + v99;
                                    while(v99 < v102) {
                                        v99 = zzdu.zzk(arr_b1, v99, zzdt0);
                                        zzfm4.zze(zzdt0.zzb >>> 1 ^ -(1L & zzdt0.zzb));
                                    }
                                    v60 = v11;
                                    if(v99 != v102) {
                                        throw zzfb.zzf();
                                    }
                                    goto label_788;
                                }
                                else {
                                    v60 = v11;
                                    if(v18 == 0) {
                                        zzfm zzfm5 = (zzfm)zzez2;
                                        v99 = zzdu.zzk(arr_b1, v98, zzdt0);
                                        zzfm5.zze(zzdt0.zzb >>> 1 ^ -(1L & zzdt0.zzb));
                                        while(v99 < v1) {
                                            int v103 = zzdu.zzh(arr_b1, v99, zzdt0);
                                            if(v55 != zzdt0.zza) {
                                                break;
                                            }
                                            v99 = zzdu.zzk(arr_b1, v103, zzdt0);
                                            zzfm5.zze(zzdt0.zzb >>> 1 ^ -(1L & zzdt0.zzb));
                                        }
                                    label_788:
                                        v3 = v99;
                                        v62 = v55;
                                        v61 = v98;
                                        v15 = v5;
                                        break;
                                    }
                                }
                            label_793:
                                v62 = v55;
                                v61 = v98;
                                v15 = v5;
                                v3 = v61;
                                break;
                            }
                            default: {
                                if(v18 == 3) {
                                    zzgi zzgi0 = this.zzr(v12);
                                    int v57 = v55 & -8 | 4;
                                    int v58 = zzdu.zzc(zzgi0, arr_b, v9, v1, v57, zzdt0);
                                    zzez2.add(zzdt0.zzc);
                                    while(v58 < v1) {
                                        int v59 = zzdu.zzh(arr_b, v58, zzdt0);
                                        if(v55 == zzdt0.zza) {
                                            v58 = zzdu.zzc(zzgi0, arr_b, v59, v1, v57, zzdt0);
                                            zzez2.add(zzdt0.zzc);
                                            continue;
                                        }
                                        arr_b1 = arr_b;
                                        goto label_392;
                                    }
                                    arr_b1 = arr_b;
                                label_392:
                                    v3 = v58;
                                    v60 = v11;
                                    v61 = v9;
                                    v15 = v5;
                                    v62 = v55;
                                }
                                else {
                                    v61 = v9;
                                    v60 = v11;
                                    v15 = v5;
                                    arr_b1 = arr_b;
                                    v62 = v55;
                                    v3 = v61;
                                }
                                break;
                            }
                        }
                        if(v3 == v61) {
                            arr_b2 = arr_b1;
                            v14 = v3;
                            v16 = v62;
                            v4 = v12;
                            v13 = v60;
                            unsafe1 = unsafe0;
                            goto label_1032;
                        }
                        else {
                            v4 = v12;
                            object1 = object2;
                            v7 = v60;
                            v5 = v15;
                            v6 = v62;
                            continue;
                        }
                        goto label_811;
                    }
                    else {
                    label_811:
                        v53 = v9;
                        v52 = v11;
                        v15 = v5;
                        unsafe1 = unsafe0;
                        v54 = v55;
                        if(v20 == 50) {
                            if(v18 == 2) {
                                Unsafe unsafe5 = zzga.zzb;
                                Object object8 = this.zzs(v12);
                                Object object9 = unsafe5.getObject(object2, v21);
                                if(!((zzfr)object9).zze()) {
                                    zzfr zzfr0 = zzfr.zza().zzb();
                                    zzfs.zza(zzfr0, object9);
                                    unsafe5.putObject(object2, v21, zzfr0);
                                }
                                zzfq zzfq0 = (zzfq)object8;
                                throw null;
                            }
                        label_827:
                            arr_b2 = arr_b;
                            v16 = v54;
                            v14 = v53;
                            v4 = v12;
                            v13 = v52;
                        }
                        else {
                            Unsafe unsafe6 = zzga.zzb;
                            long v104 = (long)(arr_v[v12 + 2] & 0xFFFFF);
                            switch(v20) {
                                case 51: {
                                    arr_b2 = arr_b;
                                    v16 = v54;
                                    v105 = v12;
                                    v13 = v52;
                                    v106 = v53;
                                    if(v18 == 1) {
                                        unsafe6.putObject(object2, v21, Double.longBitsToDouble(zzdu.zzn(arr_b2, v106)));
                                        v107 = v106 + 8;
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v107;
                                        break;
                                    }
                                    v3 = v106;
                                    break;
                                }
                                case 52: {
                                    arr_b2 = arr_b;
                                    v16 = v54;
                                    v105 = v12;
                                    v13 = v52;
                                    v106 = v53;
                                    if(v18 == 5) {
                                        unsafe6.putObject(object2, v21, Float.intBitsToFloat(zzdu.zzb(arr_b2, v106)));
                                        v107 = v106 + 4;
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v107;
                                        break;
                                    }
                                    v3 = v106;
                                    break;
                                }
                                case 53: 
                                case 54: {
                                    arr_b2 = arr_b;
                                    v16 = v54;
                                    v105 = v12;
                                    v13 = v52;
                                    v106 = v53;
                                    if(v18 == 0) {
                                        v108 = zzdu.zzk(arr_b2, v106, zzdt0);
                                        unsafe6.putObject(object2, v21, zzdt0.zzb);
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v108;
                                        break;
                                    }
                                    v3 = v106;
                                    break;
                                }
                                case 58: {
                                    arr_b2 = arr_b;
                                    v16 = v54;
                                    v105 = v12;
                                    v13 = v52;
                                    v106 = v53;
                                    if(v18 == 0) {
                                        v108 = zzdu.zzk(arr_b2, v106, zzdt0);
                                        unsafe6.putObject(object2, v21, Boolean.valueOf(zzdt0.zzb != 0L));
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v108;
                                        break;
                                    }
                                    v3 = v106;
                                    break;
                                }
                                case 59: {
                                    arr_b2 = arr_b;
                                    v105 = v12;
                                    v13 = v52;
                                    v16 = v54;
                                    v106 = v53;
                                    if(v18 == 2) {
                                        int v109 = zzdu.zzh(arr_b2, v106, zzdt0);
                                        int v110 = zzdt0.zza;
                                        if(v110 == 0) {
                                            unsafe6.putObject(object2, v21, "");
                                        }
                                        else {
                                            if((v19 & 0x20000000) != 0 && !zzhn.zzc(arr_b2, v109, v109 + v110)) {
                                                throw zzfb.zzb();
                                            }
                                            unsafe6.putObject(object2, v21, new String(arr_b2, v109, v110, zzfa.zzb));
                                            v109 += v110;
                                        }
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v109;
                                        break;
                                    }
                                    v3 = v106;
                                    break;
                                }
                                case 60: {
                                    arr_b2 = arr_b;
                                    v16 = v54;
                                    v13 = v52;
                                    if(v18 == 2) {
                                        Object object10 = this.zzu(object2, v13, v12);
                                        int v111 = zzdu.zzm(object10, this.zzr(v12), arr_b2, v53, v1, zzdt0);
                                        this.zzC(object2, v13, v12, object10);
                                        v3 = v111;
                                        v105 = v12;
                                        v106 = v53;
                                    }
                                    else {
                                        v105 = v12;
                                        v106 = v53;
                                        v3 = v106;
                                    }
                                    break;
                                }
                                case 61: {
                                    arr_b2 = arr_b;
                                    v16 = v54;
                                    v13 = v52;
                                    if(v18 == 2) {
                                        v112 = zzdu.zza(arr_b2, v53, zzdt0);
                                        unsafe6.putObject(object2, v21, zzdt0.zzc);
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v112;
                                        v105 = v12;
                                        v106 = v53;
                                        break;
                                    }
                                    v105 = v12;
                                    v106 = v53;
                                    v3 = v106;
                                    break;
                                }
                                case 55: 
                                case 62: {
                                    arr_b2 = arr_b;
                                    v16 = v54;
                                    v105 = v12;
                                    v13 = v52;
                                    v106 = v53;
                                    if(v18 == 0) {
                                        v108 = zzdu.zzh(arr_b2, v106, zzdt0);
                                        unsafe6.putObject(object2, v21, zzdt0.zza);
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v108;
                                        break;
                                    }
                                    v3 = v106;
                                    break;
                                }
                                case 0x3F: {
                                    arr_b2 = arr_b;
                                    v13 = v52;
                                    if(v18 == 0) {
                                        v112 = zzdu.zzh(arr_b2, v53, zzdt0);
                                        int v113 = zzdt0.zza;
                                        zzey zzey3 = this.zzq(v12);
                                        if(zzey3 != null && !zzey3.zza()) {
                                            v16 = v54;
                                            zzga.zzc(object2).zzh(v16, ((long)v113));
                                        }
                                        else {
                                            v16 = v54;
                                            unsafe6.putObject(object2, v21, v113);
                                            unsafe6.putInt(object2, v104, v13);
                                        }
                                        v3 = v112;
                                        v105 = v12;
                                        v106 = v53;
                                    }
                                    else {
                                        v16 = v54;
                                        v105 = v12;
                                        v106 = v53;
                                        v3 = v106;
                                    }
                                    break;
                                }
                                case 57: 
                                case 0x40: {
                                    arr_b2 = arr_b;
                                    v16 = v54;
                                    v105 = v12;
                                    v13 = v52;
                                    v106 = v53;
                                    if(v18 == 5) {
                                        unsafe6.putObject(object2, v21, zzdu.zzb(arr_b2, v106));
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v106 + 4;
                                        break;
                                    }
                                    v3 = v106;
                                    break;
                                }
                                case 56: 
                                case 65: {
                                    arr_b2 = arr_b;
                                    v16 = v54;
                                    v105 = v12;
                                    v13 = v52;
                                    v106 = v53;
                                    if(v18 == 1) {
                                        unsafe6.putObject(object2, v21, zzdu.zzn(arr_b2, v106));
                                        v107 = v106 + 8;
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v107;
                                        break;
                                    }
                                    v3 = v106;
                                    break;
                                }
                                case 66: {
                                    arr_b2 = arr_b;
                                    v13 = v52;
                                    if(v18 == 0) {
                                        int v114 = zzdu.zzh(arr_b2, v53, zzdt0);
                                        unsafe6.putObject(object2, v21, ((int)(zzdt0.zza >>> 1 ^ -(zzdt0.zza & 1))));
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v114;
                                        v16 = v54;
                                        v105 = v12;
                                        v106 = v53;
                                        break;
                                    }
                                    else {
                                        v16 = v54;
                                    }
                                    v105 = v12;
                                    v106 = v53;
                                    v3 = v106;
                                    break;
                                }
                                case 67: {
                                    arr_b2 = arr_b;
                                    v13 = v52;
                                    if(v18 == 0) {
                                        int v115 = zzdu.zzk(arr_b2, v53, zzdt0);
                                        unsafe6.putObject(object2, v21, ((long)(zzdt0.zzb >>> 1 ^ -(1L & zzdt0.zzb))));
                                        unsafe6.putInt(object2, v104, v13);
                                        v3 = v115;
                                        v16 = v54;
                                        v105 = v12;
                                        v106 = v53;
                                    }
                                    else {
                                        v16 = v54;
                                        v105 = v12;
                                        v106 = v53;
                                        v3 = v106;
                                    }
                                    break;
                                }
                                case 68: {
                                    if(v18 == 3) {
                                        v13 = v52;
                                        Object object11 = this.zzu(object2, v13, v12);
                                        int v116 = zzdu.zzl(object11, this.zzr(v12), arr_b, v53, v1, v54 & -8 | 4, zzdt0);
                                        arr_b2 = arr_b;
                                        this.zzC(object2, v13, v12, object11);
                                        v3 = v116;
                                        v16 = v54;
                                        v105 = v12;
                                        v106 = v53;
                                        break;
                                    }
                                    else {
                                        v13 = v52;
                                        arr_b2 = arr_b;
                                        v16 = v54;
                                        v105 = v12;
                                        v106 = v53;
                                    }
                                    v3 = v106;
                                    break;
                                }
                                default: {
                                    arr_b2 = arr_b;
                                    v16 = v54;
                                    v105 = v12;
                                    v13 = v52;
                                    v106 = v53;
                                    v3 = v106;
                                    break;
                                }
                            }
                            if(v3 == v106) {
                                v14 = v3;
                                v4 = v105;
                            }
                            else {
                                arr_b1 = arr_b2;
                                v7 = v13;
                                unsafe0 = unsafe1;
                                object1 = object2;
                                v4 = v105;
                                v5 = v15;
                                v6 = v16;
                                continue;
                            }
                        }
                    }
                }
            }
        label_1032:
            if(v16 != v2 || v2 == 0) {
                v3 = zzdu.zzg(v16, arr_b2, v14, v1, zzga.zzc(object2), zzdt0);
                arr_b1 = arr_b;
                v7 = v13;
                object1 = object2;
                v6 = v16;
                unsafe0 = unsafe1;
                v5 = v15;
                continue;
            }
            else {
                v3 = v14;
                object1 = object2;
                v6 = v16;
            }
            break;
        }
        if(v8 != 0xFFFFF) {
            unsafe1.putInt(object1, ((long)v8), v15);
        }
        int v117 = this.zzi;
        while(v117 < this.zzj) {
            int v118 = this.zzh[v117];
            int v119 = this.zzc[v118];
            Object object12 = zzhj.zzf(object1, ((long)(this.zzo(v118) & 0xFFFFF)));
            if(object12 == null || this.zzq(v118) == null) {
                ++v117;
                continue;
            }
            zzfr zzfr1 = (zzfr)object12;
            zzfq zzfq1 = (zzfq)this.zzs(v118);
            throw null;
        }
        if(v2 == 0) {
            if(v3 != v1) {
                throw zzfb.zzd();
            }
            return v3;
        }
        if(v3 > v1 || v6 != v2) {
            throw zzfb.zzd();
        }
        return v3;
    }

    public static zzha zzc(Object object0) {
        zzha zzha0 = ((zzev)object0).zzc;
        if(zzha0 == zzha.zza()) {
            zzha0 = zzha.zzd();
            ((zzev)object0).zzc = zzha0;
        }
        return zzha0;
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final Object zzd() {
        return ((zzev)this.zzg).zzc();
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final void zze(Object object0) {
        if(!zzga.zzH(object0)) {
            return;
        }
        if(object0 instanceof zzev) {
            ((zzev)object0).zzl(0x7FFFFFFF);
            ((zzev)object0).zza = 0;
            ((zzev)object0).zzj();
        }
        for(int v = 0; v < this.zzc.length; v += 3) {
            int v1 = this.zzo(v);
            long v2 = (long)(0xFFFFF & v1);
            switch(v1 >>> 20 & 0xFF) {
                case 9: 
                case 17: {
                    if(this.zzE(object0, v)) {
                        this.zzr(v).zze(zzga.zzb.getObject(object0, v2));
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
                    this.zzk.zza(object0, v2);
                    break;
                }
                case 50: {
                    Unsafe unsafe0 = zzga.zzb;
                    Object object1 = unsafe0.getObject(object0, v2);
                    if(object1 != null) {
                        ((zzfr)object1).zzc();
                        unsafe0.putObject(object0, v2, object1);
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.zzI(object0, this.zzc[v], v)) {
                        this.zzr(v).zze(zzga.zzb.getObject(object0, v2));
                    }
                }
            }
        }
        this.zzl.zze(object0);
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final void zzf(Object object0, Object object1) {
        zzga.zzw(object0);
        object1.getClass();
        for(int v = 0; v < this.zzc.length; v += 3) {
            int v1 = this.zzo(v);
            int v2 = this.zzc[v];
            long v3 = (long)(0xFFFFF & v1);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzl(object0, v3, zzhj.zza(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 1: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzm(object0, v3, zzhj.zzb(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 2: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzo(object0, v3, zzhj.zzd(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 3: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzo(object0, v3, zzhj.zzd(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 4: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 5: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzo(object0, v3, zzhj.zzd(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 6: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 7: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzk(object0, v3, zzhj.zzt(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 8: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzp(object0, v3, zzhj.zzf(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 9: {
                    this.zzx(object0, object1, v);
                    break;
                }
                case 10: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzp(object0, v3, zzhj.zzf(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 11: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 12: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 13: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 14: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzo(object0, v3, zzhj.zzd(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 15: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzn(object0, v3, zzhj.zzc(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 16: {
                    if(this.zzE(object1, v)) {
                        zzhj.zzo(object0, v3, zzhj.zzd(object1, v3));
                        this.zzz(object0, v);
                    }
                    break;
                }
                case 17: {
                    this.zzx(object0, object1, v);
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
                    this.zzk.zzb(object0, object1, v3);
                    break;
                }
                case 50: {
                    zzhj.zzp(object0, v3, zzfs.zza(zzhj.zzf(object0, v3), zzhj.zzf(object1, v3)));
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
                    if(this.zzI(object1, v2, v)) {
                        zzhj.zzp(object0, v3, zzhj.zzf(object1, v3));
                        this.zzA(object0, v2, v);
                    }
                    break;
                }
                case 60: {
                    this.zzy(object0, object1, v);
                    break;
                }
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: {
                    if(this.zzI(object1, v2, v)) {
                        zzhj.zzp(object0, v3, zzhj.zzf(object1, v3));
                        this.zzA(object0, v2, v);
                    }
                    break;
                }
                case 68: {
                    this.zzy(object0, object1, v);
                }
            }
        }
        zzgk.zzd(this.zzl, object0, object1);
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final void zzg(Object object0, byte[] arr_b, int v, int v1, zzdt zzdt0) {
        this.zzb(object0, arr_b, v, v1, 0, zzdt0);
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final boolean zzh(Object object0, Object object1) {
        boolean z;
        int v = 0;
        while(v < this.zzc.length) {
            int v1 = this.zzo(v);
            long v2 = (long)(v1 & 0xFFFFF);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.zzD(object0, object1, v) && Double.doubleToLongBits(zzhj.zza(object0, v2)) == Double.doubleToLongBits(zzhj.zza(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 1: {
                    if(this.zzD(object0, object1, v) && Float.floatToIntBits(zzhj.zzb(object0, v2)) == Float.floatToIntBits(zzhj.zzb(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 2: {
                    if(this.zzD(object0, object1, v) && zzhj.zzd(object0, v2) == zzhj.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 3: {
                    if(this.zzD(object0, object1, v) && zzhj.zzd(object0, v2) == zzhj.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 4: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 5: {
                    if(this.zzD(object0, object1, v) && zzhj.zzd(object0, v2) == zzhj.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 6: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 7: {
                    if(this.zzD(object0, object1, v) && zzhj.zzt(object0, v2) == zzhj.zzt(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 8: {
                    if(this.zzD(object0, object1, v) && zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 9: {
                    if(this.zzD(object0, object1, v) && zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 10: {
                    if(this.zzD(object0, object1, v) && zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 11: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 12: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 13: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 14: {
                    if(this.zzD(object0, object1, v) && zzhj.zzd(object0, v2) == zzhj.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 15: {
                    if(this.zzD(object0, object1, v) && zzhj.zzc(object0, v2) == zzhj.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 16: {
                    if(this.zzD(object0, object1, v) && zzhj.zzd(object0, v2) == zzhj.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 17: {
                    if(this.zzD(object0, object1, v) && zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2))) {
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
                    z = zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2));
                    goto label_45;
                }
                case 50: {
                    z = zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2));
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
                    int v3 = this.zzl(v);
                    if(zzhj.zzc(object0, ((long)(v3 & 0xFFFFF))) != zzhj.zzc(object1, ((long)(v3 & 0xFFFFF))) || !zzgk.zzf(zzhj.zzf(object0, v2), zzhj.zzf(object1, v2))) {
                        return false;
                    }
                }
            }
            v += 3;
        }
        return this.zzl.zzb(object0).equals(this.zzl.zzb(object1));
    }

    @Override  // com.google.android.gms.internal.auth.zzgi
    public final boolean zzi(Object object0) {
        int v10;
        int v9;
        int v = 0;
        int v2 = 0xFFFFF;
        for(int v1 = 0; v < this.zzi; v1 = v9) {
            int v3 = this.zzh[v];
            int v4 = this.zzc[v3];
            int v5 = this.zzo(v3);
            int v6 = this.zzc[v3 + 2];
            int v7 = v6 & 0xFFFFF;
            int v8 = 1 << (v6 >>> 20);
            if(v7 == v2) {
                v10 = v2;
                v9 = v1;
            }
            else {
                if(v7 != 0xFFFFF) {
                    v1 = zzga.zzb.getInt(object0, ((long)v7));
                }
                v9 = v1;
                v10 = v7;
            }
            if((0x10000000 & v5) != 0 && !this.zzF(object0, v3, v10, v9, v8)) {
                return false;
            }
            switch(v5 >>> 20 & 0xFF) {
                case 9: 
                case 17: {
                    if(this.zzF(object0, v3, v10, v9, v8) && !zzga.zzG(object0, v5, this.zzr(v3))) {
                        return false;
                    }
                    break;
                }
                case 27: 
                case 49: {
                    List list0 = (List)zzhj.zzf(object0, ((long)(v5 & 0xFFFFF)));
                    if(!list0.isEmpty()) {
                        zzgi zzgi0 = this.zzr(v3);
                        for(int v11 = 0; v11 < list0.size(); ++v11) {
                            if(!zzgi0.zzi(list0.get(v11))) {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 50: {
                    if(!((zzfr)zzhj.zzf(object0, ((long)(v5 & 0xFFFFF)))).isEmpty()) {
                        zzfq zzfq0 = (zzfq)this.zzs(v3);
                        throw null;
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.zzI(object0, v4, v3) && !zzga.zzG(object0, v5, this.zzr(v3))) {
                        return false;
                    }
                }
            }
            ++v;
            v2 = v10;
        }
        return true;
    }

    public static zzga zzj(Class class0, zzfu zzfu0, zzgc zzgc0, zzfl zzfl0, zzgz zzgz0, zzem zzem0, zzfs zzfs0) {
        Field field3;
        int v92;
        String s1;
        int v85;
        int v84;
        int v83;
        int v82;
        Field field1;
        Field field0;
        int v79;
        int v77;
        int v76;
        int v70;
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
        if(zzfu0 instanceof zzgh) {
            String s = ((zzgh)zzfu0).zzd();
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
                arr_v = zzga.zza;
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
                v9 = s.charAt(v30);
                if(v9 >= 0xD800) {
                    int v36 = v9 & 0x1FFF;
                    int v37 = 13;
                    int v38;
                    while((v38 = s.charAt(v35)) >= 0xD800) {
                        v36 |= (v38 & 0x1FFF) << v37;
                        v37 += 13;
                        ++v35;
                    }
                    v9 = v36 | v38 << v37;
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
                v12 = v16 * 2 + v21;
                v10 = v26;
                v8 = v40;
                arr_v = new int[v50 + v40 + v45];
                v11 = v31;
                v13 = v50;
                v14 = v16;
                v3 = v49;
            }
            Unsafe unsafe0 = zzga.zzb;
            Object[] arr_object = ((zzgh)zzfu0).zze();
            Class class1 = ((zzgh)zzfu0).zza().getClass();
            int v54 = v13 + v8;
            int[] arr_v1 = new int[v9 * 3];
            Object[] arr_object1 = new Object[v9 + v9];
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
                    int v69;
                    while((v69 = s.charAt(v67)) >= 0xD800) {
                        v66 |= (v69 & 0x1FFF) << v68;
                        v68 += 13;
                        ++v67;
                    }
                    v65 = v66 | v69 << v68;
                    v70 = v67 + 1;
                }
                else {
                    v70 = v64 + 1;
                }
                if((v65 & 0x400) != 0) {
                    arr_v[v58] = v57;
                    ++v58;
                }
                if((v65 & 0xFF) >= 51) {
                    int v71 = s.charAt(v70);
                    if(v71 >= 0xD800) {
                        int v72 = v71 & 0x1FFF;
                        int v73 = v70 + 1;
                        int v74 = 13;
                        int v75;
                        while((v75 = s.charAt(v73)) >= 0xD800) {
                            v72 |= (v75 & 0x1FFF) << v74;
                            v74 += 13;
                            ++v73;
                        }
                        v71 = v72 | v75 << v74;
                        v76 = v73 + 1;
                    }
                    else {
                        v76 = v70 + 1;
                    }
                    v77 = v76;
                    int v78 = (v65 & 0xFF) - 51;
                    v79 = v;
                    if(v78 == 9 || v78 == 17) {
                        arr_object1[v57 / 3 * 2 + 1] = arr_object[v12];
                        ++v12;
                    }
                    else if(v78 == 12 && (((zzgh)zzfu0).zzc() == 1 || (v65 & 0x800) != 0)) {
                        arr_object1[v57 / 3 * 2 + 1] = arr_object[v12];
                        ++v12;
                    }
                    int v80 = v71 + v71;
                    Object object0 = arr_object[v80];
                    if(object0 instanceof Field) {
                        field0 = (Field)object0;
                    }
                    else {
                        field0 = zzga.zzv(class1, ((String)object0));
                        arr_object[v80] = field0;
                    }
                    int v81 = (int)unsafe0.objectFieldOffset(field0);
                    Object object1 = arr_object[v80 + 1];
                    if(object1 instanceof Field) {
                        field1 = (Field)object1;
                    }
                    else {
                        field1 = zzga.zzv(class1, ((String)object1));
                        arr_object[v80 + 1] = field1;
                    }
                    v82 = (int)unsafe0.objectFieldOffset(field1);
                    v83 = v81;
                    v84 = 0;
                    v85 = v14;
                }
                else {
                    v79 = v;
                    Field field2 = zzga.zzv(class1, ((String)arr_object[v12]));
                    int v86 = v12 + 1;
                    switch(v65 & 0xFF) {
                        case 9: 
                        case 17: {
                            v85 = v14;
                            arr_object1[v57 / 3 * 2 + 1] = field2.getType();
                            s1 = s;
                            v12 = v86;
                            break;
                        }
                        case 12: 
                        case 30: 
                        case 44: {
                            v85 = v14;
                            if(((zzgh)zzfu0).zzc() == 1 || (v65 & 0x800) != 0) {
                                v12 += 2;
                                arr_object1[v57 / 3 * 2 + 1] = arr_object[v86];
                                s1 = s;
                                break;
                            }
                            s1 = s;
                            v12 = v86;
                            break;
                        }
                        case 27: 
                        case 49: {
                            v85 = v14;
                            v12 += 2;
                            arr_object1[v57 / 3 * 2 + 1] = arr_object[v86];
                            s1 = s;
                            break;
                        }
                        case 50: {
                            arr_v[v55] = v57;
                            int v87 = v57 / 3 + v57 / 3;
                            arr_object1[v87] = arr_object[v86];
                            if((v65 & 0x800) == 0) {
                                s1 = s;
                                v12 += 2;
                                ++v55;
                                v85 = v14;
                            }
                            else {
                                arr_object1[v87 + 1] = arr_object[v12 + 2];
                                v12 += 3;
                                s1 = s;
                                v85 = v14;
                                ++v55;
                            }
                            break;
                        }
                        default: {
                            v85 = v14;
                            s1 = s;
                            v12 = v86;
                            break;
                        }
                    }
                    v83 = (int)unsafe0.objectFieldOffset(field2);
                    v82 = 0xFFFFF;
                    if((v65 & 0x1000) == 0 || (v65 & 0xFF) > 17) {
                        s = s1;
                        v77 = v70;
                        v84 = 0;
                    }
                    else {
                        int v88 = v70 + 1;
                        String s2 = s1;
                        int v89 = s2.charAt(v70);
                        if(v89 >= 0xD800) {
                            int v90 = v89 & 0x1FFF;
                            int v91 = 13;
                            while(true) {
                                v77 = v88 + 1;
                                v92 = s2.charAt(v88);
                                if(v92 < 0xD800) {
                                    break;
                                }
                                v90 |= (v92 & 0x1FFF) << v91;
                                v91 += 13;
                                v88 = v77;
                            }
                            v89 = v90 | v92 << v91;
                        }
                        else {
                            v77 = v88;
                        }
                        int v93 = v89 / 0x20 + v85 * 2;
                        Object object2 = arr_object[v93];
                        if(object2 instanceof Field) {
                            field3 = (Field)object2;
                        }
                        else {
                            field3 = zzga.zzv(class1, ((String)object2));
                            arr_object[v93] = field3;
                        }
                        v84 = v89 % 0x20;
                        v82 = (int)unsafe0.objectFieldOffset(field3);
                        s = s2;
                    }
                    if((v65 & 0xFF) >= 18 && (v65 & 0xFF) <= 49) {
                        arr_v[v56] = v83;
                        ++v56;
                    }
                }
                arr_v1[v57] = v59;
                int v94 = v57 + 2;
                arr_v1[v57 + 1] = ((v65 & 0x200) == 0 ? 0 : 0x20000000) | ((v65 & 0x100) == 0 ? 0 : 0x10000000) | ((v65 & 0x800) == 0 ? 0 : 0x80000000) | (v65 & 0xFF) << 20 | v83;
                v57 += 3;
                arr_v1[v94] = v84 << 20 | v82;
                v3 = v77;
                v14 = v85;
                v = v79;
            }
            return new zzga(arr_v1, arr_object1, v10, v11, ((zzgh)zzfu0).zza(), ((zzgh)zzfu0).zzc(), false, arr_v, v13, v54, zzgc0, zzfl0, zzgz0, zzem0, zzfs0);
        }
        zzgw zzgw0 = (zzgw)zzfu0;
        throw null;
    }

    private static int zzk(Object object0, long v) {
        return (int)(((Integer)zzhj.zzf(object0, v)));
    }

    private final int zzl(int v) {
        return this.zzc[v + 2];
    }

    private final int zzm(int v, int v1) {
        int v2 = this.zzc.length / 3 - 1;
        while(v1 <= v2) {
            int v3 = v2 + v1 >>> 1;
            int v4 = v3 * 3;
            int v5 = this.zzc[v4];
            if(v == v5) {
                return v4;
            }
            if(v < v5) {
                v2 = v3 - 1;
            }
            else {
                v1 = v3 + 1;
            }
        }
        return -1;
    }

    private static int zzn(int v) [...] // Inlined contents

    private final int zzo(int v) {
        return this.zzc[v + 1];
    }

    private static long zzp(Object object0, long v) {
        return (long)(((Long)zzhj.zzf(object0, v)));
    }

    private final zzey zzq(int v) {
        return (zzey)this.zzd[v / 3 * 2 + 1];
    }

    private final zzgi zzr(int v) {
        int v1 = v / 3 + v / 3;
        zzgi zzgi0 = (zzgi)this.zzd[v1];
        if(zzgi0 != null) {
            return zzgi0;
        }
        zzgi zzgi1 = zzgf.zza().zzb(((Class)this.zzd[v1 + 1]));
        this.zzd[v1] = zzgi1;
        return zzgi1;
    }

    private final Object zzs(int v) {
        return this.zzd[v / 3 + v / 3];
    }

    private final Object zzt(Object object0, int v) {
        zzgi zzgi0 = this.zzr(v);
        int v1 = this.zzo(v);
        if(!this.zzE(object0, v)) {
            return zzgi0.zzd();
        }
        Object object1 = zzga.zzb.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(zzga.zzH(object1)) {
            return object1;
        }
        Object object2 = zzgi0.zzd();
        if(object1 != null) {
            zzgi0.zzf(object2, object1);
        }
        return object2;
    }

    private final Object zzu(Object object0, int v, int v1) {
        zzgi zzgi0 = this.zzr(v1);
        if(!this.zzI(object0, v, v1)) {
            return zzgi0.zzd();
        }
        int v2 = this.zzo(v1);
        Object object1 = zzga.zzb.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(zzga.zzH(object1)) {
            return object1;
        }
        Object object2 = zzgi0.zzd();
        if(object1 != null) {
            zzgi0.zzf(object2, object1);
        }
        return object2;
    }

    private static Field zzv(Class class0, String s) {
        try {
            return class0.getDeclaredField(s);
        }
        catch(NoSuchFieldException unused_ex) {
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
            throw new RuntimeException(stringBuilder0.toString());
        }
    }

    private static void zzw(Object object0) {
        if(!zzga.zzH(object0)) {
            throw new IllegalArgumentException("Mutating immutable message: " + object0);
        }
    }

    private final void zzx(Object object0, Object object1, int v) {
        if(!this.zzE(object1, v)) {
            return;
        }
        int v1 = this.zzo(v);
        Unsafe unsafe0 = zzga.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException(b.f(this.zzc[v], "Source subfield ", " is present but null: ", object1.toString()));
        }
        zzgi zzgi0 = this.zzr(v);
        if(!this.zzE(object0, v)) {
            if(zzga.zzH(object2)) {
                Object object3 = zzgi0.zzd();
                zzgi0.zzf(object3, object2);
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object2);
            }
            this.zzz(object0, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(!zzga.zzH(object4)) {
            Object object5 = zzgi0.zzd();
            zzgi0.zzf(object5, object4);
            unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zzgi0.zzf(object4, object2);
    }

    private final void zzy(Object object0, Object object1, int v) {
        int v1 = this.zzc[v];
        if(!this.zzI(object1, v1, v)) {
            return;
        }
        int v2 = this.zzo(v);
        Unsafe unsafe0 = zzga.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v2 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException(b.f(this.zzc[v], "Source subfield ", " is present but null: ", object1.toString()));
        }
        zzgi zzgi0 = this.zzr(v);
        if(!this.zzI(object0, v1, v)) {
            if(zzga.zzH(object2)) {
                Object object3 = zzgi0.zzd();
                zzgi0.zzf(object3, object2);
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object2);
            }
            this.zzA(object0, v1, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(!zzga.zzH(object4)) {
            Object object5 = zzgi0.zzd();
            zzgi0.zzf(object5, object4);
            unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zzgi0.zzf(object4, object2);
    }

    private final void zzz(Object object0, int v) {
        int v1 = this.zzl(v);
        if(((long)(0xFFFFF & v1)) == 0xFFFFFL) {
            return;
        }
        zzhj.zzn(object0, ((long)(0xFFFFF & v1)), 1 << (v1 >>> 20) | zzhj.zzc(object0, ((long)(0xFFFFF & v1))));
    }
}

