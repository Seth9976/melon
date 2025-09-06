package Ac;

import Cc.N1;
import Cc.c1;
import Cc.e0;
import Cc.u0;
import De.I;
import F.E;
import M.j0;
import M.n0;
import M.p0;
import Mc.c;
import N0.M;
import Nc.J;
import O.F;
import Oc.g;
import P0.h;
import P0.i;
import P0.j;
import T.e;
import Tf.v;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.BoxChildDataElement;
import androidx.compose.foundation.layout.FillElement;
import androidx.compose.foundation.layout.b;
import androidx.compose.foundation.layout.d;
import androidx.compose.foundation.lazy.a;
import androidx.compose.foundation.y;
import androidx.compose.runtime.K0;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.i0;
import androidx.compose.runtime.k;
import androidx.compose.runtime.l;
import androidx.compose.runtime.p;
import androidx.compose.runtime.w;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.iloen.melon.net.v4x.response.OneHourChartGraphRes.RESPONSE;
import com.melon.net.res.v3.CommentConfig;
import com.melon.net.res.v3.CommentUiModel;
import gd.R7;
import hd.Y1;
import ie.H;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.channels.BufferedChannel;
import kotlinx.coroutines.selects.SelectInstance;
import r0.n;
import td.m0;
import we.o;
import zc.S;
import zc.U;

