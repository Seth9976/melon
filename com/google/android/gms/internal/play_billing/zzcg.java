package com.google.android.gms.internal.play_billing;

final class zzcg {
    private static final zzce zza;
    private static final zzce zzb;

    static {
        zzcg.zza = new zzcf();
        zzce zzce0 = null;
        try {
            zzce0 = (zzce)Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor(null).newInstance(null);
        }
        catch(Exception unused_ex) {
        }
        zzcg.zzb = zzce0;
    }

    public static zzce zza() {
        zzce zzce0 = zzcg.zzb;
        if(zzce0 == null) {
            throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
        }
        return zzce0;
    }

    public static zzce zzb() {
        return zzcg.zza;
    }
}

