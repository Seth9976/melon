package l4;

import E9.t;
import M6.B;
import P1.c;
import V3.d;
import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.MediaRoute2Info;
import android.media.MediaRouter2.RoutingController;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.media.session.MediaSessionCompat;
import android.text.TextUtils;
import android.util.Log;
import androidx.media3.exoplayer.j0;
import androidx.media3.session.w;
import androidx.mediarouter.media.MediaRouteProvider;
import androidx.mediarouter.media.MediaTransferReceiver;
import e3.m;
import i.n.i.b.a.s.e.u9;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Objects;

public final class h {
    public v A;
    public v B;
    public int C;
    public e D;
    public MediaSessionCompat E;
    public final a F;
    public static final int G;
    public final b a;
    public final HashMap b;
    public final m c;
    public O d;
    public z e;
    public L f;
    public M g;
    public final Context h;
    public final ArrayList i;
    public final ArrayList j;
    public final HashMap k;
    public final HashMap l;
    public final ArrayList m;
    public final ArrayList n;
    public final d o;
    public final f p;
    public final boolean q;
    public final boolean r;
    public o s;
    public final W t;
    public final j0 u;
    public T v;
    public O w;
    public O x;
    public O y;
    public y z;

    static {
        Log.isLoggable("AxMediaRouter", 3);
    }

    public h(Context context0) {
        boolean z;
        this.a = new b(this);
        this.b = new HashMap();
        this.i = new ArrayList();
        this.j = new ArrayList();
        this.k = new HashMap();
        this.l = new HashMap();
        this.m = new ArrayList();
        this.n = new ArrayList();
        d d0 = new d();
        d0.d = 0;
        d0.e = 3;
        this.o = d0;
        this.p = new f(this, 0);
        this.F = new a(this);
        this.h = context0;
        this.q = ((ActivityManager)context0.getSystemService("activity")).isLowRamDevice();
        int v = Build.VERSION.SDK_INT;
        if(v >= 30) {
            Intent intent0 = new Intent(context0, MediaTransferReceiver.class);
            intent0.setPackage("com.iloen.melon");
            z = context0.getPackageManager().queryBroadcastReceivers(intent0, 0).size() > 0;
        }
        else {
            z = false;
        }
        this.r = z;
        Intent intent1 = new Intent(context0, l0.class);
        intent1.setPackage("com.iloen.melon");
        context0.getPackageManager().queryBroadcastReceivers(intent1, 0).size();
        this.s = v < 30 || !z ? null : new o(context0, new a(this));
        W w0 = new W(context0, this);
        this.t = w0;
        this.u = new j0(new u9(this, 14));
        this.a(w0, true);
        o o0 = this.s;
        if(o0 != null) {
            this.a(o0, true);
        }
        m m0 = new m(context0, this);
        this.c = m0;
        Handler handler0 = (Handler)m0.e;
        if(!m0.b) {
            m0.b = true;
            IntentFilter intentFilter0 = new IntentFilter();
            intentFilter0.addAction("android.intent.action.PACKAGE_ADDED");
            intentFilter0.addAction("android.intent.action.PACKAGE_REMOVED");
            intentFilter0.addAction("android.intent.action.PACKAGE_CHANGED");
            intentFilter0.addAction("android.intent.action.PACKAGE_REPLACED");
            intentFilter0.addAction("android.intent.action.PACKAGE_RESTARTED");
            intentFilter0.addDataScheme("package");
            ((Context)m0.c).registerReceiver(((androidx.appcompat.app.z)m0.h), intentFilter0, null, handler0);
            handler0.post(((t)m0.i));
        }
    }

    public final void a(MediaRouteProvider mediaRouteProvider0, boolean z) {
        if(this.d(mediaRouteProvider0) == null) {
            N n0 = new N(mediaRouteProvider0, z);
            this.m.add(n0);
            this.a.b(0x201, n0);
            this.p(n0, mediaRouteProvider0.g);
            Q.b();
            mediaRouteProvider0.d = this.p;
            mediaRouteProvider0.g(this.A);
        }
    }

