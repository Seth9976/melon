package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.zzw;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.Nullable;

@Class(creator = "GoogleCertificatesQueryCreator")
public final class zzt extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getCallingPackage", id = 1)
    private final String zza;
    @Field(getter = "getCallingCertificateBinder", id = 2, type = "android.os.IBinder")
    @Nullable
    private final zzj zzb;
    @Field(getter = "getAllowTestKeys", id = 3)
    private final boolean zzc;
    @Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 4)
    private final boolean zzd;

    static {
        zzt.CREATOR = new zzu();
    }

    @Constructor
    public zzt(@Param(id = 1) String s, @Param(id = 2) @Nullable IBinder iBinder0, @Param(id = 3) boolean z, @Param(id = 4) boolean z1) {
        IObjectWrapper iObjectWrapper0;
        this.zza = s;
        zzj zzj0 = null;
        if(iBinder0 != null) {
            try {
                iObjectWrapper0 = zzw.zzg(iBinder0).zzd();
            }
            catch(RemoteException remoteException0) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", remoteException0);
                this.zzb = zzj0;
                this.zzc = z;
                this.zzd = z1;
                return;
            }
            byte[] arr_b = iObjectWrapper0 == null ? null : ((byte[])ObjectWrapper.unwrap(iObjectWrapper0));
            if(arr_b == null) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
            }
            else {
                zzj0 = new zzk(arr_b);
            }
        }
        this.zzb = zzj0;
        this.zzc = z;
        this.zzd = z1;
    }

    public zzt(String s, @Nullable zzj zzj0, boolean z, boolean z1) {
        this.zza = s;
        this.zzb = zzj0;
        this.zzc = z;
        this.zzd = z1;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        zzj zzj0 = this.zzb;
        if(zzj0 == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            zzj0 = null;
        }
        SafeParcelWriter.writeIBinder(parcel0, 2, zzj0, false);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

