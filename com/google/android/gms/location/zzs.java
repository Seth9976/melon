package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

public abstract class zzs extends zzb implements zzt {
    public zzs() {
        super("com.google.android.gms.location.IDeviceOrientationListener");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            DeviceOrientation deviceOrientation0 = (DeviceOrientation)zzc.zza(parcel0, DeviceOrientation.CREATOR);
            zzc.zzd(parcel0);
            this.zzd(deviceOrientation0);
            return true;
        }
        return false;
    }

    public static zzt zzb(IBinder iBinder0) {
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.location.IDeviceOrientationListener");
        return iInterface0 instanceof zzt ? ((zzt)iInterface0) : new zzr(iBinder0);
    }
}

