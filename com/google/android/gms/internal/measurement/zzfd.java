package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzfd extends zzme implements zznm {
    private int zzb;
    private int zzd;
    private zzmn zze;
    private zzmn zzf;
    private boolean zzg;
    private boolean zzh;
    private static final zzfd zzi;

    static {
        zzfd zzfd0 = new zzfd();
        zzfd.zzi = zzfd0;
        zzme.zzcp(zzfd.class, zzfd0);
    }

    private zzfd() {
        this.zze = zzme.zzcv();
        this.zzf = zzme.zzcv();
    }

    public final boolean zza() {
        return (this.zzb & 1) != 0;
    }

    public final int zzb() {
        return this.zzd;
    }

    public final List zzc() {
        return this.zze;
    }

    public final int zzd() {
        return this.zze.size();
    }

    public final zzfn zze(int v) {
        return (zzfn)this.zze.get(v);
    }

    public final List zzf() {
        return this.zzf;
    }

    public final int zzg() {
        return this.zzf.size();
    }

    public final zzff zzh(int v) {
        return (zzff)this.zzf.get(v);
    }

    public final void zzi(int v, zzfn zzfn0) {
        zzfn0.getClass();
        zzmn zzmn0 = this.zze;
        if(!zzmn0.zza()) {
            this.zze = zzme.zzcw(zzmn0);
        }
        this.zze.set(v, zzfn0);
    }

    public final void zzj(int v, zzff zzff0) {
        zzff0.getClass();
        zzmn zzmn0 = this.zzf;
        if(!zzmn0.zza()) {
            this.zzf = zzme.zzcw(zzmn0);
        }
        this.zzf.set(v, zzff0);
    }

    public static zzfd zzk() {
        return zzfd.zzi;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzfd.zzi, "\u0004\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001B\u0003\u001B\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zzb", "zzd", "zze", zzfn.class, "zzf", zzff.class, "zzg", "zzh"});
            }
            case 3: {
                return new zzfd();
            }
            case 4: {
                return new zzfc(null);
            }
            case 5: {
                return zzfd.zzi;
            }
            default: {
                throw null;
            }
        }
    }
}

