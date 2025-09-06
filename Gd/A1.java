package gd;

import Ac.m4;
import Cd.t;
import Pc.a;
import Pc.b;
import Pc.e;
import Yc.D;
import android.content.Context;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.response.DjBrandDetailDjplaylistListRes.RESPONSE.DJPLAYLISTLIST;
import com.iloen.melon.net.v6x.response.DjBrandDetailDjplaylistListRes.RESPONSE;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.K4;
import com.melon.ui.L2;
import com.melon.ui.N3;
import com.melon.ui.Q;
import com.melon.ui.Z0;
import com.melon.ui.b1;
import com.melon.ui.b3;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.f1;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import com.melon.ui.n4;
import d5.n;
import dd.z;
import h7.u0;
import hb.f;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import je.p;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import mb.k;
import oe.c;
import p8.g;
import p8.s;
import va.e0;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lgd/a1;", "Lcom/melon/ui/k1;", "LPc/a;", "Lgd/P0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class a1 extends k1 implements a {
    public final b a;
    public final StringProviderImpl b;
    public final f c;
    public final Q d;
    public final b3 e;
    public final n4 f;
    public final k g;
    public String h;
    public String i;
    public Context j;
    public static final int k;

    public a1(Q q0, b3 b30, n4 n40, StringProviderImpl stringProviderImpl0, f f0, k k0) {
        q.g(k0, "loginUseCase");
        super();
        this.a = new b();
        this.b = stringProviderImpl0;
        this.c = f0;
        this.d = q0;
        this.e = b30;
        this.f = n40;
        this.g = k0;
    }

    @Override  // Pc.a
    public final boolean a() {
        return this.a.b;
    }

    public static m4 c(a1 a10, d1 d10) {
        q.g(d10, "fetchResult");
        if(d10 instanceof c1) {
            RESPONSE djBrandDetailDjplaylistListRes$RESPONSE0 = (RESPONSE)((c1)d10).a;
            ArrayList arrayList0 = new ArrayList();
            ArrayList arrayList1 = djBrandDetailDjplaylistListRes$RESPONSE0.djPlaylistList;
            q.f(arrayList1, "djPlaylistList");
            ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
            for(Object object0: arrayList1) {
                arrayList2.add(Boolean.valueOf(arrayList0.add(new P0(((DJPLAYLISTLIST)object0).plylstseq, ((DJPLAYLISTLIST)object0).thumbimg, ((DJPLAYLISTLIST)object0).plylsttitle, ((DJPLAYLISTLIST)object0).ownermemberkey, ((DJPLAYLISTLIST)object0).ownernickname, ((DJPLAYLISTLIST)object0).likecnt, ((DJPLAYLISTLIST)object0).statsElements, ((DJPLAYLISTLIST)object0).songcnt, ((DJPLAYLISTLIST)object0).fameregyn, ((DJPLAYLISTLIST)object0).withdrawyn, ((DJPLAYLISTLIST)object0).delYn))));
            }
            a10.a.d(arrayList0, djBrandDetailDjplaylistListRes$RESPONSE0.hasMore);
            return new T0(p.P0(a10.a.a));
        }
        if(d10 instanceof Z0) {
            return new R0(((Z0)d10).a);
        }
        if(d10 instanceof com.melon.ui.a1) {
            a10.cancelFetch();
            return null;
        }
        if(!(d10 instanceof b1)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return new S0(((b1)d10).a);
    }

    public final Context d() {
        Context context0 = this.j;
        if(context0 != null) {
            return context0;
        }
        q.m("context");
        throw null;
    }

    public final p8.f e() {
        String s = null;
        if(this.getTiaraProperty() == null) {
            return null;
        }
        p8.f f0 = new g();  // 初始化器: Lp8/f;-><init>()V
        s s1 = this.getTiaraProperty();
        f0.b = s1 == null ? null : s1.a;
        s s2 = this.getTiaraProperty();
        f0.c = s2 == null ? null : s2.b;
        s s3 = this.getTiaraProperty();
        if(s3 != null) {
            s = s3.c;
        }
        f0.I = s;
        return f0;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        K4 k40;
        String s;
        Throwable throwable1;
        L0 l01;
        Object object1;
        X0 x00;
        if(continuation0 instanceof X0) {
            x00 = (X0)continuation0;
            int v = x00.E;
            if((v & 0x80000000) == 0) {
                x00 = new X0(this, ((c)continuation0));
            }
            else {
                x00.E = v ^ 0x80000000;
            }
        }
        else {
            x00 = new X0(this, ((c)continuation0));
        }
        Object object0 = x00.B;
        ne.a a0 = ne.a.a;
        switch(x00.E) {
            case 0: {
                n.D(object0);
                L0 l00 = this.getProgressUpdater();
                b b0 = this.a;
                if(l00 == null) {
                    if(g10 instanceof f1) {
                        b0.c();
                    }
                    Deferred deferred0 = u0.j(this, Dispatchers.getDefault(), new Y0(this, null), 2);
                    x00.r = null;
                    x00.w = null;
                    x00.E = 1;
                    object0 = deferred0.await(x00);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_47;
                }
                else {
                    l00.a("FetchViewModel true", true);
                    try {
                        if(g10 instanceof f1) {
                            b0.c();
                        }
                        Deferred deferred1 = u0.j(this, Dispatchers.getDefault(), new Y0(this, null), 2);
                        x00.r = l00;
                        x00.w = "FetchViewModel";
                        x00.E = 2;
                        object1 = deferred1.await(x00);
                    }
                    catch(Throwable throwable0) {
                        l01 = l00;
                        throwable1 = throwable0;
                        s = "FetchViewModel";
                        Y.v(s, " false", l01, false);
                        throw throwable1;
                    }
                    if(object1 == a0) {
                        return a0;
                    }
                    try {
                        l01 = l00;
                        s = "FetchViewModel";
                        k40 = this.handleDefaultHttpResponseResult(((Na.f)object1), new z(this, 14));
                        goto label_55;
                    }
                    catch(Throwable throwable1) {
                        Y.v(s, " false", l01, false);
                        throw throwable1;
                    }
                }
                break;
            }
            case 1: {
                n.D(object0);
            label_47:
                K4 k41 = this.handleDefaultHttpResponseResult(((Na.f)object0), new z(this, 14));
                if(k41 != null) {
                    this.updateUiState(new t(k41, 21));
                    return H.a;
                }
                break;
            }
            case 2: {
                try {
                    s = x00.w;
                    l01 = x00.r;
                    n.D(object0);
                    k40 = this.handleDefaultHttpResponseResult(((Na.f)object0), new z(this, 14));
                label_55:
                    if(k40 != null) {
                        this.updateUiState(new t(k40, 21));
                    }
                }
                catch(Throwable throwable1) {
                    Y.v(s, " false", l01, false);
                    throw throwable1;
                }
                Y.v(s, " false", l01, false);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        return H.a;
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof V0) {
            P0 p00 = ((V0)e0).a;
            Navigator.openDjPlaylistDetail(p00.a);
            p8.f f0 = this.e();
            if(f0 == null) {
                return;
            }
            Context context0 = this.d();
            String s = this.b.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            String s1 = this.b.a(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
            String s2 = this.b.a(0x7F130D54);  // string:tiara_click_copy_more "더보기"
            String s3 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            com.google.firebase.b.O(f0, context0, s, s1, ActionKind.ClickContent, s2, 0, p00.a, s3, p00.c, null, null, false, 0, 0x1E20);
            return;
        }
        if(e0 instanceof U0) {
            P0 p01 = ((U0)e0).a;
            String s4 = p01.a;
            if(s4 != null) {
                com.melon.ui.k k0 = new com.melon.ui.k(s4, this.getMenuId(), p01.g, 0x20);
                T2.a a0 = f0.h(this);
                D d0 = new D(1, this, a1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 29);
                this.d.d(k0, a0, d0);
                p8.f f1 = this.e();
                if(f1 != null) {
                    Context context1 = this.d();
                    q.f("리스트", "getString(...)");
                    String s5 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
                    com.google.firebase.b.O(f1, context1, "음악재생", "리스트", ActionKind.PlayMusic, "더보기", 0, p01.a, s5, p01.c, null, null, false, 0, 0x1E20);
                }
            }
            return;
        }
        if(e0 instanceof W0) {
            P0 p02 = ((W0)e0).a;
            boolean z = q.b(p02.k, "Y");
            this.sendUiEvent(new Q0((p02.a == null ? "" : p02.a), (p02.c == null ? "" : p02.c), (p02.e == null ? "" : p02.e), (p02.d == null ? "" : p02.d), (p02.i == null ? "" : p02.i), (p02.h == null ? "" : p02.h), (p02.j == null ? "" : p02.j), p02.b, z));
            return;
        }
        k k1 = this.g;
        if(e0 instanceof L2) {
            T2.a a1 = f0.h(this);
            boolean z1 = ((e0)k1).m();
            gd.Z0 z00 = new gd.Z0(1, this, a1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 0);
            L0 l00 = this.getProgressUpdater();
            this.e.b(((L2)e0), a1, z1, z00, l00);
            return;
        }
        if(e0 instanceof N3) {
            T2.a a2 = f0.h(this);
            boolean z2 = ((e0)k1).m();
            gd.Z0 z01 = new gd.Z0(1, this, a1.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 1);
            L0 l01 = this.getProgressUpdater();
            this.f.b(((N3)e0), a2, z2, z01, l01);
            return;
        }
        super.onUserEvent(e0);
    }
}

