package com.google.android.gms.auth.api.identity;

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

@Class(creator = "SignInPasswordCreator")
@Deprecated
public class SignInPassword extends AbstractSafeParcelable {
    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getId", id = 1)
    private final String zba;
    @Field(getter = "getPassword", id = 2)
    private final String zbb;

    static {
        SignInPassword.CREATOR = new zbt();
    }

    @Constructor
    public SignInPassword(@Param(id = 1) String s, @Param(id = 2) String s1) {
        this.zba = Preconditions.checkNotEmpty(((String)Preconditions.checkNotNull(s, "Account identifier cannot be null")).trim(), "Account identifier cannot be empty");
        this.zbb = Preconditions.checkNotEmpty(s1);
    }

    // 去混淆评级： 低(30)
    @Override
    public boolean equals(Object object0) {
        return object0 instanceof SignInPassword ? Objects.equal(this.zba, ((SignInPassword)object0).zba) && Objects.equal(this.zbb, ((SignInPassword)object0).zbb) : false;
    }

    public String getId() {
        return this.zba;
    }

    public String getPassword() {
        return this.zbb;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{this.zba, this.zbb});
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 1, this.getId(), false);
        SafeParcelWriter.writeString(parcel0, 2, this.getPassword(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

