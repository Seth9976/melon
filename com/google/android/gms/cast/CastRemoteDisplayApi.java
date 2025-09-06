package com.google.android.gms.cast;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;

@Deprecated
public interface CastRemoteDisplayApi {
    PendingResult startRemoteDisplay(GoogleApiClient arg1, String arg2);

    PendingResult stopRemoteDisplay(GoogleApiClient arg1);
}

