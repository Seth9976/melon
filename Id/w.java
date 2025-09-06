package id;

import Kd.g;
import Na.d;
import Na.e;
import Na.f;
import androidx.lifecycle.f0;
import com.iloen.melon.constants.CType;
import com.iloen.melon.custom.L0;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.time.TimeUtils;
import com.melon.data.database.entity.MusicSearchHistoryEntity;
import com.melon.ui.K4;
import com.melon.ui.Q;
import com.melon.ui.g1;
import com.melon.ui.k1;
import d5.n;
import hd.U1;
import hd.i;
import i.n.i.b.a.s.e.Ga;
import i.n.i.b.a.s.e.M3;
import ie.H;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.c;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lid/w;", "Lcom/melon/ui/k1;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class w extends k1 {
    public final Ga a;
    public final Q b;
    public final CoroutineDispatcher c;
    public static final int d;

    public w(Ga ga0, Q q0, CoroutineDispatcher coroutineDispatcher0) {
        this.a = ga0;
        this.b = q0;
        this.c = coroutineDispatcher0;
        new LogU("MusicSearchHistoryViewModel").setCategory(Category.UI);
    }

    // 去混淆评级： 低(22)
    public static s c(f f0, K4 k40) {
        q.g(k40, "it");
        if(((List)((e)f0).a).isEmpty()) {
            return id.q.a;
        }
        ArrayList arrayList0 = new ArrayList(je.q.Q(10, ((Iterable)((e)f0).a)));
        for(Object object0: ((Iterable)((e)f0).a)) {
            LinkedHashMap linkedHashMap0 = new LinkedHashMap();
            linkedHashMap0.put("", "");
            boolean z = ((MusicSearchHistoryEntity)object0).isAdult();
            boolean z1 = ((MusicSearchHistoryEntity)object0).isService();
            q.f(CType.SONG, "SONG");
            g g0 = new g("", "", "", "", "", "", linkedHashMap0, z, z1, false, false, false, false, false, "", CType.SONG, true, false, false, false, "", null, false, false);
            long v = ((MusicSearchHistoryEntity)object0).getTimestamp();
            String s = TimeUtils.INSTANCE.long2Timestamp(v);
            q.g(s, "<set-?>");
            g0.T = s;
            arrayList0.add(g0);
        }
        return new r(arrayList0);
    }

    @Override  // com.melon.ui.k1
    public final Object onFetchStart(g1 g10, Continuation continuation0) {
        String s;
        L0 l01;
        Throwable throwable1;
        Object object1;
        u u0;
        if(continuation0 instanceof u) {
            u0 = (u)continuation0;
            int v = u0.E;
            if((v & 0x80000000) == 0) {
                u0 = new u(this, ((c)continuation0));
            }
            else {
                u0.E = v ^ 0x80000000;
            }
        }
        else {
            u0 = new u(this, ((c)continuation0));
        }
        Object object0 = u0.B;
        a a0 = a.a;
        switch(u0.E) {
            case 0: {
                n.D(object0);
                L0 l00 = this.getProgressUpdater();
                if(l00 == null) {
                    v v1 = new v(this, null);
                    u0.r = null;
                    u0.w = null;
                    u0.E = 1;
                    object0 = BuildersKt.withContext(Dispatchers.getIO(), v1, u0);
                    if(object0 == a0) {
                        return a0;
                    }
                    goto label_42;
                }
                else {
                    l00.a("MusicSearchHistoryViewModel true", true);
                    try {
                        v v2 = new v(this, null);
                        u0.r = l00;
                        u0.w = "MusicSearchHistoryViewModel";
                        u0.E = 2;
                        object1 = BuildersKt.withContext(Dispatchers.getIO(), v2, u0);
                    }
                    catch(Throwable throwable0) {
                        throwable1 = throwable0;
                        l01 = l00;
                        s = "MusicSearchHistoryViewModel";
                        Y.v(s, " false", l01, false);
                        throw throwable1;
                    }
                    if(object1 == a0) {
                        return a0;
                    }
                    object0 = object1;
                    l01 = l00;
                    s = "MusicSearchHistoryViewModel";
                    goto label_50;
                }
                break;
            }
            case 1: {
                n.D(object0);
            label_42:
                if(((f)object0) instanceof e) {
                    this.updateUiState(new i(((e)(((f)object0))), 7));
                    return H.a;
                }
                if(!(((f)object0) instanceof d)) {
                    throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                }
                break;
            }
            case 2: {
                try {
                    s = u0.w;
                    l01 = u0.r;
                    n.D(object0);
                label_50:
                    if(((f)object0) instanceof e) {
                        this.updateUiState(new i(((e)(((f)object0))), 7));
                    }
                    else if(!(((f)object0) instanceof d)) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
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
    public final void onUserEvent(Pc.e e0) {
        q.g(e0, "userEvent");
        if(e0 instanceof com.melon.ui.q) {
            T2.a a0 = f0.h(this);
            U1 u10 = new U1(1, this, w.class, "sendUiEvent", "sendUiEvent(Lcom/melon/ui/UiEvent;)V", 0, 7);
            this.b.d(((com.melon.ui.q)e0), a0, u10);
            return;
        }
        super.onUserEvent(e0);
    }
}