    public final String b(N n0, String s) {
        String s3;
        String s1 = ((ComponentName)n0.d.b).flattenToShortString();
        String s2 = n0.c ? s : s1 + ":" + s;
        HashMap hashMap0 = this.l;
        if(!n0.c) {
            ArrayList arrayList0 = this.j;
            int v = arrayList0.size();
            int v1;
            for(v1 = 0; true; ++v1) {
                if(v1 >= v) {
                    v1 = -1;
                    break;
                }
                if(((O)arrayList0.get(v1)).c.equals(s2)) {
                    break;
                }
            }
            if(v1 >= 0) {
                Log.w("AxMediaRouter", "Either " + s + " isn\'t unique in " + s1 + " or we\'re trying to assign a unique ID for an already added route");
                int v2 = 2;
                while(true) {
                    s3 = s2 + "_" + v2;
                    int v3 = arrayList0.size();
                    int v4 = 0;
                    while(true) {
                        if(v4 < v3) {
                            if(((O)arrayList0.get(v4)).c.equals(s3)) {
                                break;
                            }
                            else {
                                ++v4;
                                continue;
                            }
                        }
                        v4 = -1;
                        break;
                    }
                    if(v4 < 0) {
                        break;
                    }
                    ++v2;
                }
                hashMap0.put(new b2.b(s1, s), s3);
                return s3;
            }
        }
        hashMap0.put(new b2.b(s1, s), s2);
        return s2;
    }

    public final O c() {
        for(Object object0: this.j) {
            O o0 = (O)object0;
            if(o0 != this.w && o0.c() == this.t && o0.m("android.media.intent.category.LIVE_AUDIO") && !o0.m("android.media.intent.category.LIVE_VIDEO") && o0.f()) {
                return o0;
            }
            if(false) {
                break;
            }
        }
        return this.w;
    }

    public final N d(MediaRouteProvider mediaRouteProvider0) {
        for(Object object0: this.m) {
            N n0 = (N)object0;
            if(n0.a == mediaRouteProvider0) {
                return n0;
            }
            if(false) {
                break;
            }
        }
        return null;
    }

    public final void e() {
        Iterator iterator0 = this.k.values().iterator();
        if(iterator0.hasNext()) {
            throw H0.b.b(iterator0);
        }
    }

    public final z f(O o0) {
        if(o0 == this.d) {
            z z0 = this.e;
            if(z0 != null) {
                return z0;
            }
        }
        if(o0 instanceof K && ((K)o0).n()) {
            this.e();
            return null;
        }
        z z1 = (z)this.b.get(o0.c);
        if(z1 != null) {
            return z1;
        }
        Iterator iterator0 = this.k.values().iterator();
        if(iterator0.hasNext()) {
            throw H0.b.b(iterator0);
        }
        return null;
    }

    public final O g() {
        O o0 = this.d;
        if(o0 == null) {
            throw new IllegalStateException("There is no currently selected route.  The media router has not yet been fully initialized.");
        }
        return o0;
    }

    // 去混淆评级： 低(30)
    public final boolean h() {
        return this.r && (this.v == null || this.v.a);
    }

    public final void i() {
        if(this.d.e()) {
            List list0 = Collections.unmodifiableList(this.d.v);
            HashSet hashSet0 = new HashSet();
            for(Object object0: list0) {
                hashSet0.add(((O)object0).c);
            }
            HashMap hashMap0 = this.b;
            Iterator iterator1 = hashMap0.entrySet().iterator();
            while(iterator1.hasNext()) {
                Object object1 = iterator1.next();
                Map.Entry map$Entry0 = (Map.Entry)object1;
                if(!hashSet0.contains(map$Entry0.getKey())) {
                    z z0 = (z)map$Entry0.getValue();
                    z0.i(0);
                    z0.e();
                    iterator1.remove();
                }
            }
            for(Object object2: list0) {
                O o0 = (O)object2;
                if(!hashMap0.containsKey(o0.c)) {
                    z z1 = o0.c().c(o0.b, this.d.b);
                    if(z1 != null) {
                        z1.f();
                        hashMap0.put(o0.c, z1);
                    }
                }
            }
        }
    }

