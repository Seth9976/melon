package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.util.Log;
import com.bumptech.glide.util.GlideSuppliers.GlideSupplier;
import com.bumptech.glide.util.GlideSuppliers;
import com.bumptech.glide.util.Util;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.Executor;

final class SingletonConnectivityReceiver {
    interface FrameworkConnectivityMonitor {
        boolean register();

        void unregister();
    }

    static final class FrameworkConnectivityMonitorPostApi24 implements FrameworkConnectivityMonitor {
        private final GlideSupplier connectivityManager;
        boolean isConnected;
        final ConnectivityListener listener;
        private final ConnectivityManager.NetworkCallback networkCallback;

        public FrameworkConnectivityMonitorPostApi24(GlideSupplier glideSuppliers$GlideSupplier0, ConnectivityListener connectivityMonitor$ConnectivityListener0) {
            this.networkCallback = new ConnectivityManager.NetworkCallback() {
                @Override  // android.net.ConnectivityManager$NetworkCallback
                public void onAvailable(Network network0) {
                    this.postOnConnectivityChange(true);
                }

                // 检测为 Lambda 实现
                public void onConnectivityChange(boolean z) [...]

                @Override  // android.net.ConnectivityManager$NetworkCallback
                public void onLost(Network network0) {
                    this.postOnConnectivityChange(false);
                }

                private void postOnConnectivityChange(boolean z) {
                    Util.postOnUiThread(() -> {
                        Util.assertMainThread();
                        FrameworkConnectivityMonitorPostApi24 singletonConnectivityReceiver$FrameworkConnectivityMonitorPostApi240 = FrameworkConnectivityMonitorPostApi24.this;
                        boolean z1 = singletonConnectivityReceiver$FrameworkConnectivityMonitorPostApi240.isConnected;
                        singletonConnectivityReceiver$FrameworkConnectivityMonitorPostApi240.isConnected = this.val$newState;
                        if(z1 != this.val$newState) {
                            singletonConnectivityReceiver$FrameworkConnectivityMonitorPostApi240.listener.onConnectivityChanged(this.val$newState);
                        }
                    });

                    class com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.1.1 implements Runnable {
                        public com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.1.1(boolean z) {
                        }

                        @Override
                        public void run() {
                            com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPostApi24.1.this.onConnectivityChange(this.val$newState);
                        }
                    }

                }
            };
            this.connectivityManager = glideSuppliers$GlideSupplier0;
            this.listener = connectivityMonitor$ConnectivityListener0;
        }

        @Override  // com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitor
        @SuppressLint({"MissingPermission"})
        public boolean register() {
            boolean z = ((ConnectivityManager)this.connectivityManager.get()).getActiveNetwork() != null;
            try {
                this.isConnected = z;
                ((ConnectivityManager)this.connectivityManager.get()).registerDefaultNetworkCallback(this.networkCallback);
                return true;
            }
            catch(RuntimeException runtimeException0) {
                if(Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to register callback", runtimeException0);
                }
                return false;
            }
        }

        @Override  // com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitor
        public void unregister() {
            ((ConnectivityManager)this.connectivityManager.get()).unregisterNetworkCallback(this.networkCallback);
        }
    }

    static final class FrameworkConnectivityMonitorPreApi24 implements FrameworkConnectivityMonitor {
        static final Executor EXECUTOR;
        private final GlideSupplier connectivityManager;
        final BroadcastReceiver connectivityReceiver;
        final Context context;
        volatile boolean isConnected;
        volatile boolean isRegistered;
        final ConnectivityListener listener;

        static {
            FrameworkConnectivityMonitorPreApi24.EXECUTOR = AsyncTask.SERIAL_EXECUTOR;
        }

        public FrameworkConnectivityMonitorPreApi24(Context context0, GlideSupplier glideSuppliers$GlideSupplier0, ConnectivityListener connectivityMonitor$ConnectivityListener0) {
            this.connectivityReceiver = new BroadcastReceiver() {
                @Override  // android.content.BroadcastReceiver
                public void onReceive(Context context0, Intent intent0) {
                    FrameworkConnectivityMonitorPreApi24.this.onConnectivityChange();
                }
            };
            this.context = context0.getApplicationContext();
            this.connectivityManager = glideSuppliers$GlideSupplier0;
            this.listener = connectivityMonitor$ConnectivityListener0;
        }

        @SuppressLint({"MissingPermission"})
        public boolean isConnected() {
            try {
                NetworkInfo networkInfo0 = ((ConnectivityManager)this.connectivityManager.get()).getActiveNetworkInfo();
                return networkInfo0 != null && networkInfo0.isConnected();
            }
            catch(RuntimeException runtimeException0) {
                if(Log.isLoggable("ConnectivityMonitor", 5)) {
                    Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", runtimeException0);
                }
                return true;
            }
        }

        public void notifyChangeOnUiThread(boolean z) {
            Util.postOnUiThread(new Runnable() {
                @Override
                public void run() {
                    FrameworkConnectivityMonitorPreApi24.this.listener.onConnectivityChanged(z);
                }
            });
        }

