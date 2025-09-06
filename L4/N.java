package l4;

import android.media.MediaRoute2Info;
import android.media.MediaRouter2.RoutingController;
import android.media.MediaRouter2.TransferCallback;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.material.internal.F;
import java.util.List;

public final class n extends MediaRouter2.TransferCallback {
    public final o a;

    public n(o o0) {
        this.a = o0;
        super();
    }

    @Override  // android.media.MediaRouter2$TransferCallback
    public final void onStop(MediaRouter2.RoutingController mediaRouter2$RoutingController0) {
        o o0 = this.a;
        o0.D = null;
        z z0 = (z)o0.k.remove(mediaRouter2$RoutingController0);
        if(z0 != null) {
            h h0 = o0.j.a;
            if(z0 == h0.e) {
                O o1 = h0.c();
                if(h0.g() != o1) {
                    h0.m(o1, 2, true);
                }
                return;
            }
            return;
        }
        Log.w("MR2Provider", "onStop: No matching routeController found. routingController=" + mediaRouter2$RoutingController0);
    }

    @Override  // android.media.MediaRouter2$TransferCallback
    public final void onTransfer(MediaRouter2.RoutingController mediaRouter2$RoutingController0, MediaRouter2.RoutingController mediaRouter2$RoutingController1) {
        O o0 = null;
        this.a.D = null;
        this.a.k.remove(mediaRouter2$RoutingController0);
        if(mediaRouter2$RoutingController1 == this.a.i.getSystemController()) {
            h h0 = this.a.j.a;
            O o1 = h0.c();
            if(h0.g() != o1) {
                h0.m(o1, 3, true);
            }
            return;
        }
        List list0 = F.q(mediaRouter2$RoutingController1);
        if(list0.isEmpty()) {
            Log.w("MR2Provider", "Selected routes are empty. This shouldn\'t happen.");
            return;
        }
        String s = i.b(list0.get(0)).getId();
        k k0 = new k(this.a, mediaRouter2$RoutingController1, s);
        this.a.k.put(mediaRouter2$RoutingController1, k0);
        h h1 = this.a.j.a;
        for(Object object0: h1.j) {
            O o2 = (O)object0;
            if(o2.c() == h1.s && TextUtils.equals(s, o2.b)) {
                o0 = o2;
                break;
            }
            if(false) {
                break;
            }
        }
        if(o0 == null) {
            androidx.appcompat.app.o.A("onSelectRoute: The target RouteInfo is not found for descriptorId=", s, "AxMediaRouter");
        }
        else {
            h1.m(o0, 3, true);
        }
        this.a.j(mediaRouter2$RoutingController1);
    }

    @Override  // android.media.MediaRouter2$TransferCallback
    public final void onTransferFailure(MediaRoute2Info mediaRoute2Info0) {
        this.a.D = null;
        Log.w("MR2Provider", "Transfer failed. requestedRoute=" + mediaRoute2Info0);
    }
}

