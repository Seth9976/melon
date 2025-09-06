package com.google.android.gms.internal.location;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class zzn extends zzb implements zzo {
    public zzn() {
        super("com.google.android.gms.location.internal.IBooleanStatusCallback");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        boolean z = false;
        if(v == 1) {
            Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
            if(parcel0.readInt() != 0) {
                z = true;
            }
            zzc.zzd(parcel0);
            this.zzb(status0, z);
            return true;
        }
        return false;
    }
}