public final class i2 implements o {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public i2(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        n n0 = n.a;
        int v = 4;
        V v1 = k.a;
        H h0 = H.a;
        Object object3 = this.b;
        boolean z = false;
        Object object4 = this.d;
        Object object5 = this.c;
        switch(this.a) {
            case 0: {
                int v2 = (int)(((Integer)object2));
                q.g(((a)object0), "$this$item");
                if(((p)(((l)object1))).Q(v2 & 1, (v2 & 17) != 16)) {
                    CommentUiModel commentUiModel0 = ((O2)object3).a;
                    boolean z4 = ((List)object5).isEmpty();
                    CommentConfig commentConfig0 = ((O2)object3).b;
                    boolean z5 = ((p)(((l)object1))).i(((v2)object4));
                    o2 o20 = ((p)(((l)object1))).N();
                    if(z5 || o20 == v1) {
                        o20 = new o2(1, ((v2)object4), v2.class, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V", 0, 0);
                        ((p)(((l)object1))).l0(o20);
                    }
                    o1.d(commentUiModel0, true, z4, 0.0f, false, commentConfig0, o20, ((p)(((l)object1))), 0x6030, 8);
                    return h0;
                }
                ((p)(((l)object1))).T();
                return h0;
            }
            case 1: {
                int v3 = (int)(((Integer)object2));
                q.g(((we.n)object0), "innerTextField");
                if((v3 & 6) == 0) {
                    if(!((p)(((l)object1))).i(((we.n)object0))) {
                        v = 2;
                    }
                    v3 |= v;
                }
                p p0 = (p)(((l)object1));
                if(p0.Q(v3 & 1, (v3 & 19) != 18)) {
                    r0.q q1 = d.f(n0, 1.0f);
                    y y0 = androidx.compose.foundation.q.a(e0.T(p0, 0x7F060154), 0.5f);  // color:gray200s_support_high_contrast
                    T.d d0 = e.b(5.0f);
                    r0.q q2 = androidx.compose.foundation.layout.a.l(androidx.compose.foundation.q.j(q1, y0.a, y0.b, d0), 10.0f, 0.0f, 2);
                    M m0 = M.p.d(r0.d.d, false);
                    int v4 = p0.P;
                    i0 i00 = p0.m();
                    r0.q q3 = r0.a.d(p0, q2);
                    P0.k.y.getClass();
                    i i0 = j.b;
                    p0.e0();
                    if(p0.O) {
                        p0.l(i0);
                    }
                    else {
                        p0.o0();
                    }
                    w.x(p0, m0, j.f);
                    w.x(p0, i00, j.e);
                    h h1 = j.g;
                    if(p0.O || !q.b(p0.N(), v4)) {
                        A7.d.q(v4, p0, v4, h1);
                    }
                    w.x(p0, q3, j.d);
                    if(((String)object3).length() == 0) {
                        p0.a0(879504708);
                        N1.b(((String)object5), d.h(n0, 14.0f), ye.a.v(p0, 0x7F06015D), 14.0f, null, null, 0L, null, 0.0f, 0, false, 0, 0, null, null, p0, 0xC30, 0, 0x1FFF0);  // color:gray500s_support_high_contrast
                    }
                    else {
                        p0.a0(0x347158F1);
                        r0.q q4 = r0.a.a((b this, /* 缺少Lambda参数 */) -> q0.then(new BoxChildDataElement(e0, false)).a(n0, r0.d.f), new u0(7, ((we.a)object4)));
                        androidx.compose.foundation.q.c(I.Q(0x7F080138, p0, 6), H0.e.Y(p0, 0x7F130AE7), q4, null, null, 0.0f, null, p0, 0, 120);  // drawable:btn_common_edit_delete
                    }
                    p0.p(false);
                    ((we.n)object0).invoke(p0, ((int)(v3 & 14)));
                    p0.p(true);
                    return h0;
                }
                p0.T();
                return h0;
            }
            case 2: {
                J j0 = ((g)object5).b;
                q.g(((LayoutInflater)object0), "inflater");
                q.g(((ViewGroup)object1), "parent");
                View view0 = ((LayoutInflater)object0).inflate(0x7F0D02C9, ((ViewGroup)object1), false);  // layout:fragment_viewpager
                if(((Boolean)object2).booleanValue()) {
                    ((ViewGroup)object1).addView(view0);
                }
                ViewPager2 viewPager20 = (ViewPager2)I.C(view0, 0x7F0A0DC9);  // id:view_pager
                if(viewPager20 == null) {
                    throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0DC9));  // id:view_pager
                }
                J8.o1 o10 = new J8.o1(((ConstraintLayout)view0), viewPager20);
                ((Mc.g)object3).f = new c(((Mc.g)object3), j0.b, 0);
                Mc.b b0 = new Mc.b(((we.k)object4), 0);
                ((ArrayList)viewPager20.c.b).add(b0);
                viewPager20.setOffscreenPageLimit(j0.b.size());
                viewPager20.setAdapter(((Mc.g)object3).f);
                c2.M.m(((ConstraintLayout)view0), true);
                return o10;
            }
            case 3: {
                ((Integer)object2).getClass();
                q.g(((E)object0), "$this$AnimatedVisibility");
                n n1 = n.a;
                M.c.d(((l)object1), d.h(n1, 6.0f));
                p0 p00 = n0.a(M.j.a, r0.d.k, ((l)object1), 0x30);
                int v5 = ((p)(((l)object1))).P;
                i0 i01 = ((p)(((l)object1))).m();
                r0.q q5 = r0.a.d(((l)object1), n1);
                P0.k.y.getClass();
                i i1 = j.b;
                ((p)(((l)object1))).e0();
                if(((p)(((l)object1))).O) {
                    ((p)(((l)object1))).l(i1);
                }
                else {
                    ((p)(((l)object1))).o0();
                }
                w.x(((l)object1), p00, j.f);
                w.x(((l)object1), i01, j.e);
                h h2 = j.g;
                if(((p)(((l)object1))).O || !q.b(((p)(((l)object1))).N(), v5)) {
                    A7.d.q(v5, ((p)(((l)object1))), v5, h2);
                }
                w.x(((l)object1), q5, j.d);
                if(((CharSequence)((b0)object3).getValue()).length() > 0) {
                    ((p)(((l)object1))).a0(-1062309805);
                    c1.n(d5.n.o(d.n(n1, 15.0f), e.a), ((b0)object3).getValue(), null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((l)object1), 0, 0, 0x7FFC);
                    M.c.d(((l)object1), d.q(n1, 4.0f));
                    r0.q q6 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 1.0f, 0.0f, 0.0f, 13);
                    N1.b(((String)((b0)object5).getValue()), q6, e0.T(((l)object1), 0x7F0604A1), 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, ((l)object1), 0xC30, 0xC30, 0x1D7F0);  // color:white000e
                }
                else {
                    ((p)(((l)object1))).a0(0xC0BD60D4);
                    c1.n(d.n(n1, 11.0f), 0x7F0804B0, null, null, false, 0, null, null, null, 0.0f, null, 0, 0, false, false, ((l)object1), 54, 0, 0x7FFC);  // drawable:ic_malang_song_11
                    M.c.d(((l)object1), d.q(n1, 2.0f));
                    r0.q q7 = androidx.compose.foundation.layout.a.n(n1, 0.0f, 1.0f, 0.0f, 0.0f, 13);
                    ((p)(((l)object1))).a0(0x508A7703);
                    a1.d d1 = new a1.d();
                    int v6 = d1.g(new a1.M(e0.T(((l)object1), 0x7F0604A1), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFE));  // color:white000e
                    try {
                        d1.d(((String)((b0)object4).getValue()));
                    }
                    finally {
                        d1.f(v6);
                    }
                    d1.d(" ");
                    int v8 = d1.g(new a1.M(e0.T(((l)object1), 0x7F0604B7), 0L, null, null, null, null, null, 0L, null, null, null, 0L, null, null, 0xFFFE));  // color:white700e
                    try {
                        d1.d(v.p0(v.p0(((String)((b0)object5).getValue()), "\n", " "), "\r", ""));
                    }
                    finally {
                        d1.f(v8);
                    }
                    a1.g g0 = d1.h();
                    ((p)(((l)object1))).p(false);
                    N1.a(g0, q7, 0L, 13.0f, null, null, 0L, null, 0.0f, 2, false, 1, 0, null, null, null, ((l)object1), 0xC30, 0xC30, 0x3D7F4);
                }
                ((p)(((l)object1))).p(false);
                ((p)(((l)object1))).p(true);
                return h0;
            }
            case 4: {
                return BufferedChannel.a(this.b, ((BufferedChannel)object5), ((SelectInstance)object4), ((Throwable)object0), object1, ((me.i)object2));
            }
            case 5: {
                ((Integer)object2).getClass();
                q.g(((E)object0), "$this$AnimatedVisibility");
                FillElement fillElement0 = d.c;
                j0 j00 = androidx.compose.foundation.layout.a.c(0.0f, 0.0f, 0.0f, 118.0f, 7);
                boolean z6 = ((p)(((l)object1))).i(((ArrayList)object5));
                boolean z7 = ((p)(((l)object1))).i(((Y1)object4));
                R7 r70 = ((p)(((l)object1))).N();
                if(z6 || z7 || r70 == v1) {
                    r70 = new R7(9, ((ArrayList)object5), ((Y1)object4));
                    ((p)(((l)object1))).l0(r70);
                }
                c1.o(fillElement0, ((F)object3), j00, false, null, null, null, false, r70, ((p)(((l)object1))), 390, 0xF8);
                return h0;
            }
            case 6: {
                int v10 = (int)(((Integer)object2));
                q.g(((M.v)object0), "$this$BoxWithConstraints");
                if((v10 & 6) == 0) {
                    v10 |= (((p)(((l)object1))).g(((M.v)object0)) ? 4 : 2);
                }
                if((v10 & 19) != 18) {
                    z = true;
                }
                if(((p)(((l)object1))).Q(v10 & 1, z)) {
                    int v11 = ((K0)object3).m();
                    List list0 = ((RESPONSE)object4).getEntChartXLagels();
                    if(list0 == null) {
                        list0 = je.w.a;
                    }
                    S.a(v11, ((List)object5), list0, null, ((androidx.compose.foundation.layout.c)(((M.v)object0))).c(), ((p)(((l)object1))), 0);
                    return h0;
                }
                ((p)(((l)object1))).T();
                return h0;
            }
            default: {
                ((Integer)object2).getClass();
                q.g(((E)object0), "$this$AnimatedVisibility");
                r0.q q0 = d.n(n0, ((U)object3).d);
                boolean z1 = ((p)(((l)object1))).i(((ArrayList)object5));
                boolean z2 = ((p)(((l)object1))).i(((U)object3));
                boolean z3 = ((p)(((l)object1))).i(((Context)object4));
                m0 m00 = ((p)(((l)object1))).N();
                if((z1 | z2 | z3) != 0 || m00 == v1) {
                    m00 = new m0(((ArrayList)object5), ((U)object3), ((Context)object4), 6);
                    ((p)(((l)object1))).l0(m00);
                }
                androidx.compose.foundation.q.b(q0, m00, ((p)(((l)object1))), 0);
                return h0;
            }
        }
    }
}

