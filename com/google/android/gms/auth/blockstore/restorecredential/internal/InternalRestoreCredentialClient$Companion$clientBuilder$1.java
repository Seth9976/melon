package com.google.android.gms.auth.blockstore.restorecredential.internal;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.ApiOptions.NoOptions;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.internal.ConnectionCallbacks;
import com.google.android.gms.common.api.internal.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.q;

@Metadata(d1 = {"\u00005\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001J8\u0010\u0004\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00062\u0006\u0010\u0007\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0016¨\u0006\u0010"}, d2 = {"com/google/android/gms/auth/blockstore/restorecredential/internal/InternalRestoreCredentialClient$Companion$clientBuilder$1", "Lcom/google/android/gms/common/api/Api$AbstractClientBuilder;", "Lcom/google/android/gms/auth/blockstore/restorecredential/internal/RestoreCredentialClientImpl;", "Lcom/google/android/gms/common/api/Api$ApiOptions$NoOptions;", "buildClient", "context", "Landroid/content/Context;", "looper", "Landroid/os/Looper;", "commonSettings", "Lcom/google/android/gms/common/internal/ClientSettings;", "apiOptions", "connectedListener", "Lcom/google/android/gms/common/api/internal/ConnectionCallbacks;", "connectionFailedListener", "Lcom/google/android/gms/common/api/internal/OnConnectionFailedListener;", "java.com.google.android.gmscore.integ.client.auth_blockstore_client_auth_blockstore"}, k = 1, mv = {2, 0, 0}, xi = 0x30)
public final class InternalRestoreCredentialClient.Companion.clientBuilder.1 extends AbstractClientBuilder {
    public RestoreCredentialClientImpl buildClient(Context context0, Looper looper0, ClientSettings clientSettings0, NoOptions api$ApiOptions$NoOptions0, ConnectionCallbacks connectionCallbacks0, OnConnectionFailedListener onConnectionFailedListener0) {
        q.g(context0, "context");
        q.g(looper0, "looper");
        q.g(clientSettings0, "commonSettings");
        q.g(api$ApiOptions$NoOptions0, "apiOptions");
        q.g(connectionCallbacks0, "connectedListener");
        q.g(onConnectionFailedListener0, "connectionFailedListener");
        return new RestoreCredentialClientImpl(context0, looper0, clientSettings0, connectionCallbacks0, onConnectionFailedListener0);
    }

    @Override  // com.google.android.gms.common.api.Api$AbstractClientBuilder
    public Client buildClient(Context context0, Looper looper0, ClientSettings clientSettings0, Object object0, ConnectionCallbacks connectionCallbacks0, OnConnectionFailedListener onConnectionFailedListener0) {
        return this.buildClient(context0, looper0, clientSettings0, ((NoOptions)object0), connectionCallbacks0, onConnectionFailedListener0);
    }
}

