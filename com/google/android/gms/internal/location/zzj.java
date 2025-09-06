package com.google.android.gms.internal.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.location.zzs;
import com.google.android.gms.location.zzt;

@Class(creator = "DeviceOrientationRequestUpdateDataCreator")
public final class zzj extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(defaultValueUnchecked = "DeviceOrientationRequestUpdateData.OPERATION_ADD", id = 1)
    final int zza;
    @Field(defaultValueUnchecked = "null", id = 2)
    final zzh zzb;
    @Field(defaultValueUnchecked = "null", getter = "getDeviceOrientationListenerBinder", id = 3, type = "android.os.IBinder")
    final zzt zzc;
    @Field(defaultValueUnchecked = "null", getter = "getFusedLocationProviderCallbackBinder", id = 4, type = "android.os.IBinder")
    final zzr zzd;

    static {
        zzj.CREATOR = new zzk();
    }

    @Constructor
    public zzj(@Param(id = 1) int v, @Param(id = 2) zzh zzh0, @Param(id = 3) IBinder iBinder0, @Param(id = 4) IBinder iBinder1) {
        this.zza = v;
        this.zzb = zzh0;
        zzr zzr0 = null;
        this.zzc = iBinder0 == null ? null : zzs.zzb(iBinder0);
        if(iBinder1 != null) {
            IInterface iInterface0 = iBinder1.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzr0 = iInterface0 instanceof zzr ? ((zzr)iInterface0) : new zzp(iBinder1);
        }
        this.zzd = zzr0;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzb, v, false);
        IBinder iBinder0 = null;
        SafeParcelWriter.writeIBinder(parcel0, 3, (this.zzc == null ? null : this.zzc.asBinder()), false);
        zzr zzr0 = this.zzd;
        if(zzr0 != null) {
            iBinder0 = zzr0.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel0, 4, iBinder0, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

