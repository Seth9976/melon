package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzln extends zzkt implements zzmh, zzns, RandomAccess {
    private static final double[] zza;
    private double[] zzb;
    private int zzc;

    static {
        double[] arr_f = new double[0];
        zzln.zza = arr_f;
        new zzln(arr_f, 0, false);
    }

    public zzln() {
        this(zzln.zza, 0, true);
    }

    private zzln(double[] arr_f, int v, boolean z) {
        super(z);
        this.zzb = arr_f;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final void add(int v, Object object0) {
        double f = (double)(((Double)object0));
        this.zzcF();
        if(v >= 0) {
            int v1 = this.zzc;
            if(v <= v1) {
                double[] arr_f = this.zzb;
                if(v1 < arr_f.length) {
                    System.arraycopy(arr_f, v, arr_f, v + 1, v1 - v);
                }
                else {
                    double[] arr_f1 = new double[zzln.zzi(arr_f.length)];
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
        throw new IndexOutOfBoundsException(this.zzk(v));
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final boolean add(Object object0) {
        this.zzf(((double)(((Double)object0))));
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final boolean addAll(Collection collection0) {
        this.zzcF();
        collection0.getClass();
        if(!(collection0 instanceof zzln)) {
            return super.addAll(collection0);
        }
        int v = ((zzln)collection0).zzc;
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
        System.arraycopy(((zzln)collection0).zzb, 0, this.zzb, this.zzc, ((zzln)collection0).zzc);
        this.zzc = v2;
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
        if(!(object0 instanceof zzln)) {
            return super.equals(object0);
        }
        if(this.zzc != ((zzln)object0).zzc) {
            return false;
        }
        double[] arr_f = ((zzln)object0).zzb;
        for(int v = 0; v < this.zzc; ++v) {
            if(Double.doubleToLongBits(this.zzb[v]) != Double.doubleToLongBits(arr_f[v])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzj(v);
        return (double)this.zzb[v];
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
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

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final Object remove(int v) {
        this.zzcF();
        this.zzj(v);
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
        this.zzcF();
        if(v1 < v) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        System.arraycopy(this.zzb, v1, this.zzb, v, this.zzc - v1);
        this.zzc -= v1 - v;
        ++this.modCount;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final Object set(int v, Object object0) {
        this.zzcF();
        this.zzj(v);
        double[] arr_f = this.zzb;
        double f = arr_f[v];
        arr_f[v] = (double)(((Double)object0));
        return f;
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.measurement.zzmh
    public final zzmh zzd(int v) {
        if(v < this.zzc) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new zzln(zzln.zza, this.zzc, true) : new zzln(Arrays.copyOf(this.zzb, v), this.zzc, true);
    }

    public final double zze(int v) {
        this.zzj(v);
        return this.zzb[v];
    }

    public final void zzf(double f) {
        this.zzcF();
        int v = this.zzb.length;
        if(this.zzc == v) {
            double[] arr_f = new double[zzln.zzi(v)];
            System.arraycopy(this.zzb, 0, arr_f, 0, this.zzc);
            this.zzb = arr_f;
        }
        int v1 = this.zzc;
        this.zzc = v1 + 1;
        this.zzb[v1] = f;
    }

    @Override  // com.google.android.gms.internal.measurement.zzmh, com.google.android.gms.internal.measurement.zzmn
    public final zzmn zzg(int v) {
        return this.zzd(v);
    }

    public final void zzh(int v) {
        int v1 = this.zzb.length;
        if(v <= v1) {
            return;
        }
        if(v1 != 0) {
            while(v1 < v) {
                v1 = zzln.zzi(v1);
            }
            this.zzb = Arrays.copyOf(this.zzb, v1);
            return;
        }
        this.zzb = new double[Math.max(v, 10)];
    }

    private static int zzi(int v) {
        return Z.c(v, 3, 2, 1, 10);
    }

    private final void zzj(int v) {
        if(v < 0 || v >= this.zzc) {
            throw new IndexOutOfBoundsException(this.zzk(v));
        }
    }

    private final String zzk(int v) {
        return "Index:" + v + ", Size:" + this.zzc;
    }
}

