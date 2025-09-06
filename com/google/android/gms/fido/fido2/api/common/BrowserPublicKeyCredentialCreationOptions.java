package com.google.android.gms.fido.fido2.api.common;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

@Class(creator = "BrowserPublicKeyCredentialCreationOptionsCreator")
@Reserved({1})
public class BrowserPublicKeyCredentialCreationOptions extends BrowserRequestOptions {
    public static final class Builder {
        private PublicKeyCredentialCreationOptions zza;
        private Uri zzb;
        private byte[] zzc;

        public BrowserPublicKeyCredentialCreationOptions build() {
            return new BrowserPublicKeyCredentialCreationOptions(this.zza, this.zzb, this.zzc);
        }

        public Builder setClientDataHash(byte[] arr_b) {
            BrowserPublicKeyCredentialCreationOptions.zzb(arr_b);
            this.zzc = arr_b;
            return this;
        }

        public Builder setOrigin(Uri uri0) {
            BrowserPublicKeyCredentialCreationOptions.zza(uri0);
            this.zzb = uri0;
            return this;
        }

        public Builder setPublicKeyCredentialCreationOptions(PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions0) {
            this.zza = publicKeyCredentialCreationOptions0;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getPublicKeyCredentialCreationOptions", id = 2)
    private final PublicKeyCredentialCreationOptions zza;
    @Field(getter = "getOrigin", id = 3)
    private final Uri zzb;
    @Field(getter = "getClientDataHash", id = 4)
    private final byte[] zzc;

    static {
        BrowserPublicKeyCredentialCreationOptions.CREATOR = new zzn();
    }

    @Constructor
    public BrowserPublicKeyCredentialCreationOptions(@Param(id = 2) PublicKeyCredentialCreationOptions publicKeyCredentialCreationOptions0, @Param(id = 3) Uri uri0, @Param(id = 4) byte[] arr_b) {
        this.zza = (PublicKeyCredentialCreationOptions)Preconditions.checkNotNull(publicKeyCredentialCreationOptions0);
        BrowserPublicKeyCredentialCreationOptions.zzc(uri0);
        this.zzb = uri0;
        BrowserPublicKeyCredentialCreationOptions.zzd(arr_b);
        this.zzc = arr_b;
    }

    public static BrowserPublicKeyCredentialCreationOptions deserializeFromBytes(byte[] arr_b) {
        return (BrowserPublicKeyCredentialCreationOptions)SafeParcelableSerializer.deserializeFromBytes(arr_b, BrowserPublicKeyCredentialCreationOptions.CREATOR);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof BrowserPublicKeyCredentialCreationOptions ? Objects.equal(this.zza, ((BrowserPublicKeyCredentialCreationOptions)object0).zza) && Objects.equal(this.zzb, ((BrowserPublicKeyCredentialCreationOptions)object0).zzb) : false;
    }

    @Override  // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public AuthenticationExtensions getAuthenticationExtensions() {
        return this.zza.getAuthenticationExtensions();
    }

    @Override  // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public byte[] getChallenge() {
        return this.zza.getChallenge();
    }

    @Override  // com.google.android.gms.fido.fido2.api.common.BrowserRequestOptions
    public byte[] getClientDataHash() {
        return this.zzc;
    }

    @Override  // com.google.android.gms.fido.fido2.api.common.BrowserRequestOptions
    public Uri getOrigin() {
        return this.zzb;
    }

    public PublicKeyCredentialCreationOptions getPublicKeyCredentialCreationOptions() {
        return this.zza;
    }

    @Override  // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public Integer getRequestId() {
        return this.zza.getRequestId();
    }

    @Override  // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public Double getTimeoutSeconds() {
        return this.zza.getTimeoutSeconds();
    }

    @Override  // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public TokenBinding getTokenBinding() {
        return this.zza.getTokenBinding();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zza, this.zzb});
    }

    @Override  // com.google.android.gms.fido.fido2.api.common.RequestOptions
    public byte[] serializeToBytes() {
        return SafeParcelableSerializer.serializeToBytes(this);
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeParcelable(parcel0, 2, this.getPublicKeyCredentialCreationOptions(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 3, this.getOrigin(), v, false);
        SafeParcelWriter.writeByteArray(parcel0, 4, this.getClientDataHash(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public static Uri zza(Uri uri0) {
        BrowserPublicKeyCredentialCreationOptions.zzc(uri0);
        return uri0;
    }

    public static byte[] zzb(byte[] arr_b) {
        BrowserPublicKeyCredentialCreationOptions.zzd(arr_b);
        return arr_b;
    }

    private static Uri zzc(Uri uri0) {
        Preconditions.checkNotNull(uri0);
        boolean z = false;
        Preconditions.checkArgument(uri0.getScheme() != null, "origin scheme must be non-empty");
        if(uri0.getAuthority() != null) {
            z = true;
        }
        Preconditions.checkArgument(z, "origin authority must be non-empty");
        return uri0;
    }

    private static byte[] zzd(byte[] arr_b) {
        Preconditions.checkArgument(arr_b == null || arr_b.length == 0x20, "clientDataHash must be 32 bytes long");
        return arr_b;
    }
}

