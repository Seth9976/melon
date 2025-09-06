package com.google.android.gms.location;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

public interface FusedOrientationProviderClient extends HasApiKey {
    Task removeOrientationUpdates(DeviceOrientationListener arg1);

    Task requestOrientationUpdates(DeviceOrientationRequest arg1, Executor arg2, DeviceOrientationListener arg3);
}

