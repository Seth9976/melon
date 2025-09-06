package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import javax.annotation.Nullable;

@Class(creator = "GoogleCertificatesLookupResponseCreator")
@Reserved({6})
public final class zzr extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getResult", id = 1)
    private final boolean zza;
    @Field(getter = "getErrorMessage", id = 2)
    @Nullable
    private final String zzb;
    @Field(getter = "getStatusValue", id = 3)
    private final int zzc;
    @Field(getter = "getFirstPartyStatusValue", id = 4)
    private final int zzd;
    @Field(defaultValue = "-1", getter = "getSourceStampTimestampSeconds", id = 5)
    private final long zze;

    static {
        zzr.CREATOR = new zzs();
    }

    @Constructor
    public zzr(@Param(id = 1) boolean z, @Param(id = 2) String s, @Param(id = 3) int v, @Param(id = 4) int v1, @Param(id = 5) long v2) {
        this.zza = z;
        this.zzb = s;
        this.zzc = zzz.zza(v) - 1;
        this.zzd = zzc.zza(v1) - 1;
        this.zze = v2;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 1, this.zza);
        SafeParcelWriter.writeString(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeInt(parcel0, 3, this.zzc);
        SafeParcelWriter.writeInt(parcel0, 4, this.zzd);
        SafeParcelWriter.writeLong(parcel0, 5, this.zze);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final boolean zza() {
        return this.zza;
    }

    @Nullable
    public final String zzb() {
        return this.zzb;
    }

    public final long zzc() {
        return this.zze;
    }

    public final int zzd() {
        return zzz.zza(this.zzc);
    }

    public final int zze() {
        return zzc.zza(this.zzd);
    }
}

