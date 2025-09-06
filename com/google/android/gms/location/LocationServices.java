package com.google.android.gms.location;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.internal.location.zzbb;
import com.google.android.gms.internal.location.zzbi;
import com.google.android.gms.internal.location.zzci;
import com.google.android.gms.internal.location.zzcr;
import com.google.android.gms.internal.location.zzct;
import com.google.android.gms.internal.location.zzcz;
import com.google.android.gms.internal.location.zzda;

public class LocationServices {
    @Deprecated
    public static final Api API;
    @Deprecated
    public static final FusedLocationProviderApi FusedLocationApi;
    @Deprecated
    public static final GeofencingApi GeofencingApi;
    @Deprecated
    public static final SettingsApi SettingsApi;

    static {
        LocationServices.API = zzbi.zzb;
        LocationServices.FusedLocationApi = new zzbb();
        LocationServices.GeofencingApi = new zzcr();
        LocationServices.SettingsApi = new zzcz();
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(Activity activity0) {
        return new zzbi(activity0);
    }

    public static FusedLocationProviderClient getFusedLocationProviderClient(Context context0) {
        return new zzbi(context0);
    }

    public static FusedOrientationProviderClient getFusedOrientationProviderClient(Activity activity0) {
        return new zzci(activity0);
    }

    public static FusedOrientationProviderClient getFusedOrientationProviderClient(Context context0) {
        return new zzci(context0);
    }

    public static GeofencingClient getGeofencingClient(Activity activity0) {
        return new zzct(activity0);
    }

    public static GeofencingClient getGeofencingClient(Context context0) {
        return new zzct(context0);
    }

    public static SettingsClient getSettingsClient(Activity activity0) {
        return new zzda(activity0);
    }

    public static SettingsClient getSettingsClient(Context context0) {
        return new zzda(context0);
    }
}

