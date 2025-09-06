package gd;

import Pc.a;
import Pc.b;
import Pc.e;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.MelonLinkExecutor;
import com.melon.ui.Q;
import com.melon.ui.f1;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import com.melon.ui.o;
import hb.f;
import ie.H;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lgd/y2;", "Lcom/melon/ui/k1;", "LPc/a;", "Lgd/r2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class y2 extends k1 implements a {
    public final b a;
    public final f b;
    public final Q c;
    public final StringProviderImpl d;
    public String e;
    public String f;
    public static final int g;

    public y2(f f0, Q q0, StringProviderImpl stringProviderImpl0) {
        this.a = new b();
        this.b = f0;
        this.c = q0;
        this.d = stringProviderImpl0;
    }

    @Override  // Pc.a
    public final boolean a() {
        return this.a.b;
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        L0 l00 = this.getProgressUpdater();
        b b0 = this.a;
        if(l00 == null) {
            if(g10 instanceof f1) {
                b0.c();
            }
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new x2(this, null), 2, null);
            return H.a;
        }
        l00.a("MelonDjBrandVideoViewModel true", true);
        try {
            if(g10 instanceof f1) {
                b0.c();
            }
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new x2(this, null), 2, null);
            return H.a;
        }
        finally {
            l00.a("MelonDjBrandVideoViewModel false", false);
        }
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof v2) {
            r2 r20 = ((v2)e0).a;
            String s = r20.i;
            if(q.b(s, "N10003")) {
                String s1 = r20.a;
                if(s1 == null) {
                    return;
                }
                o o0 = new o(s1, this.getMenuId(), null, 36);
                T2.a a0 = f0.h(this);
                Z0 z00 = new Z0(1, this, y2.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 22);
                this.c.d(o0, a0, z00);
                return;
            }
            if(!q.b(s, "N10076") && !q.b(s, "N10077")) {
                return;
            }
            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
            melonLinkInfo0.a = r20.j;
            melonLinkInfo0.b = r20.k;
            MelonLinkExecutor.open(melonLinkInfo0);
            return;
        }
        super.onUserEvent(e0);
    }
}

