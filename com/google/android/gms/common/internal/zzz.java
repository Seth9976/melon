package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.common.zzb;
import com.google.android.gms.internal.common.zzc;

public abstract class zzz extends zzb implements IGmsCallbacks {
    public zzz() {
        super("com.google.android.gms.common.internal.IGmsCallbacks");
    }

    @Override  // com.google.android.gms.internal.common.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                int v2 = parcel0.readInt();
                IBinder iBinder0 = parcel0.readStrongBinder();
                Bundle bundle0 = (Bundle)zzc.zzb(parcel0, Bundle.CREATOR);
                zzc.zzf(parcel0);
                this.onPostInitComplete(v2, iBinder0, bundle0);
                break;
            }
            case 2: {
                int v3 = parcel0.readInt();
                Bundle bundle1 = (Bundle)zzc.zzb(parcel0, Bundle.CREATOR);
                zzc.zzf(parcel0);
                this.zzb(v3, bundle1);
                break;
            }
            case 3: {
                int v4 = parcel0.readInt();
                IBinder iBinder1 = parcel0.readStrongBinder();
                zzj zzj0 = (zzj)zzc.zzb(parcel0, zzj.CREATOR);
                zzc.zzf(parcel0);
                this.zzc(v4, iBinder1, zzj0);
                break;
            }
            default: {
                return false;
            }
        }
        parcel1.writeNoException();
        return true;
    }
}

