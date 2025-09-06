package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzgf extends zzme implements zznm {
    private int zzb;
    private zzmn zzd;
    private zzmn zze;
    private zzmn zzf;
    private boolean zzg;
    private zzmn zzh;
    private static final zzgf zzi;

    static {
        zzgf zzgf0 = new zzgf();
        zzgf.zzi = zzgf0;
        zzme.zzcp(zzgf.class, zzgf0);
    }

    private zzgf() {
        this.zzd = zzme.zzcv();
        this.zze = zzme.zzcv();
        this.zzf = zzme.zzcv();
        this.zzh = zzme.zzcv();
    }

    public final List zza() {
        return this.zzd;
    }

    public final List zzb() {
        return this.zze;
    }

    public final List zzc() {
        return this.zzf;
    }

    public final boolean zzd() {
        return (this.zzb & 1) != 0;
    }

    public final boolean zze() {
        return this.zzg;
    }

    public final List zzf() {
        return this.zzh;
    }

    public static zzgf zzg() {
        return zzgf.zzi;
    }

    public static zzgf zzh() {
        return zzgf.zzi;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzgf.zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0004\u0000\u0001\u001B\u0002\u001B\u0003\u001B\u0004ဇ\u0000\u0005\u001B", new Object[]{"zzb", "zzd", zzfu.class, "zze", zzfw.class, "zzf", zzgc.class, "zzg", "zzh", zzfu.class});
            }
            case 3: {
                return new zzgf();
            }
            case 4: {
                return new zzfs(null);
            }
            case 5: {
                return zzgf.zzi;
            }
            default: {
                throw null;
            }
        }
    }
}

