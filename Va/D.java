package va;

import com.google.android.gms.auth.blockstore.Blockstore;
import com.google.android.gms.tasks.Task;
import com.melon.data.newlogin.BlockStoreAccountRepository;
import e1.u;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScope;
import ma.b;
import ma.c;
import ne.a;
import oe.i;
import pc.t;
import we.n;

public final class d extends i implements n {
    public int r;
    public final BlockStoreAccountRepository w;

    public d(BlockStoreAccountRepository blockStoreAccountRepository0, Continuation continuation0) {
        this.w = blockStoreAccountRepository0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new d(this.w, continuation0);
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
                this.r = 1;
                CancellableContinuationImpl cancellableContinuationImpl0 = new CancellableContinuationImpl(u.D(this), 1);
                cancellableContinuationImpl0.initCancellability();
                Task task0 = Blockstore.getClient(this.w.a).retrieveBytes();
                q.f(task0, "retrieveBytes(...)");
                task0.addOnSuccessListener(new t(new b(cancellableContinuationImpl0, 1), 27));
                task0.addOnFailureListener(new c(cancellableContinuationImpl0, 4));
                task0.addOnCanceledListener(new c(cancellableContinuationImpl0, 5));
                Object object1 = cancellableContinuationImpl0.getResult();
                return object1 == a0 ? a0 : object1;
            }
            case 1: {
                d5.n.D(object0);
                return object0;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

