package G8;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.datastore.MigrationDataStoreKt;
import e.k;
import ie.H;
import k8.t;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import ne.a;
import oe.i;
import we.n;

public final class d extends i implements n {
    public int r;

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(2, continuation0);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((d)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                MelonAppBase.Companion.getClass();
                l2.i i0 = MigrationDataStoreKt.getMigrationDataStore(t.a().getContext());
                c c0 = new c(2, null);  // 初始化器: Loe/i;-><init>(ILkotlin/coroutines/Continuation;)V
                this.r = 1;
                return k.n(i0, c0, this) == a0 ? a0 : H.a;
            }
            case 1: {
                d5.n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

