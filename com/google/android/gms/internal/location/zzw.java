package com.google.android.gms.internal.location;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.LocationAvailability;

public abstract class zzw extends zzb implements zzx {
    public zzw() {
        super("com.google.android.gms.location.internal.ILocationAvailabilityStatusCallback");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
            LocationAvailability locationAvailability0 = (LocationAvailability)zzc.zza(parcel0, LocationAvailability.CREATOR);
            zzc.zzd(parcel0);
            this.zzb(status0, locationAvailability0);
            return true;
        }
        return false;
    }
}

