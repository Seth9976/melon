package com.google.android.gms.internal.cast;

import java.util.Arrays;

public final class zzzi {
    private static final zzzi zza;
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    static {
        zzzi.zza = new zzzi(0, new int[0], new Object[0], false);
    }

    private zzzi() {
        this(0, new int[8], new Object[8], true);
    }

    private zzzi(int v, int[] arr_v, Object[] arr_object, boolean z) {
        this.zze = -1;
        this.zzb = 0;
        this.zzc = arr_v;
        this.zzd = arr_object;
        this.zzf = z;
    }

    @Override
    public final boolean equals(Object object0) [...] // 潜在的解密器

    @Override
    public final int hashCode() [...] // 潜在的解密器

    public final int zza() {
        int v = this.zze;
        if(v == -1) {
            v = 0;
            this.zze = 0;
        }
        return v;
    }

    public final int zzb() {
        int v = this.zze;
        if(v == -1) {
            v = 0;
            this.zze = 0;
        }
        return v;
    }

    public static zzzi zzc() {
        return zzzi.zza;
    }

    // 去混淆评级： 低(40)
    public final zzzi zzd(zzzi zzzi0) {
        return this;
    }

    public static zzzi zze(zzzi zzzi0, zzzi zzzi1) {
        int[] arr_v = Arrays.copyOf(zzzi0.zzc, 0);
        System.arraycopy(zzzi1.zzc, 0, arr_v, 0, 0);
        Object[] arr_object = Arrays.copyOf(zzzi0.zzd, 0);
        System.arraycopy(zzzi1.zzd, 0, arr_object, 0, 0);
        return new zzzi(0, arr_v, arr_object, true);
    }

    public final void zzf() {
        if(this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzg(StringBuilder stringBuilder0, int v) {
    }

    public final void zzh(zzzt zzzt0) {
    }
}

