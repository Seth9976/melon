package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.common.internal.zzx;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Arrays;

abstract class zzj extends zzw {
    private final int zza;

    public zzj(byte[] arr_b) {
        Preconditions.checkArgument(arr_b.length == 25);
        this.zza = Arrays.hashCode(arr_b);
    }

    @Override
    public final boolean equals(Object object0) {
        if(object0 != null && object0 instanceof zzx) {
            try {
                if(((zzx)object0).zze() != this.zza) {
                    return false;
                }
                IObjectWrapper iObjectWrapper0 = ((zzx)object0).zzd();
                if(iObjectWrapper0 != null) {
                    byte[] arr_b = (byte[])ObjectWrapper.unwrap(iObjectWrapper0);
                    return Arrays.equals(this.zzc(), arr_b);
                }
                return false;
            }
            catch(RemoteException remoteException0) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", remoteException0);
            }
        }
        return false;
    }

    @Override
    public final int hashCode() {
        return this.zza;
    }

    public abstract byte[] zzc();

    @Override  // com.google.android.gms.common.internal.zzx
    public final IObjectWrapper zzd() {
        return ObjectWrapper.wrap(this.zzc());
    }

    @Override  // com.google.android.gms.common.internal.zzx
    public final int zze() {
        return this.zza;
    }

    public static byte[] zzf(String s) [...] // 潜在的解密器
}

