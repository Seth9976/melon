package com.google.android.gms.internal.location;

import android.app.PendingIntent;
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
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.location.zzv;
import com.google.android.gms.location.zzw;
import com.google.android.gms.location.zzy;
import com.google.android.gms.location.zzz;

@Class(creator = "LocationRequestUpdateDataCreator")
@Reserved({1000})
@Deprecated
public final class zzei extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(defaultValueUnchecked = "LocationRequestUpdateData.OPERATION_ADD", getter = "getOperation", id = 1)
    private final int zza;
    @Field(defaultValueUnchecked = "null", getter = "getLocationRequest", id = 2)
    private final zzeg zzb;
    @Field(defaultValueUnchecked = "null", getter = "getLocationListenerAsBinder", id = 3, type = "android.os.IBinder")
    private final zzz zzc;
    @Field(defaultValueUnchecked = "null", getter = "getLocationCallbackAsBinder", id = 5, type = "android.os.IBinder")
    private final zzw zzd;
    @Field(defaultValueUnchecked = "null", getter = "getPendingIntent", id = 4)
    private final PendingIntent zze;
    @Field(defaultValueUnchecked = "null", getter = "getFusedLocationProviderCallbackAsBinder", id = 6, type = "android.os.IBinder")
    private final zzr zzf;
    @Field(defaultValueUnchecked = "null", getter = "getListenerId", id = 8)
    private final String zzg;

    static {
        zzei.CREATOR = new zzej();
    }

    @Constructor
    public zzei(@Param(id = 1) int v, @Param(id = 2) zzeg zzeg0, @Param(id = 3) IBinder iBinder0, @Param(id = 5) IBinder iBinder1, @Param(id = 4) PendingIntent pendingIntent0, @Param(id = 6) IBinder iBinder2, @Param(id = 8) String s) {
        this.zza = v;
        this.zzb = zzeg0;
        zzr zzr0 = null;
        this.zzc = iBinder0 == null ? null : zzy.zzb(iBinder0);
        this.zze = pendingIntent0;
        this.zzd = iBinder1 == null ? null : zzv.zzb(iBinder1);
        if(iBinder2 != null) {
            IInterface iInterface0 = iBinder2.queryLocalInterface("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
            zzr0 = iInterface0 instanceof zzr ? ((zzr)iInterface0) : new zzp(iBinder2);
        }
        this.zzf = zzr0;
        this.zzg = s;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.zzb, v, false);
        IBinder iBinder0 = null;
        SafeParcelWriter.writeIBinder(parcel0, 3, (this.zzc == null ? null : this.zzc.asBinder()), false);
        SafeParcelWriter.writeParcelable(parcel0, 4, this.zze, v, false);
        SafeParcelWriter.writeIBinder(parcel0, 5, (this.zzd == null ? null : this.zzd.asBinder()), false);
        zzr zzr0 = this.zzf;
        if(zzr0 != null) {
            iBinder0 = zzr0.asBinder();
        }
        SafeParcelWriter.writeIBinder(parcel0, 6, iBinder0, false);
        SafeParcelWriter.writeString(parcel0, 8, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

