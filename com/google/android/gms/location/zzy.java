package com.google.android.gms.location;

import android.location.Location;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.location.zzb;
import com.google.android.gms.internal.location.zzc;

public abstract class zzy extends zzb implements zzz {
    public zzy() {
        super("com.google.android.gms.location.ILocationListener");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                Location location0 = (Location)zzc.zza(parcel0, Location.CREATOR);
                zzc.zzd(parcel0);
                this.zzd(location0);
                return true;
            }
            case 2: {
                this.zze();
                return true;
            }
            default: {
                return false;
            }
        }
    }

    public static zzz zzb(IBinder iBinder0) {
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.location.ILocationListener");
        return iInterface0 instanceof zzz ? ((zzz)iInterface0) : new zzx(iBinder0);
    }
}

