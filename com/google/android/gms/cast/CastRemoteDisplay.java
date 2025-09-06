package com.google.android.gms.cast;

import android.content.Context;
import android.view.Display;
import com.google.android.gms.cast.internal.zzal;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.HasOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.cast.zzef;

@Deprecated
public final class CastRemoteDisplay {
    @Deprecated
    public static final class CastRemoteDisplayOptions implements HasOptions {
        @Deprecated
        public static final class Builder {
            final CastDevice zza;
            final CastRemoteDisplaySessionCallbacks zzb;
            int zzc;

            public Builder(CastDevice castDevice0, CastRemoteDisplaySessionCallbacks castRemoteDisplay$CastRemoteDisplaySessionCallbacks0) {
                Preconditions.checkNotNull(castDevice0, "CastDevice parameter cannot be null");
                this.zza = castDevice0;
                this.zzb = castRemoteDisplay$CastRemoteDisplaySessionCallbacks0;
                this.zzc = 2;
            }

            public CastRemoteDisplayOptions build() {
                return new CastRemoteDisplayOptions(this, null);
            }

            public Builder setConfigPreset(@Configuration int v) {
                this.zzc = v;
                return this;
            }
        }

        final CastDevice zza;
        final CastRemoteDisplaySessionCallbacks zzb;
        final int zzc;

        public CastRemoteDisplayOptions(Builder castRemoteDisplay$CastRemoteDisplayOptions$Builder0, zzx zzx0) {
            this.zza = castRemoteDisplay$CastRemoteDisplayOptions$Builder0.zza;
            this.zzb = castRemoteDisplay$CastRemoteDisplayOptions$Builder0.zzb;
            this.zzc = castRemoteDisplay$CastRemoteDisplayOptions$Builder0.zzc;
        }
    }

    @Deprecated
    public interface CastRemoteDisplaySessionCallbacks {
        void onRemoteDisplayEnded(Status arg1);
    }

    @Deprecated
    public interface CastRemoteDisplaySessionResult extends Result {
        Display getPresentationDisplay();
    }

    public @interface Configuration {
    }

    @Deprecated
    public static final Api API = null;
    public static final int CONFIGURATION_INTERACTIVE_NONREALTIME = 2;
    public static final int CONFIGURATION_INTERACTIVE_REALTIME = 1;
    public static final int CONFIGURATION_NONINTERACTIVE = 3;
    @Deprecated
    public static final CastRemoteDisplayApi CastRemoteDisplayApi = null;
    public static final String EXTRA_INT_SESSION_ENDED_STATUS_CODE = "extra_int_session_ended_status_code";
    private static final AbstractClientBuilder zza;

    static {
        zzw zzw0 = new zzw();
        CastRemoteDisplay.zza = zzw0;
        Api api0 = new Api("CastRemoteDisplay.API", zzw0, zzal.zzc);
        CastRemoteDisplay.API = api0;
        CastRemoteDisplay.CastRemoteDisplayApi = new zzef(api0);
    }

    public static CastRemoteDisplayClient getClient(Context context0) {
        return new CastRemoteDisplayClient(context0);
    }

    @Deprecated
    public static final boolean isRemoteDisplaySdkSupported(Context context0) {
        return false;
    }
}

