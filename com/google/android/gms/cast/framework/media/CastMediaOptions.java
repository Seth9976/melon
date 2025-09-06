package com.google.android.gms.cast.framework.media;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.dynamic.ObjectWrapper;

@Class(creator = "CastMediaOptionsCreator")
@Reserved({1})
public class CastMediaOptions extends AbstractSafeParcelable {
    public static final class Builder {
        private String zza;
        private String zzb;
        private ImagePicker zzc;
        private NotificationOptions zzd;
        private boolean zze;

        public Builder() {
            this.zza = "com.google.android.gms.cast.framework.media.MediaIntentReceiver";
            this.zzd = new com.google.android.gms.cast.framework.media.NotificationOptions.Builder().build();
            this.zze = true;
        }

        public CastMediaOptions build() {
            return this.zzc == null ? new CastMediaOptions(this.zza, this.zzb, null, this.zzd, false, this.zze) : new CastMediaOptions(this.zza, this.zzb, ((IBinder)this.zzc.zza()), this.zzd, false, this.zze);
        }

        public Builder setExpandedControllerActivityClassName(String s) {
            this.zzb = s;
            return this;
        }

        public Builder setImagePicker(ImagePicker imagePicker0) {
            this.zzc = imagePicker0;
            return this;
        }

        public Builder setMediaIntentReceiverClassName(String s) {
            this.zza = s;
            return this;
        }

        public Builder setMediaSessionEnabled(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setNotificationOptions(NotificationOptions notificationOptions0) {
            this.zzd = notificationOptions0;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    private static final Logger zza;
    @Field(getter = "getMediaIntentReceiverClassName", id = 2)
    private final String zzb;
    @Field(getter = "getExpandedControllerActivityClassName", id = 3)
    private final String zzc;
    @Field(getter = "getImagePickerAsBinder", id = 4, type = "android.os.IBinder")
    private final zzd zzd;
    @Field(getter = "getNotificationOptions", id = 5)
    private final NotificationOptions zze;
    @Field(getter = "getDisableRemoteControlNotification", id = 6)
    private final boolean zzf;
    @Field(getter = "getMediaSessionEnabled", id = 7)
    private final boolean zzg;

    static {
        CastMediaOptions.zza = new Logger("CastMediaOptions");
        CastMediaOptions.CREATOR = new zza();
    }

    @Constructor
    public CastMediaOptions(@Param(id = 2) String s, @Param(id = 3) String s1, @Param(id = 4) IBinder iBinder0, @Param(id = 5) NotificationOptions notificationOptions0, @Param(id = 6) boolean z, @Param(id = 7) boolean z1) {
        zzd zzd0;
        this.zzb = s;
        this.zzc = s1;
        if(iBinder0 == null) {
            zzd0 = null;
        }
        else {
            IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.framework.media.IImagePicker");
            zzd0 = iInterface0 instanceof zzd ? ((zzd)iInterface0) : new zzb(iBinder0);
        }
        this.zzd = zzd0;
        this.zze = notificationOptions0;
        this.zzf = z;
        this.zzg = z1;
    }

    public String getExpandedControllerActivityClassName() {
        return this.zzc;
    }

    public ImagePicker getImagePicker() {
        zzd zzd0 = this.zzd;
        if(zzd0 != null) {
            try {
                return (ImagePicker)ObjectWrapper.unwrap(zzd0.zzg());
            }
            catch(RemoteException remoteException0) {
                CastMediaOptions.zza.d(remoteException0, "Unable to call %s on %s.", new Object[]{"getWrappedClientObject", "zzd"});
            }
        }
        return null;
    }

    public String getMediaIntentReceiverClassName() {
        return this.zzb;
    }

    public boolean getMediaSessionEnabled() {
        return this.zzg;
    }

    public NotificationOptions getNotificationOptions() {
        return this.zze;
    }

    @Override  // android.os.Parcelable
    public void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getMediaIntentReceiverClassName(), false);
        SafeParcelWriter.writeString(parcel0, 3, this.getExpandedControllerActivityClassName(), false);
        SafeParcelWriter.writeIBinder(parcel0, 4, (this.zzd == null ? null : this.zzd.asBinder()), false);
        SafeParcelWriter.writeParcelable(parcel0, 5, this.getNotificationOptions(), v, false);
        SafeParcelWriter.writeBoolean(parcel0, 6, this.zzf);
        SafeParcelWriter.writeBoolean(parcel0, 7, this.getMediaSessionEnabled());
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @ShowFirstParty
    public final boolean zza() {
        return this.zzf;
    }
}

