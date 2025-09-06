package com.google.android.gms.location;

import android.app.PendingIntent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.api.HasApiKey;
import com.google.android.gms.tasks.CancellationToken;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.Executor;

public interface FusedLocationProviderClient extends HasApiKey {
    @Deprecated
    public static final String KEY_MOCK_LOCATION = "mockLocation";
    @Deprecated
    public static final String KEY_VERTICAL_ACCURACY = "verticalAccuracy";

    Task flushLocations();

    Task getCurrentLocation(int arg1, CancellationToken arg2);

    Task getCurrentLocation(CurrentLocationRequest arg1, CancellationToken arg2);

    Task getLastLocation();

    Task getLastLocation(LastLocationRequest arg1);

    Task getLocationAvailability();

    @Deprecated
    Task removeDeviceOrientationUpdates(DeviceOrientationListener arg1);

    Task removeLocationUpdates(PendingIntent arg1);

    Task removeLocationUpdates(LocationCallback arg1);

    Task removeLocationUpdates(LocationListener arg1);

    @Deprecated
    Task requestDeviceOrientationUpdates(DeviceOrientationRequest arg1, DeviceOrientationListener arg2, Looper arg3);

    @Deprecated
    Task requestDeviceOrientationUpdates(DeviceOrientationRequest arg1, Executor arg2, DeviceOrientationListener arg3);

    Task requestLocationUpdates(LocationRequest arg1, PendingIntent arg2);

    Task requestLocationUpdates(LocationRequest arg1, LocationCallback arg2, Looper arg3);

    Task requestLocationUpdates(LocationRequest arg1, LocationListener arg2, Looper arg3);

    Task requestLocationUpdates(LocationRequest arg1, Executor arg2, LocationCallback arg3);

    Task requestLocationUpdates(LocationRequest arg1, Executor arg2, LocationListener arg3);

    Task setMockLocation(Location arg1);

    Task setMockMode(boolean arg1);
}

