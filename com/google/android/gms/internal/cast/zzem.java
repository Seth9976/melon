package com.google.android.gms.internal.cast;

import android.os.Parcel;

public abstract class zzem extends zzb implements zzen {
    public zzem() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
    }

    @Override  // com.google.android.gms.internal.cast.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            int v2 = parcel0.readInt();
            zzc.zzb(parcel0);
            this.zzb(v2);
            return true;
        }
        return false;
    }
}

