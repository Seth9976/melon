package l4;

import P1.c;
import android.content.Context;
import android.media.MediaRoute2ProviderService;
import android.media.RouteDiscoveryPreference;
import android.media.RoutingSessionInfo.Builder;
import android.media.RoutingSessionInfo;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import androidx.appcompat.app.o;
import androidx.collection.f;
import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.MediaRouteProviderService;
import df.B;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Objects;

public final class t extends MediaRoute2ProviderService {
    public final Object a;
    public final C b;
    public final f c;
    public final SparseArray d;
    public volatile B e;
    public static final int f;

    static {
        Log.isLoggable("MR2ProviderService", 3);
    }

    public t(C c0) {
        this.a = new Object();
        this.c = new f(0);  // 初始化器: Landroidx/collection/V;-><init>(I)V
        this.d = new SparseArray();
        this.b = c0;
    }

    public final String a(s s0) {
        synchronized(this.a) {
            while(this.c.containsKey("04dfe952-d395-422f-b33f-d9b48b460497")) {
            }
            s0.i = "04dfe952-d395-422f-b33f-d9b48b460497";
            this.c.put("04dfe952-d395-422f-b33f-d9b48b460497", s0);
            return "04dfe952-d395-422f-b33f-d9b48b460497";
        }
    }

    @Override  // android.app.Service
    public final void attachBaseContext(Context context0) {
        super.attachBaseContext(context0);
    }

