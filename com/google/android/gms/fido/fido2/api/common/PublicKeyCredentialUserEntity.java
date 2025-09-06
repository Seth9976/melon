package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Arrays;

@Class(creator = "PublicKeyCredentialUserEntityCreator")
@Reserved({1})
public class PublicKeyCredentialUserEntity extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getId", id = 2)
    private final byte[] zza;
    @Field(getter = "getName", id = 3)
    private final String zzb;
    @Field(getter = "getIcon", id = 4)
    private final String zzc;
    @Field(getter = "getDisplayName", id = 5)
    private final String zzd;

    static {
        PublicKeyCredentialUserEntity.CREATOR = new zzar();
    }

    @Constructor
    public PublicKeyCredentialUserEntity(@Param(id = 2) byte[] arr_b, @Param(id = 3) String s, @Param(id = 4) String s1, @Param(id = 5) String s2) {
        this.zza = (byte[])Preconditions.checkNotNull(arr_b);
        this.zzb = (String)Preconditions.checkNotNull(s);
        this.zzc = s1;
        this.zzd = (String)Preconditions.checkNotNull(s2);
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof PublicKeyCredentialUserEntity ? Arrays.equals(this.zza, ((PublicKeyCredentialUserEntity)object0).zza) && Objects.equal(this.zzb, ((PublicKeyCredentialUserEntity)object0).zzb) && Objects.equal(this.zzc, ((PublicKeyCredentialUserEntity)object0).zzc) && Objects.equal(this.zzd, ((PublicKeyCredentialUserEntity)object0).zzd) : false;
    }

    public String getDisplayName() {
        return this.zzd;
    }

    public String getIcon() {
        return this.zzc;
    }

    public byte[] getId() {
        return this.zza;
    }

    public String getName() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeByteArray(parcel0, 2, this.getId(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getName(), false);
        SafeParcelWriter.writeString(parcel0, 4, this.getIcon(), false);
        SafeParcelWriter.writeString(parcel0, 5, this.getDisplayName(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

