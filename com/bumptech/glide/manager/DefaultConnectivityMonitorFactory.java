package com.bumptech.glide.manager;

import P1.c;
import android.content.Context;
import android.util.Log;

public class DefaultConnectivityMonitorFactory implements ConnectivityMonitorFactory {
    private static final String NETWORK_PERMISSION = "android.permission.ACCESS_NETWORK_STATE";
    private static final String TAG = "ConnectivityMonitor";

    @Override  // com.bumptech.glide.manager.ConnectivityMonitorFactory
    public ConnectivityMonitor build(Context context0, ConnectivityListener connectivityMonitor$ConnectivityListener0) {
        boolean z = c.checkSelfPermission(context0, "android.permission.ACCESS_NETWORK_STATE") == 0;
        if(Log.isLoggable("ConnectivityMonitor", 3)) {
            Log.d("ConnectivityMonitor", (z ? "ACCESS_NETWORK_STATE permission granted, registering connectivity monitor" : "ACCESS_NETWORK_STATE permission missing, cannot register connectivity monitor"));
        }
        return z ? new DefaultConnectivityMonitor(context0, connectivityMonitor$ConnectivityListener0) : new NullConnectivityMonitor();
    }
}

