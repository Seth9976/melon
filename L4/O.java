package l4;

import android.content.Context;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2.RouteCallback;
import android.media.MediaRouter2.RoutingController;
import android.media.MediaRouter2;
import android.media.RouteDiscoveryPreference;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.Log;
import androidx.media3.session.p0;
import androidx.mediarouter.media.MediaRouteProvider;
import com.google.android.material.internal.F;
import d5.i;
import d5.w;
import df.B;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map.Entry;

public final class o extends MediaRouteProvider {
    public final ArrayMap B;
    public String D;
    public static final int E;
    public final MediaRouter2 i;
    public final a j;
    public final ArrayMap k;
    public final MediaRouter2.RouteCallback l;
    public final n m;
    public final j n;
    public final p0 o;
    public boolean r;
    public ArrayList w;

    static {
        Log.isLoggable("MR2Provider", 3);
    }

    public o(Context context0, a a0) {
        super(context0);
        this.k = new ArrayMap();
        this.m = new n(this);
        this.n = new j(this);
        this.w = new ArrayList();
        this.B = new ArrayMap();
        this.i = F.i(context0);
        this.j = a0;
        this.o = new p0(new Handler(Looper.getMainLooper()), 1);
        if(Build.VERSION.SDK_INT >= 34) {
            this.l = new m(this, 1);
            return;
        }
        this.l = new m(this, 0);
    }

