package com.google.android.gms.location;

import android.app.PendingIntent;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.Task;
import java.util.List;

public interface GeofencingClient extends HasApiKey {
    Task addGeofences(GeofencingRequest arg1, PendingIntent arg2);

    Task removeGeofences(PendingIntent arg1);

    Task removeGeofences(List arg1);
}