    public final z b(String s) {
        synchronized(this.a) {
            ArrayList arrayList0 = new ArrayList(this.c.values());
        }
        for(Object object0: arrayList0) {
            l4.B b0 = (l4.B)((s)object0).e.get();
            z z0 = b0 == null ? ((z)((s)object0).a.get(s)) : ((z)b0.i.get(s));
            if(z0 != null) {
                return z0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public final y c(String s) {
        synchronized(this.a) {
            s s1 = (s)this.c.get(s);
            return s1 == null ? null : s1.b;
        }
    }

    public final u d(String s, String s1) {
        MediaRouteProviderService mediaRouteProviderService0 = this.b.a;
        if((mediaRouteProviderService0 == null ? null : mediaRouteProviderService0.d) != null && this.e != null) {
            for(Object object0: this.e.b) {
                u u0 = (u)object0;
                if(TextUtils.equals(u0.f(), s)) {
                    return u0;
                }
                if(false) {
                    break;
                }
            }
            Log.w("MR2ProviderService", s1 + ": Couldn\'t find a route : " + s);
            return null;
        }
        Log.w("MR2ProviderService", s1 + ": no provider info");
        return null;
    }

    public final void e(l4.B b0, z z0, int v, String s, String s1) {
        y y0;
        int v1;
        u u0 = this.d(s1, "notifyRouteControllerAdded");
        if(u0 == null) {
            return;
        }
        if(z0 instanceof y) {
            v1 = 6;
            y0 = (y)z0;
        }
        else {
            v1 = u0.d().isEmpty() ? 0 : 2;
            y0 = new r(s1, z0);
        }
        s s2 = new s(this, y0, 0L, v1, b0);
        s2.j = s1;
        String s3 = this.a(s2);
        this.d.put(v, s3);
        RoutingSessionInfo.Builder routingSessionInfo$Builder0 = i.f(s3, s).setName(u0.g()).setVolumeHandling(u0.i()).setVolume(u0.h()).setVolumeMax(u0.j());
        if(u0.d().isEmpty()) {
            routingSessionInfo$Builder0.addSelectedRoute(s1);
        }
        else {
            for(Object object0: u0.d()) {
                routingSessionInfo$Builder0.addSelectedRoute(((String)object0));
            }
        }
        s2.b(routingSessionInfo$Builder0.build());
    }

    public final void f(int v) {
        s s1;
        String s = (String)this.d.get(v);
        if(s != null) {
            this.d.remove(v);
            synchronized(this.a) {
                s1 = (s)this.c.remove(s);
            }
            if(s1 != null) {
                s1.a(false);
            }
        }
    }

    public final void g(y y0, u u0, Collection collection0) {
        s s0;
        synchronized(this.a) {
            for(Object object1: this.c.entrySet()) {
                s0 = (s)((Map.Entry)object1).getValue();
                if(s0.b != y0) {
                    continue;
                }
                goto label_14;
            }
        }
        s0 = null;
    label_14:
        if(s0 == null) {
            Log.w("MR2ProviderService", "setDynamicRouteDescriptor: Ignoring unknown controller");
            return;
        }
        s0.d(u0, collection0);
    }

    @Override  // android.media.MediaRoute2ProviderService
    public final void onCreateSession(long v, String s, String s1, Bundle bundle0) {
        y y1;
        int v1;
        MediaRouteProviderService mediaRouteProviderService0 = this.b.a;
        MediaRouteProvider mediaRouteProvider0 = mediaRouteProviderService0 == null ? null : mediaRouteProviderService0.d;
        u u0 = this.d(s1, "onCreateSession");
        if(u0 == null) {
            i.C(this, v);
            return;
        }
        Bundle bundle1 = new Bundle();
        bundle1.putParcelable("controlHints", bundle0);
        bundle1.putString("clientPackageName", s);
        A a0 = new A(bundle1);
        if(this.e.c) {
            y y0 = mediaRouteProvider0.a(s1, a0);
            if(y0 == null) {
                Log.w("MR2ProviderService", "onCreateSession: Couldn\'t create a dynamic controller");
                p.r(this, v);
                return;
            }
            v1 = 7;
            y1 = y0;
        }
        else {
            z z0 = mediaRouteProvider0.d(s1, a0);
            if(z0 == null) {
                Log.w("MR2ProviderService", "onCreateSession: Couldn\'t create a controller");
                p.r(this, v);
                return;
            }
            v1 = u0.d().isEmpty() ? 1 : 3;
            y1 = new r(s1, z0);
        }
        y1.f();
        s s2 = new s(this, y1, v, v1, null);
        RoutingSessionInfo.Builder routingSessionInfo$Builder0 = i.f(this.a(s2), s).setName(u0.g()).setVolumeHandling(u0.i()).setVolume(u0.h()).setVolumeMax(u0.j());
        if(u0.d().isEmpty()) {
            routingSessionInfo$Builder0.addSelectedRoute(s1);
        }
        else {
            for(Object object0: u0.d()) {
                routingSessionInfo$Builder0.addSelectedRoute(((String)object0));
            }
        }
        RoutingSessionInfo routingSessionInfo0 = routingSessionInfo$Builder0.build();
        s2.b(routingSessionInfo0);
        if((v1 & 4) == 0) {
            if((v1 & 2) == 0) {
                s2.a.put(s1, s2.b);
            }
            else {
                s2.c(s1, null, routingSessionInfo0, a0);
            }
        }
        y1.q(c.getMainExecutor(this.b.a.getApplicationContext()), this.b.j);
    }

    @Override  // android.media.MediaRoute2ProviderService
    public final void onDeselectRoute(long v, String s, String s1) {
        if(this.getSessionInfo(s) == null) {
            Log.w("MR2ProviderService", "onDeselectRoute: Couldn\'t find a session");
            i.u(this, v);
            return;
        }
        if(this.d(s1, "onDeselectRoute") == null) {
            i.C(this, v);
            return;
        }
        y y0 = this.c(s);
        if(y0 == null) {
            Log.w("MR2ProviderService", "onDeselectRoute: Couldn\'t find a controller");
            i.C(this, v);
            return;
        }
        y0.o(s1);
    }

    @Override  // android.media.MediaRoute2ProviderService
    public final void onDiscoveryPreferenceChanged(RouteDiscoveryPreference routeDiscoveryPreference0) {
        G g0;
        ArrayList arrayList1;
        ArrayList arrayList0 = new ArrayList();
        Iterator iterator0 = routeDiscoveryPreference0.getPreferredFeatures().iterator();
        while(true) {
            arrayList1 = null;
            if(!iterator0.hasNext()) {
                break;
            }
            Object object0 = iterator0.next();
            String s = (String)object0;
            s.getClass();
            switch(s) {
                case "android.media.route.feature.LIVE_AUDIO": {
                    s = "android.media.intent.category.LIVE_AUDIO";
                    break;
                }
                case "android.media.route.feature.LIVE_VIDEO": {
                    s = "android.media.intent.category.LIVE_VIDEO";
                    break;
                }
                case "android.media.route.feature.REMOTE_AUDIO_PLAYBACK": {
                    s = "android.media.intent.category.REMOTE_AUDIO_PLAYBACK";
                    break;
                }
                case "android.media.route.feature.REMOTE_PLAYBACK": {
                    s = "android.media.intent.category.REMOTE_PLAYBACK";
                    break;
                }
                case "android.media.route.feature.REMOTE_VIDEO_PLAYBACK": {
                    s = "android.media.intent.category.REMOTE_VIDEO_PLAYBACK";
                }
            }
            arrayList0.add(s);
        }
        if(!arrayList0.isEmpty()) {
            for(Object object1: arrayList0) {
                String s1 = (String)object1;
                if(s1 == null) {
                    throw new IllegalArgumentException("category must not be null");
                }
                if(arrayList1 == null) {
                    arrayList1 = new ArrayList();
                }
                if(!arrayList1.contains(s1)) {
                    arrayList1.add(s1);
                }
            }
        }
        if(arrayList1 == null) {
            g0 = G.c;
        }
        else {
            Bundle bundle0 = new Bundle();
            bundle0.putStringArrayList("controlCategories", arrayList1);
            g0 = new G(bundle0, arrayList1);
        }
        v v0 = new v(g0, routeDiscoveryPreference0.shouldPerformActiveScan());
        C c0 = this.b;
        c0.getClass();
        long v1 = SystemClock.elapsedRealtime();
        if(Objects.equals(c0.d, v0) && !v0.b()) {
            return;
        }
        c0.d = v0;
        c0.e = v1;
        c0.h();
    }

    @Override  // android.media.MediaRoute2ProviderService
    public final void onReleaseSession(long v, String s) {
        s s1;
        if(this.getSessionInfo(s) == null) {
            return;
        }
        synchronized(this.a) {
            s1 = (s)this.c.remove(s);
        }
        if(s1 == null) {
            Log.w("MR2ProviderService", "onReleaseSession: Couldn\'t find a session");
            i.u(this, v);
            return;
        }
        s1.a(true);
    }

    @Override  // android.media.MediaRoute2ProviderService
    public final void onSelectRoute(long v, String s, String s1) {
        if(this.getSessionInfo(s) == null) {
            Log.w("MR2ProviderService", "onSelectRoute: Couldn\'t find a session");
            i.u(this, v);
            return;
        }
        if(this.d(s1, "onSelectRoute") == null) {
            i.C(this, v);
            return;
        }
        y y0 = this.c(s);
        if(y0 == null) {
            Log.w("MR2ProviderService", "onSelectRoute: Couldn\'t find a controller");
            i.C(this, v);
            return;
        }
        y0.n(s1);
    }

    @Override  // android.media.MediaRoute2ProviderService
    public final void onSetRouteVolume(long v, String s, int v1) {
        z z0 = this.b(s);
        if(z0 == null) {
            o.A("onSetRouteVolume: Couldn\'t find a controller for routeId=", s, "MR2ProviderService");
            i.C(this, v);
            return;
        }
        z0.g(v1);
    }

    @Override  // android.media.MediaRoute2ProviderService
    public final void onSetSessionVolume(long v, String s, int v1) {
        if(this.getSessionInfo(s) == null) {
            Log.w("MR2ProviderService", "onSetSessionVolume: Couldn\'t find a session");
            i.u(this, v);
            return;
        }
        y y0 = this.c(s);
        if(y0 == null) {
            Log.w("MR2ProviderService", "onSetSessionVolume: Couldn\'t find a controller");
            i.C(this, v);
            return;
        }
        y0.g(v1);
    }

    @Override  // android.media.MediaRoute2ProviderService
    public final void onTransferToRoute(long v, String s, String s1) {
        if(this.getSessionInfo(s) == null) {
            Log.w("MR2ProviderService", "onTransferToRoute: Couldn\'t find a session");
            i.u(this, v);
            return;
        }
        if(this.d(s1, "onTransferToRoute") == null) {
            i.C(this, v);
            return;
        }
        y y0 = this.c(s);
        if(y0 == null) {
            Log.w("MR2ProviderService", "onTransferToRoute: Couldn\'t find a controller");
            i.C(this, v);
            return;
        }
        y0.p(Collections.singletonList(s1));
    }
}