    public final void j(h h0, O o0, z z0, int v, boolean z1, O o1, Collection collection0) {
        M m0 = this.g;
        if(m0 != null) {
            m0.a();
            this.g = null;
        }
        M m1 = new M(h0, o0, z0, v, z1, o1, collection0);
        this.g = m1;
        if(m1.b == 3) {
            L l0 = this.f;
            if(l0 != null) {
                B b0 = l0.onPrepareTransfer(this.d, m1.e);
                if(b0 == null) {
                    this.g.b();
                    return;
                }
                M m2 = this.g;
                h h1 = (h)m2.h.get();
                if(h1 != null && h1.g == m2) {
                    if(m2.i != null) {
                        throw new IllegalStateException("future is already set");
                    }
                    m2.i = b0;
                    u9 u90 = new u9(m2, 16);
                    Objects.requireNonNull(h1.a);
                    b0.addListener(u90, new w(h1.a, 3));
                    return;
                }
                Log.w("AxMediaRouter", "Router is released. Cancel transfer");
                m2.a();
                return;
            }
        }
        m1.b();
    }

    public final void k(MediaRouteProvider mediaRouteProvider0) {
        N n0 = this.d(mediaRouteProvider0);
        if(n0 != null) {
            mediaRouteProvider0.getClass();
            Q.b();
            mediaRouteProvider0.d = null;
            mediaRouteProvider0.g(null);
            this.p(n0, null);
            this.a.b(0x202, n0);
            this.m.remove(n0);
        }
    }

    public final void l(O o0, int v, boolean z) {
        if(!this.j.contains(o0)) {
            Log.w("AxMediaRouter", "Ignoring attempt to select removed route: " + o0);
            return;
        }
        if(!o0.g) {
            Log.w("AxMediaRouter", "Ignoring attempt to select disabled route: " + o0);
            return;
        }
        O o1 = this.d;
        if(o1 != o0) {
            K k0 = o1 == null ? null : o1.a();
            if(k0 == null || Collections.unmodifiableList(k0.v).size() != 1) {
                goto label_13;
            }
            l4.w w0 = (l4.w)k0.x.get(o0.c);
            int v1 = w0 == null ? 4 : w0.b;
            if(v1 != 2 && v1 != 3) {
            label_13:
                if(Build.VERSION.SDK_INT >= 30) {
                    MediaRouteProvider mediaRouteProvider0 = o0.c();
                    o o2 = this.s;
                    if(mediaRouteProvider0 == o2 && this.d != o0) {
                        String s = o0.b;
                        MediaRoute2Info mediaRoute2Info0 = o2.h(s);
                        if(mediaRoute2Info0 == null) {
                            androidx.appcompat.app.o.A("transferTo: Specified route not found. routeId=", s, "MR2Provider");
                            return;
                        }
                        if(TextUtils.equals(o2.D, s)) {
                            Log.w("MR2Provider", "Ignoring attempt to transfer to pending transfer route: " + mediaRoute2Info0);
                            return;
                        }
                        o2.D = s;
                        i.p(o2.i, mediaRoute2Info0);
                        return;
                    }
                }
                this.m(o0, v, z);
                return;
            }
        }
        Log.w("AxMediaRouter", "Ignoring attempt to select selected route: " + o0);
    }

