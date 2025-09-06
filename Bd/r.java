package bd;

import androidx.compose.runtime.b0;
import com.iloen.melon.utils.time.TimeUtils;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import ne.a;
import oe.i;
import we.n;

public final class r extends i implements n {
    public final b0 B;
    public final long D;
    public int r;
    public Object w;

    public r(long v, b0 b00, Continuation continuation0) {
        this.B = b00;
        this.D = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new r(this.D, this.B, continuation0);
        continuation1.w = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((r)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        CoroutineScope coroutineScope0 = (CoroutineScope)this.w;
        a a0 = a.a;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                goto label_10;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        while(true) {
            Vb.i i0 = new Vb.i(10);
            String s = TimeUtils.INSTANCE.getRemainedTimeTextOrDefault(this.D, System.currentTimeMillis(), i0);
            this.B.setValue(s);
        label_10:
            if(!CoroutineScopeKt.isActive(coroutineScope0)) {
                break;
            }
            this.w = coroutineScope0;
            this.r = 1;
            if(DelayKt.delay(1000L, this) != a0) {
                continue;
            }
            return a0;
        }
        return H.a;
    }
}

