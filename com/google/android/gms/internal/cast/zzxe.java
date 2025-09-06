package com.google.android.gms.internal.cast;

final class zzxe implements zzyj {
    private static final zzxe zza;

    static {
        zzxe.zza = new zzxe();
    }

    public static zzxe zza() {
        return zzxe.zza;
    }

    @Override  // com.google.android.gms.internal.cast.zzyj
    public final zzyi zzb(Class class0) {
        Class class1 = zzxi.class;
        if(class1.isAssignableFrom(class0)) {
            try {
                return (zzyi)zzxi.zzz(class0.asSubclass(class1)).zzb(3, null, null);
            }
            catch(Exception exception0) {
                throw new RuntimeException("Unable to get message info for " + class0.getName(), exception0);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + class0.getName());
    }

    @Override  // com.google.android.gms.internal.cast.zzyj
    public final boolean zzc(Class class0) {
        return zzxi.class.isAssignableFrom(class0);
    }
}

