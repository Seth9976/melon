package l4;

import Bb.e;
import android.content.Intent;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2.RoutingController;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;
import android.util.Log;
import android.util.SparseArray;
import com.google.android.material.internal.F;
import i.n.i.b.a.s.e.u9;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public final class k extends y {
    public final String f;
    public final MediaRouter2.RoutingController g;
    public final Messenger h;
    public final Messenger i;
    public final SparseArray j;
    public final Handler k;
    public final AtomicInteger l;
    public final u9 m;
    public int n;
    public u o;
    public final o p;

    public k(o o0, MediaRouter2.RoutingController mediaRouter2$RoutingController0, String s) {
        this.p = o0;
        super();
        this.j = new SparseArray();
        this.l = new AtomicInteger(1);
        this.m = new u9(this, 15);
        this.n = -1;
        this.g = mediaRouter2$RoutingController0;
        this.f = s;
        Bundle bundle0 = F.j(mediaRouter2$RoutingController0);
        Messenger messenger0 = null;
        Messenger messenger1 = bundle0 == null ? null : ((Messenger)bundle0.getParcelable("androidx.mediarouter.media.KEY_MESSENGER"));
        this.h = messenger1;
        if(messenger1 != null) {
            messenger0 = new Messenger(new e(this));
        }
        this.i = messenger0;
        this.k = new Handler(Looper.getMainLooper());
    }

    @Override  // l4.z
    public final boolean d(Intent intent0, J j0) {
        if(this.g != null && !this.g.isReleased()) {
            Messenger messenger0 = this.h;
            if(messenger0 != null) {
                int v = this.l.getAndIncrement();
                Message message0 = Message.obtain();
                message0.what = 9;
                message0.arg1 = v;
                message0.obj = intent0;
                message0.replyTo = this.i;
                try {
                    messenger0.send(message0);
                    if(j0 != null) {
                        this.j.put(v, j0);
                        return true;
                    }
                    return true;
                }
                catch(DeadObjectException remoteException0) {
                }
                catch(RemoteException unused_ex) {
                    return false;
                }
                Log.e("MR2Provider", "Could not send control request to service.", remoteException0);
            }
        }
        return false;
    }

    @Override  // l4.z
    public final void e() {
        this.g.release();
    }

    @Override  // l4.z
    public final void g(int v) {
        MediaRouter2.RoutingController mediaRouter2$RoutingController0 = this.g;
        if(mediaRouter2$RoutingController0 == null) {
            return;
        }
        mediaRouter2$RoutingController0.setVolume(v);
        this.n = v;
        this.k.removeCallbacks(this.m);
        this.k.postDelayed(this.m, 1000L);
    }

    @Override  // l4.z
    public final void j(int v) {
        MediaRouter2.RoutingController mediaRouter2$RoutingController0 = this.g;
        if(mediaRouter2$RoutingController0 == null) {
            return;
        }
        int v1 = Math.max(0, Math.min((this.n >= 0 ? this.n : F.c(mediaRouter2$RoutingController0)) + v, this.g.getVolumeMax()));
        this.n = v1;
        this.g.setVolume(v1);
        this.k.removeCallbacks(this.m);
        this.k.postDelayed(this.m, 1000L);
    }

    @Override  // l4.y
    public final void n(String s) {
        if(s != null && !s.isEmpty()) {
            MediaRoute2Info mediaRoute2Info0 = this.p.h(s);
            if(mediaRoute2Info0 == null) {
                Log.w("MR2Provider", "onAddMemberRoute: Specified route not found. routeId=" + s);
                return;
            }
            this.g.selectRoute(mediaRoute2Info0);
            return;
        }
        Log.w("MR2Provider", "onAddMemberRoute: Ignoring null or empty routeId.");
    }

    @Override  // l4.y
    public final void o(String s) {
        if(s != null && !s.isEmpty()) {
            MediaRoute2Info mediaRoute2Info0 = this.p.h(s);
            if(mediaRoute2Info0 == null) {
                Log.w("MR2Provider", "onRemoveMemberRoute: Specified route not found. routeId=" + s);
                return;
            }
            this.g.deselectRoute(mediaRoute2Info0);
            return;
        }
        Log.w("MR2Provider", "onRemoveMemberRoute: Ignoring null or empty routeId.");
    }

    @Override  // l4.y
    public final void p(List list0) {
        if(list0 != null && !list0.isEmpty()) {
            String s = (String)list0.get(0);
            o o0 = this.p;
            MediaRoute2Info mediaRoute2Info0 = o0.h(s);
            if(mediaRoute2Info0 == null) {
                androidx.appcompat.app.o.A("onUpdateMemberRoutes: Specified route not found. routeId=", s, "MR2Provider");
                return;
            }
            o0.i.transferTo(mediaRoute2Info0);
            return;
        }
        Log.w("MR2Provider", "onUpdateMemberRoutes: Ignoring null or empty routeIds.");
    }
}

