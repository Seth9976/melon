package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.Arrays;
import java.util.RandomAccess;

final class zznu extends zzkt implements RandomAccess {
    private static final Object[] zza;
    private static final zznu zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] arr_object = new Object[0];
        zznu.zza = arr_object;
        zznu.zzb = new zznu(arr_object, 0, false);
    }

    public zznu() {
        this(zznu.zza, 0, true);
    }

    private zznu(Object[] arr_object, int v, boolean z) {
        super(z);
        this.zzc = arr_object;
        this.zzd = v;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final void add(int v, Object object0) {
        this.zzcF();
        if(v >= 0) {
            int v1 = this.zzd;
            if(v <= v1) {
                Object[] arr_object = this.zzc;
                if(v1 < arr_object.length) {
                    System.arraycopy(arr_object, v, arr_object, v + 1, v1 - v);
                }
                else {
                    Object[] arr_object1 = new Object[zznu.zzf(arr_object.length)];
                    System.arraycopy(this.zzc, 0, arr_object1, 0, v);
                    System.arraycopy(this.zzc, v, arr_object1, v + 1, this.zzd - v);
                    this.zzc = arr_object1;
                }
                this.zzc[v] = object0;
                ++this.zzd;
                ++this.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.zzi(v));
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final boolean add(Object object0) {
        this.zzcF();
        int v = this.zzc.length;
        if(this.zzd == v) {
            int v1 = zznu.zzf(v);
            this.zzc = Arrays.copyOf(this.zzc, v1);
        }
        int v2 = this.zzd;
        this.zzd = v2 + 1;
        this.zzc[v2] = object0;
        ++this.modCount;
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzh(v);
        return this.zzc[v];
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final Object remove(int v) {
        this.zzcF();
        this.zzh(v);
        Object[] arr_object = this.zzc;
        Object object0 = arr_object[v];
        int v1 = this.zzd;
        if(v < v1 - 1) {
            System.arraycopy(arr_object, v + 1, arr_object, v, v1 - v - 1);
        }
        --this.zzd;
        ++this.modCount;
        return object0;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final Object set(int v, Object object0) {
        this.zzcF();
        this.zzh(v);
        Object[] arr_object = this.zzc;
        Object object1 = arr_object[v];
        arr_object[v] = object0;
        ++this.modCount;
        return object1;
    }

    @Override
    public final int size() {
        return this.zzd;
    }

    public static zznu zzd() {
        return zznu.zzb;
    }

    public final void zze(int v) {
        int v1 = this.zzc.length;
        if(v <= v1) {
            return;
        }
        if(v1 != 0) {
            while(v1 < v) {
                v1 = zznu.zzf(v1);
            }
            this.zzc = Arrays.copyOf(this.zzc, v1);
            return;
        }
        this.zzc = new Object[Math.max(v, 10)];
    }

    private static int zzf(int v) {
        return Z.c(v, 3, 2, 1, 10);
    }

    @Override  // com.google.android.gms.internal.measurement.zzmn
    public final zzmn zzg(int v) {
        if(v < this.zzd) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new zznu(zznu.zza, this.zzd, true) : new zznu(Arrays.copyOf(this.zzc, v), this.zzd, true);
    }

    private final void zzh(int v) {
        if(v < 0 || v >= this.zzd) {
            throw new IndexOutOfBoundsException(this.zzi(v));
        }
    }

    private final String zzi(int v) {
        return "Index:" + v + ", Size:" + this.zzd;
    }
}

