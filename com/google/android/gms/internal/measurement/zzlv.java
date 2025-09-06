package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

final class zzlv {
    final zzod zza;
    private boolean zzb;
    private boolean zzc;
    private static final zzlv zzd;

    static {
        zzlv.zzd = new zzlv(true);
    }

    private zzlv() {
        this.zza = new zznz();
    }

    private zzlv(boolean z) {
        zznz zznz0 = new zznz();
        super();
        this.zza = zznz0;
        this.zzb();
        this.zzb();
    }

    @Override
    public final Object clone() {
        zzlv zzlv0 = new zzlv();
        zzod zzod0 = this.zza;
        int v = zzod0.zzc();
        for(int v1 = 0; v1 < v; ++v1) {
            Map.Entry map$Entry0 = zzod0.zzd(v1);
            zzlv0.zzd(((zzlu)((zzoa)map$Entry0).zza()), map$Entry0.getValue());
        }
        for(Object object0: zzod0.zze()) {
            zzlv0.zzd(((zzlu)((Map.Entry)object0).getKey()), ((Map.Entry)object0).getValue());
        }
        zzlv0.zzc = this.zzc;
        return zzlv0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof zzlv ? this.zza.equals(((zzlv)object0).zza) : false;
    }

    @Override
    public final int hashCode() {
        return this.zza.hashCode();
    }

    public static zzlv zza() {
        return zzlv.zzd;
    }

