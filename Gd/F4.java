package gd;

import Ac.m4;
import Cd.t;
import Pc.a;
import Pc.b;
import Pc.e;
import android.content.Context;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res.RESPONSE.PLAYLIST;
import com.iloen.melon.net.v6x.response.DjPlaylistListV6Res.RESPONSE;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.H4;
import com.melon.ui.K4;
import com.melon.ui.L2;
import com.melon.ui.Q;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.b3;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.f1;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import com.melon.ui.n4;
import d3.g;
import d5.n;
import h7.u0;
import hb.f;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.List;
import je.p;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import mb.k;
import oe.c;
import p8.s;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lgd/f4;", "Lcom/melon/ui/k1;", "LPc/a;", "Lgd/O3;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class f4 extends k1 implements a {
    public final b a;
    public final StringProviderImpl b;
    public final f c;
    public final k d;
    public final Q e;
    public final b3 f;
    public final n4 g;
    public int h;
    public int i;
    public Context j;
    public final r k;
    public final r l;
    public static final int m;

    public f4(Q q0, b3 b30, n4 n40, StringProviderImpl stringProviderImpl0, f f0, k k0) {
        q.g(k0, "loginUseCase");
        super();
        this.a = new b();
        this.b = stringProviderImpl0;
        this.c = f0;
        this.d = k0;
        this.e = q0;
        this.f = b30;
        this.g = n40;
        this.k = g.Q(new a4(this, 0));
        this.l = g.Q(new a4(this, 1));
    }

    @Override  // Pc.a
    public final boolean a() {
        return this.a.b;
    }

    public static m4 c(g1 g10, f4 f40, d1 d10) {
        b b0 = f40.a;
        q.g(d10, "fetchResult");
        if(d10 instanceof c1) {
            RESPONSE djPlaylistListV6Res$RESPONSE0 = (RESPONSE)((c1)d10).a;
            ArrayList arrayList0 = new ArrayList();
            if(g10 instanceof f1) {
                arrayList0.add(f40.e());
            }
            ArrayList arrayList1 = djPlaylistListV6Res$RESPONSE0.djPlaylists;
            q.f(arrayList1, "djPlaylists");
            ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList1));
            for(Object object0: arrayList1) {
                boolean z = q.b(((PLAYLIST)object0).openyn, "N");
                arrayList2.add(Boolean.valueOf(arrayList0.add(new N3(((PLAYLIST)object0).plylstseq, ((PLAYLIST)object0).thumbimg, ((PLAYLIST)object0).plylsttitle, ((PLAYLIST)object0).ownermemberkey, ((PLAYLIST)object0).ownernickname, ((PLAYLIST)object0).likecnt, ((PLAYLIST)object0).statsElements, ((PLAYLIST)object0).songcnt, ((PLAYLIST)object0).fameregyn, ((PLAYLIST)object0).withdrawyn, ((PLAYLIST)object0).delYn, !z))));
            }
            b0.d(arrayList0, djPlaylistListV6Res$RESPONSE0.hasMore);
            return new S3(p.P0(b0.a));
        }
        if(d10 instanceof Z0) {
            return new Q3(((Z0)d10).a);
        }
        if(d10 instanceof a1) {
            f40.cancelFetch();
            return null;
        }
        if(!(d10 instanceof b1)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        return new R3(((b1)d10).a);
    }

    public final Context d() {
        Context context0 = this.j;
        if(context0 != null) {
            return context0;
        }
        q.m("context");
        throw null;
    }

    public final gd.M3 e() {
        int v = this.h;
        int v1 = this.i;
        return (v == 0 ? "ALL" : "POWERDJ").equals("ALL") ? new gd.M3(v, v1, ((List)this.k.getValue())) : new gd.M3(v, v1, ((List)this.l.getValue()));
    }

    public final p8.f f() {
        String s = null;
        if(this.getTiaraProperty() == null) {
            return null;
        }
        p8.f f0 = new p8.g();  // 初始化器: Lp8/f;-><init>()V
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
        g1 g11;
        String s1;
        K4 k40;
        L0 l01;
        Object object1;
        String s;
        L0 l00;
        b4 b40;
        if(continuation0 instanceof b4) {
            b40 = (b4)continuation0;
            int v = b40.G;
            if((v & 0x80000000) == 0) {
                b40 = new b4(this, ((c)continuation0));
            }
            else {
                b40.G = v ^ 0x80000000;
            }
        }
        else {
            b40 = new b4(this, ((c)continuation0));
        }
        Object object0 = b40.D;
        ne.a a0 = ne.a.a;
        switch(b40.G) {
            case 0: {
                n.D(object0);
                l00 = this.getProgressUpdater();
                s = "FetchViewModel";
                b b0 = this.a;
                if(l00 == null) {
                    if(g10 instanceof f1) {
                        b0.c();
                    }
                    Deferred deferred0 = u0.j(this, Dispatchers.getDefault(), new c4(this, null), 2);
                    b40.r = g10;
                    b40.w = null;
                    b40.B = null;
                    b40.G = 1;
                    object0 = deferred0.await(b40);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_44;
                }
                else {
                    l00.a("FetchViewModel true", true);
                    try {
                        if(g10 instanceof f1) {
                            b0.c();
                        }
                        Deferred deferred1 = u0.j(this, Dispatchers.getDefault(), new c4(this, null), 2);
                        b40.r = g10;
                        b40.w = l00;
                        b40.B = "FetchViewModel";
                        b40.G = 2;
                        object1 = deferred1.await(b40);
                        if(object1 == a0) {
                            return a0;
                        }
                        l01 = l00;
                        k40 = this.handleDefaultHttpResponseResult(((Na.f)object1), new l(18, g10, this));
                        goto label_57;
                    }
                    catch(Throwable throwable0) {
                        l01 = l00;
                        throwable1 = throwable0;
                        s1 = s;
                        goto label_67;
                    }
                    return a0;
                }
                break;
            }
            case 1: {
                g10 = b40.r;
                n.D(object0);
            label_44:
                K4 k41 = this.handleDefaultHttpResponseResult(((Na.f)object0), new l(18, g10, this));
                if(k41 != null) {
                    this.updateUiState(new t(k41, 24));
                    return H.a;
                }
                break;
            }
            case 2: {
                try {
                    s1 = b40.B;
                    l01 = b40.w;
                    g11 = b40.r;
                    n.D(object0);
                    s = s1;
                }
                catch(Throwable throwable1) {
                    goto label_67;
                }
                try {
                    k40 = this.handleDefaultHttpResponseResult(((Na.f)object0), new l(18, g11, this));
                label_57:
                    if(k40 != null) {
                        this.updateUiState(new t(k40, 24));
                    }
                    goto label_69;
                }
                catch(Throwable throwable1) {
                    while(true) {
                        try {
                            s1 = s;
                            goto label_67;
                        }
                        catch(Throwable throwable0) {
                        }
                        break;
                    }
                }
                l01 = l00;
                throwable1 = throwable0;
                s1 = s;
            label_67:
                Y.v(s1, " false", l01, false);
                throw throwable1;
            label_69:
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
        if(e0 instanceof W3) {
            N3 n30 = ((W3)e0).a;
            Navigator.openDjPlaylistDetail(n30.a);
            p8.f f0 = this.f();
            if(f0 == null) {
                return;
            }
            Context context0 = this.d();
            String s = this.b.a(0x7F130ED4);  // string:tiara_melon_dj_layer1_list "리스트"
            String s1 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
            com.google.firebase.b.O(f0, context0, null, s, ActionKind.ClickContent, null, ((W3)e0).b, n30.a, s1, n30.c, n30.e, null, false, this.h, 3090);
            return;
        }
        if(e0 instanceof V3) {
            N3 n31 = ((V3)e0).a;
            String s2 = n31.a;
            if(s2 != null) {
                com.melon.ui.k k0 = new com.melon.ui.k(s2, this.getMenuId(), n31.g, 0x20);
                T2.a a0 = f0.h(this);
                j3 j30 = new j3(1, this, f4.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 14);
                this.e.d(k0, a0, j30);
                p8.f f1 = this.f();
                if(f1 != null) {
                    Context context1 = this.d();
                    q.f("리스트", "getString(...)");
                    String s3 = Y.i(ContsTypeCode.DJ_PLAYLIST, "code(...)");
                    com.google.firebase.b.O(f1, context1, null, "리스트", ActionKind.PlayMusic, null, ((V3)e0).b, n31.a, s3, n31.c, n31.e, null, false, this.h, 3090);
                }
            }
            return;
        }
        if(e0 instanceof X3) {
            N3 n32 = ((X3)e0).a;
            boolean z = q.b(n32.k, "Y");
            this.sendUiEvent(new P3((n32.a == null ? "" : n32.a), (n32.c == null ? "" : n32.c), (n32.e == null ? "" : n32.e), (n32.d == null ? "" : n32.d), (n32.i == null ? "" : n32.i), (n32.h == null ? "" : n32.h), (n32.j == null ? "" : n32.j), n32.b, z, n32.l));
            return;
        }
        if(e0 instanceof T3) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new d4(this, e0, null), 2, null);
            return;
        }
        if(e0 instanceof U3) {
            this.sendUiEvent(new H4(((U3)e0).a, this.i));
            return;
        }
        if(e0 instanceof Y3) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new e4(this, e0, null), 2, null);
            return;
        }
        if(e0 instanceof L2) {
            T2.a a1 = f0.h(this);
            boolean z1 = ((e0)o.a()).m();
            j3 j31 = new j3(1, this, f4.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 15);
            L0 l00 = this.getProgressUpdater();
            this.f.b(((L2)e0), a1, z1, j31, l00);
            return;
        }
        if(e0 instanceof com.melon.ui.N3) {
            T2.a a2 = f0.h(this);
            boolean z2 = ((e0)o.a()).m();
            j3 j32 = new j3(1, this, f4.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 16);
            L0 l01 = this.getProgressUpdater();
            this.g.b(((com.melon.ui.N3)e0), a2, z2, j32, l01);
            return;
        }
        super.onUserEvent(e0);
    }
}

