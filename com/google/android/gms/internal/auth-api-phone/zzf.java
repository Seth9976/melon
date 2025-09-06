package com.google.android.gms.internal.auth-api-phone;

import android.app.PendingIntent;
import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class zzf extends zzb implements zzg {
    public zzf() {
        super("com.google.android.gms.auth.api.phone.internal.IMissedCallRetrieverCallbacks");
    }

    @Override  // com.google.android.gms.internal.auth-api-phone.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            PendingIntent pendingIntent0 = (PendingIntent)zzc.zza(parcel0, PendingIntent.CREATOR);
            Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
            zzc.zzb(parcel0);
            this.zzb(pendingIntent0, status0);
            return true;
        }
        return false;
    }
}

