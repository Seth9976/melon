package com.google.android.gms.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import java.util.List;

@ShowFirstParty
@Class(creator = "TokenDataCreator")
public class TokenData extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    @VersionField(id = 1)
    final int zza;
    @Field(getter = "getToken", id = 2)
    private final String zzb;
    @Field(getter = "getExpirationTimeSecs", id = 3)
    private final Long zzc;
    @Field(getter = "isCached", id = 4)
    private final boolean zzd;
    @Field(getter = "isSnowballed", id = 5)
    private final boolean zze;
    @Field(getter = "getGrantedScopes", id = 6)
    private final List zzf;
    @Field(getter = "getScopeData", id = 7)
    private final String zzg;

    static {
        TokenData.CREATOR = new zzm();
    }

    @Constructor
    public TokenData(@Param(id = 1) int v, @Param(id = 2) String s, @Param(id = 3) Long long0, @Param(id = 4) boolean z, @Param(id = 5) boolean z1, @Param(id = 6) List list0, @Param(id = 7) String s1) {
        this.zza = v;
        this.zzb = Preconditions.checkNotEmpty(s);
        this.zzc = long0;
        this.zzd = z;
        this.zze = z1;
        this.zzf = list0;
        this.zzg = s1;
    }

    // 去混淆评级： 中等(50)
    @Override
    public final boolean equals(Object object0) {
        return object0 instanceof TokenData ? TextUtils.equals(this.zzb, ((TokenData)object0).zzb) && Objects.equal(this.zzc, ((TokenData)object0).zzc) && this.zzd == ((TokenData)object0).zzd && this.zze == ((TokenData)object0).zze && Objects.equal(this.zzf, ((TokenData)object0).zzf) && Objects.equal(this.zzg, ((TokenData)object0).zzg) : false;
    }

    @Override
    public final int hashCode() {
        return Objects.hashCode(new Object[]{this.zzb, this.zzc, Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zzf, this.zzg});
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeInt(parcel0, 1, this.zza);
        SafeParcelWriter.writeString(parcel0, 2, this.zzb, false);
        SafeParcelWriter.writeLongObject(parcel0, 3, this.zzc, false);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel0, 5, this.zze);
        SafeParcelWriter.writeStringList(parcel0, 6, this.zzf, false);
        SafeParcelWriter.writeString(parcel0, 7, this.zzg, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final String zza() {
        return this.zzb;
    }
}

