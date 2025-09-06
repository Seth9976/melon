package com.google.android.gms.cast.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.cast.zzav;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.ApiMetadata;
import com.google.android.gms.common.api.ComplianceOptions;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;

public final class zzy extends GmsClient {
    private static final Logger zze;
    private final CastDevice zzf;
    private final long zzg;
    private final Bundle zzh;
    private final String zzi;

    static {
        zzy.zze = new Logger("CastClientImplCxless");
    }

    public zzy(Context context0, Looper looper0, ClientSettings clientSettings0, CastDevice castDevice0, long v, Bundle bundle0, String s, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0) {
        super(context0, looper0, 10, clientSettings0, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0);
        this.zzf = castDevice0;
        this.zzg = v;
        this.zzh = bundle0;
        this.zzi = s;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder0) {
        if(iBinder0 == null) {
            return null;
        }
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.cast.internal.ICastDeviceController");
        return iInterface0 instanceof zzah ? ((zzah)iInterface0) : new zzah(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final void disconnect() {
        try {
            ((zzah)this.getService()).zzf(ApiMetadata.fromComplianceOptions(ComplianceOptions.newBuilder(this.getContext()).build()));
        }
        catch(RemoteException | IllegalStateException remoteException0) {
            zzy.zze.d(remoteException0, "Error while disconnecting the controller interface", new Object[0]);
        }
        finally {
            super.disconnect();
        }
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final Feature[] getApiFeatures() {
        return zzav.zzo;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final Bundle getGetServiceRequestExtraArgs() {
        Bundle bundle0 = new Bundle();
        zzy.zze.d("getRemoteService()", new Object[0]);
        this.zzf.putInBundle(bundle0);
        bundle0.putLong("com.google.android.gms.cast.EXTRA_CAST_FLAGS", this.zzg);
        bundle0.putString("connectionless_client_record_id", this.zzi);
        Bundle bundle1 = this.zzh;
        if(bundle1 != null) {
            bundle0.putAll(bundle1);
        }
        return bundle0;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 19390000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final String getServiceDescriptor() {
        return "com.google.android.gms.cast.internal.ICastDeviceController";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final String getStartServiceAction() {
        return "com.google.android.gms.cast.service.BIND_CAST_DEVICE_CONTROLLER_SERVICE";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }
}

