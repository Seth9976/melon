package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzmz extends zzkt implements zzmm, zzns, RandomAccess {
    private static final long[] zza;
    private static final zzmz zzb;
    private long[] zzc;
    private int zzd;

    static {
        long[] arr_v = new long[0];
        zzmz.zza = arr_v;
        zzmz.zzb = new zzmz(arr_v, 0, false);
    }

    public zzmz() {
        this(zzmz.zza, 0, true);
    }

    private zzmz(long[] arr_v, int v, boolean z) {
        super(z);
        this.zzc = arr_v;
        this.zzd = v;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final void add(int v, Object object0) {
        long v1 = (long)(((Long)object0));
        this.zzcF();
        if(v >= 0) {
            int v2 = this.zzd;
            if(v <= v2) {
                long[] arr_v = this.zzc;
                if(v2 < arr_v.length) {
                    System.arraycopy(arr_v, v, arr_v, v + 1, v2 - v);
                }
                else {
                    long[] arr_v1 = new long[zzmz.zzi(arr_v.length)];
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
        throw new IndexOutOfBoundsException(this.zzk(v));
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final boolean add(Object object0) {
        this.zzf(((long)(((Long)object0))));
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final boolean addAll(Collection collection0) {
        this.zzcF();
        collection0.getClass();
        if(!(collection0 instanceof zzmz)) {
            return super.addAll(collection0);
        }
        int v = ((zzmz)collection0).zzd;
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
        System.arraycopy(((zzmz)collection0).zzc, 0, this.zzc, this.zzd, ((zzmz)collection0).zzd);
        this.zzd = v2;
        ++this.modCount;
        return true;
    }

    @Override
    public final boolean contains(Object object0) {
        return this.indexOf(object0) != -1;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzmz)) {
            return super.equals(object0);
        }
        if(this.zzd != ((zzmz)object0).zzd) {
            return false;
        }
        long[] arr_v = ((zzmz)object0).zzc;
        for(int v = 0; v < this.zzd; ++v) {
            if(this.zzc[v] != arr_v[v]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzj(v);
        return (long)this.zzc[v];
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
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

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final Object remove(int v) {
        this.zzcF();
        this.zzj(v);
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
        this.zzcF();
        if(v1 < v) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzc, v1, this.zzc, v, this.zzd - v1);
        this.zzd -= v1 - v;
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final Object set(int v, Object object0) {
        this.zzcF();
        this.zzj(v);
        long[] arr_v = this.zzc;
        long v1 = arr_v[v];
        arr_v[v] = (long)(((Long)object0));
        return v1;
    }

    @Override
    public final int size() {
        return this.zzd;
    }

    @Override  // com.google.android.gms.internal.measurement.zzmm
    public final long zzc(int v) {
        this.zzj(v);
        return this.zzc[v];
    }

    @Override  // com.google.android.gms.internal.measurement.zzmm
    public final zzmm zzd(int v) {
        if(v < this.zzd) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new zzmz(zzmz.zza, this.zzd, true) : new zzmz(Arrays.copyOf(this.zzc, v), this.zzd, true);
    }

    public static zzmz zze() {
        return zzmz.zzb;
    }

    public final void zzf(long v) {
        this.zzcF();
        int v1 = this.zzc.length;
        if(this.zzd == v1) {
            long[] arr_v = new long[zzmz.zzi(v1)];
            System.arraycopy(this.zzc, 0, arr_v, 0, this.zzd);
            this.zzc = arr_v;
        }
        int v2 = this.zzd;
        this.zzd = v2 + 1;
        this.zzc[v2] = v;
    }

    @Override  // com.google.android.gms.internal.measurement.zzmm, com.google.android.gms.internal.measurement.zzmn
    public final zzmn zzg(int v) {
        return this.zzd(v);
    }

    public final void zzh(int v) {
        int v1 = this.zzc.length;
        if(v <= v1) {
            return;
        }
        if(v1 != 0) {
            while(v1 < v) {
                v1 = zzmz.zzi(v1);
            }
            this.zzc = Arrays.copyOf(this.zzc, v1);
            return;
        }
        this.zzc = new long[Math.max(v, 10)];
    }

    private static int zzi(int v) {
        return Z.c(v, 3, 2, 1, 10);
    }

    private final void zzj(int v) {
        if(v < 0 || v >= this.zzd) {
            throw new IndexOutOfBoundsException(this.zzk(v));
        }
    }

    private final String zzk(int v) {
        return "Index:" + v + ", Size:" + this.zzd;
    }
}

