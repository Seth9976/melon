package androidx.compose.foundation;

import A0.d;
import P0.K;
import P0.f;
import P0.j0;
import P0.n0;
import P0.q;
import P0.z0;
import X0.x;
import Y.V;
import Y.W;
import android.view.View;
import androidx.compose.runtime.E;
import androidx.compose.runtime.O0;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.w;
import e1.n;
import ie.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.channels.ChannelResult;
import r0.p;
import r1.c;
import r1.h;
import r1.l;
import x0.b;

public final class o0 extends p implements n0, P0.p, q, z0 {
    public V a;
    public W b;
    public G0 c;
    public View d;
    public c e;
    public F0 f;
    public final b0 g;
    public E h;
    public long i;
    public l j;
    public Channel k;

    public o0(V v0, W w0, G0 g00) {
        this.a = v0;
        this.b = w0;
        this.c = g00;
        this.g = w.r(null, androidx.compose.runtime.V.c);
        this.i = 0x7FC000007FC00000L;
    }

    @Override  // P0.q
    public final void I(j0 j00) {
        ((O0)this.g).setValue(j00);
    }

    @Override  // P0.p
    public final void draw(d d0) {
        ((K)d0).a();
        Channel channel0 = this.k;
        if(channel0 != null) {
            ChannelResult.box-impl(channel0.trySend-JP2dKIU(H.a));
        }
    }

    @Override  // P0.z0
    public final void l(x x0) {
        m0 m00 = new m0(this, 1);
        ((X0.l)x0).g(p0.a, m00);
    }

    public final long m0() {
        if(this.h == null) {
            this.h = w.i(new m0(this, 0));
        }
        return this.h == null ? 0x7FC000007FC00000L : ((b)this.h.getValue()).a;
    }

    public final void n0() {
        F0 f00 = this.f;
        if(f00 != null) {
            ((H0)f00).b();
        }
        View view0 = this.d == null ? f.x(this) : this.d;
        this.d = view0;
        c c0 = this.e == null ? f.v(this).S : this.e;
        this.e = c0;
        this.f = this.c.b(view0, c0);
        this.p0();
    }

    public final void o0() {
        c c0 = this.e;
        if(c0 == null) {
            c0 = f.v(this).S;
            this.e = c0;
        }
        long v = ((b)this.a.invoke(c0)).a;
        if((v & 0x7FFFFFFF7FFFFFFFL) != 0x7FC000007FC00000L && (0x7FFFFFFF7FFFFFFFL & this.m0()) != 0x7FC000007FC00000L) {
            this.i = b.g(this.m0(), v);
            if(this.f == null) {
                this.n0();
            }
            F0 f00 = this.f;
            if(f00 != null) {
                f00.a(this.i, 0x7FC000007FC00000L);
            }
            this.p0();
            return;
        }
        this.i = 0x7FC000007FC00000L;
        F0 f01 = this.f;
        if(f01 != null) {
            ((H0)f01).b();
        }
    }

    @Override  // r0.p
    public final void onAttach() {
        this.y();
        this.k = ChannelKt.Channel$default(0, null, null, 7, null);
        CoroutineScope coroutineScope0 = this.getCoroutineScope();
        androidx.compose.foundation.n0 n00 = new androidx.compose.foundation.n0(this, null);
        BuildersKt__Builders_commonKt.launch$default(coroutineScope0, null, CoroutineStart.UNDISPATCHED, n00, 1, null);
    }

    @Override  // r0.p
    public final void onDetach() {
        F0 f00 = this.f;
        if(f00 != null) {
            ((H0)f00).b();
        }
        this.f = null;
    }

    public final void p0() {
        F0 f00 = this.f;
        if(f00 != null) {
            c c0 = this.e;
            if(c0 != null && !l.a(((H0)f00).c(), this.j)) {
                this.b.invoke(new h(c0.k(n.E(((H0)f00).c()))));
                this.j = new l(((H0)f00).c());
            }
        }
    }

    @Override  // P0.n0
    public final void y() {
        f.r(this, new m0(this, 2));
    }
}

