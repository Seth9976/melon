package com.iloen.melon.foru;

import R6.d;
import V8.e;
import android.content.Context;
import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.location.LocationSettingsRequest.Builder;
import com.iloen.melon.utils.system.GooglePlayServiceUtils;

public class LocationTracker {
    public final LocationRequest a;
    public final FusedLocationProviderClient b;
    public final e c;

    public LocationTracker(Context context0) {
        this.b = null;
        this.c = new e(this);
        if(GooglePlayServiceUtils.isEnable(context0)) {
            this.b = LocationServices.getFusedLocationProviderClient(context0);
            LocationRequest locationRequest0 = new LocationRequest();
            this.a = locationRequest0;
            locationRequest0.setInterval(10000L);
            this.a.setFastestInterval(5000L);
            this.a.setPriority(102);
            Builder locationSettingsRequest$Builder0 = new Builder().addLocationRequest(this.a);
            LocationServices.getSettingsClient(context0).checkLocationSettings(locationSettingsRequest$Builder0.build()).addOnFailureListener(new d(this));
        }
    }
}

