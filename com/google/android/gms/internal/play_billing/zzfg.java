package com.google.android.gms.internal.play_billing;

import b3.Z;
import java.util.Arrays;

public final class zzfg {
    private static final zzfg zza;
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    static {
        zzfg.zza = new zzfg(0, new int[0], new Object[0], false);
    }

    private zzfg() {
        this(0, new int[8], new Object[8], true);
    }

    private zzfg(int v, int[] arr_v, Object[] arr_object, boolean z) {
        this.zze = -1;
        this.zzb = v;
        this.zzc = arr_v;
        this.zzd = arr_object;
        this.zzf = z;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        if(!(object0 instanceof zzfg)) {
            return false;
        }
        int v = this.zzb;
        if(v == ((zzfg)object0).zzb) {
            int[] arr_v = this.zzc;
            int[] arr_v1 = ((zzfg)object0).zzc;
            for(int v1 = 0; v1 < v; ++v1) {
                if(arr_v[v1] != arr_v1[v1]) {
                    return false;
                }
            }
            Object[] arr_object = this.zzd;
            Object[] arr_object1 = ((zzfg)object0).zzd;
            int v2 = this.zzb;
            for(int v3 = 0; v3 < v2; ++v3) {
                if(!arr_object[v3].equals(arr_object1[v3])) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public final int hashCode() {
        int v = this.zzb;
        int[] arr_v = this.zzc;
        int v2 = 17;
        int v4 = 17;
        for(int v3 = 0; v3 < v; ++v3) {
            v4 = v4 * 0x1F + arr_v[v3];
        }
        Object[] arr_object = this.zzd;
        int v5 = this.zzb;
        for(int v1 = 0; v1 < v5; ++v1) {
            v2 = v2 * 0x1F + arr_object[v1].hashCode();
        }
        return ((v + 0x20F) * 0x1F + v4) * 0x1F + v2;
    }

    public final int zza() {
        int v = this.zze;
        if(v == -1) {
            int v2 = 0;
            for(int v1 = 0; v1 < this.zzb; ++v1) {
                int v3 = this.zzc[v1];
                int v4 = v3 >>> 3;
                switch(v3 & 7) {
                    case 0: {
                        v2 = zzby.zzx(((long)(((Long)this.zzd[v1])))) + zzby.zzw(v4 << 3) + v2;
                        break;
                    }
                    case 1: {
                        ((Long)this.zzd[v1]).getClass();
                        v2 = zzby.zzw(v4 << 3) + 8 + v2;
                        break;
                    }
                    case 2: {
                        int v6 = ((zzbq)this.zzd[v1]).zzd();
                        v2 = zzby.zzw(v6) + v6 + zzby.zzw(v4 << 3) + v2;
                        break;
                    }
                    case 3: {
                        int v5 = zzby.zzw(v4 << 3);
                        v2 = ((zzfg)this.zzd[v1]).zza() + (v5 + v5) + v2;
                        break;
                    }
                    case 5: {
                        ((Integer)this.zzd[v1]).getClass();
                        v2 = zzby.zzw(v4 << 3) + 4 + v2;
                        break;
                    }
                    default: {
                        throw new IllegalStateException(zzdc.zza());
                    }
                }
            }
            this.zze = v2;
            return v2;
        }
        return v;
    }

    public final int zzb() {
        int v = this.zze;
        if(v == -1) {
            int v2 = 0;
            for(int v1 = 0; v1 < this.zzb; ++v1) {
                int v3 = zzby.zzw(this.zzc[v1] >>> 3);
                int v4 = ((zzbq)this.zzd[v1]).zzd();
                v2 = Z.C(v4, v4, 1) + v2 + v3 + 3;
            }
            this.zze = v2;
            return v2;
        }
        return v;
    }

    public static zzfg zzc() {
        return zzfg.zza;
    }

    public final zzfg zzd(zzfg zzfg0) {
        if(zzfg0.equals(zzfg.zza)) {
            return this;
        }
        this.zzg();
        int v = this.zzb + zzfg0.zzb;
        this.zzm(v);
        System.arraycopy(zzfg0.zzc, 0, this.zzc, this.zzb, zzfg0.zzb);
        System.arraycopy(zzfg0.zzd, 0, this.zzd, this.zzb, zzfg0.zzb);
        this.zzb = v;
        return this;
    }

    public static zzfg zze(zzfg zzfg0, zzfg zzfg1) {
        int v = zzfg0.zzb + zzfg1.zzb;
        int[] arr_v = Arrays.copyOf(zzfg0.zzc, v);
        System.arraycopy(zzfg1.zzc, 0, arr_v, zzfg0.zzb, zzfg1.zzb);
        Object[] arr_object = Arrays.copyOf(zzfg0.zzd, v);
        System.arraycopy(zzfg1.zzd, 0, arr_object, zzfg0.zzb, zzfg1.zzb);
        return new zzfg(v, arr_v, arr_object, true);
    }

    public static zzfg zzf() {
        return new zzfg(0, new int[8], new Object[8], true);
    }

    public final void zzg() {
        if(!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzh() {
        if(this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzi(StringBuilder stringBuilder0, int v) {
        for(int v1 = 0; v1 < this.zzb; ++v1) {
            zzee.zzb(stringBuilder0, v, String.valueOf(this.zzc[v1] >>> 3), this.zzd[v1]);
        }
    }

    public final void zzj(int v, Object object0) {
        this.zzg();
        this.zzm(this.zzb + 1);
        int v1 = this.zzb;
        this.zzc[v1] = v;
        this.zzd[v1] = object0;
        this.zzb = v1 + 1;
    }

    public final void zzk(zzfx zzfx0) {
        for(int v = 0; v < this.zzb; ++v) {
            zzfx0.zzw(this.zzc[v] >>> 3, this.zzd[v]);
        }
    }

    public final void zzl(zzfx zzfx0) {
        if(this.zzb != 0) {
            for(int v = 0; v < this.zzb; ++v) {
                int v1 = this.zzc[v];
                Object object0 = this.zzd[v];
                int v2 = v1 & 7;
                int v3 = v1 >>> 3;
                switch(v2) {
                    case 0: {
                        zzfx0.zzt(v3, ((long)(((Long)object0))));
                        break;
                    }
                    case 1: {
                        zzfx0.zzm(v3, ((long)(((Long)object0))));
                        break;
                    }
                    case 2: {
                        zzfx0.zzd(v3, ((zzbq)object0));
                        break;
                    }
                    case 3: {
                        zzfx0.zzF(v3);
                        ((zzfg)object0).zzl(zzfx0);
                        zzfx0.zzh(v3);
                        break;
                    }
                    default: {
                        if(v2 != 5) {
                            throw new RuntimeException(zzdc.zza());
                        }
                        zzfx0.zzk(v3, ((int)(((Integer)object0))));
                        break;
                    }
                }
            }
        }
    }

    private final void zzm(int v) {
        int[] arr_v = this.zzc;
        if(v > arr_v.length) {
            int v1 = this.zzb / 2 + this.zzb;
            if(v1 >= v) {
                v = v1;
            }
            if(v < 8) {
                v = 8;
            }
            this.zzc = Arrays.copyOf(arr_v, v);
            this.zzd = Arrays.copyOf(this.zzd, v);
        }
    }
}

