package gd;

import Ac.m4;
import Cd.t;
import H8.q;
import Na.f;
import Pc.a;
import Pc.b;
import Pc.e;
import androidx.lifecycle.f0;
import com.iloen.melon.custom.L0;
import com.iloen.melon.net.v4x.common.UserInfoBase;
import com.iloen.melon.net.v6x.response.DjMelgunLikeMemberListRes.RESPONSE;
import com.iloen.melon.types.StringIds;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.ResponseBase;
import com.melon.ui.K4;
import com.melon.ui.Z0;
import com.melon.ui.a1;
import com.melon.ui.b1;
import com.melon.ui.c1;
import com.melon.ui.d1;
import com.melon.ui.f1;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import d5.n;
import e1.u;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import je.p;
import je.w;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import oe.c;
import va.e0;
import va.o;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lgd/u0;", "Lcom/melon/ui/k1;", "LPc/a;", "Lgd/e0;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class u0 extends k1 implements a {
    public final b a;
    public final ea.a b;
    public final q c;
    public final Za.b d;
    public final StringProviderImpl e;
    public final LogU f;
    public String g;
    public String h;
    public static final int i;

    public u0(ea.a a0, q q0, Za.b b0, StringProviderImpl stringProviderImpl0) {
        this.a = new b();
        this.b = a0;
        this.c = q0;
        this.d = b0;
        this.e = stringProviderImpl0;
        LogU logU0 = new LogU("MelonDJBrandLikePersonListViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.f = logU0;
        this.g = "";
        this.h = "";
    }

    @Override  // Pc.a
    public final boolean a() {
        return this.a.b;
    }

    public static m4 c(u0 u00, g1 g10, d1 d10) {
        boolean z;
        ArrayList arrayList0;
        String s;
        b b0 = u00.a;
        kotlin.jvm.internal.q.g(d10, "fetchResult");
        if(d10 instanceof Z0) {
            return new j0(((Z0)d10).a);
        }
        if(d10 instanceof a1) {
            u00.cancelFetch();
            return null;
        }
        if(d10 instanceof b1) {
            return new k0(((b1)d10).a);
        }
        if(!(d10 instanceof c1)) {
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        ResponseBase responseBase0 = ((c1)d10).a;
        if(responseBase0 instanceof RESPONSE) {
            s = ((RESPONSE)responseBase0).likeSumMCnt;
            kotlin.jvm.internal.q.f(s, "likeSumMCnt");
            arrayList0 = ((RESPONSE)responseBase0).userList;
            kotlin.jvm.internal.q.f(arrayList0, "userList");
            Boolean boolean0 = ((RESPONSE)responseBase0).hasMore;
            kotlin.jvm.internal.q.f(boolean0, "hasMore");
            z = boolean0.booleanValue();
        }
        else if(responseBase0 instanceof com.iloen.melon.net.v6x.response.DjBrandLikeMemberRes.RESPONSE) {
            s = ((com.iloen.melon.net.v6x.response.DjBrandLikeMemberRes.RESPONSE)responseBase0).likeSumMCnt;
            kotlin.jvm.internal.q.f(s, "likeSumMCnt");
            arrayList0 = ((com.iloen.melon.net.v6x.response.DjBrandLikeMemberRes.RESPONSE)responseBase0).userList;
            kotlin.jvm.internal.q.f(arrayList0, "userList");
            Boolean boolean1 = ((com.iloen.melon.net.v6x.response.DjBrandLikeMemberRes.RESPONSE)responseBase0).hasMore;
            kotlin.jvm.internal.q.f(boolean1, "hasMore");
            z = boolean1.booleanValue();
        }
        else {
            s = "";
            arrayList0 = w.a;
            z = false;
        }
        ArrayList arrayList1 = new ArrayList();
        String s1 = u.v(((e0)o.a()).j());
        if(g10 instanceof f1) {
            arrayList1.add(new d0(s));
        }
        ArrayList arrayList2 = new ArrayList(je.q.Q(10, arrayList0));
        for(Object object0: arrayList0) {
            arrayList2.add(Boolean.valueOf(arrayList1.add(new c0(((UserInfoBase)object0).memberkey, ((UserInfoBase)object0).memberDjIconType, ((UserInfoBase)object0).membernickname, ((UserInfoBase)object0).isOfficial, ((UserInfoBase)object0).myPageDesc, ((UserInfoBase)object0).ismyfriend, ((UserInfoBase)object0).mypageimg, s1))));
        }
        b0.d(arrayList1, z);
        return new l0(p.P0(b0.a));
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        Object object2;
        Object object1;
        L0 l00;
        String s;
        ne.a a0;
        Object object0;
        o0 o00;
        if(continuation0 instanceof o0) {
            o00 = (o0)continuation0;
            int v = o00.G;
            if((v & 0x80000000) == 0) {
                o00 = new o0(this, ((c)continuation0));
            }
            else {
                o00.G = v ^ 0x80000000;
            }
        }
        else {
            o00 = new o0(this, ((c)continuation0));
        }
        try {
            object0 = o00.D;
            a0 = ne.a.a;
            switch(o00.G) {
                case 0: {
                    goto label_31;
                }
                case 1: {
                    goto label_27;
                }
                case 2: {
                    goto label_23;
                }
                case 3: {
                    goto label_18;
                }
                case 4: {
                    goto label_13;
                }
            }
        }
        catch(Throwable throwable0) {
            Y.v(s, " false", l00, false);
            throw throwable0;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        try {
        label_13:
            s = o00.B;
            l00 = o00.w;
            g10 = o00.r;
            n.D(object0);
            goto label_90;
        label_18:
            s = o00.B;
            l00 = o00.w;
            g10 = o00.r;
            n.D(object0);
            goto label_90;
        }
        catch(Throwable throwable0) {
            Y.v(s, " false", l00, false);
            throw throwable0;
        }
    label_23:
        g10 = o00.r;
        n.D(object0);
        f f0 = (f)object0;
        goto label_57;
    label_27:
        g10 = o00.r;
        n.D(object0);
        f0 = (f)object0;
        goto label_57;
    label_31:
        n.D(object0);
        LogU.info$default(this.f, "onFetchStart() type: " + g10, null, false, 6, null);
        l00 = this.getProgressUpdater();
        b b0 = this.a;
        if(l00 == null) {
            if(g10 instanceof f1) {
                b0.c();
            }
            LogU.debug$default(this.f, "brandDJKey = " + this.g, null, false, 6, null);
            if(StringIds.a(this.g, StringIds.i)) {
                Deferred deferred0 = h7.u0.j(this, Dispatchers.getIO(), new p0(this, null), 2);
                o00.r = g10;
                o00.w = null;
                o00.B = null;
                o00.G = 1;
                object0 = deferred0.await(o00);
                if(object0 == a0) {
                    return a0;
                }
            }
            else {
                Deferred deferred1 = h7.u0.j(this, Dispatchers.getIO(), new q0(this, null), 2);
                o00.r = g10;
                o00.w = null;
                o00.B = null;
                o00.G = 2;
                object0 = deferred1.await(o00);
                if(object0 == a0) {
                    return a0;
                }
            }
            f0 = (f)object0;
        label_57:
            K4 k40 = this.handleDefaultHttpResponseResult(f0, new l(4, this, g10));
            if(k40 != null) {
                this.updateUiState(new t(k40, 20));
                return H.a;
            }
        }
        else {
            l00.a("MelonDJBrandLikePersonListViewModel true", true);
            try {
                if(g10 instanceof f1) {
                    b0.c();
                }
                LogU.debug$default(this.f, "brandDJKey = " + this.g, null, false, 6, null);
                if(StringIds.a(this.g, StringIds.i)) {
                    Deferred deferred2 = h7.u0.j(this, Dispatchers.getIO(), new p0(this, null), 2);
                    o00.r = g10;
                    o00.w = l00;
                    o00.B = "MelonDJBrandLikePersonListViewModel";
                    o00.G = 3;
                    object1 = deferred2.await(o00);
                    if(object1 != a0) {
                        s = "MelonDJBrandLikePersonListViewModel";
                        object0 = object1;
                        goto label_90;
                    }
                    return a0;
                }
                else {
                    goto label_76;
                }
                goto label_90;
            }
            catch(Throwable throwable0) {
                s = "MelonDJBrandLikePersonListViewModel";
                Y.v(s, " false", l00, false);
                throw throwable0;
            }
            try {
                s = "MelonDJBrandLikePersonListViewModel";
                object0 = object1;
                goto label_90;
            }
            catch(Throwable throwable0) {
                Y.v(s, " false", l00, false);
                throw throwable0;
            }
            try {
            label_76:
                Deferred deferred3 = h7.u0.j(this, Dispatchers.getIO(), new q0(this, null), 2);
                o00.r = g10;
                o00.w = l00;
                o00.B = "MelonDJBrandLikePersonListViewModel";
                o00.G = 4;
                object2 = deferred3.await(o00);
            }
            catch(Throwable throwable0) {
                s = "MelonDJBrandLikePersonListViewModel";
                Y.v(s, " false", l00, false);
                throw throwable0;
            }
            if(object2 == a0) {
                return a0;
            }
            s = "MelonDJBrandLikePersonListViewModel";
            object0 = object2;
            try {
            label_90:
                K4 k41 = this.handleDefaultHttpResponseResult(((f)object0), new l(4, this, g10));
                if(k41 != null) {
                    this.updateUiState(new t(k41, 20));
                }
            }
            catch(Throwable throwable0) {
                Y.v(s, " false", l00, false);
                throw throwable0;
            }
            Y.v(s, " false", l00, false);
        }
        return H.a;
    }

    @Override  // com.melon.ui.k1
    public final void onUserEvent(e e0) {
        kotlin.jvm.internal.q.g(e0, "userEvent");
        if(e0 instanceof n0) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getIO(), null, new r0(e0, this, null), 2, null);
            return;
        }
        if(e0 instanceof m0) {
            Navigator.openUserMain(((m0)e0).a);
            return;
        }
        super.onUserEvent(e0);
    }
}

