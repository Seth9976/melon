package com.google.android.gms.cast.framework;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.cast.framework.media.CastMediaOptions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Reserved;
import com.google.android.gms.internal.cast.zzgn;
import com.google.android.gms.internal.cast.zzgo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Class(creator = "CastOptionsCreator")
@Reserved({1})
public class CastOptions extends AbstractSafeParcelable {
    public static final class Builder {
        private String zza;
        private List zzb;
        private boolean zzc;
        private LaunchOptions zzd;
        private boolean zze;
        private zzgn zzf;
        private boolean zzg;
        private double zzh;
        private boolean zzi;
        private final List zzj;
        private boolean zzk;
        private boolean zzl;

        public Builder() {
            this.zzb = new ArrayList();
            this.zzd = new LaunchOptions();
            this.zze = true;
            this.zzf = zzgn.zzb();
            this.zzg = true;
            this.zzh = 0.05;
            this.zzi = false;
            this.zzj = new ArrayList();
            this.zzk = true;
            this.zzl = false;
        }

        public CastOptions build() {
            Object object0 = this.zzf.zza(CastOptions.zzc);
            zzgo.zzc(CastOptions.zza, "use Optional.orNull() instead of Optional.or(null)");
            zzgo.zzc(CastOptions.zzb, "use Optional.orNull() instead of Optional.or(null)");
            return new CastOptions(this.zza, this.zzb, this.zzc, this.zzd, this.zze, ((CastMediaOptions)object0), this.zzg, this.zzh, false, false, this.zzi, this.zzj, this.zzk, 0, false, CastOptions.zza, CastOptions.zzb, false, this.zzl);
        }

        public Builder setCastMediaOptions(CastMediaOptions castMediaOptions0) {
            this.zzf = zzgn.zzc(castMediaOptions0);
            return this;
        }

        public Builder setEnableReconnectionService(boolean z) {
            this.zzg = z;
            return this;
        }

        public Builder setLaunchOptions(LaunchOptions launchOptions0) {
            this.zzd = launchOptions0;
            return this;
        }

        public Builder setMediaTransferRestrictedToSelfProviders(boolean z) {
            this.zzl = z;
            return this;
        }

        public Builder setReceiverApplicationId(String s) {
            this.zza = s;
            return this;
        }

        public Builder setRemoteToLocalEnabled(boolean z) {
            this.zzi = z;
            return this;
        }

        public Builder setResumeSavedSession(boolean z) {
            this.zze = z;
            return this;
        }

        public Builder setSessionTransferEnabled(boolean z) {
            this.zzk = z;
            return this;
        }

        public Builder setStopReceiverApplicationWhenEndingSession(boolean z) {
            this.zzc = z;
            return this;
        }

        public Builder setSupportedNamespaces(List list0) {
            this.zzb = list0;
            return this;
        }

        @Deprecated
        public Builder setVolumeDeltaBeforeIceCreamSandwich(double f) {
            if(f <= 0.0 || f > 0.5) {
                throw new IllegalArgumentException("volumeDelta must be greater than 0 and less or equal to 0.5");
            }
            this.zzh = f;
            return this;
        }
    }

    public static final Parcelable.Creator CREATOR;
    static final zzj zza;
    static final zzl zzb;
    static final CastMediaOptions zzc;
    @Field(getter = "getReceiverApplicationId", id = 2)
    private String zzd;
    @Field(getter = "getSupportedNamespaces", id = 3)
    private final List zze;
    @Field(getter = "getStopReceiverApplicationWhenEndingSession", id = 4)
    private final boolean zzf;
    @Field(getter = "getLaunchOptions", id = 5)
    private LaunchOptions zzg;
    @Field(getter = "getResumeSavedSession", id = 6)
    private final boolean zzh;
    @Field(getter = "getCastMediaOptions", id = 7)
    private final CastMediaOptions zzi;
    @Field(getter = "getEnableReconnectionService", id = 8)
    private final boolean zzj;
    @Field(getter = "getVolumeDeltaBeforeIceCreamSandwich", id = 9)
    private final double zzk;
    @Field(getter = "getEnableIpv6Support", id = 10)
    private final boolean zzl;
    @Field(getter = "getOutputSwitcherEnabled", id = 11)
    private final boolean zzm;
    @Field(getter = "isRemoteToLocalEnabled", id = 12)
    private final boolean zzn;
    @Field(getter = "getRouteDiscoveryReceiverApplicationIds", id = 13)
    private final List zzo;
    @Field(getter = "isSessionTransferEnabled", id = 14)
    private final boolean zzp;
    @Field(getter = "isResumeSessionAfterTransferEnabled", id = 16)
    private final boolean zzq;
    @Field(getter = "getCastExperimentOptions", id = 17)
    private final zzj zzr;
    @Field(getter = "getCastFeatureVersions", id = 18)
    private zzl zzs;
    @Field(getter = "isRemoteToRemoteTransferEnabled", id = 19)
    private final boolean zzt;
    @Field(getter = "isMediaTransferRestrictedToSelfProviders", id = 20)
    private final boolean zzu;

    static {
        CastOptions.zza = new zzj(false);
        CastOptions.zzb = new zzl(0);
        com.google.android.gms.cast.framework.media.CastMediaOptions.Builder castMediaOptions$Builder0 = new com.google.android.gms.cast.framework.media.CastMediaOptions.Builder();
        castMediaOptions$Builder0.setMediaSessionEnabled(false);
        castMediaOptions$Builder0.setNotificationOptions(null);
        CastOptions.zzc = castMediaOptions$Builder0.build();
        CastOptions.CREATOR = new zzn();
    }

