package com.google.android.gms.cast.framework.media.internal;

import android.os.Parcel;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

public abstract class zzi extends zzb implements zzj {
    public zzi() {
        super("com.google.android.gms.cast.framework.media.internal.IFetchBitmapTaskProgressPublisher");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                long v2 = parcel0.readLong();
                long v3 = parcel0.readLong();
                zzc.zzb(parcel0);
                this.zzb(v2, v3);
                parcel1.writeNoException();
                return true;
            }
            case 2: {
                parcel1.writeNoException();
                parcel1.writeInt(12451000);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

