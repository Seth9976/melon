package Nb;

import Ac.F2;
import I6.V;
import M6.B;
import Mc.q;
import P0.c0;
import Pb.e;
import Pb.f;
import android.app.Service;
import android.net.Uri;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.RemoteException;
import androidx.media3.session.d0;
import androidx.media3.session.e0;
import androidx.media3.session.f1;
import androidx.media3.session.n0;
import androidx.media3.session.s1;
import androidx.media3.session.v0;
import androidx.media3.session.w0;
import androidx.media3.session.w1;
import androidx.media3.session.y0;
import com.iloen.melon.constants.CType;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.utils.image.ImageUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import d5.n;
import e3.b;
import ie.H;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import kc.i;
import kc.t1;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ob.a;
import ob.z;
import oc.M;
import oe.c;
import qd.W;

public final class h0 implements e0 {
    public final Service a;
    public final CoroutineScope b;
    public final i c;
    public final z d;
    public final a e;
    public final t1 f;
    public final W g;
    public final LogU h;
    public final CoroutineScope i;
    public final d0 j;
    public Job k;
    public Job l;
    public final androidx.media3.session.t1 m;
    public final q n;

    public h0(Service service0, CoroutineScope coroutineScope0, i i0, z z0, a a0, t1 t10, W w0) {
        this.a = service0;
        this.b = coroutineScope0;
        this.c = i0;
        this.d = z0;
        this.e = a0;
        this.f = t10;
        this.g = w0;
        this.h = Companion.create$default(LogU.Companion, "MelonLibrarySessionCallback", false, Category.Playback, 2, null);
        this.i = CoroutineScopeKt.CoroutineScope(coroutineScope0.getCoroutineContext().plus(Dispatchers.getIO()));
        this.j = new d0(Bundle.EMPTY, false, false, false);
        HashSet hashSet0 = new HashSet(new androidx.media3.session.t1(new HashSet()).a);
        hashSet0.add(new s1(50000));
        hashSet0.add(new s1(50001));
        hashSet0.add(new s1(50002));
        hashSet0.add(new s1(50003));
        hashSet0.add(new s1(50004));
        f.a.getClass();
        for(Object object0: e.b) {
            hashSet0.add(((f)object0).b());
        }
        this.m = new androidx.media3.session.t1(hashSet0);
        this.n = new q(this, 4);
    }

    public static final Uri a(h0 h00, String s) {
        LogU.debug$default(h00.h, "getImgUri() url: " + s, null, false, 6, null);
        Uri uri0 = s == null || s.length() == 0 ? ImageUtils.getResourceUri(0x7F0800A3) : Uri.parse(s);  // drawable:auto_noimage_dark
        if(kotlin.jvm.internal.q.b(uri0, Uri.EMPTY)) {
            Uri uri1 = ImageUtils.getResourceUri(0x7F0800A3);  // drawable:auto_noimage_dark
            kotlin.jvm.internal.q.f(uri1, "getResourceUri(...)");
            return uri1;
        }
        kotlin.jvm.internal.q.d(uri0);
        return uri0;
    }

    public static final Object b(h0 h00, ArrayList arrayList0, oe.i i0) {
        h00.getClass();
        H h0 = H.a;
        if(arrayList0.isEmpty()) {
            ToastManager.show(0x7F13082B);  // string:playlist_empty "재생 가능한 곡이 없습니다."
            return h0;
        }
        Object object0 = h00.f.c(arrayList0, true, i0);
        return object0 == ne.a.a ? object0 : h0;
    }

