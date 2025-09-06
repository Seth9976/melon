package com.google.android.gms.cast;

import android.os.RemoteException;
import com.google.android.gms.cast.internal.zzal;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.internal.ShowFirstParty;
import java.io.IOException;

public final class zzm implements CastApi {
    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final int getActiveInputState(GoogleApiClient googleApiClient0) {
        return ((zzx)googleApiClient0.getClient(zzal.zza)).zzr();
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final ApplicationMetadata getApplicationMetadata(GoogleApiClient googleApiClient0) {
        return ((zzx)googleApiClient0.getClient(zzal.zza)).zzt();
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final String getApplicationStatus(GoogleApiClient googleApiClient0) {
        return ((zzx)googleApiClient0.getClient(zzal.zza)).zzz();
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final int getStandbyState(GoogleApiClient googleApiClient0) {
        return ((zzx)googleApiClient0.getClient(zzal.zza)).zzs();
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final double getVolume(GoogleApiClient googleApiClient0) {
        return ((zzx)googleApiClient0.getClient(zzal.zza)).zzq();
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final boolean isMute(GoogleApiClient googleApiClient0) {
        return ((zzx)googleApiClient0.getClient(zzal.zza)).zzX();
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final PendingResult joinApplication(GoogleApiClient googleApiClient0) {
        return this.zza(googleApiClient0, null, null, null);
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final PendingResult joinApplication(GoogleApiClient googleApiClient0, String s) {
        return this.zza(googleApiClient0, s, null, null);
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final PendingResult joinApplication(GoogleApiClient googleApiClient0, String s, String s1) {
        return this.zza(googleApiClient0, s, s1, null);
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final PendingResult launchApplication(GoogleApiClient googleApiClient0, String s) {
        return googleApiClient0.execute(new zzg(this, googleApiClient0, s));
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final PendingResult launchApplication(GoogleApiClient googleApiClient0, String s, LaunchOptions launchOptions0) {
        return googleApiClient0.execute(new zzh(this, googleApiClient0, s, launchOptions0));
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    @Deprecated
    public final PendingResult launchApplication(GoogleApiClient googleApiClient0, String s, boolean z) {
        Builder launchOptions$Builder0 = new Builder();
        launchOptions$Builder0.setRelaunchIfRunning(z);
        return googleApiClient0.execute(new zzh(this, googleApiClient0, s, launchOptions$Builder0.build()));
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final PendingResult leaveApplication(GoogleApiClient googleApiClient0) {
        return googleApiClient0.execute(new zzj(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final void removeMessageReceivedCallbacks(GoogleApiClient googleApiClient0, String s) {
        try {
            ((zzx)googleApiClient0.getClient(zzal.zza)).zzO(s);
        }
        catch(RemoteException unused_ex) {
            throw new IOException("service error");
        }
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final void requestStatus(GoogleApiClient googleApiClient0) {
        try {
            ((zzx)googleApiClient0.getClient(zzal.zza)).zzP();
        }
        catch(RemoteException unused_ex) {
            throw new IOException("service error");
        }
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final PendingResult sendMessage(GoogleApiClient googleApiClient0, String s, String s1) {
        return googleApiClient0.execute(new zzf(this, googleApiClient0, s, s1));
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final void setMessageReceivedCallbacks(GoogleApiClient googleApiClient0, String s, MessageReceivedCallback cast$MessageReceivedCallback0) {
        try {
            ((zzx)googleApiClient0.getClient(zzal.zza)).zzS(s, cast$MessageReceivedCallback0);
        }
        catch(RemoteException unused_ex) {
            throw new IOException("service error");
        }
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final void setMute(GoogleApiClient googleApiClient0, boolean z) {
        try {
            ((zzx)googleApiClient0.getClient(zzal.zza)).zzT(z);
        }
        catch(RemoteException unused_ex) {
            throw new IOException("service error");
        }
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final void setVolume(GoogleApiClient googleApiClient0, double f) {
        try {
            ((zzx)googleApiClient0.getClient(zzal.zza)).zzU(f);
        }
        catch(RemoteException unused_ex) {
            throw new IOException("service error");
        }
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final PendingResult stopApplication(GoogleApiClient googleApiClient0) {
        return googleApiClient0.execute(new zzk(this, googleApiClient0));
    }

    @Override  // com.google.android.gms.cast.Cast$CastApi
    public final PendingResult stopApplication(GoogleApiClient googleApiClient0, String s) {
        return googleApiClient0.execute(new zzl(this, googleApiClient0, s));
    }

    @ShowFirstParty
    public final PendingResult zza(GoogleApiClient googleApiClient0, String s, String s1, zzbs zzbs0) {
        return googleApiClient0.execute(new zzi(this, googleApiClient0, s, s1, null));
    }
}