    public final void m(O o0, int v, boolean z) {
        String s1;
        boolean z1 = false;
        if(this.d == o0) {
            return;
        }
        Context context0 = this.h;
        if(this.x != null && o0 == this.w) {
            StackTraceElement[] arr_stackTraceElement = Thread.currentThread().getStackTrace();
            StringBuilder stringBuilder0 = new StringBuilder("- Stacktrace: [");
            int v1 = 3;
            while(v1 < arr_stackTraceElement.length) {
                StackTraceElement stackTraceElement0 = arr_stackTraceElement[v1];
                stringBuilder0.append(stackTraceElement0.getClassName());
                stringBuilder0.append(".");
                stringBuilder0.append(stackTraceElement0.getMethodName());
                stringBuilder0.append(":");
                stringBuilder0.append(stackTraceElement0.getLineNumber());
                ++v1;
                if(v1 < arr_stackTraceElement.length) {
                    stringBuilder0.append(", ");
                }
            }
            stringBuilder0.append("]");
            O o1 = this.d;
            if(o1 == null) {
                s1 = null;
            }
            else {
                String s = o1.d;
                Q.b();
                if(Q.c().x == o1) {
                    z1 = true;
                }
                s1 = s + "(BT=" + z1 + ", syncMediaRoute1Provider=" + z + ")";
            }
            StringBuilder stringBuilder1 = com.iloen.melon.utils.a.n("Changing selection(", s1, ") to default while BT is available: pkgName=");
            stringBuilder1.append("com.iloen.melon");
            stringBuilder1.append(stringBuilder0);
            Log.w("AxMediaRouter", stringBuilder1.toString());
        }
        if(this.y != null) {
            this.y = null;
            y y0 = this.z;
            if(y0 != null) {
                y0.i(3);
                this.z.e();
                this.z = null;
            }
        }
        if(this.h()) {
            df.B b0 = o0.a.e;
            if(b0 != null && b0.c) {
                MediaRouteProvider mediaRouteProvider0 = o0.c();
                Bundle bundle0 = new Bundle();
                bundle0.putString("clientPackageName", "com.iloen.melon");
                A a0 = new A(bundle0);
                y y1 = mediaRouteProvider0.a(o0.b, a0);
                if(y1 != null) {
                    y1.q(c.getMainExecutor(context0), this.F);
                    this.y = o0;
                    this.z = y1;
                    y1.f();
                    return;
                }
                Log.w("AxMediaRouter", "setSelectedRouteInternal: Failed to create dynamic group route controller. route=" + o0);
            }
        }
        MediaRouteProvider mediaRouteProvider1 = o0.c();
        Bundle bundle1 = new Bundle();
        bundle1.putString("clientPackageName", "com.iloen.melon");
        A a1 = new A(bundle1);
        z z2 = mediaRouteProvider1.d(o0.b, a1);
        if(z2 != null) {
            z2.f();
        }
        if(this.d == null) {
            this.d = o0;
            this.e = z2;
            this.a.getClass();
            g g0 = new g(null, o0, z);
            Message message0 = this.a.obtainMessage(0x106, g0);
            message0.arg1 = v;
            message0.sendToTarget();
            return;
        }
        this.j(this, o0, z2, v, z, null, null);
    }

    public final void n() {
        Q8.h h0 = new Q8.h();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.u.b = 0L;
        this.u.a = false;
        this.u.c = SystemClock.elapsedRealtime();
        ((Handler)this.u.d).removeCallbacks(((Runnable)this.u.e));
        ArrayList arrayList0 = this.i;
        int v = arrayList0.size();
        int v1 = 0;
        boolean z = false;
        while(true) {
            boolean z1 = this.q;
            if(v - 1 < 0) {
                break;
            }
            Q q0 = (Q)((WeakReference)arrayList0.get(v - 1)).get();
            if(q0 == null) {
                arrayList0.remove(v - 1);
            }
            else {
                ArrayList arrayList1 = q0.b;
                int v2 = arrayList1.size();
                v1 += v2;
                for(int v3 = 0; v3 < v2; ++v3) {
                    I i0 = (I)arrayList1.get(v3);
                    G g0 = i0.c;
                    if(g0 == null) {
                        throw new IllegalArgumentException("selector must not be null");
                    }
                    h0.g(g0.c());
                    boolean z2 = (i0.d & 1) != 0;
                    this.u.g(i0.e, z2);
                    if(z2) {
                        z = true;
                    }
                    int v4 = i0.d;
                    if((v4 & 4) != 0 && !z1) {
                        z = true;
                    }
                    if((v4 & 8) != 0) {
                        z = true;
                    }
                }
            }
            --v;
        }
        j0 j00 = this.u;
        if(j00.a) {
            long v5 = j00.b;
            if(v5 > 0L) {
                ((Handler)j00.d).postDelayed(((Runnable)j00.e), v5);
            }
        }
        boolean z3 = j00.a;
        this.C = v1;
        G g1 = z ? h0.i() : G.c;
        G g2 = h0.i();
        if(this.h()) {
            v v6 = this.B;
            if(v6 == null) {
            label_52:
                if(!g2.d() || z3) {
                    this.B = new v(g2, z3);
                    this.s.g(this.B);
                }
                else if(this.B != null) {
                    this.B = null;
                    this.s.g(this.B);
                }
            }
            else {
                v6.a();
                if(!v6.b.equals(g2) || this.B.b() != z3) {
                    goto label_52;
                }
            }
        }
        v v7 = this.A;
        if(v7 == null) {
        label_63:
            if(!g1.d() || z3) {
                this.A = new v(g1, z3);
            label_68:
                if(z && !z3 && z1) {
                    Log.i("AxMediaRouter", "Forcing passive route discovery on a low-RAM device, system performance may be affected.  Please consider using CALLBACK_FLAG_REQUEST_DISCOVERY instead of CALLBACK_FLAG_FORCE_DISCOVERY.");
                }
                for(Object object0: this.m) {
                    MediaRouteProvider mediaRouteProvider0 = ((N)object0).a;
                    if(mediaRouteProvider0 != this.s) {
                        mediaRouteProvider0.g(this.A);
                    }
                }
            }
            else if(this.A != null) {
                this.A = null;
                goto label_68;
            }
        }
        else {
            v7.a();
            if(!v7.b.equals(g1) || this.A.b() != z3) {
                goto label_63;
            }
        }
    }

