package com.google.android.gms.internal.cast;

public final class zztz extends zzxi implements zzym {
    private static final zztz zzb;
    private int zzd;
    private String zze;
    private zzrc zzf;
    private boolean zzg;
    private boolean zzh;
    private boolean zzi;
    private boolean zzj;
    private long zzk;
    private long zzl;
    private int zzm;
    private int zzn;
    private zzxl zzo;

    static {
        zztz zztz0 = new zztz();
        zztz.zzb = zztz0;
        zzxi.zzJ(zztz.class, zztz0);
    }

    private zztz() {
        this.zze = "";
        this.zzo = zzxi.zzB();
    }

    public static zztz zza() {
        return zztz.zzb;
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zztz.zzb, "\u0001\u000B\u0000\u0001\u0001\u000B\u000B\u0000\u0001\u0000\u0001ဉ\u0001\u0002ဇ\u0002\u0003ဇ\u0003\u0004ဇ\u0004\u0005ဂ\u0006\u0006ဂ\u0007\u0007င\b\bင\t\t\'\nဈ\u0000\u000Bဇ\u0005", new Object[]{"zzd", "zzf", "zzg", "zzh", "zzi", "zzk", "zzl", "zzm", "zzn", "zzo", "zze", "zzj"});
            }
            case 3: {
                return new zztz();
            }
            case 4: {
                return new zzty(null);
            }
            case 5: {
                return zztz.zzb;
            }
            default: {
                throw null;
            }
        }
    }
}

