package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class zzmf extends zzkt implements zzml, zzns, RandomAccess {
    private static final int[] zza;
    private static final zzmf zzb;
    private int[] zzc;
    private int zzd;

    static {
        int[] arr_v = new int[0];
        zzmf.zza = arr_v;
        zzmf.zzb = new zzmf(arr_v, 0, false);
    }

    public zzmf() {
        this(zzmf.zza, 0, true);
    }

    private zzmf(int[] arr_v, int v, boolean z) {
        super(z);
        this.zzc = arr_v;
        this.zzd = v;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final void add(int v, Object object0) {
        int v1 = (int)(((Integer)object0));
        this.zzcF();
        if(v >= 0) {
            int v2 = this.zzd;
            if(v <= v2) {
                int[] arr_v = this.zzc;
                if(v2 < arr_v.length) {
                    System.arraycopy(arr_v, v, arr_v, v + 1, v2 - v);
                }
                else {
                    int[] arr_v1 = new int[zzmf.zzj(arr_v.length)];
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
        throw new IndexOutOfBoundsException(this.zzl(v));
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final boolean add(Object object0) {
        this.zzh(((int)(((Integer)object0))));
        return true;
    }

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final boolean addAll(Collection collection0) {
        this.zzcF();
        collection0.getClass();
        if(!(collection0 instanceof zzmf)) {
            return super.addAll(collection0);
        }
        int v = ((zzmf)collection0).zzd;
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
        System.arraycopy(((zzmf)collection0).zzc, 0, this.zzc, this.zzd, ((zzmf)collection0).zzd);
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
        if(!(object0 instanceof zzmf)) {
            return super.equals(object0);
        }
        if(this.zzd != ((zzmf)object0).zzd) {
            return false;
        }
        int[] arr_v = ((zzmf)object0).zzc;
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

    @Override  // com.google.android.gms.internal.measurement.zzkt
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

    @Override  // com.google.android.gms.internal.measurement.zzkt
    public final Object remove(int v) {
        this.zzcF();
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

    public static zzmf zzd() {
        return zzmf.zzb;
    }

    @Override  // com.google.android.gms.internal.measurement.zzml
    public final zzml zze(int v) {
        if(v < this.zzd) {
            throw new IllegalArgumentException();
        }
        return v == 0 ? new zzmf(zzmf.zza, this.zzd, true) : new zzmf(Arrays.copyOf(this.zzc, v), this.zzd, true);
    }

    public final int zzf(int v) {
        this.zzk(v);
        return this.zzc[v];
    }

    @Override  // com.google.android.gms.internal.measurement.zzml, com.google.android.gms.internal.measurement.zzmn
    public final zzmn zzg(int v) {
        return this.zze(v);
    }

    public final void zzh(int v) {
        this.zzcF();
        int v1 = this.zzc.length;
        if(this.zzd == v1) {
            int[] arr_v = new int[zzmf.zzj(v1)];
            System.arraycopy(this.zzc, 0, arr_v, 0, this.zzd);
            this.zzc = arr_v;
        }
        int v2 = this.zzd;
        this.zzd = v2 + 1;
        this.zzc[v2] = v;
    }

    public final void zzi(int v) {
        int v1 = this.zzc.length;
        if(v <= v1) {
            return;
        }
        if(v1 != 0) {
            while(v1 < v) {
                v1 = zzmf.zzj(v1);
            }
            this.zzc = Arrays.copyOf(this.zzc, v1);
            return;
        }
        this.zzc = new int[Math.max(v, 10)];
    }

    private static int zzj(int v) {
        return Z.c(v, 3, 2, 1, 10);
    }

    private final void zzk(int v) {
        if(v < 0 || v >= this.zzd) {
            throw new IndexOutOfBoundsException(this.zzl(v));
        }
    }

    private final String zzl(int v) {
        return "Index:" + v + ", Size:" + this.zzd;
    }
}

