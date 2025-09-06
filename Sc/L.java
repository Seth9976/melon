package sc;

import A3.g;
import com.iloen.melon.utils.datastore.SmartPlaylistServerSyncPreferencesRepository;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import je.w;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oc.t0;
import oe.i;
import we.n;

public final class l extends i implements n {
    public final P0 B;
    public Object r;
    public int w;

    public l(P0 p00, Continuation continuation0) {
        this.B = p00;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l(this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((l)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        Object object1;
        P0 p00 = this.B;
        i1 i10 = p00.e;
        a a0 = a.a;
        H h0 = H.a;
        switch(this.w) {
            case 0: {
                d5.n.D(object0);
                ((S2)i10).g = null;
                p00.n.clear();
                p00.p = p00.p == null ? null : new g(0, 0);
                p00.m = -1L;
                k k0 = new k(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                this.w = 1;
                object1 = p00.e0(k0, this);
                if(object1 == a0) {
                    return a0;
                }
                goto label_18;
            }
            case 1: {
                d5.n.D(object0);
                object1 = object0;
            label_18:
                g1 g10 = (g1)object1;
                X0 x00 = new X0(p00.d, null);
                BuildersKt__Builders_commonKt.launch$default(p00.d.c, null, null, x00, 3, null);
                p00.d.e(null, "clear");
                p00.d.f(p00.m, "clear");
                p00.d.h(w.a);
                p00.d.i(t0.b, "clear");
                this.r = object1;
                this.w = 2;
                LogU.debug$default(((S2)i10).a, "clearQueueAndSavedUserData", null, false, 6, null);
                ((S2)i10).d.clear("clearQueueAndSavedUserData");
                H h1 = SmartPlaylistServerSyncPreferencesRepository.INSTANCE.clear(this);
                if(h1 != a0) {
                    h1 = h0;
                }
                if(h1 == a0) {
                    return a0;
                }
                p00.k = false;
                return h0;
            }
            case 2: {
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        d5.n.D(object0);
        p00.k = false;
        return h0;
    }
}

