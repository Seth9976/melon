package gd;

import H8.q;
import Pc.a;
import Pc.b;
import Pc.e;
import androidx.lifecycle.f0;
import bb.g;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.K4;
import com.melon.ui.g1;
import com.melon.ui.interfaces.StringProviderImpl;
import com.melon.ui.k1;
import d5.n;
import dd.z;
import ie.H;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import je.D;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import mb.k;
import oe.c;
import va.e0;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002¨\u0006\u0004"}, d2 = {"Lgd/r1;", "Lcom/melon/ui/k1;", "LPc/a;", "Lgd/f1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class r1 extends k1 implements a {
    public final b a;
    public final ea.b b;
    public final q c;
    public final StringProviderImpl d;
    public final k e;
    public final LogU f;
    public String g;
    public String h;
    public Job i;
    public String j;
    public static final int k;

    public r1(ea.b b0, q q0, StringProviderImpl stringProviderImpl0, k k0) {
        kotlin.jvm.internal.q.g(k0, "loginUseCase");
        super();
        this.a = new b();
        this.b = b0;
        this.c = q0;
        this.d = stringProviderImpl0;
        this.e = k0;
        LogU logU0 = new LogU("FetchViewModel");
        logU0.setCategory(Category.UI);
        logU0.setUseThreadInfo(true);
        this.f = logU0;
    }

    @Override  // Pc.a
    public final boolean a() {
        return this.a.b;
    }

    public static final Object c(r1 r10, Flow flow0, String s, Continuation continuation0) {
        Object object0 = flow0.collect(new q1(r10, s), continuation0);
        return object0 == ne.a.a ? object0 : H.a;
    }

    public static final void d(r1 r10, List list0) {
        K4 k40 = (K4)r10.getUiState().getValue();
        if(k40 instanceof i1) {
            int v = D.N(je.q.Q(10, list0));
            if(v < 16) {
                v = 16;
            }
            LinkedHashMap linkedHashMap0 = new LinkedHashMap(v);
            for(Object object0: list0) {
                linkedHashMap0.put(((g)object0).a, object0);
            }
            ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((i1)k40).a));
            for(Object object1: ((i1)k40).a) {
                f1 f10 = (f1)object1;
                g g0 = (g)linkedHashMap0.get(f10.a);
                if(g0 != null) {
                    f10 = new f1(f10.a, f10.b, f10.d, f10.c, g0.b);
                }
                arrayList0.add(f10);
            }
            r10.updateUiState(new z(new i1(arrayList0), 15));
        }
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        String s;
        L0 l01;
        l1 l10;
        if(continuation0 instanceof l1) {
            l10 = (l1)continuation0;
            int v = l10.E;
            if((v & 0x80000000) == 0) {
                l10 = new l1(this, ((c)continuation0));
            }
            else {
                l10.E = v ^ 0x80000000;
            }
        }
        else {
            l10 = new l1(this, ((c)continuation0));
        }
        Object object0 = l10.B;
        ne.a a0 = ne.a.a;
        k k0 = this.e;
        switch(l10.E) {
            case 0: {
                n.D(object0);
                L0 l00 = this.getProgressUpdater();
                b b0 = this.a;
                if(l00 == null) {
                    if(g10 instanceof com.melon.ui.f1) {
                        b0.c();
                    }
                    Job job0 = BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new n1(this, null), 2, null);
                    l10.r = null;
                    l10.w = null;
                    l10.E = 1;
                    if(job0.join(l10) == a0) {
                        return a0;
                    }
                    goto label_44;
                }
                else {
                    l00.a("FetchViewModel true", true);
                    try {
                        if(g10 instanceof com.melon.ui.f1) {
                            b0.c();
                        }
                        Job job1 = BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new n1(this, null), 2, null);
                        l10.r = l00;
                        l10.w = "FetchViewModel";
                        l10.E = 2;
                        if(job1.join(l10) == a0) {
                            return a0;
                        }
                    }
                    catch(Throwable throwable0) {
                        l01 = l00;
                        s = "FetchViewModel";
                        Y.v(s, " false", l01, false);
                        throw throwable0;
                    }
                    l01 = l00;
                    s = "FetchViewModel";
                    goto label_53;
                }
                break;
            }
            case 1: {
                n.D(object0);
            label_44:
                if(!((e0)k0).m()) {
                    Job job2 = this.i;
                    if(job2 != null) {
                        DefaultImpls.cancel$default(job2, null, 1, null);
                    }
                    this.i = BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new o1(this, null), 2, null);
                    return H.a;
                }
                break;
            }
            case 2: {
                try {
                    s = l10.w;
                    l01 = l10.r;
                    n.D(object0);
                label_53:
                    if(!((e0)k0).m()) {
                        Job job3 = this.i;
                        if(job3 != null) {
                            DefaultImpls.cancel$default(job3, null, 1, null);
                        }
                        this.i = BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new o1(this, null), 2, null);
                    }
                }
                catch(Throwable throwable0) {
                    Y.v(s, " false", l01, false);
                    throw throwable0;
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
        kotlin.jvm.internal.q.g(e0, "userEvent");
        if(e0 instanceof gd.k1) {
            Navigator.openArtistInfo(((gd.k1)e0).a.a);
            return;
        }
        if(e0 instanceof j1) {
            BuildersKt__Builders_commonKt.launch$default(f0.h(this), Dispatchers.getDefault(), null, new p1(e0, this, null), 2, null);
            return;
        }
        super.onUserEvent(e0);
    }
}

