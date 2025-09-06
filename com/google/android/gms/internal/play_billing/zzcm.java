package com.google.android.gms.internal.play_billing;

final class zzcm implements zzea {
    private static final zzcm zza;

    static {
        zzcm.zza = new zzcm();
    }

    public static zzcm zza() {
        return zzcm.zza;
    }

    @Override  // com.google.android.gms.internal.play_billing.zzea
    public final zzdz zzb(Class class0) {
        Class class1 = zzcs.class;
        if(class1.isAssignableFrom(class0)) {
            try {
                return (zzdz)zzcs.zzj(class0.asSubclass(class1)).zzx(3, null, null);
            }
            catch(Exception exception0) {
                throw new RuntimeException("Unable to get message info for " + class0.getName(), exception0);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + class0.getName());
    }

    @Override  // com.google.android.gms.internal.play_billing.zzea
    public final boolean zzc(Class class0) {
        return zzcs.class.isAssignableFrom(class0);
    }
}

