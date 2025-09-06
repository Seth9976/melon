package com.google.android.gms.internal.cast;

import b3.Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzxj extends zzwc implements zzxl, RandomAccess {
    private static final int[] zza;
    private static final zzxj zzb;
    private int[] zzc;
    private int zzd;

    static {
        int[] arr_v = new int[0];
        zzxj.zza = arr_v;
        zzxj.zzb = new zzxj(arr_v, 0, false);
    }

    public zzxj() {
        this(zzxj.zza, 0, true);
    }

    private zzxj(int[] arr_v, int v, boolean z) {
        super(z);
        this.zzc = arr_v;
        this.zzd = v;
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final void add(int v, Object object0) {
        int v1 = (int)(((Integer)object0));
        this.zza();
        if(v >= 0) {
            int v2 = this.zzd;
            if(v <= v2) {
                int[] arr_v = this.zzc;
                if(v2 < arr_v.length) {
                    System.arraycopy(arr_v, v, arr_v, v + 1, v2 - v);
                }
                else {
                    int[] arr_v1 = new int[zzxj.zzi(arr_v.length)];
                    System.arraycopy(this.zzc, 0, arr_v1, 0, v);
                    System.arraycopy(this.zzc, v, arr_v1, v + 1, this.zzd - v);
                    this.zzc = arr_v1;
                }
                this.zzc[v] = v1;
                ++this.zzd;
                ++this.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.zzj(v));
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final boolean add(Object object0) {
        this.zzh(((int)(((Integer)object0))));
        return true;
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final boolean addAll(Collection collection0) {
        this.zza();
        collection0.getClass();
        if(!(collection0 instanceof zzxj)) {
            return super.addAll(collection0);
        }
        int v = ((zzxj)collection0).zzd;
        if(v == 0) {
            return false;
        }
        int v1 = this.zzd;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        int[] arr_v = this.zzc;
        if(v2 > arr_v.length) {
            this.zzc = Arrays.copyOf(arr_v, v2);
        }
        System.arraycopy(((zzxj)collection0).zzc, 0, this.zzc, this.zzd, ((zzxj)collection0).zzd);
        this.zzd = v2;
        ++this.modCount;
        return true;
    }

    @Override
    public final boolean contains(Object object0) {
        return this.indexOf(object0) != -1;
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzxj)) {
            return super.equals(object0);
        }
        if(this.zzd != ((zzxj)object0).zzd) {
            return false;
        }
        int[] arr_v = ((zzxj)object0).zzc;
        for(int v = 0; v < this.zzd; ++v) {
            if(this.zzc[v] != arr_v[v]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzk(v);
        return (int)this.zzc[v];
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final int hashCode() {
        int v1 = 1;
        for(int v = 0; v < this.zzd; ++v) {
            v1 = v1 * 0x1F + this.zzc[v];
        }
        return v1;
    }

    @Override
    public final int indexOf(Object object0) {
        if(!(object0 instanceof Integer)) {
            return -1;
        }
        int v = (int)(((Integer)object0));
        int v1 = this.zzd;
        for(int v2 = 0; v2 < v1; ++v2) {
            if(this.zzc[v2] == v) {
                return v2;
            }
        }
        return -1;
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final Object remove(int v) {
        this.zza();
        this.zzk(v);
        int[] arr_v = this.zzc;
        int v1 = arr_v[v];
        int v2 = this.zzd;
        if(v < v2 - 1) {
            System.arraycopy(arr_v, v + 1, arr_v, v, v2 - v - 1);
        }
        --this.zzd;
        ++this.modCount;
        return v1;
    }

    @Override
    public final void removeRange(int v, int v1) {
        this.zza();
        if(v1 < v) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzc, v1, this.zzc, v, this.zzd - v1);
        this.zzd -= v1 - v;
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final Object set(int v, Object object0) {
        this.zza();
        this.zzk(v);
        int[] arr_v = this.zzc;
        int v1 = arr_v[v];
        arr_v[v] = (int)(((Integer)object0));
        return v1;
    }

    @Override
    public final int size() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.internal.cast.zzxn
    public final zzxn zzd(int v) {
        return this.zzg(v);
    }

    public final int zze(int v) {
        this.zzk(v);
        return this.zzc[v];
    }

    public static zzxj zzf() {
        return zzxj.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxl
    public final zzxl zzg(int v) {
        if(v < this.zzd) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new zzxj(zzxj.zza, this.zzd, true) : new zzxj(Arrays.copyOf(this.zzc, v), this.zzd, true);
    }

    @Override  // com.google.android.gms.internal.cast.zzxl
    public final void zzh(int v) {
        this.zza();
        int v1 = this.zzc.length;
        if(this.zzd == v1) {
            int[] arr_v = new int[zzxj.zzi(v1)];
            System.arraycopy(this.zzc, 0, arr_v, 0, this.zzd);
            this.zzc = arr_v;
        }
        int v2 = this.zzd;
        this.zzd = v2 + 1;
        this.zzc[v2] = v;
    }

    private static int zzi(int v) {
        return Z.c(v, 3, 2, 1, 10);
    }

    private final String zzj(int v) {
        return "Index:" + v + ", Size:" + this.zzd;
    }

    private final void zzk(int v) {
        if(v < 0 || v >= this.zzd) {
            throw new IndexOutOfBoundsException(this.zzj(v));
        }
    }
}

