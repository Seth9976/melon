package com.google.android.gms.internal.cast;

public final class zzrc extends zzxi implements zzym {
    private static final zzrc zzb;
    private int zzd;
    private String zze;
    private String zzf;

    static {
        zzrc zzrc0 = new zzrc();
        zzrc.zzb = zzrc0;
        zzxi.zzJ(zzrc.class, zzrc0);
    }

    private zzrc() {
        this.zze = "";
        this.zzf = "";
    }

    public static zzrb zza() {
        return (zzrb)zzrc.zzb.zzy();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzrc.zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
            }
            case 3: {
                return new zzrc();
            }
            case 4: {
                return new zzrb(null);
            }
            case 5: {
                return zzrc.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzrc zzc() {
        return zzrc.zzb;
    }

    public static void zzd(zzrc zzrc0, String s) {
        s.getClass();
        zzrc0.zzd |= 1;
        zzrc0.zze = s;
    }
}

