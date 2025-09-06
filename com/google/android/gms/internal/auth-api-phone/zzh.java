package com.google.android.gms.internal.auth-api-phone;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.auth.api.phone.IncomingCallRetrieverRequest;

public final class zzh extends zza implements IInterface {
    public zzh(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.auth.api.phone.internal.IMissedCallRetrieverService");
    }

    public final void zzc(zzg zzg0, IncomingCallRetrieverRequest incomingCallRetrieverRequest0) {
        Parcel parcel0 = this.zza();
        zzc.zzc(parcel0, zzg0);
        if(incomingCallRetrieverRequest0 == null) {
            parcel0.writeInt(0);
        }
        else {
            parcel0.writeInt(1);
            incomingCallRetrieverRequest0.writeToParcel(parcel0, 0);
        }
        this.zzb(1, parcel0);
    }
}