    @Override  // androidx.mediarouter.media.MediaRouteProvider
    public final y a(String s, A a0) {
        for(Object object0: this.k.entrySet()) {
            y y0 = (k)((Map.Entry)object0).getValue();
            if(TextUtils.equals(s, y0.f)) {
                return y0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    @Override  // androidx.mediarouter.media.MediaRouteProvider
    public final z b(String s) {
        return new l(((String)this.B.get(s)), null);
    }

    @Override  // androidx.mediarouter.media.MediaRouteProvider
    public final z c(String s, String s1) {
        String s2 = (String)this.B.get(s);
        for(Object object0: this.k.values()) {
            k k0 = (k)object0;
            u u0 = k0.o;
            if(TextUtils.equals(s1, (u0 == null ? k0.g.getId() : u0.f()))) {
                return new l(s2, k0);
            }
            if(false) {
                break;
            }
        }
        Log.w("MR2Provider", "Could not find the matching GroupRouteController. routeId=" + s + ", routeGroupId=" + s1);
        return new l(s2, null);
    }

    @Override  // androidx.mediarouter.media.MediaRouteProvider
    public final void e(v v0) {
        RouteDiscoveryPreference routeDiscoveryPreference0;
        G g0;
        ArrayList arrayList1;
        int v1 = Q.c == null ? 0 : Q.c().C;
        MediaRouter2.RouteCallback mediaRouter2$RouteCallback0 = this.l;
        j j0 = this.n;
        n n0 = this.m;
        if(v1 > 0) {
            T t0 = Q.c().v;
            boolean z = t0 == null ? false : t0.c;
            if(v0 == null) {
                v0 = new v(G.c, false);
            }
            v0.a();
            ArrayList arrayList0 = v0.b.c();
            if(!z) {
                arrayList0.remove("android.media.intent.category.LIVE_AUDIO");
            }
            else if(!arrayList0.contains("android.media.intent.category.LIVE_AUDIO")) {
                arrayList0.add("android.media.intent.category.LIVE_AUDIO");
            }
            if(arrayList0.isEmpty()) {
                arrayList1 = null;
            }
            else {
                arrayList1 = null;
                for(Object object0: arrayList0) {
                    String s = (String)object0;
                    if(s == null) {
                        throw new IllegalArgumentException("category must not be null");
                    }
                    if(arrayList1 == null) {
                        arrayList1 = new ArrayList();
                    }
                    if(!arrayList1.contains(s)) {
                        arrayList1.add(s);
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
            boolean z1 = v0.b();
            if(g0 == null) {
                throw new IllegalArgumentException("selector must not be null");
            }
            Bundle bundle1 = new Bundle();
            bundle1.putBundle("selector", g0.a);
            bundle1.putBoolean("activeScan", z1);
            MediaRouter2 mediaRouter20 = this.i;
            g0.a();
            if(g0.b.contains(null)) {
                routeDiscoveryPreference0 = P.h(new ArrayList()).build();
            }
            else {
                boolean z2 = bundle1.getBoolean("activeScan");
                ArrayList arrayList2 = new ArrayList();
                for(Object object1: g0.c()) {
                    String s1 = (String)object1;
                    s1.getClass();
                    switch(s1) {
                        case "android.media.intent.category.LIVE_AUDIO": {
                            s1 = "android.media.route.feature.LIVE_AUDIO";
                            break;
                        }
                        case "android.media.intent.category.LIVE_VIDEO": {
                            s1 = "android.media.route.feature.LIVE_VIDEO";
                            break;
                        }
                        case "android.media.intent.category.REMOTE_AUDIO_PLAYBACK": {
                            s1 = "android.media.route.feature.REMOTE_AUDIO_PLAYBACK";
                            break;
                        }
                        case "android.media.intent.category.REMOTE_PLAYBACK": {
                            s1 = "android.media.route.feature.REMOTE_PLAYBACK";
                            break;
                        }
                        case "android.media.intent.category.REMOTE_VIDEO_PLAYBACK": {
                            s1 = "android.media.route.feature.REMOTE_VIDEO_PLAYBACK";
                        }
                    }
                    arrayList2.add(s1);
                }
                routeDiscoveryPreference0 = P.i(arrayList2, z2).build();
            }
            mediaRouter20.registerRouteCallback(this.o, mediaRouter2$RouteCallback0, routeDiscoveryPreference0);
            this.i.registerTransferCallback(this.o, n0);
            this.i.registerControllerCallback(this.o, j0);
            return;
        }
        F.s(this.i, mediaRouter2$RouteCallback0);
        F.u(this.i, n0);
        F.t(this.i, j0);
    }

    public final MediaRoute2Info h(String s) {
        if(s != null) {
            for(Object object0: this.w) {
                MediaRoute2Info mediaRoute2Info0 = (MediaRoute2Info)object0;
                if(TextUtils.equals(mediaRoute2Info0.getId(), s)) {
                    return mediaRoute2Info0;
                }
                if(false) {
                    break;
                }
            }
        }
        return null;
    }

    public final void i() {
        ArrayList arrayList0 = new ArrayList();
        ArraySet arraySet0 = new ArraySet();
        for(Object object0: F.r(this.i)) {
            MediaRoute2Info mediaRoute2Info0 = (MediaRoute2Info)object0;
            if(mediaRoute2Info0 != null && !arraySet0.contains(mediaRoute2Info0) && !mediaRoute2Info0.isSystemRoute() && (!this.r || mediaRoute2Info0.getId().startsWith("com.iloen.melon/"))) {
                arraySet0.add(mediaRoute2Info0);
                arrayList0.add(mediaRoute2Info0);
            }
        }
        if(arrayList0.equals(this.w)) {
            return;
        }
        this.w = arrayList0;
        ArrayMap arrayMap0 = this.B;
        arrayMap0.clear();
        for(Object object1: this.w) {
            MediaRoute2Info mediaRoute2Info1 = (MediaRoute2Info)object1;
            Bundle bundle0 = mediaRoute2Info1.getExtras();
            if(bundle0 != null && bundle0.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID") != null) {
                arrayMap0.put(mediaRoute2Info1.getId(), bundle0.getString("androidx.mediarouter.media.KEY_ORIGINAL_ROUTE_ID"));
            }
            else {
                Log.w("MR2Provider", "Cannot find the original route Id. route=" + mediaRoute2Info1);
            }
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object2: this.w) {
            u u0 = w.T(((MediaRoute2Info)object2));
            if(u0 != null) {
                arrayList1.add(u0);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        if(!arrayList1.isEmpty()) {
            for(Object object3: arrayList1) {
                if(((u)object3) == null) {
                    throw new IllegalArgumentException("route must not be null");
                }
                if(arrayList2.contains(((u)object3))) {
                    throw new IllegalArgumentException("route descriptor already added");
                }
                arrayList2.add(((u)object3));
            }
        }
        this.f(new B(arrayList2, true));
    }

    public final void j(MediaRouter2.RoutingController mediaRouter2$RoutingController0) {
        i i0;
        Object object0 = this.k.get(mediaRouter2$RoutingController0);
        if(((k)object0) == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No matching routeController found. routingController=" + mediaRouter2$RoutingController0);
            return;
        }
        List list0 = F.q(mediaRouter2$RoutingController0);
        if(list0.isEmpty()) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: No selected routes. This may happen when the selected routes become invalid.routingController=" + mediaRouter2$RoutingController0);
            return;
        }
        ArrayList arrayList0 = w.D(list0);
        u u0 = w.T(l4.i.b(list0.get(0)));
        Bundle bundle0 = F.j(mediaRouter2$RoutingController0);
        String s = "Group";
        u u1 = null;
        if(bundle0 != null) {
            try {
                String s1 = bundle0.getString("androidx.mediarouter.media.KEY_SESSION_NAME");
                if(!TextUtils.isEmpty(s1)) {
                    s = s1;
                }
                Bundle bundle1 = bundle0.getBundle("androidx.mediarouter.media.KEY_GROUP_ROUTE");
                if(bundle1 != null) {
                    u1 = new u(bundle1);
                }
            }
            catch(Exception exception0) {
                Log.w("MR2Provider", "Exception while unparceling control hints.", exception0);
            }
        }
        if(u1 == null) {
            i0 = new i(mediaRouter2$RoutingController0.getId(), s);
            Bundle bundle2 = (Bundle)i0.a;
            bundle2.putInt("connectionState", 2);
            bundle2.putInt("playbackType", 1);
        }
        else {
            i i1 = new i();  // 初始化器: Ljava/lang/Object;-><init>()V
            i1.b = new ArrayList();
            i1.c = new ArrayList();
            i1.d = new HashSet();
            i1.a = new Bundle(u1.a);
            i1.b = u1.d();
            i1.c = u1.b();
            i1.d = u1.a();
            i0 = i1;
        }
        Bundle bundle3 = (Bundle)i0.a;
        bundle3.putInt("volume", F.c(mediaRouter2$RoutingController0));
        bundle3.putInt("volumeMax", mediaRouter2$RoutingController0.getVolumeMax());
        bundle3.putInt("volumeHandling", mediaRouter2$RoutingController0.getVolumeHandling());
        ((ArrayList)i0.c).clear();
        i0.a(u0.b());
        ((ArrayList)i0.b).clear();
        i0.b(arrayList0);
        u u2 = i0.d();
        ArrayList arrayList1 = w.D(mediaRouter2$RoutingController0.getSelectableRoutes());
        ArrayList arrayList2 = w.D(mediaRouter2$RoutingController0.getDeselectableRoutes());
        B b0 = this.g;
        if(b0 == null) {
            Log.w("MR2Provider", "setDynamicRouteDescriptors: providerDescriptor is not set.");
            return;
        }
        ArrayList arrayList3 = new ArrayList();
        List list1 = b0.b;
        if(!list1.isEmpty()) {
            for(Object object1: list1) {
                String s2 = ((u)object1).f();
                int v = arrayList0.contains(s2) ? 3 : 1;
                boolean z = arrayList1.contains(s2);
                arrayList3.add(new l4.w(((u)object1), v, arrayList2.contains(s2), z, true));
            }
        }
        ((k)object0).o = u2;
        ((k)object0).m(u2, arrayList3);
    }
}

