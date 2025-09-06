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

@Class(creator = "PublicKeyCredentialRpEntityCreator")
@Reserved({1})
public class PublicKeyCredentialRpEntity extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getId", id = 2)
    private final String zza;
    @Field(getter = "getName", id = 3)
    private final String zzb;
    @Field(getter = "getIcon", id = 4)
    private final String zzc;

    static {
        PublicKeyCredentialRpEntity.CREATOR = new zzap();
    }

    @Constructor
    public PublicKeyCredentialRpEntity(@Param(id = 2) String s, @Param(id = 3) String s1, @Param(id = 4) String s2) {
        this.zza = (String)Preconditions.checkNotNull(s);
        this.zzb = (String)Preconditions.checkNotNull(s1);
        this.zzc = s2;
    }

    // 去混淆评级： 低(40)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof PublicKeyCredentialRpEntity ? Objects.equal(this.zza, ((PublicKeyCredentialRpEntity)object0).zza) && Objects.equal(this.zzb, ((PublicKeyCredentialRpEntity)object0).zzb) && Objects.equal(this.zzc, ((PublicKeyCredentialRpEntity)object0).zzc) : false;
    }

    public String getIcon() {
        return this.zzc;
    }

    public String getId() {
        return this.zza;
    }

    public String getName() {
        return this.zzb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getId(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getName(), false);
        SafeParcelWriter.writeString(parcel0, 4, this.getIcon(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

