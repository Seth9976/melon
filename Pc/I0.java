package pc;

import com.iloen.melon.MixUpPreference;
import com.iloen.melon.utils.log.LogU;
import d5.n;
import ie.H;
import java.io.IOException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.flow.FlowCollector;
import ne.a;
import oe.i;
import we.o;

public final class i0 extends i implements o {
    public FlowCollector B;
    public Throwable D;
    public final y0 E;
    public final int r;
    public int w;

    public i0(int v, Continuation continuation0, y0 y00) {
        this.r = v;
        this.E = y00;
        super(3, continuation0);
    }

    @Override  // we.o
    public final Object invoke(Object object0, Object object1, Object object2) {
        if(this.r != 0) {
            i0 i00 = new i0(1, ((Continuation)object2), this.E);
            i00.B = (FlowCollector)object0;
            i00.D = (Throwable)object1;
            return i00.invokeSuspend(H.a);
        }
        i0 i01 = new i0(0, ((Continuation)object2), this.E);
        i01.B = (FlowCollector)object0;
        i01.D = (Throwable)object1;
        return i01.invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        if(this.r != 0) {
            FlowCollector flowCollector0 = this.B;
            Throwable throwable0 = this.D;
            a a0 = a.a;
            switch(this.w) {
                case 0: {
                    n.D(object0);
                    if(!(throwable0 instanceof IOException)) {
                        throw throwable0;
                    }
                    LogU.error$default(this.E.f, "Error reading mixup info", throwable0, false, 4, null);
                    MixUpPreference mixUpPreference0 = MixUpPreference.getDefaultInstance();
                    q.f(mixUpPreference0, "getDefaultInstance(...)");
                    this.B = null;
                    this.D = null;
                    this.w = 1;
                    return flowCollector0.emit(mixUpPreference0, this) != a0 ? H.a : a0;
                }
                case 1: {
                    n.D(object0);
                    return H.a;
                }
                default: {
                    throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                }
            }
        }
        FlowCollector flowCollector1 = this.B;
        Throwable throwable1 = this.D;
        a a1 = a.a;
        switch(this.w) {
            case 0: {
                n.D(object0);
                if(!(throwable1 instanceof IOException)) {
                    throw throwable1;
                }
                LogU.error$default(this.E.f, "Error reading mixup info", throwable1, false, 4, null);
                MixUpPreference mixUpPreference1 = MixUpPreference.getDefaultInstance();
                q.f(mixUpPreference1, "getDefaultInstance(...)");
                this.B = null;
                this.D = null;
                this.w = 1;
                return flowCollector1.emit(mixUpPreference1, this) != a1 ? H.a : a1;
            }
            case 1: {
                n.D(object0);
                return H.a;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
    }
}

