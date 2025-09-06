package com.google.android.gms.internal.measurement;

import A7.d;
import U4.x;
import b3.Z;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class zzno implements zznw {
    private static final int[] zza;
    private static final Unsafe zzb;
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zznl zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzoh zzl;
    private final zzlr zzm;

    static {
        zzno.zza = new int[0];
        zzno.zzb = zzoo.zzq();
    }

    private zzno(int[] arr_v, Object[] arr_object, int v, int v1, zznl zznl0, boolean z, int[] arr_v1, int v2, int v3, zznq zznq0, zzmx zzmx0, zzoh zzoh0, zzlr zzlr0, zzng zzng0) {
        this.zzc = arr_v;
        this.zzd = arr_object;
        this.zze = v;
        this.zzf = v1;
        this.zzh = zzlr0 != null && zznl0 instanceof zzmb;
        this.zzi = arr_v1;
        this.zzj = v2;
        this.zzk = v3;
        this.zzl = zzoh0;
        this.zzm = zzlr0;
        this.zzg = zznl0;
    }

    private static boolean zzA(Object object0) {
        if(object0 == null) {
            return false;
        }
        return object0 instanceof zzme ? ((zzme)object0).zzcf() : true;
    }

    private static void zzB(Object object0) {
        if(!zzno.zzA(object0)) {
            throw new IllegalArgumentException("Mutating immutable message: " + object0);
        }
    }

    private static double zzC(Object object0, long v) {
        return (double)(((Double)zzoo.zzn(object0, v)));
    }

    private static float zzD(Object object0, long v) {
        return (float)(((Float)zzoo.zzn(object0, v)));
    }

    private static int zzE(Object object0, long v) {
        return (int)(((Integer)zzoo.zzn(object0, v)));
    }

    private static long zzF(Object object0, long v) {
        return (long)(((Long)zzoo.zzn(object0, v)));
    }

    private static boolean zzG(Object object0, long v) {
        return ((Boolean)zzoo.zzn(object0, v)).booleanValue();
    }

    private final boolean zzH(Object object0, Object object1, int v) {
        return this.zzJ(object0, v) == this.zzJ(object1, v);
    }

    private final boolean zzI(Object object0, int v, int v1, int v2, int v3) {
        return v1 == 0xFFFFF ? this.zzJ(object0, v) : (v2 & v3) != 0;
    }

    private final boolean zzJ(Object object0, int v) {
        int v1 = this.zzy(v);
        if(Long.compare(v1 & 0xFFFFF, 0xFFFFFL) == 0) {
            int v2 = this.zzx(v);
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    return Double.doubleToRawLongBits(zzoo.zzl(object0, ((long)(v2 & 0xFFFFF)))) != 0L;
                }
                case 1: {
                    return Float.floatToRawIntBits(zzoo.zzj(object0, ((long)(v2 & 0xFFFFF)))) != 0;
                }
                case 2: {
                    return zzoo.zzf(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 3: {
                    return zzoo.zzf(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 4: {
                    return zzoo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 5: {
                    return zzoo.zzf(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 6: {
                    return zzoo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 7: {
                    return zzoo.zzh(object0, ((long)(v2 & 0xFFFFF)));
                }
                case 8: {
                    Object object1 = zzoo.zzn(object0, ((long)(v2 & 0xFFFFF)));
                    if(object1 instanceof String) {
                        return !((String)object1).isEmpty();
                    }
                    if(!(object1 instanceof zzlg)) {
                        throw new IllegalArgumentException();
                    }
                    return !zzlg.zzb.equals(object1);
                }
                case 9: {
                    return zzoo.zzn(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                case 10: {
                    Object object2 = zzoo.zzn(object0, ((long)(v2 & 0xFFFFF)));
                    return !zzlg.zzb.equals(object2);
                }
                case 11: {
                    return zzoo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 12: {
                    return zzoo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 13: {
                    return zzoo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 14: {
                    return zzoo.zzf(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 15: {
                    return zzoo.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 16: {
                    return zzoo.zzf(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 17: {
                    return zzoo.zzn(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        return (zzoo.zzd(object0, ((long)(v1 & 0xFFFFF))) & 1 << (v1 >>> 20)) != 0;
    }

    private final void zzK(Object object0, int v) {
        int v1 = this.zzy(v);
        if(((long)(0xFFFFF & v1)) == 0xFFFFFL) {
            return;
        }
        zzoo.zze(object0, ((long)(0xFFFFF & v1)), 1 << (v1 >>> 20) | zzoo.zzd(object0, ((long)(0xFFFFF & v1))));
    }

    private final boolean zzL(Object object0, int v, int v1) {
        return zzoo.zzd(object0, ((long)(this.zzy(v1) & 0xFFFFF))) == v;
    }

    private final void zzM(Object object0, int v, int v1) {
        zzoo.zze(object0, ((long)(this.zzy(v1) & 0xFFFFF)), v);
    }

    private final int zzN(int v, int v1) {
        int[] arr_v = this.zzc;
        int v2 = arr_v.length / 3 - 1;
        while(v1 <= v2) {
            int v3 = v2 + v1 >>> 1;
            int v4 = v3 * 3;
            int v5 = arr_v[v4];
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

    private static final int zzO(byte[] arr_b, int v, int v1, zzos zzos0, Class class0, zzkv zzkv0) {
        switch(zzos0.ordinal()) {
            case 0: {
                zzkv0.zzc = Double.longBitsToDouble(zzkw.zze(arr_b, v));
                return v + 8;
            }
            case 1: {
                zzkv0.zzc = Float.intBitsToFloat(zzkw.zzd(arr_b, v));
                return v + 4;
            }
            case 2: 
            case 3: {
                int v2 = zzkw.zzc(arr_b, v, zzkv0);
                zzkv0.zzc = zzkv0.zzb;
                return v2;
            }
            case 7: {
                int v4 = zzkw.zzc(arr_b, v, zzkv0);
                zzkv0.zzc = Boolean.valueOf(zzkv0.zzb != 0L);
                return v4;
            }
            case 8: {
                return zzkw.zzf(arr_b, v, zzkv0);
            }
            case 10: {
                return zzkw.zzh(zznt.zza().zzb(class0), arr_b, v, v1, zzkv0);
            }
            case 11: {
                return zzkw.zzg(arr_b, v, zzkv0);
            }
            case 4: 
            case 12: 
            case 13: {
                int v3 = zzkw.zza(arr_b, v, zzkv0);
                zzkv0.zzc = zzkv0.zza;
                return v3;
            }
            case 6: 
            case 14: {
                zzkv0.zzc = zzkw.zzd(arr_b, v);
                return v + 4;
            }
            case 5: 
            case 15: {
                zzkv0.zzc = zzkw.zze(arr_b, v);
                return v + 8;
            }
            case 16: {
                int v5 = zzkw.zza(arr_b, v, zzkv0);
                zzkv0.zzc = (int)(zzkv0.zza >>> 1 ^ -(zzkv0.zza & 1));
                return v5;
            }
            case 17: {
                int v6 = zzkw.zzc(arr_b, v, zzkv0);
                zzkv0.zzc = (long)(zzkv0.zzb >>> 1 ^ -(1L & zzkv0.zzb));
                return v6;
            }
            default: {
                throw new RuntimeException("unsupported field type.");
            }
        }
    }

    private static final void zzP(int v, Object object0, zzou zzou0) {
        if(object0 instanceof String) {
            zzou0.zzm(v, ((String)object0));
            return;
        }
        zzou0.zzn(v, ((zzlg)object0));
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final Object zza() {
        return ((zzme)this.zzg).zzch();
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final boolean zzb(Object object0, Object object1) {
        boolean z;
        int v = 0;
        while(v < this.zzc.length) {
            int v1 = this.zzx(v);
            long v2 = (long)(v1 & 0xFFFFF);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.zzH(object0, object1, v) && Double.doubleToLongBits(zzoo.zzl(object0, v2)) == Double.doubleToLongBits(zzoo.zzl(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 1: {
                    if(this.zzH(object0, object1, v) && Float.floatToIntBits(zzoo.zzj(object0, v2)) == Float.floatToIntBits(zzoo.zzj(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 2: {
                    if(this.zzH(object0, object1, v) && zzoo.zzf(object0, v2) == zzoo.zzf(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 3: {
                    if(this.zzH(object0, object1, v) && zzoo.zzf(object0, v2) == zzoo.zzf(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 4: {
                    if(this.zzH(object0, object1, v) && zzoo.zzd(object0, v2) == zzoo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 5: {
                    if(this.zzH(object0, object1, v) && zzoo.zzf(object0, v2) == zzoo.zzf(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 6: {
                    if(this.zzH(object0, object1, v) && zzoo.zzd(object0, v2) == zzoo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 7: {
                    if(this.zzH(object0, object1, v) && zzoo.zzh(object0, v2) == zzoo.zzh(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 8: {
                    if(this.zzH(object0, object1, v) && zzny.zzB(zzoo.zzn(object0, v2), zzoo.zzn(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 9: {
                    if(this.zzH(object0, object1, v) && zzny.zzB(zzoo.zzn(object0, v2), zzoo.zzn(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 10: {
                    if(this.zzH(object0, object1, v) && zzny.zzB(zzoo.zzn(object0, v2), zzoo.zzn(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 11: {
                    if(this.zzH(object0, object1, v) && zzoo.zzd(object0, v2) == zzoo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 12: {
                    if(this.zzH(object0, object1, v) && zzoo.zzd(object0, v2) == zzoo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 13: {
                    if(this.zzH(object0, object1, v) && zzoo.zzd(object0, v2) == zzoo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 14: {
                    if(this.zzH(object0, object1, v) && zzoo.zzf(object0, v2) == zzoo.zzf(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 15: {
                    if(this.zzH(object0, object1, v) && zzoo.zzd(object0, v2) == zzoo.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 16: {
                    if(this.zzH(object0, object1, v) && zzoo.zzf(object0, v2) == zzoo.zzf(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 17: {
                    if(this.zzH(object0, object1, v) && zzny.zzB(zzoo.zzn(object0, v2), zzoo.zzn(object1, v2))) {
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
                    z = zzny.zzB(zzoo.zzn(object0, v2), zzoo.zzn(object1, v2));
                    goto label_45;
                }
                case 50: {
                    z = zzny.zzB(zzoo.zzn(object0, v2), zzoo.zzn(object1, v2));
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
                    int v3 = this.zzy(v);
                    if(zzoo.zzd(object0, ((long)(v3 & 0xFFFFF))) != zzoo.zzd(object1, ((long)(v3 & 0xFFFFF))) || !zzny.zzB(zzoo.zzn(object0, v2), zzoo.zzn(object1, v2))) {
                        return false;
                    }
                }
            }
            v += 3;
        }
        if(!((zzme)object0).zzc.equals(((zzme)object1).zzc)) {
            return false;
        }
        return this.zzh ? ((zzmb)object0).zzb.equals(((zzmb)object1).zzb) : true;
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final int zzc(Object object0) {
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
            int v2 = this.zzx(v);
            int v3 = arr_v[v];
            long v4 = (long)(0xFFFFF & v2);
            int v5 = 37;
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    v6 = v1 * 53;
                    v7 = Double.doubleToLongBits(zzoo.zzl(object0, v4));
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 1: {
                    v9 = v1 * 53;
                    v10 = Float.floatToIntBits(zzoo.zzj(object0, v4));
                    v1 = v10 + v9;
                    break;
                }
                case 2: {
                    v6 = v1 * 53;
                    v7 = zzoo.zzf(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 3: {
                    v6 = v1 * 53;
                    v7 = zzoo.zzf(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 4: {
                    v6 = v1 * 53;
                    v8 = zzoo.zzd(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 5: {
                    v6 = v1 * 53;
                    v7 = zzoo.zzf(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 6: {
                    v6 = v1 * 53;
                    v8 = zzoo.zzd(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 7: {
                    v9 = v1 * 53;
                    v10 = zzmo.zzb(zzoo.zzh(object0, v4));
                    v1 = v10 + v9;
                    break;
                }
                case 8: {
                    v9 = v1 * 53;
                    v10 = ((String)zzoo.zzn(object0, v4)).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 9: {
                    Object object1 = zzoo.zzn(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 10: {
                    v9 = v1 * 53;
                    v10 = zzoo.zzn(object0, v4).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 11: {
                    v6 = v1 * 53;
                    v8 = zzoo.zzd(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 12: {
                    v6 = v1 * 53;
                    v8 = zzoo.zzd(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 13: {
                    v1 = v1 * 53 + zzoo.zzd(object0, v4);
                    break;
                }
                case 14: {
                    v7 = zzoo.zzf(object0, v4);
                    v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    break;
                }
                case 15: {
                    v1 = v1 * 53 + zzoo.zzd(object0, v4);
                    break;
                }
                case 16: {
                    v7 = zzoo.zzf(object0, v4);
                    v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    break;
                }
                case 17: {
                    Object object2 = zzoo.zzn(object0, v4);
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
                    v10 = zzoo.zzn(object0, v4).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 50: {
                    v1 = zzoo.zzn(object0, v4).hashCode() + v1 * 53;
                    break;
                }
                case 51: {
                    if(this.zzL(object0, v3, v)) {
                        v7 = Double.doubleToLongBits(zzno.zzC(object0, v4));
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 52: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = Float.floatToIntBits(zzno.zzD(object0, v4)) + v1 * 53;
                    }
                    break;
                }
                case 53: {
                    if(this.zzL(object0, v3, v)) {
                        v7 = zzno.zzF(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 54: {
                    if(this.zzL(object0, v3, v)) {
                        v7 = zzno.zzF(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 55: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = v1 * 53 + zzno.zzE(object0, v4);
                    }
                    break;
                }
                case 56: {
                    if(this.zzL(object0, v3, v)) {
                        v7 = zzno.zzF(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 57: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = v1 * 53 + zzno.zzE(object0, v4);
                    }
                    break;
                }
                case 58: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = zzmo.zzb(zzno.zzG(object0, v4)) + v1 * 53;
                    }
                    break;
                }
                case 59: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = ((String)zzoo.zzn(object0, v4)).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 60: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = zzoo.zzn(object0, v4).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 61: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = zzoo.zzn(object0, v4).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 62: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = v1 * 53 + zzno.zzE(object0, v4);
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = v1 * 53 + zzno.zzE(object0, v4);
                    }
                    break;
                }
                case 0x40: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = v1 * 53 + zzno.zzE(object0, v4);
                    }
                    break;
                }
                case 65: {
                    if(this.zzL(object0, v3, v)) {
                        v7 = zzno.zzF(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 66: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = v1 * 53 + zzno.zzE(object0, v4);
                    }
                    break;
                }
                case 67: {
                    if(this.zzL(object0, v3, v)) {
                        v7 = zzno.zzF(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 68: {
                    if(this.zzL(object0, v3, v)) {
                        v1 = zzoo.zzn(object0, v4).hashCode() + v1 * 53;
                    }
                }
            }
        }
        int v11 = ((zzme)object0).zzc.hashCode() + v1 * 53;
        return this.zzh ? v11 * 53 + ((zzmb)object0).zzb.zza.hashCode() : v11;
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final void zzd(Object object0, Object object1) {
        zzno.zzB(object0);
        object1.getClass();
        for(int v = 0; true; v += 3) {
            int[] arr_v = this.zzc;
            if(v >= arr_v.length) {
                break;
            }
            int v1 = this.zzx(v);
            int v2 = arr_v[v];
            long v3 = (long)(0xFFFFF & v1);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zzm(object0, v3, zzoo.zzl(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 1: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zzk(object0, v3, zzoo.zzj(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 2: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zzg(object0, v3, zzoo.zzf(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 3: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zzg(object0, v3, zzoo.zzf(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 4: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zze(object0, v3, zzoo.zzd(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 5: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zzg(object0, v3, zzoo.zzf(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 6: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zze(object0, v3, zzoo.zzd(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 7: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zzi(object0, v3, zzoo.zzh(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 8: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zzo(object0, v3, zzoo.zzn(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 9: {
                    this.zzn(object0, object1, v);
                    break;
                }
                case 10: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zzo(object0, v3, zzoo.zzn(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 11: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zze(object0, v3, zzoo.zzd(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 12: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zze(object0, v3, zzoo.zzd(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 13: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zze(object0, v3, zzoo.zzd(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 14: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zzg(object0, v3, zzoo.zzf(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 15: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zze(object0, v3, zzoo.zzd(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 16: {
                    if(this.zzJ(object1, v)) {
                        zzoo.zzg(object0, v3, zzoo.zzf(object1, v3));
                        this.zzK(object0, v);
                    }
                    break;
                }
                case 17: {
                    this.zzn(object0, object1, v);
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
                    zzmn zzmn0 = (zzmn)zzoo.zzn(object0, v3);
                    zzmn zzmn1 = (zzmn)zzoo.zzn(object1, v3);
                    int v4 = zzmn0.size();
                    int v5 = zzmn1.size();
                    if(v4 > 0 && v5 > 0) {
                        if(!zzmn0.zza()) {
                            zzmn0 = zzmn0.zzg(v5 + v4);
                        }
                        zzmn0.addAll(zzmn1);
                    }
                    if(v4 > 0) {
                        zzmn1 = zzmn0;
                    }
                    zzoo.zzo(object0, v3, zzmn1);
                    break;
                }
                case 50: {
                    zzoo.zzo(object0, v3, zzng.zza(zzoo.zzn(object0, v3), zzoo.zzn(object1, v3)));
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
                    if(this.zzL(object1, v2, v)) {
                        zzoo.zzo(object0, v3, zzoo.zzn(object1, v3));
                        this.zzM(object0, v2, v);
                    }
                    break;
                }
                case 60: {
                    this.zzo(object0, object1, v);
                    break;
                }
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: {
                    if(this.zzL(object1, v2, v)) {
                        zzoo.zzo(object0, v3, zzoo.zzn(object1, v3));
                        this.zzM(object0, v2, v);
                    }
                    break;
                }
                case 68: {
                    this.zzo(object0, object1, v);
                }
            }
        }
        zzny.zzD(this.zzl, object0, object1);
        if(this.zzh) {
            zzny.zzC(this.zzm, object0, object1);
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final int zze(Object object0) {
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
        Unsafe unsafe0 = zzno.zzb;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        int v4 = 0xFFFFF;
        while(true) {
            int[] arr_v = this.zzc;
            if(v1 >= arr_v.length) {
                break;
            }
            int v5 = this.zzx(v1);
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
            boolean z = v6 < zzlw.zzJ.zza();
            long v11 = (long)(v5 & 0xFFFFF);
            switch(v6) {
                case 0: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 = Z.B(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 1: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 = Z.B(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 2: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v12 = zzll.zzz(v7 << 3);
                        v13 = zzll.zzA(unsafe0.getLong(object0, v11));
                        v3 += v13 + v12;
                    }
                    v1 += 3;
                    continue;
                }
                case 3: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v12 = zzll.zzz(v7 << 3);
                        v13 = zzll.zzA(unsafe0.getLong(object0, v11));
                        v3 += v13 + v12;
                    }
                    v1 += 3;
                    continue;
                }
                case 4: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v12 = zzll.zzz(v7 << 3);
                        v13 = zzll.zzA(unsafe0.getInt(object0, v11));
                        v3 += v13 + v12;
                    }
                    v1 += 3;
                    continue;
                }
                case 5: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 = Z.B(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 6: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 = Z.B(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 7: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 = Z.B(v7 << 3, 1, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 8: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        Object object1 = unsafe0.getObject(object0, v11);
                        if(object1 instanceof zzlg) {
                            v14 = ((zzlg)object1).zzc();
                            v3 += zzll.zzz(v14) + v14 + zzll.zzz(v7 << 3);
                            v1 += 3;
                            continue;
                        }
                        else {
                            v12 = zzll.zzz(v7 << 3);
                            v13 = zzll.zzB(((String)object1));
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
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 += zzny.zzz(v7, unsafe0.getObject(object0, v11), this.zzp(v1));
                    }
                    v1 += 3;
                    continue;
                }
                case 10: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v14 = ((zzlg)unsafe0.getObject(object0, v11)).zzc();
                        v3 += zzll.zzz(v14) + v14 + zzll.zzz(v7 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 11: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 = Z.B(unsafe0.getInt(object0, v11), zzll.zzz(v7 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 12: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 += zzll.zzA(unsafe0.getInt(object0, v11)) + zzll.zzz(v7 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 13: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 = Z.B(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 14: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 = Z.B(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 15: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        int v15 = unsafe0.getInt(object0, v11);
                        v3 = Z.B(v15 >> 0x1F ^ v15 + v15, zzll.zzz(v7 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 16: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        long v16 = unsafe0.getLong(object0, v11);
                        v3 += zzll.zzA(v16 >> 0x3F ^ v16 + v16) + zzll.zzz(v7 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 17: {
                    if(this.zzI(object0, v1, v4, v2, v10)) {
                        v3 += zzll.zzG(v7, ((zznl)unsafe0.getObject(object0, v11)), this.zzp(v1));
                        break;
                    }
                    else {
                        v1 += 3;
                        continue;
                    }
                    v17 = zzny.zzy(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 18: {
                    v17 = zzny.zzy(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 19: {
                    v17 = zzny.zzw(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 20: {
                    List list0 = (List)unsafe0.getObject(object0, v11);
                    if(list0.size() != 0) {
                        v3 += zzll.zzz(v7 << 3) * list0.size() + zzny.zzo(list0);
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
                        v19 = zzny.zzp(list1);
                        v20 = zzll.zzz(v7 << 3);
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
                        v19 = zzny.zzs(list2);
                        v20 = zzll.zzz(v7 << 3);
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
                    v17 = zzny.zzy(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 24: {
                    v17 = zzny.zzw(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 25: {
                    int v21 = ((List)unsafe0.getObject(object0, v11)).size();
                    v3 += (v21 == 0 ? 0 : (zzll.zzz(v7 << 3) + 1) * v21);
                    v1 += 3;
                    continue;
                }
                case 26: {
                    List list3 = (List)unsafe0.getObject(object0, v11);
                    int v22 = list3.size();
                    if(v22 != 0) {
                        v23 = zzll.zzz(v7 << 3) * v22;
                        if(list3 instanceof zzmw) {
                            zzmw zzmw0 = (zzmw)list3;
                            for(int v24 = 0; v24 < v22; ++v24) {
                                Object object2 = zzmw0.zzc();
                                if(object2 instanceof zzlg) {
                                    int v25 = ((zzlg)object2).zzc();
                                    v23 = Z.B(v25, v25, v23);
                                }
                                else {
                                    v23 = zzll.zzB(((String)object2)) + v23;
                                }
                            }
                        }
                        else {
                            for(int v26 = 0; v26 < v22; ++v26) {
                                Object object3 = list3.get(v26);
                                if(object3 instanceof zzlg) {
                                    int v27 = ((zzlg)object3).zzc();
                                    v23 = Z.B(v27, v27, v23);
                                }
                                else {
                                    v23 = zzll.zzB(((String)object3)) + v23;
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
                    zznw zznw0 = this.zzp(v1);
                    int v28 = list4.size();
                    if(v28 == 0) {
                        v29 = 0;
                    }
                    else {
                        v29 = zzll.zzz(v7 << 3) * v28;
                        for(int v30 = 0; v30 < v28; ++v30) {
                            Object object4 = list4.get(v30);
                            if(object4 instanceof zzmv) {
                                int v31 = ((zzmv)object4).zzb();
                                v29 = Z.B(v31, v31, v29);
                            }
                            else {
                                v29 = zzll.zzD(((zznl)object4), zznw0) + v29;
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
                        v23 = zzll.zzz(v7 << 3) * v32;
                        for(int v33 = 0; v33 < list5.size(); ++v33) {
                            int v34 = ((zzlg)list5.get(v33)).zzc();
                            v23 = Z.B(v34, v34, v23);
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
                        v19 = zzny.zzt(list6);
                        v20 = zzll.zzz(v7 << 3);
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
                        v19 = zzny.zzr(list7);
                        v20 = zzll.zzz(v7 << 3);
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
                    v17 = zzny.zzw(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    break;
                }
                case 0x20: {
                    v17 = zzny.zzy(v7, ((List)unsafe0.getObject(object0, v11)), false);
                    v3 += v17;
                    break;
                }
                case 33: {
                    List list8 = (List)unsafe0.getObject(object0, v11);
                    v18 = list8.size();
                    if(v18 != 0) {
                        v19 = zzny.zzu(list8);
                        v20 = zzll.zzz(v7 << 3);
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
                case 34: {
                    List list9 = (List)unsafe0.getObject(object0, v11);
                    v18 = list9.size();
                    if(v18 != 0) {
                        v3 += zzll.zzz(v7 << 3) * v18 + zzny.zzq(list9);
                        v1 += 3;
                        continue;
                    }
                    v23 = 0;
                    v3 += v23;
                    v1 += 3;
                    continue;
                }
                case 35: {
                    v35 = zzny.zzx(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 36: {
                    v35 = zzny.zzv(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 37: {
                    v35 = zzny.zzo(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 38: {
                    v35 = zzny.zzp(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 39: {
                    v35 = zzny.zzs(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 40: {
                    v35 = zzny.zzx(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 41: {
                    v35 = zzny.zzv(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
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
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 43: {
                    v35 = zzny.zzt(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 44: {
                    v35 = zzny.zzr(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 45: {
                    v35 = zzny.zzv(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 46: {
                    v35 = zzny.zzx(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x2F: {
                    v35 = zzny.zzu(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x30: {
                    v35 = zzny.zzq(((List)unsafe0.getObject(object0, v11)));
                    if(v35 > 0) {
                        v36 = zzll.zzz(v7 << 3);
                        v37 = zzll.zzz(v35);
                        v3 += v37 + v36 + v35;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 49: {
                    List list10 = (List)unsafe0.getObject(object0, v11);
                    zznw zznw1 = this.zzp(v1);
                    int v38 = list10.size();
                    if(v38 == 0) {
                        v39 = 0;
                    }
                    else {
                        v39 = 0;
                        for(int v40 = 0; v40 < v38; ++v40) {
                            v39 += zzll.zzG(v7, ((zznl)list10.get(v40)), zznw1);
                        }
                    }
                    v3 += v39;
                    v1 += 3;
                    continue;
                }
                case 50: {
                    Object object5 = unsafe0.getObject(object0, v11);
                    Object object6 = this.zzq(v1);
                    zznf zznf0 = (zznf)object5;
                    zzne zzne0 = (zzne)object6;
                    if(zznf0.isEmpty()) {
                        v23 = 0;
                    }
                    else {
                        v23 = 0;
                        for(Object object7: zznf0.entrySet()) {
                            v23 += zzne0.zzd(v7, ((Map.Entry)object7).getKey(), ((Map.Entry)object7).getValue());
                        }
                    }
                    v3 += v23;
                    v1 += 3;
                    continue;
                }
                case 51: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 = Z.B(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 52: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 = Z.B(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 53: {
                    if(this.zzL(object0, v7, v1)) {
                        v41 = zzll.zzz(v7 << 3);
                        v42 = zzll.zzA(zzno.zzF(object0, v11));
                        v3 += v42 + v41;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 54: {
                    if(this.zzL(object0, v7, v1)) {
                        v41 = zzll.zzz(v7 << 3);
                        v42 = zzll.zzA(zzno.zzF(object0, v11));
                        v3 += v42 + v41;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 55: {
                    if(this.zzL(object0, v7, v1)) {
                        v41 = zzll.zzz(v7 << 3);
                        v42 = zzll.zzA(zzno.zzE(object0, v11));
                        v3 += v42 + v41;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 56: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 = Z.B(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 57: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 = Z.B(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 58: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 = Z.B(v7 << 3, 1, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 59: {
                    if(this.zzL(object0, v7, v1)) {
                        Object object8 = unsafe0.getObject(object0, v11);
                        if(object8 instanceof zzlg) {
                            v36 = ((zzlg)object8).zzc();
                            v3 += zzll.zzz(v36) + v36 + zzll.zzz(v7 << 3);
                            break;
                        }
                        else {
                            v41 = zzll.zzz(v7 << 3);
                            v42 = zzll.zzB(((String)object8));
                        }
                        v3 += v42 + v41;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 60: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 += zzny.zzz(v7, unsafe0.getObject(object0, v11), this.zzp(v1));
                    }
                    v1 += 3;
                    continue;
                }
                case 61: {
                    if(this.zzL(object0, v7, v1)) {
                        v36 = ((zzlg)unsafe0.getObject(object0, v11)).zzc();
                        v3 += zzll.zzz(v36) + v36 + zzll.zzz(v7 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 62: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 = Z.B(zzno.zzE(object0, v11), zzll.zzz(v7 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 0x3F: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 += zzll.zzA(zzno.zzE(object0, v11)) + zzll.zzz(v7 << 3);
                        break;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x40: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 = Z.B(v7 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 65: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 = Z.B(v7 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 66: {
                    if(this.zzL(object0, v7, v1)) {
                        int v43 = zzno.zzE(object0, v11);
                        v3 = Z.B(v43 >> 0x1F ^ v43 + v43, zzll.zzz(v7 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 67: {
                    if(this.zzL(object0, v7, v1)) {
                        long v44 = zzno.zzF(object0, v11);
                        v3 += zzll.zzA(v44 >> 0x3F ^ v44 + v44) + zzll.zzz(v7 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 68: {
                    if(this.zzL(object0, v7, v1)) {
                        v3 += zzll.zzG(v7, ((zznl)unsafe0.getObject(object0, v11)), this.zzp(v1));
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
        int v45 = ((zzme)object0).zzc.zzi() + v3;
        if(this.zzh) {
            zzod zzod0 = ((zzmb)object0).zzb.zza;
            int v46 = zzod0.zzc();
            int v47 = 0;
            for(int v = 0; v < v46; ++v) {
                Map.Entry map$Entry0 = zzod0.zzd(v);
                v47 += zzlv.zzj(((zzlu)((zzoa)map$Entry0).zza()), map$Entry0.getValue());
            }
            for(Object object9: zzod0.zze()) {
                v47 += zzlv.zzj(((zzlu)((Map.Entry)object9).getKey()), ((Map.Entry)object9).getValue());
            }
            return v45 + v47;
        }
        return v45;
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final void zzf(Object object0, zzou zzou0) {
        int v9;
        int v8;
        Map.Entry map$Entry0;
        if(this.zzh) {
            zzlv zzlv0 = ((zzmb)object0).zzb;
            if(zzlv0.zza.isEmpty()) {
                map$Entry0 = null;
            }
            else {
                Object object1 = zzlv0.zzc().next();
                map$Entry0 = (Map.Entry)object1;
            }
        }
        else {
            map$Entry0 = null;
        }
        int[] arr_v = this.zzc;
        Unsafe unsafe0 = zzno.zzb;
        int v = 0xFFFFF;
        int v1 = 0;
        int v2 = 0;
        while(v1 < arr_v.length) {
            int v3 = this.zzx(v1);
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
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzf(v5, zzoo.zzl(object0, v10));
                        }
                        break;
                    }
                    case 1: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zze(v5, zzoo.zzj(object0, v10));
                        }
                        break;
                    }
                    case 2: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzc(v5, unsafe0.getLong(object0, v10));
                        }
                        break;
                    }
                    case 3: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzh(v5, unsafe0.getLong(object0, v10));
                        }
                        break;
                    }
                    case 4: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzi(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 5: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzj(v5, unsafe0.getLong(object0, v10));
                        }
                        break;
                    }
                    case 6: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzk(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 7: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzl(v5, zzoo.zzh(object0, v10));
                        }
                        break;
                    }
                    case 8: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzno.zzP(v5, unsafe0.getObject(object0, v10), zzou0);
                        }
                        break;
                    }
                    case 9: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzr(v5, unsafe0.getObject(object0, v10), this.zzp(v1));
                        }
                        break;
                    }
                    case 10: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzn(v5, ((zzlg)unsafe0.getObject(object0, v10)));
                        }
                        break;
                    }
                    case 11: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzo(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 12: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzg(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 13: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzb(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 14: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzd(v5, unsafe0.getLong(object0, v10));
                        }
                        break;
                    }
                    case 15: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzp(v5, unsafe0.getInt(object0, v10));
                        }
                        break;
                    }
                    case 16: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzq(v5, unsafe0.getLong(object0, v10));
                        }
                        break;
                    }
                    case 17: {
                        if(this.zzI(object0, v1, v, v2, v9)) {
                            zzou0.zzs(v5, unsafe0.getObject(object0, v10), this.zzp(v1));
                        }
                        break;
                    }
                    case 18: {
                        zzny.zza(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 19: {
                        zzny.zzb(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 20: {
                        zzny.zzc(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 21: {
                        zzny.zzd(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 22: {
                        zzny.zzh(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 23: {
                        zzny.zzf(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 24: {
                        zzny.zzk(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 25: {
                        zzny.zzn(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 26: {
                        int v11 = arr_v[v1];
                        List list0 = (List)unsafe0.getObject(object0, v10);
                        if(list0 != null && !list0.isEmpty()) {
                            zzou0.zzF(v11, list0);
                        }
                        break;
                    }
                    case 27: {
                        int v12 = arr_v[v1];
                        List list1 = (List)unsafe0.getObject(object0, v10);
                        zznw zznw0 = this.zzp(v1);
                        if(list1 != null && !list1.isEmpty()) {
                            for(int v13 = 0; v13 < list1.size(); ++v13) {
                                ((zzlm)zzou0).zzr(v12, list1.get(v13), zznw0);
                            }
                        }
                        break;
                    }
                    case 28: {
                        int v14 = arr_v[v1];
                        List list2 = (List)unsafe0.getObject(object0, v10);
                        if(list2 != null && !list2.isEmpty()) {
                            zzou0.zzG(v14, list2);
                        }
                        break;
                    }
                    case 29: {
                        zzny.zzi(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 30: {
                        zzny.zzm(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 0x1F: {
                        zzny.zzl(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 0x20: {
                        zzny.zzg(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 33: {
                        zzny.zzj(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 34: {
                        zzny.zze(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, false);
                        break;
                    }
                    case 35: {
                        zzny.zza(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 36: {
                        zzny.zzb(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 37: {
                        zzny.zzc(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 38: {
                        zzny.zzd(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 39: {
                        zzny.zzh(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 40: {
                        zzny.zzf(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 41: {
                        zzny.zzk(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 42: {
                        zzny.zzn(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 43: {
                        zzny.zzi(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 44: {
                        zzny.zzm(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 45: {
                        zzny.zzl(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 46: {
                        zzny.zzg(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 0x2F: {
                        zzny.zzj(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 0x30: {
                        zzny.zze(arr_v[v1], ((List)unsafe0.getObject(object0, v10)), zzou0, true);
                        break;
                    }
                    case 49: {
                        int v15 = arr_v[v1];
                        List list3 = (List)unsafe0.getObject(object0, v10);
                        zznw zznw1 = this.zzp(v1);
                        if(list3 != null && !list3.isEmpty()) {
                            for(int v16 = 0; v16 < list3.size(); ++v16) {
                                ((zzlm)zzou0).zzs(v15, list3.get(v16), zznw1);
                            }
                        }
                        break;
                    }
                    case 50: {
                        Object object2 = unsafe0.getObject(object0, v10);
                        if(object2 != null) {
                            zzou0.zzM(v5, ((zzne)this.zzq(v1)).zze(), ((zznf)object2));
                        }
                        break;
                    }
                    case 51: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzf(v5, zzno.zzC(object0, v10));
                        }
                        break;
                    }
                    case 52: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zze(v5, zzno.zzD(object0, v10));
                        }
                        break;
                    }
                    case 53: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzc(v5, zzno.zzF(object0, v10));
                        }
                        break;
                    }
                    case 54: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzh(v5, zzno.zzF(object0, v10));
                        }
                        break;
                    }
                    case 55: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzi(v5, zzno.zzE(object0, v10));
                        }
                        break;
                    }
                    case 56: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzj(v5, zzno.zzF(object0, v10));
                        }
                        break;
                    }
                    case 57: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzk(v5, zzno.zzE(object0, v10));
                        }
                        break;
                    }
                    case 58: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzl(v5, zzno.zzG(object0, v10));
                        }
                        break;
                    }
                    case 59: {
                        if(this.zzL(object0, v5, v1)) {
                            zzno.zzP(v5, unsafe0.getObject(object0, v10), zzou0);
                        }
                        break;
                    }
                    case 60: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzr(v5, unsafe0.getObject(object0, v10), this.zzp(v1));
                        }
                        break;
                    }
                    case 61: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzn(v5, ((zzlg)unsafe0.getObject(object0, v10)));
                        }
                        break;
                    }
                    case 62: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzo(v5, zzno.zzE(object0, v10));
                        }
                        break;
                    }
                    case 0x3F: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzg(v5, zzno.zzE(object0, v10));
                        }
                        break;
                    }
                    case 0x40: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzb(v5, zzno.zzE(object0, v10));
                        }
                        break;
                    }
                    case 65: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzd(v5, zzno.zzF(object0, v10));
                        }
                        break;
                    }
                    case 66: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzp(v5, zzno.zzE(object0, v10));
                        }
                        break;
                    }
                    case 67: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzq(v5, zzno.zzF(object0, v10));
                        }
                        break;
                    }
                    case 68: {
                        if(this.zzL(object0, v5, v1)) {
                            zzou0.zzs(v5, unsafe0.getObject(object0, v10), this.zzp(v1));
                        }
                    }
                }
                v1 += 3;
                continue;
            }
            zzmc zzmc0 = (zzmc)map$Entry0.getKey();
            throw null;
        }
        if(map$Entry0 == null) {
            ((zzme)object0).zzc.zzg(zzou0);
            return;
        }
        zzmc zzmc1 = (zzmc)map$Entry0.getKey();
        throw null;
    }

    public static zzoi zzg(Object object0) {
        zzoi zzoi0 = ((zzme)object0).zzc;
        if(zzoi0 == zzoi.zza()) {
            zzoi0 = zzoi.zzb();
            ((zzme)object0).zzc = zzoi0;
        }
        return zzoi0;
    }

    public final int zzh(Object object0, byte[] arr_b, int v, int v1, int v2, zzkv zzkv0) {
        int v126;
        int v125;
        int v124;
        int v121;
        int v117;
        int v115;
        int v114;
        int v112;
        Object object14;
        Object object13;
        Object object12;
        zzkv zzkv5;
        zzkv zzkv6;
        Unsafe unsafe5;
        int v53;
        int v51;
        int v103;
        int v101;
        int v69;
        int v100;
        int v95;
        int v94;
        int v93;
        int v92;
        int v68;
        int v67;
        int v59;
        long v47;
        Unsafe unsafe4;
        zzkv zzkv3;
        int v45;
        int v44;
        int v27;
        int v26;
        Object object4;
        Unsafe unsafe2;
        int v39;
        int v38;
        int v29;
        Object object5;
        Unsafe unsafe3;
        int v36;
        int v35;
        int v34;
        int v30;
        int v24;
        int v16;
        int v15;
        byte[] arr_b2;
        Object object2;
        zzkv zzkv2;
        int v14;
        int v13;
        Unsafe unsafe1;
        int v12;
        zzkv zzkv1 = zzkv0;
        Object object1 = object0;
        byte[] arr_b1 = arr_b;
        zzno.zzB(object1);
        Unsafe unsafe0 = zzno.zzb;
        int v3 = v;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v7 = -1;
        int v8 = 0xFFFFF;
        while(true) {
            if(v3 >= v1) {
                v14 = v5;
                object2 = object1;
                break;
            }
            int v9 = v3 + 1;
            int v10 = arr_b1[v3];
            if(v10 < 0) {
                v9 = zzkw.zzb(v10, arr_b1, v9, zzkv1);
                v10 = zzkv1.zza;
            }
            v6 = v10;
            int v11 = v6 >>> 3;
            if(v11 <= v7) {
                if(v11 >= this.zze && v11 <= this.zzf) {
                    v12 = this.zzN(v11, 0);
                }
            }
            else if(v11 >= this.zze && v11 <= this.zzf) {
                v12 = this.zzN(v11, v4 / 3);
            }
            else {
                v12 = -1;
            }
            if(v12 == -1) {
                unsafe1 = unsafe0;
                v13 = v8;
                v4 = 0;
                v14 = v5;
                zzkv2 = zzkv0;
                object2 = object1;
                arr_b2 = arr_b1;
                v15 = v11;
                v16 = v9;
            }
            else {
                int v17 = v6 & 7;
                int v18 = this.zzc[v12 + 1];
                int v19 = v18 >>> 20 & 0xFF;
                long v20 = (long)(v18 & 0xFFFFF);
                int[] arr_v = this.zzc;
                if(v19 <= 17) {
                    int v21 = arr_v[v12 + 2];
                    int v22 = 1 << (v21 >>> 20);
                    int v23 = v21 & 0xFFFFF;
                    if(v23 == v8) {
                        v24 = v12;
                        v23 = v8;
                    }
                    else {
                        v24 = v12;
                        if(v8 != 0xFFFFF) {
                            unsafe0.putInt(object1, ((long)v8), v5);
                        }
                        v5 = v23 == 0xFFFFF ? 0 : unsafe0.getInt(object1, ((long)v23));
                    }
                    switch(v19) {
                        case 0: {
                        label_73:
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v27 = v9;
                            v14 = v5;
                            v26 = v6;
                            if(v17 == 1) {
                                v3 = v27 + 8;
                                v5 = v14 | v22;
                                zzoo.zzm(object4, v20, Double.longBitsToDouble(zzkw.zze(arr_b, v27)));
                                object1 = object4;
                                unsafe0 = unsafe2;
                                arr_b1 = arr_b;
                                v8 = v23;
                                v7 = v11;
                                v6 = v26;
                                v4 = v24;
                                continue;
                            }
                            break;
                        }
                        case 1: {
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v27 = v9;
                            v14 = v5;
                            v26 = v6;
                            if(v17 == 5) {
                                v3 = v27 + 4;
                                v5 = v14 | v22;
                                zzoo.zzk(object4, v20, Float.intBitsToFloat(zzkw.zzd(arr_b, v27)));
                                object1 = object4;
                                unsafe0 = unsafe2;
                                arr_b1 = arr_b;
                                v8 = v23;
                                v7 = v11;
                                v6 = v26;
                                v4 = v24;
                                continue;
                            }
                            break;
                        }
                        case 2: 
                        case 3: {
                            v27 = v9;
                            v14 = v5;
                            v26 = v6;
                            if(v17 == 0) {
                                v5 = v14 | v22;
                                int v28 = zzkw.zzc(arr_b, v27, zzkv0);
                                unsafe0.putLong(object1, v20, zzkv0.zzb);
                                arr_b1 = arr_b;
                                v3 = v28;
                                v8 = v23;
                                v7 = v11;
                                v6 = v26;
                                v4 = v24;
                                continue;
                            }
                            else {
                                unsafe2 = unsafe0;
                                object4 = object1;
                                break;
                            }
                            goto label_112;
                        }
                        case 7: {
                            unsafe3 = unsafe0;
                            object5 = object1;
                            v27 = v9;
                            v14 = v5;
                            v26 = v6;
                            if(v17 == 0) {
                                v29 = v14 | v22;
                                v3 = zzkw.zzc(arr_b, v27, zzkv0);
                                zzoo.zzi(object5, v20, zzkv0.zzb != 0L);
                            label_161:
                                v5 = v29;
                                object1 = object5;
                                v7 = v11;
                                v6 = v26;
                                v4 = v24;
                                arr_b1 = arr_b;
                                unsafe0 = unsafe3;
                                v8 = v23;
                                continue;
                            }
                            object4 = object5;
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 8: {
                            unsafe3 = unsafe0;
                            v27 = v9;
                            v14 = v5;
                            v26 = v6;
                            if(v17 != 2) {
                            }
                            else if((v18 & 0x20000000) == 0) {
                                int v31 = zzkw.zza(arr_b, v27, zzkv0);
                                int v32 = zzkv0.zza;
                                if(v32 < 0) {
                                    throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                }
                                v30 = v14 | v22;
                                if(v32 == 0) {
                                    zzkv0.zzc = "";
                                }
                                else {
                                    zzkv0.zzc = new String(arr_b, v31, v32, zzmo.zza);
                                    v31 += v32;
                                }
                                v3 = v31;
                            label_189:
                                unsafe3.putObject(object1, v20, zzkv0.zzc);
                                v5 = v30;
                                v7 = v11;
                                v6 = v26;
                                v4 = v24;
                                arr_b1 = arr_b;
                                unsafe0 = unsafe3;
                                v8 = v23;
                                continue;
                            }
                            else {
                                v3 = zzkw.zzf(arr_b, v27, zzkv0);
                                v30 = v14 | v22;
                                goto label_189;
                            }
                            object4 = object1;
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 9: {
                            unsafe2 = unsafe0;
                            if(v17 == 2) {
                                v5 |= v22;
                                Object object6 = this.zzs(object1, v24);
                                unsafe3 = unsafe2;
                                v4 = v24;
                                int v33 = zzkw.zzj(object6, this.zzp(v24), arr_b, v9, v1, zzkv1);
                                this.zzt(object1, v4, object6);
                                v3 = v33;
                                v7 = v11;
                                arr_b1 = arr_b;
                                unsafe0 = unsafe3;
                                v8 = v23;
                                continue;
                            }
                            else {
                                v27 = v9;
                                object4 = object1;
                                v14 = v5;
                                v26 = v6;
                                break;
                            }
                            goto label_216;
                        }
                        case 10: {
                        label_216:
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v34 = v9;
                            v35 = v24;
                            if(v17 == 2) {
                                v5 |= v22;
                                v36 = zzkw.zzg(arr_b, v34, zzkv0);
                                unsafe2.putObject(object4, v20, zzkv0.zzc);
                                goto label_238;
                            }
                            goto label_246;
                        }
                        case 4: 
                        case 11: {
                        label_112:
                            v27 = v9;
                            v14 = v5;
                            v26 = v6;
                            if(v17 == 0) {
                                v5 = v14 | v22;
                                v3 = zzkw.zza(arr_b, v27, zzkv0);
                                unsafe0.putInt(object1, v20, zzkv0.zza);
                                arr_b1 = arr_b;
                                v8 = v23;
                                v7 = v11;
                                v6 = v26;
                                v4 = v24;
                                continue;
                            }
                            else {
                                unsafe2 = unsafe0;
                                object4 = object1;
                                break;
                            }
                            goto label_127;
                        }
                        case 12: {
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v34 = v9;
                            v35 = v24;
                            if(v17 == 0) {
                                v36 = zzkw.zza(arr_b, v34, zzkv0);
                                int v37 = zzkv0.zza;
                                zzmj zzmj0 = this.zzr(v35);
                                if((v18 & 0x80000000) == 0 || zzmj0 == null || zzmj0.zza(v37)) {
                                    v5 |= v22;
                                    unsafe2.putInt(object4, v20, v37);
                                }
                                else {
                                    zzno.zzg(object4).zzk(v6, ((long)v37));
                                }
                            label_238:
                                object1 = object4;
                                unsafe0 = unsafe2;
                                v4 = v35;
                                v3 = v36;
                                arr_b1 = arr_b;
                                v8 = v23;
                                v7 = v11;
                                continue;
                            }
                        label_246:
                            v24 = v35;
                            v27 = v34;
                            v14 = v5;
                            v26 = v6;
                            break;
                        }
                        case 6: 
                        case 13: {
                        label_142:
                            unsafe3 = unsafe0;
                            object5 = object1;
                            v27 = v9;
                            v14 = v5;
                            v26 = v6;
                            if(v17 == 5) {
                                v3 = v27 + 4;
                                v29 = v14 | v22;
                                unsafe3.putInt(object5, v20, zzkw.zzd(arr_b, v27));
                                goto label_161;
                            }
                            object4 = object5;
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 5: 
                        case 14: {
                        label_127:
                            v27 = v9;
                            v14 = v5;
                            v26 = v6;
                            if(v17 == 1) {
                                unsafe0.putLong(object1, v20, zzkw.zze(arr_b, v27));
                                arr_b1 = arr_b;
                                v3 = v27 + 8;
                                v8 = v23;
                                v5 = v14 | v22;
                                v7 = v11;
                                v6 = v26;
                                v4 = v24;
                                continue;
                            }
                            else {
                                object4 = object1;
                                unsafe2 = unsafe0;
                                break;
                            }
                            goto label_142;
                        }
                        case 15: {
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v38 = v9;
                            v39 = v24;
                            if(v17 == 0) {
                                v5 |= v22;
                                int v40 = zzkw.zza(arr_b, v38, zzkv0);
                                unsafe2.putInt(object4, v20, zzkv0.zza >>> 1 ^ -(zzkv0.zza & 1));
                                object1 = object4;
                                unsafe0 = unsafe2;
                                v3 = v40;
                                arr_b1 = arr_b;
                                v8 = v23;
                                v4 = v39;
                                v7 = v11;
                                continue;
                            }
                            goto label_276;
                        }
                        case 16: {
                            v38 = v9;
                            v39 = v24;
                            if(v17 == 0) {
                                v5 |= v22;
                                int v41 = zzkw.zzc(arr_b, v38, zzkv0);
                                unsafe0.putLong(object1, v20, zzkv0.zzb >>> 1 ^ -(1L & zzkv0.zzb));
                                arr_b1 = arr_b;
                                v3 = v41;
                                v8 = v23;
                                v4 = v39;
                                v7 = v11;
                                continue;
                            }
                            else {
                                unsafe2 = unsafe0;
                                object4 = object1;
                            }
                        label_276:
                            v27 = v38;
                            v24 = v39;
                            v14 = v5;
                            v26 = v6;
                            break;
                        }
                        default: {
                            if(v17 == 3) {
                                v5 |= v22;
                                Object object3 = this.zzs(object1, v24);
                                int v25 = zzkw.zzk(object3, this.zzp(v24), arr_b, v9, v1, v11 << 3 | 4, zzkv0);
                                this.zzt(object1, v24, object3);
                                v3 = v25;
                                arr_b1 = arr_b;
                                v8 = v23;
                                v4 = v24;
                                v7 = v11;
                                continue;
                            }
                            else {
                                unsafe2 = unsafe0;
                                object4 = object1;
                                v14 = v5;
                                v26 = v6;
                                v27 = v9;
                                break;
                            }
                            goto label_73;
                        }
                    }
                    v13 = v23;
                    v15 = v11;
                    object2 = object4;
                    unsafe1 = unsafe2;
                    v16 = v27;
                    arr_b2 = arr_b;
                    zzkv2 = zzkv0;
                    v6 = v26;
                    goto label_781;
                }
                else {
                    int v42 = v11;
                    v13 = v8;
                    v14 = v5;
                    if(v19 == 27) {
                        if(v17 == 2) {
                            zzmn zzmn0 = (zzmn)unsafe0.getObject(object1, v20);
                            if(!zzmn0.zza()) {
                                int v43 = zzmn0.size();
                                zzmn0 = zzmn0.zzg((v43 == 0 ? 10 : v43 + v43));
                                unsafe0.putObject(object1, v20, zzmn0);
                            }
                            arr_b1 = arr_b;
                            v3 = zzkw.zzn(this.zzp(v12), v6, arr_b1, v9, v1, zzmn0, zzkv0);
                            v4 = v12;
                            v7 = v42;
                            v8 = v13;
                            object1 = object0;
                            v5 = v14;
                            continue;
                        }
                        else {
                            v44 = v42;
                            v45 = v9;
                            zzkv3 = zzkv0;
                            object2 = object1;
                            unsafe4 = unsafe0;
                            goto label_865;
                        }
                        goto label_313;
                    }
                    else {
                    label_313:
                        object2 = object1;
                        if(v19 <= 49) {
                            zzmn zzmn1 = (zzmn)unsafe0.getObject(object2, v20);
                            if(zzmn1.zza()) {
                                v47 = (long)v18;
                            }
                            else {
                                int v46 = zzmn1.size();
                                v47 = (long)v18;
                                zzmn1 = zzmn1.zzg(v46 + v46);
                                unsafe0.putObject(object2, v20, zzmn1);
                            }
                            zzmn zzmn2 = zzmn1;
                            switch(v19) {
                                case 26: {
                                    v67 = v6;
                                    v51 = v9;
                                    unsafe5 = unsafe0;
                                    zzmn zzmn3 = zzmn2;
                                    if(v17 == 2) {
                                        if((v47 & 0x20000000L) == 0L) {
                                            int v79 = zzkw.zza(arr_b, v51, zzkv0);
                                            int v80 = zzkv0.zza;
                                            if(v80 >= 0) {
                                                if(v80 == 0) {
                                                    zzmn3.add("");
                                                    goto label_563;
                                                }
                                                else {
                                                    zzmn3.add(new String(arr_b, v79, v80, zzmo.zza));
                                                }
                                            alab1:
                                                while(true) {
                                                    v79 += v80;
                                                    while(true) {
                                                    label_563:
                                                        if(v79 >= v1) {
                                                            break alab1;
                                                        }
                                                        int v81 = zzkw.zza(arr_b, v79, zzkv0);
                                                        if(v67 != zzkv0.zza) {
                                                            break alab1;
                                                        }
                                                        v79 = zzkw.zza(arr_b, v81, zzkv0);
                                                        v80 = zzkv0.zza;
                                                        if(v80 < 0) {
                                                            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                        }
                                                        if(v80 != 0) {
                                                            zzmn3.add(new String(arr_b, v79, v80, zzmo.zza));
                                                            break;
                                                        }
                                                        zzmn3.add("");
                                                    }
                                                }
                                                v3 = v79;
                                                v24 = v12;
                                                v53 = v42;
                                                goto label_766;
                                            }
                                        }
                                        else {
                                            v68 = zzkw.zza(arr_b, v51, zzkv0);
                                            int v82 = zzkv0.zza;
                                            if(v82 >= 0) {
                                                if(v82 == 0) {
                                                    zzmn3.add("");
                                                    v53 = v42;
                                                    goto label_593;
                                                }
                                                else {
                                                    int v83 = v68 + v82;
                                                    if(!zzor.zza(arr_b, v68, v83)) {
                                                        throw new zzmq("Protocol message had invalid UTF-8.");
                                                    }
                                                    int v84 = v83;
                                                    v53 = v42;
                                                    zzmn3.add(new String(arr_b, v68, v82, zzmo.zza));
                                                alab2:
                                                    while(true) {
                                                        v68 = v84;
                                                        while(true) {
                                                        label_593:
                                                            if(v68 >= v1) {
                                                                v3 = v68;
                                                                v24 = v12;
                                                                goto label_766;
                                                            }
                                                            int v85 = zzkw.zza(arr_b, v68, zzkv0);
                                                            if(v67 != zzkv0.zza) {
                                                                v3 = v68;
                                                                v24 = v12;
                                                                goto label_766;
                                                            }
                                                            v68 = zzkw.zza(arr_b, v85, zzkv0);
                                                            int v86 = zzkv0.zza;
                                                            if(v86 < 0) {
                                                                throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                            }
                                                            if(v86 != 0) {
                                                                int v87 = v68 + v86;
                                                                if(!zzor.zza(arr_b, v68, v87)) {
                                                                    break alab2;
                                                                }
                                                                v84 = v87;
                                                                zzmn3.add(new String(arr_b, v68, v86, zzmo.zza));
                                                                break;
                                                            }
                                                            zzmn3.add("");
                                                        }
                                                    }
                                                    throw new zzmq("Protocol message had invalid UTF-8.");
                                                }
                                            }
                                        }
                                        throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                    }
                                    else {
                                        v53 = v42;
                                        v24 = v12;
                                        break;
                                    }
                                    goto label_617;
                                }
                                case 28: {
                                label_617:
                                    int v88 = v6;
                                    unsafe5 = unsafe0;
                                    if(v17 == 2) {
                                        int v89 = zzkw.zza(arr_b, v9, zzkv0);
                                        int v90 = zzkv0.zza;
                                        if(v90 < 0) {
                                            throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                        }
                                        if(v90 > arr_b.length - v89) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        if(v90 == 0) {
                                            zzmn2.add(zzlg.zzb);
                                            goto label_629;
                                        }
                                        else {
                                            zzmn2.add(zzlg.zzh(arr_b, v89, v90));
                                        }
                                    alab3:
                                        while(true) {
                                            v89 += v90;
                                            while(true) {
                                            label_629:
                                                if(v89 >= v1) {
                                                    goto label_643;
                                                }
                                                int v91 = zzkw.zza(arr_b, v89, zzkv0);
                                                if(v88 != zzkv0.zza) {
                                                    goto label_643;
                                                }
                                                v89 = zzkw.zza(arr_b, v91, zzkv0);
                                                v90 = zzkv0.zza;
                                                if(v90 < 0) {
                                                    throw new zzmq("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
                                                }
                                                if(v90 > arr_b.length - v89) {
                                                    break alab3;
                                                }
                                                if(v90 != 0) {
                                                    zzmn2.add(zzlg.zzh(arr_b, v89, v90));
                                                    break;
                                                }
                                                zzmn2.add(zzlg.zzb);
                                            }
                                        }
                                        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                    label_643:
                                        v51 = v9;
                                        v24 = v12;
                                        v53 = v42;
                                        v3 = v89;
                                        goto label_766;
                                    }
                                    else {
                                        v51 = v9;
                                        v24 = v12;
                                        v53 = v42;
                                        break;
                                    }
                                    goto label_654;
                                }
                                case 18: 
                                case 35: {
                                label_348:
                                    unsafe5 = unsafe0;
                                    v51 = v9;
                                    v53 = v42;
                                    if(v17 == 2) {
                                        zzln zzln0 = (zzln)zzmn2;
                                        int v54 = zzkw.zza(arr_b, v51, zzkv0);
                                        int v55 = zzkv0.zza;
                                        int v56 = v54 + v55;
                                        if(v56 > arr_b.length) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        zzln0.zzh(v55 / 8 + zzln0.size());
                                        while(v54 < v56) {
                                            zzln0.zzf(Double.longBitsToDouble(zzkw.zze(arr_b, v54)));
                                            v54 += 8;
                                        }
                                        v24 = v12;
                                        if(v54 != v56) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        v3 = v54;
                                        goto label_766;
                                    }
                                    else {
                                        v24 = v12;
                                        if(v17 == 1) {
                                            int v57 = v51 + 8;
                                            zzln zzln1 = (zzln)zzmn2;
                                            zzln1.zzf(Double.longBitsToDouble(zzkw.zze(arr_b, v51)));
                                            while(v57 < v1) {
                                                int v58 = zzkw.zza(arr_b, v57, zzkv0);
                                                if(v6 != zzkv0.zza) {
                                                    break;
                                                }
                                                zzln1.zzf(Double.longBitsToDouble(zzkw.zze(arr_b, v58)));
                                                v57 = v58 + 8;
                                            }
                                            v3 = v57;
                                            goto label_766;
                                        }
                                    }
                                    break;
                                }
                                case 19: 
                                case 36: {
                                    unsafe5 = unsafe0;
                                    v51 = v9;
                                    v53 = v42;
                                    if(v17 == 2) {
                                        zzlx zzlx0 = (zzlx)zzmn2;
                                        v59 = zzkw.zza(arr_b, v51, zzkv0);
                                        int v60 = zzkv0.zza;
                                        int v61 = v59 + v60;
                                        if(v61 > arr_b.length) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        zzlx0.zzh(v60 / 4 + zzlx0.size());
                                        while(v59 < v61) {
                                            zzlx0.zzf(Float.intBitsToFloat(zzkw.zzd(arr_b, v59)));
                                            v59 += 4;
                                        }
                                        if(v59 != v61) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        v3 = v59;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    else if(v17 == 5) {
                                        int v62 = v51 + 4;
                                        zzlx zzlx1 = (zzlx)zzmn2;
                                        zzlx1.zzf(Float.intBitsToFloat(zzkw.zzd(arr_b, v51)));
                                        while(v62 < v1) {
                                            int v63 = zzkw.zza(arr_b, v62, zzkv0);
                                            if(v6 != zzkv0.zza) {
                                                break;
                                            }
                                            zzlx1.zzf(Float.intBitsToFloat(zzkw.zzd(arr_b, v63)));
                                            v62 = v63 + 4;
                                        }
                                        v3 = v62;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    v24 = v12;
                                    break;
                                }
                                case 20: 
                                case 21: 
                                case 37: 
                                case 38: {
                                    unsafe5 = unsafe0;
                                    v51 = v9;
                                    v53 = v42;
                                    if(v17 == 2) {
                                        zzmz zzmz0 = (zzmz)zzmn2;
                                        v59 = zzkw.zza(arr_b, v51, zzkv0);
                                        int v64 = zzkv0.zza + v59;
                                        while(v59 < v64) {
                                            v59 = zzkw.zzc(arr_b, v59, zzkv0);
                                            zzmz0.zzf(zzkv0.zzb);
                                        }
                                        if(v59 != v64) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        v3 = v59;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    else if(v17 == 0) {
                                        zzmz zzmz1 = (zzmz)zzmn2;
                                        int v65 = zzkw.zzc(arr_b, v51, zzkv0);
                                        zzmz1.zzf(zzkv0.zzb);
                                        while(v65 < v1) {
                                            int v66 = zzkw.zza(arr_b, v65, zzkv0);
                                            if(v6 != zzkv0.zza) {
                                                break;
                                            }
                                            v65 = zzkw.zzc(arr_b, v66, zzkv0);
                                            zzmz1.zzf(zzkv0.zzb);
                                        }
                                        v3 = v65;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    v24 = v12;
                                    break;
                                }
                                case 25: 
                                case 42: {
                                    v67 = v6;
                                    v51 = v9;
                                    v53 = v42;
                                    unsafe5 = unsafe0;
                                    if(v17 == 2) {
                                        zzkx zzkx0 = (zzkx)zzmn2;
                                        v69 = zzkw.zza(arr_b, v51, zzkv0);
                                        int v76 = zzkv0.zza + v69;
                                        while(v69 < v76) {
                                            v69 = zzkw.zzc(arr_b, v69, zzkv0);
                                            zzkx0.zzf(zzkv0.zzb != 0L);
                                        }
                                        if(v69 != v76) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        v6 = v67;
                                        v3 = v69;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    else if(v17 == 0) {
                                        zzkx zzkx1 = (zzkx)zzmn2;
                                        int v77 = zzkw.zzc(arr_b, v51, zzkv0);
                                        zzkx1.zzf(zzkv0.zzb != 0L);
                                        while(v77 < v1) {
                                            int v78 = zzkw.zza(arr_b, v77, zzkv0);
                                            if(v67 != zzkv0.zza) {
                                                break;
                                            }
                                            v77 = zzkw.zzc(arr_b, v78, zzkv0);
                                            zzkx1.zzf(zzkv0.zzb != 0L);
                                        }
                                        v6 = v67;
                                        v3 = v77;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    v6 = v67;
                                    v24 = v12;
                                    break;
                                }
                                case 22: 
                                case 29: 
                                case 39: 
                                case 43: {
                                    v67 = v6;
                                    v51 = v9;
                                    v53 = v42;
                                    unsafe5 = unsafe0;
                                    if(v17 == 2) {
                                        v68 = zzkw.zzm(arr_b, v51, zzmn2, zzkv0);
                                        v3 = v68;
                                        v6 = v67;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    else if(v17 == 0) {
                                        v6 = v67;
                                        v3 = zzkw.zzl(v67, arr_b, v51, v1, zzmn2, zzkv0);
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    v6 = v67;
                                    v24 = v12;
                                    break;
                                }
                                case 30: 
                                case 44: {
                                label_654:
                                    v92 = v6;
                                    v51 = v9;
                                    unsafe5 = unsafe0;
                                    if(v17 == 2) {
                                        v93 = zzkw.zzm(arr_b, v51, zzmn2, zzkv0);
                                        v94 = v92;
                                        v95 = v51;
                                        goto label_666;
                                    }
                                    else if(v17 == 0) {
                                        v94 = v92;
                                        v95 = v51;
                                        v93 = zzkw.zzl(v94, arr_b, v95, v1, zzmn2, zzkv0);
                                    label_666:
                                        zzmj zzmj1 = this.zzr(v12);
                                        zzoh zzoh0 = this.zzl;
                                        if(zzmj1 == null) {
                                            v100 = v93;
                                        }
                                        else {
                                            if(zzmn2 == null) {
                                                throw new NullPointerException();
                                            }
                                            int v96 = zzmn2.size();
                                            Object object7 = null;
                                            int v98 = 0;
                                            for(int v97 = 0; v97 < v96; ++v97) {
                                                Integer integer0 = (Integer)zzmn2.get(v97);
                                                int v99 = (int)integer0;
                                                if(zzmj1.zza(v99)) {
                                                    if(v97 != v98) {
                                                        zzmn2.set(v98, integer0);
                                                    }
                                                    ++v98;
                                                }
                                                else {
                                                    object7 = zzny.zzE(object0, v42, v99, object7, zzoh0);
                                                }
                                            }
                                            v100 = v93;
                                            if(v98 != v96) {
                                                zzmn2.subList(v98, v96).clear();
                                            }
                                        }
                                        object2 = object0;
                                        v6 = v94;
                                        v51 = v95;
                                        v24 = v12;
                                        v53 = v42;
                                        v3 = v100;
                                        goto label_766;
                                    }
                                    goto label_761;
                                }
                                case 24: 
                                case 0x1F: 
                                case 41: 
                                case 45: {
                                    v67 = v6;
                                    v51 = v9;
                                    v53 = v42;
                                    unsafe5 = unsafe0;
                                    if(v17 == 2) {
                                        zzmf zzmf0 = (zzmf)zzmn2;
                                        v69 = zzkw.zza(arr_b, v51, zzkv0);
                                        int v73 = zzkv0.zza;
                                        int v74 = v69 + v73;
                                        if(v74 > arr_b.length) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        zzmf0.zzi(v73 / 4 + zzmf0.size());
                                        while(v69 < v74) {
                                            zzmf0.zzh(zzkw.zzd(arr_b, v69));
                                            v69 += 4;
                                        }
                                        if(v69 != v74) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        v6 = v67;
                                        v3 = v69;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    else if(v17 == 5) {
                                        v68 = v51 + 4;
                                        zzmf zzmf1 = (zzmf)zzmn2;
                                        zzmf1.zzh(zzkw.zzd(arr_b, v51));
                                        while(v68 < v1) {
                                            int v75 = zzkw.zza(arr_b, v68, zzkv0);
                                            if(v67 != zzkv0.zza) {
                                                break;
                                            }
                                            zzmf1.zzh(zzkw.zzd(arr_b, v75));
                                            v68 = v75 + 4;
                                        }
                                        v3 = v68;
                                        v6 = v67;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    v6 = v67;
                                    v24 = v12;
                                    break;
                                }
                                case 23: 
                                case 0x20: 
                                case 40: 
                                case 46: {
                                    v67 = v6;
                                    v51 = v9;
                                    v53 = v42;
                                    unsafe5 = unsafe0;
                                    if(v17 == 2) {
                                        zzmz zzmz2 = (zzmz)zzmn2;
                                        v69 = zzkw.zza(arr_b, v51, zzkv0);
                                        int v70 = zzkv0.zza;
                                        int v71 = v69 + v70;
                                        if(v71 > arr_b.length) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        zzmz2.zzh(v70 / 8 + zzmz2.size());
                                        while(v69 < v71) {
                                            zzmz2.zzf(zzkw.zze(arr_b, v69));
                                            v69 += 8;
                                        }
                                        if(v69 != v71) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        v6 = v67;
                                        v3 = v69;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    else if(v17 == 1) {
                                        v68 = v51 + 8;
                                        zzmz zzmz3 = (zzmz)zzmn2;
                                        zzmz3.zzf(zzkw.zze(arr_b, v51));
                                        while(v68 < v1) {
                                            int v72 = zzkw.zza(arr_b, v68, zzkv0);
                                            if(v67 != zzkv0.zza) {
                                                break;
                                            }
                                            zzmz3.zzf(zzkw.zze(arr_b, v72));
                                            v68 = v72 + 8;
                                        }
                                        v3 = v68;
                                        v6 = v67;
                                        v24 = v12;
                                        goto label_766;
                                    }
                                    v6 = v67;
                                    v24 = v12;
                                    break;
                                }
                                case 33: 
                                case 0x2F: {
                                    v92 = v6;
                                    v51 = v9;
                                    unsafe5 = unsafe0;
                                    if(v17 == 2) {
                                        zzmf zzmf2 = (zzmf)zzmn2;
                                        v101 = zzkw.zza(arr_b, v51, zzkv0);
                                        int v102 = zzkv0.zza + v101;
                                        while(v101 < v102) {
                                            v101 = zzkw.zza(arr_b, v101, zzkv0);
                                            zzmf2.zzh(zzkv0.zza >>> 1 ^ -(zzkv0.zza & 1));
                                        }
                                        if(v101 != v102) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        object2 = object0;
                                        v3 = v101;
                                        v24 = v12;
                                        v53 = v42;
                                        v6 = v92;
                                        goto label_766;
                                    }
                                    else if(v17 == 0) {
                                        zzmf zzmf3 = (zzmf)zzmn2;
                                        v103 = zzkw.zza(arr_b, v51, zzkv0);
                                        zzmf3.zzh(zzkv0.zza >>> 1 ^ -(zzkv0.zza & 1));
                                        while(v103 < v1) {
                                            int v104 = zzkw.zza(arr_b, v103, zzkv0);
                                            if(v92 != zzkv0.zza) {
                                                break;
                                            }
                                            v103 = zzkw.zza(arr_b, v104, zzkv0);
                                            zzmf3.zzh(zzkv0.zza >>> 1 ^ -(zzkv0.zza & 1));
                                        }
                                        object2 = object0;
                                        v3 = v103;
                                        v24 = v12;
                                        v53 = v42;
                                        v6 = v92;
                                        goto label_766;
                                    }
                                    goto label_761;
                                }
                                case 34: 
                                case 0x30: {
                                    v92 = v6;
                                    v51 = v9;
                                    if(v17 == 2) {
                                        zzmz zzmz4 = (zzmz)zzmn2;
                                        v101 = zzkw.zza(arr_b, v51, zzkv0);
                                        int v105 = zzkv0.zza + v101;
                                        while(v101 < v105) {
                                            v101 = zzkw.zzc(arr_b, v101, zzkv0);
                                            zzmz4.zzf(zzkv0.zzb >>> 1 ^ -(1L & zzkv0.zzb));
                                        }
                                        unsafe5 = unsafe0;
                                        if(v101 != v105) {
                                            throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                        }
                                        object2 = object0;
                                        v3 = v101;
                                        v24 = v12;
                                        v53 = v42;
                                        v6 = v92;
                                        goto label_766;
                                    }
                                    else {
                                        unsafe5 = unsafe0;
                                        if(v17 == 0) {
                                            zzmz zzmz5 = (zzmz)zzmn2;
                                            v103 = zzkw.zzc(arr_b, v51, zzkv0);
                                            zzmz5.zzf(zzkv0.zzb >>> 1 ^ -(1L & zzkv0.zzb));
                                            while(v103 < v1) {
                                                int v106 = zzkw.zza(arr_b, v103, zzkv0);
                                                if(v92 != zzkv0.zza) {
                                                    break;
                                                }
                                                v103 = zzkw.zzc(arr_b, v106, zzkv0);
                                                zzmz5.zzf(zzkv0.zzb >>> 1 ^ -(1L & zzkv0.zzb));
                                            }
                                            object2 = object0;
                                            v3 = v103;
                                            v24 = v12;
                                            v53 = v42;
                                            v6 = v92;
                                            goto label_766;
                                        }
                                    }
                                label_761:
                                    object2 = object0;
                                    v24 = v12;
                                    v53 = v42;
                                    v6 = v92;
                                    break;
                                }
                                default: {
                                    if(v17 == 3) {
                                        int v48 = v6 & -8 | 4;
                                        zznw zznw0 = this.zzp(v12);
                                        int v49 = v6;
                                        int v50 = zzkw.zzi(zznw0, arr_b, v9, v1, v48, zzkv0);
                                        v51 = v9;
                                        zzmn2.add(zzkv0.zzc);
                                        while(v50 < v1) {
                                            int v52 = zzkw.zza(arr_b, v50, zzkv0);
                                            if(v49 != zzkv0.zza) {
                                                break;
                                            }
                                            v50 = zzkw.zzi(zznw0, arr_b, v52, v1, v48, zzkv0);
                                            zzmn2.add(zzkv0.zzc);
                                        }
                                        v3 = v50;
                                        v24 = v12;
                                        v53 = v42;
                                        unsafe5 = unsafe0;
                                        goto label_766;
                                    }
                                    else {
                                        unsafe5 = unsafe0;
                                        v24 = v12;
                                        v51 = v9;
                                        v53 = v42;
                                        break;
                                    }
                                    goto label_348;
                                }
                            }
                            v3 = v51;
                        label_766:
                            if(v3 == v51) {
                                arr_b2 = arr_b;
                                v16 = v3;
                                zzkv2 = zzkv0;
                                unsafe1 = unsafe5;
                                v15 = v53;
                            }
                            else {
                                arr_b1 = arr_b;
                                zzkv1 = zzkv0;
                                object1 = object2;
                                v8 = v13;
                                unsafe0 = unsafe5;
                                v5 = v14;
                                v7 = v53;
                                v4 = v24;
                                continue;
                            }
                        label_781:
                            v4 = v24;
                        }
                        else {
                            v45 = v9;
                            v44 = v42;
                            zzkv zzkv4 = zzkv0;
                            if(v19 == 50) {
                                if(v17 == 2) {
                                    Object object8 = this.zzq(v12);
                                    zznf zznf0 = unsafe0.getObject(object2, v20);
                                    if(!zznf0.zze()) {
                                        zznf zznf1 = zznf.zza().zzc();
                                        zzng.zza(zznf1, zznf0);
                                        unsafe0.putObject(object2, v20, zznf1);
                                        zznf0 = zznf1;
                                    }
                                    zznd zznd0 = ((zzne)object8).zze();
                                    int v107 = zzkw.zza(arr_b, v45, zzkv4);
                                    int v108 = zzkv4.zza;
                                    if(v108 < 0 || v108 > v1 - v107) {
                                        throw new zzmq("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
                                    }
                                    int v109 = v107 + v108;
                                    Object object9 = zznd0.zzb;
                                    Object object10 = zznd0.zzd;
                                    Object object11 = object10;
                                    while(v107 < v109) {
                                        int v110 = v107 + 1;
                                        int v111 = arr_b[v107];
                                        if(v111 < 0) {
                                            v110 = zzkw.zzb(v111, arr_b, v110, zzkv4);
                                            v111 = zzkv4.zza;
                                        }
                                        switch(v111 >>> 3) {
                                            case 1: {
                                                zzkv6 = zzkv4;
                                                object12 = object9;
                                                object13 = object10;
                                                zzos zzos0 = zznd0.zza;
                                                if((v111 & 7) == zzos0.zzb()) {
                                                    v107 = zzno.zzO(arr_b, v110, v1, zzos0, null, zzkv6);
                                                    zzkv4 = zzkv6;
                                                    object9 = zzkv6.zzc;
                                                    goto label_840;
                                                }
                                                zzkv5 = zzkv6;
                                                object14 = object11;
                                                v112 = v110;
                                                break;
                                            }
                                            case 2: {
                                                zzos zzos1 = zznd0.zzc;
                                                if((v111 & 7) == zzos1.zzb()) {
                                                    v107 = zzno.zzO(arr_b, v110, v1, zzos1, object10.getClass(), zzkv4);
                                                    object11 = zzkv4.zzc;
                                                    continue;
                                                }
                                                else {
                                                    zzkv6 = zzkv4;
                                                    object12 = object9;
                                                    object13 = object10;
                                                }
                                                zzkv5 = zzkv6;
                                                object14 = object11;
                                                v112 = v110;
                                                break;
                                            }
                                            default: {
                                                zzkv5 = zzkv4;
                                                object12 = object9;
                                                object13 = object10;
                                                object14 = object11;
                                                v112 = v110;
                                            }
                                        }
                                        v107 = zzkw.zzp(v111, arr_b, v112, v1, zzkv5);
                                        zzkv4 = zzkv5;
                                        object9 = object12;
                                        object11 = object14;
                                    label_840:
                                        object10 = object13;
                                    }
                                    if(v107 == v109) {
                                        zznf0.put(object9, object11);
                                        if(v109 == v45) {
                                            v16 = v109;
                                            unsafe1 = unsafe0;
                                            v4 = v12;
                                            zzkv2 = zzkv4;
                                            arr_b2 = arr_b;
                                            v15 = v44;
                                            goto label_1078;
                                        }
                                        else {
                                            v3 = v109;
                                            zzkv1 = zzkv4;
                                            object1 = object2;
                                            v5 = v14;
                                            v7 = v44;
                                            arr_b1 = arr_b;
                                            v4 = v12;
                                            v8 = v13;
                                            continue;
                                        }
                                    }
                                    throw new zzmq("Failed to parse the message.");
                                }
                                else {
                                    zzkv3 = zzkv4;
                                    unsafe4 = unsafe0;
                                }
                            label_865:
                                arr_b2 = arr_b;
                                unsafe1 = unsafe4;
                                v4 = v12;
                                v15 = v44;
                                zzkv2 = zzkv3;
                                v16 = v45;
                            }
                            else {
                                unsafe1 = unsafe0;
                                long v113 = (long)(arr_v[v12 + 2] & 0xFFFFF);
                                switch(v19) {
                                    case 51: {
                                        arr_b2 = arr_b;
                                        v24 = v12;
                                        v114 = v45;
                                        v15 = v44;
                                        zzkv2 = zzkv0;
                                        if(v17 == 1) {
                                            v115 = v114 + 8;
                                            unsafe1.putObject(object2, v20, Double.longBitsToDouble(zzkw.zze(arr_b2, v114)));
                                            unsafe1.putInt(object2, v113, v15);
                                            v3 = v115;
                                            break;
                                        }
                                        v3 = v114;
                                        break;
                                    }
                                    case 52: {
                                        arr_b2 = arr_b;
                                        v24 = v12;
                                        v114 = v45;
                                        v15 = v44;
                                        zzkv2 = zzkv0;
                                        if(v17 == 5) {
                                            v115 = v114 + 4;
                                            unsafe1.putObject(object2, v20, Float.intBitsToFloat(zzkw.zzd(arr_b2, v114)));
                                            unsafe1.putInt(object2, v113, v15);
                                            v3 = v115;
                                            break;
                                        }
                                        v3 = v114;
                                        break;
                                    }
                                    case 53: 
                                    case 54: {
                                        arr_b2 = arr_b;
                                        v24 = v12;
                                        v114 = v45;
                                        v15 = v44;
                                        zzkv2 = zzkv0;
                                        if(v17 == 0) {
                                            v3 = zzkw.zzc(arr_b2, v114, zzkv2);
                                            unsafe1.putObject(object2, v20, zzkv2.zzb);
                                            unsafe1.putInt(object2, v113, v15);
                                            break;
                                        }
                                        v3 = v114;
                                        break;
                                    }
                                    case 58: {
                                        v24 = v12;
                                        v114 = v45;
                                        v15 = v44;
                                        zzkv2 = zzkv0;
                                        if(v17 == 0) {
                                            int v116 = zzkw.zzc(arr_b, v114, zzkv2);
                                            unsafe1.putObject(object2, v20, Boolean.valueOf(zzkv2.zzb != 0L));
                                            unsafe1.putInt(object2, v113, v15);
                                            v3 = v116;
                                            arr_b2 = arr_b;
                                        }
                                        else {
                                            arr_b2 = arr_b;
                                            v3 = v114;
                                        }
                                        break;
                                    }
                                    case 59: {
                                        v24 = v12;
                                        v114 = v45;
                                        v15 = v44;
                                        zzkv2 = zzkv0;
                                        if(v17 == 2) {
                                            v117 = zzkw.zza(arr_b, v114, zzkv2);
                                            int v118 = zzkv2.zza;
                                            if(v118 == 0) {
                                                unsafe1.putObject(object2, v20, "");
                                            }
                                            else {
                                                int v119 = v117 + v118;
                                                if((v18 & 0x20000000) != 0 && !zzor.zza(arr_b, v117, v119)) {
                                                    throw new zzmq("Protocol message had invalid UTF-8.");
                                                }
                                                unsafe1.putObject(object2, v20, new String(arr_b, v117, v118, zzmo.zza));
                                                v117 = v119;
                                            }
                                            unsafe1.putInt(object2, v113, v15);
                                            arr_b2 = arr_b;
                                            v3 = v117;
                                        }
                                        else {
                                            arr_b2 = arr_b;
                                            v3 = v114;
                                        }
                                        break;
                                    }
                                    case 60: {
                                        if(v17 == 2) {
                                            Object object15 = this.zzu(object2, v44, v12);
                                            int v120 = zzkw.zzj(object15, this.zzp(v12), arr_b, v45, v1, zzkv0);
                                            this.zzv(object2, v44, v12, object15);
                                            v3 = v120;
                                            v24 = v12;
                                            v15 = v44;
                                            zzkv2 = zzkv0;
                                            arr_b2 = arr_b;
                                            v114 = v45;
                                        }
                                        else {
                                            arr_b2 = arr_b;
                                            v24 = v12;
                                            v15 = v44;
                                            v114 = v45;
                                            zzkv2 = zzkv0;
                                            v3 = v114;
                                        }
                                        break;
                                    }
                                    case 61: {
                                        v121 = v44;
                                        if(v17 == 2) {
                                            v117 = zzkw.zzg(arr_b, v45, zzkv0);
                                            unsafe1.putObject(object2, v20, zzkv0.zzc);
                                            unsafe1.putInt(object2, v113, v121);
                                            arr_b2 = arr_b;
                                            v24 = v12;
                                            v15 = v121;
                                            v114 = v45;
                                            zzkv2 = zzkv0;
                                            v3 = v117;
                                            break;
                                        }
                                        goto label_1043;
                                    }
                                    case 55: 
                                    case 62: {
                                        arr_b2 = arr_b;
                                        v24 = v12;
                                        v114 = v45;
                                        v15 = v44;
                                        zzkv2 = zzkv0;
                                        if(v17 == 0) {
                                            v115 = zzkw.zza(arr_b2, v114, zzkv2);
                                            unsafe1.putObject(object2, v20, zzkv2.zza);
                                            unsafe1.putInt(object2, v113, v15);
                                            v3 = v115;
                                            break;
                                        }
                                        v3 = v114;
                                        break;
                                    }
                                    case 0x3F: {
                                        v24 = v12;
                                        v121 = v44;
                                        if(v17 == 0) {
                                            int v122 = zzkw.zza(arr_b, v45, zzkv0);
                                            int v123 = zzkv0.zza;
                                            zzmj zzmj2 = this.zzr(v24);
                                            if(zzmj2 == null || zzmj2.zza(v123)) {
                                                unsafe1.putObject(object2, v20, v123);
                                                unsafe1.putInt(object2, v113, v121);
                                            }
                                            else {
                                                zzno.zzg(object2).zzk(v6, ((long)v123));
                                            }
                                            arr_b2 = arr_b;
                                            v15 = v121;
                                            v114 = v45;
                                            zzkv2 = zzkv0;
                                            v3 = v122;
                                            break;
                                        }
                                        goto label_1026;
                                    }
                                    case 57: 
                                    case 0x40: {
                                        v24 = v12;
                                        v114 = v45;
                                        v15 = v44;
                                        zzkv2 = zzkv0;
                                        if(v17 == 5) {
                                            arr_b2 = arr_b;
                                            unsafe1.putObject(object2, v20, zzkw.zzd(arr_b2, v114));
                                            unsafe1.putInt(object2, v113, v15);
                                            v3 = v114 + 4;
                                        }
                                        else {
                                            arr_b2 = arr_b;
                                            v3 = v114;
                                        }
                                        break;
                                    }
                                    case 56: 
                                    case 65: {
                                        arr_b2 = arr_b;
                                        v24 = v12;
                                        v114 = v45;
                                        v15 = v44;
                                        zzkv2 = zzkv0;
                                        if(v17 == 1) {
                                            v115 = v114 + 8;
                                            unsafe1.putObject(object2, v20, zzkw.zze(arr_b2, v114));
                                            unsafe1.putInt(object2, v113, v15);
                                            v3 = v115;
                                            break;
                                        }
                                        v3 = v114;
                                        break;
                                    }
                                    case 66: {
                                        v24 = v12;
                                        v121 = v44;
                                        if(v17 == 0) {
                                            v124 = zzkw.zza(arr_b, v45, zzkv0);
                                            unsafe1.putObject(object2, v20, ((int)(zzkv0.zza >>> 1 ^ -(zzkv0.zza & 1))));
                                            unsafe1.putInt(object2, v113, v121);
                                            goto label_1037;
                                        }
                                    label_1026:
                                        arr_b2 = arr_b;
                                        zzkv2 = zzkv0;
                                        v15 = v121;
                                        v114 = v45;
                                        v3 = v114;
                                        break;
                                    }
                                    case 67: {
                                        v121 = v44;
                                        if(v17 == 0) {
                                            v124 = zzkw.zzc(arr_b, v45, zzkv0);
                                            v24 = v12;
                                            unsafe1.putObject(object2, v20, ((long)(zzkv0.zzb >>> 1 ^ -(1L & zzkv0.zzb))));
                                            unsafe1.putInt(object2, v113, v121);
                                        label_1037:
                                            zzkv2 = zzkv0;
                                            v15 = v121;
                                            v114 = v45;
                                            v3 = v124;
                                            arr_b2 = arr_b;
                                            break;
                                        }
                                    label_1043:
                                        arr_b2 = arr_b;
                                        v24 = v12;
                                        v15 = v121;
                                        v114 = v45;
                                        zzkv2 = zzkv0;
                                        v3 = v114;
                                        break;
                                    }
                                    case 68: {
                                        if(v17 == 3) {
                                            Object object16 = this.zzu(object2, v44, v12);
                                            v124 = zzkw.zzk(object16, this.zzp(v12), arr_b, v45, v1, v6 & -8 | 4, zzkv0);
                                            this.zzv(object2, v44, v12, object16);
                                            v24 = v12;
                                            v15 = v44;
                                            v114 = v45;
                                            zzkv2 = zzkv0;
                                            v3 = v124;
                                            arr_b2 = arr_b;
                                            break;
                                        }
                                    label_1060:
                                        arr_b2 = arr_b;
                                        v24 = v12;
                                        v114 = v45;
                                        v15 = v44;
                                        zzkv2 = zzkv0;
                                        v3 = v114;
                                        break;
                                    }
                                    default: {
                                        goto label_1060;
                                    }
                                }
                                if(v3 == v114) {
                                    v16 = v3;
                                    v4 = v24;
                                }
                                else {
                                    unsafe0 = unsafe1;
                                    arr_b1 = arr_b2;
                                    zzkv1 = zzkv2;
                                    v7 = v15;
                                    object1 = object2;
                                    v8 = v13;
                                    v5 = v14;
                                    v4 = v24;
                                    continue;
                                }
                            }
                        }
                    }
                }
            }
        label_1078:
            if(v6 != v2 || v2 == 0) {
                if(this.zzh) {
                    zzlq zzlq0 = zzkv2.zzd;
                    if(zzlq0 != zzlq.zza) {
                        if(zzlq0.zzb(this.zzg, v15) == null) {
                            v125 = v6;
                            v126 = zzkw.zzo(v125, arr_b2, v16, v1, zzno.zzg(object2), zzkv2);
                            goto label_1094;
                        }
                        zzmb zzmb0 = (zzmb)object2;
                        throw null;
                    }
                }
                v125 = v6;
                v126 = zzkw.zzo(v125, arr_b, v16, v1, zzno.zzg(object2), zzkv0);
            label_1094:
                v3 = v126;
                arr_b1 = arr_b;
                v6 = v125;
                v7 = v15;
                object1 = object2;
                v8 = v13;
                v5 = v14;
                unsafe0 = unsafe1;
                continue;
            }
            else {
                unsafe0 = unsafe1;
                v3 = v16;
                v8 = v13;
            }
            break;
        }
        if(v8 != 0xFFFFF) {
            unsafe0.putInt(object2, ((long)v8), v14);
        }
        int v127 = this.zzj;
        zzoi zzoi0 = null;
        while(v127 < this.zzk) {
            zzoh zzoh1 = this.zzl;
            int v128 = this.zzi[v127];
            int v129 = this.zzc[v128];
            Object object17 = zzoo.zzn(object2, ((long)(this.zzx(v128) & 0xFFFFF)));
            if(object17 != null) {
                zzmj zzmj3 = this.zzr(v128);
                if(zzmj3 != null) {
                    zznd zznd1 = ((zzne)this.zzq(v128)).zze();
                    Iterator iterator0 = ((zznf)object17).entrySet().iterator();
                    while(iterator0.hasNext()) {
                        Object object18 = iterator0.next();
                        Map.Entry map$Entry0 = (Map.Entry)object18;
                        if(!zzmj3.zza(((int)(((Integer)map$Entry0.getValue()))))) {
                            if(zzoi0 == null) {
                                zzoi0 = zzoh1.zza(object2);
                            }
                            int v130 = zzne.zzc(zznd1, map$Entry0.getKey(), map$Entry0.getValue());
                            byte[] arr_b3 = new byte[v130];
                            zzlj zzlj0 = new zzlj(arr_b3, 0, v130);
                            try {
                                zzne.zzb(zzlj0, zznd1, map$Entry0.getKey(), map$Entry0.getValue());
                            }
                            catch(IOException iOException0) {
                                throw new RuntimeException(iOException0);
                            }
                            zzoi0.zzk(v129 << 3 | 2, zzld.zza(zzlj0, arr_b3));
                            iterator0.remove();
                        }
                    }
                }
            }
            ++v127;
        }
        if(zzoi0 != null) {
            ((zzme)object2).zzc = zzoi0;
        }
        if(v2 == 0) {
            if(v3 != v1) {
                throw new zzmq("Failed to parse the message.");
            }
            return v3;
        }
        if(v3 > v1 || v6 != v2) {
            throw new zzmq("Failed to parse the message.");
        }
        return v3;
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final void zzi(Object object0, byte[] arr_b, int v, int v1, zzkv zzkv0) {
        this.zzh(object0, arr_b, v, v1, 0, zzkv0);
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final void zzj(Object object0) {
        if(zzno.zzA(object0)) {
            if(object0 instanceof zzme) {
                ((zzme)object0).zzcm(0x7FFFFFFF);
                ((zzme)object0).zza = 0;
                ((zzme)object0).zzcg();
            }
            int[] arr_v = this.zzc;
            for(int v = 0; v < arr_v.length; v += 3) {
                int v1 = this.zzx(v);
                long v2 = (long)(0xFFFFF & v1);
                switch(v1 >>> 20 & 0xFF) {
                    case 9: 
                    case 17: {
                        if(this.zzJ(object0, v)) {
                            this.zzp(v).zzj(zzno.zzb.getObject(object0, v2));
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
                        ((zzmn)zzoo.zzn(object0, v2)).zzb();
                        break;
                    }
                    case 50: {
                        Unsafe unsafe0 = zzno.zzb;
                        Object object1 = unsafe0.getObject(object0, v2);
                        if(object1 != null) {
                            ((zznf)object1).zzd();
                            unsafe0.putObject(object0, v2, object1);
                        }
                        break;
                    }
                    case 60: 
                    case 68: {
                        if(this.zzL(object0, arr_v[v], v)) {
                            this.zzp(v).zzj(zzno.zzb.getObject(object0, v2));
                        }
                    }
                }
            }
            this.zzl.zzb(object0);
            if(this.zzh) {
                this.zzm.zza(object0);
            }
        }
    }

    @Override  // com.google.android.gms.internal.measurement.zznw
    public final boolean zzk(Object object0) {
        int v11;
        int v10;
        int v9;
        int v = 0;
        int v1 = 0;
        int v2 = 0xFFFFF;
        while(v1 < this.zzj) {
            int v3 = this.zzi[v1];
            int v4 = this.zzc[v3];
            int v5 = this.zzx(v3);
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
                    v = zzno.zzb.getInt(object0, ((long)v7));
                }
                v9 = v3;
                v10 = v;
                v11 = v7;
            }
            if((0x10000000 & v5) != 0 && !this.zzI(object0, v9, v11, v10, v8)) {
                return false;
            }
            switch(v5 >>> 20 & 0xFF) {
                case 9: 
                case 17: {
                    if(this.zzI(object0, v9, v11, v10, v8) && !zzno.zzw(object0, v5, this.zzp(v9))) {
                        return false;
                    }
                    break;
                }
                case 27: 
                case 49: {
                    List list0 = (List)zzoo.zzn(object0, ((long)(v5 & 0xFFFFF)));
                    if(!list0.isEmpty()) {
                        zznw zznw1 = this.zzp(v9);
                        for(int v12 = 0; v12 < list0.size(); ++v12) {
                            if(!zznw1.zzk(list0.get(v12))) {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 50: {
                    zznf zznf0 = (zznf)zzoo.zzn(object0, ((long)(v5 & 0xFFFFF)));
                    if(!zznf0.isEmpty() && ((zzne)this.zzq(v9)).zze().zzc.zza() == zzot.zzi) {
                        zznw zznw0 = null;
                        Iterator iterator0 = zznf0.values().iterator();
                        while(true) {
                            if(!iterator0.hasNext()) {
                                break;
                            }
                            Object object1 = iterator0.next();
                            if(zznw0 == null) {
                                zznw0 = zznt.zza().zzb(object1.getClass());
                            }
                            if(zznw0.zzk(object1)) {
                                continue;
                            }
                            return false;
                        }
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.zzL(object0, v4, v9) && !zzno.zzw(object0, v5, this.zzp(v9))) {
                        return false;
                    }
                }
            }
            ++v1;
            v2 = v11;
            v = v10;
        }
        return !this.zzh || ((zzmb)object0).zzb.zze();
    }

    public static zzno zzl(Class class0, zzni zzni0, zznq zznq0, zzmx zzmx0, zzoh zzoh0, zzlr zzlr0, zzng zzng0) {
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
        zznv zznv1;
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
        if(zzni0 instanceof zznv) {
            zznv zznv0 = (zznv)zzni0;
            String s = zznv0.zzd();
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
                arr_v = zzno.zza;
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
            Unsafe unsafe0 = zzno.zzb;
            Object[] arr_object = zznv0.zze();
            Class class1 = zznv0.zzb().getClass();
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
                        zznv1 = zznv0;
                        if(v69 < 0xD800) {
                            break;
                        }
                        v66 |= (v69 & 0x1FFF) << v68;
                        v68 += 13;
                        ++v67;
                        zznv0 = zznv1;
                    }
                    v65 = v66 | v69 << v68;
                    v70 = v67 + 1;
                }
                else {
                    zznv1 = zznv0;
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
                            if(zznv1.zzc() == 1 || v71 != 0) {
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
                        field0 = zzno.zzm(class1, ((String)object0));
                        arr_object[v80] = field0;
                    }
                    int v81 = (int)unsafe0.objectFieldOffset(field0);
                    Object object1 = arr_object[v80 + 1];
                    if(object1 instanceof Field) {
                        field1 = (Field)object1;
                    }
                    else {
                        field1 = zzno.zzm(class1, ((String)object1));
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
                    Field field2 = zzno.zzm(class1, ((String)arr_object[v9]));
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
                            if(zznv1.zzc() == 1 || v71 != 0) {
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
                            field3 = zzno.zzm(class1, ((String)object2));
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
                zznv0 = zznv1;
                v14 = v82;
                arr_object1 = arr_object2;
            }
            return new zzno(arr_v1, arr_object1, v11, v12, zznv0.zzb(), false, arr_v, v13, v54, zznq0, zzmx0, zzoh0, zzlr0, zzng0);
        }
        zzoe zzoe0 = (zzoe)zzni0;
        throw null;
    }

    private static Field zzm(Class class0, String s) {
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
            String s1 = class0.getName();
            String s2 = Arrays.toString(arr_field);
            StringBuilder stringBuilder0 = new StringBuilder(Z.e(11, s) + s1.length() + 29 + String.valueOf(s2).length());
            d.u(stringBuilder0, "Field ", s, " for ", s1);
            throw new RuntimeException(x.m(stringBuilder0, " not found. Known fields are ", s2), noSuchFieldException0);
        }
    }

    private final void zzn(Object object0, Object object1, int v) {
        if(!this.zzJ(object1, v)) {
            return;
        }
        int v1 = this.zzx(v);
        Unsafe unsafe0 = zzno.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException("Source subfield " + this.zzc[v] + " is present but null: " + object1.toString());
        }
        zznw zznw0 = this.zzp(v);
        if(!this.zzJ(object0, v)) {
            if(zzno.zzA(object2)) {
                Object object3 = zznw0.zza();
                zznw0.zzd(object3, object2);
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object2);
            }
            this.zzK(object0, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(!zzno.zzA(object4)) {
            Object object5 = zznw0.zza();
            zznw0.zzd(object5, object4);
            unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zznw0.zzd(object4, object2);
    }

    private final void zzo(Object object0, Object object1, int v) {
        int[] arr_v = this.zzc;
        int v1 = arr_v[v];
        if(!this.zzL(object1, v1, v)) {
            return;
        }
        int v2 = this.zzx(v);
        Unsafe unsafe0 = zzno.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v2 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException("Source subfield " + arr_v[v] + " is present but null: " + object1.toString());
        }
        zznw zznw0 = this.zzp(v);
        if(!this.zzL(object0, v1, v)) {
            if(zzno.zzA(object2)) {
                Object object3 = zznw0.zza();
                zznw0.zzd(object3, object2);
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object2);
            }
            this.zzM(object0, v1, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(!zzno.zzA(object4)) {
            Object object5 = zznw0.zza();
            zznw0.zzd(object5, object4);
            unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zznw0.zzd(object4, object2);
    }

    private final zznw zzp(int v) {
        Object[] arr_object = this.zzd;
        int v1 = v / 3 + v / 3;
        zznw zznw0 = (zznw)arr_object[v1];
        if(zznw0 != null) {
            return zznw0;
        }
        zznw zznw1 = zznt.zza().zzb(((Class)arr_object[v1 + 1]));
        arr_object[v1] = zznw1;
        return zznw1;
    }

    private final Object zzq(int v) {
        return this.zzd[v / 3 + v / 3];
    }

    private final zzmj zzr(int v) {
        return (zzmj)this.zzd[v / 3 * 2 + 1];
    }

    private final Object zzs(Object object0, int v) {
        zznw zznw0 = this.zzp(v);
        int v1 = this.zzx(v);
        if(!this.zzJ(object0, v)) {
            return zznw0.zza();
        }
        Object object1 = zzno.zzb.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(zzno.zzA(object1)) {
            return object1;
        }
        Object object2 = zznw0.zza();
        if(object1 != null) {
            zznw0.zzd(object2, object1);
        }
        return object2;
    }

    private final void zzt(Object object0, int v, Object object1) {
        int v1 = this.zzx(v);
        zzno.zzb.putObject(object0, ((long)(v1 & 0xFFFFF)), object1);
        this.zzK(object0, v);
    }

    private final Object zzu(Object object0, int v, int v1) {
        zznw zznw0 = this.zzp(v1);
        if(!this.zzL(object0, v, v1)) {
            return zznw0.zza();
        }
        int v2 = this.zzx(v1);
        Object object1 = zzno.zzb.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(zzno.zzA(object1)) {
            return object1;
        }
        Object object2 = zznw0.zza();
        if(object1 != null) {
            zznw0.zzd(object2, object1);
        }
        return object2;
    }

    private final void zzv(Object object0, int v, int v1, Object object1) {
        int v2 = this.zzx(v1);
        zzno.zzb.putObject(object0, ((long)(v2 & 0xFFFFF)), object1);
        this.zzM(object0, v, v1);
    }

    private static boolean zzw(Object object0, int v, zznw zznw0) {
        return zznw0.zzk(zzoo.zzn(object0, ((long)(v & 0xFFFFF))));
    }

    private final int zzx(int v) {
        return this.zzc[v + 1];
    }

    private final int zzy(int v) {
        return this.zzc[v + 2];
    }

    private static int zzz(int v) [...] // Inlined contents
}

