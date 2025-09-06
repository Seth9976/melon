package com.google.android.gms.internal.measurement;

import b3.Z;
import java.util.Arrays;

public final class zzoi {
    private static final zzoi zza;
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    static {
        zzoi.zza = new zzoi(0, new int[0], new Object[0], false);
    }

    private zzoi() {
        this(0, new int[8], new Object[8], true);
    }

    private zzoi(int v, int[] arr_v, Object[] arr_object, boolean z) {
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
        if(!(object0 instanceof zzoi)) {
            return false;
        }
        int v = this.zzb;
        if(v == ((zzoi)object0).zzb) {
            int[] arr_v = this.zzc;
            int[] arr_v1 = ((zzoi)object0).zzc;
            for(int v1 = 0; v1 < v; ++v1) {
                if(arr_v[v1] != arr_v1[v1]) {
                    return false;
                }
            }
            Object[] arr_object = this.zzd;
            Object[] arr_object1 = ((zzoi)object0).zzd;
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

    public static zzoi zza() {
        return zzoi.zza;
    }

    public static zzoi zzb() {
        return new zzoi(0, new int[8], new Object[8], true);
    }

    public static zzoi zzc(zzoi zzoi0, zzoi zzoi1) {
        int v = zzoi0.zzb + zzoi1.zzb;
        int[] arr_v = Arrays.copyOf(zzoi0.zzc, v);
        System.arraycopy(zzoi1.zzc, 0, arr_v, zzoi0.zzb, zzoi1.zzb);
        Object[] arr_object = Arrays.copyOf(zzoi0.zzd, v);
        System.arraycopy(zzoi1.zzd, 0, arr_object, zzoi0.zzb, zzoi1.zzb);
        return new zzoi(v, arr_v, arr_object, true);
    }

    public final void zzd() {
        if(this.zzf) {
            this.zzf = false;
        }
    }

    public final void zze() {
        if(!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final void zzf(zzou zzou0) {
        for(int v = 0; v < this.zzb; ++v) {
            zzou0.zzv(this.zzc[v] >>> 3, this.zzd[v]);
        }
    }

    public final void zzg(zzou zzou0) {
        if(this.zzb != 0) {
            for(int v = 0; v < this.zzb; ++v) {
                int v1 = this.zzc[v];
                Object object0 = this.zzd[v];
                int v2 = v1 & 7;
                int v3 = v1 >>> 3;
                switch(v2) {
                    case 0: {
                        zzou0.zzc(v3, ((long)(((Long)object0))));
                        break;
                    }
                    case 1: {
                        zzou0.zzj(v3, ((long)(((Long)object0))));
                        break;
                    }
                    case 2: {
                        zzou0.zzn(v3, ((zzlg)object0));
                        break;
                    }
                    case 3: {
                        zzou0.zzt(v3);
                        ((zzoi)object0).zzg(zzou0);
                        zzou0.zzu(v3);
                        break;
                    }
                    default: {
                        if(v2 != 5) {
                            throw new RuntimeException(new zzmp("Protocol message tag had invalid wire type."));
                        }
                        zzou0.zzk(v3, ((int)(((Integer)object0))));
                        break;
                    }
                }
            }
        }
    }

    public final int zzh() {
        int v = this.zze;
        if(v == -1) {
            int v2 = 0;
            for(int v1 = 0; v1 < this.zzb; ++v1) {
                int v3 = zzll.zzz(this.zzc[v1] >>> 3);
                int v4 = ((zzlg)this.zzd[v1]).zzc();
                v2 = Z.B(v4, v4, 1) + v2 + v3 + 3;
            }
            this.zze = v2;
            return v2;
        }
        return v;
    }

    public final int zzi() {
        int v = this.zze;
        if(v == -1) {
            int v2 = 0;
            for(int v1 = 0; v1 < this.zzb; ++v1) {
                int v3 = this.zzc[v1];
                int v4 = v3 >>> 3;
                switch(v3 & 7) {
                    case 0: {
                        v2 = zzll.zzA(((long)(((Long)this.zzd[v1])))) + zzll.zzz(v4 << 3) + v2;
                        break;
                    }
                    case 1: {
                        ((Long)this.zzd[v1]).getClass();
                        v2 = zzll.zzz(v4 << 3) + 8 + v2;
                        break;
                    }
                    case 2: {
                        int v6 = ((zzlg)this.zzd[v1]).zzc();
                        v2 = zzll.zzz(v6) + v6 + zzll.zzz(v4 << 3) + v2;
                        break;
                    }
                    case 3: {
                        int v5 = zzll.zzz(v4 << 3);
                        v2 = ((zzoi)this.zzd[v1]).zzi() + (v5 + v5) + v2;
                        break;
                    }
                    case 5: {
                        ((Integer)this.zzd[v1]).getClass();
                        v2 = zzll.zzz(v4 << 3) + 4 + v2;
                        break;
                    }
                    default: {
                        throw new IllegalStateException(new zzmp("Protocol message tag had invalid wire type."));
                    }
                }
            }
            this.zze = v2;
            return v2;
        }
        return v;
    }

    public final void zzj(StringBuilder stringBuilder0, int v) {
        for(int v1 = 0; v1 < this.zzb; ++v1) {
            zznn.zzb(stringBuilder0, v, String.valueOf(this.zzc[v1] >>> 3), this.zzd[v1]);
        }
    }

    public final void zzk(int v, Object object0) {
        this.zze();
        this.zzm(this.zzb + 1);
        int v1 = this.zzb;
        this.zzc[v1] = v;
        this.zzd[v1] = object0;
        this.zzb = v1 + 1;
    }

    public final zzoi zzl(zzoi zzoi0) {
        if(zzoi0.equals(zzoi.zza)) {
            return this;
        }
        this.zze();
        int v = this.zzb + zzoi0.zzb;
        this.zzm(v);
        System.arraycopy(zzoi0.zzc, 0, this.zzc, this.zzb, zzoi0.zzb);
        System.arraycopy(zzoi0.zzd, 0, this.zzd, this.zzb, zzoi0.zzb);
        this.zzb = v;
        return this;
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

