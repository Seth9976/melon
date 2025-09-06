package com.google.android.gms.cast.framework.media;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;

@Class(creator = "NotificationActionCreator")
@Reserved({1})
public class NotificationAction extends AbstractSafeParcelable {
    public static final class Builder {
        String zza;
        int zzb;
        String zzc;

        public NotificationAction build() {
            return new NotificationAction(this.zza, this.zzb, this.zzc);
        }

        public Builder setAction(String s) {
            if(TextUtils.isEmpty(s)) {
                throw new IllegalArgumentException("action cannot be null or an empty string.");
            }
            this.zza = s;
            return this;
        }

        public Builder setContentDescription(String s) {
            if(TextUtils.isEmpty(s)) {
                throw new IllegalArgumentException("contentDescription cannot be null  or an empty string.");
            }
            this.zzc = s;
            return this;
        }

        public Builder setIconResId(int v) {
            this.zzb = v;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    @Field(getter = "getAction", id = 2)
    private final String zza;
    @Field(getter = "getIconResId", id = 3)
    private final int zzb;
    @Field(getter = "getContentDescription", id = 4)
    private final String zzc;

    static {
        NotificationAction.CREATOR = new zzt();
    }

    @Constructor
    public NotificationAction(@Param(id = 2) String s, @Param(id = 3) int v, @Param(id = 4) String s1) {
        this.zza = s;
        this.zzb = v;
        this.zzc = s1;
    }

    public String getAction() {
        return this.zza;
    }

    public String getContentDescription() {
        return this.zzc;
    }

    public int getIconResId() {
        return this.zzb;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getAction(), false);
        SafeParcelWriter.writeInt(parcel0, 3, this.getIconResId());
        SafeParcelWriter.writeString(parcel0, 4, this.getContentDescription(), false);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }
}

