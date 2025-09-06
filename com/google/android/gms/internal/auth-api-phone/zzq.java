package com.google.android.gms.internal.auth-api-phone;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import kotlin.jvm.internal.q;

public final class zzq extends AbstractClientBuilder {
    @Override  // com.google.android.gms.common.api.Api$AbstractClientBuilder
    public final Client buildClient(Context context0, Looper looper0, ClientSettings clientSettings0, Object object0, ConnectionCallbacks connectionCallbacks0, OnConnectionFailedListener onConnectionFailedListener0) {
        q.g(context0, "context");
        q.g(looper0, "looper");
        q.g(clientSettings0, "commonSettings");
        q.g(((NoOptions)object0), "apiOptions");
        q.g(connectionCallbacks0, "connectedListener");
        q.g(onConnectionFailedListener0, "connectionFailedListener");
        return new zzae(context0, looper0, clientSettings0, connectionCallbacks0, onConnectionFailedListener0);
    }
}

