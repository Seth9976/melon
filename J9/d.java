package j9;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import com.iloen.melon.custom.h0;
import com.iloen.melon.utils.log.LogU;
import d3.g;
import ie.r;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.SharedFlow;
import kotlinx.coroutines.flow.SharingStarted.Companion;
import kotlinx.coroutines.flow.SharingStarted;

public final class d {
    public final LogU a;
    public final r b;
    public final SharedFlow c;

    public d(Context context0, CoroutineScope coroutineScope0) {
        q.g(context0, "context");
        super();
        this.a = new LogU("NetworkMonitor");
        this.b = g.Q(new h0(context0, 1));
        this.c = FlowKt.shareIn(FlowKt.distinctUntilChanged(FlowKt.callbackFlow(new b(this, null))), coroutineScope0, Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, null), 1);
        FlowKt.shareIn(FlowKt.distinctUntilChanged(FlowKt.callbackFlow(new c(this, null))), coroutineScope0, Companion.WhileSubscribed$default(SharingStarted.Companion, 5000L, 0L, 2, null), 1);
    }

    public final ConnectivityManager a() {
        return (ConnectivityManager)this.b.getValue();
    }

    public final boolean b() {
        Network network0 = this.a().getActiveNetwork();
        if(network0 != null) {
            NetworkCapabilities networkCapabilities0 = this.a().getNetworkCapabilities(network0);
            return networkCapabilities0 != null && networkCapabilities0.hasCapability(12) && networkCapabilities0.hasCapability(16);
        }
        return false;
    }
}

