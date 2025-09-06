package com.google.android.gms.auth.api.identity;

import android.net.Uri;
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
import com.google.android.gms.fido.fido2.api.common.PublicKeyCredential;

@Class(creator = "SignInCredentialCreator")
@Deprecated
public final class SignInCredential extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getId", id = 1)
    private final String zba;
    @Field(getter = "getDisplayName", id = 2)
    private final String zbb;
    @Field(getter = "getGivenName", id = 3)
    private final String zbc;
    @Field(getter = "getFamilyName", id = 4)
    private final String zbd;
    @Field(getter = "getProfilePictureUri", id = 5)
    private final Uri zbe;
    @Field(getter = "getPassword", id = 6)
    private final String zbf;
    @Field(getter = "getGoogleIdToken", id = 7)
    private final String zbg;
    @Field(getter = "getPhoneNumber", id = 8)
    private final String zbh;
    @Field(getter = "getPublicKeyCredential", id = 9)
    private final PublicKeyCredential zbi;

    static {
        SignInCredential.CREATOR = new zbr();
    }

    @Constructor
    public SignInCredential(@Param(id = 1) String s, @Param(id = 2) String s1, @Param(id = 3) String s2, @Param(id = 4) String s3, @Param(id = 5) Uri uri0, @Param(id = 6) String s4, @Param(id = 7) String s5, @Param(id = 8) String s6, @Param(id = 9) PublicKeyCredential publicKeyCredential0) {
        this.zba = (String)Preconditions.checkNotNull(s);
        this.zbb = s1;
        this.zbc = s2;
        this.zbd = s3;
        this.zbe = uri0;
        this.zbf = s4;
        this.zbg = s5;
        this.zbh = s6;
        this.zbi = publicKeyCredential0;
    }

    // 去混淆评级： 中等(100)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof SignInCredential ? Objects.equal(this.zba, ((SignInCredential)object0).zba) && Objects.equal(this.zbb, ((SignInCredential)object0).zbb) && Objects.equal(this.zbc, ((SignInCredential)object0).zbc) && Objects.equal(this.zbd, ((SignInCredential)object0).zbd) && Objects.equal(this.zbe, ((SignInCredential)object0).zbe) && Objects.equal(this.zbf, ((SignInCredential)object0).zbf) && Objects.equal(this.zbg, ((SignInCredential)object0).zbg) && Objects.equal(this.zbh, ((SignInCredential)object0).zbh) && Objects.equal(this.zbi, ((SignInCredential)object0).zbi) : false;
    }

    public String getDisplayName() {
        return this.zbb;
    }

    public String getFamilyName() {
        return this.zbd;
    }

    public String getGivenName() {
        return this.zbc;
    }

    public String getGoogleIdToken() {
        return this.zbg;
    }

    public String getId() {
        return this.zba;
    }

    public String getPassword() {
        return this.zbf;
    }

    @Deprecated
    public String getPhoneNumber() {
        return this.zbh;
    }

    public Uri getProfilePictureUri() {
        return this.zbe;
    }

    public PublicKeyCredential getPublicKeyCredential() {
        return this.zbi;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zba, this.zbb, this.zbc, this.zbd, this.zbe, this.zbf, this.zbg, this.zbh, this.zbi});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getId(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getDisplayName(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getGivenName(), false);
        SafeParcelWriter.writeString(parcel0, 4, this.getFamilyName(), false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.getProfilePictureUri(), v, false);
        SafeParcelWriter.writeString(parcel0, 6, this.getPassword(), false);
        SafeParcelWriter.writeString(parcel0, 7, this.getGoogleIdToken(), false);
        SafeParcelWriter.writeString(parcel0, 8, this.getPhoneNumber(), false);
        SafeParcelWriter.writeParcelable(parcel0, 9, this.getPublicKeyCredential(), v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

