package com.google.android.gms.auth.api.proxy;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.tasks.Task;

@KeepForSdk
@ShowFirstParty
public interface ProxyClient extends HasApiKey {
    @KeepForSdk
    Task getSpatulaHeader();

    @KeepForSdk
    Task performProxyRequest(ProxyRequest arg1);
}

