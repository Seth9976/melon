package com.google.android.gms.internal.cast;

public final class zzaaj extends zzxi implements zzym {
    private static final zzaaj zzb;
    private zzxn zzd;

    static {
        zzaaj zzaaj0 = new zzaaj();
        zzaaj.zzb = zzaaj0;
        zzxi.zzJ(zzaaj.class, zzaaj0);
    }

    private zzaaj() {
        this.zzd = zzxi.zzD();
    }

    @Override  // com.google.android.gms.internal.cast.zzxi
    public final Object zzb(int v, Object object0, Object object1) {
        switch(v - 1) {
            case 0: {
                return (byte)1;
            }
            case 2: {
                return zzxi.zzG(zzaaj.zzb, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001B", new Object[]{"zzd", zzaam.class});
            }
            case 3: {
                return new zzaaj();
            }
            case 4: {
                return new zzaah(null);
            }
            case 5: {
                return zzaaj.zzb;
            }
            default: {
                throw null;
            }
        }
    }

    public static zzaaj zzc() {
        return zzaaj.zzb;
    }
}

