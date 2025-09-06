package com.google.android.gms.internal.measurement;

final class zzlz implements zznj {
    private static final zzlz zza;

    static {
        zzlz.zza = new zzlz();
    }

    public static zzlz zza() {
        return zzlz.zza;
    }

    @Override  // com.google.android.gms.internal.measurement.zznj
    public final boolean zzb(Class class0) {
        return zzme.class.isAssignableFrom(class0);
    }

    @Override  // com.google.android.gms.internal.measurement.zznj
    public final zzni zzc(Class class0) {
        Class class1 = zzme.class;
        if(class1.isAssignableFrom(class0)) {
            try {
                return (zzni)zzme.zzco(class0.asSubclass(class1)).zzl(3, null, null);
            }
            catch(Exception exception0) {
                throw new RuntimeException("Unable to get message info for " + class0.getName(), exception0);
            }
        }
        throw new IllegalArgumentException("Unsupported message type: " + class0.getName());
    }
}

