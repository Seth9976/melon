package com.google.android.gms.internal.auth-api-phone;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;

public abstract class zzd extends zzb implements zze {
    public zzd() {
        super("com.google.android.gms.auth.api.phone.internal.IAutofillPermissionStateCallback");
    }

    @Override  // com.google.android.gms.internal.auth-api-phone.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            Status status0 = (Status)zzc.zza(parcel0, Status.CREATOR);
            int v2 = parcel0.readInt();
            zzc.zzb(parcel0);
            this.zzb(status0, v2);
            return true;
        }
        return false;
    }
}

