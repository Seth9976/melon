package com.google.android.gms.internal.auth-api-phone;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.GmsClient;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

public final class zzae extends GmsClient {
    public zzae(@NotNull Context context0, @NotNull Looper looper0, @NotNull ClientSettings clientSettings0, @NotNull ConnectionCallbacks connectionCallbacks0, @NotNull OnConnectionFailedListener onConnectionFailedListener0) {
        q.g(context0, "context");
        q.g(looper0, "looper");
        q.g(clientSettings0, "clientSettings");
        q.g(connectionCallbacks0, "connectionCallbacks");
        q.g(onConnectionFailedListener0, "connectionFailedListener");
        super(context0, looper0, 411, clientSettings0, connectionCallbacks0, onConnectionFailedListener0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final IInterface createServiceInterface(IBinder iBinder0) {
        q.g(iBinder0, "iBinder");
        IInterface iInterface0 = iBinder0.queryLocalInterface("com.google.android.gms.auth.api.phone.internal.IMissedCallRetrieverService");
        return iInterface0 instanceof zzh ? ((zzh)iInterface0) : new zzh(iBinder0);
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    @NotNull
    public final Feature[] getApiFeatures() {
        q.f(zzal.zzf, "ALL_FEATURES");
        return zzal.zzf;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient, com.google.android.gms.common.api.Api$Client
    public final int getMinApkVersion() {
        return 244000000;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    @NotNull
    public final String getServiceDescriptor() {
        return "com.google.android.gms.auth.api.phone.internal.IMissedCallRetrieverService";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    @NotNull
    public final String getStartServiceAction() {
        return "com.google.android.gms.auth.api.phone.service.MissedCallRetrieverService.START";
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean getUseDynamicLookup() {
        return true;
    }

    @Override  // com.google.android.gms.common.internal.BaseGmsClient
    public final boolean usesClientTelemetry() {
        return true;
    }
}

