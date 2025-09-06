package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map.Entry;

public final class zzhi {
    Object[] zza;
    int zzb;
    zzhh zzc;

    public zzhi() {
        this(4);
    }

    public zzhi(int v) {
        this.zza = new Object[v + v];
        this.zzb = 0;
    }

    public final zzhi zza(Iterable iterable0) {
        if(iterable0 instanceof Collection) {
            this.zzb(((Collection)iterable0).size() + this.zzb);
        }
        for(Object object0: iterable0) {
            Object object1 = ((Map.Entry)object0).getKey();
            Object object2 = ((Map.Entry)object0).getValue();
            this.zzb(this.zzb + 1);
            zzgx.zza(object1, object2);
            Object[] arr_object = this.zza;
            int v = this.zzb;
            int v1 = v + v;
            arr_object[v1] = object1;
            arr_object[v1 + 1] = object2;
            this.zzb = v + 1;
        }
        return this;
    }

    private final void zzb(int v) {
        Object[] arr_object = this.zza;
        int v1 = v + v;
        if(v1 > arr_object.length) {
            this.zza = Arrays.copyOf(arr_object, zzhb.zza(arr_object.length, v1));
        }
    }
}

