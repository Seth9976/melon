package com.google.android.exoplayer2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.PowerManager.WakeLock;
import android.os.PowerManager;
import com.google.android.exoplayer2.util.Log;

final class WakeLockManager {
    private static final String TAG = "WakeLockManager";
    private static final String WAKE_LOCK_TAG = "ExoPlayer:WakeLockManager";
    private boolean enabled;
    private final PowerManager powerManager;
    private boolean stayAwake;
    private PowerManager.WakeLock wakeLock;

    public WakeLockManager(Context context0) {
        this.powerManager = (PowerManager)context0.getApplicationContext().getSystemService("power");
    }

    public void setEnabled(boolean z) {
        if(z && this.wakeLock == null) {
            PowerManager powerManager0 = this.powerManager;
            if(powerManager0 == null) {
                Log.w("WakeLockManager", "PowerManager is null, therefore not creating the WakeLock.");
                return;
            }
            PowerManager.WakeLock powerManager$WakeLock0 = powerManager0.newWakeLock(1, "ExoPlayer:WakeLockManager");
            this.wakeLock = powerManager$WakeLock0;
            powerManager$WakeLock0.setReferenceCounted(false);
        }
        this.enabled = z;
        this.updateWakeLock();
    }

    public void setStayAwake(boolean z) {
        this.stayAwake = z;
        this.updateWakeLock();
    }

    @SuppressLint({"WakelockTimeout"})
    private void updateWakeLock() {
        PowerManager.WakeLock powerManager$WakeLock0 = this.wakeLock;
        if(powerManager$WakeLock0 == null) {
            return;
        }
        if(this.enabled && this.stayAwake) {
            powerManager$WakeLock0.acquire();
            return;
        }
        powerManager$WakeLock0.release();
    }
}

