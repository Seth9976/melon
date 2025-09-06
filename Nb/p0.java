package Nb;

import O.F;
import O.j;
import O.w;
import android.net.Uri;
import b3.E;
import b3.G;
import b3.S;
import com.iloen.melon.utils.log.LogConstantsKt;
import fc.a;
import gd.M6;
import ie.H;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import m0.b;
import we.k;
import we.n;
import y0.l;
import zc.r;

public final class p0 implements k {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;
    public final Object e;
    public final Object f;
    public final Object g;

    public p0(int v, S s0, E e0, G g0, gc.G g1, t0 t00) {
        this.a = 0;
        super();
        this.b = v;
        this.c = s0;
        this.d = e0;
        this.e = g0;
        this.f = g1;
        this.g = t00;
    }

    public p0(List list0, int v, n n0, CoroutineScope coroutineScope0, F f0, n n1) {
        this.a = 1;
        super();
        this.c = list0;
        this.b = v;
        this.d = n0;
        this.e = coroutineScope0;
        this.f = f0;
        this.g = n1;
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        Uri uri0;
        String s5;
        String s3;
        String s1;
        if(this.a != 0) {
            q.g(((w)object0), "$this$MelonLazyRow");
            l l0 = new l(2, new M6(23), ((List)this.c));
            hd.w w0 = new hd.w(((List)this.c), 13);
            b b0 = new b(0xBEF78951, new r(((List)this.c), this.b, ((n)this.d), ((CoroutineScope)this.e), ((F)this.f), ((n)this.g)), true);
            ((j)(((w)object0))).u(((List)this.c).size(), l0, w0, b0);
            return H.a;
        }
        S s0 = (S)this.c;
        E e0 = (E)this.d;
        G g0 = (G)this.e;
        gc.G g1 = (gc.G)this.f;
        t0 t00 = (t0)this.g;
        q.g(((a)object0), "previous");
        int v = this.b;
        boolean z = v != 1 && v != 4 && s0.getPlayWhenReady();
        if(e0 == null) {
            s1 = "";
        }
        else {
            s1 = e0.a;
            if(s1 == null) {
                s1 = "";
            }
        }
        long v1 = s0.getContentPosition();
        long v2 = s0.getDuration();
        if(g0 == null) {
            s3 = "";
        }
        else {
            CharSequence charSequence0 = g0.a;
            if(charSequence0 == null) {
                s3 = "";
            }
            else {
                String s2 = charSequence0.toString();
                s3 = s2 == null ? "" : s2;
            }
        }
        if(g0 == null) {
            s5 = "";
        }
        else {
            CharSequence charSequence1 = g0.b;
            if(charSequence1 == null) {
                s5 = "";
            }
            else {
                String s4 = charSequence1.toString();
                s5 = s4 == null ? "" : s4;
            }
        }
        if(g0 == null) {
            uri0 = Uri.EMPTY;
        }
        else {
            uri0 = g0.m;
            if(uri0 == null) {
                uri0 = Uri.EMPTY;
            }
        }
        q.d(uri0);
        a a0 = a.a(((a)object0), v, z, s1, v1, v2, s3, s5, uri0, g1, null, 0x200);
        if(((a)object0).a != v) {
            LogConstantsKt.debugOnlyDebugMode(t00.c, "updatePlaybackState() " + a0);
        }
        return a0;
    }
}

