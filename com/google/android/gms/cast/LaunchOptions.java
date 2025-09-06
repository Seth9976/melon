package com.google.android.gms.cast;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import androidx.appcompat.app.o;
import b3.Z;
import com.google.android.gms.cast.internal.CastUtils;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import java.util.Locale;

@Class(creator = "LaunchOptionsCreator")
@Reserved({1})
public class LaunchOptions extends AbstractSafeParcelable {
    public static final class Builder {
        private final LaunchOptions zza;

        public Builder() {
            this.zza = new LaunchOptions();
        }

        public Builder(LaunchOptions launchOptions0) {
            this.zza = new LaunchOptions(launchOptions0.getRelaunchIfRunning(), launchOptions0.getLanguage(), launchOptions0.getAndroidReceiverCompatible(), launchOptions0.getCredentialsData());
        }

        public LaunchOptions build() {
            return this.zza;
        }

        public Builder setAndroidReceiverCompatible(boolean z) {
            this.zza.zzb(z);
            return this;
        }

        public Builder setCredentialsData(CredentialsData credentialsData0) {
            this.zza.zzd = credentialsData0;
            return this;
        }

        public Builder setLocale(Locale locale0) {
            String s = CastUtils.zzb(locale0);
            this.zza.setLanguage(s);
            return this;
        }

        public Builder setRelaunchIfRunning(boolean z) {
            this.zza.setRelaunchIfRunning(z);
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getRelaunchIfRunning", id = 2)
    private boolean zza;
    @Field(getter = "getLanguage", id = 3)
    private String zzb;
    @Field(getter = "getAndroidReceiverCompatible", id = 4)
    private boolean zzc;
    @Field(getter = "getCredentialsData", id = 5)
    private CredentialsData zzd;

    static {
        LaunchOptions.CREATOR = new zzbu();
    }

    public LaunchOptions() {
        this(false, CastUtils.zzb(Locale.getDefault()), false, null);
    }

    @Constructor
    public LaunchOptions(@Param(id = 2) boolean z, @Param(id = 3) String s, @Param(id = 4) boolean z1, @Param(id = 5) CredentialsData credentialsData0) {
        this.zza = z;
        this.zzb = s;
        this.zzc = z1;
        this.zzd = credentialsData0;
    }

    @Override
    public boolean equals(Object object0) {
        if(object0 == this) {
            return true;
        }
        return object0 instanceof LaunchOptions ? this.zza == ((LaunchOptions)object0).zza && CastUtils.zze(this.zzb, ((LaunchOptions)object0).zzb) && this.zzc == ((LaunchOptions)object0).zzc && CastUtils.zze(this.zzd, ((LaunchOptions)object0).zzd) : false;
    }

    public boolean getAndroidReceiverCompatible() {
        return this.zzc;
    }

    public CredentialsData getCredentialsData() {
        return this.zzd;
    }

    public String getLanguage() {
        return this.zzb;
    }

    public boolean getRelaunchIfRunning() {
        return this.zza;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(new Object[]{Boolean.valueOf(this.zza), this.zzb, Boolean.valueOf(this.zzc), this.zzd});
    }

    public void setLanguage(String s) {
        this.zzb = s;
    }

    public void setRelaunchIfRunning(boolean z) {
        this.zza = z;
    }

    @Override
    public String toString() {
        boolean z = this.zzc;
        return o.s(Z.p("LaunchOptions(relaunchIfRunning=", ", language=", this.zzb, ", androidReceiverCompatible: ", this.zza), z, ")");
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeBoolean(parcel0, 2, this.getRelaunchIfRunning());
        SafeParcelWriter.writeString(parcel0, 3, this.getLanguage(), false);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.getAndroidReceiverCompatible());
        SafeParcelWriter.writeParcelable(parcel0, 5, this.getCredentialsData(), v, false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    public final void zzb(boolean z) {
        this.zzc = z;
    }
}

