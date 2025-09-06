package com.google.android.gms.cast;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.cast.internal.zzal;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;

public final class Cast {
    public interface ApplicationConnectionResult extends Result {
        ApplicationMetadata getApplicationMetadata();

        String getApplicationStatus();

        String getSessionId();

        boolean getWasLaunched();
    }

    @Deprecated
    public interface CastApi {
        int getActiveInputState(GoogleApiClient arg1);

        ApplicationMetadata getApplicationMetadata(GoogleApiClient arg1);

        String getApplicationStatus(GoogleApiClient arg1);

        int getStandbyState(GoogleApiClient arg1);

        double getVolume(GoogleApiClient arg1);

        boolean isMute(GoogleApiClient arg1);

        PendingResult joinApplication(GoogleApiClient arg1);

        PendingResult joinApplication(GoogleApiClient arg1, String arg2);

        PendingResult joinApplication(GoogleApiClient arg1, String arg2, String arg3);

        PendingResult launchApplication(GoogleApiClient arg1, String arg2);

        PendingResult launchApplication(GoogleApiClient arg1, String arg2, LaunchOptions arg3);

        @Deprecated
        PendingResult launchApplication(GoogleApiClient arg1, String arg2, boolean arg3);

        PendingResult leaveApplication(GoogleApiClient arg1);

        void removeMessageReceivedCallbacks(GoogleApiClient arg1, String arg2);

        void requestStatus(GoogleApiClient arg1);

        PendingResult sendMessage(GoogleApiClient arg1, String arg2, String arg3);

        void setMessageReceivedCallbacks(GoogleApiClient arg1, String arg2, MessageReceivedCallback arg3);

        void setMute(GoogleApiClient arg1, boolean arg2);

        void setVolume(GoogleApiClient arg1, double arg2);

        PendingResult stopApplication(GoogleApiClient arg1);

        PendingResult stopApplication(GoogleApiClient arg1, String arg2);
    }

    public static final class CastOptions implements HasOptions {
        public static final class Builder {
            final CastDevice zza;
            final Listener zzb;
            private int zzc;
            private Bundle zzd;

            public Builder(CastDevice castDevice0, Listener cast$Listener0) {
                Preconditions.checkNotNull(castDevice0, "CastDevice parameter cannot be null");
                Preconditions.checkNotNull(cast$Listener0, "CastListener parameter cannot be null");
                this.zza = castDevice0;
                this.zzb = cast$Listener0;
                this.zzc = 0;
            }

            public CastOptions build() {
                return new CastOptions(this, null);
            }

            public Builder setVerboseLoggingEnabled(boolean z) {
                this.zzc = z;
                return this;
            }

            public static int zza(Builder cast$CastOptions$Builder0) {
                return cast$CastOptions$Builder0.zzc;
            }

            public static Bundle zzb(Builder cast$CastOptions$Builder0) {
                return cast$CastOptions$Builder0.zzd;
            }

            public final Builder zzc(Bundle bundle0) {
                this.zzd = bundle0;
                return this;
            }
        }

        final CastDevice zza;
        final Listener zzb;
        final Bundle zzc;
        final int zzd;
        final String zze;

        public CastOptions(Builder cast$CastOptions$Builder0, zzp zzp0) {
            this.zza = cast$CastOptions$Builder0.zza;
            this.zzb = cast$CastOptions$Builder0.zzb;
            this.zzd = Builder.zza(cast$CastOptions$Builder0);
            this.zzc = Builder.zzb(cast$CastOptions$Builder0);
            this.zze = "03d100ab-53ca-4c58-ab2b-0fd4755bf522";
        }

        @Deprecated
        public static Builder builder(CastDevice castDevice0, Listener cast$Listener0) {
            return new Builder(castDevice0, cast$Listener0);
        }

        @Override
        public boolean equals(Object object0) {
            if(object0 == this) {
                return true;
            }
            return object0 instanceof CastOptions ? Objects.equal(this.zza, ((CastOptions)object0).zza) && Objects.checkBundlesEquality(this.zzc, ((CastOptions)object0).zzc) && this.zzd == ((CastOptions)object0).zzd && Objects.equal(this.zze, ((CastOptions)object0).zze) : false;
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(new Object[]{this.zza, this.zzc, this.zzd, this.zze});
        }
    }

    public static class Listener {
        public void onActiveInputStateChanged(int v) {
        }

        public void onApplicationDisconnected(int v) {
        }

        public void onApplicationMetadataChanged(ApplicationMetadata applicationMetadata0) {
        }

        public void onApplicationStatusChanged() {
        }

        public void onDeviceNameChanged() {
        }

        public void onStandbyStateChanged(int v) {
        }

        public void onVolumeChanged() {
        }
    }

    public interface MessageReceivedCallback {
        void onMessageReceived(CastDevice arg1, String arg2, String arg3);
    }

    public static final int ACTIVE_INPUT_STATE_NO = 0;
    public static final int ACTIVE_INPUT_STATE_UNKNOWN = -1;
    public static final int ACTIVE_INPUT_STATE_YES = 1;
    public static final Api API = null;
    public static final CastApi CastApi = null;
    public static final String EXTRA_APP_NO_LONGER_RUNNING = "com.google.android.gms.cast.EXTRA_APP_NO_LONGER_RUNNING";
    public static final int MAX_MESSAGE_LENGTH = 0x10000;
    public static final int MAX_NAMESPACE_LENGTH = 0x80;
    public static final int STANDBY_STATE_NO = 0;
    public static final int STANDBY_STATE_UNKNOWN = -1;
    public static final int STANDBY_STATE_YES = 1;
    static final AbstractClientBuilder zza;

    static {
        zze zze0 = new zze();
        Cast.zza = zze0;
        Cast.API = new Api("Cast.API", zze0, zzal.zza);
        Cast.CastApi = new zzm();
    }

    @ShowFirstParty
    public static zzr zza(Context context0, CastOptions cast$CastOptions0) {
        return new zzbr(context0, cast$CastOptions0);
    }
}

