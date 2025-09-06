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

@Class(creator = "PublicKeyCredentialParametersCreator")
@Reserved({1})
public class PublicKeyCredentialParameters extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getTypeAsString", id = 2, type = "java.lang.String")
    private final PublicKeyCredentialType zza;
    @Field(getter = "getAlgorithmIdAsInteger", id = 3, type = "java.lang.Integer")
    private final COSEAlgorithmIdentifier zzb;

    static {
        PublicKeyCredentialParameters.CREATOR = new zzan();
    }

    @Constructor
    public PublicKeyCredentialParameters(@Param(id = 2) String s, @Param(id = 3) int v) {
        Preconditions.checkNotNull(s);
        try {
            this.zza = PublicKeyCredentialType.fromString(s);
        }
        catch(UnsupportedPublicKeyCredTypeException publicKeyCredentialType$UnsupportedPublicKeyCredTypeException0) {
            throw new IllegalArgumentException(publicKeyCredentialType$UnsupportedPublicKeyCredTypeException0);
        }
        Preconditions.checkNotNull(v);
        try {
            this.zzb = COSEAlgorithmIdentifier.fromCoseValue(v);
        }
        catch(UnsupportedAlgorithmIdentifierException cOSEAlgorithmIdentifier$UnsupportedAlgorithmIdentifierException0) {
            throw new IllegalArgumentException(cOSEAlgorithmIdentifier$UnsupportedAlgorithmIdentifierException0);
        }
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof PublicKeyCredentialParameters ? this.zza.equals(((PublicKeyCredentialParameters)object0).zza) && this.zzb.equals(((PublicKeyCredentialParameters)object0).zzb) : false;
    }

    public COSEAlgorithmIdentifier getAlgorithm() {
        return this.zzb;
    }

    public int getAlgorithmIdAsInteger() {
        return this.zzb.toCoseValue();
    }

    public PublicKeyCredentialType getType() {
        return this.zza;
    }

    public String getTypeAsString() {
        return this.zza.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getTypeAsString(), false);
        SafeParcelWriter.writeIntegerObject(parcel0, 3, this.getAlgorithmIdAsInteger(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