    @Constructor
    public CastOptions(@Param(id = 2) String s, @Param(id = 3) List list0, @Param(id = 4) boolean z, @Param(id = 5) LaunchOptions launchOptions0, @Param(id = 6) boolean z1, @Param(id = 7) CastMediaOptions castMediaOptions0, @Param(id = 8) boolean z2, @Param(id = 9) double f, @Param(id = 10) boolean z3, @Param(id = 11) boolean z4, @Param(id = 12) boolean z5, @Param(id = 13) List list1, @Param(id = 14) boolean z6, @Param(id = 15) int v, @Param(id = 16) boolean z7, @Param(id = 17) zzj zzj0, @Param(id = 18) zzl zzl0, @Param(id = 19) boolean z8, @Param(id = 20) boolean z9) {
        if(TextUtils.isEmpty(s)) {
            s = "";
        }
        this.zzd = s;
        int v1 = list0 == null ? 0 : list0.size();
        ArrayList arrayList0 = new ArrayList(v1);
        this.zze = arrayList0;
        if(v1 > 0) {
            arrayList0.addAll(list0);
        }
        this.zzf = z;
        if(launchOptions0 == null) {
            launchOptions0 = new LaunchOptions();
        }
        this.zzg = launchOptions0;
        this.zzh = z1;
        this.zzi = castMediaOptions0;
        this.zzj = z2;
        this.zzk = f;
        this.zzl = z3;
        this.zzm = z4;
        this.zzn = z5;
        this.zzo = list1;
        this.zzp = z6;
        this.zzq = z7;
        this.zzr = zzj0;
        this.zzs = zzl0;
        this.zzt = z8;
        this.zzu = z9;
    }

    public CastMediaOptions getCastMediaOptions() {
        return this.zzi;
    }

    public boolean getEnableReconnectionService() {
        return this.zzj;
    }

    public LaunchOptions getLaunchOptions() {
        return this.zzg;
    }

    public String getReceiverApplicationId() {
        return this.zzd;
    }

    public boolean getResumeSavedSession() {
        return this.zzh;
    }

    public boolean getStopReceiverApplicationWhenEndingSession() {
        return this.zzf;
    }

    public List getSupportedNamespaces() {
        return Collections.unmodifiableList(this.zze);
    }

    @Deprecated
    public double getVolumeDeltaBeforeIceCreamSandwich() {
        return this.zzk;
    }

    @Override  // android.os.Parcelable
    public final void writeToParcel(Parcel parcel0, int v) {
        int v1 = SafeParcelWriter.beginObjectHeader(parcel0);
        SafeParcelWriter.writeString(parcel0, 2, this.getReceiverApplicationId(), false);
        SafeParcelWriter.writeStringList(parcel0, 3, this.getSupportedNamespaces(), false);
        SafeParcelWriter.writeBoolean(parcel0, 4, this.getStopReceiverApplicationWhenEndingSession());
        SafeParcelWriter.writeParcelable(parcel0, 5, this.getLaunchOptions(), v, false);
        SafeParcelWriter.writeBoolean(parcel0, 6, this.getResumeSavedSession());
        SafeParcelWriter.writeParcelable(parcel0, 7, this.getCastMediaOptions(), v, false);
        SafeParcelWriter.writeBoolean(parcel0, 8, this.getEnableReconnectionService());
        SafeParcelWriter.writeDouble(parcel0, 9, this.getVolumeDeltaBeforeIceCreamSandwich());
        SafeParcelWriter.writeBoolean(parcel0, 10, this.zzl);
        SafeParcelWriter.writeBoolean(parcel0, 11, this.zzm);
        SafeParcelWriter.writeBoolean(parcel0, 12, this.zzn);
        SafeParcelWriter.writeStringList(parcel0, 13, Collections.unmodifiableList(this.zzo), false);
        SafeParcelWriter.writeBoolean(parcel0, 14, this.zzp);
        SafeParcelWriter.writeInt(parcel0, 15, 0);
        SafeParcelWriter.writeBoolean(parcel0, 16, this.zzq);
        SafeParcelWriter.writeParcelable(parcel0, 17, this.zzr, v, false);
        SafeParcelWriter.writeParcelable(parcel0, 18, this.zzs, v, false);
        SafeParcelWriter.writeBoolean(parcel0, 19, this.zzt);
        SafeParcelWriter.writeBoolean(parcel0, 20, this.zzu);
        SafeParcelWriter.finishObjectHeader(parcel0, v1);
    }

    @ShowFirstParty
    public final List zza() {
        return Collections.unmodifiableList(this.zzo);
    }

    @ShowFirstParty
    public final void zzb(zzl zzl0) {
        this.zzs = zzl0;
    }

    public final void zzc(LaunchOptions launchOptions0) {
        this.zzg = launchOptions0;
    }

    public final void zzd(String s) {
        this.zzd = s;
    }

    public final boolean zze() {
        return this.zzm;
    }

    public final boolean zzf() {
        return this.zzu;
    }

    public final boolean zzg() {
        return this.zzn;
    }

    public final boolean zzh() {
        return this.zzt;
    }

    public final boolean zzi() {
        return this.zzp;
    }
}

