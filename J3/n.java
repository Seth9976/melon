package j3;

import Ac.J;
import I6.Q;
import I6.V;
import I6.p0;
import androidx.core.widget.NestedScrollView;
import androidx.core.widget.h;
import androidx.lifecycle.f0;
import androidx.media3.common.b;
import b3.q0;
import com.google.android.material.navigation.i;
import com.iloen.melon.custom.K0;
import com.melon.ui.M0;
import com.melon.ui.playermusic.PlayerMoreView;
import e3.m;
import gd.y1;
import java.util.Collection;
import je.p;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import l4.C;
import l4.i0;
import l4.x;
import l4.y;
import o3.u;
import o3.v;
import okhttp3.Call;
import okhttp3.EventListener.Factory;
import okhttp3.EventListener;
import okhttp3.internal.Util;
import rd.F1;
import rd.K1;
import v3.f;
import v3.k;
import w1.j;
import x1.s;

public final class n implements h, i, K0, M0, x, u, Factory, k, w1.k {
    public final int a;
    public final Object b;

    public n(m m0, i0 i00) {
        this.a = 3;
        super();
        this.b = m0;
    }

    public n(Object object0, int v) {
        this.a = v;
        this.b = object0;
        super();
    }

    @Override  // com.melon.ui.M0
    public void a(boolean z, boolean z1) {
        BuildersKt__Builders_commonKt.launch$default(f0.h(((K1)this.b)), null, null, new F1(((K1)this.b), z, z1, null), 3, null);
    }

    @Override  // w1.k
    public Object attachCompleter(j j0) {
        q.g(((Deferred)this.b), "$this_asListenableFuture");
        y1 y10 = new y1(25, j0, ((Deferred)this.b));
        ((Deferred)this.b).invokeOnCompletion(y10);
        return "Deferred.asListenableFuture";
    }

    @Override  // l4.x
    public void b(y y0, l4.u u0, Collection collection0) {
        ((C)this.b).i.g(y0, u0, collection0);
    }

    @Override  // v3.k
    public p0 c(int v, q0 q00, int[] arr_v) {
        v3.h h0 = (v3.h)this.b;
        Q q0 = V.o();
        for(int v1 = 0; v1 < q00.a; ++v1) {
            q0.a(new f(v, q00, v1, h0, arr_v[v1]));
        }
        return q0.g();
    }

    @Override  // okhttp3.EventListener$Factory
    public EventListener create(Call call0) {
        return Util.a(((EventListener)this.b), call0);
    }

    public void d() {
        if(this.a != 5) {
            synchronized(p0.m.b) {
                p0.m.h = p.w0(((Iterable)p0.m.h), ((J)this.b));
            }
            p0.m.a();
            return;
        }
        synchronized(p0.m.b) {
            p0.m.g = p.w0(((Iterable)p0.m.g), ((we.n)this.b));
        }
    }

    public float e(float f) {
        return ((s)this.b).k.b() * f;
    }

    @Override  // o3.u
    public int getScore(Object object0) {
        b b0 = (b)this.b;
        String s = ((o3.m)object0).b;
        if(!s.equals(b0.n) && !s.equals(v.b(b0))) {
            return 0;
        }
        return ((o3.m)object0).c(b0, false) ? 1 : 0;
    }

    @Override  // androidx.core.widget.h
    public void j(NestedScrollView nestedScrollView0, int v, int v1, int v2, int v3) {
        ((PlayerMoreView)this.b).k();
    }

    @Override  // com.iloen.melon.custom.K0
    public void onNewListButtonClicked() {
        ((wd.b)this.b).sendUserEvent(wd.m.a);
    }
}

