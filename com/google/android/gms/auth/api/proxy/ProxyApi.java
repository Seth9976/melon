package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.ShowFirstParty;

@KeepForSdk
@ShowFirstParty
public interface ProxyApi {
    @KeepForSdk
    @ShowFirstParty
    public interface ProxyResult extends Result {
        @KeepForSdk
        ProxyResponse getResponse();
    }

    @KeepForSdk
    @ShowFirstParty
    public interface SpatulaHeaderResult extends Result {
        @KeepForSdk
        @ShowFirstParty
        String getSpatulaHeader();
    }

    @KeepForSdk
    @ShowFirstParty
    @Deprecated
    PendingResult getSpatulaHeader(GoogleApiClient arg1);

    @KeepForSdk
    @Deprecated
    PendingResult performProxyRequest(GoogleApiClient arg1, ProxyRequest arg2);
}

