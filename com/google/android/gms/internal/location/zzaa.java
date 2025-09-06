package com.google.android.gms.internal.location;

import android.os.Parcel;
import com.google.android.gms.location.LocationSettingsResult;

public abstract class zzaa extends zzb implements zzab {
    public zzaa() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            LocationSettingsResult locationSettingsResult0 = (LocationSettingsResult)zzc.zza(parcel0, LocationSettingsResult.CREATOR);
            zzc.zzd(parcel0);
            this.zzb(locationSettingsResult0);
            return true;
        }
        return false;
    }
}

