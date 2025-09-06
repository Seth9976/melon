package com.google.android.gms.common;

import android.content.Context;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.dynamic.IObjectWrapper.Stub;
import com.google.android.gms.dynamic.ObjectWrapper;

@Class(creator = "GoogleCertificatesLookupQueryCreator")
@Reserved({7})
public final class zzp extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getCallingPackage", id = 1)
    private final String zza;
    @Field(getter = "getAllowTestKeys", id = 2)
    private final boolean zzb;
    @Field(defaultValue = "false", getter = "getIgnoreTestKeysOverride", id = 3)
    private final boolean zzc;
    @Field(getter = "getCallingContextBinder", id = 4, type = "android.os.IBinder")
    private final Context zzd;
    @Field(getter = "getIsChimeraPackage", id = 5)
    private final boolean zze;
    @Field(getter = "getIncludeHashesInErrorMessage", id = 6)
    private final boolean zzf;
    @Field(defaultValue = "false", getter = "getShouldFetchSourceStampTimestamp", id = 8)
    private final boolean zzg;

    static {
        zzp.CREATOR = new zzq();
    }

    @Constructor
    public zzp(@Param(id = 1) String s, @Param(id = 2) boolean z, @Param(id = 3) boolean z1, @Param(id = 4) IBinder iBinder0, @Param(id = 5) boolean z2, @Param(id = 6) boolean z3, @Param(id = 8) boolean z4) {
        this.zza = s;
        this.zzb = z;
        this.zzc = z1;
        this.zzd = (Context)ObjectWrapper.unwrap(Stub.asInterface(iBinder0));
        this.zze = z2;
        this.zzf = z3;
        this.zzg = z4;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.zza, false);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.zzb);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzc);
        SafeParcelWriter.writeIBinder(parcel0, 4, ((IBinder)ObjectWrapper.wrap(this.zzd)), false);
        SafeParcelWriter.writeBoolean(parcel0, 5, this.zze);
        SafeParcelWriter.writeBoolean(parcel0, 6, this.zzf);
        SafeParcelWriter.writeBoolean(parcel0, 8, this.zzg);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

