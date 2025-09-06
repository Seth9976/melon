package com.google.android.exoplayer2.scheduler;

import android.annotation.TargetApi;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.os.Handler;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public final class RequirementsWatcher {
    class DeviceStatusChangeReceiver extends BroadcastReceiver {
        private DeviceStatusChangeReceiver() {
        }

        public DeviceStatusChangeReceiver(com.google.android.exoplayer2.scheduler.RequirementsWatcher.1 requirementsWatcher$10) {
        }

        @Override  // android.content.BroadcastReceiver
        public void onReceive(Context context0, Intent intent0) {
            if(!this.isInitialStickyBroadcast()) {
                RequirementsWatcher.access$200(RequirementsWatcher.this);
            }
        }
    }

    public interface Listener {
        void onRequirementsStateChanged(RequirementsWatcher arg1, int arg2);
    }

    final class NetworkCallback extends ConnectivityManager.NetworkCallback {
        private boolean networkValidated;
        private boolean receivedCapabilitiesChange;

        private NetworkCallback() {
        }

        public NetworkCallback(com.google.android.exoplayer2.scheduler.RequirementsWatcher.1 requirementsWatcher$10) {
        }

        public static void a(NetworkCallback requirementsWatcher$NetworkCallback0) {
            requirementsWatcher$NetworkCallback0.lambda$postRecheckNotMetNetworkRequirements$1();
        }

        public static void b(NetworkCallback requirementsWatcher$NetworkCallback0) {
            requirementsWatcher$NetworkCallback0.lambda$postCheckRequirements$0();
        }

        private void lambda$postCheckRequirements$0() {
            if(RequirementsWatcher.this.networkCallback != null) {
                RequirementsWatcher.this.checkRequirements();
            }
        }

        private void lambda$postRecheckNotMetNetworkRequirements$1() {
            if(RequirementsWatcher.this.networkCallback != null) {
                RequirementsWatcher.this.recheckNotMetNetworkRequirements();
            }
        }

        @Override  // android.net.ConnectivityManager$NetworkCallback
        public void onAvailable(Network network0) {
            this.postCheckRequirements();
        }

        @Override  // android.net.ConnectivityManager$NetworkCallback
        public void onBlockedStatusChanged(Network network0, boolean z) {
            if(!z) {
                this.postRecheckNotMetNetworkRequirements();
            }
        }

        @Override  // android.net.ConnectivityManager$NetworkCallback
        public void onCapabilitiesChanged(Network network0, NetworkCapabilities networkCapabilities0) {
            boolean z = networkCapabilities0.hasCapability(16);
            if(this.receivedCapabilitiesChange && this.networkValidated == z) {
                if(z) {
                    this.postRecheckNotMetNetworkRequirements();
                }
                return;
            }
            this.receivedCapabilitiesChange = true;
            this.networkValidated = z;
            this.postCheckRequirements();
        }

        @Override  // android.net.ConnectivityManager$NetworkCallback
        public void onLost(Network network0) {
            this.postCheckRequirements();
        }

        private void postCheckRequirements() {
            a a0 = new a(this, 0);
            RequirementsWatcher.this.handler.post(a0);
        }

        private void postRecheckNotMetNetworkRequirements() {
            a a0 = new a(this, 1);
            RequirementsWatcher.this.handler.post(a0);
        }
    }

    private final Context context;
    private final Handler handler;
    private final Listener listener;
    private NetworkCallback networkCallback;
    private int notMetRequirements;
    private DeviceStatusChangeReceiver receiver;
    private final Requirements requirements;

    public RequirementsWatcher(Context context0, Listener requirementsWatcher$Listener0, Requirements requirements0) {
        this.context = context0.getApplicationContext();
        this.listener = requirementsWatcher$Listener0;
        this.requirements = requirements0;
        this.handler = new Handler(Util.getLooper());
    }

    private void checkRequirements() {
        int v = this.requirements.getNotMetRequirements(this.context);
        if(this.notMetRequirements != v) {
            this.notMetRequirements = v;
            this.listener.onRequirementsStateChanged(this, v);
        }
    }

    public Requirements getRequirements() {
        return this.requirements;
    }

    private void recheckNotMetNetworkRequirements() {
        if((this.notMetRequirements & 3) == 0) {
            return;
        }
        this.checkRequirements();
    }

    @TargetApi(24)
    private void registerNetworkCallbackV24() {
        ConnectivityManager connectivityManager0 = (ConnectivityManager)Assertions.checkNotNull(((ConnectivityManager)this.context.getSystemService("connectivity")));
        NetworkCallback requirementsWatcher$NetworkCallback0 = new NetworkCallback(this, null);
        this.networkCallback = requirementsWatcher$NetworkCallback0;
        connectivityManager0.registerDefaultNetworkCallback(requirementsWatcher$NetworkCallback0);
    }

    public int start() {
        this.notMetRequirements = this.requirements.getNotMetRequirements(this.context);
        IntentFilter intentFilter0 = new IntentFilter();
        if(this.requirements.isNetworkRequired()) {
            if(Util.SDK_INT >= 24) {
                this.registerNetworkCallbackV24();
            }
            else {
                intentFilter0.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
        }
        if(this.requirements.isChargingRequired()) {
            intentFilter0.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter0.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        }
        if(this.requirements.isIdleRequired()) {
            if(Util.SDK_INT >= 23) {
                intentFilter0.addAction("android.os.action.DEVICE_IDLE_MODE_CHANGED");
            }
            else {
                intentFilter0.addAction("android.intent.action.SCREEN_ON");
                intentFilter0.addAction("android.intent.action.SCREEN_OFF");
            }
        }
        DeviceStatusChangeReceiver requirementsWatcher$DeviceStatusChangeReceiver0 = new DeviceStatusChangeReceiver(this, null);
        this.receiver = requirementsWatcher$DeviceStatusChangeReceiver0;
        this.context.registerReceiver(requirementsWatcher$DeviceStatusChangeReceiver0, intentFilter0, null, this.handler);
        return this.notMetRequirements;
    }

    public void stop() {
        BroadcastReceiver broadcastReceiver0 = (BroadcastReceiver)Assertions.checkNotNull(this.receiver);
        this.context.unregisterReceiver(broadcastReceiver0);
        this.receiver = null;
        if(Util.SDK_INT >= 24 && this.networkCallback != null) {
            this.unregisterNetworkCallbackV24();
        }
    }

    @TargetApi(24)
    private void unregisterNetworkCallbackV24() {
        ((ConnectivityManager)this.context.getSystemService("connectivity")).unregisterNetworkCallback(((ConnectivityManager.NetworkCallback)Assertions.checkNotNull(this.networkCallback)));
        this.networkCallback = null;
    }

    class com.google.android.exoplayer2.scheduler.RequirementsWatcher.1 {
    }

}

