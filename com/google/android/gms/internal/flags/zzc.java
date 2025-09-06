package com.google.android.gms.internal.flags;

import android.os.IInterface;
import android.os.Parcel;

public final class zzc {
    private static final ClassLoader zza;

    static {
        zzc.zza = zzc.class.getClassLoader();
    }

    public static void zza(Parcel parcel0, boolean z) {
        parcel0.writeInt(((int)z));
    }

    public static void zzb(Parcel parcel0, IInterface iInterface0) {
        if(iInterface0 == null) {
            parcel0.writeStrongBinder(null);
            return;
        }
        parcel0.writeStrongBinder(iInterface0.asBinder());
    }

    public static boolean zzc(Parcel parcel0) {
        return parcel0.readInt() != 0;
    }
}

