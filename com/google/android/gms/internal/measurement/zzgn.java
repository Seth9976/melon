package com.google.android.gms.internal.measurement;

public final class zzgn extends zzme implements zznm {
    private zzmn zzb;
    private static final zzgn zzd;

    static {
        zzgn zzgn0 = new zzgn();
        zzgn.zzd = zzgn0;
        zzme.zzcp(zzgn.class, zzgn0);
    }

    private zzgn() {
        this.zzb = zzme.zzcv();
    }

    public static zzgn zza() {
        return zzgn.zzd;
    }

    @Override  // com.google.android.gms.internal.measurement.zzme
    public final Object zzl(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzme.zzcq(zzgn.zzd, "\u0004\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001A", new Object[]{"zzb"});
            }
            case 3: {
                return new zzgn();
            }
            case 4: {
                return new zzgm(null);
            }
            case 5: {
                return zzgn.zzd;
            }
            default: {
                throw null;
            }
        }
    }
}

