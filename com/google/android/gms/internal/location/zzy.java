package com.google.android.gms.internal.location;

import android.location.Location;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class zzy extends zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.location.internal.ILocationStatusCallback");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
            Location location0 = (Location)zzc.zza(parcel0, Location.CREATOR);
            zzc.zzd(parcel0);
            this.zzb(status0, location0);
            return true;
        }
        return false;
    }
}

