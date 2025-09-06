package com.bumptech.glide.manager;

import android.content.Context;

public interface ConnectivityMonitorFactory {
    ConnectivityMonitor build(Context arg1, ConnectivityListener arg2);
}

