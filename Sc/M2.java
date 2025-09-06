package sc;

import com.iloen.melon.net.mcp.response.PlaylistsSmartRes;
import com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import ie.o;
import ie.p;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import ne.a;
import oe.i;
import va.e;
import we.n;

public final class m2 extends i implements n {
    public String B;
    public int D;
    public int E;
    public Object G;
    public final S2 I;
    public final l1 M;
    public S2 r;
    public l1 w;

    public m2(S2 s20, l1 l10, Continuation continuation0) {
        this.I = s20;
        this.M = l10;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new m2(this.I, this.M, continuation0);
        continuation1.G = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((m2)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        o o0;
        S2 s23;
        l1 l13;
        Object object2;
        CoroutineScope coroutineScope0 = (CoroutineScope)this.G;
        a a0 = a.a;
        H h0 = H.a;
        S2 s20 = this.I;
        try {
            switch(this.E) {
                case 0: {
                    goto label_6;
                }
                case 1: {
                    goto label_22;
                }
                case 2: {
                    goto label_47;
                }
                case 3: {
                    goto label_67;
                }
            }
        }
        catch(Throwable throwable0) {
            goto label_74;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_6:
        d5.n.D(object0);
        l1 l10 = this.M;
        try {
            String s = s20.j.format(new Long(System.currentTimeMillis()));
            Flow flow0 = SmartPlaylistServerSyncPreferencesRepository.INSTANCE.getLastHistoryReqDate();
            this.G = null;
            this.r = s20;
            this.w = l10;
            this.B = s;
            this.D = 0;
            this.E = 1;
            Object object1 = FlowKt.firstOrNull(flow0, this);
            if(object1 == a0) {
                return a0;
            }
            l1 l11 = l10;
            int v = 0;
            S2 s21 = s20;
            goto label_31;
        label_22:
            v = this.D;
            String s1 = this.B;
            l1 l12 = this.w;
            S2 s22 = this.r;
            d5.n.D(object0);
            s21 = s22;
            l11 = l12;
            s = s1;
            object1 = object0;
        label_31:
            if(((String)object1) != null && s.compareTo(((String)object1)) <= 0) {
                LogU.debug$default(s21.a, "requestHistorySync skipped - not in time.", null, false, 6, null);
                goto label_71;
            label_47:
                int v1 = this.D;
                String s2 = this.B;
                l13 = this.w;
                s23 = this.r;
                d5.n.D(object0);
                s = s2;
                v = v1;
                object2 = object0;
            label_55:
                s23.getClass();
                S2.q(l13.a);
                if(((PlaylistsSmartRes)object2).success) {
                    q.d(s);
                    this.G = null;
                    this.r = null;
                    this.w = null;
                    this.B = null;
                    this.D = v;
                    this.E = 3;
                    if(SmartPlaylistServerSyncPreferencesRepository.INSTANCE.updateLastHistoryReqDate(s, this) == a0) {
                        return a0;
                    }
                }
            }
            else {
                LogU.debug$default(s21.a, "requestHistorySync execute - " + s, null, false, 6, null);
                l2 l20 = new l2(s21, l11, null);
                this.G = null;
                this.r = s21;
                this.w = l11;
                this.B = s;
                this.D = v;
                this.E = 2;
                object2 = BuildersKt.withContext(Dispatchers.getIO(), l20, this);
                if(object2 == a0) {
                    return a0;
                }
                l13 = l11;
                s23 = s21;
                goto label_55;
            }
            goto label_71;
        }
        catch(Throwable throwable0) {
            goto label_74;
        }
    label_67:
        PlaylistsSmartRes playlistsSmartRes0 = (PlaylistsSmartRes)this.B;
        String s3 = (String)this.w;
        CoroutineScope coroutineScope1 = (CoroutineScope)this.r;
        try {
            d5.n.D(object0);
        label_71:
            o0 = h0;
        }
        catch(Throwable throwable0) {
        label_74:
            o0 = d5.n.t(throwable0);
        }
        Throwable throwable1 = p.a(o0);
        if(throwable1 != null) {
            LogU.debug$default(s20.a, e.b("requestHistorySync failed - ", throwable1.getMessage()), null, false, 6, null);
        }
        return h0;
    }
}

