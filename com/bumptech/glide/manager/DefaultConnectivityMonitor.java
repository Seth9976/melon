package com.bumptech.glide.manager;

import android.content.Context;

final class DefaultConnectivityMonitor implements ConnectivityMonitor {
    private final Context context;
    final ConnectivityListener listener;

    public DefaultConnectivityMonitor(Context context0, ConnectivityListener connectivityMonitor$ConnectivityListener0) {
        this.context = context0.getApplicationContext();
        this.listener = connectivityMonitor$ConnectivityListener0;
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onDestroy() {
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStart() {
        this.register();
    }

    @Override  // com.bumptech.glide.manager.LifecycleListener
    public void onStop() {
        this.unregister();
    }

    private void register() {
        SingletonConnectivityReceiver.get(this.context).register(this.listener);
    }

    private void unregister() {
        SingletonConnectivityReceiver.get(this.context).unregister(this.listener);
    }
}

