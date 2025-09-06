package com.google.android.gms.auth.api.identity;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import java.util.List;

@Class(creator = "AuthorizationResultCreator")
public final class AuthorizationResult extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getServerAuthCode", id = 1)
    private final String zba;
    @Field(getter = "getAccessToken", id = 2)
    private final String zbb;
    @Field(getter = "getIdToken", id = 3)
    private final String zbc;
    @Field(getter = "getGrantedScopes", id = 4)
    private final List zbd;
    @Field(getter = "toGoogleSignInAccount", id = 5)
    private final GoogleSignInAccount zbe;
    @Field(getter = "getPendingIntent", id = 6)
    private final PendingIntent zbf;

    static {
        AuthorizationResult.CREATOR = new zbc();
    }

    @Constructor
    public AuthorizationResult(@Param(id = 1) String s, @Param(id = 2) String s1, @Param(id = 3) String s2, @Param(id = 4) List list0, @Param(id = 5) GoogleSignInAccount googleSignInAccount0, @Param(id = 6) PendingIntent pendingIntent0) {
        this.zba = s;
        this.zbb = s1;
        this.zbc = s2;
        this.zbd = (List)Preconditions.checkNotNull(list0);
        this.zbf = pendingIntent0;
        this.zbe = googleSignInAccount0;
    }

    // 去混淆评级： 中等(70)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof AuthorizationResult ? Objects.equal(this.zba, ((AuthorizationResult)object0).zba) && Objects.equal(this.zbb, ((AuthorizationResult)object0).zbb) && Objects.equal(this.zbc, ((AuthorizationResult)object0).zbc) && Objects.equal(this.zbd, ((AuthorizationResult)object0).zbd) && Objects.equal(this.zbf, ((AuthorizationResult)object0).zbf) && Objects.equal(this.zbe, ((AuthorizationResult)object0).zbe) : false;
    }

    public String getAccessToken() {
        return this.zbb;
    }

    public List getGrantedScopes() {
        return this.zbd;
    }

    public PendingIntent getPendingIntent() {
        return this.zbf;
    }

    public String getServerAuthCode() {
        return this.zba;
    }

    public boolean hasResolution() {
        return this.zbf != null;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zba, this.zbb, this.zbc, this.zbd, this.zbf, this.zbe});
    }

    public GoogleSignInAccount toGoogleSignInAccount() {
        return this.zbe;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getServerAuthCode(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getAccessToken(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.zbc, false);
        SafeParcelWriter.writeStringList(parcel0, 4, this.getGrantedScopes(), false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.toGoogleSignInAccount(), v, false);
        SafeParcelWriter.writeParcelable(parcel0, 6, this.getPendingIntent(), v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

