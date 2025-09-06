package com.google.android.gms.internal.cast;

public final class zztp extends zzxi implements zzym {
    private static final zztp zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private zzxn zzg;

    static {
        zztp zztp0 = new zztp();
        zztp.zzb = zztp0;
        zzxi.zzJ(zztp.class, zztp0);
    }

    private zztp() {
        this.zzg = zzxi.zzD();
    }

    public static zztp zza() {
        return zztp.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztp.zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003\u001B", new Object[]{"zzd", "zze", "zzf", "zzg", zztr.class});
            }
            case 3: {
                return new zztp();
            }
            case 4: {
                return new zzto(null);
            }
            case 5: {
                return zztp.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

