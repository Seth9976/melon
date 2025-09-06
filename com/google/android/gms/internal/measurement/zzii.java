package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzii extends zzme implements zznm {
    private zzmm zzb;
    private zzmm zzd;
    private zzmn zze;
    private zzmn zzf;
    private static final zzii zzg;

    static {
        zzii zzii0 = new zzii();
        zzii.zzg = zzii0;
        zzme.zzcp(zzii.class, zzii0);
    }

    private zzii() {
        this.zzb = zzme.zzct();
        this.zzd = zzme.zzct();
        this.zze = zzme.zzcv();
        this.zzf = zzme.zzcv();
    }

    public final List zza() {
        return this.zzb;
    }

    public final int zzb() {
        return this.zzb.size();
    }

    public final List zzc() {
        return this.zzd;
    }

    public final int zzd() {
        return this.zzd.size();
    }

    public final List zze() {
        return this.zze;
    }

    public final int zzf() {
        return this.zze.size();
    }

    public final List zzg() {
        return this.zzf;
    }

    public final int zzh() {
        return this.zzf.size();
    }

    public static zzih zzi() {
        return (zzih)zzii.zzg.zzck();
    }

    public static zzii zzj() {
        return zzii.zzg;
    }

    public final void zzk(Iterable iterable0) {
        zzmm zzmm0 = this.zzb;
        if(!zzmm0.zza()) {
            this.zzb = zzme.zzcu(zzmm0);
        }
        zzkr.zzce(iterable0, this.zzb);
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzii.zzg, "\u0004\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001B\u0004\u001B", new Object[]{"zzb", "zzd", "zze", zzhq.class, "zzf", zzik.class});
            }
            case 3: {
                return new zzii();
            }
            case 4: {
                return new zzih(null);
            }
            case 5: {
                return zzii.zzg;
            }
            default: {
                throw null;
            }
        }
    }

    public final void zzm() {
        this.zzb = zzme.zzct();
    }

    public final void zzn(Iterable iterable0) {
        zzmm zzmm0 = this.zzd;
        if(!zzmm0.zza()) {
            this.zzd = zzme.zzcu(zzmm0);
        }
        zzkr.zzce(iterable0, this.zzd);
    }

    public final void zzo() {
        this.zzd = zzme.zzct();
    }

    public final void zzp(Iterable iterable0) {
        zzmn zzmn0 = this.zze;
        if(!zzmn0.zza()) {
            this.zze = zzme.zzcw(zzmn0);
        }
        zzkr.zzce(iterable0, this.zze);
    }

    public final void zzq() {
        this.zze = zzme.zzcv();
    }

    public final void zzr(Iterable iterable0) {
        zzmn zzmn0 = this.zzf;
        if(!zzmn0.zza()) {
            this.zzf = zzme.zzcw(zzmn0);
        }
        zzkr.zzce(iterable0, this.zzf);
    }

    public final void zzs() {
        this.zzf = zzme.zzcv();
    }

    public static zzii zzt() {
        return zzii.zzg;
    }
}

