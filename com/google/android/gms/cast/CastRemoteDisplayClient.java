package com.google.android.gms.cast;

import U4.x;
import android.app.PendingIntent;
import android.content.Context;
import android.hardware.display.VirtualDisplay;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzal;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi.Settings;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.tasks.Task;

@Deprecated
public class CastRemoteDisplayClient extends GoogleApi {
    private static final AbstractClientBuilder zza;
    private static final Api zzb;
    private final Logger zzc;
    private VirtualDisplay zzd;

    static {
        zzaa zzaa0 = new zzaa();
        CastRemoteDisplayClient.zza = zzaa0;
        CastRemoteDisplayClient.zzb = new Api("CastRemoteDisplay.API", zzaa0, zzal.zzd);
    }

    public CastRemoteDisplayClient(Context context0) {
        super(context0, CastRemoteDisplayClient.zzb, ApiOptions.NO_OPTIONS, Settings.DEFAULT_SETTINGS);
        this.zzc = new Logger("CastRemoteDisplay");
    }

    public Task startRemoteDisplay(CastDevice castDevice0, String s, @Configuration int v, PendingIntent pendingIntent0) {
        return this.zze(castDevice0, s, v, pendingIntent0, null);
    }

    public Task stopRemoteDisplay() {
        return this.doWrite(TaskApiCall.builder().setMethodKey(8402).run(new zzz(this)).build());
    }

    public static void zzd(CastRemoteDisplayClient castRemoteDisplayClient0) {
        VirtualDisplay virtualDisplay0 = castRemoteDisplayClient0.zzd;
        if(virtualDisplay0 != null) {
            if(virtualDisplay0.getDisplay() != null) {
                String s = x.e(castRemoteDisplayClient0.zzd.getDisplay().getDisplayId(), "releasing virtual display: ");
                castRemoteDisplayClient0.zzc.d(s, new Object[0]);
            }
            VirtualDisplay virtualDisplay1 = castRemoteDisplayClient0.zzd;
            if(virtualDisplay1 != null) {
                virtualDisplay1.release();
                castRemoteDisplayClient0.zzd = null;
            }
        }
    }

    public final Task zze(CastDevice castDevice0, String s, @Configuration int v, PendingIntent pendingIntent0, zzak zzak0) {
        return this.doWrite(TaskApiCall.builder().setMethodKey(8401).run(new zzy(this, v, zzak0, pendingIntent0, castDevice0, s)).build());
    }
}

