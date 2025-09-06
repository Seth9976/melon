package com.google.android.gms.internal.play_billing;

import A7.d;
import H0.b;
import b3.Z;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import sun.misc.Unsafe;

final class zzef implements zzeo {
    private static final int[] zza;
    private static final Unsafe zzb;
    private final int[] zzc;
    private final Object[] zzd;
    private final int zze;
    private final int zzf;
    private final zzec zzg;
    private final boolean zzh;
    private final int[] zzi;
    private final int zzj;
    private final int zzk;
    private final zzdq zzl;
    private final zzff zzm;
    private final zzce zzn;
    private final zzei zzo;
    private final zzdx zzp;

    static {
        zzef.zza = new int[0];
        zzef.zzb = zzfp.zzg();
    }

    private zzef(int[] arr_v, Object[] arr_object, int v, int v1, zzec zzec0, int v2, boolean z, int[] arr_v1, int v3, int v4, zzei zzei0, zzdq zzdq0, zzff zzff0, zzce zzce0, zzdx zzdx0) {
        this.zzc = arr_v;
        this.zzd = arr_object;
        this.zze = v;
        this.zzf = v1;
        this.zzh = zzce0 != null && zzce0.zzf(zzec0);
        this.zzi = arr_v1;
        this.zzj = v3;
        this.zzk = v4;
        this.zzo = zzei0;
        this.zzl = zzdq0;
        this.zzm = zzff0;
        this.zzn = zzce0;
        this.zzg = zzec0;
        this.zzp = zzdx0;
    }

    private static void zzA(Object object0) {
        if(!zzef.zzL(object0)) {
            throw new IllegalArgumentException("Mutating immutable message: " + object0);
        }
    }

