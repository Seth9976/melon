package com.google.android.gms.internal.play_billing;

import b3.Z;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzci {
    final zzfb zza;
    private static final zzci zzb;
    private boolean zzc;
    private boolean zzd;

    static {
        zzci.zzb = new zzci(true);
    }

    private zzci() {
        this.zza = new zzer(16);
    }

    private zzci(boolean z) {
        zzer zzer0 = new zzer(0);
        super();
        this.zza = zzer0;
        this.zzg();
        this.zzg();
    }

    @Override
    public final Object clone() {
        zzci zzci0 = new zzci();
        for(int v = 0; v < this.zza.zzb(); ++v) {
            Map.Entry map$Entry0 = this.zza.zzg(v);
            zzci0.zzi(((zzch)map$Entry0.getKey()), map$Entry0.getValue());
        }
        for(Object object0: this.zza.zzc()) {
            zzci0.zzi(((zzch)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
        }
        zzci0.zzd = this.zzd;
        return zzci0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzci ? this.zza.equals(((zzci)object0).zza) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static int zza(zzfv zzfv0, int v, Object object0) {
        throw zzfv.zzj != null || !(((zzec)object0) instanceof zzaz) ? null : null;
    }

    public static int zzb(zzch zzch0, Object object0) {
        int v = 0;
        zzfv zzfv0 = zzch0.zzd();
        int v1 = zzch0.zza();
        if(zzch0.zzg()) {
            if(zzch0.zzf()) {
                if(((List)object0).isEmpty()) {
                    return 0;
                }
                Iterator iterator0 = ((List)object0).iterator();
                if(!iterator0.hasNext()) {
                    return zzby.zzw(v1 << 3) + 1;
                }
                iterator0.next();
                throw null;
            }
            for(Object object1: ((List)object0)) {
                v += zzci.zza(zzfv0, v1, object1);
            }
            return v;
        }
        return zzci.zza(zzfv0, v1, object0);
    }

    public final int zzc() {
        int v1 = 0;
        for(int v = 0; v < this.zza.zzb(); ++v) {
            v1 += zzci.zzo(this.zza.zzg(v));
        }
        for(Object object0: this.zza.zzc()) {
            v1 += zzci.zzo(((Map.Entry)object0));
        }
        return v1;
    }

    public static zzci zzd() {
        return zzci.zzb;
    }

    public final Object zze(zzch zzch0) {
        Object object0 = this.zza.get(zzch0);
        if(object0 instanceof zzdh) {
            throw null;
        }
        return object0;
    }

    public final Iterator zzf() {
        return this.zzd ? new zzdg(this.zza.entrySet().iterator()) : this.zza.entrySet().iterator();
    }

    public final void zzg() {
        if(!this.zzc) {
            for(int v = 0; v < this.zza.zzb(); ++v) {
                Map.Entry map$Entry0 = this.zza.zzg(v);
                if(map$Entry0.getValue() instanceof zzcs) {
                    ((zzcs)map$Entry0.getValue()).zzr();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzh(zzci zzci0) {
        for(int v = 0; v < zzci0.zza.zzb(); ++v) {
            this.zzl(zzci0.zza.zzg(v));
        }
        for(Object object0: zzci0.zza.zzc()) {
            this.zzl(((Map.Entry)object0));
        }
    }

    public final void zzi(zzch zzch0, Object object0) {
        if(zzch0.zzg()) {
            if(!(object0 instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            ArrayList arrayList0 = new ArrayList();
            arrayList0.addAll(((List)object0));
            int v = arrayList0.size();
            for(int v1 = 0; v1 < v; ++v1) {
                zzci.zzp(zzch0, arrayList0.get(v1));
            }
            object0 = arrayList0;
        }
        else {
            zzci.zzp(zzch0, object0);
        }
        if(object0 instanceof zzdh) {
            this.zzd = true;
        }
        this.zza.zze(zzch0, object0);
    }

    public final boolean zzj() {
        for(int v = 0; v < this.zza.zzb(); ++v) {
            if(!zzci.zzm(this.zza.zzg(v))) {
                return false;
            }
        }
        for(Object object0: this.zza.zzc()) {
            if(!zzci.zzm(((Map.Entry)object0))) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    private static Object zzk(Object object0) {
        if(object0 instanceof zzeh) {
            return ((zzeh)object0).zzd();
        }
        if(object0 instanceof byte[]) {
            byte[] arr_b = new byte[((byte[])object0).length];
            System.arraycopy(((byte[])object0), 0, arr_b, 0, ((byte[])object0).length);
            return arr_b;
        }
        return object0;
    }

    private final void zzl(Map.Entry map$Entry0) {
        zzch zzch0 = (zzch)map$Entry0.getKey();
        Object object0 = map$Entry0.getValue();
        if(zzch0.zzg()) {
            if(object0 instanceof zzdh) {
                throw new IllegalStateException("Lazy fields can not be repeated");
            }
            ArrayList arrayList0 = this.zze(zzch0);
            if(arrayList0 == null) {
                arrayList0 = new ArrayList();
            }
            for(Object object1: ((List)object0)) {
                arrayList0.add(zzci.zzk(object1));
            }
            this.zza.zze(zzch0, arrayList0);
            return;
        }
        if(zzch0.zze() == zzfw.zzi) {
            Object object2 = this.zze(zzch0);
            if(object2 == null) {
                Object object3 = zzci.zzk(object0);
                this.zza.zze(zzch0, object3);
                if(object0 instanceof zzdh) {
                    this.zzd = true;
                }
                return;
            }
            if(object0 instanceof zzdh) {
                throw null;
            }
            zzec zzec0 = object2 instanceof zzeh ? zzch0.zzc(((zzeh)object2), ((zzeh)object0)) : zzch0.zzb(((zzec)object2).zzF(), ((zzec)object0)).zzf();
            this.zza.zze(zzch0, zzec0);
            return;
        }
        if(object0 instanceof zzdh) {
            throw new IllegalStateException("Lazy fields must be message-valued");
        }
        Object object4 = zzci.zzk(object0);
        this.zza.zze(zzch0, object4);
    }

    private static boolean zzm(Map.Entry map$Entry0) {
        zzch zzch0 = (zzch)map$Entry0.getKey();
        if(zzch0.zze() == zzfw.zzi) {
            if(zzch0.zzg()) {
                Iterator iterator0 = ((List)map$Entry0.getValue()).iterator();
                while(true) {
                    if(!iterator0.hasNext()) {
                        return true;
                    }
                    Object object0 = iterator0.next();
                    if(zzci.zzn(object0)) {
                        continue;
                    }
                    return false;
                }
            }
            return zzci.zzn(map$Entry0.getValue());
        }
        return true;
    }

    private static boolean zzn(Object object0) {
        if(object0 instanceof zzed) {
            return ((zzed)object0).zzk();
        }
        if(!(object0 instanceof zzdh)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        return true;
    }

    private static final int zzo(Map.Entry map$Entry0) {
        int v;
        zzch zzch0 = (zzch)map$Entry0.getKey();
        Object object0 = map$Entry0.getValue();
        if(zzch0.zze() == zzfw.zzi && !zzch0.zzg() && !zzch0.zzf()) {
            if(object0 instanceof zzdh) {
                v = zzby.zzw(((zzch)map$Entry0.getKey()).zza()) + 1;
                int v1 = ((zzdh)object0).zza();
                return Z.C(v1, v1, 1) + 2 + v;
            }
            v = zzby.zzw(((zzch)map$Entry0.getKey()).zza()) + 1;
            int v2 = ((zzec)object0).zzf();
            return Z.C(v2, v2, 1) + v + 2;
        }
        return zzci.zzb(zzch0, object0);
    }

    private static final void zzp(zzch zzch0, Object object0) {
        boolean z;
        zzfv zzfv0 = zzch0.zzd();
        object0.getClass();
        switch(zzfv0.zza().ordinal()) {
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
                if(object0 instanceof zzbq || object0 instanceof byte[]) {
                    return;
                }
                break;
            }
            case 7: {
                if(object0 instanceof Integer || object0 instanceof zzcu) {
                    return;
                }
                break;
            }
            case 8: {
                if(object0 instanceof zzec || object0 instanceof zzdh) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", zzch0.zza(), zzch0.zzd().zza(), object0.getClass().getName()));
    }
}

