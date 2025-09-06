package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzdr extends zzba implements zzcz, zzek, RandomAccess {
    private static final zzdr zza;
    private long[] zzb;
    private int zzc;

    static {
        zzdr.zza = new zzdr(new long[0], 0, false);
    }

    public zzdr() {
        this(new long[10], 0, true);
    }

    private zzdr(long[] arr_v, int v, boolean z) {
        super(z);
        this.zzb = arr_v;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final void add(int v, Object object0) {
        long v1 = (long)(((Long)object0));
        this.zza();
        if(v >= 0) {
            int v2 = this.zzc;
            if(v <= v2) {
                long[] arr_v = this.zzb;
                if(v2 < arr_v.length) {
                    System.arraycopy(arr_v, v, arr_v, v + 1, v2 - v);
                }
                else {
                    long[] arr_v1 = new long[v2 * 3 / 2 + 1];
                    System.arraycopy(arr_v, 0, arr_v1, 0, v);
                    System.arraycopy(this.zzb, v, arr_v1, v + 1, this.zzc - v);
                    this.zzb = arr_v1;
                }
                this.zzb[v] = v1;
                ++this.zzc;
                ++this.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.zzg(v));
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final boolean add(Object object0) {
        this.zzf(((long)(((Long)object0))));
        return true;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final boolean addAll(Collection collection0) {
        this.zza();
        collection0.getClass();
        if(!(collection0 instanceof zzdr)) {
            return super.addAll(collection0);
        }
        int v = ((zzdr)collection0).zzc;
        if(v == 0) {
            return false;
        }
        int v1 = this.zzc;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        long[] arr_v = this.zzb;
        if(v2 > arr_v.length) {
            this.zzb = Arrays.copyOf(arr_v, v2);
        }
        System.arraycopy(((zzdr)collection0).zzb, 0, this.zzb, this.zzc, ((zzdr)collection0).zzc);
        this.zzc = v2;
        ++this.modCount;
        return true;
    }

    @Override
    public final boolean contains(Object object0) {
        return this.indexOf(object0) != -1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzdr)) {
            return super.equals(object0);
        }
        if(this.zzc != ((zzdr)object0).zzc) {
            return false;
        }
        long[] arr_v = ((zzdr)object0).zzb;
        for(int v = 0; v < this.zzc; ++v) {
            if(this.zzb[v] != arr_v[v]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzh(v);
        return (long)this.zzb[v];
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final int hashCode() {
        int v1 = 1;
        for(int v = 0; v < this.zzc; ++v) {
            long v2 = this.zzb[v];
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
        int v1 = this.zzc;
        for(int v2 = 0; v2 < v1; ++v2) {
            if(this.zzb[v2] == v) {
                return v2;
            }
        }
        return -1;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final Object remove(int v) {
        this.zza();
        this.zzh(v);
        long[] arr_v = this.zzb;
        long v1 = arr_v[v];
        int v2 = this.zzc;
        if(v < v2 - 1) {
            System.arraycopy(arr_v, v + 1, arr_v, v, v2 - v - 1);
        }
        --this.zzc;
        ++this.modCount;
        return v1;
    }

    @Override
    public final void removeRange(int v, int v1) {
        this.zza();
        if(v1 < v) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzb, v1, this.zzb, v, this.zzc - v1);
        this.zzc -= v1 - v;
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzba
    public final Object set(int v, Object object0) {
        this.zza();
        this.zzh(v);
        long[] arr_v = this.zzb;
        long v1 = arr_v[v];
        arr_v[v] = (long)(((Long)object0));
        return v1;
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzcz
    public final zzcz zzd(int v) {
        if(v < this.zzc) {
            throw new IllegalArgumentException();
        }
        return new zzdr(Arrays.copyOf(this.zzb, v), this.zzc, true);
    }

    public final long zze(int v) {
        this.zzh(v);
        return this.zzb[v];
    }

    public final void zzf(long v) {
        this.zza();
        int v1 = this.zzc;
        long[] arr_v = this.zzb;
        if(v1 == arr_v.length) {
            long[] arr_v1 = new long[v1 * 3 / 2 + 1];
            System.arraycopy(arr_v, 0, arr_v1, 0, v1);
            this.zzb = arr_v1;
        }
        int v2 = this.zzc;
        this.zzc = v2 + 1;
        this.zzb[v2] = v;
    }

    private final String zzg(int v) {
        return "Index:" + v + ", Size:" + this.zzc;
    }

    private final void zzh(int v) {
        if(v < 0 || v >= this.zzc) {
            throw new IndexOutOfBoundsException(this.zzg(v));
        }
    }
}

