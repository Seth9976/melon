package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzlx extends zzkt implements zzmk, zzns, RandomAccess {
    private static final float[] zza;
    private float[] zzb;
    private int zzc;

    static {
        float[] arr_f = new float[0];
        zzlx.zza = arr_f;
        new zzlx(arr_f, 0, false);
    }

    public zzlx() {
        this(zzlx.zza, 0, true);
    }

    private zzlx(float[] arr_f, int v, boolean z) {
        super(z);
        this.zzb = arr_f;
        this.zzc = v;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final void add(int v, Object object0) {
        float f = (float)(((Float)object0));
        this.zzcF();
        if(v >= 0) {
            int v1 = this.zzc;
            if(v <= v1) {
                float[] arr_f = this.zzb;
                if(v1 < arr_f.length) {
                    System.arraycopy(arr_f, v, arr_f, v + 1, v1 - v);
                }
                else {
                    float[] arr_f1 = new float[zzlx.zzi(arr_f.length)];
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
        this.zzf(((float)(((Float)object0))));
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final boolean addAll(Collection collection0) {
        this.zzcF();
        collection0.getClass();
        if(!(collection0 instanceof zzlx)) {
            return super.addAll(collection0);
        }
        int v = ((zzlx)collection0).zzc;
        if(v == 0) {
            return false;
        }
        int v1 = this.zzc;
        if(0x7FFFFFFF - v1 < v) {
            throw new OutOfMemoryError();
        }
        int v2 = v1 + v;
        float[] arr_f = this.zzb;
        if(v2 > arr_f.length) {
            this.zzb = Arrays.copyOf(arr_f, v2);
        }
        System.arraycopy(((zzlx)collection0).zzb, 0, this.zzb, this.zzc, ((zzlx)collection0).zzc);
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
        if(!(object0 instanceof zzlx)) {
            return super.equals(object0);
        }
        if(this.zzc != ((zzlx)object0).zzc) {
            return false;
        }
        float[] arr_f = ((zzlx)object0).zzb;
        for(int v = 0; v < this.zzc; ++v) {
            if(Float.floatToIntBits(this.zzb[v]) != Float.floatToIntBits(arr_f[v])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public final Object get(int v) {
        this.zzj(v);
        return (float)this.zzb[v];
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final int hashCode() {
        int v1 = 1;
        for(int v = 0; v < this.zzc; ++v) {
            v1 = v1 * 0x1F + Float.floatToIntBits(this.zzb[v]);
        }
        return v1;
    }

    @Override
    public final int indexOf(Object object0) {
        if(!(object0 instanceof Float)) {
            return -1;
        }
        float f = (float)(((Float)object0));
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
        float[] arr_f = this.zzb;
        float f = arr_f[v];
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
        float[] arr_f = this.zzb;
        float f = arr_f[v];
        arr_f[v] = (float)(((Float)object0));
        return f;
    }

    @Override
    public final int size() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.internal.measurement.zzmk
    public final zzmk zzd(int v) {
        if(v < this.zzc) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new zzlx(zzlx.zza, this.zzc, true) : new zzlx(Arrays.copyOf(this.zzb, v), this.zzc, true);
    }

    public final float zze(int v) {
        this.zzj(v);
        return this.zzb[v];
    }

    public final void zzf(float f) {
        this.zzcF();
        int v = this.zzb.length;
        if(this.zzc == v) {
            float[] arr_f = new float[zzlx.zzi(v)];
            System.arraycopy(this.zzb, 0, arr_f, 0, this.zzc);
            this.zzb = arr_f;
        }
        int v1 = this.zzc;
        this.zzc = v1 + 1;
        this.zzb[v1] = f;
    }

    @Override  // com.google.android.gms.internal.measurement.zzmk, com.google.android.gms.internal.measurement.zzmn
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
                v1 = zzlx.zzi(v1);
            }
            this.zzb = Arrays.copyOf(this.zzb, v1);
            return;
        }
        this.zzb = new float[Math.max(v, 10)];
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

