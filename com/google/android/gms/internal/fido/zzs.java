package com.google.android.gms.internal.fido;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialCreationOptions;
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredentialRequestOptions;

public final class zzs extends zza implements IInterface {
    public zzs(IBinder iBinder0) {
        super(iBinder0, "com.google.android.gms.fido.fido2.internal.regular.IFido2AppService");
    }

    public final void zzc(zzr zzr0, PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions0) {
        Parcel parcel0 = this.zza();
        parcel0.writeStrongBinder(((IBinder)zzr0));
        zzc.zzd(parcel0, publicKeyCredentialCreationOptions0);
        this.zzb(1, parcel0);
    }

    public final void zzd(zzr zzr0, PublicKeyCredentialRequestOptions publicKeyCredentialRequestOptions0) {
        Parcel parcel0 = this.zza();
        parcel0.writeStrongBinder(((IBinder)zzr0));
        zzc.zzd(parcel0, publicKeyCredentialRequestOptions0);
        this.zzb(2, parcel0);
    }

    public final void zze(zze zze0) {
        Parcel parcel0 = this.zza();
        parcel0.writeStrongBinder(((IBinder)zze0));
        this.zzb(3, parcel0);
    }
}