    public final void o() {
        O o0 = this.d;
        if(o0 == null) {
            e e1 = this.D;
            if(e1 != null) {
                e1.a();
            }
        }
        else {
            d d0 = this.o;
            d0.b = o0.p;
            d0.c = o0.q;
            int v = 0;
            d0.d = !o0.e() || Q.h() ? o0.o : 0;
            d0.e = this.d.m;
            String s = null;
            if(!this.h() || this.d.c() != this.s) {
                d0.f = null;
            }
            else {
                z z0 = this.e;
                if(z0 instanceof k) {
                    MediaRouter2.RoutingController mediaRouter2$RoutingController0 = ((k)z0).g;
                    if(mediaRouter2$RoutingController0 != null) {
                        s = mediaRouter2$RoutingController0.getId();
                    }
                }
                d0.f = s;
            }
            Iterator iterator0 = this.n.iterator();
            if(iterator0.hasNext()) {
                throw H0.b.b(iterator0);
            }
            e e0 = this.D;
            if(e0 != null) {
                O o1 = this.d;
                O o2 = this.w;
                if(o2 == null) {
                    throw new IllegalStateException("There is no default route.  The media router has not yet been fully initialized.");
                }
                if(o1 == o2 || o1 == this.x) {
                    e0.a();
                    return;
                }
                if(d0.d == 1) {
                    v = 2;
                }
                int v1 = d0.c;
                int v2 = d0.b;
                String s1 = (String)d0.f;
                MediaSessionCompat mediaSessionCompat0 = e0.a;
                l4.d d1 = e0.b;
                if(d1 == null || v != 0 || v1 != 0) {
                    goto label_40;
                }
                d1.d = v2;
                X2.v.a(d1.a(), v2);
                X2.w w0 = d1.e;
                if(w0 != null) {
                    w0.onVolumeChanged(d1);
                    return;
                label_40:
                    l4.d d2 = new l4.d(e0, v, v1, v2, s1);
                    e0.b = d2;
                    mediaSessionCompat0.setPlaybackToRemote(d2);
                }
            }
        }
    }

