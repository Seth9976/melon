package com.google.android.gms.common.internal;

import com.google.android.gms.common.ConnectionResult;

public final class zzaf extends Exception {
    public final ConnectionResult zza;

    public zzaf(ConnectionResult connectionResult0) {
        Preconditions.checkArgument(connectionResult0.hasResolution(), "ResolvableConnectionException can only be created with a connection result containing a resolution.");
        this.zza = connectionResult0;
    }
}

