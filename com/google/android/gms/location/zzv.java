package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

public abstract class zzv extends zzb implements zzw {
    public zzv() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                LocationResult locationResult0 = (LocationResult)zzc.zza(parcel0, LocationResult.CREATOR);
                zzc.zzd(parcel0);
                this.zzd(locationResult0);
                return true;
            }
            case 2: {
                LocationAvailability locationAvailability0 = (LocationAvailability)zzc.zza(parcel0, LocationAvailability.CREATOR);
                zzc.zzd(parcel0);
                this.zze(locationAvailability0);
                return true;
            }
            case 3: {
                this.zzf();
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static zzw zzb(IBinder iBinder0) {
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return iInterface0 instanceof zzw ? ((zzw)iInterface0) : new zzu(iBinder0);
    }
}

