package com.google.android.gms.internal.measurement;

import java.util.List;

public final class zzho extends zzme implements zznm {
    private zzmn zzb;
    private static final zzho zzd;

    static {
        zzho zzho0 = new zzho();
        zzho.zzd = zzho0;
        zzme.zzcp(zzho.class, zzho0);
    }

    private zzho() {
        this.zzb = zzme.zzcv();
    }

    public final List zza() {
        return this.zzb;
    }

    public static zzhh zzb() {
        return (zzhh)zzho.zzd.zzck();
    }

    public static zzho zzc() {
        return zzho.zzd;
    }

    public final void zzd(Iterable iterable0) {
        zzmn zzmn0 = this.zzb;
        if(!zzmn0.zza()) {
            this.zzb = zzme.zzcw(zzmn0);
        }
        zzkr.zzce(iterable0, this.zzb);
    }

    public static zzho zze() {
        return zzho.zzd;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzho.zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001B", new Object[]{"zzb", zzhl.class});
            }
            case 3: {
                return new zzho();
            }
            case 4: {
                return new zzhh(null);
            }
            case 5: {
                return zzho.zzd;
            }
            default: {
                throw null;
            }
        }
    }
}

