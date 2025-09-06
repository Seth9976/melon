package com.kakaoent.trevi.ad.util;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001A\u00020\u00042\u0006\u0010\u0003\u001A\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/kakaoent/trevi/ad/util/NetworkManager$networkCallback$1", "Landroid/net/ConnectivityManager$NetworkCallback;", "Landroid/net/Network;", "network", "Lie/H;", "onAvailable", "(Landroid/net/Network;)V", "onLost", "trevi-ad-android-sdk_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class NetworkManager.networkCallback.1 extends ConnectivityManager.NetworkCallback {
    @Override  // android.net.ConnectivityManager$NetworkCallback
    public void onAvailable(@NotNull Network network0) {
        q.g(network0, "network");
        super.onAvailable(network0);
        TreviLog.INSTANCE.i("NetworkManager", "onAvailable(" + network0.hashCode() + ')');
        NetworkManager.access$checkNetwork(NetworkManager.INSTANCE, network0);
        NetworkManager.access$updateNetworkState(NetworkManager.INSTANCE);
        NetworkManager.access$deliverNetworkState(NetworkManager.INSTANCE, NetworkManager.access$getNetworkState$p(), NetworkManager.access$getNetworkState$p());
        TreviLog.INSTANCE.i("NetworkManager", "onAvailable(" + network0.hashCode() + ") " + false + '(' + 0 + ") / " + false + " / " + NetworkManager.access$getNetworkState$p());
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public void onLost(@NotNull Network network0) {
        q.g(network0, "network");
        super.onLost(network0);
        TreviLog treviLog0 = TreviLog.INSTANCE;
        treviLog0.i("NetworkManager", "onLost(" + network0.hashCode() + ')');
        State networkManager$State0 = NetworkManager.access$getNetworkState$p();
        if(network0.hashCode() == 0) {
            NetworkManager.access$setWifi$p(false);
        }
        NetworkManager.checkNetworkConnect$default(NetworkManager.INSTANCE, null, 1, null);
        NetworkManager.access$updateNetworkState(NetworkManager.INSTANCE);
        NetworkManager.access$deliverNetworkState(NetworkManager.INSTANCE, networkManager$State0, NetworkManager.access$getNetworkState$p());
        treviLog0.i("NetworkManager", "onLost(" + network0.hashCode() + ") " + false + '(' + 0 + ") / " + false + " / " + NetworkManager.access$getNetworkState$p());
    }
}

