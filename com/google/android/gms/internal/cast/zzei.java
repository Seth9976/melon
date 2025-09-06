package com.google.android.gms.internal.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder.DeathRecipient;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.CastRemoteDisplay.CastRemoteDisplaySessionCallbacks;
import com.google.android.gms.cast.internal.Logger;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

@Deprecated
public final class zzei extends GmsClient implements IBinder.DeathRecipient {
    private static final Logger zze;
    private final CastRemoteDisplaySessionCallbacks zzf;
    private final CastDevice zzg;
    private final Bundle zzh;

    static {
        zzei.zze = new Logger("CastRemoteDisplayClientImpl");
    }

    public zzei(Context context0, Looper looper0, ClientSettings clientSettings0, CastDevice castDevice0, Bundle bundle0, CastRemoteDisplaySessionCallbacks castRemoteDisplay$CastRemoteDisplaySessionCallbacks0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0) {
        super(context0, looper0, 83, clientSettings0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0);
        zzei.zze.d("instance created", new Object[0]);
        this.zzf = castRemoteDisplay$CastRemoteDisplaySessionCallbacks0;
        this.zzg = castDevice0;
        this.zzh = bundle0;
    }

    @Override  // android.os.IBinder$DeathRecipient
    public final void binderDied() {
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
        return iInterface0 instanceof zzel ? ((zzel)iInterface0) : new zzel(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final void disconnect() {
        zzei.zze.d("disconnect", new Object[0]);
        try {
            ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(this.getContext()).build();
            ((zzel)this.getService()).zze(ApiMetadata.fromComplianceOptions(complianceOptions0));
        }
        catch(RemoteException | IllegalStateException unused_ex) {
        }
        finally {
            super.disconnect();
        }
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 12451000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.remote_display.service.START";
    }

    public final void zzr(zzek zzek0, zzen zzen0, String s) {
        zzei.zze.d("startRemoteDisplay", new Object[0]);
        zzeh zzeh0 = new zzeh(this, zzen0);
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(this.getContext()).build();
        IInterface iInterface0 = this.getService();
        String s1 = this.zzg.getDeviceId();
        ApiMetadata apiMetadata0 = ApiMetadata.fromComplianceOptions(complianceOptions0);
        ((zzel)iInterface0).zzg(zzek0, zzeh0, s1, s, this.zzh, apiMetadata0);
    }

    public final void zzs(zzek zzek0) {
        zzei.zze.d("stopRemoteDisplay", new Object[0]);
        ComplianceOptions complianceOptions0 = ComplianceOptions.newBuilder(this.getContext()).build();
        ((zzel)this.getService()).zzi(zzek0, ApiMetadata.fromComplianceOptions(complianceOptions0));
    }
}

