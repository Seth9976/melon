package W;

import androidx.compose.runtime.I0;
import i.n.i.b.a.s.e.M3;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobKt;
import ne.a;
import oe.i;
import we.n;

public final class j extends i implements n {
    public final l B;
    public int r;
    public final Job w;

    public j(Job job0, l l0, Continuation continuation0) {
        this.w = job0;
        this.B = l0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new j(this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((j)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return a.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        l l0;
        a a0;
        try {
            a0 = a.a;
            l0 = this.B;
            switch(this.r) {
                case 0: {
                    goto label_12;
                }
                case 1: {
                    goto label_10;
                }
                case 2: {
                    goto label_8;
                }
                case 3: {
                    goto label_6;
                }
                case 4: {
                    goto label_4;
                }
            }
        }
        catch(Throwable throwable0) {
            ((I0)l0.c).n(0.0f);
            throw throwable0;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
        try {
        label_4:
            d5.n.D(object0);
            goto label_27;
        label_6:
            d5.n.D(object0);
            goto label_24;
        label_8:
            d5.n.D(object0);
            throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
        }
        catch(Throwable throwable0) {
            ((I0)l0.c).n(0.0f);
            throw throwable0;
        }
    label_10:
        d5.n.D(object0);
        goto label_17;
    label_12:
        d5.n.D(object0);
        Job job0 = this.w;
        if(job0 == null) {
            try {
            label_17:
                ((I0)l0.c).n(1.0f);
                if(l0.a) {
                    while(true) {
                        this.r = 3;
                        if(DelayKt.delay(500L, this) == a0) {
                            break;
                        }
                    label_24:
                        ((I0)l0.c).n(0.0f);
                        this.r = 4;
                        if(DelayKt.delay(500L, this) == a0) {
                            break;
                        }
                    label_27:
                        ((I0)l0.c).n(1.0f);
                    }
                }
                else {
                    this.r = 2;
                    if(DelayKt.awaitCancellation(this) != a0) {
                        throw new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
                    }
                }
                return a0;
            }
            catch(Throwable throwable0) {
                ((I0)l0.c).n(0.0f);
                throw throwable0;
            }
        }
        else {
            this.r = 1;
            if(JobKt.cancelAndJoin(job0, this) != a0) {
                goto label_17;
            }
        }
        return a0;
    }
}

