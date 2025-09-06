package com.google.android.exoplayer2;

import android.content.Context;
import android.net.wifi.WifiManager.WifiLock;
import android.net.wifi.WifiManager;
import com.google.android.exoplayer2.util.Log;

final class WifiLockManager {
    private static final String TAG = "WifiLockManager";
    private static final String WIFI_LOCK_TAG = "ExoPlayer:WifiLockManager";
    private boolean enabled;
    private boolean stayAwake;
    private WifiManager.WifiLock wifiLock;
    private final WifiManager wifiManager;

    public WifiLockManager(Context context0) {
        this.wifiManager = (WifiManager)context0.getApplicationContext().getSystemService("wifi");
    }

    public void setEnabled(boolean z) {
        if(z && this.wifiLock == null) {
            WifiManager wifiManager0 = this.wifiManager;
            if(wifiManager0 == null) {
                Log.w("WifiLockManager", "WifiManager is null, therefore not creating the WifiLock.");
                return;
            }
            WifiManager.WifiLock wifiManager$WifiLock0 = wifiManager0.createWifiLock(3, "ExoPlayer:WifiLockManager");
            this.wifiLock = wifiManager$WifiLock0;
            wifiManager$WifiLock0.setReferenceCounted(false);
        }
        this.enabled = z;
        this.updateWifiLock();
    }

    public void setStayAwake(boolean z) {
        this.stayAwake = z;
        this.updateWifiLock();
    }

    private void updateWifiLock() {
        WifiManager.WifiLock wifiManager$WifiLock0 = this.wifiLock;
        if(wifiManager$WifiLock0 == null) {
            return;
        }
        if(this.enabled && this.stayAwake) {
            wifiManager$WifiLock0.acquire();
            return;
        }
        wifiManager$WifiLock0.release();
    }
}

