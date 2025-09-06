package com.google.android.gms.cast;

import android.content.Context;
import android.os.Looper;
import com.google.android.gms.cast.internal.zzx;
import com.google.android.gms.common.api.Api.AbstractClientBuilder;
import com.google.android.gms.common.api.Api.Client;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.ClientSettings;
import com.google.android.gms.common.internal.Preconditions;

final class zze extends AbstractClientBuilder {
    @Override  // com.google.android.gms.common.api.Api$AbstractClientBuilder
    public final Client buildClient(Context context0, Looper looper0, ClientSettings clientSettings0, Object object0, ConnectionCallbacks googleApiClient$ConnectionCallbacks0, OnConnectionFailedListener googleApiClient$OnConnectionFailedListener0) {
        Preconditions.checkNotNull(((CastOptions)object0), "Setting the API options is required.");
        return new zzx(context0, looper0, clientSettings0, ((CastOptions)object0).zza, ((long)((CastOptions)object0).zzd), ((CastOptions)object0).zzb, ((CastOptions)object0).zzc, googleApiClient$ConnectionCallbacks0, googleApiClient$OnConnectionFailedListener0);
    }
}

