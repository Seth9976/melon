package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

public abstract class zzhk extends zzhc implements Set {
    private transient zzhg zza;

    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof zzhk && this.zzl() && ((zzhk)object0).zzl() && this.hashCode() != object0.hashCode()) {
            return false;
        }
        if(object0 == this) {
            return true;
        }
        if(object0 instanceof Set) {
            Set set0 = (Set)object0;
            try {
                return this.size() != set0.size() || !this.containsAll(set0) ? false : true;
            }
            catch(NullPointerException | ClassCastException unused_ex) {
            }
        }
        return false;
    }

    @Override
    public int hashCode() {
        return zzhu.zza(this);
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public Iterator iterator() {
        return this.zze();
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public zzhg zzd() {
        zzhg zzhg0 = this.zza;
        if(zzhg0 == null) {
            zzhg0 = this.zzi();
            this.zza = zzhg0;
        }
        return zzhg0;
    }

    @Override  // com.google.android.gms.internal.cast.zzhc
    public abstract zzhw zze();

    public static int zzh(int v) {
        int v1 = Math.max(v, 2);
        if(v1 < 0x2CCCCCCC) {
            int v2 = Integer.highestOneBit(v1 - 1);
            do {
                v2 += v2;
            }
            while(((double)v2) * 0.7 < ((double)v1));
            return v2;
        }
        if(v1 >= 0x40000000) {
            throw new IllegalArgumentException("collection too large");
        }
        return 0x40000000;
    }

    public zzhg zzi() {
        Object[] arr_object = this.toArray();
        return zzhg.zzi(arr_object, arr_object.length);
    }

    public static zzhk zzj(Collection collection0) {
        Object[] arr_object = collection0.toArray();
        return zzhk.zzm(arr_object.length, arr_object);
    }

    public static zzhk zzk() {
        return zzht.zza;
    }

    public boolean zzl() {
        return false;
    }

    private static zzhk zzm(int v, Object[] arr_object) {
        switch(v) {
            case 0: {
                return zzht.zza;
            }
            case 1: {
                Object object3 = arr_object[0];
                Objects.requireNonNull(object3);
                return new zzhv(object3);
            }
            default: {
                int v1 = zzhk.zzh(v);
                Object[] arr_object1 = new Object[v1];
                int v3 = 0;
                int v4 = 0;
                for(int v2 = 0; v2 < v; ++v2) {
                    Object object0 = arr_object[v2];
                    zzhm.zza(object0, v2);
                    int v5 = object0.hashCode();
                    for(int v6 = zzgz.zza(v5); true; ++v6) {
                        int v7 = v6 & v1 - 1;
                        Object object1 = arr_object1[v7];
                        if(object1 == null) {
                            arr_object[v4] = object0;
                            arr_object1[v7] = object0;
                            v3 += v5;
                            ++v4;
                            break;
                        }
                        if(object1.equals(object0)) {
                            break;
                        }
                    }
                }
                Arrays.fill(arr_object, v4, v, null);
                if(v4 == 1) {
                    Object object2 = arr_object[0];
                    Objects.requireNonNull(object2);
                    return new zzhv(object2);
                }
                if(zzhk.zzh(v4) < v1 / 2) {
                    return zzhk.zzm(v4, arr_object);
                }
                if(v4 < (arr_object.length >> 1) + (arr_object.length >> 2)) {
                    arr_object = Arrays.copyOf(arr_object, v4);
                }
                return new zzht(arr_object, v3, arr_object1, v1 - 1, v4);
            }
        }
    }
}

