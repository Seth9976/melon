package com.google.android.gms.internal.cast;

public final class zzqs extends zzxi implements zzym {
    private static final zzqs zzb;
    private int zzd;
    private String zze;
    private long zzf;

    static {
        zzqs zzqs0 = new zzqs();
        zzqs.zzb = zzqs0;
        zzxi.zzJ(zzqs.class, zzqs0);
    }

    private zzqs() {
        this.zze = "";
    }

    public static zzqs zza() {
        return zzqs.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzqs.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
            }
            case 3: {
                return new zzqs();
            }
            case 4: {
                return new zzqr(null);
            }
            case 5: {
                return zzqs.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

