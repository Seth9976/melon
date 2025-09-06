package com.google.android.gms.internal.cast;

public final class zzpn extends zzxi implements zzym {
    private static final zzpn zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private zzxn zzi;
    private zzxn zzj;
    private String zzk;

    static {
        zzpn zzpn0 = new zzpn();
        zzpn.zzb = zzpn0;
        zzxi.zzJ(zzpn.class, zzpn0);
    }

    private zzpn() {
        this.zzi = zzxi.zzD();
        this.zzj = zzxi.zzD();
        this.zzk = "";
    }

    public static zzpn zza() {
        return zzpn.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzpn.zzb, "\u0001\u0007\u0000\u0001\u0001\t\u0007\u0000\u0002\u0000\u0001᠌\u0000\u0002ဇ\u0001\u0003᠌\u0002\u0004ဇ\u0003\u0007\u001B\b\u001B\tဈ\u0004", new Object[]{"zzd", "zze", zzkt.zza(), "zzf", "zzg", zzlx.zza(), "zzh", "zzi", zzso.class, "zzj", zzso.class, "zzk"});
            }
            case 3: {
                return new zzpn();
            }
            case 4: {
                return new zzpm(null);
            }
            case 5: {
                return zzpn.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

