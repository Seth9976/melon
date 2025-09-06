package com.google.android.gms.common.api;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.internal.ApiKey;

public interface HasApiKey {
    @KeepForSdk
    ApiKey getApiKey();
}

