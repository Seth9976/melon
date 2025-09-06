package com.google.android.gms.internal.play_billing;

final class zzej {
    private static final zzei zza;
    private static final zzei zzb;

    static {
        zzei zzei0 = null;
        try {
            zzei0 = (zzei)Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor(null).newInstance(null);
        }
        catch(Exception unused_ex) {
        }
        zzej.zza = zzei0;
        zzej.zzb = new zzei();
    }

    public static zzei zza() {
        return zzej.zza;
    }

    public static zzei zzb() {
        return zzej.zzb;
    }
}

