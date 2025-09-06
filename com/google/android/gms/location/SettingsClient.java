package com.google.android.gms.location;

import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;

public interface SettingsClient extends HasApiKey {
    Task checkLocationSettings(LocationSettingsRequest arg1);

    Task isGoogleLocationAccuracyEnabled();
}

