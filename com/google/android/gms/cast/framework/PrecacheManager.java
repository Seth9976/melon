package com.google.android.gms.cast.framework;

import com.google.android.gms.cast.framework.media.RemoteMediaClient;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.cast.internal.zzf;
import com.google.android.gms.cast.internal.zzn;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.internal.cast.zzp;
import com.google.android.gms.internal.cast.zzpb;

public class PrecacheManager {
    private final Logger zza;
    private final CastOptions zzb;
    private final SessionManager zzc;
    private final zzn zzd;

    public PrecacheManager(CastOptions castOptions0, SessionManager sessionManager0, zzn zzn0) {
        this.zza = new Logger("PrecacheManager");
        this.zzb = castOptions0;
        this.zzc = sessionManager0;
        this.zzd = zzn0;
    }

    public void precache(String s) {
        zzp.zzd(zzpb.zzr);
        Session session0 = this.zzc.getCurrentSession();
        if(s == null) {
            throw new IllegalArgumentException("No precache data found to be precached");
        }
        if(session0 == null) {
            TaskApiCall taskApiCall0 = TaskApiCall.builder().setMethodKey(0x20E7).run(new zzf(this.zzd, new String[]{this.zzb.getReceiverApplicationId()}, s, null)).build();
            this.zzd.doWrite(taskApiCall0);
            return;
        }
        if(session0 instanceof CastSession) {
            RemoteMediaClient remoteMediaClient0 = ((CastSession)session0).getRemoteMediaClient();
            if(remoteMediaClient0 != null) {
                remoteMediaClient0.zzg(s, null);
                return;
            }
            this.zza.e("Failed to get RemoteMediaClient from current cast session.", new Object[0]);
            return;
        }
        this.zza.e("Current session is not a CastSession. Precache is not supported.", new Object[0]);
    }
}

