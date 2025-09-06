package ad;

import Cc.c1;
import Cc.e0;
import F8.N;
import F8.o;
import F8.r;
import F8.s;
import J8.l2;
import O.F;
import O.I;
import Q0.C0;
import R6.c;
import T7.b;
import X0.n;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.compose.foundation.layout.d;
import androidx.compose.runtime.J;
import androidx.compose.runtime.V;
import androidx.compose.runtime.b0;
import androidx.compose.runtime.n0;
import androidx.compose.runtime.p;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.f0;
import androidx.fragment.app.l0;
import cd.A1;
import cd.A2;
import cd.B0;
import cd.B1;
import cd.B2;
import cd.E;
import cd.F0;
import cd.G0;
import cd.J0;
import cd.K0;
import cd.N2;
import cd.O2;
import cd.P1;
import cd.Q0;
import cd.Q1;
import cd.R0;
import cd.W0;
import cd.X0;
import cd.Y2;
import cd.Y;
import cd.Z2;
import cd.Z;
import cd.a1;
import cd.b2;
import cd.c0;
import cd.c2;
import cd.i0;
import cd.i1;
import cd.j0;
import cd.j1;
import cd.m0;
import cd.m1;
import cd.m2;
import cd.n2;
import cd.s2;
import cd.t2;
import cd.u2;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.google.android.material.appbar.AppBarLayout.LayoutParams;
import com.iloen.melon.constants.MelonContentUris;
import com.iloen.melon.custom.U;
import com.iloen.melon.custom.l1;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.fragments.tabs.BottomTabBaseFragment;
import com.iloen.melon.net.v6x.response.MusicTabTitleBarBannerRes.RESPONSE.CommerceBanner;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.I4;
import com.melon.ui.K4;
import com.melon.ui.L0;
import com.melon.ui.O0;
import com.melon.ui.V0;
import com.melon.ui.c3;
import com.melon.ui.e;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CoroutineScope;
import we.k;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lad/j;", "Lcom/iloen/melon/fragments/tabs/BottomTabBaseFragment;", "<init>", "()V", "a", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class j extends BottomTabBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004B\u0007¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lad/j$a;", "Lcom/melon/ui/u1;", "Lad/q0;", "Lcom/melon/ui/a;", "Lcom/melon/ui/L0;", "<init>", "()V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class a extends l implements L0, com.melon.ui.a {
        public final e f;
        public final c g;

        public a() {
            this.f = new e();  // 初始化器: Ljava/lang/Object;-><init>()V
            this.g = new c(25);
            new LogU("TabMusicFragment").setCategory(Category.UI);
            q.f(this.registerForActivityResult(new f0(3), new b(26)), "registerForActivityResult(...)");
        }

        @Override  // com.melon.ui.c0
        public final String getCacheKey() {
            String s = MelonContentUris.X0.buildUpon().build().toString();
            q.f(s, "toString(...)");
            return s;
        }

        @Override  // com.melon.ui.J0
        public final Class getViewModelClass() {
            return q0.class;
        }

        @Override  // com.melon.ui.a
        public final void handleAddPlayUiEvent(l0 l00, com.melon.ui.b b0, Context context0, k k0, CoroutineScope coroutineScope0) {
            q.g(b0, "event");
            q.g(coroutineScope0, "coroutineScope");
            this.f.handleAddPlayUiEvent(l00, b0, context0, k0, coroutineScope0);
        }

        @Override  // com.melon.ui.L0
        public final void handleDjMalrangUiEvent(l0 l00, O0 o00, Activity activity0, k k0, CoroutineScope coroutineScope0) {
            q.g(o00, "event");
            q.g(coroutineScope0, "coroutineScope");
            this.g.handleDjMalrangUiEvent(l00, o00, activity0, k0, coroutineScope0);
        }

        @Override  // com.melon.ui.u1
        public final void m(androidx.compose.runtime.l l0, int v) {
            int v4;
            int v3;
            ((p)l0).c0(0xFDE4DB8E);
            int v1 = (((p)l0).i(this) ? 4 : 2) | v;
            if(((p)l0).Q(v1 & 1, (v1 & 3) != 2)) {
                b0 b00 = B.a.r(((q0)this.getViewModel()).getUiState(), ((p)l0), 0);
                Object object0 = b00.getValue();
                C c0 = object0 instanceof C ? ((C)object0) : null;
                if(c0 == null) {
                    ((p)l0).a0(0xEB6D08C6);
                }
                else {
                    ((p)l0).a0(0xEB6D08C7);
                    if(c0 instanceof B) {
                        ((p)l0).a0(46590060);
                        ad.q q0 = ((B)c0).a;
                        List list0 = q0.a;
                        l2 l20 = (l2)this.getBinding();
                        if(l20 == null) {
                            v4 = v1;
                        }
                        else {
                            TitleBar titleBar0 = (TitleBar)l20.h.c;
                            if(H0.e.N(this)) {
                                int v2 = 0;
                                o o0 = null;
                                for(Object object1: list0) {
                                    if(v2 >= 0) {
                                        if(((w)object1) instanceof u) {
                                            o0 = new r(1);
                                            v3 = v1;
                                        }
                                        else if(((w)object1) instanceof t) {
                                            o0 = new s(((t)(((w)object1))).a);
                                            o0.c = new ad.c(((t)(((w)object1))), v2, 0);
                                            y y0 = new y(v2);
                                            ((t)(((w)object1))).b.invoke(y0);
                                            v3 = v1;
                                        }
                                        else if(((w)object1) instanceof ad.s) {
                                            RequestManager requestManager0 = Glide.with(this);
                                            v3 = v1;
                                            boolean z = q.b(((ad.s)(((w)object1))).a.getShowRedDot(), Boolean.TRUE);
                                            F8.y y1 = new F8.y(((ad.s)(((w)object1))).a.getImgContent(), requestManager0, z);
                                            y1.c = new ad.c(((ad.s)(((w)object1))), v2, 1);
                                            y y2 = new y(v2);
                                            ((ad.s)(((w)object1))).b.invoke(y2);
                                            if(o0 == null) {
                                                o0 = y1;
                                            }
                                            else {
                                                o0.g(y1);
                                            }
                                        }
                                        else {
                                            v3 = v1;
                                            if(!(((w)object1) instanceof v)) {
                                                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                                            }
                                            CommerceBanner musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0 = ((v)(((w)object1))).a;
                                            RequestManager requestManager1 = Glide.with(this);
                                            CommerceBanner musicTabTitleBarBannerRes$RESPONSE$CommerceBanner1 = ((v)(((w)object1))).a;
                                            N n0 = new N((musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0 == null ? null : musicTabTitleBarBannerRes$RESPONSE$CommerceBanner0.getImgContent()), requestManager1, (musicTabTitleBarBannerRes$RESPONSE$CommerceBanner1 == null ? false : q.b(musicTabTitleBarBannerRes$RESPONSE$CommerceBanner1.getShowRedDot(), Boolean.TRUE)));
                                            if(this.isAdded()) {
                                                n0.c = new ad.c(((v)(((w)object1))), v2, 2);
                                                y y3 = new y(v2);
                                                ((v)(((w)object1))).b.invoke(y3);
                                            }
                                            if(o0 == null) {
                                                o0 = n0;
                                            }
                                            else {
                                                o0.g(n0);
                                            }
                                        }
                                        ++v2;
                                        v1 = v3;
                                        continue;
                                    }
                                    e.k.O();
                                    throw null;
                                }
                                v4 = v1;
                                if(o0 != null) {
                                    titleBar0.a(o0);
                                }
                            }
                            else {
                                v4 = v1;
                            }
                        }
                        this.o(q0.b, ((p)l0), v4 << 3 & 0x70);
                    }
                    else {
                        if(!(c0 instanceof A)) {
                            throw l1.c(((p)l0), 0x39E55CBC, false);
                        }
                        ((p)l0).a0(0x2CA80DB);
                        Object object2 = b00.getValue();
                        V0 v00 = object2 instanceof V0 ? ((V0)object2) : null;
                        V0 v01 = v00 == null ? new c3("", 0x7F080430, false, null, 12) : v00;  // drawable:ic_error_wifi
                        c1.w(v01, this.getDefaultNetworkErrorHandle().a(), this.getDefaultNetworkErrorHandle().b(), 0.0f, 0.0f, ((p)l0), 0, 24);
                    }
                    ((p)l0).p(false);
                }
                ((p)l0).p(false);
            }
            else {
                ((p)l0).T();
            }
            n0 n00 = ((p)l0).t();
            if(n00 != null) {
                n00.d = new Zc.c(this, v, 5);
            }
        }

        public final void o(List list0, androidx.compose.runtime.l l0, int v) {
            int v7;
            int v4;
            p p0 = (p)l0;
            p0.c0(0x25268096);
            int v1 = (v & 6) == 0 ? (p0.i(list0) ? 4 : 2) | v : v;
            if((v & 0x30) == 0) {
                v1 |= (p0.i(this) ? 0x20 : 16);
            }
            if(p0.Q(v1 & 1, (v1 & 19) != 18)) {
                FragmentActivity fragmentActivity0 = this.getActivity();
                q.e(fragmentActivity0, "null cannot be cast to non-null type com.iloen.melon.custom.IMiniPlayerControllable");
                int v2 = ((U)fragmentActivity0).getMiniPlayerHeight();
                F f0 = I.a(0, 0, 3, p0);
                Iterator iterator0 = ((ArrayList)list0).iterator();
                for(int v3 = 0; true; ++v3) {
                    v4 = -1;
                    if(!iterator0.hasNext()) {
                        break;
                    }
                    Object object0 = iterator0.next();
                    if(((K4)object0) instanceof s2) {
                        v4 = v3;
                        break;
                    }
                }
                int v5 = 0;
                Iterator iterator1 = ((ArrayList)list0).iterator();
                while(true) {
                    if(!iterator1.hasNext()) {
                        v5 = -1;
                        break;
                    }
                    Object object1 = iterator1.next();
                    if(((K4)object1) instanceof u2) {
                        break;
                    }
                    ++v5;
                }
                Iterator iterator2 = ((ArrayList)list0).iterator();
                for(int v6 = 0; true; ++v6) {
                    v7 = -1;
                    if(!iterator2.hasNext()) {
                        break;
                    }
                    Object object2 = iterator2.next();
                    if(((K4)object2) instanceof B2) {
                        v7 = v6;
                        break;
                    }
                }
                boolean z = f0.h.b();
                Boolean boolean0 = Boolean.valueOf(z);
                boolean z1 = p0.i(this);
                boolean z2 = p0.h(z);
                ad.e e0 = p0.N();
                V v8 = androidx.compose.runtime.k.a;
                if(z1 || z2 || e0 == v8) {
                    e0 = new ad.e(this, z, null);
                    p0.l0(e0);
                }
                J.d(p0, boolean0, e0);
                C0 c00 = Q0.N.u(p0);
                r0.q q0 = androidx.compose.foundation.layout.a.n(androidx.compose.ui.input.nestedscroll.a.a(d.c, c00, null), 0.0f, 0.0f, 0.0f, e0.Z(p0, v2), 7);
                Wf.a a0 = p0.N();
                if(a0 == v8) {
                    a0 = new Wf.a(9);
                    p0.l0(a0);
                }
                r0.q q1 = androidx.compose.ui.platform.a.a(n.c(q0, false, a0), "MusicTabLazyColumn");
                boolean z3 = p0.i(list0);
                boolean z4 = p0.e(v4);
                boolean z5 = p0.e(v7);
                boolean z6 = p0.e(v5);
                boolean z7 = p0.i(this);
                ad.d d0 = p0.N();
                if((z3 | z4 | z5 | z6 | z7) != 0 || d0 == v8) {
                    ad.d d1 = new ad.d(((ArrayList)list0), v4, v7, v5, this);
                    p0.l0(d1);
                    d0 = d1;
                }
                c1.o(q1, f0, null, false, null, null, null, false, d0, p0, 0, 0xFC);
                boolean z8 = p0.i(this);
                boolean z9 = p0.g(f0);
                g g0 = p0.N();
                if(z8 || z9 || g0 == v8) {
                    g0 = new g(this, f0, null);
                    p0.l0(g0);
                }
                J.d(p0, Boolean.TRUE, g0);
            }
            else {
                p0.T();
            }
            n0 n00 = p0.t();
            if(n00 != null) {
                n00.d = new Cc.U(this, ((ArrayList)list0), v, 8);
            }
        }

        @Override  // com.melon.ui.o1
        public final void onForeground() {
            super.onForeground();
            if(this.isFragmentVisible()) {
                this.sendUserEvent(M.a);
            }
        }

        @Override  // com.melon.ui.J0
        public final void onUiEvent(I4 i40) {
            q.g(i40, "event");
            if(i40 instanceof com.melon.ui.b) {
                l0 l00 = this.getChildFragmentManager();
                q.f(l00, "getChildFragmentManager(...)");
                com.melon.ui.a.f(this, l00, ((com.melon.ui.b)i40), this.getContext(), new i(1, 0, a.class, this, "sendUserEvent", "sendUserEvent(Lcom/melon/ui/interfaces/UserEvent;)V"));  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
            }
            super.onUiEvent(i40);
        }

        @Override  // com.melon.ui.u1
        public final void onViewCreated(View view0, Bundle bundle0) {
            q.g(view0, "view");
            super.onViewCreated(view0, bundle0);
            l2 l20 = (l2)this.getBinding();
            if(l20 == null) {
                return;
            }
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = l20.e.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type com.google.android.material.appbar.AppBarLayout.LayoutParams");
            LayoutParams appBarLayout$LayoutParams0 = (LayoutParams)viewGroup$LayoutParams0;
        }

        public final void p(K4 k40, androidx.compose.runtime.l l0, int v) {
            q.g(k40, "slotUiState");
            p p0 = (p)l0;
            p0.c0(-325481580);
            int v1 = (p0.g(k40) ? 4 : 2) | v | (p0.i(this) ? 0x20 : 16);
            if(!p0.Q(v1 & 1, (v1 & 19) != 18)) {
                p0.T();
            }
            else if(k40 instanceof u2) {
                p0.a0(0x2C65074E);
                t2.a(((u2)k40), p0, 0);
                p0.p(false);
            }
            else {
                if(k40 instanceof s2) {
                    p0.a0(0x2C650F8A);
                    V4.u.g(((s2)k40), p0, 0);
                }
                else if(k40 instanceof cd.V) {
                    p0.a0(744822503);
                    cd.U.b(((cd.V)k40), p0, 0);
                }
                else if(k40 instanceof B1) {
                    p0.a0(0x2C651EAD);
                    A1.b(((B1)k40), p0, 0);
                }
                else if(k40 instanceof cd.r) {
                    p0.a0(744826570);
                    cd.q.a(((cd.r)k40), p0, 0);
                }
                else if(k40 instanceof m1) {
                    p0.a0(0x2C652F71);
                    cd.l1.a(((m1)k40), p0, 0);
                }
                else if(k40 instanceof c2) {
                    p0.a0(744831085);
                    b2.b(((c2)k40), p0, 0);
                }
                else if(k40 instanceof Z) {
                    p0.a0(0x2C654192);
                    Y.a(((Z)k40), p0, 0);
                }
                else if(k40 instanceof cd.C0) {
                    p0.a0(744836053);
                    B0.c(((cd.C0)k40), p0, 0);
                }
                else if(k40 instanceof m0) {
                    p0.a0(744838770);
                    cd.l0.a(((m0)k40), p0, 0);
                }
                else if(k40 instanceof j0) {
                    p0.a0(0x2C65617C);
                    i0.a(((j0)k40), p0, 0);
                }
                else if(k40 instanceof c0) {
                    p0.a0(0x2C656C51);
                    cd.b0.a(((c0)k40), p0, 0);
                }
                else if(k40 instanceof G0) {
                    p0.a0(744846900);
                    F0.a(((G0)k40), p0, 0);
                }
                else if(k40 instanceof X0) {
                    p0.a0(0x2C6580D7);
                    W0.a(((X0)k40), p0, 0);
                }
                else if(k40 instanceof K0) {
                    p0.a0(744852406);
                    J0.a(((K0)k40), p0, 0);
                }
                else if(k40 instanceof R0) {
                    p0.a0(0x2C6596FA);
                    Q0.a(((R0)k40), p0, 0);
                }
                else if(k40 instanceof a1) {
                    p0.a0(0x2C65A0CB);
                    U4.F.a(((a1)k40), p0, 0);
                }
                else if(k40 instanceof cd.F) {
                    p0.a0(744860082);
                    E.a(((cd.F)k40), p0, 0);
                }
                else if(k40 instanceof O2) {
                    p0.a0(0x2C65B26A);
                    N2.b(((O2)k40), p0, 0);
                }
                else if(k40 instanceof j1) {
                    p0.a0(0x2C65BA8D);
                    i1.b(((j1)k40), p0, 0);
                }
                else if(k40 instanceof n2) {
                    p0.a0(744866408);
                    m2.b(((n2)k40), p0, 0);
                }
                else if(k40 instanceof B2) {
                    p0.a0(0x2C65CB59);
                    A2.a(((B2)k40), ((q0)this.getViewModel()).o, p0, 0);
                }
                else if(k40 instanceof Z2) {
                    p0.a0(0x2C65D92D);
                    Y2.b(((Z2)k40), p0, 0);
                }
                else if(k40 instanceof Q1) {
                    p0.a0(0x2C65E210);
                    P1.b(((Q1)k40), p0, 0);
                }
                else {
                    p0.a0(1604074894);
                }
                p0.p(false);
            }
            n0 n00 = p0.t();
            if(n00 != null) {
                n00.d = new Nc.Y(this, k40, v, 24);
            }
        }

        @Override  // com.melon.ui.u1
        public final void tiaraViewImpMapFlush() {
        }
    }

    @Override  // com.iloen.melon.fragments.tabs.BottomTabBaseFragment
    public final void onLazyCreateView() {
        this.addFragment(new a());
    }
}

