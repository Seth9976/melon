package com.google.android.gms.common.api.internal;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
public interface ConnectionCallbacks {
    @KeepForSdk
    @ShowFirstParty
    void onConnected(Bundle arg1);

    @KeepForSdk
    @ShowFirstParty
    void onConnectionSuspended(int arg1);
}

