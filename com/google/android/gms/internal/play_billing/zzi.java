package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.Parcel;

public abstract class zzi extends zzw implements zzj {
    public zzi() {
        super("com.android.vending.billing.IInAppBillingGetBillingConfigCallback");
    }

    @Override  // com.google.android.gms.internal.play_billing.zzw
    public final boolean zzb(int v, Parcel parcel0, Parcel parcel1, int v1) {
        if(v == 1) {
            Bundle bundle0 = (Bundle)zzx.zza(parcel0, Bundle.CREATOR);
            zzx.zzb(parcel0);
            this.zza(bundle0);
            parcel1.writeNoException();
            return true;
        }
        return false;
    }
}

