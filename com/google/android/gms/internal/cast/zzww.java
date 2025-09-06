package com.google.android.gms.internal.cast;

import b3.Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzww extends zzwc implements zzxn, RandomAccess {
    private static final double[] zza;
    private double[] zzb;
    private int zzc;

    static {
        double[] arr_f = new double[0];
        zzww.zza = arr_f;
        new zzww(arr_f, 0, false);
    }

    public zzww() {
        this(zzww.zza, 0, true);
    }

    private zzww(double[] arr_f, int v, boolean z) {
        super(z);
        this.zzb = arr_f;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final void add(int v, Object object0) {
        double f = (double)(((Double)object0));
        this.zza();
        if(v >= 0) {
            int v1 = this.zzc;
            if(v <= v1) {
                double[] arr_f = this.zzb;
                if(v1 < arr_f.length) {
                    System.arraycopy(arr_f, v, arr_f, v + 1, v1 - v);
                }
                else {
                    double[] arr_f1 = new double[zzww.zzf(arr_f.length)];
                    System.arraycopy(this.zzb, 0, arr_f1, 0, v);
                    System.arraycopy(this.zzb, v, arr_f1, v + 1, this.zzc - v);
                    this.zzb = arr_f1;
                }
                this.zzb[v] = f;
                ++this.zzc;
                ++this.modCount;
                return;
            }
        }
        throw new IndexOutOfBoundsException(this.zzg(v));
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final boolean add(Object object0) {
        double f = (double)(((Double)object0));
        this.zza();
        int v = this.zzb.length;
        if(this.zzc == v) {
            double[] arr_f = new double[zzww.zzf(v)];
            System.arraycopy(this.zzb, 0, arr_f, 0, this.zzc);
            this.zzb = arr_f;
        }
        int v1 = this.zzc;
        this.zzc = v1 + 1;
        this.zzb[v1] = f;
        return true;
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final boolean addAll(Collection collection0) {
        this.zza();
        collection0.getClass();
        if(!(collection0 instanceof zzww)) {
            return super.addAll(collection0);
        }
        int v = ((zzww)collection0).zzc;
        if(v == 0) {
            return false;
        }
        int v1 = this.zzc;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        double[] arr_f = this.zzb;
        if(v2 > arr_f.length) {
            this.zzb = Arrays.copyOf(arr_f, v2);
        }
        System.arraycopy(((zzww)collection0).zzb, 0, this.zzb, this.zzc, ((zzww)collection0).zzc);
        this.zzc = v2;
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
        if(!(object0 instanceof zzww)) {
            return super.equals(object0);
        }
        if(this.zzc != ((zzww)object0).zzc) {
            return false;
        }
        double[] arr_f = ((zzww)object0).zzb;
        for(int v = 0; v < this.zzc; ++v) {
            if(Double.doubleToLongBits(this.zzb[v]) != Double.doubleToLongBits(arr_f[v])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzh(v);
        return (double)this.zzb[v];
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final int hashCode() {
        int v1 = 1;
        for(int v = 0; v < this.zzc; ++v) {
            long v2 = Double.doubleToLongBits(this.zzb[v]);
            v1 = v1 * 0x1F + ((int)(v2 ^ v2 >>> 0x20));
        }
        return v1;
    }

    @Override
    public final int indexOf(Object object0) {
        if(!(object0 instanceof Double)) {
            return -1;
        }
        double f = (double)(((Double)object0));
        int v = this.zzc;
        for(int v1 = 0; v1 < v; ++v1) {
            if(this.zzb[v1] == f) {
                return v1;
            }
        }
        return -1;
    }

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final Object remove(int v) {
        this.zza();
        this.zzh(v);
        double[] arr_f = this.zzb;
        double f = arr_f[v];
        int v1 = this.zzc;
        if(v < v1 - 1) {
            System.arraycopy(arr_f, v + 1, arr_f, v, v1 - v - 1);
        }
        --this.zzc;
        ++this.modCount;
        return f;
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

    @Override  // com.google.android.gms.internal.cast.zzwc
    public final Object set(int v, Object object0) {
        this.zza();
        this.zzh(v);
        double[] arr_f = this.zzb;
        double f = arr_f[v];
        arr_f[v] = (double)(((Double)object0));
        return f;
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.cast.zzxn
    public final zzxn zzd(int v) {
        if(v < this.zzc) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new zzww(zzww.zza, this.zzc, true) : new zzww(Arrays.copyOf(this.zzb, v), this.zzc, true);
    }

    public final double zze(int v) {
        this.zzh(v);
        return this.zzb[v];
    }

    private static int zzf(int v) {
        return Z.c(v, 3, 2, 1, 10);
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

