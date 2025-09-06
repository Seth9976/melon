package ld;

import Cb.i;
import Cc.U3;
import Kd.d;
import Na.f;
import Pc.a;
import Pc.b;
import Pc.e;
import Ud.g;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.kakao.tiara.data.ActionKind;
import com.melon.ui.B4;
import com.melon.ui.F4;
import com.melon.ui.K4;
import com.melon.ui.L2;
import com.melon.ui.N3;
import com.melon.ui.Q;
import com.melon.ui.b3;
import com.melon.ui.f1;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import com.melon.ui.n4;
import com.melon.ui.q3;
import com.melon.ui.t3;
import d5.n;
import e1.F;
import e1.m;
import e3.h;
import eb.y;
import gd.R7;
import h7.u0;
import hd.z1;
import i.n.i.b.a.s.e.M3;
import ie.H;
import ie.r;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import jd.N2;
import jd.e3;
import je.p;
import je.w;
import k8.Y;
import kb.D;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import oe.c;
import p8.s;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lld/x;", "Lcom/melon/ui/k1;", "LPc/a;", "Lcom/melon/ui/K4;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class x extends k1 implements a {
    public final b a;
    public final D b;
    public final n4 c;
    public final t3 d;
    public final b3 e;
    public final y f;
    public final Q g;
    public final StringProviderImpl h;
    public boolean i;
    public int j;
    public final LogU k;
    public final g l;
    public final r m;
    public static final int n;

    public x(D d0, n4 n40, t3 t30, b3 b30, y y0, Q q0, StringProviderImpl stringProviderImpl0) {
        this.a = new b();
        this.b = d0;
        this.c = n40;
        this.d = t30;
        this.e = b30;
        this.f = y0;
        this.g = q0;
        this.h = stringProviderImpl0;
        LogU logU0 = new LogU("NewSongViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.k = logU0;
        g g0 = new g(new h());  // 初始化器: Ljava/lang/Object;-><init>()V
        g0.c = new F();  // 初始化器: Ljava/lang/Object;-><init>()V
        this.l = g0;
        this.m = d3.g.Q(new e3(this, 10));
    }

    @Override  // Pc.a
    public final boolean a() {
        return this.a.b;
    }

    public static q c(q q0, x x0, K4 k40) {
        kotlin.jvm.internal.q.g(k40, "it");
        int v = x0.j;
        U3 u30 = U3.a(q0.f, 0, false, 0, 23);
        return q.a(q0, v, false, w.a, u30, 1);
    }

    public final q d() {
        Object object0 = this.getUiState().getValue();
        return object0 instanceof q ? ((q)object0) : null;
    }

    public static void e(x x0, String s, ActionKind actionKind0, String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, int v) {
        if((v & 2) != 0) {
            actionKind0 = null;
        }
        if((v & 16) != 0) {
            s3 = null;
        }
        if((v & 0x20) != 0) {
            s4 = null;
        }
        if((v & 0x40) != 0) {
            s5 = null;
        }
        if((v & 0x80) != 0) {
            s6 = null;
        }
        if((v & 0x100) != 0) {
            s7 = null;
        }
        if((v & 0x200) != 0) {
            s8 = null;
        }
        s s10 = x0.getTiaraProperty();
        if(s10 != null) {
            m.F(new ld.s(s, s10, actionKind0, s1, s2, s3, s4, s5, s6, s7, s8, ((v & 0x400) == 0 ? s9 : null))).track();
        }
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        g1 g12;
        x x2;
        K4 k40;
        L0 l02;
        L0 l01;
        Object object3;
        x x0;
        Object object2;
        String s1;
        v v0;
        if(continuation0 instanceof v) {
            v0 = (v)continuation0;
            int v1 = v0.I;
            if((v1 & 0x80000000) == 0) {
                v0 = new v(this, ((c)continuation0));
            }
            else {
                v0.I = v1 ^ 0x80000000;
            }
        }
        else {
            v0 = new v(this, ((c)continuation0));
        }
        Object object0 = v0.E;
        ne.a a0 = ne.a.a;
        switch(v0.I) {
            case 0: {
                n.D(object0);
                String s = "onFetchStart() type: " + i.o(g10);
                LogU.info$default(this.k, s, null, false, 6, null);
                L0 l00 = this.getProgressUpdater();
                s1 = "NewSongViewModel";
                b b0 = this.a;
                D d0 = this.b;
                String s2 = "O";
                if(l00 == null) {
                    if(g10 instanceof f1) {
                        b0.c();
                        q q0 = this.d();
                        if(q0 != null) {
                            this.updateUiState(new R7(26, q0, this));
                        }
                    }
                    if(this.j == 0) {
                        s2 = "I";
                    }
                    int v2 = b0.b();
                    v0.r = null;
                    v0.w = null;
                    v0.B = g10;
                    v0.D = this;
                    v0.I = 1;
                    Object object1 = d0.k(v2, 100, s2, v0);
                    if(object1 == a0) {
                        return a0;
                    }
                    object2 = object1;
                    x0 = this;
                    goto label_71;
                }
                else {
                    l00.a("NewSongViewModel true", true);
                    try {
                        if(g10 instanceof f1) {
                            b0.c();
                            q q1 = this.d();
                            if(q1 != null) {
                                this.updateUiState(new R7(26, q1, this));
                            }
                        }
                        if(this.j == 0) {
                            s2 = "I";
                        }
                        int v3 = b0.b();
                        v0.r = l00;
                        v0.w = "NewSongViewModel";
                        v0.B = g10;
                        v0.D = this;
                        v0.I = 2;
                        object3 = d0.k(v3, 100, s2, v0);
                    }
                    catch(Throwable throwable0) {
                        l01 = l00;
                        Y.v(s1, " false", l01, false);
                        throw throwable0;
                    }
                    if(object3 == a0) {
                        return a0;
                    }
                    try {
                        l02 = l00;
                        this.getClass();
                        k40 = this.handleDefaultHttpResponseResult(((f)object3), new R7(28, this, g10));
                        goto label_87;
                    }
                    catch(Throwable throwable0) {
                        l01 = l02;
                        Y.v(s1, " false", l01, false);
                        throw throwable0;
                    }
                }
                break;
            }
            case 1: {
                x x1 = v0.D;
                g1 g11 = v0.B;
                n.D(object0);
                x0 = x1;
                g10 = g11;
                object2 = object0;
            label_71:
                x0.getClass();
                K4 k41 = x0.handleDefaultHttpResponseResult(((f)object2), new R7(28, x0, g10));
                if(k41 != null) {
                    this.updateUiState(new z1(k41, 8));
                    return H.a;
                }
                break;
            }
            case 2: {
                try {
                    x2 = v0.D;
                    g12 = v0.B;
                    s1 = v0.w;
                    l01 = v0.r;
                    n.D(object0);
                    l02 = l01;
                }
                catch(Throwable throwable0) {
                    Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                try {
                    x2.getClass();
                    k40 = x2.handleDefaultHttpResponseResult(((f)object0), new R7(28, x2, g12));
                label_87:
                    if(k40 != null) {
                        this.updateUiState(new z1(k40, 8));
                    }
                }
                catch(Throwable throwable0) {
                    l01 = l02;
                    Y.v(s1, " false", l01, false);
                    throw throwable0;
                }
                Y.v(s1, " false", l02, false);
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
        kotlin.jvm.internal.q.g(e0, "userEvent");
        boolean z = false;
        StringProviderImpl stringProviderImpl0 = this.h;
        if(e0 instanceof Kd.f) {
            if(((Kd.f)e0) instanceof Kd.b) {
                Kd.g g0 = ((Kd.b)(((Kd.f)e0))).a;
                LogU.debug$default(this.k, "selectItem() selectItem\'s songName:" + g0.b, null, false, 6, null);
                q q0 = this.d();
                if(q0 != null) {
                    List list0 = q0.e;
                    if(!list0.isEmpty()) {
                        LogU.debug$default(this.k, "selectItem() songList\'s size:" + list0.size(), null, false, 6, null);
                        this.updateUiState(new R7(27, this.l.b(list0, g0), q0));
                    }
                }
                String s = stringProviderImpl0.a(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
                String s1 = stringProviderImpl0.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                String s2 = stringProviderImpl0.a(0x7F130E38);  // string:tiara_common_layer2_select_song "곡선택"
                String s3 = stringProviderImpl0.a(0x7F130F01);  // string:tiara_meta_type_song "곡"
                x.e(this, s, ActionKind.ClickContent, s1, s2, String.valueOf(((Kd.b)(((Kd.f)e0))).b + 1), g0.f, null, g0.a, s3, g0.b, g0.G, 0x40);
                return;
            }
            if(((Kd.f)e0) instanceof Kd.c) {
                u0.L(this, Dispatchers.getIO(), new u(((Kd.f)e0), this, null), 2);
                return;
            }
            if(((Kd.f)e0) instanceof Kd.e) {
                Navigator.openAlbumInfo(((Kd.e)(((Kd.f)e0))).a.c);
                String s4 = stringProviderImpl0.a(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
                String s5 = stringProviderImpl0.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                String s6 = stringProviderImpl0.a(0x7F130E2F);  // string:tiara_common_layer2_move_page "페이지이동"
                String s7 = stringProviderImpl0.a(0x7F130EF0);  // string:tiara_meta_type_album "앨범"
                x.e(this, s4, ActionKind.ClickContent, s5, s6, String.valueOf(((Kd.e)(((Kd.f)e0))).b + 1), ((Kd.e)(((Kd.f)e0))).a.f, null, ((Kd.e)(((Kd.f)e0))).a.c, s7, ((Kd.e)(((Kd.f)e0))).a.d, ((Kd.e)(((Kd.f)e0))).a.G, 0x40);
                return;
            }
            if(((Kd.f)e0) instanceof d) {
                String s8 = this.getMenuId();
                List list1 = Collections.singletonList(Kd.h.b(((d)(((Kd.f)e0))).a, s8));
                kotlin.jvm.internal.q.d(list1);
                this.sendUiEvent(new B4(28, this.getMenuId(), list1, false));
                String s9 = stringProviderImpl0.a(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
                String s10 = stringProviderImpl0.a(0x7F130DFF);  // string:tiara_common_layer1_music_list "곡리스트"
                String s11 = stringProviderImpl0.a(0x7F130E32);  // string:tiara_common_layer2_play_music "음악재생"
                String s12 = stringProviderImpl0.a(0x7F130F01);  // string:tiara_meta_type_song "곡"
                x.e(this, s9, ActionKind.PlayMusic, s10, s11, String.valueOf(((d)(((Kd.f)e0))).b + 1), ((d)(((Kd.f)e0))).a.f, null, ((d)(((Kd.f)e0))).a.a, s12, ((d)(((Kd.f)e0))).a.b, ((d)(((Kd.f)e0))).a.G, 0x40);
                return;
            }
            if(!(((Kd.f)e0) instanceof Kd.a)) {
                throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
            }
            String s13 = this.getMenuId();
            this.sendUiEvent(new F4(Kd.h.b(((Kd.a)(((Kd.f)e0))).a, s13), this.getMenuId()));
            return;
        }
        if(e0 instanceof ld.d) {
            int v = this.j;
            int v1 = ((ld.d)e0).a;
            if(v == v1) {
                return;
            }
            this.j = v1;
            k1.startFetch$default(this, true, null, null, 6, null);
            x.e(this, stringProviderImpl0.a(0x7F130DC9), null, stringProviderImpl0.a(0x7F130E02), stringProviderImpl0.a(0x7F130E2F), null, null, stringProviderImpl0.a((this.j == 0 ? 0x7F130F8C : 0x7F130F8D)), null, null, null, null, 1970);  // string:tiara_common_action_name_move_page "페이지이동"
            return;
        }
        if(e0 instanceof ld.g) {
            q q1 = this.d();
            if(q1 != null && !q1.d) {
                z = true;
            }
            this.selectAll(z);
            x.e(this, stringProviderImpl0.a(0x7F130DD0), null, stringProviderImpl0.a(0x7F130DFF), stringProviderImpl0.a(0x7F130E36), null, null, null, null, null, null, null, 0x7F2);  // string:tiara_common_action_name_select "선택"
            return;
        }
        if(e0 instanceof ld.f) {
            k1.startFetch$default(this, true, null, null, 6, null);
            x.e(this, stringProviderImpl0.a(0x7F130DC9), null, stringProviderImpl0.a(0x7F130DFF), stringProviderImpl0.a(0x7F130E35), null, null, null, null, null, null, null, 0x7F2);  // string:tiara_common_action_name_move_page "페이지이동"
            return;
        }
        if(e0 instanceof ld.e) {
            Iterable iterable0 = p.P0(this.a.a);
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, iterable0));
            for(Object object0: iterable0) {
                kotlin.jvm.internal.q.e(((K4)object0), "null cannot be cast to non-null type com.melon.ui.viewholder.SongListItemUiState");
                arrayList0.add(Kd.h.b(((Kd.g)(((K4)object0))), this.getMenuId()));
            }
            this.sendUiEvent(new B4(28, this.getMenuId(), arrayList0, false));
            x.e(this, stringProviderImpl0.a(0x7F130DCB), null, stringProviderImpl0.a(0x7F130DFF), stringProviderImpl0.a(0x7F130E31), null, null, null, null, null, null, null, 0x7F2);  // string:tiara_common_action_name_play_music "음악재생"
            return;
        }
        if(e0 instanceof N3) {
            T2.a a0 = f0.h(this);
            boolean z1 = ((e0)o.a()).m();
            N2 n20 = new N2(1, this, x.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 11);
            L0 l00 = this.getProgressUpdater();
            this.c.b(((N3)e0), a0, z1, n20, l00);
            return;
        }
        if(e0 instanceof q3) {
            T2.a a1 = f0.h(this);
            boolean z2 = ((e0)o.a()).m();
            N2 n21 = new N2(1, this, x.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 12);
            L0 l01 = this.getProgressUpdater();
            this.d.a(((q3)e0), a1, z2, n21, l01);
            return;
        }
        if(e0 instanceof L2) {
            T2.a a2 = f0.h(this);
            boolean z3 = ((e0)o.a()).m();
            N2 n22 = new N2(1, this, x.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 13);
            L0 l02 = this.getProgressUpdater();
            this.e.b(((L2)e0), a2, z3, n22, l02);
            return;
        }
        if(e0 instanceof com.melon.ui.q) {
            T2.a a3 = f0.h(this);
            N2 n23 = new N2(1, this, x.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 14);
            this.g.d(((com.melon.ui.q)e0), a3, n23);
            return;
        }
        if(e0 instanceof Ed.a) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new ld.w(this, e0, null), 2, null);
            return;
        }
        super.onUserEvent(e0);
    }

    public final void selectAll(boolean z) {
        q q0 = this.d();
        if(q0 != null) {
            List list0 = q0.e;
            if(!list0.isEmpty()) {
                this.updateUiState(new R7(25, this.l.a(list0, z), q0));
            }
        }
    }
}