    public static final Object c(h0 h00, y0 y00, c c0) {
        int v2;
        w0 w01;
        g0 g00;
        h00.getClass();
        if(c0 instanceof g0) {
            g00 = (g0)c0;
            int v = g00.E;
            if((v & 0x80000000) == 0) {
                g00 = new g0(h00, c0);
            }
            else {
                g00.E = v ^ 0x80000000;
            }
        }
        else {
            g00 = new g0(h00, c0);
        }
        Serializable serializable0 = g00.B;
        ne.a a0 = ne.a.a;
        switch(g00.E) {
            case 0: {
                n.D(serializable0);
                w0 w00 = y00.a.g();
                if(w00 != null) {
                    g00.r = w00;
                    g00.w = y00;
                    g00.E = 1;
                    Serializable serializable1 = h00.d(g00);
                    if(serializable1 == a0) {
                        return a0;
                    }
                    serializable0 = serializable1;
                    w01 = w00;
                    goto label_29;
                }
                break;
            }
            case 1: {
                y00 = g00.w;
                w01 = g00.r;
                n.D(serializable0);
            label_29:
                y00.getClass();
                b.h(w01, "controller must not be null");
                b.h(((List)serializable0), "layout must not be null");
                n0 n00 = y00.a;
                V v1 = V.p(((List)serializable0));
                boolean z = n00.k(w01);
                f1 f10 = n00.g;
                if(z) {
                    n00.t.e = v1;
                    n00.h.L(n00.t);
                }
                try {
                    c0 c00 = f10.c.n(w01);
                    if(c00 == null) {
                        if(!n00.j(w01)) {
                            com.google.firebase.b.I(new w1(-100));
                            return H.a;
                        }
                        com.google.firebase.b.I(new w1(0));
                        v2 = 0;
                    }
                    else {
                        v2 = c00.l(n0.J).h;
                    }
                    v0 v00 = w01.d;
                    if(v00 != null) {
                        v00.m(v2, v1);
                        return H.a;
                    }
                    break;
                }
                catch(DeadObjectException unused_ex) {
                }
                catch(RemoteException remoteException0) {
                    b.E("MediaSessionImpl", "Exception in " + w01.toString(), remoteException0);
                    com.google.firebase.b.I(new w1(-1));
                    return H.a;
                }
                f10.c.w(w01);
                com.google.firebase.b.I(new w1(-100));
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    public final Serializable d(c c0) {
        androidx.media3.session.b[] arr_b5;
        androidx.media3.session.b[] arr_b4;
        androidx.media3.session.b[] arr_b1;
        int v2;
        androidx.media3.session.b[] arr_b;
        s s0;
        if(c0 instanceof s) {
            s0 = (s)c0;
            int v = s0.G;
            if((v & 0x80000000) == 0) {
                s0 = new s(this, c0);
            }
            else {
                s0.G = v ^ 0x80000000;
            }
        }
        else {
            s0 = new s(this, c0);
        }
        Object object0 = s0.D;
        Serializable serializable0 = ne.a.a;
        int v1 = 1;
        switch(s0.G) {
            case 0: {
                n.D(object0);
                arr_b = new androidx.media3.session.b[2];
                s0.r = arr_b;
                s0.w = arr_b;
                v2 = 0;
                s0.B = 0;
                s0.G = 1;
                object0 = this.f(s0);
                if(object0 == serializable0) {
                    return serializable0;
                }
                arr_b1 = arr_b;
                goto label_31;
            }
            case 1: {
                v2 = s0.B;
                androidx.media3.session.b[] arr_b2 = s0.w;
                androidx.media3.session.b[] arr_b3 = s0.r;
                n.D(object0);
                arr_b1 = arr_b2;
                arr_b = arr_b3;
            label_31:
                arr_b1[v2] = object0;
                s0.r = arr_b;
                s0.w = arr_b;
                s0.B = 1;
                s0.G = 2;
                object0 = this.e(s0);
                if(object0 == serializable0) {
                    return serializable0;
                }
                arr_b4 = arr_b;
                arr_b5 = arr_b4;
                break;
            }
            case 2: {
                v1 = s0.B;
                arr_b5 = s0.w;
                arr_b4 = s0.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        arr_b5[v1] = object0;
        kotlin.jvm.internal.q.g(arr_b4, "elements");
        return je.n.g0(arr_b4);
    }

    public final Object e(c c0) {
        Nb.z z0;
        if(c0 instanceof Nb.z) {
            z0 = (Nb.z)c0;
            int v = z0.B;
            if((v & 0x80000000) == 0) {
                z0 = new Nb.z(this, c0);
            }
            else {
                z0.B = v ^ 0x80000000;
            }
        }
        else {
            z0 = new Nb.z(this, c0);
        }
        Enum enum0 = z0.r;
        ne.a a0 = ne.a.a;
        i i0 = this.c;
    alab1:
        switch(z0.B) {
            case 0: {
                n.D(enum0);
                z0.B = 1;
                enum0 = ((com.melon.playlist.b)i0).s(z0);
                if(enum0 == a0) {
                    return a0;
                }
                goto label_20;
            }
            case 1: {
                n.D(enum0);
            label_20:
                if(e1.n.i(((PlaylistId)enum0))) {
                    F2 f20 = ((com.melon.playlist.b)i0).c.n();
                    z0.B = 2;
                    enum0 = FlowKt.firstOrNull(f20, z0);
                    if(enum0 == a0) {
                        return a0;
                    }
                    goto label_27;
                }
                break;
            }
            case 2: {
                n.D(enum0);
            label_27:
                int v1 = ((M)enum0) == null ? -1 : r.a[((M)enum0).ordinal()];
                switch(v1) {
                    case 1: {
                        androidx.media3.session.a a1 = new androidx.media3.session.a(0);
                        a1.f = "Repeat All";
                        f.a.getClass();
                        a1.c(new s1("com.melon.playback.command.REPEAT_ONE", Bundle.EMPTY));
                        a1.d = 0x7F080296;  // drawable:btn_widget_media_repeat_all
                        return a1.a();
                    }
                    case 2: {
                        androidx.media3.session.a a2 = new androidx.media3.session.a(0);
                        a2.f = "Repeat One";
                        f.a.getClass();
                        a2.c(new s1("com.melon.playback.command.REPEAT_OFF", Bundle.EMPTY));
                        a2.d = 0x7F080298;  // drawable:btn_widget_media_repeat_one
                        return a2.a();
                    label_42:
                        if(v1 == 3) {
                            androidx.media3.session.a a3 = new androidx.media3.session.a(0);
                            a3.f = "Repeat Off";
                            f.a.getClass();
                            a3.c(new s1("com.melon.playback.command.REPEAT_ALL", Bundle.EMPTY));
                            a3.d = 0x7F080297;  // drawable:btn_widget_media_repeat_off
                            return a3.a();
                        }
                        break alab1;
                    }
                    default: {
                        goto label_42;
                    }
                }
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return null;
    }

    public final Object f(c c0) {
        A a0;
        if(c0 instanceof A) {
            a0 = (A)c0;
            int v = a0.B;
            if((v & 0x80000000) == 0) {
                a0 = new A(this, c0);
            }
            else {
                a0.B = v ^ 0x80000000;
            }
        }
        else {
            a0 = new A(this, c0);
        }
        Enum enum0 = a0.r;
        ne.a a1 = ne.a.a;
        i i0 = this.c;
        switch(a0.B) {
            case 0: {
                n.D(enum0);
                a0.B = 1;
                enum0 = ((com.melon.playlist.b)i0).s(a0);
                if(enum0 == a1) {
                    return a1;
                }
                goto label_20;
            }
            case 1: {
                n.D(enum0);
            label_20:
                if(!e1.n.j(((PlaylistId)enum0))) {
                    return null;
                }
                F2 f20 = ((com.melon.playlist.b)i0).c.o();
                a0.B = 2;
                enum0 = FlowKt.firstOrNull(f20, a0);
                if(enum0 == a1) {
                    return a1;
                }
                goto label_28;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        n.D(enum0);
    label_28:
        if(kotlin.jvm.internal.q.b(((Boolean)enum0), Boolean.TRUE)) {
            androidx.media3.session.a a2 = new androidx.media3.session.a(0);
            a2.f = "Shuffle On";
            f.a.getClass();
            a2.c(new s1("com.melon.playback.command.SHUFFLE_OFF", Bundle.EMPTY));
            a2.d = 0x7F08029A;  // drawable:btn_widget_media_shuffle_on
            return a2.a();
        }
        androidx.media3.session.a a3 = new androidx.media3.session.a(0);
        a3.f = "Shuffle Off";
        f.a.getClass();
        a3.c(new s1("com.melon.playback.command.SHUFFLE_ON", Bundle.EMPTY));
        a3.d = 0x7F080299;  // drawable:btn_widget_media_shuffle_off
        return a3.a();
    }

    public final B g(y0 y00, w0 w00) {
        kotlin.jvm.internal.q.g(y00, "session");
        kotlin.jvm.internal.q.g(w00, "controller");
        LogU.debug$default(this.h, "onPlaybackResumption()", null, false, 6, null);
        Nb.H h0 = new Nb.H(y00, null);
        return ListenableFutureKt.future$default(this.b, null, null, h0, 3, null);
    }

    public final void h(Uri uri0) {
        String s = uri0.getQueryParameter("cid");
        if(s != null && s.length() != 0) {
            String s1 = uri0.getQueryParameter("ctype");
            if("son".equals(s1)) {
                s1 = "1";
            }
            CType cType0 = CType.get(s1);
            String s2 = uri0.getQueryParameter("menuid");
            if(s2 == null || s2.length() == 0) {
                s2 = kotlin.jvm.internal.q.b(CType.MV, cType0) ? "1000000550" : "1000000543";
            }
            Nb.W w0 = new Nb.W(this, s, cType0, s2, null);
            BuildersKt__Builders_commonKt.launch$default(this.i, null, null, w0, 3, null);
        }
    }
}