    private final void zzB(Object object0, Object object1, int v) {
        if(!this.zzI(object1, v)) {
            return;
        }
        int v1 = this.zzs(v);
        Unsafe unsafe0 = zzef.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v1 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException(b.f(this.zzc[v], "Source subfield ", " is present but null: ", object1.toString()));
        }
        zzeo zzeo0 = this.zzv(v);
        if(!this.zzI(object0, v)) {
            if(zzef.zzL(object2)) {
                Object object3 = zzeo0.zze();
                zzeo0.zzg(object3, object2);
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object2);
            }
            this.zzD(object0, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(!zzef.zzL(object4)) {
            Object object5 = zzeo0.zze();
            zzeo0.zzg(object5, object4);
            unsafe0.putObject(object0, ((long)(v1 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zzeo0.zzg(object4, object2);
    }

    private final void zzC(Object object0, Object object1, int v) {
        int v1 = this.zzc[v];
        if(!this.zzM(object1, v1, v)) {
            return;
        }
        int v2 = this.zzs(v);
        Unsafe unsafe0 = zzef.zzb;
        Object object2 = unsafe0.getObject(object1, ((long)(v2 & 0xFFFFF)));
        if(object2 == null) {
            throw new IllegalStateException(b.f(this.zzc[v], "Source subfield ", " is present but null: ", object1.toString()));
        }
        zzeo zzeo0 = this.zzv(v);
        if(!this.zzM(object0, v1, v)) {
            if(zzef.zzL(object2)) {
                Object object3 = zzeo0.zze();
                zzeo0.zzg(object3, object2);
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object3);
            }
            else {
                unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object2);
            }
            this.zzE(object0, v1, v);
            return;
        }
        Object object4 = unsafe0.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(!zzef.zzL(object4)) {
            Object object5 = zzeo0.zze();
            zzeo0.zzg(object5, object4);
            unsafe0.putObject(object0, ((long)(v2 & 0xFFFFF)), object5);
            object4 = object5;
        }
        zzeo0.zzg(object4, object2);
    }

    private final void zzD(Object object0, int v) {
        int v1 = this.zzp(v);
        if(((long)(0xFFFFF & v1)) == 0xFFFFFL) {
            return;
        }
        zzfp.zzq(object0, ((long)(0xFFFFF & v1)), 1 << (v1 >>> 20) | zzfp.zzc(object0, ((long)(0xFFFFF & v1))));
    }

    private final void zzE(Object object0, int v, int v1) {
        zzfp.zzq(object0, ((long)(this.zzp(v1) & 0xFFFFF)), v);
    }

    private final void zzF(Object object0, int v, Object object1) {
        int v1 = this.zzs(v);
        zzef.zzb.putObject(object0, ((long)(v1 & 0xFFFFF)), object1);
        this.zzD(object0, v);
    }

    private final void zzG(Object object0, int v, int v1, Object object1) {
        int v2 = this.zzs(v1);
        zzef.zzb.putObject(object0, ((long)(v2 & 0xFFFFF)), object1);
        this.zzE(object0, v, v1);
    }

    private final boolean zzH(Object object0, Object object1, int v) {
        return this.zzI(object0, v) == this.zzI(object1, v);
    }

    private final boolean zzI(Object object0, int v) {
        int v1 = this.zzp(v);
        if(Long.compare(v1 & 0xFFFFF, 0xFFFFFL) == 0) {
            int v2 = this.zzs(v);
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    return Double.doubleToRawLongBits(zzfp.zza(object0, ((long)(v2 & 0xFFFFF)))) != 0L;
                }
                case 1: {
                    return Float.floatToRawIntBits(zzfp.zzb(object0, ((long)(v2 & 0xFFFFF)))) != 0;
                }
                case 2: {
                    return zzfp.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 3: {
                    return zzfp.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 4: {
                    return zzfp.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 5: {
                    return zzfp.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 6: {
                    return zzfp.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 7: {
                    return zzfp.zzw(object0, ((long)(v2 & 0xFFFFF)));
                }
                case 8: {
                    Object object1 = zzfp.zzf(object0, ((long)(v2 & 0xFFFFF)));
                    if(object1 instanceof String) {
                        return !((String)object1).isEmpty();
                    }
                    if(!(object1 instanceof zzbq)) {
                        throw new IllegalArgumentException();
                    }
                    return !zzbq.zzb.equals(object1);
                }
                case 9: {
                    return zzfp.zzf(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                case 10: {
                    Object object2 = zzfp.zzf(object0, ((long)(v2 & 0xFFFFF)));
                    return !zzbq.zzb.equals(object2);
                }
                case 11: {
                    return zzfp.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 12: {
                    return zzfp.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 13: {
                    return zzfp.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 14: {
                    return zzfp.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 15: {
                    return zzfp.zzc(object0, ((long)(v2 & 0xFFFFF))) != 0;
                }
                case 16: {
                    return zzfp.zzd(object0, ((long)(v2 & 0xFFFFF))) != 0L;
                }
                case 17: {
                    return zzfp.zzf(object0, ((long)(v2 & 0xFFFFF))) != null;
                }
                default: {
                    throw new IllegalArgumentException();
                }
            }
        }
        return (zzfp.zzc(object0, ((long)(v1 & 0xFFFFF))) & 1 << (v1 >>> 20)) != 0;
    }

    private final boolean zzJ(Object object0, int v, int v1, int v2, int v3) {
        return v1 == 0xFFFFF ? this.zzI(object0, v) : (v2 & v3) != 0;
    }

    private static boolean zzK(Object object0, int v, zzeo zzeo0) {
        return zzeo0.zzk(zzfp.zzf(object0, ((long)(v & 0xFFFFF))));
    }

    private static boolean zzL(Object object0) {
        if(object0 == null) {
            return false;
        }
        return object0 instanceof zzcs ? ((zzcs)object0).zzw() : true;
    }

    private final boolean zzM(Object object0, int v, int v1) {
        return zzfp.zzc(object0, ((long)(this.zzp(v1) & 0xFFFFF))) == v;
    }

    private static boolean zzN(Object object0, long v) {
        return ((Boolean)zzfp.zzf(object0, v)).booleanValue();
    }

    private static final void zzO(int v, Object object0, zzfx zzfx0) {
        if(object0 instanceof String) {
            zzfx0.zzG(v, ((String)object0));
            return;
        }
        zzfx0.zzd(v, ((zzbq)object0));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final int zza(Object object0) {
        int v45;
        int v44;
        int v40;
        int v39;
        int v38;
        int v37;
        int v36;
        int v35;
        int v32;
        int v28;
        int v21;
        int v18;
        int v17;
        int v16;
        int v13;
        int v12;
        int v11;
        int v9;
        Unsafe unsafe0 = zzef.zzb;
        int v = 0xFFFFF;
        int v1 = 0;
        int v2 = 0;
        int v3 = 0;
        while(v1 < this.zzc.length) {
            int v4 = this.zzs(v1);
            int v5 = v4 >>> 20 & 0xFF;
            int v6 = this.zzc[v1];
            int v7 = this.zzc[v1 + 2];
            int v8 = v7 & 0xFFFFF;
            if(v5 <= 17) {
                if(v8 != v) {
                    v2 = v8 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v8));
                    v = v8;
                }
                v9 = 1 << (v7 >>> 20);
            }
            else {
                v9 = 0;
            }
            boolean z = v5 < zzcj.zzJ.zza();
            long v10 = (long)(v4 & 0xFFFFF);
            switch(v5) {
                case 0: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 = Z.C(v6 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 1: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 = Z.C(v6 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 2: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v11 = zzby.zzw(v6 << 3);
                        v12 = zzby.zzx(unsafe0.getLong(object0, v10));
                        v3 += v12 + v11;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 3: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v11 = zzby.zzw(v6 << 3);
                        v12 = zzby.zzx(unsafe0.getLong(object0, v10));
                        v3 += v12 + v11;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 4: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v11 = zzby.zzw(v6 << 3);
                        v12 = zzby.zzx(unsafe0.getInt(object0, v10));
                        v3 += v12 + v11;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 5: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 = Z.C(v6 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 6: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 = Z.C(v6 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 7: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 = Z.C(v6 << 3, 1, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 8: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        Object object1 = unsafe0.getObject(object0, v10);
                        if(object1 instanceof zzbq) {
                            v13 = ((zzbq)object1).zzd();
                            v3 += zzby.zzw(v13) + v13 + zzby.zzw(v6 << 3);
                            v1 += 3;
                            continue;
                        }
                        else {
                            v11 = zzby.zzw(v6 << 3);
                            v12 = zzby.zzv(((String)object1));
                        }
                        v3 += v12 + v11;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 9: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 += zzeq.zzh(v6, unsafe0.getObject(object0, v10), this.zzv(v1));
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 10: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v13 = ((zzbq)unsafe0.getObject(object0, v10)).zzd();
                        v3 += zzby.zzw(v13) + v13 + zzby.zzw(v6 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 11: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 = Z.C(unsafe0.getInt(object0, v10), zzby.zzw(v6 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 12: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 += zzby.zzx(unsafe0.getInt(object0, v10)) + zzby.zzw(v6 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 13: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 = Z.C(v6 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 14: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 = Z.C(v6 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 15: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        int v14 = unsafe0.getInt(object0, v10);
                        v3 = Z.C(v14 >> 0x1F ^ v14 + v14, zzby.zzw(v6 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 16: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        long v15 = unsafe0.getLong(object0, v10);
                        v3 += zzby.zzx(v15 >> 0x3F ^ v15 + v15) + zzby.zzw(v6 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 17: {
                    if(this.zzJ(object0, v1, v, v2, v9)) {
                        v3 += zzby.zzt(v6, ((zzec)unsafe0.getObject(object0, v10)), this.zzv(v1));
                    }
                    v1 += 3;
                    continue;
                }
                case 18: {
                    v3 += zzeq.zzd(v6, ((List)unsafe0.getObject(object0, v10)), false);
                    v1 += 3;
                    continue;
                }
                case 19: {
                    v3 += zzeq.zzb(v6, ((List)unsafe0.getObject(object0, v10)), false);
                    v1 += 3;
                    continue;
                }
                case 20: {
                    List list0 = (List)unsafe0.getObject(object0, v10);
                    if(list0.size() != 0) {
                        v3 += zzby.zzw(v6 << 3) * list0.size() + zzeq.zzg(list0);
                        v1 += 3;
                        continue;
                    }
                    v17 = 0;
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 21: {
                    List list1 = (List)unsafe0.getObject(object0, v10);
                    v16 = list1.size();
                    if(v16 != 0) {
                        v17 = zzby.zzw(v6 << 3) * v16 + zzeq.zzl(list1);
                        v3 += v17;
                        v1 += 3;
                        continue;
                    }
                    v17 = 0;
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 22: {
                    List list2 = (List)unsafe0.getObject(object0, v10);
                    v16 = list2.size();
                    v17 = v16 == 0 ? 0 : zzby.zzw(v6 << 3) * v16 + zzeq.zzf(list2);
                    v3 += v17;
                    v1 += 3;
                    continue;
                }
                case 23: {
                    v18 = zzeq.zzd(v6, ((List)unsafe0.getObject(object0, v10)), false);
                    v3 += v18;
                    v1 += 3;
                    continue;
                }
                case 24: {
                    v3 += zzeq.zzb(v6, ((List)unsafe0.getObject(object0, v10)), false);
                    v1 += 3;
                    continue;
                }
                case 25: {
                    int v19 = ((List)unsafe0.getObject(object0, v10)).size();
                    if(v19 != 0) {
                        v18 = v19 * (zzby.zzw(v6 << 3) + 1);
                        v3 += v18;
                        v1 += 3;
                        continue;
                    }
                    v18 = 0;
                    v3 += v18;
                    break;
                }
                case 26: {
                    List list3 = (List)unsafe0.getObject(object0, v10);
                    int v20 = list3.size();
                    if(v20 == 0) {
                        v21 = 0;
                    }
                    else {
                        int v22 = zzby.zzw(v6 << 3) * v20;
                        if(list3 instanceof zzdk) {
                            zzdk zzdk0 = (zzdk)list3;
                            v21 = v22;
                            for(int v23 = 0; v23 < v20; ++v23) {
                                Object object2 = zzdk0.zzf(v23);
                                if(object2 instanceof zzbq) {
                                    int v24 = ((zzbq)object2).zzd();
                                    v21 = Z.C(v24, v24, v21);
                                }
                                else {
                                    v21 = zzby.zzv(((String)object2)) + v21;
                                }
                            }
                        }
                        else {
                            v21 = v22;
                            for(int v25 = 0; v25 < v20; ++v25) {
                                Object object3 = list3.get(v25);
                                if(object3 instanceof zzbq) {
                                    int v26 = ((zzbq)object3).zzd();
                                    v21 = Z.C(v26, v26, v21);
                                }
                                else {
                                    v21 = zzby.zzv(((String)object3)) + v21;
                                }
                            }
                        }
                    }
                    v3 += v21;
                    v1 += 3;
                    continue;
                }
                case 27: {
                    List list4 = (List)unsafe0.getObject(object0, v10);
                    zzeo zzeo0 = this.zzv(v1);
                    int v27 = list4.size();
                    if(v27 == 0) {
                        v28 = 0;
                    }
                    else {
                        v28 = zzby.zzw(v6 << 3) * v27;
                        for(int v29 = 0; v29 < v27; ++v29) {
                            Object object4 = list4.get(v29);
                            if(object4 instanceof zzdi) {
                                int v30 = ((zzdi)object4).zza();
                                v28 = Z.C(v30, v30, v28);
                            }
                            else {
                                v28 = zzby.zzu(((zzec)object4), zzeo0) + v28;
                            }
                        }
                    }
                    v3 += v28;
                    v1 += 3;
                    continue;
                }
                case 28: {
                    List list5 = (List)unsafe0.getObject(object0, v10);
                    int v31 = list5.size();
                    if(v31 == 0) {
                        v32 = 0;
                    }
                    else {
                        v32 = zzby.zzw(v6 << 3) * v31;
                        for(int v33 = 0; v33 < list5.size(); ++v33) {
                            int v34 = ((zzbq)list5.get(v33)).zzd();
                            v32 = Z.C(v34, v34, v32);
                        }
                    }
                    v3 += v32;
                    v1 += 3;
                    continue;
                }
                case 29: {
                    List list6 = (List)unsafe0.getObject(object0, v10);
                    v35 = list6.size();
                    v18 = v35 == 0 ? 0 : zzeq.zzk(list6) + zzby.zzw(v6 << 3) * v35;
                    v3 += v18;
                    break;
                }
                case 30: {
                    List list7 = (List)unsafe0.getObject(object0, v10);
                    v35 = list7.size();
                    v18 = v35 == 0 ? 0 : zzeq.zza(list7) + zzby.zzw(v6 << 3) * v35;
                    v3 += v18;
                    v1 += 3;
                    continue;
                }
                case 0x1F: {
                    v18 = zzeq.zzb(v6, ((List)unsafe0.getObject(object0, v10)), false);
                    v3 += v18;
                    v1 += 3;
                    continue;
                }
                case 0x20: {
                    v3 += zzeq.zzd(v6, ((List)unsafe0.getObject(object0, v10)), false);
                    v1 += 3;
                    continue;
                }
                case 33: {
                    List list8 = (List)unsafe0.getObject(object0, v10);
                    v36 = list8.size();
                    if(v36 != 0) {
                        v37 = zzby.zzw(v6 << 3) * v36 + zzeq.zzi(list8);
                        v3 += v37;
                        v1 += 3;
                        continue;
                    }
                    v37 = 0;
                    v3 += v37;
                    v1 += 3;
                    continue;
                }
                case 34: {
                    List list9 = (List)unsafe0.getObject(object0, v10);
                    v36 = list9.size();
                    if(v36 != 0) {
                        v3 += zzby.zzw(v6 << 3) * v36 + zzeq.zzj(list9);
                        v1 += 3;
                        continue;
                    }
                    v37 = 0;
                    v3 += v37;
                    v1 += 3;
                    continue;
                }
                case 35: {
                    v38 = zzeq.zze(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 36: {
                    v38 = zzeq.zzc(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 37: {
                    v38 = zzeq.zzg(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 38: {
                    v38 = zzeq.zzl(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 39: {
                    v38 = zzeq.zzf(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 40: {
                    v38 = zzeq.zze(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 41: {
                    v38 = zzeq.zzc(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 42: {
                    v38 = ((List)unsafe0.getObject(object0, v10)).size();
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 43: {
                    v38 = zzeq.zzk(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 44: {
                    v38 = zzeq.zza(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 45: {
                    v38 = zzeq.zzc(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 46: {
                    v38 = zzeq.zze(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x2F: {
                    v38 = zzeq.zzi(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x30: {
                    v38 = zzeq.zzj(((List)unsafe0.getObject(object0, v10)));
                    if(v38 > 0) {
                        v39 = zzby.zzw(v6 << 3);
                        v40 = zzby.zzw(v38);
                        v3 += v40 + v39 + v38;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 49: {
                    List list10 = (List)unsafe0.getObject(object0, v10);
                    zzeo zzeo1 = this.zzv(v1);
                    int v41 = list10.size();
                    if(v41 == 0) {
                        v37 = 0;
                    }
                    else {
                        int v42 = 0;
                        for(int v43 = 0; v43 < v41; ++v43) {
                            v42 += zzby.zzt(v6, ((zzec)list10.get(v43)), zzeo1);
                        }
                        v37 = v42;
                    }
                    v3 += v37;
                    v1 += 3;
                    continue;
                }
                case 50: {
                    Object object5 = unsafe0.getObject(object0, v10);
                    Object object6 = this.zzw(v1);
                    zzdw zzdw0 = (zzdw)object5;
                    zzdv zzdv0 = (zzdv)object6;
                    if(!zzdw0.isEmpty()) {
                        Iterator iterator0 = zzdw0.entrySet().iterator();
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
                    if(this.zzM(object0, v6, v1)) {
                        v3 = Z.C(v6 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 52: {
                    if(this.zzM(object0, v6, v1)) {
                        v3 = Z.C(v6 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 53: {
                    if(this.zzM(object0, v6, v1)) {
                        v44 = zzby.zzw(v6 << 3);
                        v45 = zzby.zzx(zzef.zzt(object0, v10));
                        v3 += v45 + v44;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 54: {
                    if(this.zzM(object0, v6, v1)) {
                        v44 = zzby.zzw(v6 << 3);
                        v45 = zzby.zzx(zzef.zzt(object0, v10));
                        v3 += v45 + v44;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 55: {
                    if(this.zzM(object0, v6, v1)) {
                        v44 = zzby.zzw(v6 << 3);
                        v45 = zzby.zzx(zzef.zzo(object0, v10));
                        v3 += v45 + v44;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 56: {
                    if(this.zzM(object0, v6, v1)) {
                        v3 = Z.C(v6 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 57: {
                    if(this.zzM(object0, v6, v1)) {
                        v3 = Z.C(v6 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 58: {
                    if(this.zzM(object0, v6, v1)) {
                        v3 = Z.C(v6 << 3, 1, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 59: {
                    if(this.zzM(object0, v6, v1)) {
                        Object object8 = unsafe0.getObject(object0, v10);
                        if(object8 instanceof zzbq) {
                            v39 = ((zzbq)object8).zzd();
                            v3 += zzby.zzw(v39) + v39 + zzby.zzw(v6 << 3);
                            break;
                        }
                        else {
                            v44 = zzby.zzw(v6 << 3);
                            v45 = zzby.zzv(((String)object8));
                        }
                        v3 += v45 + v44;
                        v1 += 3;
                        continue;
                    }
                    v1 += 3;
                    continue;
                }
                case 60: {
                    if(this.zzM(object0, v6, v1)) {
                        v3 += zzeq.zzh(v6, unsafe0.getObject(object0, v10), this.zzv(v1));
                    }
                    v1 += 3;
                    continue;
                }
                case 61: {
                    if(this.zzM(object0, v6, v1)) {
                        v39 = ((zzbq)unsafe0.getObject(object0, v10)).zzd();
                        v3 += zzby.zzw(v39) + v39 + zzby.zzw(v6 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 62: {
                    if(this.zzM(object0, v6, v1)) {
                        v3 = Z.C(zzef.zzo(object0, v10), zzby.zzw(v6 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 0x3F: {
                    if(this.zzM(object0, v6, v1)) {
                        v3 += zzby.zzx(zzef.zzo(object0, v10)) + zzby.zzw(v6 << 3);
                        break;
                    }
                    v1 += 3;
                    continue;
                }
                case 0x40: {
                    if(this.zzM(object0, v6, v1)) {
                        v3 = Z.C(v6 << 3, 4, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 65: {
                    if(this.zzM(object0, v6, v1)) {
                        v3 = Z.C(v6 << 3, 8, v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 66: {
                    if(this.zzM(object0, v6, v1)) {
                        int v46 = zzef.zzo(object0, v10);
                        v3 = Z.C(v46 >> 0x1F ^ v46 + v46, zzby.zzw(v6 << 3), v3);
                    }
                    v1 += 3;
                    continue;
                }
                case 67: {
                    if(this.zzM(object0, v6, v1)) {
                        long v47 = zzef.zzt(object0, v10);
                        v3 += zzby.zzx(v47 >> 0x3F ^ v47 + v47) + zzby.zzw(v6 << 3);
                    }
                    v1 += 3;
                    continue;
                }
                case 68: {
                    if(this.zzM(object0, v6, v1)) {
                        v3 += zzby.zzt(v6, ((zzec)unsafe0.getObject(object0, v10)), this.zzv(v1));
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
        int v48 = 0;
        Object object9 = this.zzm.zzd(object0);
        int v49 = v3 + this.zzm.zza(object9);
        if(this.zzh) {
            zzci zzci0 = this.zzn.zzb(object0);
            for(int v50 = 0; v50 < zzci0.zza.zzb(); ++v50) {
                Map.Entry map$Entry0 = zzci0.zza.zzg(v50);
                v48 += zzci.zzb(((zzch)map$Entry0.getKey()), map$Entry0.getValue());
            }
            for(Object object10: zzci0.zza.zzc()) {
                v48 += zzci.zzb(((zzch)((Map.Entry)object10).getKey()), ((Map.Entry)object10).getValue());
            }
            return v49 + v48;
        }
        return v49;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final int zzb(Object object0) {
        int v10;
        int v9;
        int v8;
        long v7;
        int v6;
        int v1 = 0;
        for(int v = 0; v < this.zzc.length; v += 3) {
            int v2 = this.zzs(v);
            int v3 = this.zzc[v];
            long v4 = (long)(0xFFFFF & v2);
            int v5 = 37;
            switch(v2 >>> 20 & 0xFF) {
                case 0: {
                    v6 = v1 * 53;
                    v7 = Double.doubleToLongBits(zzfp.zza(object0, v4));
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 1: {
                    v9 = v1 * 53;
                    v10 = Float.floatToIntBits(zzfp.zzb(object0, v4));
                    v1 = v10 + v9;
                    break;
                }
                case 2: {
                    v6 = v1 * 53;
                    v7 = zzfp.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 3: {
                    v6 = v1 * 53;
                    v7 = zzfp.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 4: {
                    v6 = v1 * 53;
                    v8 = zzfp.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 5: {
                    v6 = v1 * 53;
                    v7 = zzfp.zzd(object0, v4);
                    v8 = (int)(v7 ^ v7 >>> 0x20);
                    v1 = v6 + v8;
                    break;
                }
                case 6: {
                    v6 = v1 * 53;
                    v8 = zzfp.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 7: {
                    v9 = v1 * 53;
                    v10 = zzda.zza(zzfp.zzw(object0, v4));
                    v1 = v10 + v9;
                    break;
                }
                case 8: {
                    v9 = v1 * 53;
                    v10 = ((String)zzfp.zzf(object0, v4)).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 9: {
                    Object object1 = zzfp.zzf(object0, v4);
                    if(object1 != null) {
                        v5 = object1.hashCode();
                    }
                    v1 = v1 * 53 + v5;
                    break;
                }
                case 10: {
                    v9 = v1 * 53;
                    v10 = zzfp.zzf(object0, v4).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 11: {
                    v6 = v1 * 53;
                    v8 = zzfp.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 12: {
                    v6 = v1 * 53;
                    v8 = zzfp.zzc(object0, v4);
                    v1 = v6 + v8;
                    break;
                }
                case 13: {
                    v1 = v1 * 53 + zzfp.zzc(object0, v4);
                    break;
                }
                case 14: {
                    v7 = zzfp.zzd(object0, v4);
                    v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    break;
                }
                case 15: {
                    v1 = v1 * 53 + zzfp.zzc(object0, v4);
                    break;
                }
                case 16: {
                    v7 = zzfp.zzd(object0, v4);
                    v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    break;
                }
                case 17: {
                    Object object2 = zzfp.zzf(object0, v4);
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
                    v10 = zzfp.zzf(object0, v4).hashCode();
                    v1 = v10 + v9;
                    break;
                }
                case 50: {
                    v1 = zzfp.zzf(object0, v4).hashCode() + v1 * 53;
                    break;
                }
                case 51: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = Double.doubleToLongBits(zzef.zzm(object0, v4));
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 52: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = Float.floatToIntBits(zzef.zzn(object0, v4)) + v1 * 53;
                    }
                    break;
                }
                case 53: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = zzef.zzt(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 54: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = zzef.zzt(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 55: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzef.zzo(object0, v4);
                    }
                    break;
                }
                case 56: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = zzef.zzt(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 57: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzef.zzo(object0, v4);
                    }
                    break;
                }
                case 58: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = zzda.zza(zzef.zzN(object0, v4)) + v1 * 53;
                    }
                    break;
                }
                case 59: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = ((String)zzfp.zzf(object0, v4)).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 60: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = zzfp.zzf(object0, v4).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 61: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = zzfp.zzf(object0, v4).hashCode() + v1 * 53;
                    }
                    break;
                }
                case 62: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzef.zzo(object0, v4);
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzef.zzo(object0, v4);
                    }
                    break;
                }
                case 0x40: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzef.zzo(object0, v4);
                    }
                    break;
                }
                case 65: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = zzef.zzt(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 66: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = v1 * 53 + zzef.zzo(object0, v4);
                    }
                    break;
                }
                case 67: {
                    if(this.zzM(object0, v3, v)) {
                        v7 = zzef.zzt(object0, v4);
                        v1 = v1 * 53 + ((int)(v7 ^ v7 >>> 0x20));
                    }
                    break;
                }
                case 68: {
                    if(this.zzM(object0, v3, v)) {
                        v1 = zzfp.zzf(object0, v4).hashCode() + v1 * 53;
                    }
                }
            }
        }
        int v11 = this.zzm.zzd(object0).hashCode() + v1 * 53;
        return this.zzh ? v11 * 53 + this.zzn.zzb(object0).zza.hashCode() : v11;
    }

    public final int zzc(Object object0, byte[] arr_b, int v, int v1, int v2, zzbc zzbc0) {
        int v121;
        int v120;
        int v115;
        int v114;
        int v109;
        int v108;
        int v107;
        zzef zzef3;
        int v101;
        int v100;
        int v99;
        int v98;
        int v94;
        zzcz zzcz5;
        int v92;
        int v74;
        int v68;
        int v66;
        int v87;
        Unsafe unsafe5;
        zzef zzef2;
        int v32;
        int v31;
        int v30;
        int v29;
        Object object4;
        Unsafe unsafe2;
        Object object5;
        int v56;
        int v55;
        int v54;
        Unsafe unsafe4;
        int v52;
        int v51;
        int v49;
        int v40;
        int v39;
        int v36;
        Unsafe unsafe3;
        int v33;
        int v27;
        int v26;
        int v25;
        Object object2;
        zzef zzef1;
        int v16;
        int v15;
        int v14;
        int v13;
        byte[] arr_b2;
        Unsafe unsafe1;
        int v12;
        zzef zzef0 = this;
        Object object1 = object0;
        byte[] arr_b1 = arr_b;
        zzef.zzA(object1);
        Unsafe unsafe0 = zzef.zzb;
        int v3 = v;
        int v4 = 0;
        int v5 = 0;
        int v6 = 0;
        int v7 = -1;
        int v8 = 0xFFFFF;
        while(true) {
            if(v3 >= v1) {
                zzef1 = zzef0;
                unsafe1 = unsafe0;
                break;
            }
            int v9 = v3 + 1;
            int v10 = arr_b1[v3];
            if(v10 < 0) {
                v9 = zzbd.zzi(v10, arr_b1, v9, zzbc0);
                v10 = zzbc0.zza;
            }
            v6 = v10;
            int v11 = v6 >>> 3;
            if(v11 <= v7) {
                if(v11 >= zzef0.zze && v11 <= zzef0.zzf) {
                    v12 = zzef0.zzq(v11, 0);
                }
            }
            else if(v11 >= zzef0.zze && v11 <= zzef0.zzf) {
                v12 = zzef0.zzq(v11, v4 / 3);
            }
            else {
                v12 = -1;
            }
            if(v12 == -1) {
                unsafe1 = unsafe0;
                arr_b2 = arr_b1;
                v13 = v11;
                v14 = v9;
                v4 = 0;
                v15 = v5;
                v16 = v6;
                zzef1 = zzef0;
                object2 = object1;
            }
            else {
                int v17 = 10;
                int v18 = v6 & 7;
                int[] arr_v = zzef0.zzc;
                int v19 = arr_v[v12 + 1];
                int v20 = v19 >>> 20 & 0xFF;
                long v21 = (long)(v19 & 0xFFFFF);
                if(v20 <= 17) {
                    int v22 = arr_v[v12 + 2];
                    int v23 = 1 << (v22 >>> 20);
                    int v24 = v22 & 0xFFFFF;
                    if(v24 == v8) {
                        v25 = v9;
                        v26 = v5;
                        v27 = v8;
                    }
                    else {
                        v25 = v9;
                        if(v8 != 0xFFFFF) {
                            unsafe0.putInt(object1, ((long)v8), v5);
                        }
                        v26 = v24 == 0xFFFFF ? 0 : unsafe0.getInt(object1, ((long)v24));
                        v27 = v24;
                    }
                    switch(v20) {
                        case 0: {
                        label_78:
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v29 = v26;
                            v31 = v27;
                            v32 = v25;
                            v30 = v12;
                            arr_b2 = arr_b;
                            if(v18 == 1) {
                                v33 = v32 + 8;
                                v5 = v29 | v23;
                                zzfp.zzo(object4, v21, Double.longBitsToDouble(zzbd.zzn(arr_b2, v32)));
                                goto label_101;
                            }
                            break;
                        }
                        case 1: {
                            unsafe2 = unsafe0;
                            object4 = object1;
                            v29 = v26;
                            v31 = v27;
                            v32 = v25;
                            v30 = v12;
                            arr_b2 = arr_b;
                            if(v18 == 5) {
                                v33 = v32 + 4;
                                v5 = v29 | v23;
                                zzfp.zzp(object4, v21, Float.intBitsToFloat(zzbd.zzb(arr_b2, v32)));
                            label_101:
                                object1 = object4;
                                unsafe0 = unsafe2;
                                v3 = v33;
                                arr_b1 = arr_b2;
                                v8 = v31;
                                v4 = v30;
                                v7 = v11;
                                continue;
                            }
                            break;
                        }
                        case 2: 
                        case 3: {
                            unsafe3 = unsafe0;
                            object4 = object1;
                            v29 = v26;
                            v31 = v27;
                            v32 = v25;
                            v30 = v12;
                            arr_b2 = arr_b;
                            if(v18 == 0) {
                                v5 = v29 | v23;
                                int v34 = zzbd.zzk(arr_b2, v32, zzbc0);
                                object1 = object4;
                                unsafe0 = unsafe3;
                                unsafe0.putLong(object1, v21, zzbc0.zzb);
                                arr_b1 = arr_b2;
                                v3 = v34;
                                v8 = v31;
                                v4 = v30;
                                v7 = v11;
                                continue;
                            }
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 7: {
                            unsafe3 = unsafe0;
                            v29 = v26;
                            v30 = v12;
                            object5 = object1;
                            v32 = v25;
                            if(v18 == 0) {
                                int v35 = zzbd.zzk(arr_b, v32, zzbc0);
                                v31 = v27;
                                zzfp.zzm(object5, v21, zzbc0.zzb != 0L);
                                v3 = v35;
                                v5 = v29 | v23;
                            label_180:
                                object1 = object5;
                                v4 = v30;
                                v7 = v11;
                                arr_b1 = arr_b;
                                unsafe0 = unsafe3;
                                v8 = v31;
                                continue;
                            }
                            else {
                                v31 = v27;
                            }
                            arr_b2 = arr_b;
                            object4 = object5;
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 8: {
                            v29 = v26;
                            v32 = v25;
                            if(v18 == 2) {
                                if((v19 & 0x20000000) == 0) {
                                    v39 = v12;
                                    v36 = zzbd.zzh(arr_b, v32, zzbc0);
                                    int v50 = zzbc0.zza;
                                    if(v50 >= 0) {
                                        v40 = v29 | v23;
                                        if(v50 == 0) {
                                            zzbc0.zzc = "";
                                        }
                                        else {
                                            zzbc0.zzc = new String(arr_b, v36, v50, zzda.zzb);
                                            v36 += v50;
                                        }
                                    label_272:
                                        unsafe0.putObject(object1, v21, zzbc0.zzc);
                                        arr_b1 = arr_b;
                                        v3 = v36;
                                        v8 = v27;
                                        v7 = v11;
                                        v5 = v40;
                                        v4 = v39;
                                        continue;
                                    }
                                }
                                else {
                                    v36 = zzbd.zzh(arr_b, v32, zzbc0);
                                    int v37 = zzbc0.zza;
                                    if(v37 >= 0) {
                                        int v38 = v29 | v23;
                                        if(v37 == 0) {
                                            zzbc0.zzc = "";
                                            v39 = v12;
                                        }
                                        else {
                                            if((v36 | v37 | arr_b.length - v36 - v37) < 0) {
                                                throw new ArrayIndexOutOfBoundsException(String.format("buffer length=%d, index=%d, size=%d", ((int)arr_b.length), v36, v37));
                                            }
                                            int v41 = v36 + v37;
                                            char[] arr_c = new char[v37];
                                            int v42;
                                            for(v42 = 0; v36 < v41; ++v42) {
                                                int v43 = arr_b[v36];
                                                if(!zzfq.zzd(((byte)v43))) {
                                                    break;
                                                }
                                                arr_c[v42] = (char)v43;
                                                ++v36;
                                            }
                                            int v44 = v36;
                                        label_217:
                                            while(v44 < v41) {
                                                int v45 = v44;
                                                v44 = v45 + 1;
                                                int v46 = arr_b[v45];
                                                if(zzfq.zzd(((byte)v46))) {
                                                    int v47 = v42 + 1;
                                                    arr_c[v42] = (char)v46;
                                                    while(true) {
                                                        v42 = v47;
                                                        if(v44 >= v41) {
                                                            continue label_217;
                                                        }
                                                        int v48 = arr_b[v44];
                                                        if(!zzfq.zzd(((byte)v48))) {
                                                            continue label_217;
                                                        }
                                                        ++v44;
                                                        v47 = v42 + 1;
                                                        arr_c[v42] = (char)v48;
                                                    }
                                                }
                                                if(v46 >= 0xFFFFFFE0) {
                                                    if(v46 < -16) {
                                                        if(v44 >= v41 - 1) {
                                                            throw zzdc.zzc();
                                                        }
                                                        v49 = v41;
                                                        zzfq.zzb(((byte)v46), arr_b[v44], arr_b[v45 + 2], arr_c, v42);
                                                        ++v42;
                                                        v44 = v45 + 3;
                                                    }
                                                    else {
                                                        v49 = v41;
                                                        if(v44 >= v49 - 2) {
                                                            throw zzdc.zzc();
                                                        }
                                                        zzfq.zza(((byte)v46), arr_b[v44], arr_b[v45 + 2], arr_b[v45 + 3], arr_c, v42);
                                                        v42 += 2;
                                                        v44 = v45 + 4;
                                                    }
                                                    v41 = v49;
                                                    continue;
                                                }
                                                else if(v44 < v41) {
                                                    zzfq.zzc(((byte)v46), arr_b[v44], arr_c, v42);
                                                    ++v42;
                                                    v44 = v45 + 2;
                                                    continue;
                                                }
                                                throw zzdc.zzc();
                                            }
                                            v39 = v12;
                                            zzbc0.zzc = new String(arr_c, 0, v42);
                                            v36 = v41;
                                        }
                                        v40 = v38;
                                        goto label_272;
                                    }
                                }
                                throw zzdc.zzd();
                            }
                            else {
                                v30 = v12;
                                arr_b2 = arr_b;
                                object4 = object1;
                                unsafe2 = unsafe0;
                                v31 = v27;
                                break;
                            }
                            goto label_286;
                        }
                        case 9: {
                        label_286:
                            v29 = v26;
                            v51 = v12;
                            if(v18 == 2) {
                                v52 = v29 | v23;
                                Object object6 = zzef0.zzx(object1, v51);
                                int v53 = zzbd.zzm(object6, zzef0.zzv(v51), arr_b, v25, v1, zzbc0);
                                zzef0.zzF(object1, v51, object6);
                                arr_b1 = arr_b;
                                v3 = v53;
                                goto label_370;
                            }
                            else {
                                v32 = v25;
                                arr_b2 = arr_b;
                                object4 = object1;
                                unsafe2 = unsafe0;
                                v30 = v51;
                                v31 = v27;
                                break;
                            }
                            goto label_301;
                        }
                        case 10: {
                        label_301:
                            unsafe4 = unsafe0;
                            object4 = object1;
                            v29 = v26;
                            v51 = v12;
                            v54 = v25;
                            arr_b2 = arr_b;
                            if(v18 == 2) {
                                v55 = v29 | v23;
                                v56 = zzbd.zza(arr_b2, v54, zzbc0);
                                unsafe4.putObject(object4, v21, zzbc0.zzc);
                                goto label_350;
                            }
                            goto label_359;
                        }
                        case 4: 
                        case 11: {
                            unsafe3 = unsafe0;
                            object4 = object1;
                            v29 = v26;
                            v31 = v27;
                            v32 = v25;
                            v30 = v12;
                            arr_b2 = arr_b;
                            if(v18 == 0) {
                                v5 = v29 | v23;
                                v3 = zzbd.zzh(arr_b2, v32, zzbc0);
                                unsafe3.putInt(object4, v21, zzbc0.zza);
                                object1 = object4;
                                arr_b1 = arr_b2;
                                unsafe0 = unsafe3;
                                v8 = v31;
                                v4 = v30;
                                v7 = v11;
                                continue;
                            }
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 12: {
                            unsafe4 = unsafe0;
                            object4 = object1;
                            v29 = v26;
                            v51 = v12;
                            v54 = v25;
                            arr_b2 = arr_b;
                            if(v18 == 0) {
                                int v57 = zzbd.zzh(arr_b2, v54, zzbc0);
                                int v58 = zzbc0.zza;
                                zzcw zzcw0 = zzef0.zzu(v51);
                                if((v19 & 0x80000000) == 0 || zzcw0 == null || zzcw0.zza(v58)) {
                                    v52 = v29 | v23;
                                    unsafe4.putInt(object4, v21, v58);
                                    object1 = object4;
                                    unsafe0 = unsafe4;
                                    v3 = v57;
                                    arr_b1 = arr_b2;
                                    goto label_370;
                                }
                                else {
                                    zzef.zzd(object4).zzj(v6, ((long)v58));
                                    object1 = object4;
                                    unsafe0 = unsafe4;
                                    v3 = v57;
                                    arr_b1 = arr_b2;
                                    v4 = v51;
                                    v8 = v27;
                                    v7 = v11;
                                    v5 = v29;
                                    continue;
                                }
                                goto label_340;
                            }
                            goto label_359;
                        }
                        case 6: 
                        case 13: {
                        label_158:
                            unsafe3 = unsafe0;
                            v29 = v26;
                            v31 = v27;
                            v30 = v12;
                            object5 = object1;
                            v32 = v25;
                            if(v18 == 5) {
                                v5 = v29 | v23;
                                unsafe3.putInt(object5, v21, zzbd.zzb(arr_b, v32));
                                v3 = v32 + 4;
                                goto label_180;
                            }
                            arr_b2 = arr_b;
                            object4 = object5;
                            unsafe2 = unsafe3;
                            break;
                        }
                        case 5: 
                        case 14: {
                            unsafe3 = unsafe0;
                            v29 = v26;
                            v31 = v27;
                            v30 = v12;
                            v32 = v25;
                            if(v18 == 1) {
                                v5 = v29 | v23;
                                unsafe0 = unsafe3;
                                unsafe0.putLong(object1, v21, zzbd.zzn(arr_b, v32));
                                arr_b1 = arr_b;
                                v3 = v32 + 8;
                                v8 = v31;
                                v4 = v30;
                                v7 = v11;
                                continue;
                            }
                            else {
                                arr_b2 = arr_b;
                                object4 = object1;
                                unsafe2 = unsafe3;
                                break;
                            }
                            goto label_158;
                        }
                        case 15: {
                        label_340:
                            unsafe4 = unsafe0;
                            object4 = object1;
                            v29 = v26;
                            v51 = v12;
                            v54 = v25;
                            arr_b2 = arr_b;
                            if(v18 == 0) {
                                v55 = v29 | v23;
                                v56 = zzbd.zzh(arr_b2, v54, zzbc0);
                                unsafe4.putInt(object4, v21, zzbc0.zza >>> 1 ^ -(zzbc0.zza & 1));
                            label_350:
                                object1 = object4;
                                unsafe0 = unsafe4;
                                v3 = v56;
                                v4 = v51;
                                v8 = v27;
                                v5 = v55;
                                arr_b1 = arr_b2;
                                v7 = v11;
                                continue;
                            }
                        label_359:
                            unsafe2 = unsafe4;
                            v32 = v54;
                            v30 = v51;
                            v31 = v27;
                            break;
                        }
                        case 16: {
                            v51 = v12;
                            arr_b2 = arr_b;
                            if(v18 == 0) {
                                v52 = v26 | v23;
                                int v59 = zzbd.zzk(arr_b2, v25, zzbc0);
                                unsafe0.putLong(object1, v21, zzbc0.zzb >>> 1 ^ -(1L & zzbc0.zzb));
                                arr_b1 = arr_b2;
                                v3 = v59;
                            label_370:
                                v8 = v27;
                                v7 = v11;
                                v5 = v52;
                                v4 = v51;
                                continue;
                            }
                            else {
                                object4 = object1;
                                unsafe2 = unsafe0;
                                v32 = v25;
                                v29 = v26;
                            }
                            v30 = v51;
                            v31 = v27;
                            break;
                        }
                        default: {
                            if(v18 == 3) {
                                Object object3 = zzef0.zzx(object1, v12);
                                int v28 = zzbd.zzl(object3, zzef0.zzv(v12), arr_b, v25, v1, v11 << 3 | 4, zzbc0);
                                zzef0.zzF(object1, v12, object3);
                                v3 = v28;
                                arr_b1 = arr_b;
                                v4 = v12;
                                v8 = v27;
                                v7 = v11;
                                v5 = v26 | v23;
                                continue;
                            }
                            else {
                                unsafe2 = unsafe0;
                                object4 = object1;
                                v29 = v26;
                                v30 = v12;
                                v31 = v27;
                                v32 = v25;
                                arr_b2 = arr_b;
                                break;
                            }
                            goto label_78;
                        }
                    }
                    v15 = v29;
                    zzef1 = zzef0;
                    unsafe1 = unsafe2;
                    v16 = v6;
                    v8 = v31;
                    v4 = v30;
                    v13 = v11;
                    object2 = object4;
                    v14 = v32;
                }
                else if(v20 == 27) {
                    if(v18 == 2) {
                        zzcz zzcz0 = (zzcz)unsafe0.getObject(object1, v21);
                        if(!zzcz0.zzc()) {
                            int v60 = zzcz0.size();
                            if(v60 != 0) {
                                v17 = v60 + v60;
                            }
                            zzcz0 = zzcz0.zzd(v17);
                            unsafe0.putObject(object1, v21, zzcz0);
                        }
                        arr_b1 = arr_b;
                        v3 = zzbd.zze(zzef0.zzv(v12), v6, arr_b, v9, v1, zzcz0, zzbc0);
                        v4 = v12;
                        object1 = object0;
                        v7 = v11;
                        continue;
                    }
                    else {
                        object2 = object1;
                        v13 = v11;
                        v15 = v5;
                        v14 = v9;
                        zzef2 = zzef0;
                        v16 = v6;
                        unsafe5 = unsafe0;
                        goto label_858;
                    }
                    goto label_414;
                }
                else {
                label_414:
                    int v61 = v6;
                    object2 = object1;
                    v14 = v9;
                    if(v20 <= 49) {
                        unsafe1 = unsafe0;
                        Unsafe unsafe6 = zzef.zzb;
                        zzcz zzcz1 = (zzcz)unsafe6.getObject(object2, v21);
                        if(!zzcz1.zzc()) {
                            int v62 = zzcz1.size();
                            if(v62 != 0) {
                                v17 = v62 + v62;
                            }
                            zzcz1 = zzcz1.zzd(v17);
                            unsafe6.putObject(object2, v21, zzcz1);
                        }
                        zzcz zzcz2 = zzcz1;
                        switch(v20) {
                            case 26: {
                            label_620:
                                v74 = v61;
                                v13 = v11;
                                zzcz zzcz3 = zzcz2;
                                v15 = v5;
                                zzef3 = zzef0;
                                if(v18 == 2) {
                                    if((((long)v19) & 0x20000000L) == 0L) {
                                        v66 = zzbd.zzh(arr_b, v14, zzbc0);
                                        int v81 = zzbc0.zza;
                                        if(v81 >= 0) {
                                            if(v81 == 0) {
                                                zzcz3.add("");
                                                goto label_635;
                                            }
                                            else {
                                                zzcz3.add(new String(arr_b, v66, v81, zzda.zzb));
                                            }
                                        alab1:
                                            while(true) {
                                                v66 += v81;
                                                while(true) {
                                                label_635:
                                                    if(v66 >= v1) {
                                                        break alab1;
                                                    }
                                                    int v82 = zzbd.zzh(arr_b, v66, zzbc0);
                                                    if(v74 != zzbc0.zza) {
                                                        break alab1;
                                                    }
                                                    v66 = zzbd.zzh(arr_b, v82, zzbc0);
                                                    v81 = zzbc0.zza;
                                                    if(v81 < 0) {
                                                        throw zzdc.zzd();
                                                    }
                                                    if(v81 != 0) {
                                                        zzcz3.add(new String(arr_b, v66, v81, zzda.zzb));
                                                        break;
                                                    }
                                                    zzcz3.add("");
                                                }
                                            }
                                        label_647:
                                            v16 = v74;
                                        label_648:
                                            v3 = v66;
                                            break;
                                        }
                                    }
                                    else {
                                        v66 = zzbd.zzh(arr_b, v14, zzbc0);
                                        int v83 = zzbc0.zza;
                                        if(v83 >= 0) {
                                            if(v83 == 0) {
                                                zzcz3.add("");
                                                goto label_661;
                                            }
                                            else {
                                                int v84 = v66 + v83;
                                                if(!zzfu.zze(arr_b, v66, v84)) {
                                                    throw zzdc.zzc();
                                                }
                                                zzcz3.add(new String(arr_b, v66, v83, zzda.zzb));
                                            alab2:
                                                while(true) {
                                                    v66 = v84;
                                                    while(true) {
                                                    label_661:
                                                        if(v66 >= v1) {
                                                            goto label_676;
                                                        }
                                                        int v85 = zzbd.zzh(arr_b, v66, zzbc0);
                                                        if(v74 != zzbc0.zza) {
                                                            goto label_676;
                                                        }
                                                        v66 = zzbd.zzh(arr_b, v85, zzbc0);
                                                        int v86 = zzbc0.zza;
                                                        if(v86 < 0) {
                                                            throw zzdc.zzd();
                                                        }
                                                        if(v86 != 0) {
                                                            v84 = v66 + v86;
                                                            if(!zzfu.zze(arr_b, v66, v84)) {
                                                                break alab2;
                                                            }
                                                            zzcz3.add(new String(arr_b, v66, v86, zzda.zzb));
                                                            break;
                                                        }
                                                        zzcz3.add("");
                                                    }
                                                }
                                                throw zzdc.zzc();
                                            label_676:
                                                v16 = v74;
                                                v3 = v66;
                                                break;
                                            }
                                        }
                                    }
                                    throw zzdc.zzd();
                                }
                                else {
                                    v16 = v74;
                                    v3 = v14;
                                    break;
                                }
                                goto label_683;
                            }
                            case 28: {
                            label_683:
                                v87 = v61;
                                v13 = v11;
                                zzcz zzcz4 = zzcz2;
                                v15 = v5;
                                if(v18 == 2) {
                                    int v88 = zzbd.zzh(arr_b, v14, zzbc0);
                                    int v89 = zzbc0.zza;
                                    if(v89 < 0) {
                                        throw zzdc.zzd();
                                    }
                                    if(v89 > arr_b.length - v88) {
                                        throw zzdc.zzg();
                                    }
                                    if(v89 == 0) {
                                        zzcz4.add(zzbq.zzb);
                                        goto label_697;
                                    }
                                    else {
                                        zzcz4.add(zzbq.zzl(arr_b, v88, v89));
                                    }
                                alab3:
                                    while(true) {
                                        v88 += v89;
                                        while(true) {
                                        label_697:
                                            if(v88 >= v1) {
                                                goto label_711;
                                            }
                                            int v90 = zzbd.zzh(arr_b, v88, zzbc0);
                                            if(v87 != zzbc0.zza) {
                                                goto label_711;
                                            }
                                            v88 = zzbd.zzh(arr_b, v90, zzbc0);
                                            v89 = zzbc0.zza;
                                            if(v89 < 0) {
                                                throw zzdc.zzd();
                                            }
                                            if(v89 > arr_b.length - v88) {
                                                break alab3;
                                            }
                                            if(v89 != 0) {
                                                zzcz4.add(zzbq.zzl(arr_b, v88, v89));
                                                break;
                                            }
                                            zzcz4.add(zzbq.zzb);
                                        }
                                    }
                                    throw zzdc.zzg();
                                label_711:
                                    zzef3 = this;
                                    v3 = v88;
                                    v16 = v87;
                                }
                                else {
                                    zzef3 = this;
                                    v16 = v87;
                                    v3 = v14;
                                }
                                break;
                            }
                            case 18: 
                            case 35: {
                                v13 = v11;
                                v15 = v5;
                                zzef3 = zzef0;
                                v16 = v61;
                                if(v18 == 2) {
                                    zzca zzca0 = (zzca)zzcz2;
                                    v66 = zzbd.zzh(arr_b, v14, zzbc0);
                                    int v67 = zzbc0.zza + v66;
                                    while(v66 < v67) {
                                        zzca0.zzf(Double.longBitsToDouble(zzbd.zzn(arr_b, v66)));
                                        v66 += 8;
                                    }
                                    if(v66 != v67) {
                                        throw zzdc.zzg();
                                    }
                                    goto label_648;
                                }
                                else if(v18 == 1) {
                                    v68 = v14 + 8;
                                    zzca zzca1 = (zzca)zzcz2;
                                    zzca1.zzf(Double.longBitsToDouble(zzbd.zzn(arr_b, v14)));
                                    while(v68 < v1) {
                                        int v69 = zzbd.zzh(arr_b, v68, zzbc0);
                                        if(v16 != zzbc0.zza) {
                                            break;
                                        }
                                        zzca1.zzf(Double.longBitsToDouble(zzbd.zzn(arr_b, v69)));
                                        v68 = v69 + 8;
                                    }
                                    v3 = v68;
                                    break;
                                }
                                v3 = v14;
                                break;
                            }
                            case 19: 
                            case 36: {
                                v13 = v11;
                                v15 = v5;
                                zzef3 = zzef0;
                                v16 = v61;
                                if(v18 == 2) {
                                    zzck zzck0 = (zzck)zzcz2;
                                    v66 = zzbd.zzh(arr_b, v14, zzbc0);
                                    int v70 = zzbc0.zza + v66;
                                    while(v66 < v70) {
                                        zzck0.zzf(Float.intBitsToFloat(zzbd.zzb(arr_b, v66)));
                                        v66 += 4;
                                    }
                                    if(v66 != v70) {
                                        throw zzdc.zzg();
                                    }
                                    goto label_648;
                                }
                                else if(v18 == 5) {
                                    v68 = v14 + 4;
                                    zzck zzck1 = (zzck)zzcz2;
                                    zzck1.zzf(Float.intBitsToFloat(zzbd.zzb(arr_b, v14)));
                                    while(v68 < v1) {
                                        int v71 = zzbd.zzh(arr_b, v68, zzbc0);
                                        if(v16 != zzbc0.zza) {
                                            break;
                                        }
                                        zzck1.zzf(Float.intBitsToFloat(zzbd.zzb(arr_b, v71)));
                                        v68 = v71 + 4;
                                    }
                                    v3 = v68;
                                    break;
                                }
                                v3 = v14;
                                break;
                            }
                            case 20: 
                            case 21: 
                            case 37: 
                            case 38: {
                                v13 = v11;
                                v15 = v5;
                                zzef3 = zzef0;
                                v16 = v61;
                                if(v18 == 2) {
                                    zzdr zzdr0 = (zzdr)zzcz2;
                                    v66 = zzbd.zzh(arr_b, v14, zzbc0);
                                    int v72 = zzbc0.zza + v66;
                                    while(v66 < v72) {
                                        v66 = zzbd.zzk(arr_b, v66, zzbc0);
                                        zzdr0.zzf(zzbc0.zzb);
                                    }
                                    if(v66 != v72) {
                                        throw zzdc.zzg();
                                    }
                                    goto label_648;
                                }
                                else if(v18 == 0) {
                                    zzdr zzdr1 = (zzdr)zzcz2;
                                    v66 = zzbd.zzk(arr_b, v14, zzbc0);
                                    zzdr1.zzf(zzbc0.zzb);
                                    while(v66 < v1) {
                                        int v73 = zzbd.zzh(arr_b, v66, zzbc0);
                                        if(v16 != zzbc0.zza) {
                                            break;
                                        }
                                        v66 = zzbd.zzk(arr_b, v73, zzbc0);
                                        zzdr1.zzf(zzbc0.zzb);
                                    }
                                    goto label_648;
                                }
                                v3 = v14;
                                break;
                            }
                            case 25: 
                            case 42: {
                                v74 = v61;
                                v13 = v11;
                                v15 = v5;
                                zzef3 = zzef0;
                                if(v18 == 2) {
                                    zzbe zzbe0 = (zzbe)zzcz2;
                                    v66 = zzbd.zzh(arr_b, v14, zzbc0);
                                    int v79 = zzbc0.zza + v66;
                                    while(v66 < v79) {
                                        v66 = zzbd.zzk(arr_b, v66, zzbc0);
                                        zzbe0.zze(zzbc0.zzb != 0L);
                                    }
                                    if(v66 != v79) {
                                        throw zzdc.zzg();
                                    }
                                    goto label_647;
                                }
                                else if(v18 == 0) {
                                    zzbe zzbe1 = (zzbe)zzcz2;
                                    v66 = zzbd.zzk(arr_b, v14, zzbc0);
                                    zzbe1.zze(zzbc0.zzb != 0L);
                                    while(v66 < v1) {
                                        int v80 = zzbd.zzh(arr_b, v66, zzbc0);
                                        if(v74 != zzbc0.zza) {
                                            break;
                                        }
                                        v66 = zzbd.zzk(arr_b, v80, zzbc0);
                                        zzbe1.zze(zzbc0.zzb != 0L);
                                    }
                                    goto label_647;
                                }
                                else {
                                    v16 = v74;
                                    v3 = v14;
                                    break;
                                }
                                goto label_620;
                            }
                            case 22: 
                            case 29: 
                            case 39: 
                            case 43: {
                                v74 = v61;
                                v13 = v11;
                                v15 = v5;
                                zzef3 = zzef0;
                                if(v18 == 2) {
                                    v66 = zzbd.zzf(arr_b, v14, zzcz2, zzbc0);
                                    goto label_647;
                                }
                                else if(v18 == 0) {
                                    v66 = zzbd.zzj(v74, arr_b, v14, v1, zzcz2, zzbc0);
                                    v16 = v74;
                                    goto label_648;
                                }
                                v16 = v74;
                                v3 = v14;
                                break;
                            }
                            case 30: 
                            case 44: {
                                int v91 = v11;
                                if(v18 == 2) {
                                    v92 = zzbd.zzf(arr_b, v14, zzcz2, zzbc0);
                                    v87 = v61;
                                    zzcz5 = zzcz2;
                                    goto label_730;
                                }
                                else if(v18 == 0) {
                                    v87 = v61;
                                    zzcz5 = zzcz2;
                                    v92 = zzbd.zzj(v87, arr_b, v14, v1, zzcz5, zzbc0);
                                label_730:
                                    zzcw zzcw1 = zzef0.zzu(v12);
                                    zzff zzff0 = zzef0.zzm;
                                    if(zzcw1 == null) {
                                        v94 = v92;
                                        v15 = v5;
                                        v13 = v91;
                                    }
                                    else {
                                        if(zzcz5 == null) {
                                            throw new NullPointerException();
                                        }
                                        int v93 = zzcz5.size();
                                        v94 = v92;
                                        v15 = v5;
                                        Object object7 = null;
                                        int v95 = 0;
                                        int v96 = 0;
                                        while(v96 < v93) {
                                            Integer integer0 = (Integer)zzcz5.get(v96);
                                            int v97 = (int)integer0;
                                            if(zzcw1.zza(v97)) {
                                                if(v96 != v95) {
                                                    zzcz5.set(v95, integer0);
                                                }
                                                ++v95;
                                                v98 = v91;
                                            }
                                            else {
                                                v98 = v91;
                                                object7 = zzeq.zzo(object2, v98, v97, object7, zzff0);
                                            }
                                            ++v96;
                                            v91 = v98;
                                        }
                                        v13 = v91;
                                        if(v95 != v93) {
                                            zzcz5.subList(v95, v93).clear();
                                        }
                                    }
                                    zzef3 = this;
                                    v3 = v94;
                                    v16 = v87;
                                    break;
                                }
                                else {
                                    v15 = v5;
                                    v13 = v91;
                                    zzef3 = this;
                                    v16 = v61;
                                    v3 = v14;
                                    break;
                                }
                                goto label_771;
                            }
                            case 24: 
                            case 0x1F: 
                            case 41: 
                            case 45: {
                                v74 = v61;
                                v13 = v11;
                                v15 = v5;
                                zzef3 = zzef0;
                                if(v18 == 2) {
                                    zzct zzct0 = (zzct)zzcz2;
                                    v66 = zzbd.zzh(arr_b, v14, zzbc0);
                                    int v77 = zzbc0.zza + v66;
                                    while(v66 < v77) {
                                        zzct0.zzg(zzbd.zzb(arr_b, v66));
                                        v66 += 4;
                                    }
                                    if(v66 != v77) {
                                        throw zzdc.zzg();
                                    }
                                    goto label_647;
                                }
                                else if(v18 == 5) {
                                    v66 = v14 + 4;
                                    zzct zzct1 = (zzct)zzcz2;
                                    zzct1.zzg(zzbd.zzb(arr_b, v14));
                                    while(v66 < v1) {
                                        int v78 = zzbd.zzh(arr_b, v66, zzbc0);
                                        if(v74 != zzbc0.zza) {
                                            break;
                                        }
                                        zzct1.zzg(zzbd.zzb(arr_b, v78));
                                        v66 = v78 + 4;
                                    }
                                    goto label_647;
                                }
                                v16 = v74;
                                v3 = v14;
                                break;
                            }
                            case 23: 
                            case 0x20: 
                            case 40: 
                            case 46: {
                                v74 = v61;
                                v13 = v11;
                                v15 = v5;
                                zzef3 = zzef0;
                                if(v18 == 2) {
                                    zzdr zzdr2 = (zzdr)zzcz2;
                                    v66 = zzbd.zzh(arr_b, v14, zzbc0);
                                    int v75 = zzbc0.zza + v66;
                                    while(v66 < v75) {
                                        zzdr2.zzf(zzbd.zzn(arr_b, v66));
                                        v66 += 8;
                                    }
                                    if(v66 != v75) {
                                        throw zzdc.zzg();
                                    }
                                    goto label_647;
                                }
                                else if(v18 == 1) {
                                    v66 = v14 + 8;
                                    zzdr zzdr3 = (zzdr)zzcz2;
                                    zzdr3.zzf(zzbd.zzn(arr_b, v14));
                                    while(v66 < v1) {
                                        int v76 = zzbd.zzh(arr_b, v66, zzbc0);
                                        if(v74 != zzbc0.zza) {
                                            break;
                                        }
                                        zzdr3.zzf(zzbd.zzn(arr_b, v76));
                                        v66 = v76 + 8;
                                    }
                                    goto label_647;
                                }
                                v16 = v74;
                                v3 = v14;
                                break;
                            }
                            case 33: 
                            case 0x2F: {
                            label_771:
                                v99 = v14;
                                v100 = v11;
                                if(v18 == 2) {
                                    zzct zzct2 = (zzct)zzcz2;
                                    v101 = zzbd.zzh(arr_b, v99, zzbc0);
                                    int v102 = zzbc0.zza + v101;
                                    while(v101 < v102) {
                                        v101 = zzbd.zzh(arr_b, v101, zzbc0);
                                        zzct2.zzg(zzbc0.zza >>> 1 ^ -(zzbc0.zza & 1));
                                    }
                                    if(v101 != v102) {
                                        throw zzdc.zzg();
                                    }
                                    goto label_817;
                                }
                                else if(v18 == 0) {
                                    zzct zzct3 = (zzct)zzcz2;
                                    v101 = zzbd.zzh(arr_b, v99, zzbc0);
                                    zzct3.zzg(zzbc0.zza >>> 1 ^ -(zzbc0.zza & 1));
                                    while(v101 < v1) {
                                        int v103 = zzbd.zzh(arr_b, v101, zzbc0);
                                        if(v61 != zzbc0.zza) {
                                            break;
                                        }
                                        v101 = zzbd.zzh(arr_b, v103, zzbc0);
                                        zzct3.zzg(zzbc0.zza >>> 1 ^ -(zzbc0.zza & 1));
                                    }
                                    goto label_817;
                                }
                                goto label_824;
                            }
                            case 34: 
                            case 0x30: {
                                v99 = v14;
                                if(v18 == 2) {
                                    zzdr zzdr4 = (zzdr)zzcz2;
                                    v101 = zzbd.zzh(arr_b, v99, zzbc0);
                                    int v104 = zzbc0.zza + v101;
                                    while(v101 < v104) {
                                        v101 = zzbd.zzk(arr_b, v101, zzbc0);
                                        zzdr4.zzf(zzbc0.zzb >>> 1 ^ -(1L & zzbc0.zzb));
                                    }
                                    v100 = v11;
                                    if(v101 != v104) {
                                        throw zzdc.zzg();
                                    }
                                    goto label_817;
                                }
                                else {
                                    v100 = v11;
                                    if(v18 == 0) {
                                        zzdr zzdr5 = (zzdr)zzcz2;
                                        v101 = zzbd.zzk(arr_b, v99, zzbc0);
                                        zzdr5.zzf(zzbc0.zzb >>> 1 ^ -(1L & zzbc0.zzb));
                                        while(v101 < v1) {
                                            int v105 = zzbd.zzh(arr_b, v101, zzbc0);
                                            if(v61 != zzbc0.zza) {
                                                break;
                                            }
                                            v101 = zzbd.zzk(arr_b, v105, zzbc0);
                                            zzdr5.zzf(zzbc0.zzb >>> 1 ^ -(1L & zzbc0.zzb));
                                        }
                                    label_817:
                                        zzef3 = zzef0;
                                        v3 = v101;
                                        v14 = v99;
                                        v15 = v5;
                                        v13 = v100;
                                        v16 = v61;
                                        break;
                                    }
                                }
                            label_824:
                                zzef3 = zzef0;
                                v14 = v99;
                                v15 = v5;
                                v13 = v100;
                                v16 = v61;
                                v3 = v14;
                                break;
                            }
                            default: {
                                if(v18 == 3) {
                                    int v63 = v61 & -8 | 4;
                                    zzeo zzeo0 = zzef0.zzv(v12);
                                    int v64 = zzbd.zzc(zzeo0, arr_b, v14, v1, v63, zzbc0);
                                    zzcz2.add(zzbc0.zzc);
                                    while(v64 < v1) {
                                        int v65 = zzbd.zzh(arr_b, v64, zzbc0);
                                        if(v61 != zzbc0.zza) {
                                            break;
                                        }
                                        v64 = zzbd.zzc(zzeo0, arr_b, v65, v1, v63, zzbc0);
                                        zzcz2.add(zzbc0.zzc);
                                    }
                                    v3 = v64;
                                    v13 = v11;
                                    v15 = v5;
                                    zzef3 = zzef0;
                                    v16 = v61;
                                }
                                else {
                                    v13 = v11;
                                    v15 = v5;
                                    zzef3 = zzef0;
                                    v16 = v61;
                                    v3 = v14;
                                }
                                break;
                            }
                        }
                        if(v3 == v14) {
                            arr_b2 = arr_b;
                            v14 = v3;
                            zzef1 = zzef3;
                            v4 = v12;
                            goto label_1057;
                        }
                        else {
                            arr_b1 = arr_b;
                            zzef0 = zzef3;
                            v7 = v13;
                            v4 = v12;
                            object1 = object2;
                            unsafe0 = unsafe1;
                            v6 = v16;
                            v5 = v15;
                            continue;
                        }
                        goto label_842;
                    }
                    else {
                    label_842:
                        v13 = v11;
                        v15 = v5;
                        zzef2 = zzef0;
                        unsafe5 = unsafe0;
                        v16 = v61;
                        if(v20 == 50) {
                            if(v18 == 2) {
                                Unsafe unsafe7 = zzef.zzb;
                                Object object8 = zzef2.zzw(v12);
                                Object object9 = unsafe7.getObject(object2, v21);
                                if(!((zzdw)object9).zze()) {
                                    zzdw zzdw0 = zzdw.zza().zzb();
                                    zzdx.zza(zzdw0, object9);
                                    unsafe7.putObject(object2, v21, zzdw0);
                                }
                                zzdv zzdv0 = (zzdv)object8;
                                throw null;
                            }
                        label_858:
                            unsafe1 = unsafe5;
                            arr_b2 = arr_b;
                            zzef1 = zzef2;
                            v4 = v12;
                        }
                        else {
                            Unsafe unsafe8 = zzef.zzb;
                            long v106 = (long)(arr_v[v12 + 2] & 0xFFFFF);
                            switch(v20) {
                                case 51: {
                                    arr_b2 = arr_b;
                                    zzef1 = zzef2;
                                    v107 = v12;
                                    v108 = v14;
                                    unsafe1 = unsafe5;
                                    if(v18 == 1) {
                                        v109 = v108 + 8;
                                        unsafe8.putObject(object2, v21, Double.longBitsToDouble(zzbd.zzn(arr_b2, v108)));
                                        unsafe8.putInt(object2, v106, v13);
                                        v3 = v109;
                                        goto label_1045;
                                    }
                                    break;
                                }
                                case 52: {
                                    arr_b2 = arr_b;
                                    zzef1 = zzef2;
                                    v107 = v12;
                                    v108 = v14;
                                    unsafe1 = unsafe5;
                                    if(v18 == 5) {
                                        v109 = v108 + 4;
                                        unsafe8.putObject(object2, v21, Float.intBitsToFloat(zzbd.zzb(arr_b2, v108)));
                                        unsafe8.putInt(object2, v106, v13);
                                        v3 = v109;
                                        goto label_1045;
                                    }
                                    break;
                                }
                                case 53: 
                                case 54: {
                                    arr_b2 = arr_b;
                                    zzef1 = zzef2;
                                    v107 = v12;
                                    v108 = v14;
                                    unsafe1 = unsafe5;
                                    if(v18 == 0) {
                                        v109 = zzbd.zzk(arr_b2, v108, zzbc0);
                                        unsafe8.putObject(object2, v21, zzbc0.zzb);
                                        unsafe8.putInt(object2, v106, v13);
                                        v3 = v109;
                                        goto label_1045;
                                    }
                                    break;
                                }
                                case 58: {
                                    arr_b2 = arr_b;
                                    zzef1 = zzef2;
                                    v107 = v12;
                                    v108 = v14;
                                    unsafe1 = unsafe5;
                                    if(v18 == 0) {
                                        v109 = zzbd.zzk(arr_b2, v108, zzbc0);
                                        unsafe8.putObject(object2, v21, Boolean.valueOf(zzbc0.zzb != 0L));
                                        unsafe8.putInt(object2, v106, v13);
                                        v3 = v109;
                                        goto label_1045;
                                    }
                                    break;
                                }
                                case 59: {
                                    arr_b2 = arr_b;
                                    v107 = v12;
                                    v108 = v14;
                                    zzef1 = zzef2;
                                    if(v18 == 2) {
                                        int v110 = zzbd.zzh(arr_b2, v108, zzbc0);
                                        int v111 = zzbc0.zza;
                                        if(v111 == 0) {
                                            unsafe8.putObject(object2, v21, "");
                                            unsafe1 = unsafe5;
                                        }
                                        else {
                                            int v112 = v110 + v111;
                                            if((v19 & 0x20000000) != 0 && !zzfu.zze(arr_b2, v110, v112)) {
                                                throw zzdc.zzc();
                                            }
                                            unsafe1 = unsafe5;
                                            unsafe8.putObject(object2, v21, new String(arr_b2, v110, v111, zzda.zzb));
                                            v110 = v112;
                                        }
                                        unsafe8.putInt(object2, v106, v13);
                                        v3 = v110;
                                        goto label_1045;
                                    }
                                    unsafe1 = unsafe5;
                                    break;
                                }
                                case 60: {
                                    arr_b2 = arr_b;
                                    zzef1 = zzef2;
                                    if(v18 == 2) {
                                        Object object10 = zzef1.zzy(object2, v13, v12);
                                        int v113 = zzbd.zzm(object10, zzef1.zzv(v12), arr_b2, v14, v1, zzbc0);
                                        zzef1.zzG(object2, v13, v12, object10);
                                        unsafe1 = unsafe5;
                                        v3 = v113;
                                        v107 = v12;
                                        v108 = v14;
                                        goto label_1045;
                                    }
                                    else {
                                        unsafe1 = unsafe5;
                                        v107 = v12;
                                        v108 = v14;
                                        break;
                                    }
                                    goto label_974;
                                }
                                case 61: {
                                label_974:
                                    arr_b2 = arr_b;
                                    zzef1 = zzef2;
                                    v114 = v14;
                                    if(v18 == 2) {
                                        v115 = zzbd.zza(arr_b2, v114, zzbc0);
                                        unsafe8.putObject(object2, v21, zzbc0.zzc);
                                        unsafe8.putInt(object2, v106, v13);
                                        unsafe1 = unsafe5;
                                        v3 = v115;
                                        v107 = v12;
                                        v108 = v114;
                                        goto label_1045;
                                    }
                                    unsafe1 = unsafe5;
                                    v107 = v12;
                                    v108 = v114;
                                    break;
                                }
                                case 55: 
                                case 62: {
                                    arr_b2 = arr_b;
                                    zzef1 = zzef2;
                                    v107 = v12;
                                    v108 = v14;
                                    unsafe1 = unsafe5;
                                    if(v18 == 0) {
                                        v109 = zzbd.zzh(arr_b2, v108, zzbc0);
                                        unsafe8.putObject(object2, v21, zzbc0.zza);
                                        unsafe8.putInt(object2, v106, v13);
                                        v3 = v109;
                                        goto label_1045;
                                    }
                                    break;
                                }
                                case 0x3F: {
                                    arr_b2 = arr_b;
                                    v114 = v14;
                                    if(v18 == 0) {
                                        int v116 = zzbd.zzh(arr_b2, v114, zzbc0);
                                        int v117 = zzbc0.zza;
                                        zzef1 = this;
                                        zzcw zzcw2 = zzef1.zzu(v12);
                                        if(zzcw2 == null || zzcw2.zza(v117)) {
                                            unsafe8.putObject(object2, v21, v117);
                                            unsafe8.putInt(object2, v106, v13);
                                        }
                                        else {
                                            zzef.zzd(object2).zzj(v16, ((long)v117));
                                        }
                                        v3 = v116;
                                        unsafe1 = unsafe5;
                                        v107 = v12;
                                        v108 = v114;
                                        goto label_1045;
                                    }
                                    goto label_1009;
                                }
                                case 57: 
                                case 0x40: {
                                    arr_b2 = arr_b;
                                    zzef1 = zzef2;
                                    v107 = v12;
                                    v108 = v14;
                                    unsafe1 = unsafe5;
                                    if(v18 == 5) {
                                        v109 = v108 + 4;
                                        unsafe8.putObject(object2, v21, zzbd.zzb(arr_b2, v108));
                                        unsafe8.putInt(object2, v106, v13);
                                        v3 = v109;
                                        goto label_1045;
                                    }
                                    break;
                                }
                                case 56: 
                                case 65: {
                                    arr_b2 = arr_b;
                                    zzef1 = zzef2;
                                    v107 = v12;
                                    v108 = v14;
                                    unsafe1 = unsafe5;
                                    if(v18 == 1) {
                                        v109 = v108 + 8;
                                        unsafe8.putObject(object2, v21, zzbd.zzn(arr_b2, v108));
                                        unsafe8.putInt(object2, v106, v13);
                                        v3 = v109;
                                        goto label_1045;
                                    }
                                    break;
                                }
                                case 66: {
                                    arr_b2 = arr_b;
                                    v114 = v14;
                                    if(v18 == 0) {
                                        v115 = zzbd.zzh(arr_b2, v114, zzbc0);
                                        unsafe8.putObject(object2, v21, ((int)(zzbc0.zza >>> 1 ^ -(zzbc0.zza & 1))));
                                        unsafe8.putInt(object2, v106, v13);
                                        zzef1 = this;
                                        unsafe1 = unsafe5;
                                        v3 = v115;
                                        v107 = v12;
                                        v108 = v114;
                                        goto label_1045;
                                    }
                                label_1009:
                                    zzef1 = this;
                                    unsafe1 = unsafe5;
                                    v107 = v12;
                                    v108 = v114;
                                    break;
                                }
                                case 67: {
                                    arr_b2 = arr_b;
                                    v114 = v14;
                                    if(v18 == 0) {
                                        int v118 = zzbd.zzk(arr_b2, v114, zzbc0);
                                        unsafe8.putObject(object2, v21, ((long)(zzbc0.zzb >>> 1 ^ -(1L & zzbc0.zzb))));
                                        unsafe8.putInt(object2, v106, v13);
                                        zzef1 = this;
                                        v3 = v118;
                                        unsafe1 = unsafe5;
                                        v107 = v12;
                                        v108 = v114;
                                        goto label_1045;
                                    }
                                    else {
                                        zzef1 = this;
                                    }
                                    unsafe1 = unsafe5;
                                    v107 = v12;
                                    v108 = v114;
                                    break;
                                }
                                case 68: {
                                    if(v18 == 3) {
                                        Object object11 = zzef2.zzy(object2, v13, v12);
                                        int v119 = zzbd.zzl(object11, zzef2.zzv(v12), arr_b, v14, v1, v16 & -8 | 4, zzbc0);
                                        arr_b2 = arr_b;
                                        zzef2.zzG(object2, v13, v12, object11);
                                        unsafe1 = unsafe5;
                                        v3 = v119;
                                        zzef1 = zzef2;
                                        v107 = v12;
                                        v108 = v14;
                                        goto label_1045;
                                    }
                                label_1039:
                                    arr_b2 = arr_b;
                                    zzef1 = zzef2;
                                    v107 = v12;
                                    v108 = v14;
                                    unsafe1 = unsafe5;
                                    break;
                                }
                                default: {
                                    goto label_1039;
                                }
                            }
                            v3 = v108;
                        label_1045:
                            if(v3 == v108) {
                                v14 = v3;
                                v4 = v107;
                            }
                            else {
                                arr_b1 = arr_b2;
                                v7 = v13;
                                zzef0 = zzef1;
                                object1 = object2;
                                v4 = v107;
                                unsafe0 = unsafe1;
                                v6 = v16;
                                v5 = v15;
                                continue;
                            }
                        }
                    }
                }
            }
        label_1057:
            if(v16 != v2 || v2 == 0) {
                if(zzef1.zzh) {
                    zzcd zzcd0 = zzbc0.zzd;
                    if(zzcd0 != zzcd.zza) {
                        if(zzcd0.zzb(zzef1.zzg, v13) == null) {
                            v120 = v16;
                            v121 = zzbd.zzg(v120, arr_b2, v14, v1, zzef.zzd(object2), zzbc0);
                            goto label_1074;
                        }
                        zzco zzco0 = (zzco)object2;
                        throw null;
                    }
                }
                v120 = v16;
                v121 = zzbd.zzg(v120, arr_b, v14, v1, zzef.zzd(object2), zzbc0);
            label_1074:
                v3 = v121;
                arr_b1 = arr_b;
                v7 = v13;
                zzef0 = zzef1;
                object1 = object2;
                v5 = v15;
                v6 = v120;
                unsafe0 = unsafe1;
                continue;
            }
            else {
                v3 = v14;
                object1 = object2;
                v6 = v16;
                v5 = v15;
            }
            break;
        }
        if(v8 != 0xFFFFF) {
            unsafe1.putInt(object1, ((long)v8), v5);
        }
        int v122 = zzef1.zzj;
        while(v122 < zzef1.zzk) {
            int v123 = zzef1.zzi[v122];
            int v124 = zzef1.zzc[v123];
            Object object12 = zzfp.zzf(object1, ((long)(zzef1.zzs(v123) & 0xFFFFF)));
            if(object12 == null || zzef1.zzu(v123) == null) {
                ++v122;
                continue;
            }
            zzdw zzdw1 = (zzdw)object12;
            zzdv zzdv1 = (zzdv)zzef1.zzw(v123);
            throw null;
        }
        if(v2 == 0) {
            if(v3 != v1) {
                throw zzdc.zze();
            }
            return v3;
        }
        if(v3 > v1 || v6 != v2) {
            throw zzdc.zze();
        }
        return v3;
    }

    public static zzfg zzd(Object object0) {
        zzfg zzfg0 = ((zzcs)object0).zzc;
        if(zzfg0 == zzfg.zzc()) {
            zzfg0 = zzfg.zzf();
            ((zzcs)object0).zzc = zzfg0;
        }
        return zzfg0;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final Object zze() {
        return ((zzcs)this.zzg).zzl();
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final void zzf(Object object0) {
        if(zzef.zzL(object0)) {
            if(object0 instanceof zzcs) {
                ((zzcs)object0).zzu(0x7FFFFFFF);
                ((zzcs)object0).zza = 0;
                ((zzcs)object0).zzs();
            }
            int[] arr_v = this.zzc;
            for(int v = 0; v < arr_v.length; v += 3) {
                int v1 = this.zzs(v);
                long v2 = (long)(0xFFFFF & v1);
                switch(v1 >>> 20 & 0xFF) {
                    case 9: 
                    case 17: {
                        if(this.zzI(object0, v)) {
                            this.zzv(v).zzf(zzef.zzb.getObject(object0, v2));
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
                        this.zzl.zza(object0, v2);
                        break;
                    }
                    case 50: {
                        Unsafe unsafe0 = zzef.zzb;
                        Object object1 = unsafe0.getObject(object0, v2);
                        if(object1 != null) {
                            ((zzdw)object1).zzc();
                            unsafe0.putObject(object0, v2, object1);
                        }
                        break;
                    }
                    case 60: 
                    case 68: {
                        if(this.zzM(object0, this.zzc[v], v)) {
                            this.zzv(v).zzf(zzef.zzb.getObject(object0, v2));
                        }
                    }
                }
            }
            this.zzm.zzg(object0);
            if(this.zzh) {
                this.zzn.zzd(object0);
            }
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final void zzg(Object object0, Object object1) {
        zzef.zzA(object0);
        object1.getClass();
        for(int v = 0; v < this.zzc.length; v += 3) {
            int v1 = this.zzs(v);
            int v2 = this.zzc[v];
            long v3 = (long)(0xFFFFF & v1);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzo(object0, v3, zzfp.zza(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 1: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzp(object0, v3, zzfp.zzb(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 2: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzr(object0, v3, zzfp.zzd(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 3: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzr(object0, v3, zzfp.zzd(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 4: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzq(object0, v3, zzfp.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 5: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzr(object0, v3, zzfp.zzd(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 6: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzq(object0, v3, zzfp.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 7: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzm(object0, v3, zzfp.zzw(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 8: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzs(object0, v3, zzfp.zzf(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 9: {
                    this.zzB(object0, object1, v);
                    break;
                }
                case 10: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzs(object0, v3, zzfp.zzf(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 11: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzq(object0, v3, zzfp.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 12: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzq(object0, v3, zzfp.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 13: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzq(object0, v3, zzfp.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 14: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzr(object0, v3, zzfp.zzd(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 15: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzq(object0, v3, zzfp.zzc(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 16: {
                    if(this.zzI(object1, v)) {
                        zzfp.zzr(object0, v3, zzfp.zzd(object1, v3));
                        this.zzD(object0, v);
                    }
                    break;
                }
                case 17: {
                    this.zzB(object0, object1, v);
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
                    this.zzl.zzb(object0, object1, v3);
                    break;
                }
                case 50: {
                    zzfp.zzs(object0, v3, zzdx.zza(zzfp.zzf(object0, v3), zzfp.zzf(object1, v3)));
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
                    if(this.zzM(object1, v2, v)) {
                        zzfp.zzs(object0, v3, zzfp.zzf(object1, v3));
                        this.zzE(object0, v2, v);
                    }
                    break;
                }
                case 60: {
                    this.zzC(object0, object1, v);
                    break;
                }
                case 61: 
                case 62: 
                case 0x3F: 
                case 0x40: 
                case 65: 
                case 66: 
                case 67: {
                    if(this.zzM(object1, v2, v)) {
                        zzfp.zzs(object0, v3, zzfp.zzf(object1, v3));
                        this.zzE(object0, v2, v);
                    }
                    break;
                }
                case 68: {
                    this.zzC(object0, object1, v);
                }
            }
        }
        zzeq.zzq(this.zzm, object0, object1);
        if(this.zzh) {
            zzeq.zzp(this.zzn, object0, object1);
        }
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final void zzh(Object object0, byte[] arr_b, int v, int v1, zzbc zzbc0) {
        this.zzc(object0, arr_b, v, v1, 0, zzbc0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final void zzi(Object object0, zzfx zzfx0) {
        int v10;
        int v9;
        int v8;
        Map.Entry map$Entry1;
        Iterator iterator1;
        Map.Entry map$Entry0;
        if(this.zzh) {
            zzci zzci0 = this.zzn.zzb(object0);
            if(zzci0.zza.isEmpty()) {
                map$Entry0 = null;
                iterator1 = null;
            }
            else {
                Iterator iterator0 = zzci0.zzf();
                Object object1 = iterator0.next();
                map$Entry0 = (Map.Entry)object1;
                iterator1 = iterator0;
            }
        }
        else {
            map$Entry0 = null;
            iterator1 = null;
        }
        int[] arr_v = this.zzc;
        Unsafe unsafe0 = zzef.zzb;
        int v = 0;
        int v1 = 0xFFFFF;
        int v2 = 0;
        while(v < arr_v.length) {
            int v3 = this.zzs(v);
            int[] arr_v1 = this.zzc;
            int v4 = v3 >>> 20 & 0xFF;
            int v5 = arr_v1[v];
            if(v4 <= 17) {
                int v6 = arr_v1[v + 2];
                int v7 = v6 & 0xFFFFF;
                if(v7 != v1) {
                    v2 = v7 == 0xFFFFF ? 0 : unsafe0.getInt(object0, ((long)v7));
                    v1 = v7;
                }
                map$Entry1 = map$Entry0;
                v8 = v1;
                v9 = v2;
                v10 = 1 << (v6 >>> 20);
            }
            else {
                map$Entry1 = map$Entry0;
                v8 = v1;
                v9 = v2;
                v10 = 0;
            }
            while(map$Entry1 != null && this.zzn.zza(map$Entry1) <= v5) {
                this.zzn.zze(zzfx0, map$Entry1);
                if(iterator1.hasNext()) {
                    Object object2 = iterator1.next();
                    map$Entry1 = (Map.Entry)object2;
                }
                else {
                    map$Entry1 = null;
                }
            }
            long v11 = (long)(v3 & 0xFFFFF);
            switch(v4) {
                case 0: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzf(v5, zzfp.zza(object0, v11));
                    }
                    break;
                }
                case 1: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzo(v5, zzfp.zzb(object0, v11));
                    }
                    break;
                }
                case 2: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzt(v5, unsafe0.getLong(object0, v11));
                    }
                    break;
                }
                case 3: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzK(v5, unsafe0.getLong(object0, v11));
                    }
                    break;
                }
                case 4: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzr(v5, unsafe0.getInt(object0, v11));
                    }
                    break;
                }
                case 5: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzm(v5, unsafe0.getLong(object0, v11));
                    }
                    break;
                }
                case 6: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzk(v5, unsafe0.getInt(object0, v11));
                    }
                    break;
                }
                case 7: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzb(v5, zzfp.zzw(object0, v11));
                    }
                    break;
                }
                case 8: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzef.zzO(v5, unsafe0.getObject(object0, v11), zzfx0);
                    }
                    break;
                }
                case 9: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzv(v5, unsafe0.getObject(object0, v11), this.zzv(v));
                    }
                    break;
                }
                case 10: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzd(v5, ((zzbq)unsafe0.getObject(object0, v11)));
                    }
                    break;
                }
                case 11: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzI(v5, unsafe0.getInt(object0, v11));
                    }
                    break;
                }
                case 12: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzi(v5, unsafe0.getInt(object0, v11));
                    }
                    break;
                }
                case 13: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzx(v5, unsafe0.getInt(object0, v11));
                    }
                    break;
                }
                case 14: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzz(v5, unsafe0.getLong(object0, v11));
                    }
                    break;
                }
                case 15: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzB(v5, unsafe0.getInt(object0, v11));
                    }
                    break;
                }
                case 16: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzD(v5, unsafe0.getLong(object0, v11));
                    }
                    break;
                }
                case 17: {
                    if(this.zzJ(object0, v, v8, v9, v10)) {
                        zzfx0.zzq(v5, unsafe0.getObject(object0, v11), this.zzv(v));
                    }
                    break;
                }
                case 18: {
                    zzeq.zzt(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 19: {
                    zzeq.zzx(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 20: {
                    zzeq.zzz(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 21: {
                    zzeq.zzF(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 22: {
                    zzeq.zzy(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 23: {
                    zzeq.zzw(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 24: {
                    zzeq.zzv(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 25: {
                    zzeq.zzs(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 26: {
                    int v12 = this.zzc[v];
                    List list0 = (List)unsafe0.getObject(object0, v11);
                    if(list0 != null && !list0.isEmpty()) {
                        zzfx0.zzH(v12, list0);
                    }
                    break;
                }
                case 27: {
                    int v13 = this.zzc[v];
                    List list1 = (List)unsafe0.getObject(object0, v11);
                    zzeo zzeo0 = this.zzv(v);
                    if(list1 != null && !list1.isEmpty()) {
                        for(int v14 = 0; v14 < list1.size(); ++v14) {
                            ((zzbz)zzfx0).zzv(v13, list1.get(v14), zzeo0);
                        }
                    }
                    break;
                }
                case 28: {
                    int v15 = this.zzc[v];
                    List list2 = (List)unsafe0.getObject(object0, v11);
                    if(list2 != null && !list2.isEmpty()) {
                        zzfx0.zze(v15, list2);
                    }
                    break;
                }
                case 29: {
                    zzeq.zzE(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 30: {
                    zzeq.zzu(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 0x1F: {
                    zzeq.zzA(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 0x20: {
                    zzeq.zzB(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 33: {
                    zzeq.zzC(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 34: {
                    zzeq.zzD(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, false);
                    break;
                }
                case 35: {
                    zzeq.zzt(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 36: {
                    zzeq.zzx(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 37: {
                    zzeq.zzz(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 38: {
                    zzeq.zzF(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 39: {
                    zzeq.zzy(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 40: {
                    zzeq.zzw(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 41: {
                    zzeq.zzv(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 42: {
                    zzeq.zzs(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 43: {
                    zzeq.zzE(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 44: {
                    zzeq.zzu(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 45: {
                    zzeq.zzA(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 46: {
                    zzeq.zzB(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 0x2F: {
                    zzeq.zzC(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 0x30: {
                    zzeq.zzD(this.zzc[v], ((List)unsafe0.getObject(object0, v11)), zzfx0, true);
                    break;
                }
                case 49: {
                    int v16 = this.zzc[v];
                    List list3 = (List)unsafe0.getObject(object0, v11);
                    zzeo zzeo1 = this.zzv(v);
                    if(list3 != null && !list3.isEmpty()) {
                        for(int v17 = 0; v17 < list3.size(); ++v17) {
                            ((zzbz)zzfx0).zzq(v16, list3.get(v17), zzeo1);
                        }
                    }
                    break;
                }
                case 50: {
                    if(unsafe0.getObject(object0, v11) != null) {
                        zzdv zzdv0 = (zzdv)this.zzw(v);
                        throw null;
                    }
                    break;
                }
                case 51: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzf(v5, zzef.zzm(object0, v11));
                    }
                    break;
                }
                case 52: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzo(v5, zzef.zzn(object0, v11));
                    }
                    break;
                }
                case 53: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzt(v5, zzef.zzt(object0, v11));
                    }
                    break;
                }
                case 54: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzK(v5, zzef.zzt(object0, v11));
                    }
                    break;
                }
                case 55: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzr(v5, zzef.zzo(object0, v11));
                    }
                    break;
                }
                case 56: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzm(v5, zzef.zzt(object0, v11));
                    }
                    break;
                }
                case 57: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzk(v5, zzef.zzo(object0, v11));
                    }
                    break;
                }
                case 58: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzb(v5, zzef.zzN(object0, v11));
                    }
                    break;
                }
                case 59: {
                    if(this.zzM(object0, v5, v)) {
                        zzef.zzO(v5, unsafe0.getObject(object0, v11), zzfx0);
                    }
                    break;
                }
                case 60: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzv(v5, unsafe0.getObject(object0, v11), this.zzv(v));
                    }
                    break;
                }
                case 61: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzd(v5, ((zzbq)unsafe0.getObject(object0, v11)));
                    }
                    break;
                }
                case 62: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzI(v5, zzef.zzo(object0, v11));
                    }
                    break;
                }
                case 0x3F: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzi(v5, zzef.zzo(object0, v11));
                    }
                    break;
                }
                case 0x40: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzx(v5, zzef.zzo(object0, v11));
                    }
                    break;
                }
                case 65: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzz(v5, zzef.zzt(object0, v11));
                    }
                    break;
                }
                case 66: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzB(v5, zzef.zzo(object0, v11));
                    }
                    break;
                }
                case 67: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzD(v5, zzef.zzt(object0, v11));
                    }
                    break;
                }
                case 68: {
                    if(this.zzM(object0, v5, v)) {
                        zzfx0.zzq(v5, unsafe0.getObject(object0, v11), this.zzv(v));
                    }
                }
            }
            v += 3;
            v2 = v9;
            v1 = v8;
            map$Entry0 = map$Entry1;
        }
        while(map$Entry0 != null) {
            this.zzn.zze(zzfx0, map$Entry0);
            if(iterator1.hasNext()) {
                Object object3 = iterator1.next();
                map$Entry0 = (Map.Entry)object3;
            }
            else {
                map$Entry0 = null;
            }
        }
        Object object4 = this.zzm.zzd(object0);
        this.zzm.zzj(object4, zzfx0);
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final boolean zzj(Object object0, Object object1) {
        boolean z;
        int v = 0;
        while(v < this.zzc.length) {
            int v1 = this.zzs(v);
            long v2 = (long)(v1 & 0xFFFFF);
            switch(v1 >>> 20 & 0xFF) {
                case 0: {
                    if(this.zzH(object0, object1, v) && Double.doubleToLongBits(zzfp.zza(object0, v2)) == Double.doubleToLongBits(zzfp.zza(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 1: {
                    if(this.zzH(object0, object1, v) && Float.floatToIntBits(zzfp.zzb(object0, v2)) == Float.floatToIntBits(zzfp.zzb(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 2: {
                    if(this.zzH(object0, object1, v) && zzfp.zzd(object0, v2) == zzfp.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 3: {
                    if(this.zzH(object0, object1, v) && zzfp.zzd(object0, v2) == zzfp.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 4: {
                    if(this.zzH(object0, object1, v) && zzfp.zzc(object0, v2) == zzfp.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 5: {
                    if(this.zzH(object0, object1, v) && zzfp.zzd(object0, v2) == zzfp.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 6: {
                    if(this.zzH(object0, object1, v) && zzfp.zzc(object0, v2) == zzfp.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 7: {
                    if(this.zzH(object0, object1, v) && zzfp.zzw(object0, v2) == zzfp.zzw(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 8: {
                    if(this.zzH(object0, object1, v) && zzeq.zzG(zzfp.zzf(object0, v2), zzfp.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 9: {
                    if(this.zzH(object0, object1, v) && zzeq.zzG(zzfp.zzf(object0, v2), zzfp.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 10: {
                    if(this.zzH(object0, object1, v) && zzeq.zzG(zzfp.zzf(object0, v2), zzfp.zzf(object1, v2))) {
                        break;
                    }
                    return false;
                }
                case 11: {
                    if(this.zzH(object0, object1, v) && zzfp.zzc(object0, v2) == zzfp.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 12: {
                    if(this.zzH(object0, object1, v) && zzfp.zzc(object0, v2) == zzfp.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 13: {
                    if(this.zzH(object0, object1, v) && zzfp.zzc(object0, v2) == zzfp.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 14: {
                    if(this.zzH(object0, object1, v) && zzfp.zzd(object0, v2) == zzfp.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 15: {
                    if(this.zzH(object0, object1, v) && zzfp.zzc(object0, v2) == zzfp.zzc(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 16: {
                    if(this.zzH(object0, object1, v) && zzfp.zzd(object0, v2) == zzfp.zzd(object1, v2)) {
                        break;
                    }
                    return false;
                }
                case 17: {
                    if(this.zzH(object0, object1, v) && zzeq.zzG(zzfp.zzf(object0, v2), zzfp.zzf(object1, v2))) {
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
                    z = zzeq.zzG(zzfp.zzf(object0, v2), zzfp.zzf(object1, v2));
                    goto label_45;
                }
                case 50: {
                    z = zzeq.zzG(zzfp.zzf(object0, v2), zzfp.zzf(object1, v2));
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
                    int v3 = this.zzp(v);
                    if(zzfp.zzc(object0, ((long)(v3 & 0xFFFFF))) != zzfp.zzc(object1, ((long)(v3 & 0xFFFFF))) || !zzeq.zzG(zzfp.zzf(object0, v2), zzfp.zzf(object1, v2))) {
                        return false;
                    }
                }
            }
            v += 3;
        }
        if(!this.zzm.zzd(object0).equals(this.zzm.zzd(object1))) {
            return false;
        }
        return this.zzh ? this.zzn.zzb(object0).equals(this.zzn.zzb(object1)) : true;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzeo
    public final boolean zzk(Object object0) {
        int v10;
        int v9;
        int v = 0;
        int v2 = 0xFFFFF;
        for(int v1 = 0; v < this.zzj; v1 = v9) {
            int v3 = this.zzi[v];
            int v4 = this.zzc[v3];
            int v5 = this.zzs(v3);
            int v6 = this.zzc[v3 + 2];
            int v7 = v6 & 0xFFFFF;
            int v8 = 1 << (v6 >>> 20);
            if(v7 == v2) {
                v10 = v2;
                v9 = v1;
            }
            else {
                if(v7 != 0xFFFFF) {
                    v1 = zzef.zzb.getInt(object0, ((long)v7));
                }
                v9 = v1;
                v10 = v7;
            }
            if((0x10000000 & v5) != 0 && !this.zzJ(object0, v3, v10, v9, v8)) {
                return false;
            }
            switch(v5 >>> 20 & 0xFF) {
                case 9: 
                case 17: {
                    if(this.zzJ(object0, v3, v10, v9, v8) && !zzef.zzK(object0, v5, this.zzv(v3))) {
                        return false;
                    }
                    break;
                }
                case 27: 
                case 49: {
                    List list0 = (List)zzfp.zzf(object0, ((long)(v5 & 0xFFFFF)));
                    if(!list0.isEmpty()) {
                        zzeo zzeo0 = this.zzv(v3);
                        for(int v11 = 0; v11 < list0.size(); ++v11) {
                            if(!zzeo0.zzk(list0.get(v11))) {
                                return false;
                            }
                        }
                    }
                    break;
                }
                case 50: {
                    if(!((zzdw)zzfp.zzf(object0, ((long)(v5 & 0xFFFFF)))).isEmpty()) {
                        zzdv zzdv0 = (zzdv)this.zzw(v3);
                        throw null;
                    }
                    break;
                }
                case 60: 
                case 68: {
                    if(this.zzM(object0, v4, v3) && !zzef.zzK(object0, v5, this.zzv(v3))) {
                        return false;
                    }
                }
            }
            ++v;
            v2 = v10;
        }
        return !this.zzh || this.zzn.zzb(object0).zzj();
    }

    public static zzef zzl(Class class0, zzdz zzdz0, zzei zzei0, zzdq zzdq0, zzff zzff0, zzce zzce0, zzdx zzdx0) {
        Field field3;
        int v95;
        int v89;
        Object[] arr_object2;
        int v88;
        int v87;
        int v86;
        int v85;
        int v84;
        Field field1;
        int v83;
        int v82;
        Field field0;
        int v80;
        int v79;
        int v77;
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
        if(zzdz0 instanceof zzen) {
            String s = ((zzen)zzdz0).zzd();
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
                arr_v = zzef.zza;
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
            Unsafe unsafe0 = zzef.zzb;
            Object[] arr_object = ((zzen)zzdz0).zze();
            Class class1 = ((zzen)zzdz0).zza().getClass();
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
                    v79 = v;
                    if(v78 == 9 || v78 == 17) {
                        arr_object1[v57 / 3 * 2 + 1] = arr_object[v12];
                        v80 = v71;
                        ++v12;
                    }
                    else {
                        if(v78 == 12) {
                            if(((zzen)zzdz0).zzc() == 1 || v71 != 0) {
                                arr_object1[v57 / 3 * 2 + 1] = arr_object[v12];
                                ++v12;
                            }
                            else {
                                v80 = 0;
                                goto label_220;
                            }
                        }
                        v80 = v71;
                    }
                label_220:
                    int v81 = v72 + v72;
                    Object object0 = arr_object[v81];
                    v71 = v80;
                    if(object0 instanceof Field) {
                        field0 = (Field)object0;
                    }
                    else {
                        field0 = zzef.zzz(class1, ((String)object0));
                        arr_object[v81] = field0;
                    }
                    v82 = (int)unsafe0.objectFieldOffset(field0);
                    Object object1 = arr_object[v81 + 1];
                    v83 = v14;
                    if(object1 instanceof Field) {
                        field1 = (Field)object1;
                    }
                    else {
                        field1 = zzef.zzz(class1, ((String)object1));
                        arr_object[v81 + 1] = field1;
                    }
                    v84 = v12;
                    v85 = v77;
                    v86 = 0;
                    v87 = v57;
                    v88 = (int)unsafe0.objectFieldOffset(field1);
                    arr_object2 = arr_object1;
                }
                else {
                    v79 = v;
                    v83 = v14;
                    Field field2 = zzef.zzz(class1, ((String)arr_object[v12]));
                    switch(v65 & 0xFF) {
                        case 9: 
                        case 17: {
                            v84 = v12 + 1;
                            arr_object1[v57 / 3 * 2 + 1] = field2.getType();
                            v87 = v57;
                            break;
                        }
                        case 27: {
                            v89 = v12 + 2;
                            arr_object1[v57 / 3 * 2 + 1] = arr_object[v12 + 1];
                            v84 = v89;
                            v87 = v57;
                            break;
                        }
                        case 12: 
                        case 30: 
                        case 44: {
                            v84 = v12 + 1;
                            if(((zzen)zzdz0).zzc() == 1 || v71 != 0) {
                                v89 = v12 + 2;
                                arr_object1[v57 / 3 * 2 + 1] = arr_object[v84];
                                v84 = v89;
                                v87 = v57;
                            }
                            else {
                                v87 = v57;
                                v71 = 0;
                            }
                            break;
                        }
                        case 49: {
                            arr_object1[v57 / 3 * 2 + 1] = arr_object[v12 + 1];
                            v84 = v12 + 2;
                            v87 = v57;
                            break;
                        }
                        case 50: {
                            arr_v[v55] = v57;
                            int v90 = v57 / 3 + v57 / 3;
                            arr_object1[v90] = arr_object[v12 + 1];
                            if(v71 == 0) {
                                v87 = v57;
                                ++v55;
                                v71 = 0;
                                v84 = v12 + 2;
                            }
                            else {
                                arr_object1[v90 + 1] = arr_object[v12 + 2];
                                v87 = v57;
                                ++v55;
                                v84 = v12 + 3;
                            }
                            break;
                        }
                        default: {
                            v84 = v12 + 1;
                            v87 = v57;
                            break;
                        }
                    }
                    v82 = (int)unsafe0.objectFieldOffset(field2);
                    v88 = 0xFFFFF;
                    if((v65 & 0x1000) == 0 || (v65 & 0xFF) > 17) {
                        arr_object2 = arr_object1;
                        v85 = v70;
                        v86 = 0;
                    }
                    else {
                        int v91 = v70 + 1;
                        int v92 = s.charAt(v70);
                        if(v92 >= 0xD800) {
                            int v93 = v92 & 0x1FFF;
                            int v94 = 13;
                            while(true) {
                                v85 = v91 + 1;
                                v95 = s.charAt(v91);
                                if(v95 < 0xD800) {
                                    break;
                                }
                                v93 |= (v95 & 0x1FFF) << v94;
                                v94 += 13;
                                v91 = v85;
                            }
                            v92 = v93 | v95 << v94;
                        }
                        else {
                            v85 = v91;
                        }
                        int v96 = v92 / 0x20 + v83 * 2;
                        Object object2 = arr_object[v96];
                        if(object2 instanceof Field) {
                            field3 = (Field)object2;
                        }
                        else {
                            field3 = zzef.zzz(class1, ((String)object2));
                            arr_object[v96] = field3;
                        }
                        arr_object2 = arr_object1;
                        v86 = v92 % 0x20;
                        v88 = (int)unsafe0.objectFieldOffset(field3);
                    }
                    if((v65 & 0xFF) >= 18 && (v65 & 0xFF) <= 49) {
                        arr_v[v56] = v82;
                        ++v56;
                    }
                }
                arr_v1[v87] = v59;
                arr_v1[v87 + 1] = v82 | (((v65 & 0x100) == 0 ? 0 : 0x10000000) | ((v65 & 0x200) == 0 ? 0 : 0x20000000) | (v71 == 0 ? 0 : 0x80000000) | (v65 & 0xFF) << 20);
                arr_v1[v87 + 2] = v86 << 20 | v88;
                arr_object1 = arr_object2;
                v57 = v87 + 3;
                v3 = v85;
                v12 = v84;
                v = v79;
                v14 = v83;
            }
            return new zzef(arr_v1, arr_object1, v10, v11, ((zzen)zzdz0).zza(), ((zzen)zzdz0).zzc(), false, arr_v, v13, v54, zzei0, zzdq0, zzff0, zzce0, zzdx0);
        }
        zzfc zzfc0 = (zzfc)zzdz0;
        throw null;
    }

    private static double zzm(Object object0, long v) {
        return (double)(((Double)zzfp.zzf(object0, v)));
    }

    private static float zzn(Object object0, long v) {
        return (float)(((Float)zzfp.zzf(object0, v)));
    }

    private static int zzo(Object object0, long v) {
        return (int)(((Integer)zzfp.zzf(object0, v)));
    }

    private final int zzp(int v) {
        return this.zzc[v + 2];
    }

    private final int zzq(int v, int v1) {
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

    private static int zzr(int v) [...] // Inlined contents

    private final int zzs(int v) {
        return this.zzc[v + 1];
    }

    private static long zzt(Object object0, long v) {
        return (long)(((Long)zzfp.zzf(object0, v)));
    }

    private final zzcw zzu(int v) {
        return (zzcw)this.zzd[v / 3 * 2 + 1];
    }

    private final zzeo zzv(int v) {
        Object[] arr_object = this.zzd;
        int v1 = v / 3 + v / 3;
        zzeo zzeo0 = (zzeo)arr_object[v1];
        if(zzeo0 != null) {
            return zzeo0;
        }
        zzeo zzeo1 = zzel.zza().zzb(((Class)arr_object[v1 + 1]));
        this.zzd[v1] = zzeo1;
        return zzeo1;
    }

    private final Object zzw(int v) {
        return this.zzd[v / 3 + v / 3];
    }

    private final Object zzx(Object object0, int v) {
        zzeo zzeo0 = this.zzv(v);
        int v1 = this.zzs(v);
        if(!this.zzI(object0, v)) {
            return zzeo0.zze();
        }
        Object object1 = zzef.zzb.getObject(object0, ((long)(v1 & 0xFFFFF)));
        if(zzef.zzL(object1)) {
            return object1;
        }
        Object object2 = zzeo0.zze();
        if(object1 != null) {
            zzeo0.zzg(object2, object1);
        }
        return object2;
    }

    private final Object zzy(Object object0, int v, int v1) {
        zzeo zzeo0 = this.zzv(v1);
        if(!this.zzM(object0, v, v1)) {
            return zzeo0.zze();
        }
        int v2 = this.zzs(v1);
        Object object1 = zzef.zzb.getObject(object0, ((long)(v2 & 0xFFFFF)));
        if(zzef.zzL(object1)) {
            return object1;
        }
        Object object2 = zzeo0.zze();
        if(object1 != null) {
            zzeo0.zzg(object2, object1);
        }
        return object2;
    }

    private static Field zzz(Class class0, String s) {
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
}

