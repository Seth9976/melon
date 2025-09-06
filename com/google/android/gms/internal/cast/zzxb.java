package com.google.android.gms.internal.cast;

import b3.Z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzxb {
    final zzzd zza;
    private static final zzxb zzb;
    private boolean zzc;
    private boolean zzd;

    static {
        zzxb.zzb = new zzxb(true);
    }

    private zzxb() {
        this.zza = new zzyy();
    }

    private zzxb(boolean z) {
        zzyy zzyy0 = new zzyy();
        super();
        this.zza = zzyy0;
        this.zzf();
        this.zzf();
    }

    @Override
    public final Object clone() {
        zzxb zzxb0 = new zzxb();
        zzzd zzzd0 = this.zza;
        int v = zzzd0.zzc();
        for(int v1 = 0; v1 < v; ++v1) {
            Map.Entry map$Entry0 = zzzd0.zzg(v1);
            zzxb0.zzg(((zzxa)((zzyz)map$Entry0).zza()), map$Entry0.getValue());
        }
        for(Object object0: zzzd0.zzd()) {
            zzxb0.zzg(((zzxa)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
        }
        zzxb0.zzd = this.zzd;
        return zzxb0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzxb ? this.zza.equals(((zzxb)object0).zza) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static int zza(zzzr zzzr0, int v, Object object0) {
        throw zzzr.zzj != null || !(((zzyl)object0) instanceof zzwb) ? null : null;
    }

    public static int zzb(zzxa zzxa0, Object object0) {
        zzzr zzzr0 = zzxa0.zzb();
        int v = zzxa0.zza();
        if(zzxa0.zze()) {
            int v1 = ((List)object0).size();
            if(zzxa0.zzd()) {
                if(!((List)object0).isEmpty()) {
                    if(v1 <= 0) {
                        return zzwu.zzz(v << 3) + 1;
                    }
                    ((List)object0).get(0);
                    throw null;
                }
                return 0;
            }
            int v3 = 0;
            for(int v2 = 0; v2 < v1; ++v2) {
                v3 += zzxb.zza(zzzr0, v, ((List)object0).get(v2));
            }
            return v3;
        }
        return zzxb.zza(zzzr0, v, object0);
    }

    public final int zzc() {
        zzzd zzzd0 = this.zza;
        int v = zzzd0.zzc();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += zzxb.zzk(zzzd0.zzg(v1));
        }
        for(Object object0: zzzd0.zzd()) {
            v2 += zzxb.zzk(((Map.Entry)object0));
        }
        return v2;
    }

    public static zzxb zzd() {
        return zzxb.zzb;
    }

    public final Iterator zze() {
        zzzd zzzd0 = this.zza;
        if(zzzd0.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzd ? new zzxt(zzzd0.entrySet().iterator()) : zzzd0.entrySet().iterator();
    }

    public final void zzf() {
        if(this.zzc) {
            return;
        }
        zzzd zzzd0 = this.zza;
        int v = zzzd0.zzc();
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = zzzd0.zzg(v1).getValue();
            if(object0 instanceof zzxi) {
                ((zzxi)object0).zzH();
            }
        }
        for(Object object1: zzzd0.zzd()) {
            Object object2 = ((Map.Entry)object1).getValue();
            if(object2 instanceof zzxi) {
                ((zzxi)object2).zzH();
            }
        }
        zzzd0.zza();
        this.zzc = true;
    }

    public final void zzg(zzxa zzxa0, Object object0) {
        if(zzxa0.zze()) {
            if(!(object0 instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list0 = (List)object0;
            int v = list0.size();
            ArrayList arrayList0 = new ArrayList(v);
            for(int v1 = 0; v1 < v; ++v1) {
                Object object1 = list0.get(v1);
                zzxb.zzl(zzxa0, object1);
                arrayList0.add(object1);
            }
            object0 = arrayList0;
        }
        else {
            zzxb.zzl(zzxa0, object0);
        }
        if(object0 instanceof zzxv) {
            this.zzd = true;
        }
        this.zza.zzf(zzxa0, object0);
    }

    public final boolean zzh() {
        zzzd zzzd0 = this.zza;
        int v = zzzd0.zzc();
        for(int v1 = 0; v1 < v; ++v1) {
            if(!zzxb.zzi(zzzd0.zzg(v1))) {
                return false;
            }
        }
        for(Object object0: zzzd0.zzd()) {
            if(!zzxb.zzi(((Map.Entry)object0))) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    private static boolean zzi(Map.Entry map$Entry0) {
        zzxa zzxa0 = (zzxa)map$Entry0.getKey();
        if(zzxa0.zzc() == zzzs.zzi) {
            if(zzxa0.zze()) {
                List list0 = (List)map$Entry0.getValue();
                int v = list0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    if(!zzxb.zzj(list0.get(v1))) {
                        return false;
                    }
                }
                return true;
            }
            return zzxb.zzj(map$Entry0.getValue());
        }
        return true;
    }

    private static boolean zzj(Object object0) {
        if(object0 instanceof zzym) {
            return ((zzym)object0).zzx();
        }
        if(!(object0 instanceof zzxv)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        return true;
    }

    private static final int zzk(Map.Entry map$Entry0) {
        int v;
        zzxa zzxa0 = (zzxa)map$Entry0.getKey();
        Object object0 = map$Entry0.getValue();
        if(zzxa0.zzc() == zzzs.zzi && !zzxa0.zze() && !zzxa0.zzd()) {
            if(object0 instanceof zzxv) {
                v = zzwu.zzz(((zzxa)map$Entry0.getKey()).zza()) + 1;
                int v1 = ((zzxv)object0).zza();
                return Z.z(v1, v1, 1) + 2 + v;
            }
            v = zzwu.zzz(((zzxa)map$Entry0.getKey()).zza()) + 1;
            int v2 = ((zzyl)object0).zzw();
            return Z.z(v2, v2, 1) + v + 2;
        }
        return zzxb.zzb(zzxa0, object0);
    }

    private static final void zzl(zzxa zzxa0, Object object0) {
        boolean z;
        zzzr zzzr0 = zzxa0.zzb();
        object0.getClass();
        switch(zzzr0.zza().ordinal()) {
            case 0: {
                z = object0 instanceof Integer;
                goto label_15;
            }
            case 1: {
                z = object0 instanceof Long;
                goto label_15;
            }
            case 2: {
                z = object0 instanceof Float;
                goto label_15;
            }
            case 3: {
                z = object0 instanceof Double;
                goto label_15;
            }
            case 4: {
                z = object0 instanceof Boolean;
                goto label_15;
            }
            case 5: {
                z = object0 instanceof String;
            label_15:
                if(z) {
                    return;
                }
                break;
            }
            case 6: {
                if(object0 instanceof zzwn || object0 instanceof byte[]) {
                    return;
                }
                break;
            }
            case 7: {
                if(object0 instanceof Integer || object0 instanceof zzpb) {
                    return;
                }
                break;
            }
            case 8: {
                if(object0 instanceof zzyl || object0 instanceof zzxv) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", zzxa0.zza(), zzxa0.zzb().zza(), object0.getClass().getName()));
    }
}

