package com.iloen.melon.net;

import A8.b;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager.NetworkCallback;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.iloen.melon.utils.MelonSettingInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000E\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\b\u001A\u00020\u0007H\u0007¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\n¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0011\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0017¢\u0006\u0004\b\u0011\u0010\u0012J\u0017\u0010\u0013\u001A\u00020\f2\u0006\u0010\u0010\u001A\u00020\u000FH\u0016¢\u0006\u0004\b\u0013\u0010\u0012J\u000F\u0010\u0014\u001A\u00020\fH\u0007¢\u0006\u0004\b\u0014\u0010\u0003R\u0014\u0010\u0016\u001A\u00020\u00158\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0005\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0005\u0010\u0018R\u0016\u0010\u0019\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0019\u0010\u0018R\u0018\u0010\u001B\u001A\u0004\u0018\u00010\u001A8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001B\u0010\u001CR$\u0010\u001D\u001A\u0004\u0018\u00010\u000F8\u0006@\u0006X\u0086\u000E¢\u0006\u0012\n\u0004\b\u001D\u0010\u001E\u001A\u0004\b\u001F\u0010 \"\u0004\b!\u0010\u0012¨\u0006\""}, d2 = {"Lcom/iloen/melon/net/NetworkStatusManager;", "Landroid/net/ConnectivityManager$NetworkCallback;", "<init>", "()V", "", "isNetworkAvailable", "()Z", "", "getCurrentNetworkStatus", "()I", "Landroid/content/Context;", "context", "Lie/H;", "initialize", "(Landroid/content/Context;)V", "Landroid/net/Network;", "network", "onAvailable", "(Landroid/net/Network;)V", "onLost", "registerNetworkCallback", "", "TAG", "Ljava/lang/String;", "Z", "isCellularAvailable", "Landroid/net/ConnectivityManager;", "connectivityManager", "Landroid/net/ConnectivityManager;", "currentNetwork", "Landroid/net/Network;", "getCurrentNetwork", "()Landroid/net/Network;", "setCurrentNetwork", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class NetworkStatusManager extends ConnectivityManager.NetworkCallback {
    public static final int $stable = 0;
    @NotNull
    public static final NetworkStatusManager INSTANCE = null;
    @NotNull
    public static final String TAG = "NetworkStatusManager";
    @Nullable
    private static ConnectivityManager connectivityManager;
    @Nullable
    private static Network currentNetwork;
    private static boolean isCellularAvailable;
    private static boolean isNetworkAvailable;

    static {
        NetworkStatusManager.INSTANCE = new NetworkStatusManager();
        NetworkStatusManager.isNetworkAvailable = true;
        NetworkStatusManager.$stable = 8;
    }

    @Nullable
    public final Network getCurrentNetwork() {
        return NetworkStatusManager.currentNetwork;
    }

    public static final int getCurrentNetworkStatus() [...] // 潜在的解密器

    public final void initialize(@Nullable Context context0) {
        synchronized(this) {
            if(context0 != null && NetworkStatusManager.connectivityManager == null) {
                NetworkStatusManager.connectivityManager = (ConnectivityManager)context0.getSystemService("connectivity");
                NetworkStatusManager.isNetworkAvailable = false;
                NetworkStatusManager.INSTANCE.registerNetworkCallback();
            }
        }
    }

    public static final boolean isNetworkAvailable() {
        MelonSettingInfo.isUseDataNetwork();
        return true;
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    @SuppressLint({"MissingPermission"})
    public void onAvailable(@NotNull Network network0) {
        q.g(network0, "network");
        super.onAvailable(network0);
        NetworkStatusManager.currentNetwork = network0;
        ConnectivityManager connectivityManager0 = NetworkStatusManager.connectivityManager;
        if(connectivityManager0 != null) {
            NetworkCapabilities networkCapabilities0 = connectivityManager0.getNetworkCapabilities(network0);
            if(networkCapabilities0 != null && (b.d() || !networkCapabilities0.hasTransport(4))) {
                NetworkStatusManager.isCellularAvailable = networkCapabilities0.hasTransport(0);
            }
        }
        NetworkStatusManager.isNetworkAvailable = true;
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public void onLost(@NotNull Network network0) {
        q.g(network0, "network");
        super.onLost(network0);
        NetworkStatusManager.currentNetwork = network0;
        NetworkStatusManager.isNetworkAvailable = false;
        NetworkStatusManager.isCellularAvailable = false;
    }

    @SuppressLint({"MissingPermission"})
    public final void registerNetworkCallback() {
        ConnectivityManager connectivityManager0 = NetworkStatusManager.connectivityManager;
        if(connectivityManager0 != null) {
            connectivityManager0.registerDefaultNetworkCallback(this);
        }
    }

    public final void setCurrentNetwork(@Nullable Network network0) {
        NetworkStatusManager.currentNetwork = network0;
    }
}

