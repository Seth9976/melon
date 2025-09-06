package j9;

import android.net.ConnectivityManager.NetworkCallback;
import android.net.Network;
import android.net.NetworkCapabilities;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.ProducerScope;

public final class a extends ConnectivityManager.NetworkCallback {
    public final int a;
    public final ProducerScope b;

    public a(ProducerScope producerScope0, int v) {
        this.a = v;
        this.b = producerScope0;
        super();
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public void onAvailable(Network network0) {
        if(this.a != 1) {
            super.onAvailable(network0);
            return;
        }
        q.g(network0, "network");
        this.b.trySend-JP2dKIU(e.a);
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public void onCapabilitiesChanged(Network network0, NetworkCapabilities networkCapabilities0) {
        if(this.a != 0) {
            super.onCapabilitiesChanged(network0, networkCapabilities0);
            return;
        }
        q.g(network0, "network");
        q.g(networkCapabilities0, "networkCapabilities");
        if(networkCapabilities0.hasCapability(12) && networkCapabilities0.hasCapability(16)) {
            this.b.trySend-JP2dKIU(Boolean.TRUE);
        }
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public void onLosing(Network network0, int v) {
        if(this.a != 1) {
            super.onLosing(network0, v);
            return;
        }
        q.g(network0, "network");
        this.b.trySend-JP2dKIU(e.b);
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public final void onLost(Network network0) {
        if(this.a != 0) {
            q.g(network0, "network");
            this.b.trySend-JP2dKIU(e.c);
            return;
        }
        q.g(network0, "network");
        this.b.trySend-JP2dKIU(Boolean.FALSE);
    }

    @Override  // android.net.ConnectivityManager$NetworkCallback
    public void onUnavailable() {
        if(this.a != 1) {
            super.onUnavailable();
            return;
        }
        this.b.trySend-JP2dKIU(e.d);
    }
}