    public final void p(N n0, df.B b0) {
        boolean z2;
        Iterator iterator1;
        int v2;
        boolean z;
        ArrayList arrayList0 = n0.b;
        if(n0.e != b0) {
            n0.e = b0;
            ArrayList arrayList1 = this.j;
            b b1 = this.a;
            if(b0 == null) {
                z = false;
                Log.w("AxMediaRouter", "Ignoring null provider descriptor from " + ((ComponentName)n0.d.b));
                v2 = 0;
            }
            else {
                List list0 = b0.b;
                int v = list0.size();
                int v1 = 0;
                while(v1 < v) {
                    u u0 = (u)list0.get(v1);
                    if(u0 != null && u0.k()) {
                        ++v1;
                        continue;
                    }
                    if(b0 == this.t.g) {
                        break;
                    }
                    z = false;
                    Log.w("AxMediaRouter", (b0 == null ? "Ignoring null provider descriptor from " + ((ComponentName)n0.d.b) : "Ignoring invalid provider descriptor: " + b0));
                    v2 = 0;
                    goto label_91;
                }
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                int v3 = 0;
                boolean z1 = false;
                Iterator iterator0 = list0.iterator();
                while(iterator0.hasNext()) {
                    Object object0 = iterator0.next();
                    u u1 = (u)object0;
                    if(u1 != null && u1.k()) {
                        String s = u1.f();
                        int v4 = arrayList0.size();
                        int v5 = 0;
                        while(true) {
                            if(v5 < v4) {
                                if(((O)arrayList0.get(v5)).b.equals(s)) {
                                    break;
                                }
                                else {
                                    ++v5;
                                    continue;
                                }
                            }
                            v5 = -1;
                            break;
                        }
                        if(v5 < 0) {
                            iterator1 = iterator0;
                            z2 = z1;
                            O o0 = new O(n0, s, this.b(n0, s), u1.a.getBoolean("isSystemRoute", false));
                            arrayList0.add(v3, o0);
                            arrayList1.add(o0);
                            if(u1.d().isEmpty()) {
                                o0.i(u1);
                                b1.b(0x101, o0);
                            }
                            else {
                                arrayList2.add(new b2.b(o0, u1));
                            }
                        }
                        else {
                            iterator1 = iterator0;
                            z2 = z1;
                            if(v5 < v3) {
                                Log.w("AxMediaRouter", "Ignoring route descriptor with duplicate id: " + u1);
                                goto label_68;
                            }
                            else {
                                O o1 = (O)arrayList0.get(v5);
                                Collections.swap(arrayList0, v5, v3);
                                if(!u1.d().isEmpty()) {
                                    arrayList3.add(new b2.b(o1, u1));
                                }
                                else if(this.q(o1, u1) != 0 && o1 == this.d) {
                                    ++v3;
                                    z2 = true;
                                    goto label_68;
                                }
                            }
                        }
                        ++v3;
                    }
                    else {
                        iterator1 = iterator0;
                        z2 = z1;
                        Log.w("AxMediaRouter", "Ignoring invalid route descriptor: " + u1);
                    }
                label_68:
                    iterator0 = iterator1;
                    z1 = z2;
                }
                for(Object object1: arrayList2) {
                    ((O)((b2.b)object1).a).i(((u)((b2.b)object1).b));
                    b1.b(0x101, ((O)((b2.b)object1).a));
                }
                boolean z3 = z1;
                for(Object object2: arrayList3) {
                    O o2 = (O)((b2.b)object2).a;
                    if(this.q(o2, ((u)((b2.b)object2).b)) != 0 && o2 == this.d) {
                        z3 = true;
                    }
                }
                z = z3;
                v2 = v3;
            }
        label_91:
            for(int v6 = arrayList0.size() - 1; v6 >= v2; --v6) {
                O o3 = (O)arrayList0.get(v6);
                o3.i(null);
                arrayList1.remove(o3);
            }
            this.r(z);
            for(int v7 = arrayList0.size() - 1; v7 >= v2; --v7) {
                b1.b(0x102, ((O)arrayList0.remove(v7)));
            }
            b1.b(0x203, n0);
        }
    }

    public final int q(O o0, u u0) {
        int v = o0.i(u0);
        if(v != 0) {
            b b0 = this.a;
            if((v & 1) != 0) {
                b0.b(0x103, o0);
            }
            if((v & 2) != 0) {
                b0.b(260, o0);
            }
            if((v & 4) != 0) {
                b0.b(0x105, o0);
            }
        }
        return v;
    }

    public final void r(boolean z) {
        if(this.w != null && !this.w.f()) {
            Log.i("AxMediaRouter", "Clearing the default route because it is no longer selectable: " + this.w);
            this.w = null;
        }
        ArrayList arrayList0 = this.j;
        if(this.w == null) {
            for(Object object0: arrayList0) {
                O o0 = (O)object0;
                if(o0.c() == this.t && o0.b.equals("DEFAULT_ROUTE") && o0.f()) {
                    this.w = o0;
                    Log.i("AxMediaRouter", "Found default route: " + this.w);
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        if(this.x != null && !this.x.f()) {
            Log.i("AxMediaRouter", "Clearing the bluetooth route because it is no longer selectable: " + this.x);
            this.x = null;
        }
        if(this.x == null) {
            for(Object object1: arrayList0) {
                O o1 = (O)object1;
                if(o1.c() == this.t && o1.m("android.media.intent.category.LIVE_AUDIO") && !o1.m("android.media.intent.category.LIVE_VIDEO") && o1.f()) {
                    this.x = o1;
                    Log.i("AxMediaRouter", "Found bluetooth route: " + this.x);
                    break;
                }
                if(false) {
                    break;
                }
            }
        }
        if(this.d != null && this.d.g) {
            if(z) {
                this.i();
                this.o();
            }
            return;
        }
        Log.i("AxMediaRouter", "Unselecting the current route because it is no longer selectable: " + this.d);
        this.m(this.c(), 0, true);
    }
}

