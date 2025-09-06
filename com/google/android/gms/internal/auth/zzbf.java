package com.google.android.gms.internal.auth;

import android.os.Parcel;
import com.google.android.gms.auth.api.proxy.ProxyResponse;

public abstract class zzbf extends zzb implements zzbg {
    public zzbf() {
        super("com.google.android.gms.auth.api.internal.IAuthCallbacks");
    }

    @Override  // com.google.android.gms.internal.auth.zzb
    public final boolean zza(int v, Parcel parcel0, Parcel parcel1, int v1) {
        switch(v) {
            case 1: {
                ProxyResponse proxyResponse0 = (ProxyResponse)zzc.zza(parcel0, ProxyResponse.CREATOR);
                zzc.zzb(parcel0);
                this.zzb(proxyResponse0);
                break;
            }
            case 2: {
                String s = parcel0.readString();
                zzc.zzb(parcel0);
                this.zzc(s);
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