    public final void zzb() {
        if(this.zzb) {
            return;
        }
        zzod zzod0 = this.zza;
        int v = zzod0.zzc();
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = zzod0.zzd(v1).getValue();
            if(object0 instanceof zzme) {
                ((zzme)object0).zzcj();
            }
        }
        for(Object object1: zzod0.zze()) {
            Object object2 = ((Map.Entry)object1).getValue();
            if(object2 instanceof zzme) {
                ((zzme)object2).zzcj();
            }
        }
        zzod0.zza();
        this.zzb = true;
    }

    public final Iterator zzc() {
        zzod zzod0 = this.zza;
        if(zzod0.isEmpty()) {
            return Collections.emptyIterator();
        }
        return this.zzc ? new zzmt(zzod0.entrySet().iterator()) : zzod0.entrySet().iterator();
    }

    public final void zzd(zzlu zzlu0, Object object0) {
        if(zzlu0.zzd()) {
            if(!(object0 instanceof List)) {
                throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
            }
            List list0 = (List)object0;
            int v = list0.size();
            ArrayList arrayList0 = new ArrayList(v);
            for(int v1 = 0; v1 < v; ++v1) {
                Object object1 = list0.get(v1);
                zzlv.zzn(zzlu0, object1);
                arrayList0.add(object1);
            }
            object0 = arrayList0;
        }
        else {
            zzlv.zzn(zzlu0, object0);
        }
        if(object0 instanceof zzmu) {
            this.zzc = true;
        }
        this.zza.zzf(zzlu0, object0);
    }

    public final boolean zze() {
        zzod zzod0 = this.zza;
        int v = zzod0.zzc();
        for(int v1 = 0; v1 < v; ++v1) {
            if(!zzlv.zzk(zzod0.zzd(v1))) {
                return false;
            }
        }
        for(Object object0: zzod0.zze()) {
            if(!zzlv.zzk(((Map.Entry)object0))) {
                return false;
            }
            if(false) {
                break;
            }
        }
        return true;
    }

    public static void zzf(zzll zzll0, zzos zzos0, int v, Object object0) {
        if(zzos0 != zzos.zzj) {
            zzll0.zza(v, zzos0.zzb());
            switch(zzos0.ordinal()) {
                case 0: {
                    zzll0.zzu(Double.doubleToRawLongBits(((double)(((Double)object0)))));
                    return;
                }
                case 1: {
                    zzll0.zzs(Float.floatToRawIntBits(((float)(((Float)object0)))));
                    return;
                }
                case 2: {
                    zzll0.zzt(((long)(((Long)object0))));
                    return;
                }
                case 3: {
                    zzll0.zzt(((long)(((Long)object0))));
                    return;
                }
                case 4: {
                    zzll0.zzq(((int)(((Integer)object0))));
                    return;
                }
                case 5: {
                    zzll0.zzu(((long)(((Long)object0))));
                    return;
                }
                case 6: {
                    zzll0.zzs(((int)(((Integer)object0))));
                    return;
                }
                case 7: {
                    zzll0.zzp(((byte)((Boolean)object0).booleanValue()));
                    return;
                }
                case 8: {
                    if(object0 instanceof zzlg) {
                        zzll0.zzj(((zzlg)object0));
                        return;
                    }
                    zzll0.zzx(((String)object0));
                    return;
                }
                case 9: {
                    ((zznl)object0).zzcB(zzll0);
                    return;
                }
                case 10: {
                    zzll0.zzo(((zznl)object0));
                    return;
                }
                case 11: {
                    if(object0 instanceof zzlg) {
                        zzll0.zzj(((zzlg)object0));
                        return;
                    }
                    zzll0.zzk(((byte[])object0), 0, ((byte[])object0).length);
                    return;
                }
                case 12: {
                    zzll0.zzr(((int)(((Integer)object0))));
                    return;
                }
                case 13: {
                    if(object0 instanceof zzmi) {
                        zzll0.zzq(((zzmi)object0).zza());
                        return;
                    }
                    zzll0.zzq(((int)(((Integer)object0))));
                    return;
                }
                case 14: {
                    zzll0.zzs(((int)(((Integer)object0))));
                    return;
                }
                case 15: {
                    zzll0.zzu(((long)(((Long)object0))));
                    return;
                }
                case 16: {
                    int v1 = (int)(((Integer)object0));
                    zzll0.zzr(v1 >> 0x1F ^ v1 + v1);
                    return;
                }
                case 17: {
                    long v2 = (long)(((Long)object0));
                    zzll0.zzt(v2 >> 0x3F ^ v2 + v2);
                    return;
                }
                default: {
                    return;
                }
            }
        }
        zzmo.zzd(((zznl)object0));
        zzll0.zza(v, 3);
        ((zznl)object0).zzcB(zzll0);
        zzll0.zza(v, 4);
    }

    public final int zzg() {
        zzod zzod0 = this.zza;
        int v = zzod0.zzc();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            v2 += zzlv.zzm(zzod0.zzd(v1));
        }
        for(Object object0: zzod0.zze()) {
            v2 += zzlv.zzm(((Map.Entry)object0));
        }
        return v2;
    }

    public static int zzh(zzos zzos0, int v, Object object0) {
        int v1 = zzll.zzz(v << 3);
        if(zzos0 == zzos.zzj) {
            zzmo.zzd(((zznl)object0));
            v1 += v1;
        }
        return v1 + zzlv.zzi(zzos0, object0);
    }

    public static int zzi(zzos zzos0, Object object0) {
        int v;
        switch(zzos0.ordinal()) {
            case 0: {
                ((Double)object0).getClass();
                return 8;
            }
            case 1: {
                ((Float)object0).getClass();
                return 4;
            }
            case 2: {
                return zzll.zzA(((long)(((Long)object0))));
            }
            case 3: {
                return zzll.zzA(((long)(((Long)object0))));
            }
            case 4: {
                return zzll.zzA(((int)(((Integer)object0))));
            }
            case 5: {
                ((Long)object0).getClass();
                return 8;
            }
            case 6: {
                ((Integer)object0).getClass();
                return 4;
            }
            case 7: {
                ((Boolean)object0).getClass();
                return 1;
            }
            case 8: {
                if(object0 instanceof zzlg) {
                    v = ((zzlg)object0).zzc();
                    return zzll.zzz(v) + v;
                }
                return zzll.zzB(((String)object0));
            }
            case 9: {
                return ((zznl)object0).zzcn();
            }
            case 10: {
                if(object0 instanceof zzmu) {
                    v = ((zzmu)object0).zzb();
                    return zzll.zzz(v) + v;
                }
                return zzll.zzC(((zznl)object0));
            }
            case 11: {
                if(object0 instanceof zzlg) {
                    v = ((zzlg)object0).zzc();
                    return zzll.zzz(v) + v;
                }
                return zzll.zzz(((byte[])object0).length) + ((byte[])object0).length;
            }
            case 12: {
                return zzll.zzz(((int)(((Integer)object0))));
            }
            case 13: {
                return object0 instanceof zzmi ? zzll.zzA(((zzmi)object0).zza()) : zzll.zzA(((int)(((Integer)object0))));
            }
            case 14: {
                ((Integer)object0).getClass();
                return 4;
            }
            case 15: {
                ((Long)object0).getClass();
                return 8;
            }
            case 16: {
                int v1 = (int)(((Integer)object0));
                return zzll.zzz(v1 >> 0x1F ^ v1 + v1);
            }
            case 17: {
                long v2 = (long)(((Long)object0));
                return zzll.zzA(v2 >> 0x3F ^ v2 + v2);
            }
            default: {
                throw new RuntimeException("There is no way to get here, but the compiler thinks otherwise.");
            }
        }
    }

    public static int zzj(zzlu zzlu0, Object object0) {
        zzos zzos0 = zzlu0.zzb();
        int v = zzlu0.zza();
        if(zzlu0.zzd()) {
            int v1 = ((List)object0).size();
            int v2 = 0;
            if(zzlu0.zze()) {
                if(!((List)object0).isEmpty()) {
                    int v3 = 0;
                    while(v2 < v1) {
                        v3 += zzlv.zzi(zzos0, ((List)object0).get(v2));
                        ++v2;
                    }
                    return zzll.zzz(v3) + (zzll.zzz(v << 3) + v3);
                }
                return 0;
            }
            int v4 = 0;
            while(v2 < v1) {
                v4 += zzlv.zzh(zzos0, v, ((List)object0).get(v2));
                ++v2;
            }
            return v4;
        }
        return zzlv.zzh(zzos0, v, object0);
    }

    private static boolean zzk(Map.Entry map$Entry0) {
        zzlu zzlu0 = (zzlu)map$Entry0.getKey();
        if(zzlu0.zzc() == zzot.zzi) {
            if(zzlu0.zzd()) {
                List list0 = (List)map$Entry0.getValue();
                int v = list0.size();
                for(int v1 = 0; v1 < v; ++v1) {
                    if(!zzlv.zzl(list0.get(v1))) {
                        return false;
                    }
                }
                return true;
            }
            return zzlv.zzl(map$Entry0.getValue());
        }
        return true;
    }

    private static boolean zzl(Object object0) {
        if(object0 instanceof zznm) {
            return ((zznm)object0).zzcD();
        }
        if(!(object0 instanceof zzmu)) {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        return true;
    }

    private static final int zzm(Map.Entry map$Entry0) {
        zzlu zzlu0 = (zzlu)map$Entry0.getKey();
        Object object0 = map$Entry0.getValue();
        if(zzlu0.zzc() == zzot.zzi && !zzlu0.zzd() && !zzlu0.zze()) {
            if(object0 instanceof zzmu) {
                int v = zzll.zzz(((zzlu)map$Entry0.getKey()).zza()) + 1;
                int v1 = ((zzmu)object0).zzb();
                return Z.B(v1, v1, 1) + 2 + v;
            }
            return zzll.zzz(((zzlu)map$Entry0.getKey()).zza()) + 3 + (zzll.zzC(((zznl)object0)) + 1);
        }
        return zzlv.zzj(zzlu0, object0);
    }

    private static final void zzn(zzlu zzlu0, Object object0) {
        boolean z;
        zzos zzos0 = zzlu0.zzb();
        object0.getClass();
        switch(zzos0.zza().ordinal()) {
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
                if(object0 instanceof zzlg || object0 instanceof byte[]) {
                    return;
                }
                break;
            }
            case 7: {
                if(object0 instanceof Integer || object0 instanceof zzmi) {
                    return;
                }
                break;
            }
            case 8: {
                if(object0 instanceof zznl || object0 instanceof zzmu) {
                    return;
                }
            }
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", zzlu0.zza(), zzlu0.zzb().zza(), object0.getClass().getName()));
    }
}

