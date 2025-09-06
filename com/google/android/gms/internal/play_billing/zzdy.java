package com.google.android.gms.internal.play_billing;

final class zzdy {
    private static final zzdx zza;
    private static final zzdx zzb;

    static {
        zzdx zzdx0 = null;
        try {
            zzdx0 = (zzdx)Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor(null).newInstance(null);
        }
        catch(Exception unused_ex) {
        }
        zzdy.zza = zzdx0;
        zzdy.zzb = new zzdx();
    }

    public static zzdx zza() {
        return zzdy.zza;
    }

    public static zzdx zzb() {
        return zzdy.zzb;
    }
}

