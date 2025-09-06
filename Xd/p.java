package xd;

import Ac.b0;
import H0.b;
import com.iloen.melon.types.StringIds;
import com.melon.ui.popup.context.more.ExtraProperties.ArtistInfo;
import com.melon.ui.popup.context.more.ExtraProperties;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import ie.H;
import ie.m;
import java.util.ArrayList;
import java.util.List;
import je.q;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ld.j;
import ne.a;
import oe.i;
import qb.d;
import we.n;
import x9.c;
import zd.Q;

public final class p extends i implements n {
    public int r;
    public final r w;

    public p(r r0, Continuation continuation0) {
        this.w = r0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new p(this.w, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((p)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Flow flow0;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.r) {
            case 0: {
                ArrayList arrayList0 = b.m(object0);
                r r0 = this.w;
                Q q0 = r0.d;
                if(q0 != null) {
                    for(Object object1: q0.c()) {
                        ExtraProperties extraProperties0 = ((MelonBottomSheetItem)object1).f;
                        ArtistInfo extraProperties$ArtistInfo0 = extraProperties0 instanceof ArtistInfo ? ((ArtistInfo)extraProperties0) : null;
                        if(extraProperties$ArtistInfo0 != null) {
                            arrayList0.add(new m(extraProperties$ArtistInfo0.a, extraProperties$ArtistInfo0.b));
                        }
                    }
                }
                ArrayList arrayList1 = new ArrayList(q.Q(10, arrayList0));
                for(Object object2: arrayList0) {
                    int v = r0.c;
                    boolean z = StringIds.a(((String)((m)object2).a), StringIds.e);
                    arrayList1.add(new f(v, ((String)((m)object2).a), ((String)((m)object2).b), null, false, z, false));
                }
                r0.updateUiState(new b0(24, arrayList1));
                c c0 = r0.a;
                int v1 = r0.c;
                c0.getClass();
                kotlin.jvm.internal.H h1 = new kotlin.jvm.internal.H();  // 初始化器: Ljava/lang/Object;-><init>()V
                h1.a = new ArrayList();
                for(Object object3: arrayList0) {
                    String s = (String)((m)object3).a;
                    String s1 = (String)((m)object3).b;
                    boolean z1 = s == null ? false : StringIds.a(s, StringIds.e);
                    List list0 = (List)h1.a;
                    if(s == null) {
                        s = "";
                    }
                    list0.add(new qb.a(v1, s, s1, null, false, z1, 2 == v1 && z1));
                }
                String s2 = je.p.q0(arrayList0, ",", null, null, new j(14), 30);
                if(v1 == 2) {
                    H8.q q1 = (H8.q)c0.c;
                    kotlin.jvm.internal.q.f("N10006", "code(...)");
                    flow0 = FlowKt.transformLatest(q1.g("N10006", s2, "fan"), new d(s2, null, h1, c0));
                }
                else {
                    flow0 = FlowKt.flow(new qb.f(s2, null, h1, c0));
                }
                Flow flow1 = FlowKt.catch(flow0, new M7.H(3, 7, null));
                this.r = 1;
                H h2 = flow1.collect(new xd.q(r0), this);
                if(h2 != a.a) {
                    h2 = h0;
                }
                return h2 == a0 ? a0 : h0;
            }
            case 1: {
                d5.n.D(object0);
                return h0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

