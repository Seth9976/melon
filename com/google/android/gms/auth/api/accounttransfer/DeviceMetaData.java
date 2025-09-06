package com.google.android.gms.auth.api.accounttransfer;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;

@Class(creator = "DeviceMetaDataCreator")
public class DeviceMetaData extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zza;
    @Field(getter = "isLockScreenSolved", id = 2)
    private final boolean zzb;
    @Field(getter = "getMinAgeOfLockScreen", id = 3)
    private final long zzc;
    @Field(getter = "isChallengeAllowed", id = 4)
    private final boolean zzd;

    static {
        DeviceMetaData.CREATOR = new zzy();
    }

    @Constructor
    public DeviceMetaData(@Param(id = 1) int v, @Param(id = 2) boolean z, @Param(id = 3) long v1, @Param(id = 4) boolean z1) {
        this.zza = v;
        this.zzb = z;
        this.zzc = v1;
        this.zzd = z1;
    }

    public long getMinAgeOfLockScreen() {
        return this.zzc;
    }

    public boolean isChallengeAllowed() {
        return this.zzd;
    }

    public boolean isLockScreenSolved() {
        return this.zzb;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.isLockScreenSolved());
        SafeParcelWriter.writeLong(parcel0, 3, this.getMinAgeOfLockScreen());
        SafeParcelWriter.writeBoolean(parcel0, 4, this.isChallengeAllowed());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

