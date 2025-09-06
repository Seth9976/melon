package com.google.android.gms.cast;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.internal.cast.zzei;

final class zzw extends AbstractClientBuilder {
    @Override  // com.google.android.gms.common.api.Api$AbstractClientBuilder
    public final Client buildClient(Context context0, Looper looper0, ClientSettings clientSettings0, Object object0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0) {
        Bundle bundle0 = new Bundle();
        bundle0.putInt("configuration", ((CastRemoteDisplayOptions)object0).zzc);
        return new zzei(context0, looper0, clientSettings0, ((CastRemoteDisplayOptions)object0).zza, bundle0, ((CastRemoteDisplayOptions)object0).zzb, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0);
    }
}

