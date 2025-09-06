package com.google.android.gms.cast.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "CastEurekaInfoCreator")
@Reserved({1})
public final class zzaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getVersion", id = 2)
    private final int zza;
    @Field(getter = "getMultizoneSupported", id = 3)
    private final boolean zzb;
    @Field(getter = "getVirtualRemoteSupported", id = 4)
    private final boolean zzc;
    @Field(getter = "getManufacturer", id = 5)
    private final String zzd;
    @Field(getter = "getProductName", id = 6)
    private final String zze;
    @Field(getter = "getBuildType", id = 7)
    private final String zzf;
    @Field(getter = "getCastBuildVersion", id = 8)
    private final String zzg;
    @Field(getter = "getSystemBuildNumber", id = 9)
    private final String zzh;
    @Field(getter = "getMultiplexConnectionsSupported", id = 10)
    private final boolean zzi;

    static {
        zzaa.CREATOR = new zzab();
    }

    @Constructor
    public zzaa(@Param(id = 2) int v, @Param(id = 3) boolean z, @Param(id = 4) boolean z1, @Param(id = 5) String s, @Param(id = 6) String s1, @Param(id = 7) String s2, @Param(id = 8) String s3, @Param(id = 9) String s4, @Param(id = 10) boolean z2) {
        this.zza = v;
        this.zzb = z;
        this.zzc = z1;
        this.zzd = s;
        this.zze = s1;
        this.zzf = s2;
        this.zzg = s3;
        this.zzh = s4;
        this.zzi = z2;
    }

    // 去混淆评级： 低(20)
    @Override
    public final boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof zzaa ? this.zza == ((zzaa)object0).zza && this.zzb == ((zzaa)object0).zzb && this.zzc == ((zzaa)object0).zzc && TextUtils.equals(this.zzd, ((zzaa)object0).zzd) && TextUtils.equals(this.zze, ((zzaa)object0).zze) && TextUtils.equals(this.zzf, ((zzaa)object0).zzf) && TextUtils.equals(this.zzg, ((zzaa)object0).zzg) && TextUtils.equals(this.zzh, ((zzaa)object0).zzh) && this.zzi == ((zzaa)object0).zzi : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, Boolean.valueOf(this.zzb), Boolean.valueOf(this.zzc), this.zzd, this.zze, this.zzf, this.zzg, this.zzh, Boolean.valueOf(this.zzi)});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 2, this.zza);
        SafeParcelWriter.writeBoolean(parcel0, 3, this.zzb);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzc);
        SafeParcelWriter.writeString(parcel0, 5, this.zzd, false);
        SafeParcelWriter.writeString(parcel0, 6, this.zze, false);
        SafeParcelWriter.writeString(parcel0, 7, this.zzf, false);
        SafeParcelWriter.writeString(parcel0, 8, this.zzg, false);
        SafeParcelWriter.writeString(parcel0, 9, this.zzh, false);
        SafeParcelWriter.writeBoolean(parcel0, 10, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zza() {
        return this.zzf;
    }

    public final String zzb() {
        return this.zzg;
    }

    public final String zzc() {
        return this.zzd;
    }

    public final String zzd() {
        return this.zze;
    }

    public final String zze() {
        return this.zzh;
    }
}

