package gd;

import Cd.t;
import H8.q;
import Pc.a;
import Pc.b;
import Pc.e;
import android.content.Context;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
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
import d3.g;
import d5.n;
import h7.u0;
import hb.f;
import ie.H;
import ie.r;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import mb.k;
import oe.c;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lgd/n6;", "Lcom/melon/ui/k1;", "LPc/a;", "Lgd/X5;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class n6 extends k1 implements a {
    public final b a;
    public final f b;
    public final Q c;
    public final b3 d;
    public final n4 e;
    public final k f;
    public String g;
    public int h;
    public Context i;
    public String j;
    public final r k;
    public static final int l;

    public n6(f f0, q q0, Q q1, b3 b30, n4 n40, StringProviderImpl stringProviderImpl0, k k0) {
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        super();
        this.a = new b();
        this.b = f0;
        this.c = q1;
        this.d = b30;
        this.e = n40;
        this.f = k0;
        LogU logU0 = new LogU("MelonDjTagHubBottomViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.g = "";
        this.k = g.Q(new ed.f(this, 20));
    }

    @Override  // Pc.a
    public final boolean a() {
        return this.a.b;
    }

    public final Object c(f1 f10, c c0) {
        l6 l60;
        if(c0 instanceof l6) {
            l60 = (l6)c0;
            int v = l60.D;
            if((v & 0x80000000) == 0) {
                l60 = new l6(this, c0);
            }
            else {
                l60.D = v ^ 0x80000000;
            }
        }
        else {
            l60 = new l6(this, c0);
        }
        Object object0 = l60.w;
        ne.a a0 = ne.a.a;
        switch(l60.D) {
            case 0: {
                n.D(object0);
                if(f10 != null) {
                    this.a.c();
                    this.j = null;
                }
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(f0.h(this), Dispatchers.getDefault(), null, new m6(this, null), 2, null);
                l60.r = f10;
                l60.D = 1;
                object0 = deferred0.await(l60);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                f10 = l60.r;
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        K4 k40 = this.handleDefaultHttpResponseResult(((Na.f)object0), new l(25, f10, this));
        if(k40 != null) {
            this.updateUiState(new t(k40, 27));
        }
        return H.a;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        u0.L(this, Dispatchers.getDefault(), new j6(this, null), 2);
        return H.a;
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(e e0) {
        kotlin.jvm.internal.q.g(e0, "userEvent");
        if(e0 instanceof e6) {
            Navigator.openMelonDJTagHubDetail(((e6)e0).a);
            return;
        }
        if(e0 instanceof i6) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new k6(this, e0, null), 2, null);
            return;
        }
        if(e0 instanceof g6) {
            this.sendUiEvent(new Z5(((g6)e0).a));
            return;
        }
        if(e0 instanceof d6) {
            Navigator.openDjPlaylistDetail(((d6)e0).a.b);
            return;
        }
        if(e0 instanceof f6) {
            Navigator.openDjPlaylistDetail(((f6)e0).a.b);
            return;
        }
        if(e0 instanceof h6) {
            V5 v50 = ((h6)e0).a;
            String s = v50.b;
            if(s != null) {
                com.melon.ui.k k0 = new com.melon.ui.k(s, this.getMenuId(), v50.n, 0x20);
                T2.a a0 = f0.h(this);
                v5 v51 = new v5(1, this, n6.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 6);
                this.c.d(k0, a0, v51);
            }
            return;
        }
        if(e0 instanceof L2) {
            T2.a a1 = f0.h(this);
            boolean z = ((e0)o.a()).m();
            v5 v52 = new v5(1, this, n6.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 7);
            L0 l00 = this.getProgressUpdater();
            this.d.b(((L2)e0), a1, z, v52, l00);
            return;
        }
        if(e0 instanceof N3) {
            T2.a a2 = f0.h(this);
            boolean z1 = ((e0)o.a()).m();
            v5 v53 = new v5(1, this, n6.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 8);
            L0 l01 = this.getProgressUpdater();
            this.e.b(((N3)e0), a2, z1, v53, l01);
            return;
        }
        super.onUserEvent(e0);
    }
}

