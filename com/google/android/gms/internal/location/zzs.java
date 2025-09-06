package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;

public abstract class zzs extends zzb implements zzt {
    public zzs() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    @Override  // com.google.android.gms.internal.location.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                int v2 = parcel0.readInt();
                String[] arr_s = parcel0.createStringArray();
                zzc.zzd(parcel0);
                this.zzb(v2, arr_s);
                return true;
            }
            case 2: {
                int v3 = parcel0.readInt();
                String[] arr_s1 = parcel0.createStringArray();
                zzc.zzd(parcel0);
                this.zzc(v3, arr_s1);
                return true;
            }
            case 3: {
                int v4 = parcel0.readInt();
                PendingIntent pendingIntent0 = (PendingIntent)zzc.zza(parcel0, PendingIntent.CREATOR);
                zzc.zzd(parcel0);
                this.zzd(v4, pendingIntent0);
                return true;
            }
            default: {
                return false;
            }
        }
    }
}