        public void onConnectivityChange() {
            com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.4 singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$40 = new Runnable() {
                @Override
                public void run() {
                    boolean z = FrameworkConnectivityMonitorPreApi24.this.isConnected;
                    FrameworkConnectivityMonitorPreApi24.this.isConnected = FrameworkConnectivityMonitorPreApi24.this.isConnected();
                    if(z != FrameworkConnectivityMonitorPreApi24.this.isConnected) {
                        if(Log.isLoggable("ConnectivityMonitor", 3)) {
                            Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + FrameworkConnectivityMonitorPreApi24.this.isConnected);
                        }
                        FrameworkConnectivityMonitorPreApi24.this.notifyChangeOnUiThread(FrameworkConnectivityMonitorPreApi24.this.isConnected);
                    }
                }
            };
            FrameworkConnectivityMonitorPreApi24.EXECUTOR.execute(singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$40);
        }

        @Override  // com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitor
        public boolean register() {
            com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.2 singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$20 = new Runnable() {
                @Override
                public void run() {
                    FrameworkConnectivityMonitorPreApi24.this.isConnected = FrameworkConnectivityMonitorPreApi24.this.isConnected();
                    try {
                        IntentFilter intentFilter0 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
                        FrameworkConnectivityMonitorPreApi24.this.context.registerReceiver(FrameworkConnectivityMonitorPreApi24.this.connectivityReceiver, intentFilter0);
                        FrameworkConnectivityMonitorPreApi24.this.isRegistered = true;
                    }
                    catch(SecurityException securityException0) {
                        if(Log.isLoggable("ConnectivityMonitor", 5)) {
                            Log.w("ConnectivityMonitor", "Failed to register", securityException0);
                        }
                        FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                    }
                }
            };
            FrameworkConnectivityMonitorPreApi24.EXECUTOR.execute(singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$20);
            return true;
        }

        @Override  // com.bumptech.glide.manager.SingletonConnectivityReceiver$FrameworkConnectivityMonitor
        public void unregister() {
            com.bumptech.glide.manager.SingletonConnectivityReceiver.FrameworkConnectivityMonitorPreApi24.3 singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$30 = new Runnable() {
                @Override
                public void run() {
                    if(!FrameworkConnectivityMonitorPreApi24.this.isRegistered) {
                        return;
                    }
                    FrameworkConnectivityMonitorPreApi24.this.isRegistered = false;
                    FrameworkConnectivityMonitorPreApi24.this.context.unregisterReceiver(FrameworkConnectivityMonitorPreApi24.this.connectivityReceiver);
                }
            };
            FrameworkConnectivityMonitorPreApi24.EXECUTOR.execute(singletonConnectivityReceiver$FrameworkConnectivityMonitorPreApi24$30);
        }
    }

    private static final String TAG = "ConnectivityMonitor";
    private final FrameworkConnectivityMonitor frameworkConnectivityMonitor;
    private static volatile SingletonConnectivityReceiver instance;
    private boolean isRegistered;
    final Set listeners;

    private SingletonConnectivityReceiver(Context context0) {
        this.listeners = new HashSet();
        this.frameworkConnectivityMonitor = new FrameworkConnectivityMonitorPostApi24(GlideSuppliers.memorize(new GlideSupplier() {
            public ConnectivityManager get() {
                return (ConnectivityManager)context0.getSystemService("connectivity");
            }

            @Override  // com.bumptech.glide.util.GlideSuppliers$GlideSupplier
            public Object get() {
                return this.get();
            }
        }), new ConnectivityListener() {
            @Override  // com.bumptech.glide.manager.ConnectivityMonitor$ConnectivityListener
            public void onConnectivityChanged(boolean z) {
                Util.assertMainThread();
                synchronized(SingletonConnectivityReceiver.this) {
                    ArrayList arrayList0 = new ArrayList(SingletonConnectivityReceiver.this.listeners);
                }
                for(Object object0: arrayList0) {
                    ((ConnectivityListener)object0).onConnectivityChanged(z);
                }
            }
        });
    }

    public static SingletonConnectivityReceiver get(Context context0) {
        if(SingletonConnectivityReceiver.instance == null) {
            Class class0 = SingletonConnectivityReceiver.class;
            synchronized(class0) {
                if(SingletonConnectivityReceiver.instance == null) {
                    SingletonConnectivityReceiver.instance = new SingletonConnectivityReceiver(context0.getApplicationContext());
                }
            }
        }
        return SingletonConnectivityReceiver.instance;
    }

    private void maybeRegisterReceiver() {
        if(!this.isRegistered && !this.listeners.isEmpty()) {
            this.isRegistered = this.frameworkConnectivityMonitor.register();
        }
    }

    private void maybeUnregisterReceiver() {
        if(this.isRegistered && this.listeners.isEmpty()) {
            this.frameworkConnectivityMonitor.unregister();
            this.isRegistered = false;
        }
    }

    public void register(ConnectivityListener connectivityMonitor$ConnectivityListener0) {
        synchronized(this) {
            this.listeners.add(connectivityMonitor$ConnectivityListener0);
            this.maybeRegisterReceiver();
        }
    }

    public static void reset() {
        SingletonConnectivityReceiver.instance = null;
    }

    public void unregister(ConnectivityListener connectivityMonitor$ConnectivityListener0) {
        synchronized(this) {
            this.listeners.remove(connectivityMonitor$ConnectivityListener0);
            this.maybeUnregisterReceiver();
        }
    }
}

