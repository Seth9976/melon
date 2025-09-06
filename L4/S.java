package l4;

import E9.m;
import android.media.RoutingSessionInfo.Builder;
import android.media.RoutingSessionInfo;
import android.os.Bundle;
import android.os.Messenger;
import android.util.Log;
import androidx.appcompat.app.o;
import androidx.collection.f;
import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.MediaRouteProviderService;
import i.n.i.b.a.s.e.P3;
import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class s {
    public final f a;
    public final y b;
    public final long c;
    public final int d;
    public final WeakReference e;
    public boolean f;
    public boolean g;
    public RoutingSessionInfo h;
    public String i;
    public String j;
    public final t k;

    public s(t t0, y y0, long v, int v1, B b0) {
        this.k = t0;
        this.a = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.f = false;
        this.b = y0;
        this.c = v;
        this.d = v1;
        this.e = new WeakReference(b0);
    }

    public final void a(boolean z) {
        if(!this.g) {
            int v = this.d;
            if((v & 3) == 3) {
                this.c(null, this.h, null, A.b);
            }
            if(z) {
                z z1 = this.b;
                z1.i(2);
                z1.e();
                if((v & 1) == 0) {
                    B b0 = (B)this.e.get();
                    if(b0 != null) {
                        if(z1 instanceof r) {
                            z1 = ((r)z1).g;
                        }
                        String s = this.j;
                        int v1 = b0.f.indexOfValue(z1);
                        int v2 = v1 >= 0 ? b0.f.keyAt(v1) : -1;
                        b0.f(v2);
                        if(b0.b < 4) {
                            b0.k.put(s, v2);
                            P3 p30 = new P3(16, b0, s);
                            b0.j.postDelayed(p30, 5000L);
                            df.B b1 = b0.l.a.d.g;
                            if(b1 != null) {
                                Bundle bundle0 = b0.a(b1);
                                MediaRouteProviderService.e(b0.a, 5, 0, 0, bundle0, null);
                            }
                        }
                        else if(v2 < 0) {
                            o.A("releaseControllerByProvider: Can\'t find the controller. route ID=", s, "MediaRouteProviderSrv");
                        }
                        else {
                            MediaRouteProviderService.e(b0.a, 8, 0, v2, null, null);
                        }
                    }
                }
            }
            this.g = true;
            p.u(this.k, this.i);
        }
    }

    public final void b(RoutingSessionInfo routingSessionInfo0) {
        if(this.h != null) {
            Log.w("MR2ProviderService", "setSessionInfo: This shouldn\'t be called after sessionInfo is set");
            return;
        }
        Messenger messenger0 = new Messenger(new m(this.k, this.i));
        RoutingSessionInfo.Builder routingSessionInfo$Builder0 = p.f(routingSessionInfo0);
        Bundle bundle0 = new Bundle();
        bundle0.putParcelable("androidx.mediarouter.media.KEY_MESSENGER", messenger0);
        bundle0.putString("androidx.mediarouter.media.KEY_SESSION_NAME", (routingSessionInfo0.getName() == null ? null : routingSessionInfo0.getName().toString()));
        this.h = routingSessionInfo$Builder0.setControlHints(bundle0).build();
    }

    public final void c(String s, RoutingSessionInfo routingSessionInfo0, RoutingSessionInfo routingSessionInfo1, A a0) {
        f f0;
        List list0 = routingSessionInfo0 == null ? Collections.EMPTY_LIST : routingSessionInfo0.getSelectedRoutes();
        List list1 = routingSessionInfo1 == null ? Collections.EMPTY_LIST : routingSessionInfo1.getSelectedRoutes();
        Iterator iterator0 = list1.iterator();
        while(true) {
            boolean z = iterator0.hasNext();
            f0 = this.a;
            if(!z) {
                break;
            }
            Object object0 = iterator0.next();
            String s1 = (String)object0;
            B b0 = (B)this.e.get();
            if((b0 == null ? ((z)f0.get(s1)) : ((z)b0.i.get(s1))) == null) {
                z z1 = (z)f0.get(s1);
                if(z1 == null) {
                    MediaRouteProvider mediaRouteProvider0 = null;
                    t t0 = this.k;
                    if(s == null) {
                        MediaRouteProviderService mediaRouteProviderService0 = t0.b.a;
                        if(mediaRouteProviderService0 != null) {
                            mediaRouteProvider0 = mediaRouteProviderService0.d;
                        }
                        z1 = mediaRouteProvider0.d(s1, a0);
                    }
                    else {
                        MediaRouteProviderService mediaRouteProviderService1 = t0.b.a;
                        if(mediaRouteProviderService1 != null) {
                            mediaRouteProvider0 = mediaRouteProviderService1.d;
                        }
                        z1 = mediaRouteProvider0.c(s1, s);
                    }
                    if(z1 != null) {
                        f0.put(s1, z1);
                    }
                }
                if(z1 != null) {
                    z1.f();
                }
            }
        }
        for(Object object1: list0) {
            String s2 = (String)object1;
            if(!list1.contains(s2)) {
                z z2 = (z)f0.remove(s2);
                if(z2 != null) {
                    z2.i(0);
                    z2.e();
                }
            }
        }
    }

    public final void d(u u0, Collection collection0) {
        RoutingSessionInfo routingSessionInfo0 = this.h;
        if(routingSessionInfo0 == null) {
            Log.w("MR2ProviderService", "updateSessionInfo: mSessionInfo is null. This shouldn\'t happen.");
            return;
        }
        t t0 = this.k;
        if(u0 != null && !u0.a.getBoolean("enabled", true)) {
            t0.onReleaseSession(0L, this.i);
            return;
        }
        RoutingSessionInfo.Builder routingSessionInfo$Builder0 = p.f(routingSessionInfo0);
        if(u0 != null) {
            this.j = u0.f();
            routingSessionInfo$Builder0.setName(u0.g()).setVolume(u0.h()).setVolumeMax(u0.j()).setVolumeHandling(u0.i());
            routingSessionInfo$Builder0.clearSelectedRoutes();
            if(u0.d().isEmpty()) {
                routingSessionInfo$Builder0.addSelectedRoute(this.j);
            }
            else {
                for(Object object0: u0.d()) {
                    routingSessionInfo$Builder0.addSelectedRoute(((String)object0));
                }
            }
            Bundle bundle0 = routingSessionInfo0.getControlHints();
            if(bundle0 == null) {
                Log.w("MR2ProviderService", "updateSessionInfo: controlHints is null. This shouldn\'t happen.");
                bundle0 = new Bundle();
            }
            bundle0.putString("androidx.mediarouter.media.KEY_SESSION_NAME", u0.g());
            bundle0.putBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE", u0.a);
            routingSessionInfo$Builder0.setControlHints(bundle0);
        }
        this.h = routingSessionInfo$Builder0.build();
        if(collection0 != null && !collection0.isEmpty()) {
            routingSessionInfo$Builder0.clearSelectedRoutes();
            p.x(routingSessionInfo$Builder0);
            routingSessionInfo$Builder0.clearDeselectableRoutes();
            routingSessionInfo$Builder0.clearTransferableRoutes();
            boolean z = false;
            for(Object object1: collection0) {
                String s = ((w)object1).a.f();
                switch(((w)object1).b) {
                    case 2: 
                    case 3: {
                        routingSessionInfo$Builder0.addSelectedRoute(s);
                        z = true;
                    }
                }
                if(((w)object1).d) {
                    routingSessionInfo$Builder0.addSelectableRoute(s);
                }
                if(((w)object1).c) {
                    p.y(routingSessionInfo$Builder0, s);
                }
                if(((w)object1).e) {
                    routingSessionInfo$Builder0.addTransferableRoute(s);
                }
            }
            if(z) {
                this.h = routingSessionInfo$Builder0.build();
            }
        }
        if((this.d & 5) == 5 && u0 != null) {
            this.c(u0.f(), routingSessionInfo0, this.h, A.b);
        }
        if(!this.f) {
            this.f = true;
            t0.notifySessionCreated(this.c, this.h);
            return;
        }
        t0.notifySessionUpdated(this.h);
    }
}

