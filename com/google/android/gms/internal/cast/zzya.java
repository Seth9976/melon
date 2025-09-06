package com.google.android.gms.internal.cast;

import b3.Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzya extends zzwc implements zzxm, RandomAccess {
    private static final long[] zza;
    private static final zzya zzb;
    private long[] zzc;
    private int zzd;

    static {
        long[] arr_v = new long[0];
        zzya.zza = arr_v;
        zzya.zzb = new zzya(arr_v, 0, false);
    }

    public zzya() {
        this(zzya.zza, 0, true);
    }

    private zzya(long[] arr_v, int v, boolean z) {
        super(z);
        this.zzc = arr_v;
        this.zzd = v;
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final void add(int v, Object object0) {
        long v1 = (long)(((Long)object0));
        this.zza();
        if(v >= 0) {
            int v2 = this.zzd;
            if(v <= v2) {
                long[] arr_v = this.zzc;
                if(v2 < arr_v.length) {
                    System.arraycopy(arr_v, v, arr_v, v + 1, v2 - v);
                }
                else {
                    long[] arr_v1 = new long[zzya.zzg(arr_v.length)];
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
        throw new IndexOutOfBoundsException(this.zzh(v));
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final boolean add(Object object0) {
        long v = (long)(((Long)object0));
        this.zza();
        int v1 = this.zzc.length;
        if(this.zzd == v1) {
            long[] arr_v = new long[zzya.zzg(v1)];
            System.arraycopy(this.zzc, 0, arr_v, 0, this.zzd);
            this.zzc = arr_v;
        }
        int v2 = this.zzd;
        this.zzd = v2 + 1;
        this.zzc[v2] = v;
        return true;
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final boolean addAll(Collection collection0) {
        this.zza();
        collection0.getClass();
        if(!(collection0 instanceof zzya)) {
            return super.addAll(collection0);
        }
        int v = ((zzya)collection0).zzd;
        if(v == 0) {
            return false;
        }
        int v1 = this.zzd;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        long[] arr_v = this.zzc;
        if(v2 > arr_v.length) {
            this.zzc = Arrays.copyOf(arr_v, v2);
        }
        System.arraycopy(((zzya)collection0).zzc, 0, this.zzc, this.zzd, ((zzya)collection0).zzd);
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
        if(!(object0 instanceof zzya)) {
            return super.equals(object0);
        }
        if(this.zzd != ((zzya)object0).zzd) {
            return false;
        }
        long[] arr_v = ((zzya)object0).zzc;
        for(int v = 0; v < this.zzd; ++v) {
            if(this.zzc[v] != arr_v[v]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzi(v);
        return (long)this.zzc[v];
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final int hashCode() {
        int v1 = 1;
        for(int v = 0; v < this.zzd; ++v) {
            long v2 = this.zzc[v];
            v1 = v1 * 0x1F + ((int)(v2 ^ v2 >>> 0x20));
        }
        return v1;
    }

    @Override
    public final int indexOf(Object object0) {
        if(!(object0 instanceof Long)) {
            return -1;
        }
        long v = (long)(((Long)object0));
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
        this.zzi(v);
        long[] arr_v = this.zzc;
        long v1 = arr_v[v];
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
        this.zzi(v);
        long[] arr_v = this.zzc;
        long v1 = arr_v[v];
        arr_v[v] = (long)(((Long)object0));
        return v1;
    }

    @Override
    public final int size() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.internal.cast.zzxn
    public final zzxn zzd(int v) {
        if(v < this.zzd) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new zzya(zzya.zza, this.zzd, true) : new zzya(Arrays.copyOf(this.zzc, v), this.zzd, true);
    }

    public final long zze(int v) {
        this.zzi(v);
        return this.zzc[v];
    }

    public static zzya zzf() {
        return zzya.zzb;
    }

    private static int zzg(int v) {
        return Z.c(v, 3, 2, 1, 10);
    }

    private final String zzh(int v) {
        return "Index:" + v + ", Size:" + this.zzd;
    }

    private final void zzi(int v) {
        if(v < 0 || v >= this.zzd) {
            throw new IndexOutOfBoundsException(this.zzh(v));
        }
    }
}

