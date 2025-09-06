package com.google.android.gms.fido.fido2.api.common;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import java.util.Arrays;

@Class(creator = "FidoCredentialDetailsCreator")
public class FidoCredentialDetails extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getUserName", id = 1)
    private final String zza;
    @Field(getter = "getUserDisplayName", id = 2)
    private final String zzb;
    @Field(getter = "getUserId", id = 3)
    private final byte[] zzc;
    @Field(getter = "getCredentialId", id = 4)
    private final byte[] zzd;
    @Field(getter = "getIsDiscoverable", id = 5)
    private final boolean zze;
    @Field(getter = "getIsPaymentCredential", id = 6)
    private final boolean zzf;

    static {
        FidoCredentialDetails.CREATOR = new zzy();
    }

    @Constructor
    public FidoCredentialDetails(@Param(id = 1) String s, @Param(id = 2) String s1, @Param(id = 3) byte[] arr_b, @Param(id = 4) byte[] arr_b1, @Param(id = 5) boolean z, @Param(id = 6) boolean z1) {
        this.zza = s;
        this.zzb = s1;
        this.zzc = arr_b;
        this.zzd = arr_b1;
        this.zze = z;
        this.zzf = z1;
    }

    public static FidoCredentialDetails deserializeFromBytes(byte[] arr_b) {
        return (FidoCredentialDetails)SafeParcelableSerializer.deserializeFromBytes(arr_b, FidoCredentialDetails.CREATOR);
    }

    // 去混淆评级： 中等(50)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof FidoCredentialDetails ? Objects.equal(this.zza, ((FidoCredentialDetails)object0).zza) && Objects.equal(this.zzb, ((FidoCredentialDetails)object0).zzb) && Arrays.equals(this.zzc, ((FidoCredentialDetails)object0).zzc) && Arrays.equals(this.zzd, ((FidoCredentialDetails)object0).zzd) && this.zze == ((FidoCredentialDetails)object0).zze && this.zzf == ((FidoCredentialDetails)object0).zzf : false;
    }

    public byte[] getCredentialId() {
        return this.zzd;
    }

    public boolean getIsDiscoverable() {
        return this.zze;
    }

    public boolean getIsPaymentCredential() {
        return this.zzf;
    }

    public String getUserDisplayName() {
        return this.zzb;
    }

    public byte[] getUserId() {
        return this.zzc;
    }

    public String getUserName() {
        return this.zza;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb, this.zzc, this.zzd, Boolean.valueOf(this.zze), Boolean.valueOf(this.zzf)});
    }

    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getUserName(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getUserDisplayName(), false);
        SafeParcelWriter.writeByteArray(parcel0, 3, this.getUserId(), false);
        SafeParcelWriter.writeByteArray(parcel0, 4, this.getCredentialId(), false);
        SafeParcelWriter.writeBoolean(parcel0, 5, this.getIsDiscoverable());
        SafeParcelWriter.writeBoolean(parcel0, 6, this.getIsPaymentCredential());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

