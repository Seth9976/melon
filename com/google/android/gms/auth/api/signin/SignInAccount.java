package com.google.android.gms.auth.api.signin;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "SignInAccountCreator")
@Reserved({1})
public class SignInAccount extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(defaultValue = "", id = 4)
    @Deprecated
    final String zba;
    @Field(defaultValue = "", id = 8)
    @Deprecated
    final String zbb;
    @Field(getter = "getGoogleSignInAccount", id = 7)
    private final GoogleSignInAccount zbc;

    static {
        SignInAccount.CREATOR = new zbc();
    }

    @Constructor
    public SignInAccount(@Param(id = 4) String s, @Param(id = 7) GoogleSignInAccount googleSignInAccount0, @Param(id = 8) String s1) {
        this.zbc = googleSignInAccount0;
        this.zba = Preconditions.checkNotEmpty(s, "8.3 and 8.4 SDKs require non-null email");
        this.zbb = Preconditions.checkNotEmpty(s1, "8.3 and 8.4 SDKs require non-null userId");
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 4, this.zba, false);
        SafeParcelWriter.writeParcelable(parcel0, 7, this.zbc, v, false);
        SafeParcelWriter.writeString(parcel0, 8, this.zbb, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final GoogleSignInAccount zba() {
        return this.zbc;
    }
}

